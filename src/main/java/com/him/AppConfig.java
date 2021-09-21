package com.him;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.him.dao.BookDaoImpl;
import com.him.dao.PublisherDaoImpl;

@Configuration
@ComponentScan(basePackages = {"com.him.dao"})
@PropertySource("classpath:db.properties")
public class AppConfig {

	@Autowired
	Environment environment;
	
	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private final String PASSWORD = "dbpassword";
	
	@Bean
	public DataSource getDriverManagerDatasouDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty(URL));
		dataSource.setUsername(environment.getProperty(USER));
		dataSource.setPassword(environment.getProperty(PASSWORD));
		dataSource.setDriverClassName(environment.getProperty(DRIVER));
		return dataSource;
	}

	@Bean
	public JdbcTemplate getJDBCTemplate() {
		JdbcTemplate j = new JdbcTemplate();
		j.setDataSource(getDriverManagerDatasouDataSource());
		return j;
	}

	@Bean("publisheDAOBean")
	public PublisherDaoImpl getPublisherDAO() {
		PublisherDaoImpl p = new PublisherDaoImpl();
		p.setJd(getJDBCTemplate());
		return p;
	}
	@Bean("bookDAOBean")
	public BookDaoImpl getBookDAO() {
		BookDaoImpl p = new BookDaoImpl();
		p.setJd(getJDBCTemplate());
		return p;
	}
}
