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
		String sql = "select BOOK.ISBN,BOOKNAME,AUTHOR,PUBLISHER,PRICE,LEND.TIME,NUM FROM LEND INNER JOIN BOOK ON BOOK.ISBN=LEND.ISBN WHERE READERID=? order by time desc";
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
					b.setISBN(set.getString(1));
					l.setISBN(b.getISBN());
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
		map.put("result", list);
		return map;
	}
	public Map<String,Object> backBook(Lend lend) throws SQLException{
		Map<String,Object> map = new HashMap<String,Object>();
		List<Lend> lends = queryById(lend.getReaderId());
		if(lends.isEmpty()){map.put("error", "请检查ISBN和借阅号");return map;}
		String delete = "delete from lend where lendid = ?";
		String update = "update lend set num = ? where lendid = ?";
		String update2 = "update book set snum = snum + ? where isbn = ?";
		int total = 0;
		for(Lend l:lends) {total = total + l.getNum();}
		System.out.println(total);
		if(total - lend.getNum() < 0){map.put("error", "请检查数量");return map;}
		Lend back = new Lend();
		Book b =new Book();
		back.setBook(b);
		b.setBookName(lends.get(0).getBook().getBookName());
		back.setNum(lend.getNum());
		back.setISBN(lend.getISBN());
		back.setReaderId(lend.getReaderId());
		for(int i = 0;i< lends.size();i++){
			Lend l = lends.get(i);
			if(lend.getNum() - l.getNum() > 0){
				runner.update(delete,l.getLenId());
				l.setNum(0);
				lend.setNum(lend.getNum()-l.getNum());
				continue;
			}else if(lend.getNum() - l.getNum() == 0){
				runner.update(delete,l.getLenId());
				l.setNum(0);
				break;
			}else{
				runner.update(update,l.getNum()-lend.getNum(),l.getLenId());
				l.setNum(l.getNum()-lend.getNum());
				break;
			}
		}
		runner.update(update2,back.getNum(),back.getISBN());
		List<Lend> noBack = new ArrayList<Lend>();
		for(int i = 0;i<lends.size();i++){
			if(lends.get(i).getNum()>0)
				noBack.add(lends.get(i));
			
		}
		map.put("lends",noBack);
		map.put("back",back);
		return map;
	}
	public List<Lend> queryAllByLend(Lend lend) throws SQLException{
		String sql = "select BOOK.ISBN,BOOKNAME,AUTHOR,PUBLISHER,PRICE,LEND.LENDID,TIME,NUM FROM LEND INNER JOIN BOOK ON BOOK.ISBN=LEND.ISBN WHERE READERID=? AND LEND.ISBN =?";
		if(runner==null)
		runner = new QueryRunner();
		List<Lend> lends = runner.query(sql, new ResultSetHandler<List<Lend>>(){

			@Override
			public List<Lend> handle(ResultSet set) throws SQLException {
				// TODO Auto-generated method stub
				List<Lend> list = new ArrayList<Lend>();
				while(set.next()){
					Lend l = new Lend();
					Book b = new Book();
					b.setISBN(set.getString(1));
					l.setISBN(b.getISBN());
					b.setBookName(set.getString(2));
					b.setAuthor(set.getString(3));
					b.setPublisher(set.getString(4));
					b.setPrice(set.getFloat(5));
					l.setBook(b);;
					l.setLenId(set.getInt(6));
					l.setTime(set.getDate(7));
					l.setNum(set.getInt(8));
					l.setReaderId(lend.getReaderId());
					list.add(l);
				}
				return list;
			}},lend.getReaderId(),lend.getISBN());
		return lends;
	}
}
