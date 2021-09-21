package com.him.dao;

import java.util.List;

import com.him.entities.Book;

public interface BookDao {
	int insertBook(Book b);
	int updateBook(Book b);
	Book getBookByISBN(String isbn);
	List<Book> getAllBooks();
	int deleteBook(String isbn);
}
