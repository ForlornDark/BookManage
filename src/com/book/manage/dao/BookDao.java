package com.book.manage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.manage.bean.Book;
import com.book.manage.utils.QueryRunner;
import com.book.manage.utils.ResultSetHandler;
import com.book.manage.utils.SaveFile;

/**
 * @author lfm
 *
 */
public class BookDao {
	QueryRunner runner =null;
	public List<Book> queryByNaAu(String param) throws SQLException{
		String sql = "select * from book where bookname=? or author=?";
		if(runner ==null)
		runner = new QueryRunner();
		List<Book> list = runner.query(sql, new ResultSetHandler<List<Book>>(){

			@Override
			public List<Book> handle(ResultSet set) throws SQLException {
				// TODO Auto-generated method stub
				List<Book> list = new ArrayList<Book>();
				while(set.next()){
					Book b =new Book();
					b.setISBN(set.getString(1));
					b.setBookName(set.getString(2));
					b.setAuthor(set.getString(3));
					b.setPublisher(set.getString(4));
					b.setPrice(set.getFloat(5));
					b.setCnum(set.getInt(6));
					b.setSnum(set.getInt(7));
					b.setPath(set.getString(9));
					list.add(b);
				}
				return list;
			}}, param,param);
		return list;
	}
	public String deleteBookByISBN(String ISBN) throws SQLException{
		String sql = "delete from book where isbn = ?";
		String result = null;
		if(runner ==null)
			runner = new QueryRunner();
		Book book =queryByISBN(ISBN) ;
		if(book!=null){
			runner.update(sql, ISBN);
			if(book.getPath()!=null)
			SaveFile.deleteFile(book.getPath());
			result = "É¾³ý³É¹¦";
		}else
			result = "É¾³ýÊ§°Ü£¬¼ì²éISBN";
		return result;
	}
	public int addBook(Book book) throws SQLException{
		if(runner ==null)
			runner = new QueryRunner();
		String sql = "insert into book(isbn,bookname,author,publisher,price,cnum,snum,photo) values(?,?,?,?,?,?,?,?)";
		int result = runner.update(sql, book.getISBN(),book.getBookName(),book.getAuthor(),book.getPublisher(),book.getPrice(),book.getCnum(),book.getSnum(),book.getPath());
		return result;
	}
	public Book queryByISBN(String ISBN) throws SQLException{
		String sql = "select * from book where isbn = ?";
		if(runner ==null)
		runner = new QueryRunner();
		Book book = runner.query(sql, new ResultSetHandler<Book>(){

			@Override
			public Book handle(ResultSet set) throws SQLException {
				// TODO Auto-generated method stub
				Book b = null;
				while(set.next()){
					b =new Book();
					b.setISBN(set.getString(1));
					b.setBookName(set.getString(2));
					b.setAuthor(set.getString(3));
					b.setPublisher(set.getString(4));
					b.setPrice(set.getFloat(5));
					b.setCnum(set.getInt(6));
					b.setSnum(set.getInt(7));
					b.setPath(set.getString(9));
				}
				return b;
			}}, ISBN);
		return book;
	}
}
