package com.company.document.domain;

import com.company.document.response.DocumentResponse;

public class DocumentResponseFactory {

	public DocumentResponse create(Document document, Long ticket) {
		return new DocumentResponse(document, ticket);
	}

}
