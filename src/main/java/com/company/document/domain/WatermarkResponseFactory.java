package com.company.document.domain;

import com.company.document.response.WatermarkResponse;

public class WatermarkResponseFactory {

	public WatermarkResponse create(Watermark watermark, Long ticket) {
		return new WatermarkResponse(watermark, ticket);
	}

}
