package com.company.document.response;

import com.company.document.domain.Document;

public class DocumentResponse {

	private Long ticket;
	private Document document;

	public DocumentResponse(Document document, Long ticket) {
		this.document = document;
		this.ticket = ticket;
	}

	public Document getDocument() {
		return this.document;
	}

	public Long getTicket() {
		return this.ticket;
	}

}
