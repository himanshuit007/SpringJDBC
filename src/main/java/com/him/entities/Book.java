package com.him.entities;

public class Book {
	private String isbn, book_name, publisher_code;

	public Book(String isbn, String book_name, String publisher_code) {
		super();
		this.isbn = isbn;
		this.book_name = book_name;
		this.publisher_code = publisher_code;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getPublisher_code() {
		return publisher_code;
	}

	public void setPublisher_code(String publisher_code) {
		this.publisher_code = publisher_code;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [isbn=").append(isbn).append(", book_name=").append(book_name).append(", publisher_code=")
				.append(publisher_code).append("]");
		return builder.toString();
	}

}
