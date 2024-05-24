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
    public ResponseEntity<Map<String, Set<String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.error("Validation failed");
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> fields = new ArrayList<>();
        Set<String> errors = new HashSet<>();
        /*TODO: return all error messages for a field instead
        ex.getBindingResult().getFieldErrors().forEach(
                error -> errorFields.put(error.getField(), (error.getDefaultMessage()))
        );*/
        Map<String, Set<String>> errorMap = new HashMap<>();
        for(FieldError fieldError: fieldErrors){
            fields.add(fieldError.getField());
        }
        for(String field: fields){
            for(FieldError error: fieldErrors){
                if(error.getField().equals(field)){
                    errors.add(error.getDefaultMessage());
                }
            }
            errorMap.put(field, errors);
        }

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
