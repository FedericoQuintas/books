package com.company.document.exception;

public class InvalidDocumentCreationException extends RuntimeException {

	private static final long serialVersionUID = 4637361489860893867L;

	public InvalidDocumentCreationException(){
		super("Invalid document creation");
	}
}
