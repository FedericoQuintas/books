package com.company.document.persistence;

import com.company.document.domain.Document;

public interface DocumentRepository {

	Long nextId();

	void save(Document document);

}
