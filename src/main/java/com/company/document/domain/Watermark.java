package com.company.document.domain;

public class Watermark {

	private String topic;
	private String authorName;
	private String content;
	private String title;

	public Watermark(String title, String content, String authorName,
			String topic) {
		this.title = title;
		this.content = content;
		this.authorName = authorName;
		this.topic = topic;
	}

	public String getTitle() {
		return this.title;
	}

	public String getContent() {
		return this.content;
	}

	public String getAuthorName() {
		return this.authorName;
	}

	public String getTopic() {
		return this.topic;
	}

}
