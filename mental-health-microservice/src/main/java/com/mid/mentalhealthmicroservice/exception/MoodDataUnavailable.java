package com.mid.mentalhealthmicroservice.exception;

public class MoodDataUnavailable extends Exception{
    private static final String MESSAGE = "To track mood insert mood first";

    public MoodDataUnavailable() {
        super(MESSAGE);
    }
}
