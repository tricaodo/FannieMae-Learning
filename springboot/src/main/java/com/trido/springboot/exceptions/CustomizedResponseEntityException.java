package com.trido.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomizedResponseEntityException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> userNotFoundException(UserNotFoundException exception){
        ExceptionResponse userNotFoundException = new ExceptionResponse(
                exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(userNotFoundException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> genericException(Exception exception){
        ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
