package io.github.byzatic.tessera.workflowroutine.workflowroutines;

import com.github.zafarkhaja.semver.Version;
import io.github.byzatic.tessera.storageapi.storageapi.StorageApiInterface;
import io.github.byzatic.tessera.workflowroutine.api_engine.MCg3WorkflowRoutineApiInterface;
import io.github.byzatic.tessera.workflowroutine.configuration.ConfigurationParameter;
import io.github.byzatic.tessera.workflowroutine.execution_context.ExecutionContextInterface;
import io.github.byzatic.tessera.workflowroutine.workflowroutines.health.HealthFlagProxy;
import io.github.byzatic.tessera.workflowroutine.workflowroutines.health.HealthFlagState;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

public class AbstractWorkflowRoutineTest {
    private static final MCg3WorkflowRoutineApiInterface API = new MCg3WorkflowRoutineApiInterface() {
        @Override
        public StorageApiInterface getStorageApi() {
            return null;
        }

        @Override
        public ExecutionContextInterface getExecutionContext() {
            return null;
        }

        @Override
        public List<ConfigurationParameter> getConfigurationParameters() {
            return Collections.emptyList();
        }
    };

    @Test
    public void validRoutineExposesConfiguredMetadata() {
        HealthFlagProxy health = HealthFlagProxy.newBuilder().build();
        TestWorkflowRoutine routine = new TestWorkflowRoutine(TestWorkflowRoutine.class, API, health);

        assertEquals(TestWorkflowRoutine.class.getSimpleName(), routine.getName());
        assertSame(API, routine.getWorkflowRoutineApi());
        assertEquals(Version.of(1, 2, 3), routine.getWorkflowRoutineVersion());
        assertEquals(Version.of(4, 5, 6), routine.getWorkflowRoutineRequires());
        assertEquals("description", routine.getWorkflowRoutineDescription());
        assertEquals("provider", routine.getWorkflowRoutineProvider());
        assertEquals("license", routine.getWorkflowRoutineLicense());
        assertEquals(Long.valueOf(7L), routine.getTerminationIntervalMinutes());

        routine.setHealthFlagState(HealthFlagState.COMPLETE);
        assertEquals(HealthFlagState.COMPLETE, health.getHealthFlagState());
    }

    @Test
    public void nullRoutineClassPreservesExceptionContract() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new TestWorkflowRoutine(null, API, HealthFlagProxy.newBuilder().build())
        );

        assertEquals(
                "Class<AbstractWorkflowRoutine> serviceExtendsAbstractWorkflowRoutineClass should be not null",
                exception.getMessage()
        );
    }

    @Test
    public void nullApiPreservesExceptionContract() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new TestWorkflowRoutine(
                        TestWorkflowRoutine.class,
                        null,
                        HealthFlagProxy.newBuilder().build()
                )
        );

        assertEquals("MCg3WorkflowRoutineApiInterface serviceApi should be not null", exception.getMessage());
    }

    @Test
    public void nullHealthStatePreservesExceptionContract() {
        TestWorkflowRoutine routine = new TestWorkflowRoutine(
                TestWorkflowRoutine.class,
                API,
                HealthFlagProxy.newBuilder().build()
        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> routine.setHealthFlagState(null)
        );

        assertEquals("HealthFlagState should be not null", exception.getMessage());
    }

    private static final class TestWorkflowRoutine extends AbstractWorkflowRoutine {
        private TestWorkflowRoutine(
                Class<? extends AbstractWorkflowRoutine> routineClass,
                MCg3WorkflowRoutineApiInterface api,
                HealthFlagProxy healthFlagProxy
        ) {
            super(
                    routineClass,
                    api,
                    healthFlagProxy,
                    Version.of(1, 2, 3),
                    Version.of(4, 5, 6),
                    "description",
                    "provider",
                    "license",
                    7L
            );
        }

        @Override
        public void run() {
        }

        @Override
        public void terminate() {
        }
    }
}
