package com.example.SingleTaskManagement.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.error("Validation failed");
        Map<String, List<String>> fieldErrorMessages = new HashMap<>();
        //TODO: return all error messages for a field instead
        ex.getBindingResult().getFieldErrors().forEach(error ->
                {
                    String field = error.getField();
                    String message = error.getDefaultMessage();
                    if(!fieldErrorMessages.containsKey(field)){
                        fieldErrorMessages.put(field, new ArrayList<>());
                    }
                    fieldErrorMessages.get(field).add(message);
                }
        );
        return new ResponseEntity<>(fieldErrorMessages, HttpStatus.BAD_REQUEST);
    }
}
