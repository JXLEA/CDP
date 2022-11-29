package com.jxlea.application.exception;

public class NoSubscriptionForCardException extends RuntimeException {

    public NoSubscriptionForCardException(String message, Throwable exception) {
        super(message, exception);
    }

    public NoSubscriptionForCardException(String message) {
        super(message);
    }
}
