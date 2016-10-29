package com.company.document.domain;

public class Document {

	private String title;
	private Long authorId;
	private Watermark watermark;
	private Long id;

	public Document(String title, Long authorId, Watermark watermark, Long id) {
		this.title = title;
		this.authorId = authorId;
		this.watermark = watermark;
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public Long getAuthorId() {
		return this.authorId;
	}

	public Watermark getWatermark() {
		return this.watermark;
	}

	public Long getId() {
		return this.id;
	}

}
