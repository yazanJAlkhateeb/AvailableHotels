package com.futtaim.beam.hotels.service.exception;

public class ServiceTechnicalException extends RuntimeException {

    public ServiceTechnicalException(String message) {
        super(message);
    }

    public ServiceTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

}
