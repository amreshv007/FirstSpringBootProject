package com.example.springboot.exceptionHandler;

public class ProjectException extends Exception {

    public ProjectException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
