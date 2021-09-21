package com.him;

import com.him.entities.Publisher;

public interface Constants {
	String DB_URL="jdbc:mysql://localhost:3306/bookstore?autoReconnect=true&useSSL=false";
	String DB_CLASS="com.mysql.jdbc.Driver";
	
	String PUBLISHER_INSERT = "insert into publisher values(?,?)";
	String PUBLISHER_UPDATE = "update publisher set PUBLISHER_NAME=? where CODE=?";
	String PUBLISHER_SELECT = "select * from publisher where CODE=?";
	String PUBLISHER_GETALL = "select  * from publisher";
	String PUBLISHER_DELETE = "delete from publisher where CODE=?";
	
	String BOOK_INSERT = "insert into book values(?,?,?)";
	String BOOK_UPDATE = "update book set BOOK_NAME = ? where ISBN=?";
	String BOOK_SELECT = "select * book where ISBN=?";
	String BOOK_DELETE = "delete from book where ISBN=?";
}
