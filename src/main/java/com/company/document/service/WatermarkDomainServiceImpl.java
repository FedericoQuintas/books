package com.company.document.service;

import com.company.document.domain.Watermark;
import com.company.document.domain.WatermarkFactory;
import com.company.document.domain.WatermarkResponseFactory;
import com.company.document.persistence.DocumentRepository;
import com.company.document.response.WatermarkResponse;

public class WatermarkDomainServiceImpl implements WatermarkDomainService {

	private WatermarkResponseFactory watermarkResponseFactory;
	private WatermarkFactory watermarkFactory;
	private DocumentRepository documentRepository;

	public WatermarkDomainServiceImpl(WatermarkFactory watermarkFactory,
			WatermarkResponseFactory watermarkResponseFactory,
			DocumentRepository documentRepository) {
		this.watermarkFactory = watermarkFactory;
		this.watermarkResponseFactory = watermarkResponseFactory;
		this.documentRepository = documentRepository;
	}

	@Override
	public WatermarkResponse create(Long documentId, String title,
			String content, String authorName, String topic) {

		Watermark watermark = watermarkFactory.create(title, content,
				authorName, topic);
		
		documentRepository.save(documentId, watermark);

		return watermarkResponseFactory.create(watermark, documentId);
	}

	@Override
	public Watermark getWatermark(Long ticket) {
		return documentRepository.getWatermark(ticket);
	}

}
