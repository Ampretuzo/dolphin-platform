/*
 * Copyright 2015-2017 Canoo Engineering AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opendolphin.core.comm

import org.opendolphin.LogConfig
import org.opendolphin.core.client.ClientDolphin
import org.opendolphin.core.server.DefaultServerDolphin
import spock.lang.Ignore
import spock.lang.Specification

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.logging.Level

class ClientConnectorPushTests extends Specification {

    volatile TestInMemoryConfig app
    DefaultServerDolphin serverDolphin
    ClientDolphin clientDolphin

    protected void setup() {
        app = new TestInMemoryConfig()
        serverDolphin = app.serverDolphin
        clientDolphin = app.clientDolphin
        LogConfig.logOnLevel(Level.OFF);
    }

    // make sure the tests only count as ok if context.assertionsDone() has been reached
    protected void cleanup() {
        clientDolphin.sync { app.assertionsDone() }
        assert app.done.await(4, TimeUnit.SECONDS) // max waiting time for async operations to have finished
        clientDolphin.stopPushListening()
    }

    void "listening can be started and stopped"() {
        when:
        clientDolphin.startPushListening(new NamedCommand("POLL"), new SignalCommand("INTERRUPT"))
        then:
        clientDolphin.stopPushListening()
    }

    @Ignore
    void "core push: server-side commands are immediately processed when listening"() {
        given:
        CountDownLatch pushWasCalled = new CountDownLatch(1)
        serverDolphin.action(PlatformConstants.POLL_EVENT_BUS_COMMAND_NAME) { cmd, resp ->
            pushWasCalled.countDown()
        }
        when:
        clientDolphin.startPushListening(new NamedCommand("POLL"), new SignalCommand("INTERRUPT"))
        then:
        pushWasCalled.await(1, TimeUnit.SECONDS)
    }
}
