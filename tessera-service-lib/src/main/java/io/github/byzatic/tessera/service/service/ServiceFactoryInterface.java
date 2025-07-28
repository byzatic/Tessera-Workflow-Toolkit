package io.github.byzatic.tessera.service.service;

import io.github.byzatic.tessera.service.api_engine.MCg3ServiceApiInterface;
import io.github.byzatic.tessera.service.service.health.HealthFlagProxy;

public interface ServiceFactoryInterface {
    ServiceInterface create(MCg3ServiceApiInterface api, HealthFlagProxy healthFlagProxy) throws ServiceOperationIncompleteException;
}
