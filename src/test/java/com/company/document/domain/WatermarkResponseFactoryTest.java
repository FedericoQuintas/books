package com.company.document.domain;

import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Test;

import com.company.document.response.DocumentResponse;
import com.company.document.response.WatermarkResponse;

public class WatermarkResponseFactoryTest {

	@Test
	public void whenCreatesWithWatermarkThenWatermarkResponseHasWatermark(){
		Watermark watermark = mock(Watermark.class);
		WatermarkResponseFactory watermarkResponseFactory = new WatermarkResponseFactory();
		WatermarkResponse watermarkResponse = watermarkResponseFactory.create(watermark, 1L);
		Assert.assertEquals(watermark, watermarkResponse.getWatermark());
	}
	
	@Test
	public void whenCreatesWithTicketThenDocumentResponseHasTitle(){
		Long ticket = 1L;
		WatermarkResponseFactory watermarkResponseFactory = new WatermarkResponseFactory();
		WatermarkResponse watermarkResponse = watermarkResponseFactory.create(null, 1L);
		Assert.assertEquals(ticket, watermarkResponse.getTicket());
	}
	
}
