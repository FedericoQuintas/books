package com.company.document.domain;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.company.document.exception.InvalidWatermarkCreationException;

public class WatermarkFactoryTest {

	private String title = "Title";
	private String content = "book";
	private String authorName = "Name";
	private String topic = "topic";
	private Watermark watermark;
	
	@Before
	public void before(){
		watermark = new WatermarkFactory().create(title, content, authorName, topic);
	}
	
	@Test
	public void whenCreatesWithTitleThenWatermarkHasTitle(){
		Assert.assertEquals(title, watermark.getTitle());
	}
	
	@Test
	public void whenCreatesWithContentThenWatermarkHasTitle(){
		Assert.assertEquals(content, watermark.getContent());
	}
	
	@Test
	public void whenCreatesWithAuthorNameThenWatermarkHasTitle(){
		Assert.assertEquals(authorName, watermark.getAuthorName());
	}
	
	@Test
	public void whenCreatesWithTopicThenWatermarkHasTopic(){
		Assert.assertEquals(topic, watermark.getTopic());
	}
	
	@Test
	public void whenAWatermarkIsCreatedWithNoAuthorNameThenExceptionIsThrown() {
		try {
			watermark = new WatermarkFactory().create(title, content, null, topic);
			fail();
		} catch (InvalidWatermarkCreationException e) {
			Assert.assertEquals("Invalid watermark creation", e.getMessage());
		}
	}
	
	@Test
	public void whenAWatermarkIsCreatedWithNoTitleThenExceptionIsThrown() {
		try {
			watermark = new WatermarkFactory().create(null, content, authorName, topic);
			fail();
		} catch (InvalidWatermarkCreationException e) {
			Assert.assertEquals("Invalid watermark creation", e.getMessage());
		}
	}
	
	@Test
	public void whenAWatermarkIsCreatedWithNoContentThenExceptionIsThrown() {
		try {
			watermark = new WatermarkFactory().create(title, null, authorName, topic);
			fail();
		} catch (InvalidWatermarkCreationException e) {
			Assert.assertEquals("Invalid watermark creation", e.getMessage());
		}
	}

}
