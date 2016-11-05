package com.book.manage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.manage.bean.Book;
import com.book.manage.utils.QueryRunner;
import com.book.manage.utils.ResultSetHandler;

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
	public int deleteBookByISBN(String ISBN) throws SQLException{
		String sql = "delete from book where isbn = ?";
		if(runner ==null)
			runner = new QueryRunner();
		return runner.update(sql, ISBN);
	}
}
