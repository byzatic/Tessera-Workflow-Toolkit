package io.github.byzatic.tessera.service.execution_context;

import io.github.byzatic.tessera.enginecommon.logging.MdcContextInterface;

public interface ExecutionContextInterface {
    MdcContextInterface getMdcContext();
}
