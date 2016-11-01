package com.book.manage.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryRunner {
	public int update(String sql,Object... params) throws SQLException{
		Connection conn = DBHelper.getConnection();
		PreparedStatement sta = conn.prepareStatement(sql);
		if(params!=null){
			for(int i =1;i<=params.length;i++)
				sta.setObject(i, params[i-1]);
		}
		int result = sta.executeUpdate();
		DBHelper.close(conn, sta, null);
		return result;
	}
	public <T> T query(String sql,ResultSetHandler<T> handler,Object... params) throws SQLException{
		Connection conn = DBHelper.getConnection();
		PreparedStatement sta = conn.prepareStatement(sql);
		if(params!=null){
			for(int i = 1;i<=params.length;i++)
			sta.setObject(i, params[i-1]);
		}
		
		ResultSet set = sta.executeQuery();
		T t = (T) handler.handle(set);
		DBHelper.close(conn, sta, set);
		return t; 
	}
}
