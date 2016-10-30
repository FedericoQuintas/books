package com.company.document.domain;

import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Test;

import com.company.document.domain.factory.DocumentResponseFactory;
import com.company.document.response.DocumentResponse;

public class DocumentResponseFactoryTest {

	@Test
	public void whenCreatesWithDocumentThenDocumentResponseHasDocument(){
		Document document = mock(Document.class);
		DocumentResponseFactory documentResponseFactory = new DocumentResponseFactory();
		DocumentResponse documentResponse = documentResponseFactory.create(document, 1L);
		Assert.assertEquals(document, documentResponse.getDocument());
	}
	
	@Test
	public void whenCreatesWithTicketThenDocumentResponseHasTicket(){
		Long ticket = 1L;
		DocumentResponseFactory documentResponseFactory = new DocumentResponseFactory();
		DocumentResponse documentResponse = documentResponseFactory.create(null, ticket);
		Assert.assertEquals(ticket, documentResponse.getTicket());
	}
	
}
