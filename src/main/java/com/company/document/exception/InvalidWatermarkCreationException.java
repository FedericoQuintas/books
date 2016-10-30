package com.company.document.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidWatermarkCreationException extends RuntimeException {

	private static final long serialVersionUID = -5247951241342641497L;
	
	public InvalidWatermarkCreationException(){
		super("Invalid watermark creation");
	}
}
