package com.databaserelationship.dbrelationonetomany.util.exception;

import com.databaserelationship.dbrelationonetomany.resources.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public final class ApiExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public final ResponseEntity<ErrorResponse> invalidRequestHandler(InvalidRequestException e) {
        return new ResponseEntity<>(
                new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.toString()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponse> beanValidationErrorHandler(MethodArgumentNotValidException e) {

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String field = ((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(field, errorMessage);
        });

        String message = errors.values().toString()
                .replace("[", "")
                .replace("]", "");

        return new ResponseEntity<>(
                new ErrorResponse(message, HttpStatus.BAD_REQUEST.toString()),
                HttpStatus.BAD_REQUEST
        );
    }
}