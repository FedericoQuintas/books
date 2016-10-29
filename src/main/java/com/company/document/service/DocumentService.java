package com.company.document.service;

import com.company.document.domain.Document;
import com.company.document.response.DocumentResponse;

public interface DocumentService {

	DocumentResponse create(String title, Long authorId, String topic, String type);

	DocumentResponse create(String title, Long authorId, String string);

	Document checkWatermarkStatus(Long ticket);

	

}
