package com.company.document.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.company.document.domain.Document;
import com.company.document.persistence.DocumentRepository;
import com.company.document.repository.DocumentInMemoryRepository;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DocumentServiceTest {

	private String title = "Title";
	private Long id = 100L;
	private Long authorId = 1L;
	private DocumentService documentService;
	private DocumentRepository documentRepository;

	@Before
	public void before(){
		documentRepository = mock(DocumentInMemoryRepository.class);
		when(documentRepository.nextId()).thenReturn(id);
		documentService = new DocumentServiceImpl(documentRepository);
	}
	
	@Test
	public void whenCreatesADocumentWithTitleThenADocumentWithTitleIsRetrieved(){
		
		Document document = documentService.create(title, authorId);
		Assert.assertEquals(title, document.getTitle());
		
	}
	
	@Test
	public void whenCreatesADocumentThenADocumentWithIdIsRetrieved(){
		
		Document document = documentService.create(title, authorId);
		Assert.assertEquals(id, document.getId());
		
	}
	
	@Test
	public void whenCreatesADocumentWithAuthorIdThenADocumentWithAuthorIdIsRetrieved(){
		
		Document document = documentService.create(title, authorId);
		Assert.assertEquals(authorId, document.getAuthorId());
		
	}
	
	@Test
	public void whenDocumentIsCreatedThenRepositoryIsAskedForNextID(){
		documentService.create(title, authorId);
		verify(documentRepository).nextId();
	}
}



