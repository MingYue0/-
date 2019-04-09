package com.jf.sadmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jf.Appoint;
import com.jf.DbUtils;
import com.jf.Page;
import com.jf.User;
import com.jf.UserService;

public class UserService_sadmin {
	public Page findPage(int pageNow, String queryType,String queryString) {
		int recordCount = 0;
		List<User> recordList = new ArrayList<User>();

		Connection con = DbUtils.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "";
			String pageSql = "";
			
			if(queryType.equals("1")){
				sql = "select count(*) from table_user where no like '"+queryString+"%'";
				pageSql = "SELECT TOP 5 * FROM table_user where id not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " id FROM table_user where no like '"+queryString+"%' order by id desc) and no like '"+queryString+"%' order by id desc";
				
				ps = con.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1);
				}
				
				ps = con.prepareStatement(pageSql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Integer id = rs.getInt(1);
					String username = rs.getString(2);
					String password = rs.getString(3);
					String no = rs.getString(4);
					String name = rs.getString(5);
					String sex = rs.getString(6);
					String department=rs.getString(7);
					String telephone=rs.getString(8);
					String email=rs.getString(9);
					String usert=rs.getString(10);

					User user=new User();
					user.setId(id);
					user.setUsername(username);
					user.setPassword(password);
					user.setNo(no);
					user.setName(name);
					user.setSex(sex);
					user.setDepartment(department);
					user.setTelephone(telephone);
					user.setEmail(email);
					user.setUsertype(usert);

					recordList.add(user);
				}
				DbUtils.closeConnection(con,ps, rs);
			}
			else if(queryType.equals("2")){
				sql = "select count(*) from table_user where department = ?";
				pageSql = "SELECT TOP 5 * FROM table_user where id not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " id FROM table_user where department = ? order by id desc) and department = ? order by id desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1,queryString);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1);
				}
				
				ps = con.prepareStatement(pageSql);
				ps.setString(1, queryString);
				ps.setString(2, queryString);
				rs = ps.executeQuery();
				while (rs.next()) {
					Integer id = rs.getInt(1);
					String username = rs.getString(2);
					String password = rs.getString(3);
					String no = rs.getString(4);
					String name = rs.getString(5);
					String sex = rs.getString(6);
					String department=rs.getString(7);
					String telephone=rs.getString(8);
					String email=rs.getString(9);
					String usert=rs.getString(10);

					User user=new User();
					user.setId(id);
					user.setUsername(username);
					user.setPassword(password);
					user.setNo(no);
					user.setName(name);
					user.setSex(sex);
					user.setDepartment(department);
					user.setTelephone(telephone);
					user.setEmail(email);
					user.setUsertype(usert);

					recordList.add(user);
				}
				DbUtils.closeConnection(con,ps,rs);
			}
			else if(queryType.equals("0")){
				sql = "select count(*) from table_user where no=?";
				pageSql = "SELECT TOP 5 * FROM table_user where id not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " id FROM table_user where no=? order by id desc) and no=? order by id desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, queryString);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1);
				}
				
				ps = con.prepareStatement(pageSql);
				ps.setString(1, queryString);
				ps.setString(2, queryString);
				rs = ps.executeQuery();
				while (rs.next()) {
					Integer id = rs.getInt(1);
					String username = rs.getString(2);
					String password = rs.getString(3);
					String no = rs.getString(4);
					String name = rs.getString(5);
					String sex = rs.getString(6);
					String department=rs.getString(7);
					String telephone=rs.getString(8);
					String email=rs.getString(9);
					String usert=rs.getString(10);

					User user=new User();
					user.setId(id);
					user.setUsername(username);
					user.setPassword(password);
					user.setNo(no);
					user.setName(name);
					user.setSex(sex);
					user.setDepartment(department);
					user.setTelephone(telephone);
					user.setEmail(email);
					user.setUsertype(usert);

					recordList.add(user);
				}
				DbUtils.closeConnection(con,ps, rs);
			}
			else if(queryType.equals("3")){
				sql = "select count(*) from table_user";
				pageSql = "SELECT TOP 5 * FROM table_user where id not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " id FROM table_user order by id desc) order by id desc";
				
				ps = con.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1);
				}
				
				ps = con.prepareStatement(pageSql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Integer id = rs.getInt(1);
					String username = rs.getString(2);
					String password = rs.getString(3);
					String no = rs.getString(4);
					String name = rs.getString(5);
					String sex = rs.getString(6);
					String department=rs.getString(7);
					String telephone=rs.getString(8);
					String email=rs.getString(9);
					String usert=rs.getString(10);

					User user=new User();
					user.setId(id);
					user.setUsername(username);
					user.setPassword(password);
					user.setNo(no);
					user.setName(name);
					user.setSex(sex);
					user.setDepartment(department);
					user.setTelephone(telephone);
					user.setEmail(email);
					user.setUsertype(usert);

					recordList.add(user);
				}
				DbUtils.closeConnection(con,ps, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		Page page = new Page(pageNow, recordCount, recordList);
		return page;
	}

	public Page findPage_log(int pageNow, String queryType,String queryString) {
		int recordCount = 0;
		List<Log> recordList = new ArrayList<Log>();

		Connection con = DbUtils.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "";
			String pageSql = "";
			
			if(queryType.equals("1")){
				sql = "select count(*) from table_log";
				pageSql = "SELECT TOP 5 * FROM table_log where logid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " logid FROM table_log  order by logid desc) order by logid desc";
				
				ps = con.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1);
				}
				
				ps = con.prepareStatement(pageSql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Integer id = rs.getInt(1);
					String no = rs.getString(2);
					String username = rs.getString(3);
					String intime = rs.getString(4);
					String outtime = rs.getString(5);
					String ip = rs.getString(6);
					intime=intime.substring(0,intime.length() - 8);
					outtime=outtime.substring(0,outtime.length() - 8);
						
					Log log=new Log();
					log.setId(id);
					log.setNo(no);
					log.setUsername(username);
					log.setNo(no);
					log.setIntime(intime);
					log.setOuttime(outtime);
					log.setIp(ip);

					recordList.add(log);
				}
				DbUtils.closeConnection(con,ps, rs);
			}
			else if(queryType.equals("2")){
				sql = "select count(*) from table_log where no like '"+queryString+"%'";
				pageSql = "SELECT TOP 5 * FROM table_log where logid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " logid FROM table_log where no like '"+queryString+"%' order by logid desc) and no like '"+queryString+"%' order by logid desc";
				
				ps = con.prepareStatement(sql);		
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1);
				}
				
				ps = con.prepareStatement(pageSql);
				rs = ps.executeQuery();
				while (rs.next()) {
					Integer id = rs.getInt(1);
					String no = rs.getString(2);
					String username = rs.getString(3);
					String intime = rs.getString(4);
					String outtime = rs.getString(5);
					String ip = rs.getString(6);
					intime=intime.substring(0,intime.length() - 8);
					outtime=outtime.substring(0,outtime.length() - 8);
					Log log=new Log();
					log.setId(id);
					log.setNo(no);
					log.setUsername(username);
					log.setNo(no);
					log.setIntime(intime);
					log.setOuttime(outtime);
					log.setIp(ip);

					recordList.add(log);
				}
				DbUtils.closeConnection(con,ps,rs);
			}
			else if(queryType.equals("0")){
				sql = "select count(*) from table_log where no=?";
				pageSql = "SELECT TOP 5 * FROM table_log where logid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " logid FROM table_log where no=? order by logid desc) and no=? order by logid desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, queryString);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1);
				}
				
				ps = con.prepareStatement(pageSql);
				ps.setString(1, queryString);
				ps.setString(2, queryString);
				rs = ps.executeQuery();
				while (rs.next()) {
					Integer id = rs.getInt(1);
					String no = rs.getString(2);
					String username = rs.getString(3);
					String intime = rs.getString(4);
					String outtime = rs.getString(5);
					String ip = rs.getString(6);
					intime=intime.substring(0,intime.length() - 8);
					outtime=outtime.substring(0,outtime.length() - 8);
					Log log=new Log();
					log.setId(id);
					log.setNo(no);
					log.setUsername(username);
					log.setNo(no);
					log.setIntime(intime);
					log.setOuttime(outtime);
					log.setIp(ip);

					recordList.add(log);
				}
				DbUtils.closeConnection(con,ps, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Page page = new Page(pageNow, recordCount, recordList);
		return page;
	}

	public boolean leading(List<User> u){
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		for(int i=0;i<u.size();i++){
			String sql = "insert into table_user (username,password,no,name,sex,department,email,telephone,usertype) values(?,?,?,?,?,?,?,?,?)";
			try {
				User user=u.get(i);
				ps = conn.prepareStatement(sql);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getNo());
				ps.setString(4, user.getName());
				ps.setString(5, user.getSex());
				ps.setString(6, user.getDepartment());
				ps.setString(7, user.getEmail());
				ps.setString(8, user.getTelephone());
				ps.setString(9, user.getUsertype());
				int rows = ps.executeUpdate();
				rows++;			
				if(rows==u.size()) {
					return true;
				}
				}catch(SQLException e) {
					return false;
				}
		}
		DbUtils.closeConnection(conn,ps,null);
		return false;
	}

	public List<User> out_stu(){
		List<User> u=new ArrayList<User>();
		Connection con = DbUtils.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select * from table_user where usertype='学生'";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer dbId=rs.getInt(1);
				String uname=rs.getString(2);
				String passw=rs.getString(3);
				String no=rs.getString(4);
				String name=rs.getString(5);
				String sex=rs.getString(6);
				String department=rs.getString(7);
				String telephone=rs.getString(8);
				String email=rs.getString(9);
				String usert=rs.getString(10);
				
				User user = null;			
				user=new User();
				user.setId(dbId);
				user.setUsername(uname);
				user.setPassword(passw);
				user.setNo(no);
				user.setName(name);
				user.setSex(sex);
				user.setDepartment(department);
				user.setTelephone(telephone);
				user.setEmail(email);
				user.setUsertype(usert);
				
				u.add(user);
			}
			DbUtils.closeConnection(con,ps,rs);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public List<Log> out_log(){
		List<Log> l=new ArrayList<Log>();
		Connection con = DbUtils.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select * from table_log";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer dbId=rs.getInt(1);
				String no=rs.getString(2);
				String username=rs.getString(3);
				String intime=rs.getString(4);
				String outtime=rs.getString(5);
				String ip=rs.getString(6);
				
				Log log = null;			
				log=new Log();
				log.setId(dbId);
				log.setNo(no);
				log.setUsername(username);
				log.setIntime(intime);
				log.setOuttime(outtime);
				log.setIp(ip);
				
				l.add(log);
			}
			DbUtils.closeConnection(con,ps,rs);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public boolean add_limit(Limit l,String comno2,String aa){
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		int a=Integer.parseInt(l.getComno());
		for(int i=0;i<Integer.parseInt(comno2);i++){
			String sql = "insert into table_limit (comno,classno,lstime,letime,reason) values(?,?,?,?,?)";
			Appoint appoint=new UserService().setappoint("被限制时段",l.getClassno(),""+a,l.getLstime(),aa);
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, ""+a);
				ps.setString(2, l.getClassno());
				ps.setString(3, l.getLstime());
				ps.setString(4, l.getLetime());
				ps.setString(5, l.getReason());
				a=a+1;
				int rows = ps.executeUpdate();		
				
				}catch(SQLException e) {
					return false;
				}
		}
		DbUtils.closeConnection(conn,ps,null);
		return true;
	}
	
	public Page getTimePage(int pageNow) {
		int recordCount = 0;
		List<User> recordList = new ArrayList<User>();

		Connection con = DbUtils.getConnection();
		PreparedStatement ps = null;
		try {
			String sql = "";
			String pageSql = "";
			
			sql = "select count(*) from table_user where usertype='学生'";
			pageSql = "SELECT TOP 5 * FROM table_user where id not in ( SELECT TOP " + (pageNow - 1) * 5
					+ " id FROM table_user where usertype='学生' order by utime desc) and usertype='学生' order by utime desc";
			
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				recordCount = rs.getInt(1);
			}
			
			ps = con.prepareStatement(pageSql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String no = rs.getString(4);
				String name = rs.getString(5);
				String sex = rs.getString(6);
				String department=rs.getString(7);
				String telephone=rs.getString(8);
				String email=rs.getString(9);
				String usert=rs.getString(10);
				String ltime=rs.getString(11);
				String utime=rs.getString(12);

				User user=new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setNo(no);
				user.setName(name);
				user.setSex(sex);
				user.setDepartment(department);
				user.setTelephone(telephone);
				user.setEmail(email);
				user.setUsertype(usert);
				user.setLtime(ltime);
				user.setUtime(utime);

				recordList.add(user);
			}
			DbUtils.closeConnection(con,ps,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		Page page = new Page(pageNow, recordCount, recordList);
		return page;
	}
	public int getCount(int time1,int time2){
		int count=0;
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		try{
			String sql="select count(*) from table_use where DateName(hour,stime)>=?-DateName(hour,etime) and DateName(hour,stime)<=?-DateName(hour,etime)";
			ps = con.prepareStatement(sql);
			ps.setInt(1,time1*2);
			ps.setInt(2,time2*2);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				count=rs.getInt(1);
				
				break;
			}
			
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return count;
	}
	
	public List<User> getClassTime(String queryString){
		List<User> recordList = new ArrayList<User>();
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		try{
			String sql="select * from table_user where no like '"+queryString+"%' order by no asc";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				String no = rs.getString(4);
				String name = rs.getString(5);
				Integer utime = rs.getInt(12);
				if (utime == null || utime.equals("")) {
					utime = 0;
				}

				
				User user=new User();
				user.setNo(no.substring(no.length()-2));
				user.setName(name);
				user.setUset(utime);

				recordList.add(user);
			}
			
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return recordList;
	}


}
