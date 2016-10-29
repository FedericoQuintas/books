package com.company.document.service;

import com.company.document.domain.Watermark;
import com.company.document.domain.WatermarkFactory;
import com.company.document.domain.WatermarkResponseFactory;
import com.company.document.response.WatermarkResponse;

public class WatermarkServiceImpl implements WatermarkService {

	private WatermarkResponseFactory watermarkResponseFactory;
	private WatermarkFactory watermarkFactory;

	public WatermarkServiceImpl(WatermarkFactory watermarkFactory,
			WatermarkResponseFactory watermarkResponseFactory) {
		this.watermarkFactory = watermarkFactory;
		this.watermarkResponseFactory = watermarkResponseFactory;
	}

	@Override
	public WatermarkResponse create(Long documentId, String title,
			String content, String authorName, String topic) {

		Watermark watermark = watermarkFactory.create(title, content,
				authorName, topic);

		Long ticket = documentId;

		return watermarkResponseFactory.create(watermark, ticket);
	}

}
