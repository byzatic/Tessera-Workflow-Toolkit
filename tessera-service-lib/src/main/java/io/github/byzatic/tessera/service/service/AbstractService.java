package io.github.byzatic.tessera.service.service;

import com.github.zafarkhaja.semver.Version;
import io.github.byzatic.commons.ObjectsUtils;
import org.jetbrains.annotations.NotNull;
import io.github.byzatic.tessera.service.api_engine.MCg3ServiceApiInterface;
import io.github.byzatic.tessera.service.service.health.HealthFlagProxy;
import io.github.byzatic.tessera.service.service.health.HealthFlagState;

public abstract class AbstractService implements ServiceInterface {
    Class<? extends AbstractService> serviceExtendsAbstractServiceClass = null;
    protected MCg3ServiceApiInterface serviceApi = null;
    protected HealthFlagProxy healthFlagProxy = null;
    protected Version serviceVersion = null;
    protected Version serviceRequires = null;
    protected String serviceDescription = null;
    protected String serviceProvider = null;
    protected String serviceLicense = null;
    protected Long terminationIntervalMinutes = null;

    public AbstractService(Class<? extends AbstractService> serviceExtendsAbstractServiceClass, MCg3ServiceApiInterface serviceApi, HealthFlagProxy healthFlagProxy, Version serviceVersion, Version serviceRequires, String serviceDescription, String serviceProvider, String serviceLicense, Long terminationIntervalMinutes) {
        ObjectsUtils.requireNonNull(serviceExtendsAbstractServiceClass, new IllegalArgumentException("Class<AbstractService> serviceExtendsAbstractServiceClass should be not null"));
        this.serviceApi = serviceApi;

        ObjectsUtils.requireNonNull(serviceApi, new IllegalArgumentException(MCg3ServiceApiInterface.class.getSimpleName() + " serviceApi should be not null"));
        this.serviceApi = serviceApi;

        ObjectsUtils.requireNonNull(healthFlagProxy, new IllegalArgumentException(HealthFlagProxy.class.getSimpleName() + " healthFlagProxy should be not null"));
        this.healthFlagProxy = healthFlagProxy;

        ObjectsUtils.requireNonNull(serviceVersion, new IllegalArgumentException(Version.class.getSimpleName() + " serviceVersion (service version) should be not null"));
        this.serviceVersion = serviceVersion;

        ObjectsUtils.requireNonNull(serviceRequires, new IllegalArgumentException(Version.class.getSimpleName() + " serviceRequires (engine version) should be not null"));
        this.serviceRequires = serviceRequires;

        ObjectsUtils.requireNonNull(serviceDescription, new IllegalArgumentException(String.class.getSimpleName() + " serviceDescription (service description) should be not null"));
        this.serviceDescription = serviceDescription;

        ObjectsUtils.requireNonNull(serviceProvider, new IllegalArgumentException(String.class.getSimpleName() + " serviceProvider (service provider) should be not null"));
        this.serviceProvider = serviceProvider;

        ObjectsUtils.requireNonNull(serviceLicense, new IllegalArgumentException(String.class.getSimpleName() + " serviceLicense (service license) should be not null"));
        this.serviceLicense = serviceLicense;

        ObjectsUtils.requireNonNull(terminationIntervalMinutes, new IllegalArgumentException(Long.class.getSimpleName() + " terminationIntervalMinutes (termination interval, minutes) should be not null"));
        this.terminationIntervalMinutes = terminationIntervalMinutes;
    }

    @NotNull
    public MCg3ServiceApiInterface getServiceApi() {
        ObjectsUtils.requireNonNull(serviceApi, new IllegalStateException(MCg3ServiceApiInterface.class.getSimpleName() + " AbstractService not configured"));
        return serviceApi;
    }

    public void setHealthFlagState(HealthFlagState healthFlagState) {
        ObjectsUtils.requireNonNull(healthFlagProxy, new IllegalStateException(HealthFlagProxy.class.getSimpleName() + " AbstractService not configured"));
        ObjectsUtils.requireNonNull(healthFlagState, new IllegalArgumentException(HealthFlagState.class.getSimpleName() + " should be not null"));
        this.healthFlagProxy.setHealthFlagState(healthFlagState);
    }
    
    @NotNull
    @Override
    public String getName() {
        ObjectsUtils.requireNonNull(serviceApi, new IllegalStateException(MCg3ServiceApiInterface.class.getSimpleName() + " AbstractService not configured"));
        return serviceExtendsAbstractServiceClass.getSimpleName();
    }

    @NotNull
    @Override
    public Version getServiceVersion() {
        ObjectsUtils.requireNonNull(this.serviceVersion, new IllegalStateException(MCg3ServiceApiInterface.class.getSimpleName() + " AbstractService not configured"));
        return this.serviceVersion;
    }

    @NotNull
    @Override
    public Version getServiceRequires() {
        ObjectsUtils.requireNonNull(this.serviceRequires, new IllegalStateException(MCg3ServiceApiInterface.class.getSimpleName() + " AbstractService not configured"));
        return this.serviceRequires;
    }

    @NotNull
    @Override
    public String getServiceDescription() {
        ObjectsUtils.requireNonNull(this.serviceDescription, new IllegalStateException(MCg3ServiceApiInterface.class.getSimpleName() + " AbstractService not configured"));
        return this.serviceDescription;
    }

    @NotNull
    @Override
    public String getServiceProvider() {
        ObjectsUtils.requireNonNull(this.serviceProvider, new IllegalStateException(MCg3ServiceApiInterface.class.getSimpleName() + " AbstractService not configured"));
        return this.serviceProvider;
    }

    @NotNull
    @Override
    public String getServiceLicense() {
        ObjectsUtils.requireNonNull(this.serviceLicense, new IllegalStateException(MCg3ServiceApiInterface.class.getSimpleName() + " AbstractService not configured"));
        return this.serviceLicense;
    }

    @NotNull
    @Override
    public Long getTerminationIntervalMinutes() {
        ObjectsUtils.requireNonNull(this.terminationIntervalMinutes, new IllegalStateException(MCg3ServiceApiInterface.class.getSimpleName() + " AbstractService not configured"));
        return this.terminationIntervalMinutes;
    }
}
