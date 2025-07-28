package io.github.byzatic.tessera.workflowroutine.workflowroutines;

import com.github.zafarkhaja.semver.Version;
import io.github.byzatic.commons.ObjectsUtils;
import org.jetbrains.annotations.NotNull;
import io.github.byzatic.tessera.workflowroutine.api_engine.MCg3WorkflowRoutineApiInterface;
import io.github.byzatic.tessera.workflowroutine.workflowroutines.health.HealthFlagProxy;
import io.github.byzatic.tessera.workflowroutine.workflowroutines.health.HealthFlagState;

public abstract class AbstractWorkflowRoutine implements WorkflowRoutineInterface {
    Class<? extends AbstractWorkflowRoutine> serviceExtendsAbstractWorkflowRoutineClass = null;
    protected MCg3WorkflowRoutineApiInterface serviceApi = null;
    protected HealthFlagProxy healthFlagProxy = null;
    protected Version serviceVersion = null;
    protected Version serviceRequires = null;
    protected String serviceDescription = null;
    protected String serviceProvider = null;
    protected String serviceLicense = null;
    protected Long terminationIntervalMinutes = null;

    public AbstractWorkflowRoutine(Class<? extends AbstractWorkflowRoutine> serviceExtendsAbstractWorkflowRoutineClass, MCg3WorkflowRoutineApiInterface serviceApi, HealthFlagProxy healthFlagProxy, Version serviceVersion, Version serviceRequires, String serviceDescription, String serviceProvider, String serviceLicense, Long terminationIntervalMinutes) {
        ObjectsUtils.requireNonNull(serviceExtendsAbstractWorkflowRoutineClass, new IllegalArgumentException("Class<AbstractWorkflowRoutine> serviceExtendsAbstractWorkflowRoutineClass should be not null"));
        this.serviceApi = serviceApi;

        ObjectsUtils.requireNonNull(serviceApi, new IllegalArgumentException(MCg3WorkflowRoutineApiInterface.class.getSimpleName() + " serviceApi should be not null"));
        this.serviceApi = serviceApi;

        ObjectsUtils.requireNonNull(healthFlagProxy, new IllegalArgumentException(HealthFlagProxy.class.getSimpleName() + " healthFlagProxy should be not null"));
        this.healthFlagProxy = healthFlagProxy;

        ObjectsUtils.requireNonNull(serviceVersion, new IllegalArgumentException(Version.class.getSimpleName() + " serviceVersion (workflowroutines version) should be not null"));
        this.serviceVersion = serviceVersion;

        ObjectsUtils.requireNonNull(serviceRequires, new IllegalArgumentException(Version.class.getSimpleName() + " serviceRequires (engine version) should be not null"));
        this.serviceRequires = serviceRequires;

        ObjectsUtils.requireNonNull(serviceDescription, new IllegalArgumentException(String.class.getSimpleName() + " serviceDescription (workflowroutines description) should be not null"));
        this.serviceDescription = serviceDescription;

        ObjectsUtils.requireNonNull(serviceProvider, new IllegalArgumentException(String.class.getSimpleName() + " serviceProvider (workflowroutines provider) should be not null"));
        this.serviceProvider = serviceProvider;

        ObjectsUtils.requireNonNull(serviceLicense, new IllegalArgumentException(String.class.getSimpleName() + " serviceLicense (workflowroutines license) should be not null"));
        this.serviceLicense = serviceLicense;

        ObjectsUtils.requireNonNull(terminationIntervalMinutes, new IllegalArgumentException(Long.class.getSimpleName() + " terminationIntervalMinutes (termination interval, minutes) should be not null"));
        this.terminationIntervalMinutes = terminationIntervalMinutes;
    }

    @NotNull
    public MCg3WorkflowRoutineApiInterface getWorkflowRoutineApi() {
        ObjectsUtils.requireNonNull(serviceApi, new IllegalStateException(MCg3WorkflowRoutineApiInterface.class.getSimpleName() + " AbstractWorkflowRoutine not configured"));
        return serviceApi;
    }

    public void setHealthFlagState(HealthFlagState healthFlagState) {
        ObjectsUtils.requireNonNull(healthFlagProxy, new IllegalStateException(HealthFlagProxy.class.getSimpleName() + " AbstractWorkflowRoutine not configured"));
        ObjectsUtils.requireNonNull(healthFlagState, new IllegalArgumentException(HealthFlagState.class.getSimpleName() + " should be not null"));
        this.healthFlagProxy.setHealthFlagState(healthFlagState);
    }
    
    @NotNull
    @Override
    public String getName() {
        ObjectsUtils.requireNonNull(serviceApi, new IllegalStateException(MCg3WorkflowRoutineApiInterface.class.getSimpleName() + " AbstractWorkflowRoutine not configured"));
        return serviceExtendsAbstractWorkflowRoutineClass.getSimpleName();
    }

    @NotNull
    @Override
    public Version getWorkflowRoutineVersion() {
        ObjectsUtils.requireNonNull(this.serviceVersion, new IllegalStateException(MCg3WorkflowRoutineApiInterface.class.getSimpleName() + " AbstractWorkflowRoutine not configured"));
        return this.serviceVersion;
    }

    @NotNull
    @Override
    public Version getWorkflowRoutineRequires() {
        ObjectsUtils.requireNonNull(this.serviceRequires, new IllegalStateException(MCg3WorkflowRoutineApiInterface.class.getSimpleName() + " AbstractWorkflowRoutine not configured"));
        return this.serviceRequires;
    }

    @NotNull
    @Override
    public String getWorkflowRoutineDescription() {
        ObjectsUtils.requireNonNull(this.serviceDescription, new IllegalStateException(MCg3WorkflowRoutineApiInterface.class.getSimpleName() + " AbstractWorkflowRoutine not configured"));
        return this.serviceDescription;
    }

    @NotNull
    @Override
    public String getWorkflowRoutineProvider() {
        ObjectsUtils.requireNonNull(this.serviceProvider, new IllegalStateException(MCg3WorkflowRoutineApiInterface.class.getSimpleName() + " AbstractWorkflowRoutine not configured"));
        return this.serviceProvider;
    }

    @NotNull
    @Override
    public String getWorkflowRoutineLicense() {
        ObjectsUtils.requireNonNull(this.serviceLicense, new IllegalStateException(MCg3WorkflowRoutineApiInterface.class.getSimpleName() + " AbstractWorkflowRoutine not configured"));
        return this.serviceLicense;
    }

    @NotNull
    @Override
    public Long getTerminationIntervalMinutes() {
        ObjectsUtils.requireNonNull(this.terminationIntervalMinutes, new IllegalStateException(MCg3WorkflowRoutineApiInterface.class.getSimpleName() + " AbstractWorkflowRoutine not configured"));
        return this.terminationIntervalMinutes;
    }
}
