package com.company.document.response;

import com.company.document.domain.Watermark;

public class WatermarkResponse {

	private Long ticket;
	private Watermark watermark;

	public WatermarkResponse(Watermark watermark, Long ticket) {
		this.watermark = watermark;
		this.ticket = ticket;
	}

	public Long getTicket() {
		return this.ticket;
	}

	public Watermark getWatermark() {
		return this.watermark;
	}

}
