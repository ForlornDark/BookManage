package com.book.manage.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.book.manage.bean.Book;
import com.book.manage.bean.Lend;
import com.book.manage.bean.Reader;
import com.book.manage.dao.BookDao;
import com.book.manage.dao.LendDao;
import com.book.manage.dao.ReaderDao;
import com.book.manage.utils.QueryRunner;
import com.book.manage.utils.SaveFile;

public class LendTest {
public void testLendDao(){
	try {
		List<Lend> list = new LendDao().queryById(1000000);
		for(Lend l :list){
			System.out.println(l.getISBN());
			System.out.println(l.getNum());
			System.out.println(l.getTime());
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void testDate(){
	SimpleDateFormat m = new SimpleDateFormat("yyyy-MM-dd");
	System.out.println(m.format(new Date()));
}

public void testUpdate(){
	QueryRunner runner = new QueryRunner();
	String sql="update book set snum = ? where isbn = ?";
	try {
		runner.update(sql, 20,"978-7-121-13072-4");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("完毕");
}

public void testFor(){
	List<Book> lists = new ArrayList<Book>();
	for(int i = 0;i<5;i++){
		Book b = new Book();
		b.setAuthor("你"+i);
		lists.add(b);
	} 
	Book b = lists.get(0);
	if(b.equals(lists.get(0)))
		System.out.println(true);
	else
		System.out.println(false);
	b.setAuthor("改变后");
	System.out.println(lists.get(0).getAuthor());
}

	public void testStringToDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = format.parse("1996-5-15");
			System.out.println(d.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteFile(){
		SaveFile.deleteFile("/upload/1/0/0/0/0/6.jpg");
	}

	public void testQueryReader(){
		ReaderDao dao = new ReaderDao();
		try {
			System.out.println(dao.deleteByID(100008));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	@Test
public void testDeleteBook(){
	BookDao dao = new BookDao();
	try {
		String state = dao.deleteBookByISBN("978-7-302-27014-0");
		System.out.println(state);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

public void tesQueryBook(){
		BookDao dao = new BookDao();
		try {
			Book b = dao.queryByISBN("978-7-121-13072-4");
			System.out.println(b.getBookName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
