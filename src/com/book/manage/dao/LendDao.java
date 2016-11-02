package com.book.manage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.manage.bean.Book;
import com.book.manage.bean.Lend;
import com.book.manage.utils.QueryRunner;
import com.book.manage.utils.ResultSetHandler;

/**
 * @author lfm
 *
 */
public class LendDao {
	public List<Lend> queryById(int id) throws SQLException{
		String sql = "select BOOK.ISBN,BOOKNAME,AUTHOR,PUBLISHER,PRICE,LEND.TIME,NUM FROM LEND INNER JOIN BOOK ON BOOK.ISBN=LEND.ISBN WHERE READERID=?";
		QueryRunner runner = new QueryRunner();
		List<Lend> list = runner.query(sql, new ResultSetHandler<List<Lend>>(){

			@Override
			public List<Lend> handle(ResultSet set) throws SQLException {
				// TODO Auto-generated method stub
				List<Lend> list = new ArrayList<Lend>();
				while(set.next()){
					Lend l = new Lend();
					Book b = new Book();
					b.setIsbn(set.getString(1));
					l.setISBN(b.getIsbn());
					b.setBookName(set.getString(2));
					b.setAuthor(set.getString(3));
					b.setPublisher(set.getString(4));
					b.setPrice(set.getFloat(5));
					l.setBook(b);;
					l.setTime(set.getDate(6));
					l.setNum(set.getInt(7));
					l.setReaderId(id);
					list.add(l);
				}
				return list;
			}}, id);
		return list;
	}
}
