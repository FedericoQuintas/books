package com.company.document.domain;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

import com.company.document.domain.Document;
import com.company.document.domain.Watermark;
import com.company.document.domain.factory.DocumentBuilder;
import com.company.document.exception.InvalidDocumentCreationException;

public class DocumentBuilderTest {

	private DocumentBuilder documentBuilder;
	
	private String title = "Title";
	
	private Long authorId = new Long(1);
	
	private Long id = new Long(100);

	@Before
	public void before() {
		documentBuilder = new DocumentBuilder();
	}

	@Test
	public void whenADocumentIsCreatedThenHasTitle() {

		Document document = documentBuilder.withId(id).withAuthorId(authorId).withTitle(title)
				.build();

		Assert.assertEquals(title, document.getTitle());

	}

	@Test
	public void whenADocumentIsCreatedThenHasAnAuthor() {

		Document document = documentBuilder.withId(id).withAuthorId(authorId).withTitle(title)
				.build();

		Assert.assertEquals(authorId, document.getAuthorId());

	}
	
	@Test
	public void whenADocumentIsCreatedThenHasAnId() {

		Document document = documentBuilder.withAuthorId(authorId).withTitle(title).withId(id)
				.build();

		Assert.assertEquals(id, document.getId());

	}
	
	@Test
	public void whenADocumentIsCreatedWithNoIdThenExceptionIsThrown() {
		try {
			new DocumentBuilder().withAuthorId(authorId).withTitle(title).build();
			fail();
		} catch (InvalidDocumentCreationException e) {
			Assert.assertEquals("Invalid document creation", e.getMessage());
		}
	}


	@Test
	public void whenADocumentIsCreatedWithNoTitleThenExceptionIsThrown() {
		try {
			new DocumentBuilder().withAuthorId(authorId).build();
			fail();
		} catch (InvalidDocumentCreationException e) {
			Assert.assertEquals("Invalid document creation", e.getMessage());
		}
	}
	
	@Test
	public void whenADocumentIsCreatedWithNoUserIdThenExceptionIsThrown() {
		try {
			new DocumentBuilder().withTitle(title).build();
			fail();
		} catch (InvalidDocumentCreationException e) {
			Assert.assertEquals("Invalid document creation", e.getMessage());
		}
	}
	
	@Test
	public void whenADocumentIsCreatedWithWatermarkThenHasAWatermark() {

		Watermark mockedWatermark = mock(Watermark.class);
		
		Document document = documentBuilder.withId(id).withAuthorId(authorId).withTitle(title).withWatermark(mockedWatermark)
				.build();

		Assert.assertEquals(mockedWatermark, document.getWatermark());

	}

}
