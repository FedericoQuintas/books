package com.company.document.exception;

public class InvalidWatermarkCreationException extends RuntimeException {

	private static final long serialVersionUID = -5247951241342641497L;
	
	public InvalidWatermarkCreationException(){
		super("Invalid watermark creation");
	}
}
