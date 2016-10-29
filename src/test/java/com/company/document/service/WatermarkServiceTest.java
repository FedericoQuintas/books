package com.company.document.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.company.document.domain.Watermark;
import com.company.document.domain.WatermarkFactory;
import com.company.document.domain.WatermarkResponseFactory;
import com.company.document.persistence.DocumentRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class WatermarkServiceTest {

	private String title = "Title";
	private String content = "book";
	private String authorName = "Name";
	private String topic = "topic";
	private Long id = 1l;
	private WatermarkDomainServiceImpl watermarkService;
	private DocumentRepository documentRepository;

	@Before
	public void before() {
		documentRepository = mock(DocumentRepository.class);
		watermarkService = new WatermarkDomainServiceImpl(
				new WatermarkFactory(), new WatermarkResponseFactory(),
				documentRepository);
	}

	@Test
	public void whenWatermarkIsCreatedThenHasTitle() {
		Watermark watermark = watermarkService.create(id, title, content,
				authorName, topic).getWatermark();
		Assert.assertEquals(title, watermark.getTitle());
	}

	@Test
	public void whenWatermarkIsCreatedThenHasContent() {
		Watermark watermark = watermarkService.create(id, title, content,
				authorName, topic).getWatermark();
		Assert.assertEquals(content, watermark.getContent());
	}

	@Test
	public void whenWatermarkIsCreatedThenHasAuthorName() {
		Watermark watermark = watermarkService.create(id, title, content,
				authorName, topic).getWatermark();
		Assert.assertEquals(authorName, watermark.getAuthorName());
	}

	@Test
	public void whenWatermarkIsCreatedWithTopicThenHasTopic() {
		Watermark watermark = watermarkService.create(id, title, content,
				authorName, topic).getWatermark();
		Assert.assertEquals(topic, watermark.getTopic());
	}

	@Test
	public void whenWatermarkIsCreatedWithNoTopicThenHasNotTopic() {
		Watermark watermark = watermarkService.create(id, title, content,
				authorName, null).getWatermark();
		Assert.assertNull(watermark.getTopic());
	}
	
	@Test
	public void whenWatermarkIsCreatedThenIsSaved() {
		Watermark watermark = watermarkService.create(id, title, content,
				authorName, null).getWatermark();
		verify(documentRepository).save(id, watermark);
	}
}
