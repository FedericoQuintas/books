package com.company.document.persistence;

import com.company.document.domain.Document;
import com.company.document.domain.Watermark;

public interface DocumentRepository {

	Long nextId();

	void save(Document document);

	Document getById(Long ticket);

	Watermark getWatermark(Long ticket);

	void save(Long ticket, Watermark watermark);

}
