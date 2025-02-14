/*
 * Copyright 2020-Present The Serverless Workflow Specification Authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.serverlessworkflow.diagram.model;

import io.serverlessworkflow.diagram.utils.WorkflowDiagramUtils;

public class ModelStateDef {
    private String name;
    private String type;
    private String noSpaceName;

    public ModelStateDef(String name, String type) {
        this.name = name;
        this.type = type;
        this.noSpaceName = name.replaceAll("\\s", "");
    }

    @Override
    public String toString() {
        StringBuffer retBuff = new StringBuffer();
        retBuff.append(WorkflowDiagramUtils.stateDef)
                .append(noSpaceName)
                .append(WorkflowDiagramUtils.stateAsName)
                .append("\"" + name + "\"")
                .append(WorkflowDiagramUtils.typeDefStart)
                .append(type)
                .append(WorkflowDiagramUtils.typeDefEnd);
        return retBuff.toString();
    }
}
