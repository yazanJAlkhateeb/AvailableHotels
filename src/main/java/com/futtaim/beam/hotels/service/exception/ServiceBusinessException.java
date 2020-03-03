package com.futtaim.beam.hotels.service.exception;

public class ServiceBusinessException extends ServiceGeneralException {

    public static String FAILED = "Failed";
    public static String SUCCESS = "Success";

    public ServiceBusinessException() {
    }

    public ServiceBusinessException(String message) {
        super(message);
    }

    public ServiceBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceBusinessException(Throwable cause) {
        super(cause);
    }

    public ServiceBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
