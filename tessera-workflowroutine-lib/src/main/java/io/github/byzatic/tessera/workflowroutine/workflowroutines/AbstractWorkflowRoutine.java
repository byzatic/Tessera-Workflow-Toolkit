package io.github.byzatic.tessera.workflowroutine.workflowroutines;

import com.github.zafarkhaja.semver.Version;
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
        this.serviceExtendsAbstractWorkflowRoutineClass = requireArgumentNonNull(
                serviceExtendsAbstractWorkflowRoutineClass,
                "Class<AbstractWorkflowRoutine> serviceExtendsAbstractWorkflowRoutineClass should be not null"
        );
        this.serviceApi = requireArgumentNonNull(
                serviceApi,
                "MCg3WorkflowRoutineApiInterface serviceApi should be not null"
        );
        this.healthFlagProxy = requireArgumentNonNull(
                healthFlagProxy,
                "HealthFlagProxy healthFlagProxy should be not null"
        );
        this.serviceVersion = requireArgumentNonNull(
                serviceVersion,
                "Version serviceVersion (workflowroutines version) should be not null"
        );
        this.serviceRequires = requireArgumentNonNull(
                serviceRequires,
                "Version serviceRequires (engine version) should be not null"
        );
        this.serviceDescription = requireArgumentNonNull(
                serviceDescription,
                "String serviceDescription (workflowroutines description) should be not null"
        );
        this.serviceProvider = requireArgumentNonNull(
                serviceProvider,
                "String serviceProvider (workflowroutines provider) should be not null"
        );
        this.serviceLicense = requireArgumentNonNull(
                serviceLicense,
                "String serviceLicense (workflowroutines license) should be not null"
        );
        this.terminationIntervalMinutes = requireArgumentNonNull(
                terminationIntervalMinutes,
                "Long terminationIntervalMinutes (termination interval, minutes) should be not null"
        );
    }

    @NotNull
    public MCg3WorkflowRoutineApiInterface getWorkflowRoutineApi() {
        return requireStateNonNull(serviceApi, "MCg3WorkflowRoutineApiInterface AbstractWorkflowRoutine not configured");
    }

    public void setHealthFlagState(HealthFlagState healthFlagState) {
        requireStateNonNull(healthFlagProxy, "HealthFlagProxy AbstractWorkflowRoutine not configured")
                .setHealthFlagState(requireArgumentNonNull(healthFlagState, "HealthFlagState should be not null"));
    }
    
    @NotNull
    @Override
    public String getName() {
        return requireStateNonNull(
                serviceExtendsAbstractWorkflowRoutineClass,
                "MCg3WorkflowRoutineApiInterface AbstractWorkflowRoutine not configured"
        ).getSimpleName();
    }

    @NotNull
    @Override
    public Version getWorkflowRoutineVersion() {
        return requireStateNonNull(serviceVersion, "MCg3WorkflowRoutineApiInterface AbstractWorkflowRoutine not configured");
    }

    @NotNull
    @Override
    public Version getWorkflowRoutineRequires() {
        return requireStateNonNull(serviceRequires, "MCg3WorkflowRoutineApiInterface AbstractWorkflowRoutine not configured");
    }

    @NotNull
    @Override
    public String getWorkflowRoutineDescription() {
        return requireStateNonNull(serviceDescription, "MCg3WorkflowRoutineApiInterface AbstractWorkflowRoutine not configured");
    }

    @NotNull
    @Override
    public String getWorkflowRoutineProvider() {
        return requireStateNonNull(serviceProvider, "MCg3WorkflowRoutineApiInterface AbstractWorkflowRoutine not configured");
    }

    @NotNull
    @Override
    public String getWorkflowRoutineLicense() {
        return requireStateNonNull(serviceLicense, "MCg3WorkflowRoutineApiInterface AbstractWorkflowRoutine not configured");
    }

    @NotNull
    @Override
    public Long getTerminationIntervalMinutes() {
        return requireStateNonNull(terminationIntervalMinutes, "MCg3WorkflowRoutineApiInterface AbstractWorkflowRoutine not configured");
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
