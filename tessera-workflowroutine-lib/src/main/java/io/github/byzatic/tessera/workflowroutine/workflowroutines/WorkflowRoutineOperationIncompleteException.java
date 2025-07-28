package io.github.byzatic.tessera.workflowroutine.workflowroutines;

public class WorkflowRoutineOperationIncompleteException extends Exception {

    public WorkflowRoutineOperationIncompleteException(String message) {
        super(message);
    }

    public WorkflowRoutineOperationIncompleteException(Throwable cause) {
        super(cause);
    }

    public WorkflowRoutineOperationIncompleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkflowRoutineOperationIncompleteException(Throwable cause, String message) {
        super(message, cause);
    }

}
