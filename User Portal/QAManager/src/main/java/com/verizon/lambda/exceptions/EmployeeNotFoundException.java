package com.verizon.lambda.exceptions;



public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String msg){
        super(msg);
    }
}
