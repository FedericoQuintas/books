package com.company;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.company.document.domain.Document;
import com.company.document.domain.DocumentBuilder;
import com.company.document.exception.InvalidDocumentCreationException;

public class DocumentBuilderTest {

	private DocumentBuilder documentBuilder;

	@Before
	public void before() {
		documentBuilder = new DocumentBuilder();
	}

	@Test
	public void whenADocumentIsCreatedThenHasTitle() {

		String title = "Title";

		Long userId = new Long(1);

		Document document = documentBuilder.withUserId(userId).withTitle(title)
				.build();

		Assert.assertEquals(title, document.getTitle());

	}

	@Test
	public void whenADocumentIsCreatedThenHasAnAuthor() {

		String title = "Title";

		Long userId = new Long(1);

		Document document = documentBuilder.withUserId(userId).withTitle(title)
				.build();

		Assert.assertEquals(userId, document.getUserId());

	}

	@Test
	public void whenADocumentIsCreatedWithNoTitleThenExceptionIsThrown() {

		Long userId = new Long(1);
		try {
			new DocumentBuilder().withUserId(userId).build();
			fail();
		} catch (InvalidDocumentCreationException e) {
			Assert.assertEquals("Invalid document creation", e.getMessage());
		}

	}
	
	@Test
	public void whenADocumentIsCreatedWithNoUserIdThenExceptionIsThrown() {

		String title = "Title";
		try {
			new DocumentBuilder().withTitle(title).build();
			fail();
		} catch (InvalidDocumentCreationException e) {
			Assert.assertEquals("Invalid document creation", e.getMessage());
		}

	}

}
