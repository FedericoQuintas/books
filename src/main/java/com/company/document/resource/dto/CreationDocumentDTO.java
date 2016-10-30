package com.company.document.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreationDocumentDTO {

	@JsonProperty("author_id")
	private Long authorId;
	
	@JsonProperty("topic")
	private String topic;
	
	@JsonProperty("title")
	private String title;

	public Long getAuthorId() {
		return this.authorId;
	}

	public String getTopic() {
		return this.topic;
	}

	public String getTitle() {
		return this.title;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
