package com.book.manage.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.book.manage.bean.Book;
import com.book.manage.bean.Page;
import com.book.manage.dao.BookDao;

public class BookTest {
	
	public void testQueryCount(){
		BookDao dao = new BookDao();
		try {
			System.out.println(dao.queryCount("%郭克华%"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testQueryByPage(){
		BookDao dao = new BookDao();
		Page<List<Book>> page = new Page<List<Book>>();
		page.setIndex("软件工程");
		page.setPageCount(1);
		page.setBlockSize(5);
		try {
			dao.queryByPage(page);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Book> list = page.getResult();
		for(Book b:list)
		System.out.println(b.getBookName());
	}
	@Test
	public void testQueryByNameOrAuthor(){
		BookDao dao = new BookDao();
		try {
			List<Book> bs = dao.queryByNaAu("计算机网络");
			for(Book b:bs){
				System.out.println(b.getBookName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
