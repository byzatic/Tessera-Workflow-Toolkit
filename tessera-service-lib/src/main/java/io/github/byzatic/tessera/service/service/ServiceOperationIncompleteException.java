package io.github.byzatic.tessera.service.service;

public class ServiceOperationIncompleteException extends Exception {

    public ServiceOperationIncompleteException(String message) {
        super(message);
    }

    public ServiceOperationIncompleteException(Throwable cause) {
        super(cause);
    }

    public ServiceOperationIncompleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceOperationIncompleteException(Throwable cause, String message) {
        super(message, cause);
    }

}
