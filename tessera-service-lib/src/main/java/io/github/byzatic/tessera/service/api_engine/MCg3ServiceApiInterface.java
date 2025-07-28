package io.github.byzatic.tessera.service.api_engine;


import io.github.byzatic.tessera.storageapi.storageapi.StorageApiInterface;
import io.github.byzatic.tessera.service.configuration.ServiceConfigurationParameter;
import io.github.byzatic.tessera.service.execution_context.ExecutionContextInterface;

import java.util.List;

public interface MCg3ServiceApiInterface {
    StorageApiInterface getStorageApi();
    ExecutionContextInterface getExecutionContext();
    List<ServiceConfigurationParameter> getServiceConfigurationParameters();
}
