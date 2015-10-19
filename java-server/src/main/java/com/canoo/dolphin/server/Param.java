/*
 * Copyright 2015 Canoo Engineering AG.
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
package com.canoo.dolphin.server;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>
 * When defining a controller method by using {@link com.canoo.dolphin.server.DolphinAction} the
 * Dolphin Platform supports methods parameters. The parameters can be set on the client when calling
 * the action method. To define parameters o the server controller method each paramter must be annotated
 * with the {@link com.canoo.dolphin.server.Param} annotation.
 *</p>
 * <p>
 * Example:
 *
 * <blockquote>
 * <pre>
 *     {@literal @}DolphinController("my-controller")
 *     public class MyController {
 *
 *         {@literal @}DolphinAction("my-action")
 *         private void showById(@Param("id") id) { . . . };
 *     }
 * </pre>
 * </blockquote>
 *</p>
 */
@Documented
@Retention(RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Param {

    String value() default "";

}
