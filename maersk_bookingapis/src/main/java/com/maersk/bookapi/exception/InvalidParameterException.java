package com.maersk.bookapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidParameterException extends RuntimeException{
    
    public InvalidParameterException() {
		super(String.format("Invalid request param"));
	}
    
}
