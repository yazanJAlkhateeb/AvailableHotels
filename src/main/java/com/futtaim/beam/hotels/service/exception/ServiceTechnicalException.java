package com.futtaim.beam.hotels.service.exception;

public class ServiceTechnicalException extends ServiceGeneralException {

    public static String ERROR = "Error";

    public ServiceTechnicalException() {
    }

    public ServiceTechnicalException(String message) {
        super(message);
    }

    public ServiceTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceTechnicalException(Throwable cause) {
        super(cause);
    }

    public ServiceTechnicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
