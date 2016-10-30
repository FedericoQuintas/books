package com.company.document.domain.factory;

import org.apache.commons.lang3.StringUtils;

import com.company.document.domain.Document;
import com.company.document.domain.Watermark;
import com.company.document.exception.InvalidDocumentCreationException;

public class DocumentBuilder {

	private String title;
	private Long authorId;
	private Watermark watermark;
	private Long id;

	public DocumentBuilder withTitle(String title) {
		this.title = title;
		return this;
	}

	public Document build() {
		validations();
		return new Document(this.title, this.authorId, this.watermark, this.id);
	}

	private void validations() {
		validateTitle();
		validateIdField(this.authorId);
		validateIdField(this.id);
	}

	private void validateTitle() {
		if(StringUtils.isBlank(this.title)){
			throw new InvalidDocumentCreationException();
		}
	}

	private void validateIdField(Long field) {
		if(field == null){
			throw new InvalidDocumentCreationException();
		}
	}

	public DocumentBuilder withAuthorId(Long authorId) {
		this.authorId = authorId;
		return this;
	}

	public DocumentBuilder withWatermark(Watermark watermark) {
		this.watermark = watermark;
		return this;
	}

	public DocumentBuilder withId(Long id) {
		this.id = id;
		return this;
	}

}
