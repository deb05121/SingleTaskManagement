package com.example.SingleTaskManagement.exception;

public class TaskNotFindException extends RuntimeException{
    public TaskNotFindException(String message) {
        super(message);
    }
}
