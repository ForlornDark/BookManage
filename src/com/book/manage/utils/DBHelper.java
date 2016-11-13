package com.book.manage.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBHelper {
	private DBHelper(){
	}
	public static Connection getConnection() throws SQLException{
		Connection conn=DriverManager.getConnection(ServerConst.url, ServerConst.user,ServerConst.password);
		return conn;
	}
public static void close(Connection conn,Statement sta,ResultSet rs){
	try {
				if(rs!=null)rs.close();
				if(sta!=null) sta.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				rs=null;
				sta=null;
				conn=null;
			}
		}
	
}
