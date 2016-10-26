package com.company.document.domain;

import org.apache.commons.lang3.StringUtils;

import com.company.document.exception.InvalidDocumentCreationException;

public class DocumentBuilder {

	private String title;
	private Long userId;

	public DocumentBuilder withTitle(String title) {
		this.title = title;
		return this;
	}

	public Document build() {
		validations();
		return new Document(this.title, this.userId);
	}

	private void validations() {
		validateTitle();
		validateUserId();
	}

	private void validateTitle() {
		if(StringUtils.isBlank(this.title)){
			throw new InvalidDocumentCreationException();
		}
	}

	private void validateUserId() {
		if(this.userId == null){
			throw new InvalidDocumentCreationException();
		}
	}

	public DocumentBuilder withUserId(Long userId) {
		this.userId = userId;
		return this;
	}

}
