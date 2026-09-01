package io.github.byzatic.tessera.service;

import com.github.zafarkhaja.semver.Version;
import io.github.byzatic.tessera.service.api_engine.MCg3ServiceApiInterface;
import io.github.byzatic.tessera.service.configuration.ServiceConfigurationParameter;
import io.github.byzatic.tessera.service.execution_context.ExecutionContextInterface;
import io.github.byzatic.tessera.service.service.AbstractService;
import io.github.byzatic.tessera.service.service.health.HealthFlagProxy;
import io.github.byzatic.tessera.service.service.health.HealthFlagState;
import io.github.byzatic.tessera.storageapi.storageapi.StorageApiInterface;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

public class AbstractServiceTest {
    private static final MCg3ServiceApiInterface API = new MCg3ServiceApiInterface() {
        @Override
        public StorageApiInterface getStorageApi() {
            return null;
        }

        @Override
        public ExecutionContextInterface getExecutionContext() {
            return null;
        }

        @Override
        public List<ServiceConfigurationParameter> getServiceConfigurationParameters() {
            return Collections.emptyList();
        }
    };

    @Test
    public void validServiceExposesConfiguredMetadata() {
        HealthFlagProxy health = HealthFlagProxy.newBuilder().build();
        TestService service = new TestService(TestService.class, API, health);

        assertEquals(TestService.class.getSimpleName(), service.getName());
        assertSame(API, service.getServiceApi());
        assertEquals(Version.of(1, 2, 3), service.getServiceVersion());
        assertEquals(Version.of(4, 5, 6), service.getServiceRequires());
        assertEquals("description", service.getServiceDescription());
        assertEquals("provider", service.getServiceProvider());
        assertEquals("license", service.getServiceLicense());
        assertEquals(Long.valueOf(7L), service.getTerminationIntervalMinutes());

        service.setHealthFlagState(HealthFlagState.STOPPED);
        assertEquals(HealthFlagState.STOPPED, health.getHealthFlagState());
    }

    @Test
    public void nullServiceClassPreservesExceptionContract() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new TestService(null, API, HealthFlagProxy.newBuilder().build())
        );

        assertEquals(
                "Class<AbstractService> serviceExtendsAbstractServiceClass should be not null",
                exception.getMessage()
        );
    }

    @Test
    public void nullApiPreservesExceptionContract() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new TestService(TestService.class, null, HealthFlagProxy.newBuilder().build())
        );

        assertEquals("MCg3ServiceApiInterface serviceApi should be not null", exception.getMessage());
    }

    @Test
    public void nullHealthStatePreservesExceptionContract() {
        TestService service = new TestService(
                TestService.class,
                API,
                HealthFlagProxy.newBuilder().build()
        );

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.setHealthFlagState(null)
        );

        assertEquals("HealthFlagState should be not null", exception.getMessage());
    }

    private static final class TestService extends AbstractService {
        private TestService(
                Class<? extends AbstractService> serviceClass,
                MCg3ServiceApiInterface api,
                HealthFlagProxy healthFlagProxy
        ) {
            super(
                    serviceClass,
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
