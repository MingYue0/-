package com.jf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jf.Page;
import com.jf.UserService;
import com.jf.jadmin.UserService_jadmin;
import com.jf.StringUtil;
import com.jf.User;

/**
 * Servlet implementation class ManagerServlet
 */
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		request.setAttribute("method", method);
		//order
		if("find".equals(method)){
			find(request,response);
		}
		else if("menu_admin".equals(method)){
			menu_admin(request,response);
		}else if("menu_sadmin".equals(method)){
			menu_sadmin(request,response);
		}
		else if("add2".equals(method)){
			add(request,response);
		}
		else if("list".equals(method)){
			list(request,response);
		}
		else if ("find".equals(method)) {
			find(request, response);
		}
		else if ("delete1".equals(method)) {
			delete1(request, response);
		}
		else if ("delete2".equals(method)) {
			delete2(request, response);
		}
		else if ("edit1".equals(method)) {
			edit1(request, response);
		}
		else if ("edit2".equals(method)) {
			edit2(request, response);
		}
		else if("list1".equals(method)){
			list1(request,response);
		}
		else if("list2".equals(method)){
			list2(request,response);
		}
		else if("repair".equals(method)){
			repair(request,response);
		}
		else if("normal".equals(method)){
			normal(request,response);
		}
		else if ("findList".equals(method)) {
			findList(request, response);
		}
		else if ("register".equals(method)) {
			register(request, response);
		}
		else if ("edit_adpassword".equals(method)) {
			edit_adpassword(request, response);
		}


	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println(method);
		boolean success = false;
		String tip=null;
		if (method.equals("add2")) {
			String comid = request.getParameter("comid");
			String version = new String(request.getParameter("version").getBytes("iso8859-1"), "utf-8");
			String classno = new String(request.getParameter("classno").getBytes("iso8859-1"), "utf-8");
			String comno = new String(request.getParameter("comno").getBytes("iso8859-1"), "utf-8");
			String configuration=new String(request.getParameter("configuration").getBytes("iso8859-1"), "utf-8");
			String software=new String(request.getParameter("software").getBytes("iso8859-1"), "utf-8");
			String director=new String(request.getParameter("director").getBytes("iso8859-1"), "utf-8");

			Computer computer = new Computer();
			if (StringUtil.isNotEmpty(comid)) {
				computer.setComid(Integer.parseInt(comid));
			}
			
			computer.setVersion(version);
			computer.setClassno(classno);
			computer.setConfiguration(configuration);
			computer.setSoftware(software);
			computer.setDirector(director);
			computer.setComno(comno);
			tip = new UserService().addComputer(computer);
			if (tip.equals("success")) {
				response.sendRedirect("/jfManager/ManagerServlet?method=list2");
				return;
			} else {
				request.setAttribute("message", tip);
				request.setAttribute("computer", computer);
				request.setAttribute("method", method);
				request.getRequestDispatcher("/WEB-INF/jsp/add2.jsp").forward(request, response);
			}

		} 
		//edit_stu
		if (method.equals("edit1")) {
			String id = request.getParameter("id");
			String username = new String(request.getParameter("username").getBytes("iso8859-1"), "utf-8");
			String password = new String(request.getParameter("password").getBytes("iso8859-1"), "utf-8");
			String no = new String(request.getParameter("no").getBytes("iso8859-1"), "utf-8");
			String name = new String(request.getParameter("name").getBytes("iso8859-1"), "utf-8");
			String sex = request.getParameter("sex");
			if (StringUtil.isNotEmpty(sex)) {
				sex = new String(request.getParameter("sex").getBytes("iso8859-1"), "utf-8");
			}
			String department = new String(request.getParameter("department").getBytes("iso8859-1"), "utf-8");
			String telephone = new String(request.getParameter("telephone").getBytes("iso8859-1"), "utf-8");
			String email = new String(request.getParameter("email").getBytes("iso8859-1"), "utf-8");
			String usertype = request.getParameter("usertype");
			if (StringUtil.isNotEmpty(usertype)) {
				usertype = new String(request.getParameter("usertype").getBytes("iso8859-1"), "utf-8");
			}
			

			User user = new User();
			if (StringUtil.isNotEmpty(id)) {
				user.setId(Integer.parseInt(id));
			}
			user.setUsername(username);
			user.setPassword(password);
			user.setNo(no);
			user.setName(name);
			user.setSex(sex);
			user.setDepartment(department);
			user.setTelephone(telephone);
			user.setEmail(email);
			user.setUsertype(usertype);
			success = new UserService().updateUser(user);
			if (success) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser",user);
				response.sendRedirect("/jfManager/MenuServlet");
				return;
			} else {
				request.setAttribute("message", "操作失败！");
				request.setAttribute("user", user);
				request.setAttribute("method", method);
				request.getRequestDispatcher("/WEB-INF/jsp/add1.jsp").forward(request, response);
			}
		}
		if (method.equals("edit2")) {
			String comid = request.getParameter("comid");
			String version = new String(request.getParameter("version").getBytes("iso8859-1"), "utf-8");
			String classno = new String(request.getParameter("classno").getBytes("iso8859-1"), "utf-8");
			String comno = new String(request.getParameter("comno").getBytes("iso8859-1"), "utf-8");
			String configuration=new String(request.getParameter("configuration").getBytes("iso8859-1"), "utf-8");
			String software=new String(request.getParameter("software").getBytes("iso8859-1"), "utf-8");
			String director=new String(request.getParameter("director").getBytes("iso8859-1"), "utf-8");

			Computer computer = new Computer();
			if (StringUtil.isNotEmpty(comid)) {
				computer.setComid(Integer.parseInt(comid));
			}
			
			computer.setVersion(version);
			computer.setClassno(classno);
			computer.setConfiguration(configuration);
			computer.setSoftware(software);
			computer.setDirector(director);
			computer.setComno(comno);
			success = new UserService().updateComputer(computer);
			if (success) {
				response.sendRedirect("/jfManager/ManagerServlet?method=list2");
				return;
			} else {
				request.setAttribute("message", "操作失败！");
				request.setAttribute("computer", computer);
				request.setAttribute("method", method);
				request.getRequestDispatcher("/WEB-INF/jsp/add2.jsp").forward(request, response);
			}

		}
		if (method.equals("register")) {
			String id = request.getParameter("id");
			String username = new String(request.getParameter("username").getBytes("iso8859-1"), "utf-8");
			String password = new String(request.getParameter("password").getBytes("iso8859-1"), "utf-8");
			String no = new String(request.getParameter("no").getBytes("iso8859-1"), "utf-8");
			String name = new String(request.getParameter("name").getBytes("iso8859-1"), "utf-8");
			String sex = request.getParameter("sex");
			if (StringUtil.isNotEmpty(sex)) {
				sex = new String(request.getParameter("sex").getBytes("iso8859-1"), "utf-8");
			}
			String department = new String(request.getParameter("department").getBytes("iso8859-1"), "utf-8");
			String telephone = new String(request.getParameter("telephone").getBytes("iso8859-1"), "utf-8");
			String email = new String(request.getParameter("email").getBytes("iso8859-1"), "utf-8");
			String usertype = request.getParameter("usertype");
			if (StringUtil.isNotEmpty(usertype)) {
				usertype = new String(request.getParameter("usertype").getBytes("iso8859-1"), "utf-8");
			}
			User user = new User();
			if (StringUtil.isNotEmpty(id)) {
				user.setId(Integer.parseInt(id));
			}
			user.setUsername(username);
			user.setPassword(password);
			user.setNo(no);
			user.setName(name);
			user.setSex(sex);
			user.setDepartment(department);
			user.setTelephone(telephone);
			user.setEmail(email);
			user.setUsertype(usertype);
			success = new UserService().addUser(user);
			if (success) {
				response.sendRedirect("/jfManager/LoginServlet");
				return;
			} else {
				request.setAttribute("message", "操作失败！");
				request.setAttribute("user", user);
				request.setAttribute("method",method );
				request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			}
		}
		//edit_password
		if (method.equals("edit_adpassword")) {
			String id = request.getParameter("id");
			String username = new String(request.getParameter("username").getBytes("iso8859-1"), "utf-8");
			String password = new String(request.getParameter("password").getBytes("iso8859-1"), "utf-8");
			String no = new String(request.getParameter("no").getBytes("iso8859-1"), "utf-8");
			String name = new String(request.getParameter("name").getBytes("iso8859-1"), "utf-8");
			String sex = request.getParameter("sex");
			if (StringUtil.isNotEmpty(sex)) {
				sex = new String(request.getParameter("sex").getBytes("iso8859-1"), "utf-8");
			}
			String department = new String(request.getParameter("department").getBytes("iso8859-1"), "utf-8");
			String telephone = new String(request.getParameter("telephone").getBytes("iso8859-1"), "utf-8");
			String email = new String(request.getParameter("email").getBytes("iso8859-1"), "utf-8");
			String usertype = request.getParameter("usertype");
			if (StringUtil.isNotEmpty(usertype)) {
				usertype = new String(request.getParameter("usertype").getBytes("iso8859-1"), "utf-8");
			}
			

			User user = new User();
			if (StringUtil.isNotEmpty(id)) {
				user.setId(Integer.parseInt(id));
			}
			user.setUsername(username);
			user.setPassword(password);
			user.setNo(no);
			user.setName(name);
			user.setSex(sex);
			user.setDepartment(department);
			user.setTelephone(telephone);
			user.setEmail(email);
			user.setUsertype(usertype);
			success = new UserService().updateUser(user);
			if (success) {
				response.sendRedirect("/jfManager/LoginServlet");
				return;
			} else {
				request.setAttribute("message", "操作失败！");
				request.setAttribute("user", user);
				request.setAttribute("method", method);
				request.getRequestDispatcher("/WEB-INF/jsp/edit_adpassword.jsp").forward(request, response);
			}
		}

		
		
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setAttribute("method", "register");
	    request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
	}

	//查看预约电脑
	private void find(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/find.jsp").forward(request, response);
	}
	private void menu_admin(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/menu_admin.jsp").forward(request, response);
	}
	private void menu_sadmin(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/menu_sadmin.jsp").forward(request, response);
	}
	//menu_stu
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("user", new User());
		request.setAttribute("method", "add2");
		request.getRequestDispatcher("/WEB-INF/jsp/add2.jsp").forward(request, response);
	}
	
	private void delete1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 第一步：获取需要删除的用户ID
		String id = request.getParameter("id");
		if (StringUtil.isEmpty(id)) {
			return;
		}
		// 第二步：链接数据库，执行删除操作
		new UserService().deleteUserById(Integer.parseInt(id));
		// 第三步：删除成功，跳转到列表页面
		response.sendRedirect("/jfManager/ManagerServlet?method=list1");
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// 查询数据库，获取所有的用户表中的数据，并且封装成List<User>对象
				request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}
	
	private void list1(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// 查询数据库，获取所有的用户表中的数据，并且封装成List<User>对象
				// List<User> userList = new UserService().getUserList();
				String pageNow = request.getParameter("pageNow");
				// 当用户没有pageNow参数，则设置一个默认值
				if (pageNow == null || pageNow.equals("")) {
					pageNow = "1";
				}
				Page page = new UserService().getPage(Integer.parseInt(pageNow));
				// 将集合数据放到Request中，以供list.jsp中使用
				// request.setAttribute("userList", userList);
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/jsp/list1.jsp").forward(request, response);
	}
	
	private void list2(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// 查询数据库，获取所有的用户表中的数据，并且封装成List<User>对象
				// List<User> userList = new UserService().getUserList();
				String pageNow = request.getParameter("pageNow");
				// 当用户没有pageNow参数，则设置一个默认值
				if (pageNow == null || pageNow.equals("")) {
					pageNow = "1";
				}
				Page page = new UserService().getCPage(Integer.parseInt(pageNow));
				// 将集合数据放到Request中，以供list.jsp中使用
				// request.setAttribute("userList", userList);
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/jsp/list2.jsp").forward(request, response);
	}
	
	//edit_stu
	
	private void edit1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User user = new UserService().getUserById(Integer.parseInt(id));
		request.setAttribute("user", user);
		request.setAttribute("method", "edit1");
		request.getRequestDispatcher("/WEB-INF/jsp/add1.jsp").forward(request, response);
	}
	
	private void edit2(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String comid =request.getParameter("comid");
		Computer computer=new UserService().getComputerById(Integer.parseInt(comid));
		request.setAttribute("computer", computer);
		request.setAttribute("method", "edit2");
		request.getRequestDispatcher("/WEB-INF/jsp/add2.jsp").forward(request, response);
	}

	private void repair(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String comid =request.getParameter("comid");
		String condition=new UserService_jadmin().chargeCondition(Integer.parseInt(comid));
		Computer computer=new UserService().repair(Integer.parseInt(comid));
		request.setAttribute("computer", computer);
		System.out.println(condition);
		if(condition.equals("normal")) {
			computer=new UserService_jadmin().getComputerById(Integer.parseInt(comid));
			Boolean success= new UserService_jadmin().repairTime(computer);
		}
		String pageNow=request.getParameter("pageNow");
		
		if(pageNow==null||pageNow.equals("")){
			pageNow="1";
		}
		Page page=new UserService().getCPage(Integer.parseInt(pageNow));
		
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/WEB-INF/jsp/list2.jsp").forward(request, response);
	}
	
	private void delete2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 第一步：获取需要删除的用户ID
		String comid = request.getParameter("comid");
		if (StringUtil.isEmpty(comid)) {
			return;
		}
		// 第二步：链接数据库，执行删除操作
		new UserService().deleteComputerById(Integer.parseInt(comid));
		// 第三步：删除成功，跳转到列表页面
		response.sendRedirect("/jfManager/ManagerServlet?method=list2");
	}
	
	private void normal(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String comid =request.getParameter("comid");
		String condition=new UserService_jadmin().chargeCondition(Integer.parseInt(comid));
		Computer computer=new UserService().normal(Integer.parseInt(comid));
		request.setAttribute("computer", computer);
		System.out.println(condition);
		if(condition.equals("damage")) {
			computer=new UserService_jadmin().getComputerById(Integer.parseInt(comid));
			Boolean success= new UserService_jadmin().normalTime(computer);
		}
		String pageNow=request.getParameter("pageNow");
		
		if(pageNow==null||pageNow.equals("")){
			pageNow="1";
		}
		Page page=new UserService().getCPage(Integer.parseInt(pageNow));
		
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/WEB-INF/jsp/list2.jsp").forward(request, response);
	}
	
	private void findList(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// 查询数据库，获取所有的用户表中的数据，并且封装成List<User>对象
		// List<User> userList = new UserService().getUserList();
		String pageNow = request.getParameter("pageNow");
		String queryType = request.getParameter("queryType");
		String queryString = new String(request.getParameter("queryString").getBytes("iso8859-1"),"utf-8");

		// 当用户没有pageNow参数，则设置一个默认值
		if (pageNow == null || pageNow.equals("")) {
			pageNow = "1";
		}
		if (queryType == null || queryType.equals("")) {
			queryType = "1";
		}
		Page page = new UserService().findPage(Integer.parseInt(pageNow),queryType,queryString);
		// 将集合数据放到Request中，以供list.jsp中使用
		// request.setAttribute("userList", userList);
		request.setAttribute("page", page);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("queryString", queryString);

		request.setAttribute("queryType", queryType);
		request.getRequestDispatcher("/WEB-INF/jsp/find_list.jsp").forward(request, response);
	}
	//editpassword
	private void edit_adpassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		User user = new UserService().getUserById(Integer.parseInt(id));
		request.setAttribute("user", user);
		request.setAttribute("method", "edit_adpassword");
		request.getRequestDispatcher("/WEB-INF/jsp/edit_adpassword.jsp").forward(request, response);
	}
	
	

}
