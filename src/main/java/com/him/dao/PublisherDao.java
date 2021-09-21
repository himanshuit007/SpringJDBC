package com.him.dao;


import java.util.List;

import com.him.entities.Publisher;

public interface PublisherDao {
	int insertPublisher(Publisher p);
	int updatePublisher(Publisher p);
	Publisher getPublisherByCode(String code);
	List<Publisher> getAllPublisher();
	int deletePublisher(String code);
}
