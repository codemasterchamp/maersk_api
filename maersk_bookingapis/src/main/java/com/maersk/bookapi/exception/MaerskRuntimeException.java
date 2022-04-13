package com.maersk.bookapi.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class MaerskRuntimeException extends RuntimeException{
    
    public MaerskRuntimeException(String message) {
		super(message);
	}
    
}
