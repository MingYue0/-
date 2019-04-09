package com.jf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {
	public static Connection getConnection() {
		Connection con = null;
		try{
			//mysql连接
			/*
			Class.forName("com.mysql.jdbc.Driver");	//加载驱动
			
			//拼接数据库连接字符串
			String dbURL = "jdbc:mysql://39.108.53.166:3306/jifang";
			
			String db_User = "root";	//数据库用户名
			
			String db_pwd = "123456";	//数据库用户的密码
			*/
			//SQL server连接
			Class.forName("net.sourceforge.jtds.jdbc.Driver");	//加载驱动
			
			//拼接数据库连接字符串
			String dbURL = "jdbc:jtds:sqlserver://127.0.0.1:1433/jifang";
			
			String db_User = "sa";	//数据库用户名
			
			String db_pwd = "j13235036521";	//数据库用户的密码
			
			con = DriverManager.getConnection(dbURL, db_User, db_pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void closeConnection(Connection conn,PreparedStatement ps,ResultSet rs) {
		try{
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
