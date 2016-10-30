package com.company.document.domain.factory;

import org.apache.commons.lang3.StringUtils;

import com.company.document.domain.Watermark;
import com.company.document.exception.InvalidWatermarkCreationException;

public class WatermarkFactory {

	public Watermark create(String title, String content, String authorName,
			String topic) {
		validateFields(title, content, authorName);
		return new Watermark(title, content, authorName, topic);
	}

	private void validateFields(String title, String content, String authorName) {
		validate(title);
		validate(content);
		validate(authorName);
	}

	private void validate(String field) {
		if(StringUtils.isBlank(field)){
			throw new InvalidWatermarkCreationException();
		}
	}

}
