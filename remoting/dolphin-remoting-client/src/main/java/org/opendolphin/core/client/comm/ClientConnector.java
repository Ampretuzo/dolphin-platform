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
package org.opendolphin.core.client.comm;

import org.opendolphin.core.comm.Command;
import org.opendolphin.core.comm.NamedCommand;
import org.opendolphin.core.comm.SignalCommand;

public interface ClientConnector {

    void send(Command command, OnFinishedHandler callback);

    void send(Command command);

    void setPushListener(NamedCommand pushListener);

    void setReleaseCommand(SignalCommand releaseCommand);

    void setPushEnabled(boolean pushEnabled);

    boolean isPushEnabled();

    void listen();

    //void setExecutor(Executor executor);
}
