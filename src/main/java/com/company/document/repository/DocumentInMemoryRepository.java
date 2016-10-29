package com.company.document.repository;

import com.company.document.persistence.DocumentRepository;

public class DocumentInMemoryRepository implements DocumentRepository {

	private Long nextId;
	
	public DocumentInMemoryRepository(){
		this.nextId = 0L;
	}

	@Override
	public Long nextId() {
		return this.nextId++;
	}

}
