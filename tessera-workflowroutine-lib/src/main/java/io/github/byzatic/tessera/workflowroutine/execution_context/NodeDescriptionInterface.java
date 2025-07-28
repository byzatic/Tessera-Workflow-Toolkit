package io.github.byzatic.tessera.workflowroutine.execution_context;

import io.github.byzatic.tessera.storageapi.exceptions.MCg3ApiOperationIncompleteException;

import java.util.List;

public interface NodeDescriptionInterface {
    String getName();
    String getId();
    List<StorageDescriptionInterface> getNodeStorages();
    List<GraphPathInterface> getRootPaths() throws MCg3ApiOperationIncompleteException;
}
