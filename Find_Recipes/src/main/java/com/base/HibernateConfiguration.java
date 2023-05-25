package com.base;

//import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.base")
@PropertySource("classpath:database.properties")
public class HibernateConfiguration {
	
	@Autowired
	private Environment env;
	
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}

	
	@Bean
	public SessionFactory sessionFactory(){
		LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("com.base.model");
		factoryBean.setHibernateProperties(hibernateProperties());
		try {
			factoryBean.afterPropertiesSet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return factoryBean.getObject();
	}
	
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("db.driver"));
		dataSource.setUrl(env.getProperty("db.url"));
		dataSource.setUsername(env.getProperty("db.username"));
		dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;
	}

	
	private Properties hibernateProperties(){
		Properties properties=new Properties();
		
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		
		return properties;
	}
	

}



//@Value("${db.driver}")
//private String driver;
//
//@Value("${db.password}")
//private String password;
//
//@Value("${db.url}")
//private String url;
//
//@Value("${db.username}")
//private String userName;
//
//@Value("${hibernate.dialect}")
//private String dialect;
//
//@Value("${hibernate.show_sql}")
//private String showSql;
//
//@Value("${hibernate.hbm2ddl.auto}")
//private String hbm2ddlAuto;

//@Value("${entitymanager.packagesToScan}")
//private String packagesToScan;







//@Bean
//public SessionFactory sessionFactory() {
//	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//	sessionFactory.setDataSource(dataSource());
//
//	sessionFactory.setPackagesToScan(packagesToScan);
//
//	Properties hibernateProperties = new Properties();
//	hibernateProperties.put("hibernate.dialect", dialect);
//	hibernateProperties.put("hibernate.show_sql", showSql);
//	hibernateProperties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
//
//	sessionFactory.setHibernateProperties(hibernateProperties);
//
//	try {
//		sessionFactory.afterPropertiesSet();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//
//	return sessionFactory.getObject();
//}
//
//@Bean
//public HibernateTransactionManager transactionManager() {
//	return new HibernateTransactionManager(sessionFactory());
//
//}

// @Bean
// public HibernateTransactionManager transactionManager() {
// HibernateTransactionManager transactionManager = new
// HibernateTransactionManager();
// transactionManager.setSessionFactory(sessionFactory().getObject());
// return transactionManager;
// }




//@Bean
//public HibernateTransactionManager hibTranMan(){
//	return new HibernateTransactionManager(sessionFactory());
//}

