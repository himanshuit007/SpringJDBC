package com.him.entities;

public class Publisher {
	private String code, publisher_name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Publisher(String code, String publisher_name) {
		super();
		this.code = code;
		this.publisher_name = publisher_name;
	}

	public String getPublisher_name() {
		return publisher_name;
	}

	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Publisher [code=").append(code).append(", publisher_name=").append(publisher_name).append("]");
		return builder.toString();
	}

}
