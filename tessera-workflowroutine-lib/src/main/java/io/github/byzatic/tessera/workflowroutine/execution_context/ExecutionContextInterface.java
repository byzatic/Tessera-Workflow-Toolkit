package io.github.byzatic.tessera.workflowroutine.execution_context;

import io.github.byzatic.tessera.enginecommon.logging.MdcContextInterface;
import io.github.byzatic.tessera.storageapi.exceptions.MCg3ApiOperationIncompleteException;

import java.util.List;

public interface ExecutionContextInterface {
    PipelineDescriptionInterface getPipelineDescription() throws MCg3ApiOperationIncompleteException;
    NodeDescriptionInterface getNodeDescription() throws MCg3ApiOperationIncompleteException;
    List<StorageDescriptionInterface> getGlobalStoragesDescription() throws MCg3ApiOperationIncompleteException;
    PipelineExecutionInfoInterface getPipelineExecutionInfo() throws MCg3ApiOperationIncompleteException;
    MdcContextInterface getMdcContext();
}
