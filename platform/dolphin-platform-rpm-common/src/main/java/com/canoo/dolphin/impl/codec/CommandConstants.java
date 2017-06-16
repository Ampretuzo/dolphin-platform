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
package com.canoo.dolphin.impl.codec;

public interface CommandConstants {

    String ID = "id";


    String VALUE_CHANGED_COMMAND_ID = "ValueChanged";

    String CREATE_PRESENTATION_MODEL_COMMAND_ID = "CreatePresentationModel";

    String PM_ID = "p";
    String PM_TYPE = "t";
    String PM_ATTRIBUTES = "a";

    String ATTRIBUTE_NAME =  "n";
    String ATTRIBUTE_ID =    "i";
    String ATTRIBUTE_VALUE = "v";
    String ATTRIBUTE_TAG =   "t";



    String CREATE_CONTROLLER_COMMAND_ID = "CreateController";
    String PARENT_CONTROLLER_ID = "p";
    String CONTROLLER_NAME = "n";

    String DESTROY_CONTROLLER_COMMAND_ID = "DestroyController";
    String CONTROLLER_ID = "c";

    String CALL_ACTION_COMMAND_ID = "CallAction";
    String ACTION_NAME = "a";
    String PARAMS = "p";
    String PARAM_NAME = "n";
    String PARAM_VALUE = "v";
}
