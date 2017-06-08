package com.canoo.dolphin.test.impl;

import com.canoo.dolphin.client.ClientConfiguration;
import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.impl.ClientContextImpl;
import com.canoo.dolphin.server.DolphinSession;
import com.canoo.dolphin.server.config.ConfigurationFileLoader;
import com.canoo.dolphin.server.config.RemotingConfiguration;
import com.canoo.dolphin.server.context.DefaultOpenDolphinFactory;
import com.canoo.dolphin.server.context.DolphinContext;
import com.canoo.dolphin.server.context.DolphinSessionProvider;
import com.canoo.dolphin.server.controller.ControllerRepository;
import com.canoo.dolphin.server.controller.ControllerValidationException;
import com.canoo.dolphin.server.impl.ClasspathScanner;
import com.canoo.dolphin.util.Assert;
import org.opendolphin.core.client.ClientModelStore;
import org.opendolphin.core.client.comm.AbstractClientConnector;
import org.opendolphin.core.comm.Command;
import org.opendolphin.util.Function;
import org.springframework.web.context.WebApplicationContext;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestConfiguration {

    private final DolphinTestContext dolphinTestContext;

    private final ClientContextImpl clientContext;

    public TestConfiguration(final WebApplicationContext context) throws ControllerValidationException, MalformedURLException, ExecutionException, InterruptedException {
        Assert.requireNonNull(context, "context");

        //Client
        final ExecutorService clientExecutor = Executors.newSingleThreadExecutor();
        final ClientConfiguration clientConfiguration = new ClientConfiguration(new URL("http://dummyURL"), clientExecutor);
        clientConfiguration.setConnectionTimeout(Long.MAX_VALUE);

        clientContext = new ClientContextImpl(clientConfiguration, new Function<ClientModelStore, AbstractClientConnector>() {
            @Override
            public AbstractClientConnector call(ClientModelStore clientModelStore) {
                return new DolphinTestClientConnector(clientModelStore, clientExecutor, new Function<List<Command>, List<Command>>(){

                    @Override
                    public List<Command> call(List<Command> commands) {
                        return sendToServer(commands);
                    }
                });
            }
        });


        //Server
        final ControllerRepository controllerRepository = new ControllerRepository(new ClasspathScanner());
        final TestSpringContainerManager containerManager = new TestSpringContainerManager(context);
        containerManager.init(context.getServletContext());
        final DolphinContextProviderMock dolphinContextProviderMock = new DolphinContextProviderMock();
        dolphinTestContext = new DolphinTestContext(new RemotingConfiguration(ConfigurationFileLoader.loadConfiguration()), dolphinContextProviderMock, containerManager, controllerRepository, new DefaultOpenDolphinFactory());
        dolphinContextProviderMock.setCurrentContext(dolphinTestContext);
    }

    private List<Command> sendToServer(final List<Command> commandList) {
        return dolphinTestContext.handle(commandList);
    }

    public DolphinTestContext getDolphinTestContext() {
        return dolphinTestContext;
    }

    private class DolphinContextProviderMock implements DolphinSessionProvider {

        DolphinContext currentContext;

        public void setCurrentContext(DolphinContext currentContext) {
            this.currentContext = currentContext;
        }

        @Override
        public DolphinSession getCurrentDolphinSession() {
            return currentContext.getDolphinSession();
        }
    }

    public ClientContext getClientContext() {
        return clientContext;
    }
}
