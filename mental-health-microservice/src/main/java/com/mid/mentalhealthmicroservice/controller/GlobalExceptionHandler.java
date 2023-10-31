package com.mid.mentalhealthmicroservice.controller;

import com.mid.mentalhealthmicroservice.exception.*;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ExerciseNotFound.class})
    public ResponseEntity<?> handleExerciseNotFound(){
        return new ResponseEntity<>(new ExerciseNotFound().getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> handleRuntimeException(){
        return new ResponseEntity<>(new CustomException("No exercise exists in this name").getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({UserNotFound.class})
    public ResponseEntity<?> handleUserNotFound(){
        return new ResponseEntity<>(new UserNotFound().getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MoodDataUnavailable.class})
    public ResponseEntity<?> handleUserMoodNotFound(){
        return new ResponseEntity<>(new MoodDataUnavailable().getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({WrongInput.class})
    public ResponseEntity<?> handleWrongInput(){
        return new ResponseEntity<>(new WrongInput().getMessage(), HttpStatus.BAD_REQUEST);
    }


}
