package com.company.document.domain;

public class Document {

	private String title;
	private Long userId;

	public Document(String title, Long userId) {
		this.title = title;
		this.userId = userId;
	}

	public String getTitle() {
		return this.title;
	}

	public Long getUserId() {
		return this.userId;
	}

}
