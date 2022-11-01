package com.example.java.full.stack.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("could not found"+id);
    }

}
