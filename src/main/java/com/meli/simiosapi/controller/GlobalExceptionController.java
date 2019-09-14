package com.meli.simiosapi.controller;

import com.meli.simiosapi.contracts.response.ErrorMessageResponse;
import com.meli.simiosapi.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessageResponse> handleConflictsException(Exception e) {
        ErrorMessageResponse errorMessage = new ErrorMessageResponse();
        errorMessage.setMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
