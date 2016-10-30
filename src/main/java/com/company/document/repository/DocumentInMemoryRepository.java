package com.company.document.repository;

import java.util.HashMap;
import java.util.Map;

import com.company.document.domain.Document;
import com.company.document.domain.Watermark;
import com.company.document.exception.DocumentNotFoundException;
import com.company.document.exception.WatermarkNotFoundException;
import com.company.document.persistence.DocumentRepository;

public class DocumentInMemoryRepository implements DocumentRepository {

	private Long nextId;
	private Map<Long, Document> documents;
	private Map<Long, Watermark> watermarks;

	public DocumentInMemoryRepository() {
		this.nextId = 1L;
		this.documents = new HashMap<Long, Document>();
		this.watermarks = new HashMap<Long, Watermark>();
	}

	@Override
	public Long nextId() {
		return this.nextId++;
	}

	@Override
	public void save(Document document) {
		this.documents.put(document.getId(), document);
	}

	@Override
	public Watermark getWatermark(Long ticket) {
		if (!this.watermarks.containsKey(ticket)) {
			throw new WatermarkNotFoundException();
		}
		return this.watermarks.get(ticket);
	}

	@Override
	public Document getById(Long id) {
		if (!this.documents.containsKey(id)) {
			throw new DocumentNotFoundException();
		}
		return this.documents.get(id);
	}

	@Override
	public void save(Long ticket, Watermark watermark) {
		this.watermarks.put(ticket, watermark);
	}

}
