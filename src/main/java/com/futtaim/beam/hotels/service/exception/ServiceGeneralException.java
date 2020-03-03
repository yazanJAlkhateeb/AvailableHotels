package com.futtaim.beam.hotels.service.exception;

public class ServiceGeneralException extends RuntimeException {

    public ServiceGeneralException() {
    }

    public ServiceGeneralException(String message) {
        super(message);
    }

    public ServiceGeneralException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceGeneralException(Throwable cause) {
        super(cause);
    }

    public ServiceGeneralException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
