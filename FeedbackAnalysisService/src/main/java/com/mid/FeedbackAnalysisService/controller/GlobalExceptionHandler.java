package com.mid.FeedbackAnalysisService.controller;

import com.mid.FeedbackAnalysisService.exception.NotFoundCustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundCustomException.class)
    public ResponseEntity<String> handleNotFoundCustomException(NotFoundCustomException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
