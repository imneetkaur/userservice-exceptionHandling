package com.stackroute.exceptions;

public class UserAlreadyExistsException extends Exception {
    String message;

    public UserAlreadyExistsException(String message){
        super(message);
        this.message=message;
    }
    public UserAlreadyExistsException(){}
}
