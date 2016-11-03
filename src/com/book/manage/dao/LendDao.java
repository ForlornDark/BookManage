package com.book.manage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.book.manage.bean.Book;
import com.book.manage.bean.Lend;
import com.book.manage.utils.QueryRunner;
import com.book.manage.utils.ResultSetHandler;

/**
 * @author lfm
 *
 */
public class LendDao {
	QueryRunner runner = null;
	public List<Lend> queryById(int id) throws SQLException{
		String sql = "select BOOK.ISBN,BOOKNAME,AUTHOR,PUBLISHER,PRICE,LEND.TIME,NUM FROM LEND INNER JOIN BOOK ON BOOK.ISBN=LEND.ISBN WHERE READERID=?";
		if(runner==null)
		runner = new QueryRunner();
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
	public Map<String,Object> lendBookForResult(Lend l) throws SQLException{
		String sql_lend = "insert into lend values(null,?,?,TO_DATE(?,'yyyy-MM-dd'),?)";
		String sql_lend2="update book set snum = ? where isbn = ?";
		String sql = "select snum from book where isbn = ?"; 
		Map<String,Object> map = new HashMap<String,Object>();
		if(runner==null)
			runner = new QueryRunner();
		System.out.println("开始。。");
		int snum = runner.query(sql, new ResultSetHandler<Integer>(){

			@Override
			public Integer handle(ResultSet set) throws SQLException {
				// TODO Auto-generated method stub
				int result = -1;
				while(set.next()){
					result = set.getInt(1);
				}
				return result;
			}}, l.getISBN());
		if(snum<0){
			map.put("error", "请确认ISBN或ID");
			return map;
		}else if(snum-l.getNum()<0){
			map.put("error", "书量不够");
			return map;
		}
		snum = snum -l.getNum();
		runner.update(sql_lend2,snum,l.getISBN());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		runner.update(sql_lend,l.getReaderId(),l.getISBN(),format.format(new Date()),l.getNum());
		List<Lend> list = queryById(l.getReaderId());
		System.out.println("四次");
		map.put("result", list);
		return map;
	}
}
