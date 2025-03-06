package com.dhana.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.dhana.spring" })
public class JLCWebConfig {
	@Bean
	public InternalResourceViewResolver viewResolver() {
	InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	viewResolver.setViewClass(JstlView.class);
	viewResolver.setPrefix("/WEB-INF/myjsps/");
	viewResolver.setSuffix(".jsp");
	return viewResolver;
	}
	
	@Bean
	public MessageSource messageSource() {
	ReloadableResourceBundleMessageSource messageSource = new
	ReloadableResourceBundleMessageSource();
	messageSource.setBasename("classpath:messages");
	messageSource.setDefaultEncoding("UTF-8");
	return messageSource;
	}
	
	@Bean()
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
	return new HibernateTemplate(sessionFactory);
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
	return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
	LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	sessionFactoryBean.setDataSource(dataSource);
	Properties props = new Properties();
	props.put("hibernate.show_sql", "true");
	props.put("hibernate.hbm2ddl.auto", "update");
	props.put("hibernate.transaction.factory_class",
	"org.hibernate.transaction.JDBCTransactionFactory");
	sessionFactoryBean.setHibernateProperties(props);
	sessionFactoryBean.setPackagesToScan("com.dhana.spring.entity");
	return sessionFactoryBean;
	}
	
	@Bean
	public DataSource dataSource() {
	DriverManagerDataSource ds = new DriverManagerDataSource();
	ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	ds.setUrl("jdbc:mysql://localhost:3306/bookstoredb?useSSL=false&serverTimezone=UTC");
	ds.setUsername("root");
	ds.setPassword("Dhana@123");
	return ds;
	}
	
	@Bean
	public JavaMailSender javaMailSenderImpl() {
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	mailSender.setHost("smtp.gmail.com");
	mailSender.setPort(465);
	mailSender.setUsername("d6300960742@gmail.com");
	mailSender.setPassword("Vineeth@123");
	Properties prop = mailSender.getJavaMailProperties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
	prop.put("mail.smtp.socketFactory.port", "465");
	prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	prop.put("mail.smtp.auth", "true");
	prop.put("mail.smtp.startssl.enable", "true");
	return mailSender;
	}
	
}
