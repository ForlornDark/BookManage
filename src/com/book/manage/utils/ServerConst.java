package com.book.manage.utils;

import java.io.FileReader;
import java.util.Properties;

public class ServerConst {
	private static Properties pro=null;
	public static String url;
	public static String user;
	public static String password;
	public static String driver;
	public static String relPath;
	public static String logicPath;
	public static String URL;
	public static String mailHost;
	public static String mailName;
	public static String mailPass;
	public static String mailPort;
	public static String mailDebug;
	public static String mailValidate;
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
			mailHost = pro.getProperty("mailHost");
			mailName =pro.getProperty("mailName");
			mailPass = pro.getProperty("mailPass");
			mailPort =pro.getProperty("mailPort");
			mailDebug = pro.getProperty("mailDebug");
			mailValidate = pro.getProperty("mailValidate");
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			new RuntimeException();
		}
	}
}
