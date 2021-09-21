package com.him.dao;

import java.awt.print.Book;
import java.util.List;

public interface BookDao {
	int insert(Book b);
	int update(Book b);
	Book getBookByISBN(String isbn);
	List<Book> getAllBooks();
	int delete(String isbn);
}
