package com.jf.jadmin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jf.Computer;
import com.jf.DbUtils;
import com.jf.Page;
import com.jf.StringUtil;
import com.jf.User;
import com.jf.sadmin.UserService_sadmin;

public class UserService_jadmin {
	
	public Page findPage(int pageNow, String queryType,String queryString,String queryString2) {
		// 总记录数
		int recordCount = 0;
		// 当前页面的具体数据集合
		List<Use> recordList = new ArrayList<Use>();

		Connection con = DbUtils.getConnection();
		PreparedStatement ps = null;
		try {
			// 统计SQL
			String sql = "";
			// 分页Sql
			String pageSql = "";
			
			// 精确查询
			if(queryType.equals("1")){
				sql = "select count(*) from table_use";
				pageSql = "SELECT TOP 5 * FROM table_use where useid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " useid FROM table_use order by useid desc) order by useid desc";
				
				ps = con.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1); // 总记录数
				}
				
				ps = con.prepareStatement(pageSql);
				// 执行Sql查询
				rs = ps.executeQuery();
				// 如果存在数据
				while (rs.next()) {
					Integer useid = rs.getInt(1);
					Integer comid = rs.getInt(2);
					String no = rs.getString(3);
					String username = rs.getString(4);
					String classno = rs.getString(5);
					String stime = rs.getString(6);
					String etime=rs.getString(7);
					String comno=rs.getString(8);
					if(etime.length()>8) {
						etime=etime.substring(0,etime.length() - 8);
					}
					if(stime.length()>8) {
						stime=stime.substring(0,stime.length() - 8);
					}
					
					
					
					Use use=new Use();
					use.setUseid(useid);
					use.setComid(comid);
					use.setNo(no);
					use.setUsername(username);
					use.setClassno(classno);
					use.setStime(stime);
					use.setEtime(etime);
					use.setComno(comno);

					recordList.add(use);
				}
				// 关闭数据库连接，释放资源
				DbUtils.closeConnection(con,ps, rs);
			}else if(queryType.equals("2")){
				// 模糊查询
				sql = "select count(*) from table_use where classno = ?";
				pageSql = "SELECT TOP 5 * FROM table_use where useid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " useid FROM table_use where classno = ? order by useid desc) and classno = ? order by useid desc";
				
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
					Integer useid = rs.getInt(1);
					Integer comid = rs.getInt(2);
					String no = rs.getString(3);
					String username = rs.getString(4);
					String classno = rs.getString(5);
					String stime = rs.getString(6);
					String etime=rs.getString(7);
					String comno=rs.getString(8);
					if(etime.length()>8) {
						etime=etime.substring(0,etime.length() - 8);
					}
					if(stime.length()>8) {
						stime=stime.substring(0,stime.length() - 8);
					}
					
					Use use=new Use();
					use.setUseid(useid);
					use.setComid(comid);
					use.setNo(no);
					use.setUsername(username);
					use.setClassno(classno);
					use.setStime(stime);
					use.setEtime(etime);
					use.setComno(comno);

					recordList.add(use);
				}
				// 关闭数据库连接，释放资源
				DbUtils.closeConnection(con,ps, rs);
			}else if(queryType.equals("3")){
				sql = "select count(*) from table_use where no=?";
				pageSql = "SELECT TOP 5 * FROM table_use where useid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " useid FROM table_use where no=? order by useid desc) and no=? order by useid desc";
				
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
					Integer useid = rs.getInt(1);
					Integer comid = rs.getInt(2);
					String no = rs.getString(3);
					String username = rs.getString(4);
					String classno = rs.getString(5);
					String stime = rs.getString(6);
					String etime=rs.getString(7);
					String comno=rs.getString(8);
					if(etime.length()>8) {
						etime=etime.substring(0,etime.length() - 8);
					}
					if(stime.length()>8) {
						stime=stime.substring(0,stime.length() - 8);
					}
					
					Use use=new Use();
					use.setUseid(useid);
					use.setComid(comid);
					use.setNo(no);
					use.setUsername(username);
					use.setClassno(classno);
					use.setStime(stime);
					use.setEtime(etime);
					use.setComno(comno);

					recordList.add(use);
				}
				// 关闭数据库连接，释放资源
				DbUtils.closeConnection(con,ps, rs);
			}else if(queryType.equals("4")){
				// 模糊查询
				sql = "select count(*) from table_use where classno = ? and comno=?";
				pageSql = "SELECT TOP 5 * FROM table_use where useid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " useid FROM table_use where classno = ? and comno=? order by useid desc) and classno = ? and comno=? order by useid desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, queryString);
				ps.setString(2, queryString2);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1); // 总记录数
				}
				
				ps = con.prepareStatement(pageSql);
				ps.setString(1, queryString);
				ps.setString(2, queryString2);
				ps.setString(3, queryString);
				ps.setString(4, queryString2);
				// 执行Sql查询
				rs = ps.executeQuery();
				// 如果存在数据
				while (rs.next()) {
					Integer useid = rs.getInt(1);
					Integer comid = rs.getInt(2);
					String no = rs.getString(3);
					String username = rs.getString(4);
					String classno = rs.getString(5);
					String stime = rs.getString(6);
					String etime=rs.getString(7);
					String comno=rs.getString(8);
					if(etime.length()>8) {
						etime=etime.substring(0,etime.length() - 8);
					}
					if(stime.length()>8) {
						stime=stime.substring(0,stime.length() - 8);
					}
					
					Use use=new Use();
					use.setUseid(useid);
					use.setComid(comid);
					use.setNo(no);
					use.setUsername(username);
					use.setClassno(classno);
					use.setStime(stime);
					use.setEtime(etime);
					use.setComno(comno);

					recordList.add(use);
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
	
	
	public Page findRepairPage(int pageNow, String queryType,String queryString,String queryString2) {
		// 总记录数
		int recordCount = 0;
		// 当前页面的具体数据集合
		List<Repair> recordList = new ArrayList<Repair>();

		Connection con = DbUtils.getConnection();
		PreparedStatement ps = null;
		try {
			// 统计SQL
			String sql = "";
			// 分页Sql
			String pageSql = "";
			
			// 精确查询
			if(queryType.equals("1")){
				sql = "select count(*) from table_repair";
				pageSql = "SELECT TOP 5 * FROM table_repair where repairid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " repairid FROM table_repair order by repairid desc) order by repairid desc";
				
				ps = con.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1); // 总记录数
				}
				
				ps = con.prepareStatement(pageSql);
				// 执行Sql查询
				rs = ps.executeQuery();
				// 如果存在数据
				while (rs.next()) {
					Integer repairid = rs.getInt(1);
					String comno = rs.getString(2);
					String classno = rs.getString(3);
					String rstime = rs.getString(4);
					String retime = rs.getString(5);
					if(retime.length()>8) {
						retime=retime.substring(0,retime.length() - 8);
					}
					if(rstime.length()>8) {
						rstime=rstime.substring(0,rstime.length() - 8);
					}
					
					Repair repair=new Repair();
					repair.setRepairid(repairid);
					repair.setComno(comno);
					repair.setClassno(classno);
					repair.setRstime(rstime);
					repair.setRetime(retime);

					recordList.add(repair);
				}
				// 关闭数据库连接，释放资源
				DbUtils.closeConnection(con,ps, rs);
			}else if(queryType.equals("2")){
				// 模糊查询
				sql = "select count(*) from table_repair where classno = ?";
				pageSql = "SELECT TOP 5 * FROM table_repair where repairid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " repairid FROM table_repair where classno = ? order by repairid desc) and classno = ? order by repairid desc";
				
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
					Integer repairid = rs.getInt(1);
					String comno = rs.getString(2);
					String classno = rs.getString(3);
					String rstime = rs.getString(4);
					String retime = rs.getString(5);
					if(retime.length()>8) {
						retime=retime.substring(0,retime.length() - 8);
					}
					if(rstime.length()>8) {
						rstime=rstime.substring(0,rstime.length() - 8);
					}
					
					Repair repair=new Repair();
					repair.setRepairid(repairid);
					repair.setComno(comno);
					repair.setClassno(classno);
					repair.setRstime(rstime);
					repair.setRetime(retime);

					recordList.add(repair);
				}
				// 关闭数据库连接，释放资源
				DbUtils.closeConnection(con,ps, rs);
			}else if(queryType.equals("4")){
				// 模糊查询
				sql = "select count(*) from table_repair where classno = ? and comno=?";
				pageSql = "SELECT TOP 5 * FROM table_repair where repairid not in ( SELECT TOP " + (pageNow - 1) * 5
						+ " repairid FROM table_repair where classno = ? and comno=? order by repairid desc) and classno = ? and comno=? order by repairid desc";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, queryString);
				ps.setString(2, queryString2);
				
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					recordCount = rs.getInt(1); // 总记录数
				}
				
				ps = con.prepareStatement(pageSql);
				ps.setString(1, queryString);
				ps.setString(2, queryString2);
				ps.setString(3, queryString);
				ps.setString(4, queryString2);
				// 执行Sql查询
				rs = ps.executeQuery();
				// 如果存在数据
				while (rs.next()) {
					Integer repairid = rs.getInt(1);
					String comno = rs.getString(2);
					String classno = rs.getString(3);
					String rstime = rs.getString(4);
					String retime = rs.getString(5);
					if(retime.length()>8) {
						retime=retime.substring(0,retime.length() - 8);
					}
					if(rstime.length()>8) {
						rstime=rstime.substring(0,rstime.length() - 8);
					}
					
					Repair repair=new Repair();
					repair.setRepairid(repairid);
					repair.setComno(comno);
					repair.setClassno(classno);
					repair.setRstime(rstime);
					repair.setRetime(retime);

					recordList.add(repair);
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

	
	//通过教室号查看电脑
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
				String configura=rs.getString(7);
				String software=rs.getString(8);
				String director=rs.getString(9);
				String comno=rs.getString(10);
				
				computer=new Computer();
				computer.setComid(comid);
				computer.setVersion(version);
				computer.setClassno(classnumber);
				computer.setCondition(condition);
				computer.setAppointment(appointment);
				computer.setSno(sno);
				computer.setConfiguration(configura);
				computer.setSoftware(software);
				computer.setDirector(director);
				computer.setComno(comno);
				
				
				comList.add(computer);
			}
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return comList;
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
	public boolean deleteAllComputer(String classno) {
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from table_computer where classno=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, classno);
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
	public Boolean repairTime(Computer computer){
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into table_repair (comno,classno,rstime) values(?,?,getdate())";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, computer.getComno());
			ps.setString(2, computer.getClassno());
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
	
	public Boolean normalTime(Computer computer){
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "update table_repair set retime=getdate() where comno=? and classno=? and retime is null";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, computer.getComno());
			ps.setString(2, computer.getClassno());
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
	public String chargeCondition(int comid){
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		String condition = null;
		try{
			String sql="select condition from table_computer where comid=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1,comid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				condition=rs.getString(1);
				break;
			}
			
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return condition;
	}
	public String getTypeByNo(String classno2){
		String type=null;
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		try{
			String sql="select type from table_computer where classno=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,classno2);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				type=rs.getString(1);
				
				break;
			}
			
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return type;
	}
	
	public Boolean alterType(String type,String classno){
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "update table_computer set type=? where classno=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ps.setString(2, classno);
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
	public List<Computer> getRepairTime(String queryString){
		List<Computer> recordList = new ArrayList<Computer>();
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		String sql="";
		String s="";
		ResultSet rs = null ;
		try{
			for(int i=1;i<=30;i++) {
			sql="select count(*),sum(datediff( second, rstime, retime )) from table_repair where classno="+queryString+" and comno=? and rstime>dateadd(month,-1,getdate())";
			ps = con.prepareStatement(sql);
			ps.setInt(1,i);
			rs = ps.executeQuery();
			while (rs.next()) {
				Integer repairnum = rs.getInt(1);
				Integer repairtime = rs.getInt(2);
				if (repairtime == null || repairtime.equals("")) {
					repairtime = 0;
				}

				Computer computer=new Computer();
				computer.setRepairnum(repairnum);
				computer.setClassno(queryString);
				computer.setComno(i+"");
				computer.setRepairtime(repairtime/3600);

				recordList.add(computer);
			}
			}
			
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return recordList;
	}
	public List<String> selsno(String classno,String comno){
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		List<String> l=new ArrayList<String>();
		String sno = null;
		try{
			String sql="select no from table_appoint where classno=? and comno=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,classno);
			ps.setString(2, comno);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				if(!rs.getString(1).equals("被限制时段")) {
				sno=rs.getString(1);
				l.add(sno);
				}
			}
			
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return l;
	}
	public List<String> selphone(List<String>  sno){
		Connection con=DbUtils.getConnection();
		PreparedStatement ps=null;
		ResultSet rs =null;
		List<String> l=new ArrayList<String>();
		String phone = null;
		try{
			for(int i=0;i<sno.size();i++){
				String sql="select telephone from table_user where no=?";
				ps = con.prepareStatement(sql);
				ps.setString(1,sno.get(i));
				rs = ps.executeQuery();
				while(rs.next())
				{
					phone=rs.getString(1);
					l.add(phone);
				}
			}
			DbUtils.closeConnection(con,ps,rs);
			}catch(SQLException e){
				e.printStackTrace();
			}
		return l;
	}
	public boolean leading_com(List<Computer> a){
		Connection conn = DbUtils.getConnection();
		PreparedStatement ps = null;
		for(int i=0;i<a.size();i++){
			String sql = "insert into table_computer (version,classno,condition,appointment,sno,configuration,software,director,comno) values(?,?,?,?,?,?,?,?,?)";
			try {
				Computer computer=a.get(i);
				ps = conn.prepareStatement(sql);
				ps.setString(1, computer.getVersion());
				ps.setString(2, computer.getClassno());
				ps.setString(3, computer.getCondition());
				ps.setString(4, computer.getAppointment());
				ps.setString(5, computer.getSno());
				ps.setString(6, computer.getConfiguration());
				ps.setString(7, computer.getSoftware());
				ps.setString(8, computer.getDirector());
				ps.setString(9, computer.getComno());
				int rows = ps.executeUpdate();
				rows++;			
				if(rows==a.size()) {
					return true;
				}
				}catch(SQLException e) {
					return false;
				}
		}
		DbUtils.closeConnection(conn,ps,null);
		return false;
	}
	
}
