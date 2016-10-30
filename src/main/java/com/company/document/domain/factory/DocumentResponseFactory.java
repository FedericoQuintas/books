package com.company.document.domain.factory;

import com.company.document.domain.Document;
import com.company.document.response.DocumentResponse;

public class DocumentResponseFactory {

	public DocumentResponse create(Document document, Long ticket) {
		return new DocumentResponse(document, ticket);
	}

}
