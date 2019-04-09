package com.jf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jf.DbUtils;
import com.jf.Page;
import com.jf.User;

public class UserService {
	public User findUserByUsernameAndPassword(String username,String password,String usertype) {
		Connection con = DbUtils.getConnection();
		PreparedStatement ps = null;
		User user = null;
		try {
			String sql="select * from table_user where username=? and password=? and usertype=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, usertype);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id=rs.getInt(1);
				String uname=rs.getString(2);
				String passw=rs.getString(3);
				String no=rs.getString(4);
				String name=rs.getString(5);
				String sex=rs.getString(6);
				String department=rs.getString(7);
				String telephone=rs.getString(8);
				String email=rs.getString(9);
				String usert=rs.getString(10);
				
							
				user=new User();
				user.setId(id);
				user.setUsername(uname);
				user.setPassword(passw);
				user.setNo(no);
				user.setName(name);
				user.setSex(sex);
				user.setDepartment(department);
				user.setTelephone(telephone);
				user.setEmail(email);
				user.setUsertype(usert);

				break;
			}
			DbUtils.closeConnection(con,ps,rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean addUser(User user) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into table_user (username,password,no,name,sex,department,email,telephone,usertype) values(?,?,?,?,?,?,?,?,?)";
		try {
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
			DbUtils.closeConnection(conn,ps,null);
			if(rows>0) {
				return true;
			}
		}catch(SQLException e) {
			return false;
		}
		
		return false;
	}
	
	public List<User> getUserList(){
		List<User> userList = new ArrayList<User>();
		Connection con = DbUtils.getConnection();
		PreparedStatement ps = null;
		User user = null;
		try {
			String sql="select * from table_user";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Integer id=rs.getInt(1);
				String uname=rs.getString(2);
				String passw=rs.getString(3);
				String no=rs.getString(4);
				String name=rs.getString(5);
				String sex=rs.getString(6);
				String department=rs.getString(7);
				String telephone=rs.getString(8);
				String email=rs.getString(9);
				String usert=rs.getString(10);
				
				user=new User();
				user.setId(id);
				user.setUsername(uname);
				user.setPassword(passw);
				user.setNo(no);
				user.setName(name);
				user.setSex(sex);
				user.setDepartment(department);
				user.setTelephone(telephone);
				user.setEmail(email);
				user.setUsertype(usert);
				userList.add(user);
			}
			DbUtils.closeConnection(con,ps,rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return userList;
		
	}

	public Page getPage(int pageNow) {
		// 记录总数
		int recordCount = 0;
		//当前页面具体数据集合
		List<User> recordList = new ArrayList<User>(); 
		Connection con = DbUtils.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select count(*) from table_user where usertype <> '系统管理员'";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				recordCount = rs.getInt(1);
			}
			String pageSql = "select top 5 * from table_user where id not in (select top " + (pageNow - 1) * 5 + "id from table_user where usertype <> '系统管理员') and usertype <> '系统管理员' ";
			ps = con.prepareStatement(pageSql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Integer id=rs.getInt(1);
				String uname=rs.getString(2);
				String passw=rs.getString(3);
				String no=rs.getString(4);
				String name=rs.getString(5);
				String sex=rs.getString(6);
				String department=rs.getString(7);
				String telephone=rs.getString(8);
				String email=rs.getString(9);
				String usert=rs.getString(10);
				
							
				User user=new User();
				user.setId(id);
				user.setUsername(uname);
				user.setPassword(passw);
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		Page page = new Page(pageNow,recordCount,recordList);
		return page;
	}

	
	public User getUserById(int id) {
		Connection con = DbUtils.getConnection();
		PreparedStatement ps = null;
		User user = null;
		try {
			String sql="select * from table_user where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
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
				
				break;
			}
			DbUtils.closeConnection(con,ps,rs);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean updateUser(User user) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "update table_user set username=?,password=?,no=?,name=?,sex=?,department=?,email=?,telephone=?,usertype=? where id=?";
		try {
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
			ps.setInt(10, user.getId());
			int rows = ps.executeUpdate();
			DbUtils.closeConnection(conn,ps,null);
			if(rows>0) {
				return true;
			}
		}catch(Exception e) {
			return false;
		}
		
		return false;
	}
	
	public boolean deleteUserById(int id) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from table_user where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			DbUtils.closeConnection(conn, ps, null);
			if (rows > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
 	
	public List<Computer> getComputerList(){
		List<Computer> comList=new ArrayList<Computer>();
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		Computer computer=null;
		try{
			String sql="select * from table_computer";
		
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Integer comid=rs.getInt(1);
				String version=rs.getString(2);
				String classno=rs.getString(3);
				String condition=rs.getString(4);
				String appointment=rs.getString(5);
				String sno=rs.getString(6);
				
				computer=new Computer();
				computer.setComid(comid);
				computer.setVersion(version);
				computer.setClassno(classno);
				computer.setCondition(condition);
				computer.setAppointment(appointment);
				computer.setSno(sno);
				
				
				comList.add(computer);
			}
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return comList;
	}
	
	public Page getCPage(int pageNow){
		int recordCount=0;
		List<Computer> recordList=new ArrayList<Computer>();
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		try{
			String sql="select count(*) from table_computer";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				recordCount=rs.getInt(1);
			}
			
			String pageSql="select top 5 * from table_computer where comid not in (select top "+(pageNow-1)*5+" comid FROM table_computer order by comid desc)order by comid desc";
			ps=con.prepareStatement(pageSql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Integer comid=rs.getInt(1);
				String version=rs.getString(2);
				String classno=rs.getString(3);
				String condition=rs.getString(4);
				String appointment=rs.getString(5);
				String sno=rs.getString(6);
				String configuration=rs.getString(7);
				String software=rs.getString(8);
				String director=rs.getString(9);
				String comno=rs.getString(10);
				
				Computer computer=new Computer();
				computer.setComid(comid);
				computer.setVersion(version);
				computer.setClassno(classno);
				computer.setCondition(condition);
				computer.setAppointment(appointment);
				computer.setSno(sno);
				computer.setConfiguration(configuration);
				computer.setSoftware(software);
				computer.setDirector(director);
				computer.setComno(comno);
				
				
				recordList.add(computer);
			}
			
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		
		Page page=new Page(pageNow,recordCount,recordList);
		
		return page;
	}
	
	public boolean deleteComputerById(int comid) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from table_computer where comid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comid);
			int rows = ps.executeUpdate();
			DbUtils.closeConnection(conn,ps, null);
			if (rows > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Computer getComputerById(int comid){
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		Computer computer=null;
		try{
			String sql="select * from table_computer where comid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1,comid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Integer computerid=rs.getInt(1);
				String version=rs.getString(2);
				String classno=rs.getString(3);
				String condition=rs.getString(4);
				String appointment=rs.getString(5);
				String sno=rs.getString(6);
				String configuration=rs.getString(7);
				String software=rs.getString(8);
				String director=rs.getString(9);
				String comno=rs.getString(10);
				
				computer=new Computer();
				computer.setComid(computerid);
				computer.setVersion(version);
				computer.setClassno(classno);
				computer.setCondition(condition);
				computer.setAppointment(appointment);
				computer.setSno(sno);
				computer.setConfiguration(configuration);
				computer.setSoftware(software);
				computer.setDirector(director);
				computer.setComno(comno);
				
				break;
			}
			
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return computer;
	}
	public boolean updateComputer(Computer computer) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "update table_computer set version=?,classno=?,configuration=?,software=?,director=?,comno=? where comid=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, computer.getVersion());
			ps.setString(2, computer.getClassno());
			ps.setString(3, computer.getConfiguration());
			ps.setString(4, computer.getSoftware());
			ps.setString(5, computer.getDirector());
			ps.setString(6, computer.getComno());
			
			ps.setInt(7, computer.getComid());
			int rows = ps.executeUpdate();
			DbUtils.closeConnection(conn,ps,null);
			if(rows>0) {
				return true;
			}
		}catch(Exception e) {
			return false;
		}
		
		return false;
	}
	
	public String addComputer(Computer computer){
		int recordCount=0,count=0;
		Connection conn=DbUtils.getConnection();
		PreparedStatement ps=null;
		String sqlequal="select count(*) from table_computer where classno=? and comno in (select comno from table_computer where comno=? or comno='0'+?)";
		String sqlcount="select count(*) from table_computer where classno=?";
		String sql="insert into table_computer(version,classno,condition,appointment,sno,configuration,software,director,comno)values(?,?,'normal',NULL,NULL,?,?,?,?)";
		try{
			ps = conn.prepareStatement(sqlequal);
			ps.setString(1,computer.getClassno());
			ps.setString(2,computer.getComno());
			ps.setString(3,computer.getComno());
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1); // 总记录数
			}
			if(count>=1) {
				return "该机房已存在编号为"+computer.getComno()+"的电脑!";
			}
			ps = conn.prepareStatement(sqlcount);
			ps.setString(1,computer.getClassno());
			
			rs = ps.executeQuery();
			while (rs.next()) {
				recordCount = rs.getInt(1); // 总记录数
			}
			if(recordCount>=30) {
				return "机房内电脑数量以达到上限!";
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, computer.getVersion());
			ps.setString(2, computer.getClassno());
			ps.setString(3, computer.getConfiguration());
			ps.setString(4, computer.getSoftware());
			ps.setString(5, computer.getDirector());
			ps.setString(6, computer.getComno());
			
			int rows=ps.executeUpdate();
			
			DbUtils.closeConnection(conn,ps,null);
			if(rows>0){
				return "success";
			}
		}catch(SQLException e){
			return "添加失败!";
		}
		return "添加失败!";
	}
	
	public Computer repair(int comid){
		Connection conn=DbUtils.getConnection();
		PreparedStatement ps=null;
		Computer computer=null;
		String sql="update table_computer set condition=? where comid=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1,"damage");
			ps.setInt(2,comid);
			ResultSet rs = ps.executeQuery();
			
			int rows=ps.executeUpdate();
			
			DbUtils.closeConnection(conn,ps,rs);
			if(rows>0){
				return computer;
			}
		}catch(Exception e){
			return null;
		}
		return null;
	}
	
	public Computer normal(int comid){
		Connection conn=DbUtils.getConnection();
		PreparedStatement ps=null;
		Computer computer=null;
		String sql="update table_computer set condition=? where comid=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1,"normal");
			ps.setInt(2,comid);
			ResultSet rs = ps.executeQuery();
			
			int rows=ps.executeUpdate();
			
			DbUtils.closeConnection(conn,ps,rs);
			if(rows>0){
				return computer;
			}
		}catch(Exception e){
			return null;
		}
		return null;
	}
	
	public Page findPage(int pageNow, String queryType,String queryString) {
		// 总记录数
		int recordCount = 0;
		// 当前页面的具体数据集合
		List<Computer> recordList = new ArrayList<Computer>();

		Connection con = DbUtils.getConnection();
		PreparedStatement ps = null;
		try {
			// 统计SQL
			String sql = "";
			// 分页Sql
			String pageSql = "";
			
			// 精确查询
			if(queryType.equals("1")){
				sql = "select count(*) from table_computer where condition=?";
				pageSql = "SELECT TOP 5 * FROM table_computer where comid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " comid FROM table_computer where condition=? order by comid desc) and condition=? order by comid desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1,"normal");
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1); // 总记录数
				}
				
				ps = con.prepareStatement(pageSql);
				ps.setString(1, "normal");
				ps.setString(2, "normal");
				// 执行Sql查询
				rs = ps.executeQuery();
				// 如果存在数据
				while (rs.next()) {
					Integer comid = rs.getInt(1);
					String version = rs.getString(2);
					String classno = rs.getString(3);
					String condition = rs.getString(4);
					String appointment = rs.getString(5);
					String sno = rs.getString(6);
					String configuration=rs.getString(7);
					String software=rs.getString(8);
					String director=rs.getString(9);
					String comno=rs.getString(10);
					
					Computer computer=new Computer();
					computer.setComid(comid);
					computer.setVersion(version);
					computer.setClassno(classno);
					computer.setCondition(condition);
					computer.setAppointment(appointment);
					computer.setSno(sno);
					computer.setConfiguration(configuration);
					computer.setSoftware(software);
					computer.setDirector(director);
					computer.setComno(comno);

					recordList.add(computer);
				}
				// 关闭数据库连接，释放资源
				DbUtils.closeConnection(con,ps, rs);
			}
			else if(queryType.equals("2")){
				// 模糊查询
				sql = "select count(*) from table_computer where appointment = ?";
				pageSql = "SELECT TOP 5 * FROM table_computer where comid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " comid FROM table_computer where appointment = ? order by comid desc) and appointment = ? order by comid desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, "未预约");
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1); // 总记录数
				}
				
				ps = con.prepareStatement(pageSql);
				ps.setString(1, "未预约");
				ps.setString(2, "未预约");
				// 执行Sql查询
				rs = ps.executeQuery();
				// 如果存在数据
				while (rs.next()) {
					Integer comid = rs.getInt(1);
					String version = rs.getString(2);
					String classno = rs.getString(3);
					String condition = rs.getString(4);
					String appointment = rs.getString(5);
					String sno = rs.getString(6);
					String configuration=rs.getString(7);
					String software=rs.getString(8);
					String director=rs.getString(9);
					String comno=rs.getString(10);
					
					Computer computer=new Computer();
					computer.setComid(comid);
					computer.setVersion(version);
					computer.setClassno(classno);
					computer.setCondition(condition);
					computer.setAppointment(appointment);
					computer.setSno(sno);
					computer.setConfiguration(configuration);
					computer.setSoftware(software);
					computer.setDirector(director);
					computer.setComno(comno);

					recordList.add(computer);
				}
				// 关闭数据库连接，释放资源
				DbUtils.closeConnection(con,ps, rs);
			}
			else if(queryType.equals("0")){
				sql = "select count(*) from table_computer where classno=?";
				pageSql = "SELECT TOP 5 * FROM table_computer where comid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " comid FROM table_computer where classno=? order by comid desc) and classno=? order by comid desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, queryString);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1); // 总记录数
				}
				
				ps = con.prepareStatement(pageSql);
				ps.setString(1, queryString);
				ps.setString(2, queryString);
				// 执行Sql查询
				rs = ps.executeQuery();
				// 如果存在数据
				while (rs.next()) {
					Integer comid = rs.getInt(1);
					String version = rs.getString(2);
					String classno = rs.getString(3);
					String condition = rs.getString(4);
					String appointment = rs.getString(5);
					String sno = rs.getString(6);
					String configuration=rs.getString(7);
					String software=rs.getString(8);
					String director=rs.getString(9);
					String comno=rs.getString(10);
					
					Computer computer=new Computer();
					computer.setComid(comid);
					computer.setVersion(version);
					computer.setClassno(classno);
					computer.setCondition(condition);
					computer.setAppointment(appointment);
					computer.setSno(sno);
					computer.setConfiguration(configuration);
					computer.setSoftware(software);
					computer.setDirector(director);
					computer.setComno(comno);
					
					recordList.add(computer);
				}
				// 关闭数据库连接，释放资源
				DbUtils.closeConnection(con,ps, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Page page = new Page(pageNow, recordCount, recordList);
		return page;
	}

	
	public List<Computer> selByClassno(int classno){
		List<Computer> comList=new ArrayList<Computer>();
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		Computer computer=null;
		try{
			String sql="select * from table_computer where classno=?";
		
			ps = con.prepareStatement(sql);
			ps.setInt(1,classno);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Integer comid=rs.getInt(1);
				String version=rs.getString(2);
				String classnumber=rs.getString(3);
				String condition=rs.getString(4);
				String appointment=rs.getString(5);
				String sno=rs.getString(6);
				
				computer=new Computer();
				computer.setComid(comid);
				computer.setVersion(version);
				computer.setClassno(classnumber);
				computer.setCondition(condition);
				computer.setAppointment(appointment);
				computer.setSno(sno);
				
				
				comList.add(computer);
			}
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return comList;
	}
	
	public Computer appointment(int comid,String sno){
		Connection conn=DbUtils.getConnection();
		PreparedStatement ps=null;
		Computer computer=null;
		String sql="update table_computer set appointment=?,sno=? where comid=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1,"已预约");
			ps.setString(2, sno);
			ps.setInt(3,comid);
			ResultSet rs = ps.executeQuery();
			
			int rows=ps.executeUpdate();
			
			DbUtils.closeConnection(conn,ps,rs);
			if(rows>0){
				return computer;
			}
		}catch(Exception e){
			return null;
		}
		return null;
	}
	public int judge(String sno){
		Connection conn=DbUtils.getConnection();
		PreparedStatement ps=null;
		int rows=0;
		String sql="SELECT count(*) FROM table_computer where sno=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				rows=rs.getInt(1);
			}
						
			DbUtils.closeConnection(conn,ps,rs);
			if(rows>0){
				return 1;
			}
			else 
				return 0;
		}catch(Exception e){
			return 1;
		}
	}
	public Appoint vieworder(String sno){
		Connection conn=DbUtils.getConnection();
		PreparedStatement ps=null;
		Appoint appoint=new Appoint();
		String sql="select * from table_appoint where no=?";
		int rows = 0;
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Integer appointid=rs.getInt(1);
				String no=rs.getString(2);
				String classno=rs.getString(3);
				String comno=rs.getString(4);
				String astime=rs.getString(5);
				String time=rs.getString(6);
				if(astime.length()>8) {
					astime=astime.substring(0,astime.length() - 8);
				}
				
				
				appoint.setAppointid(appointid);
				appoint.setNo(no);
				appoint.setClassno(classno);
				appoint.setComno(comno);
				appoint.setAstime(astime);
				appoint.setTime(time);
				rows++;
				break;
			}
		
			DbUtils.closeConnection(conn,ps,rs);
			if(rows>0){
				return appoint;
			}
			else 
				return null;
				
		}catch(Exception e){
			return null;
		}
	}
	public Appoint cancel(String sno){
		Connection conn=DbUtils.getConnection();
		PreparedStatement ps=null;
		Appoint appoint=null;
		String sql="delete table_appoint where no=?";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1,sno);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Integer appointid=rs.getInt(1);
				String no=rs.getString(2);
				String classno=rs.getString(3);
				String comno=rs.getString(4);
				String astime=rs.getString(5);
				String time=rs.getString(6);
				
				appoint.setAppointid(appointid);
				appoint.setNo(no);
				appoint.setClassno(classno);
				appoint.setComno(comno);
				appoint.setAstime(astime);
				appoint.setTime(time);
				break;
			}
			
			int rows=ps.executeUpdate();
			
			
			DbUtils.closeConnection(conn,ps,rs);
			if(rows>0){
				return appoint;
			}
			else 
				return null;
		}catch(Exception e){
			return null;
		}
	}
	public boolean write_log(String no,String username,String ip){
		Connection conn=DbUtils.getConnection();
		PreparedStatement ps=null;
		String sql="insert into table_log(no,username,intime,outtime,ip) values(?,?,getdate(),DATEADD(mi,30,getdate()),?)";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, no);
			ps.setString(2, username);
			ps.setString(3, ip);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
			DbUtils.closeConnection(conn,ps,rs);
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean outime_log(String no){
		Connection conn=DbUtils.getConnection();
		PreparedStatement ps=null;
		String sql="update table_log set outtime=getdate() where logid=(select top 1 logid from table_log where no=? order by logid desc)";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, no);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				return true;
			}
			DbUtils.closeConnection(conn,ps,rs);
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	public List<Appoint> find_appoint(String classno,String comno){
		List<Appoint> list=new ArrayList<Appoint>();
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		Appoint appoint=null;
		try{
			String sql="select * from table_appoint where classno=? and comno=?";
		
			ps = con.prepareStatement(sql);
			ps.setString(1,classno);
			ps.setString(2, comno);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Integer appointid=rs.getInt(1);
				String no=rs.getString(2);
				String classn=rs.getString(3);
				String comn=rs.getString(4);
				String astime=rs.getString(5);
				String time=rs.getString(6);
				
				appoint=new Appoint();
				appoint.setAppointid(appointid);;
				appoint.setNo(no);
				appoint.setClassno(classn);
				appoint.setComno(comn);
				appoint.setAstime(astime);
				appoint.setTime(time);
				
				
				list.add(appoint);
			}
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return list;
	}
	public List<String> findclssnobyid(int comid) {
		List<String> l=new ArrayList<String>();
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		try{
			String sql="select * from table_computer where comid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1,comid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Integer computerid=rs.getInt(1);
				String version=rs.getString(2);
				String classno=rs.getString(3);
				String condition=rs.getString(4);
				String appointment=rs.getString(5);
				String sno=rs.getString(6);
				String configuration=rs.getString(7);
				String software=rs.getString(8);
				String director=rs.getString(9);
				String comno=rs.getString(10);
				
				l.add(classno);
				l.add(comno);
								
				break;
			}
			
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return l;
	}
	public Computer getComputerByNo(String classn,String com){
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		Computer computer=null;
		try{
			String sql="select * from table_computer where classno=? and comno=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,classn);
			ps.setString(2, com);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Integer computerid=rs.getInt(1);
				String version=rs.getString(2);
				String classno=rs.getString(3);
				String condition=rs.getString(4);
				String appointment=rs.getString(5);
				String sno=rs.getString(6);
				String configuration=rs.getString(7);
				String software=rs.getString(8);
				String director=rs.getString(9);
				String comno=rs.getString(10);
				
				computer=new Computer();
				computer.setComid(computerid);
				computer.setVersion(version);
				computer.setClassno(classno);
				computer.setCondition(condition);
				computer.setAppointment(appointment);
				computer.setSno(sno);
				computer.setConfiguration(configuration);
				computer.setSoftware(software);
				computer.setDirector(director);
				computer.setComno(comno);
				
				break;
			}
			
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return computer;
	}
	public Appoint setappoint(String sno, String classno, String comno, String astime, String time) {
		Connection conn=DbUtils.getConnection();
		PreparedStatement ps=null;
		Appoint appoint=null;
		String sql="insert into table_appoint values(?,?,?,?,?)";
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1,sno);
			ps.setString(2,classno);
			ps.setString(3,comno);
			ps.setString(4,astime);
			ps.setString(5,time);
			ResultSet rs = ps.executeQuery();
			
			int rows=ps.executeUpdate();
			
			DbUtils.closeConnection(conn,ps,rs);
			if(rows>0){
				return appoint;
			}
		}catch(Exception e){
			return null;
		}
		return null;
	} 
	public Use startgo(String no, String username, String classno, String comno) {
		Connection conn=DbUtils.getConnection();
		PreparedStatement ps=null;
		Use use=null;
		try{
			String sql ="insert into table_use(comid,no,username,classno,stime,comno) values(?,?,?,?,getdate(),?)";
			String sql1="update table_computer set appointment=?,sno=? where classno=? and comno=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(classno+comno));
			ps.setString(2,no);
			ps.setString(3,username);
			ps.setString(4,classno);
			ps.setString(5,comno);
			
			int rows=ps.executeUpdate();
			
			ps = conn.prepareStatement(sql1);
			ps.setString(1,"正在上机");
			ps.setString(2,no);
			ps.setString(3,classno);
			ps.setString(4,comno);
			int row1=ps.executeUpdate();
			
			DbUtils.closeConnection(conn,ps,null);
			if(rows>0){
				return use;
			}
		}catch(Exception e){
			return null;
		}
		return null;
	} 
	
	public boolean stopgo(String no,String classno,String comno) {
		Connection conn=DbUtils.getConnection();
		PreparedStatement ps=null;
		try{			
			String sql="update table_use set etime=getdate() where useid=(select top 1 useid from table_use where no=? order by useid desc)";
			String sql1="update table_user set utime=utime+(select datediff( minute, stime, etime ) from table_use where useid=(select top 1 useid from table_use where no=? order by useid desc))where no=?";
			String sql2="delete table_appoint where no=?";
			String sql3="update table_computer set appointment=NULL,sno=NULL where classno=? and comno=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, no);
			int row2=ps.executeUpdate();
			
			ps = conn.prepareStatement(sql1);
			ps.setString(1, no);
			ps.setString(2, no);
			int row=ps.executeUpdate();

			ps = conn.prepareStatement(sql2);
			ps.setString(1, no);
			int row1=ps.executeUpdate();

			ps = conn.prepareStatement(sql3);
			ps.setString(1,classno);
			ps.setString(2,comno);
			int row3=ps.executeUpdate();
			while(row2>0)
			{
				return true;
			}
			DbUtils.closeConnection(conn,ps,null);
			
		}catch(Exception e){
			return false;
		}
		return true;
	}
	

}

