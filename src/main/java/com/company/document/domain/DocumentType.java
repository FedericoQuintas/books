package com.company.document.domain;

public enum DocumentType {
	JOURNAL("journal"), BOOK("book");

	private String name;

	DocumentType(String name){
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
