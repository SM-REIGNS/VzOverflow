package com.verizon.lambda.exceptions;

public class QuestionNotFoundException extends RuntimeException {

	public QuestionNotFoundException(String msg) {
		super(msg);
	}
}
