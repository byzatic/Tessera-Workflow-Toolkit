package io.github.byzatic.tessera.workflowroutine.workflowroutines;


import io.github.byzatic.tessera.workflowroutine.api_engine.MCg3WorkflowRoutineApiInterface;
import io.github.byzatic.tessera.workflowroutine.workflowroutines.health.HealthFlagProxy;

public interface WorkflowRoutineFactoryInterface {
    WorkflowRoutineInterface create(MCg3WorkflowRoutineApiInterface api, HealthFlagProxy healthFlagProxy) throws WorkflowRoutineOperationIncompleteException;
}
