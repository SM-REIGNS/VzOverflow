package com.verizon.lambda.exceptions;


public class UserDetailsNotFoundException extends RuntimeException {

    public UserDetailsNotFoundException(String msg){
        super(msg);
    }
}
