package com.company.document.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.company.document.domain.Document;
import com.company.document.domain.DocumentResponseFactory;
import com.company.document.domain.DocumentType;
import com.company.document.domain.Watermark;
import com.company.document.exception.WatermarkNotFoundException;
import com.company.document.persistence.DocumentRepository;
import com.company.document.repository.DocumentInMemoryRepository;
import com.company.document.response.WatermarkResponse;
import com.company.user.service.FindAuthorService;

public class DocumentServiceTest {

	private String title = "Title";
	private Long id = 100L;
	private Long authorId = 1L;
	private String topic = "topic";
	private DocumentService documentService;
	private DocumentRepository documentRepository;
	private WatermarkDomainService watermarkService;
	private FindAuthorService findAuthorService;

	@Before
	public void before() {
		documentRepository = mock(DocumentInMemoryRepository.class);
		when(documentRepository.nextId()).thenReturn(id);
		watermarkService = mock(WatermarkDomainService.class);
		WatermarkResponse waterMarkResponse = mock(WatermarkResponse.class);
		when(
				watermarkService
						.create(any(Long.class), any(String.class),
								any(String.class), any(String.class),
								any(String.class))).thenReturn(
				waterMarkResponse);
		findAuthorService = mock(FindAuthorService.class);
		when(findAuthorService.getAuthorName(authorId)).thenReturn(
				"Author name");
		documentService = new DocumentServiceImpl(documentRepository,
				watermarkService, findAuthorService,
				new DocumentResponseFactory());
	}

	@Test
	public void whenCreatesABookWithTitleThenADocumentWithTitleIsRetrieved() {
		Document document = documentService.create(title, authorId, topic,
				DocumentType.BOOK.getName()).getDocument();
		Assert.assertEquals(title, document.getTitle());
	}

	@Test
	public void whenCreatesAJourneyWithTitleThenADocumentWithTitleIsRetrieved() {
		Document document = documentService.create(title, authorId,
				DocumentType.JOURNAL.getName()).getDocument();
		Assert.assertEquals(title, document.getTitle());
	}

	@Test
	public void whenCreatesABookThenADocumentWithIdIsRetrieved() {
		Document document = documentService.create(title, authorId, topic,
				DocumentType.BOOK.getName()).getDocument();
		Assert.assertEquals(id, document.getId());
	}

	@Test
	public void whenCreatesAJournalThenADocumentWithIdIsRetrieved() {
		Document document = documentService.create(title, authorId,
				DocumentType.JOURNAL.getName()).getDocument();
		Assert.assertEquals(id, document.getId());
	}

	@Test
	public void whenCreatesABookWithAuthorIdThenADocumentWithAuthorIdIsRetrieved() {
		Document document = documentService.create(title, authorId, topic,
				DocumentType.BOOK.getName()).getDocument();
		Assert.assertEquals(authorId, document.getAuthorId());
	}

	@Test
	public void whenCreatesAJournalWithAuthorIdThenADocumentWithAuthorIdIsRetrieved() {
		Document document = documentService.create(title, authorId,
				DocumentType.JOURNAL.getName()).getDocument();
		Assert.assertEquals(authorId, document.getAuthorId());
	}

	@Test
	public void whenBookIsCreatedThenRepositoryIsAskedForNextID() {
		documentService.create(title, authorId, topic,
				DocumentType.BOOK.getName());
		verify(documentRepository).nextId();
	}

	@Test
	public void whenJournalIsCreatedThenRepositoryIsAskedForNextID() {
		documentService.create(title, authorId, DocumentType.JOURNAL.getName())
				.getDocument();
		verify(documentRepository).nextId();
	}

	@Test
	public void whenBookIsCreatedThenWatermarkServiceIsCalled() {
		documentService.create(title, authorId, topic,
				DocumentType.BOOK.getName());
		verify(watermarkService)
				.create(id, title, "book", "Author name", topic);
	}

	@Test
	public void whenJournalIsCreatedThenWatermarkServiceIsCalled() {
		documentService.create(title, authorId, DocumentType.JOURNAL.getName());
		verify(watermarkService).create(id, title,
				DocumentType.JOURNAL.getName(), "Author name", null);
	}

	@Test
	public void whenWatermarkServiceRetrievesWatermarkThenBookContainsWatermark() {

		WatermarkResponse watermarkResponse = mock(WatermarkResponse.class);

		Watermark watermark = mock(Watermark.class);

		when(watermarkResponse.getWatermark()).thenReturn(watermark);

		when(
				watermarkService
						.create(any(Long.class), any(String.class),
								any(String.class), any(String.class),
								any(String.class))).thenReturn(
				watermarkResponse);

		Document document = documentService.create(title, authorId, topic,
				DocumentType.BOOK.getName()).getDocument();

		Assert.assertNotNull(document.getWatermark());

	}

	@Test
	public void whenWatermarkServiceRetrievesWatermarkThenJournalContainsWatermark() {

		WatermarkResponse waterMarkResponse = mock(WatermarkResponse.class);

		Watermark watermark = mock(Watermark.class);

		when(waterMarkResponse.getWatermark()).thenReturn(watermark);

		when(
				watermarkService
						.create(any(Long.class), any(String.class),
								any(String.class), any(String.class),
								any(String.class))).thenReturn(
				waterMarkResponse);

		Document document = documentService.create(title, authorId,
				DocumentType.JOURNAL.getName()).getDocument();

		Assert.assertNotNull(document.getWatermark());

	}

	@Test
	public void whenWatermarkServiceDoesNotRetrieveWatermarkThenJournalNotContainsWatermark() {

		WatermarkResponse waterMarkResponse = mock(WatermarkResponse.class);

		when(
				watermarkService
						.create(any(Long.class), any(String.class),
								any(String.class), any(String.class),
								any(String.class))).thenReturn(
				waterMarkResponse);

		Document document = documentService.create(title, authorId,
				DocumentType.JOURNAL.getName()).getDocument();

		Assert.assertNull(document.getWatermark());

	}

	@Test
	public void whenWatermarkServiceDoesNotRetrieveWatermarkThenBookNotContainsWatermark() {

		WatermarkResponse waterMarkResponse = mock(WatermarkResponse.class);

		when(
				watermarkService
						.create(any(Long.class), any(String.class),
								any(String.class), any(String.class),
								any(String.class))).thenReturn(
				waterMarkResponse);

		Document document = documentService.create(title, authorId, topic,
				DocumentType.BOOK.getName()).getDocument();

		Assert.assertNull(document.getWatermark());

	}

	@Test
	public void whenAsksForWatermarkAndIsReadyThenDocumentWithWatermarkIsRetrieved() {
		Document document = documentService.create(title, authorId, topic,
				DocumentType.BOOK.getName()).getDocument();
		Watermark watermark = mock(Watermark.class);
		when(watermarkService.getWatermark(1L)).thenReturn(watermark);
		when(documentRepository.getById(1L)).thenReturn(document);
		document = documentService.checkWatermarkStatus(1L);
		Assert.assertEquals(watermark, document.getWatermark());
	}

	@Test
	public void whenAsksForWatermarkAndIsNotReadyThenExceptionIsThrown() {
		
		when(watermarkService.getWatermark(1L)).thenThrow(
				new WatermarkNotFoundException());
		
		try {
			documentService.checkWatermarkStatus(1L);
		} catch (WatermarkNotFoundException e) {
			Assert.assertEquals("Watermark not ready", e.getMessage());
		}
	}
}
