package com.company.document.service;

import com.company.document.domain.Document;

public interface DocumentService {

	Document create(String title, Long authorId);

}
