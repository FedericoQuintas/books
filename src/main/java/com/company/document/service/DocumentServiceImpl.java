package com.company.document.service;

import com.company.document.domain.Document;
import com.company.document.domain.DocumentBuilder;
import com.company.document.persistence.DocumentRepository;

public class DocumentServiceImpl implements DocumentService {

	private DocumentRepository documentRepository;

	public DocumentServiceImpl(DocumentRepository documentRepository) {
		this.documentRepository = documentRepository;
	}

	@Override
	public Document create(String title, Long authorId) {
		Long nextId = documentRepository.nextId();
		Document document = new DocumentBuilder().withAuthorId(authorId)
				.withTitle(title).withId(nextId).build();
		return document;
	}

}
