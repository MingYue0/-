package com.jf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {
	public static Connection getConnection() {
		Connection con = null;
		try{
			//mysql����
			/*
			Class.forName("com.mysql.jdbc.Driver");	//��������
			
			//ƴ�����ݿ������ַ���
			String dbURL = "jdbc:mysql://39.108.53.166:3306/jifang";
			
			String db_User = "root";	//���ݿ��û���
			
			String db_pwd = "123456";	//���ݿ��û�������
			*/
			//SQL server����
			Class.forName("net.sourceforge.jtds.jdbc.Driver");	//��������
			
			//ƴ�����ݿ������ַ���
			String dbURL = "jdbc:jtds:sqlserver://127.0.0.1:1433/jifang";
			
			String db_User = "sa";	//���ݿ��û���
			
			String db_pwd = "j13235036521";	//���ݿ��û�������
			
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
