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
package io.serverlessworkflow.diagram.utils;

import io.serverlessworkflow.api.Workflow;
import io.serverlessworkflow.api.interfaces.State;
import io.serverlessworkflow.api.states.DefaultState;

import java.util.List;
import java.util.stream.Collectors;

public class WorkflowDiagramUtils {
    public static final String versionSeparator = " v";
    public static final String wfStart = "wfstart";
    public static final String wfEnd = "wfend";
    public static final String startEnd = "[*]";
    public static final String connection = " --> ";
    public static final String description = " : ";
    public static final String title = "title ";
    public static final String footer = "center footer Serverless Workflow Specification - serverlessworkflow.io";
    public static final String legendStart = new StringBuffer().append("legend top center").append(System.lineSeparator()).toString();
    public static final String legendEnd = new StringBuffer().append(System.lineSeparator()).append("endlegend").toString();
    public static final String stateDef = "state ";
    public static final String stateAsName = " as ";
    public static final String typeDefStart = " << ";
    public static final String typeDefEnd = " >> ";


    public static State getWorkflowStartState(Workflow workflow) {
        return workflow.getStates().stream()
                .filter(ws -> ws.getName().equals(workflow.getStart().getStateName()))
                .findFirst().get();
    }

    public static List<State> getStatesByType(Workflow workflow, DefaultState.Type type) {
        return workflow.getStates().stream()
                .filter(ws -> ws.getType() == type)
                .collect(Collectors.toList());
    }

    public static List<State> getWorkflowEndStates(Workflow workflow) {
        return workflow.getStates().stream()
                .filter(ws -> ws.getEnd() != null)
                .collect(Collectors.toList());
    }
}
