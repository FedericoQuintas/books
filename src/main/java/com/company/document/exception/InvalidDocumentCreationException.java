package com.company.document.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidDocumentCreationException extends RuntimeException {

	private static final long serialVersionUID = 4637361489860893867L;

	public InvalidDocumentCreationException(){
		super("Invalid document creation");
	}
}
