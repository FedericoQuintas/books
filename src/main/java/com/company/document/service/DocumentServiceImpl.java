package com.company.document.service;

import com.company.document.domain.Document;
import com.company.document.domain.DocumentBuilder;
import com.company.document.domain.DocumentResponseFactory;
import com.company.document.domain.DocumentType;
import com.company.document.persistence.DocumentRepository;
import com.company.document.response.DocumentResponse;
import com.company.document.response.WatermarkResponse;
import com.company.user.service.FindAuthorService;

public class DocumentServiceImpl implements DocumentService {

	private DocumentRepository documentRepository;
	private WatermarkService watermarkService;
	private FindAuthorService findAuthorService;
	private DocumentResponseFactory documentResponseFactory;

	public DocumentServiceImpl(DocumentRepository documentRepository,
			WatermarkService watermarkService,
			FindAuthorService findAuthorService,
			DocumentResponseFactory documentResponseFactory) {
		this.documentRepository = documentRepository;
		this.watermarkService = watermarkService;
		this.findAuthorService = findAuthorService;
		this.documentResponseFactory = documentResponseFactory;
	}

	@Override
	public DocumentResponse create(String title, Long authorId, String topic,
			String type) {

		Document document = buildDocument(title, authorId);

		String authorName = findAuthorService.getAuthorName(authorId);

		WatermarkResponse watermarkResponse = watermarkService.create(
				document.getId(), title,
				DocumentType.valueOf(type.toUpperCase()).getName(), authorName,
				topic);

		fillDocumentWithWatermark(document, watermarkResponse);

		return documentResponseFactory.create(document,
				watermarkResponse.getTicket());
	}

	public DocumentResponse create(String title, Long authorId, String type) {
		return create(title, authorId, null, type);
	}

	private Document buildDocument(String title, Long authorId) {
		Long nextId = documentRepository.nextId();

		Document document = new DocumentBuilder().withAuthorId(authorId)
				.withTitle(title).withId(nextId).build();

		return document;
	}

	private void fillDocumentWithWatermark(Document document,
			WatermarkResponse watermarkResponse) {
		if (watermarkResponse.getWatermark() != null) {
			document.setWatermark(watermarkResponse.getWatermark());
		}
	}

}
