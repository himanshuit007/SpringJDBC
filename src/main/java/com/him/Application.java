package com.him;

import java.sql.ResultSet;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.him.dao.PublisherDao;
import com.him.dao.PublisherDaoImpl;
import com.him.entities.Publisher;

public class Application {
	public static void main(String[] args) {
//		 simpleWay();
//		daoWay();

		daoJavaConfig();

	}

	private static void daoJavaConfig() {
		AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		appContext.registerShutdownHook();
		PublisherDao pd = (PublisherDao) appContext.getBean("publisheDAO");
//		PublisherDao pd = (PublisherDao) appContext.getBean("publisheDAOBean");//using componentScan

		pd.insertPublisher(new Publisher("P1", "P1"));
		pd.updatePublisher(new Publisher("P1", "P11111"));
		pd.insertPublisher(new Publisher("P2", "P2"));

		System.out.println("All Publisher list" + pd.getAllPublisher());

		System.out.println(pd.getPublisherByCode("P1"));
		System.out.println(pd.getPublisherByCode("P2"));

		pd.deletePublisher("P1");
		pd.deletePublisher("P2");
		appContext.close();
	}

	private static void daoWay() {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		appContext.registerShutdownHook();
		// PublisherDao pd = (PublisherDao) appContext.getBean("PublisherDaoImpl");
		PublisherDao pd = (PublisherDao) appContext.getBean("p");

		pd.insertPublisher(new Publisher("P1", "P1"));
		pd.updatePublisher(new Publisher("P1", "P11111"));
		pd.insertPublisher(new Publisher("P2", "P2"));

		System.out.println("All Publisher list" + pd.getAllPublisher());

		System.out.println(pd.getPublisherByCode("P1"));
		System.out.println(pd.getPublisherByCode("P2"));

		pd.deletePublisher("P1");
		pd.deletePublisher("P2");
		appContext.close();
	}

	private static void simpleWay() {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext(
				"com/him/applicationContextCopy.xml");
		appContext.registerShutdownHook();
		JdbcTemplate jd = (JdbcTemplate) appContext.getBean("jd");
		int rs = 0;
		rs = jd.update(Constants.PUBLISHER_INSERT, "Test", "Test Publication");
		System.out.println("Query result " + rs);
		rs = jd.update(Constants.BOOK_INSERT, "ISBN1", "Test JAVA", "Test");
		System.out.println("Query result " + rs);

		rs = jd.update(Constants.BOOK_UPDATE, "Test JAVA with JAVA 8", "ISBN1");
		System.out.println("Query result " + rs);

		rs = jd.queryForObject("SELECT COUNT(*) FROM book", Integer.class);
		System.out.println("Book count" + rs);

		rs = jd.update(Constants.BOOK_DELETE, "ISBN1");
		System.out.println("Query result " + rs);
		rs = jd.update(Constants.PUBLISHER_DELETE, "Test");
		System.out.println("Query result " + rs);
		
		appContext.close();

	}
}
