package com.company.document.service;

import com.company.document.response.WatermarkResponse;

public interface WatermarkService {

	WatermarkResponse create(String title, String content, String authorName,
			String topic);

	WatermarkResponse create(String title, String string, String authorName);


}
