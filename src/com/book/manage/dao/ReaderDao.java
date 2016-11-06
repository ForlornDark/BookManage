package com.book.manage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.manage.bean.Reader;
import com.book.manage.utils.DateUtil;
import com.book.manage.utils.QueryRunner;
import com.book.manage.utils.ResultSetHandler;

public class ReaderDao {
	QueryRunner runner  =null;
	public int addReader(Reader reader) throws SQLException{
		if(runner == null)
			runner  = new QueryRunner();
		String sql = "insert into reader(readerid,name,sex,born,spec) values (null,?,?,TO_DATE(?,'yyyy-MM-dd'),?)";
		return runner.update(sql,reader.getName(),reader.getSex(),DateUtil.format(reader.getBorn()),reader.getSpec());
	}
	public int queryID(Reader reader) throws SQLException{
		if(runner == null)
			runner  = new QueryRunner();
		String sql = "select readerid from reader where name=? and sex =? and spec = ?";
		int ID = runner.query(sql, new ResultSetHandler<Integer>(){

			@Override
			public Integer handle(ResultSet set) throws SQLException {
				// TODO Auto-generated method stub
				int id = 0;
				while(set.next())
				 id = set.getInt(1);
				return id;
			}}, reader.getName(),reader.getSex(),reader.getSpec());
		return ID;
	}
	public int updatePhoto(Reader reader) throws SQLException{
		if(runner == null)
			runner  = new QueryRunner();
		String sql = "update reader set photo = ? where readerid = ?";
		return runner.update(sql,reader.getPhoto(),reader.getReaderId());
	}
}
