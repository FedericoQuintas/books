package com.company.document.repository;

import java.util.HashMap;
import java.util.Map;

import com.company.document.domain.Document;
import com.company.document.persistence.DocumentRepository;

public class DocumentInMemoryRepository implements DocumentRepository {

	private Long nextId;
	private Map<Long, Document> documents;
	
	public DocumentInMemoryRepository(){
		this.nextId = 0L;
		this.documents = new HashMap<Long, Document>();
	}

	@Override
	public Long nextId() {
		return this.nextId++;
	}

	@Override
	public void save(Document document) {
		this.documents.put(document.getId(), document);
	}

}
