package com.skylaon.spring.sm.service.exception;

public class CustomRegistrationException extends RuntimeException {

    private static final long serialVersionUID = 123456789L; // 임의의 값을 선택하여 사용

    public CustomRegistrationException(String message) {
        super(message);
    }

    public CustomRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}