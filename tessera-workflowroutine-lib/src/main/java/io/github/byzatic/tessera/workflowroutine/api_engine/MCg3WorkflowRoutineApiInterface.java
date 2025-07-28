package io.github.byzatic.tessera.workflowroutine.api_engine;

import io.github.byzatic.tessera.storageapi.storageapi.StorageApiInterface;
import io.github.byzatic.tessera.workflowroutine.configuration.ConfigurationParameter;
import io.github.byzatic.tessera.workflowroutine.execution_context.ExecutionContextInterface;

import java.util.List;

public interface MCg3WorkflowRoutineApiInterface {
    StorageApiInterface getStorageApi();
    ExecutionContextInterface getExecutionContext();
    List<ConfigurationParameter> getConfigurationParameters();
}
