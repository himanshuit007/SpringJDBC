package com.him.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.him.Constants;
import com.him.entities.Publisher;

@Service("p")
public class PublisherDaoImpl implements PublisherDao {

	@Autowired
	JdbcTemplate jd;

	public JdbcTemplate getJd() {
		return jd;
	}

	public void setJd(JdbcTemplate jd) {
		this.jd = jd;
	}

	@Override
	public int insertPublisher(Publisher p) {
		return jd.update(Constants.PUBLISHER_INSERT, p.getCode(), p.getPublisher_name());
	}

	@Override
	public int deletePublisher(String code) {
		return jd.update(Constants.PUBLISHER_DELETE, code);
	}

	@Override
	public int updatePublisher(Publisher p) {
		// TODO Auto-generated method stub
		return jd.update(Constants.PUBLISHER_UPDATE, p.getPublisher_name(), p.getCode());
	}

	@Override
	public Publisher getPublisherByCode(String code) {
		return jd.queryForObject(Constants.PUBLISHER_SELECT, new RowMapper<Publisher>() {

			@Override
			public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Publisher(rs.getString("CODE"), rs.getString("PUBLISHER_NAME"));
			}
		},new Object[] {code});

	}

	@Override
	public List<Publisher> getAllPublisher() {
		return jd.query(Constants.PUBLISHER_GETALL, new RowMapper<Publisher>() {

			@Override
			public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Publisher(rs.getString("CODE"), rs.getString("PUBLISHER_NAME"));
			}
		});

	}

}
