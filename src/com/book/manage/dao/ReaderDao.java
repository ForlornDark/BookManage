package com.book.manage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.manage.bean.Reader;
import com.book.manage.utils.DBHelper;
import com.book.manage.utils.DateUtil;
import com.book.manage.utils.QueryRunner;
import com.book.manage.utils.ResultSetHandler;
import com.book.manage.utils.SaveFile;
import com.book.manage.utils.ServerConst;

public class ReaderDao {
	QueryRunner runner  =null;
	public int addReader(Reader reader) throws SQLException{
		if(runner == null)
			runner  = new QueryRunner();
		String sql = "insert into reader(readerid,name,sex,born,spec,email) values (null,?,?,TO_DATE(?,'yyyy-MM-dd'),?,?)";
		return runner.update(sql,reader.getName(),reader.getSex(),DateUtil.format(reader.getBorn()),reader.getSpec(),reader.getMail());
	}
	public int queryID(Reader reader) throws SQLException{
		if(runner == null)
			runner  = new QueryRunner();
		String sql = "select readerid from reader where email = ?";
		int ID = runner.query(sql, new ResultSetHandler<Integer>(){

			@Override
			public Integer handle(ResultSet set) throws SQLException {
				// TODO Auto-generated method stub
				int id = 0;
				while(set.next())
				 id = set.getInt(1);
				return id;
			}}, reader.getMail());
		return ID;
	}
	public int updatePhoto(Reader reader) throws SQLException{
		if(runner == null)
			runner  = new QueryRunner();
		String sql = "update reader set photo = ? where readerid = ?";
		return runner.update(sql,reader.getPhoto(),reader.getReaderId());
	}
	/**
	 * 
	 * @param param 用户id或名字
	 * @return
	 * @throws SQLException
	 */
	public List<Reader> qureyByParam(String param) throws SQLException{
		if(runner == null)
			runner  = new QueryRunner();
		String sql = "select * from reader where readerid = ? or name = ?";
		List<Reader> readers = runner.query(sql,new ResultSetHandler<List<Reader>>(){

			@Override
		public List<Reader> handle(ResultSet set) throws SQLException {
				// TODO Auto-generated method stub
				List<Reader>  list = new ArrayList<Reader>();
				while(set.next()){
					Reader r = new Reader();
					r.setReaderId(set.getInt(1));
					r.setName(set.getString(2));
					r.setSex(set.getByte(3));
					r.setBorn(set.getDate(4));
					r.setSpec(set.getString(5));
					r.setMail(set.getString(6));
					String photo = set.getString(7);
					if(photo!=null&&(!photo.isEmpty()))
					r.setPhoto(ServerConst.URL+photo);
					list.add(r);
				}
				return list;
			}}, param,param);
		return readers;
		
	}
	public String deleteByID(int id) throws SQLException{
		if(runner == null)
			runner  = new QueryRunner();
		String result = null;
		LendDao dao = new LendDao();
		if((dao.queryById(id)).size()==0){
			Reader reader = qureyById(id);
			if(reader!=null){
				if(reader.getPhoto()!=null)
				SaveFile.deleteFile(reader.getPhoto());
				String sql = "delete from reader where readerId = ?";
				if(runner.update(sql, id)>0)
					result = "删除ID"+id+"成功";
			}else result = "请确认ID";
		}else
			result = "有未还书";
		System.out.println(result);
		return result;
	}
	public Reader qureyById(int id) throws SQLException{
		if(runner == null)
			runner  = new QueryRunner();
		String sql = "select * from reader where readerid = ?";
		Reader reader = runner.query(sql,new ResultSetHandler<Reader>(){

			@Override
		public Reader handle(ResultSet set) throws SQLException {
				// TODO Auto-generated method stub
				Reader r = null;
				while(set.next()){
					r = new Reader();
					r.setReaderId(set.getInt(1));
					r.setName(set.getString(2));
					r.setSex(set.getByte(3));
					r.setBorn(set.getDate(4));
					r.setSpec(set.getString(5));
					String photo = set.getString(6);
					if(photo!=null&&(!photo.isEmpty()))
					r.setPhoto(set.getString(6));
				}
				return r;
			}}, id);
		return reader;
		
	}
}
