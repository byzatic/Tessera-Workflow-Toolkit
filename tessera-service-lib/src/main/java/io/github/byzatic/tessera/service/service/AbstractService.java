package io.github.byzatic.tessera.service.service;

import com.github.zafarkhaja.semver.Version;
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
        this.serviceExtendsAbstractServiceClass = requireArgumentNonNull(
                serviceExtendsAbstractServiceClass,
                "Class<AbstractService> serviceExtendsAbstractServiceClass should be not null"
        );
        this.serviceApi = requireArgumentNonNull(serviceApi, "MCg3ServiceApiInterface serviceApi should be not null");
        this.healthFlagProxy = requireArgumentNonNull(
                healthFlagProxy,
                "HealthFlagProxy healthFlagProxy should be not null"
        );
        this.serviceVersion = requireArgumentNonNull(
                serviceVersion,
                "Version serviceVersion (service version) should be not null"
        );
        this.serviceRequires = requireArgumentNonNull(
                serviceRequires,
                "Version serviceRequires (engine version) should be not null"
        );
        this.serviceDescription = requireArgumentNonNull(
                serviceDescription,
                "String serviceDescription (service description) should be not null"
        );
        this.serviceProvider = requireArgumentNonNull(
                serviceProvider,
                "String serviceProvider (service provider) should be not null"
        );
        this.serviceLicense = requireArgumentNonNull(
                serviceLicense,
                "String serviceLicense (service license) should be not null"
        );
        this.terminationIntervalMinutes = requireArgumentNonNull(
                terminationIntervalMinutes,
                "Long terminationIntervalMinutes (termination interval, minutes) should be not null"
        );
    }

    @NotNull
    public MCg3ServiceApiInterface getServiceApi() {
        return requireStateNonNull(serviceApi, "MCg3ServiceApiInterface AbstractService not configured");
    }

    public void setHealthFlagState(HealthFlagState healthFlagState) {
        requireStateNonNull(healthFlagProxy, "HealthFlagProxy AbstractService not configured")
                .setHealthFlagState(requireArgumentNonNull(healthFlagState, "HealthFlagState should be not null"));
    }
    
    @NotNull
    @Override
    public String getName() {
        return requireStateNonNull(
                serviceExtendsAbstractServiceClass,
                "MCg3ServiceApiInterface AbstractService not configured"
        ).getSimpleName();
    }

    @NotNull
    @Override
    public Version getServiceVersion() {
        return requireStateNonNull(serviceVersion, "MCg3ServiceApiInterface AbstractService not configured");
    }

    @NotNull
    @Override
    public Version getServiceRequires() {
        return requireStateNonNull(serviceRequires, "MCg3ServiceApiInterface AbstractService not configured");
    }

    @NotNull
    @Override
    public String getServiceDescription() {
        return requireStateNonNull(serviceDescription, "MCg3ServiceApiInterface AbstractService not configured");
    }

    @NotNull
    @Override
    public String getServiceProvider() {
        return requireStateNonNull(serviceProvider, "MCg3ServiceApiInterface AbstractService not configured");
    }

    @NotNull
    @Override
    public String getServiceLicense() {
        return requireStateNonNull(serviceLicense, "MCg3ServiceApiInterface AbstractService not configured");
    }

    @NotNull
    @Override
    public Long getTerminationIntervalMinutes() {
        return requireStateNonNull(terminationIntervalMinutes, "MCg3ServiceApiInterface AbstractService not configured");
    }

    private static <T> T requireArgumentNonNull(T value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    private static <T> T requireStateNonNull(T value, String message) {
        if (value == null) {
            throw new IllegalStateException(message);
        }
        return value;
    }
}
