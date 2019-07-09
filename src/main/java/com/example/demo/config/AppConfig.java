package com.example.demo.config;



import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableTransactionManagement
public class AppConfig {

	@Bean
	public DataSource datasource()
	{
		DriverManagerDataSource data=new DriverManagerDataSource();
		data.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		data.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		data.setUsername("hr");
		data.setPassword("hr");
		return data;
	}
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf)
	{
		JpaTransactionManager tm=new JpaTransactionManager();
		tm.setEntityManagerFactory(emf);
		return tm;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean lce=new LocalContainerEntityManagerFactoryBean();
		lce.setDataSource(datasource());	
		lce.setJpaProperties(properties());
		lce.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		lce.setPackagesToScan("com.example.demo.model");
		return lce;
	}
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	    return new PersistenceExceptionTranslationPostProcessor();
	}
	private Properties properties()
	{
		Properties pr=new Properties();
		pr.setProperty("hibernate.hbm2ddl.auto", "update");
		pr.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		pr.setProperty("hibernate.show_sql", "true");
		pr.setProperty("hibernate.format_sql","true");
		return pr;
	}
}
