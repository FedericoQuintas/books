package com.company.config;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.company.document.domain.RealRandomProcessDuration;
import com.company.document.domain.factory.DocumentResponseFactory;
import com.company.document.domain.factory.WatermarkFactory;
import com.company.document.domain.factory.WatermarkResponseFactory;
import com.company.document.persistence.DocumentRepository;
import com.company.document.repository.DocumentInMemoryRepository;
import com.company.document.resource.DocumentResource;
import com.company.document.service.DocumentService;
import com.company.document.service.DocumentServiceImpl;
import com.company.document.service.WatermarkDomainService;
import com.company.document.service.WatermarkDomainServiceImpl;
import com.company.user.service.FindAuthorServiceImpl;

@Configuration
@EnableWebMvc
public class AppConfiguration {

	private static final int NUMBER_OF_THREADS = 40;

	@Bean
	public DocumentService documentService(
			DocumentRepository documentRepository,
			WatermarkDomainService watermarkDomainService) {
		return new DocumentServiceImpl(documentRepository,
				watermarkDomainService, new FindAuthorServiceImpl(),
				new DocumentResponseFactory());
	}

	@Bean
	public DocumentRepository documentRepository() {
		return new DocumentInMemoryRepository();
	}

	@Bean
	public DocumentResource documentResource(DocumentService documentService) {
		return new DocumentResource(documentService);
	}

	@Bean
	public WatermarkDomainService watermarkDomainService(
			DocumentRepository documentRepository) {
		return new WatermarkDomainServiceImpl(new WatermarkFactory(),
				new WatermarkResponseFactory(), documentRepository,
				Executors.newFixedThreadPool(NUMBER_OF_THREADS),
				new RealRandomProcessDuration());
	}

}
