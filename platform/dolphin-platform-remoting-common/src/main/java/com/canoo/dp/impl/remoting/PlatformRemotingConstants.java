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
package com.canoo.dp.impl.remoting;

import org.opendolphin.RemotingConstants;

public interface PlatformRemotingConstants {

    String CREATE_CONTROLLER_COMMAND_NAME = RemotingConstants.DOLPHIN_PLATFORM_PREFIX + "registerController";

    String DESTROY_CONTROLLER_COMMAND_NAME = RemotingConstants.DOLPHIN_PLATFORM_PREFIX + "destroyController";

    String CALL_ACTION_COMMAND_NAME = RemotingConstants.DOLPHIN_PLATFORM_PREFIX + "callControllerAction";

    String CREATE_CONTEXT_COMMAND_NAME = RemotingConstants.DOLPHIN_PLATFORM_PREFIX + "initClientContext";

    String CLIENT_ID_HTTP_HEADER_NAME = RemotingConstants.DOLPHIN_PLATFORM_PREFIX + "dolphinClientId";

    String DESTROY_CONTEXT_COMMAND_NAME = RemotingConstants.DOLPHIN_PLATFORM_PREFIX + "disconnectClientContext";

    String DOLPHIN_BEAN = "@@@ DOLPHIN_BEAN @@@";

    String JAVA_CLASS = "@@@ JAVA_CLASS @@@";

    String LIST_SPLICE = "@DP:LS@";

    String CONTROLLER_ACTION_CALL_BEAN_NAME = "@@@ CONTROLLER_ACTION_CALL_BEAN @@@";
    String INTERNAL_ATTRIBUTES_BEAN_NAME = "@@@ HIGHLANDER_BEAN @@@";
}
