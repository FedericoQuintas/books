package com.company.document.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.document.domain.Document;
import com.company.document.domain.DocumentType;
import com.company.document.resource.dto.CreationDocumentDTO;
import com.company.document.response.DocumentResponse;
import com.company.document.service.DocumentService;

@RequestMapping("/")
public class DocumentResource {

	private DocumentService documentService;

	public DocumentResource(DocumentService documentService) {
		this.documentService = documentService;
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST, consumes = { "application/json" })
	@ResponseBody
	public DocumentResponse storeBook(
			@RequestBody CreationDocumentDTO creationDocumentDTO) {
		return documentService.create(creationDocumentDTO.getTitle(),
				creationDocumentDTO.getAuthorId(),
				creationDocumentDTO.getTopic(), DocumentType.BOOK.getName());
	}

	@RequestMapping(value = "/journals", method = RequestMethod.POST, consumes = { "application/json" })
	@ResponseBody
	public DocumentResponse storeJournal(
			@RequestBody CreationDocumentDTO creationDocumentDTO) {
		return documentService.create(creationDocumentDTO.getTitle(),
				creationDocumentDTO.getAuthorId(),
				DocumentType.JOURNAL.getName());
	}

	@RequestMapping(value = "/watermarks/{ticket}", method = RequestMethod.GET, consumes = { "application/json" })
	@ResponseBody
	public Document checkWatermark(@PathVariable("ticket") Long ticket) {
		return documentService.checkWatermarkStatus(ticket);
	}

}
