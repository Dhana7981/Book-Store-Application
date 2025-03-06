package com.dhana.spring.dao;


import java.util.List;
import com.dhana.spring.entity.Book;

public interface BookDAO {
	public List<Book> getAllBooks();
	public List<Book> getAllBooks(int start,int total);
	public Book getBookById(Integer bid);
	public void addBook(Book book);
	public void updateBook(Book book);
	public void deleteBook(Integer bid);
	public int getBookCount();
}
