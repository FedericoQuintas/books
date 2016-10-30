package com.company.document.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

import com.company.document.domain.Watermark;
import com.company.document.domain.factory.WatermarkFactory;
import com.company.document.domain.factory.WatermarkResponseFactory;
import com.company.document.domain.random.RandomProcessDuration;
import com.company.document.persistence.DocumentRepository;
import com.company.document.response.WatermarkResponse;

public class WatermarkDomainServiceImpl implements WatermarkDomainService {

	private WatermarkResponseFactory watermarkResponseFactory;
	private WatermarkFactory watermarkFactory;
	private DocumentRepository documentRepository;
	private ExecutorService executorService;
	private RandomProcessDuration randomProcessDuration;

	public WatermarkDomainServiceImpl(WatermarkFactory watermarkFactory,
			WatermarkResponseFactory watermarkResponseFactory,
			DocumentRepository documentRepository,
			ExecutorService executorService,
			RandomProcessDuration randomProcessDuration) {
		this.watermarkFactory = watermarkFactory;
		this.watermarkResponseFactory = watermarkResponseFactory;
		this.documentRepository = documentRepository;
		this.executorService = executorService;
		this.randomProcessDuration = randomProcessDuration;
	}

	@Override
	public WatermarkResponse create(Long documentId, String title,
			String content, String authorName, String topic) {

		if (randomProcessDuration.getNumber() > 5) {
			executorService.submit(() -> {

				sleepThread();
				
				Watermark watermark = watermarkFactory.create(title, content,
						authorName, topic);
				
				documentRepository.save(documentId, watermark);
			});

			return watermarkResponseFactory.create(null, documentId);
		} else {

			Watermark watermark = watermarkFactory.create(title, content,
					authorName, topic);

			documentRepository.save(documentId, watermark);

			return watermarkResponseFactory.create(watermark, documentId);
		}

	}

	private void sleepThread() {
		try {
			Thread.sleep(ThreadLocalRandom.current().nextInt(1000,
					10000 + 1));
		} catch (Exception e) {
			System.out.println("Thread sleep errror");
		}
	}

	@Override
	public Watermark getWatermark(Long ticket) {
		return documentRepository.getWatermark(ticket);
	}

}
