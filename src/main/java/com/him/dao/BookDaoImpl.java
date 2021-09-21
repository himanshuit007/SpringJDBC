package com.him.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.him.Constants;
import com.him.entities.Book;

@Service("bookDAO")
public class BookDaoImpl implements BookDao {

	@Autowired
	JdbcTemplate jd;

	public JdbcTemplate getJd() {
		return jd;
	}

	public void setJd(JdbcTemplate jd) {
		this.jd = jd;
	}

	@Override
	public int insertBook(Book p) {
		return jd.update(Constants.BOOK_INSERT, p.getIsbn(), p.getBook_name(),p.getPublisher_code());
	}

	@Override
	public int deleteBook(String isbn) {
		return jd.update(Constants.BOOK_DELETE, isbn);
	}

	@Override
	public int updateBook(Book p) {
		return jd.update(Constants.BOOK_UPDATE, p.getBook_name(), p.getIsbn());
	}

	@Override
	public Book getBookByISBN(String code) {
		return jd.queryForObject(Constants.BOOK_SELECT, new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Book(rs.getString("ISBN"), rs.getString("BOOK_NAME"),rs.getString("PUBLISHER_CODE"));
			}
		},new Object[] {code});

	}

	@Override
	public List<Book> getAllBooks() {
		return jd.query(Constants.BOOK_GETALL, new RowMapper<Book>() {

			@Override
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Book(rs.getString("ISBN"), rs.getString("BOOK_NAME"),rs.getString("PUBLISHER_CODE"));
			}
		});

	}

}
