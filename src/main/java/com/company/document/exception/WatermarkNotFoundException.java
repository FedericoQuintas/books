package com.company.document.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WatermarkNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8742946872951641599L;

	public WatermarkNotFoundException() {
		super("Watermark not ready");
	}
}
