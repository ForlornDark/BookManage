package com.book.manage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.manage.bean.Book;
import com.book.manage.bean.Page;
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
		String sql = "select isbn,bookname,author,publisher,price,cnum,snum,photo from book where bookname=? or author=?";
		if(runner ==null)
		runner = new QueryRunner();
		List<Book> list = runner.query(sql, new MyResultSetHandler(), param,param);
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
	public int queryCount(String param) throws SQLException{
		if(runner == null) runner = new QueryRunner();
		String param1='%'+param+'%';
		String sql = "select count(isbn) from book where bookname like ? or author = ? ";
		int count = runner.query(sql, new ResultSetHandler<Integer>(){

			@Override
			public Integer handle(ResultSet set) throws SQLException {
				// TODO Auto-generated method stub
				int count = 0;
				while(set.next()){
					count = set.getInt(1);
				}
				return count;
			}},param1,param);
		System.out.println(count);
		return count;
	}
	public void queryByPage(Page<List<Book>> p) throws SQLException{
		if(runner == null) runner = new QueryRunner();
		int count = queryCount(p.getIndex());
		if(count == 0)
			return;
		p.setCount(count);
		if(p.getCount()%p.getBlockSize()==0)
			p.setMaxPage(p.getCount()/p.getBlockSize());
		else
			p.setMaxPage(p.getCount()/p.getBlockSize()+1);
		String param1= '%'+p.getIndex()+'%';
		if(p.getPageCount()<=0) p.setPageCount(1);
		else if(p.getCount()%p.getBlockSize() == 0){
			if(p.getPageCount() > p.getCount()/p.getBlockSize())
				p.setPageCount(p.getCount()/p.getBlockSize());
		}else if(p.getCount()%p.getBlockSize() > 0){
			if(p.getPageCount() > p.getCount()/p.getBlockSize()+1)
				p.setPageCount(p.getCount()/p.getBlockSize()+1);
		}
		String sql ="select isbn,bookname,author,publisher,price,cnum,snum,photo from (select isbn,bookname,author,publisher,price,cnum,snum,photo,rownum r from book where (bookname like ? or author = ?) and rownum <= ? ) where r > ?";
		List<Book> list = runner.query(sql,new MyResultSetHandler(), param1,p.getIndex(),p.getPageCount()*p.getBlockSize(),(p.getPageCount()-1)*p.getBlockSize());
		p.setResult(list);
	} 
	private class MyResultSetHandler implements ResultSetHandler<List<Book>>{

		@Override
		public List<Book> handle(ResultSet set) throws SQLException {
			// TODO Auto-generated method
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
				b.setPath(set.getString(8));
				list.add(b);
			}
			return list;
		}
		
	}
}
