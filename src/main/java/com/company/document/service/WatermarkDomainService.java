package com.company.document.service;

import com.company.document.domain.Watermark;
import com.company.document.response.WatermarkResponse;

public interface WatermarkDomainService {

	WatermarkResponse create(Long documentId, String title, String content, String authorName,
			String topic);

	Watermark getWatermark(Long ticket);

}
