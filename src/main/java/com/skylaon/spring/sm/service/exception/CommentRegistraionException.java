package com.skylaon.spring.sm.service.exception;

public class CommentRegistraionException extends RuntimeException{

    private static final long serialVersionUID = 123456789L; // 임의의 값을 선택하여 사용

    public CommentRegistraionException(String message) {
    	super(message);
    }
    public CommentRegistraionException(String message, Throwable cause) {
    	super(message, cause);
    }
}
