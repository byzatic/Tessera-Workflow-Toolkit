package io.github.byzatic.tessera.service.service;

import com.github.zafarkhaja.semver.Version;

public interface ServiceInterface extends Runnable {
    void run();

    void terminate() throws ServiceOperationIncompleteException;

    String getName();

    Version getServiceVersion();

    Version getServiceRequires();

    String getServiceDescription();

    String getServiceProvider();

    String getServiceLicense();

    Long getTerminationIntervalMinutes();
}
