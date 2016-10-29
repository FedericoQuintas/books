package com.company.document.service;

import com.company.document.response.WatermarkResponse;

public interface WatermarkService {

	WatermarkResponse create(Long documentId, String title, String content, String authorName,
			String topic);

}
