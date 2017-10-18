package com.qfedu.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	private static final String DB_DRIVER = Env.getInstance().getProperty("driver");
	private static final String DB_URL = Env.getInstance().getProperty("url");
	private static final String DB_USER = Env.getInstance().getProperty("user");
	private static final String DB_PASS = Env.getInstance().getProperty("pass");
	
	private static Connection conn = null;
	
	static{
		
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
	}
	
	
	public static Connection getConnection(){
		
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
		
		
		
	}
	
	
	public static void closeAll(Connection conn,PreparedStatement ptst,ResultSet rs){
		
		try {
			if(rs !=null){
				
				rs.close();
			}
			if(ptst !=null){
				
				ptst.close();
			}
			if(conn !=null){
				
				conn.close();
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
