package io.github.byzatic.tessera.workflowroutine.execution_context;

import java.util.List;

public interface StorageDescriptionInterface {
    String getIdName();
    String getDescription();
    List<StorageOptionInterface> getOptions();
}
