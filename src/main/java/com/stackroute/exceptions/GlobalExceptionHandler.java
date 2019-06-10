package com.stackroute.exceptions;

import com.stackroute.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> exception(UserAlreadyExistsException exception) {
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity exception1(UserNotFoundException exception1) {
        return new ResponseEntity<String>(exception1.getMessage(), HttpStatus.NOT_FOUND);
    }
}

