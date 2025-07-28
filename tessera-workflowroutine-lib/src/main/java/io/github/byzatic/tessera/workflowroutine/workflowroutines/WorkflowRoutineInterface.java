package io.github.byzatic.tessera.workflowroutine.workflowroutines;

import com.github.zafarkhaja.semver.Version;

public interface WorkflowRoutineInterface extends Runnable {
    void run();

    void terminate() throws WorkflowRoutineOperationIncompleteException;

    String getName();

    Version getWorkflowRoutineVersion();

    Version getWorkflowRoutineRequires();

    String getWorkflowRoutineDescription();

    String getWorkflowRoutineProvider();

    String getWorkflowRoutineLicense();

    Long getTerminationIntervalMinutes();
}
