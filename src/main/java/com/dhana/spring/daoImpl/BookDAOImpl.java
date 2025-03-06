package com.dhana.spring.daoImpl;


import java.math.BigInteger;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dhana.spring.dao.BookDAO;
import com.dhana.spring.entity.Book;

@Repository
@Transactional
public class BookDAOImpl implements BookDAO{
	
	@Autowired
	HibernateTemplate hibernateTemp;
	
	@Override
	public List<Book> getAllBooks() {
		System.out.println("-----BookDAOImpl--getAllBooks()---------");
		return hibernateTemp.loadAll(Book.class);
	}

	@Override
	public List<Book> getAllBooks(int start, int total) {
		System.out.println("-----BookDAOImpl--getAllBooks(start,total)---------");
		DetachedCriteria dc=DetachedCriteria.forClass(Book.class);
		return (List<Book>) hibernateTemp.findByCriteria(dc,start,total);
	}

	@Override
	public Book getBookById(Integer bid) {
		System.out.println("-----BookDAOImpl--getBookById()---------");
		return hibernateTemp.load(Book.class, bid, LockMode.READ);
	}

	@Override
	public void addBook(Book book) {
		System.out.println("-----BookDAOImpl--addBook()---------");
		hibernateTemp.save(book);
		
	}

	@Override
	public void updateBook(Book book) {
		System.out.println("-----BookDAOImpl--updateBook()---------");
		hibernateTemp.update(book);
		
	}

	@Override
	public void deleteBook(Integer bid) {
		System.out.println("-----BookDAOImpl--deleteBook()---------");
		Book book = hibernateTemp.get(Book.class, bid);
		if (book != null)
		hibernateTemp.delete(book);
		
	}

	@Override
	public int getBookCount() {
		SessionFactory sessionFactory=hibernateTemp.getSessionFactory();
		Session session=sessionFactory.openSession();
		String sql="select count(*) from mybooks";
		BigInteger big=(BigInteger) session.createNativeQuery(sql).uniqueResult();
		return big.intValue();
	}

}
