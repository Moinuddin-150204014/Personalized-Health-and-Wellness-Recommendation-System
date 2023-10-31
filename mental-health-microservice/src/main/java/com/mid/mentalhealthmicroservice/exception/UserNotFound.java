package com.mid.mentalhealthmicroservice.exception;

public class UserNotFound extends Exception{
    private static final String MESSAGE = "Complete the survey for this action!";

    public UserNotFound() {
        super(MESSAGE);
    }

    public UserNotFound(String message) {
        super(message);
    }
}
