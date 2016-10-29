package com.company.document.exception;

public class WatermarkNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8742946872951641599L;

	public WatermarkNotFoundException(){
		super("Watermark not ready");
	}
}
