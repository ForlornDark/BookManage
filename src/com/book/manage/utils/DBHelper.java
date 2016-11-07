package com.book.manage.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBHelper {
	private static Properties pro=null;
	private static String url;
	private static String user;
	private static String password;
	private static String driver;
	public static String relPath;
	public static String logicPath;
	public static String URL;
	static{
		pro=new Properties();
		try {
			pro.load(new FileReader(DBHelper.class.getClassLoader().getResource("config.properties").getPath()));
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			relPath = pro.getProperty("relPath");
			logicPath = pro.getProperty("logicPath");
			URL = pro.getProperty("URL");
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			new RuntimeException();
		}
	}
	private DBHelper(){
		
	}
	public static Connection getConnection() throws SQLException{
		Connection conn=DriverManager.getConnection(url, user,password);
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
