package com.jf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jf.jadmin.UserService_jadmin;

/**
 * Servlet implementation class ManagerServlet_stu
 */
public class ManagerServlet_stu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet_stu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		request.setAttribute("method", method);
		if("order".equals(method)){
			order(request,response);
		}
		else if("menu_stu".equals(method)){
			menu_stu(request,response);
		}
		else if ("edit_stu".equals(method)) {
			edit_stu(request, response);
		}
		else if ("edit_password".equals(method)) {
			edit_password(request, response);
		}
		else if ("orderclass".equals(method)) {
			orderclass(request, response);
		}
		else if ("ordercom".equals(method)) {
			ordercom(request, response);
		}
		else if ("ordersuccess".equals(method)) {
			ordersuccess(request, response);
		}
		else if ("orderfail".equals(method)) {
			orderfail(request, response);
		}
		else if ("orderview".equals(method)) {
			orderview(request, response);
		}
		else if ("ordercancel".equals(method)) {
			ordercancel(request, response);
		}
		else if ("start_stu".equals(method)) {
			start_stu(request, response);
		}
		else if ("stop_stu".equals(method)) {
			stop_stu(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		System.out.println(method);
		boolean success = false;
		if (method.equals("edit_stu")) {
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
				request.setAttribute("message", "²Ù×÷Ê§°Ü£¡");
				request.setAttribute("user", user);
				request.setAttribute("method", method);
				request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
			}
		}
		if (method.equals("edit_password")) {
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
				request.setAttribute("message", "²Ù×÷Ê§°Ü£¡");
				request.setAttribute("user", user);
				request.setAttribute("method", method);
				request.getRequestDispatcher("/WEB-INF/jsp/edit_password.jsp").forward(request, response);
			}
		}
	}
	//Ô¤Ô¼µçÄÔ
		private void order(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// TODO Auto-generated method stub
			String classno =request.getParameter("classno");
			if (StringUtil.isEmpty(classno)) {
				return;
			}
			List<Computer> comList=new ArrayList<Computer>();
			
			comList=new UserService().selByClassno(Integer.parseInt(classno));	
			String type=new UserService_jadmin().getTypeByNo(classno);	
			HttpSession session = request.getSession();
			session.setAttribute("comList",comList);
			request.setAttribute("type",type);
			request.getRequestDispatcher("/WEB-INF/jsp/order.jsp").forward(request, response);
		}
		
		private void orderclass(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.getRequestDispatcher("/WEB-INF/jsp/orderclass.jsp").forward(request, response);
		}
		private void ordercom(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// TODO Auto-generated method stub
			String comid =request.getParameter("comid");
			if (StringUtil.isEmpty(comid)) {
				return;
			}
			Computer computer =new Computer();
			List<Appoint> listAppoint=new ArrayList<Appoint>();
			List<String> l=new ArrayList<String>();
			computer=new UserService().getComputerById(Integer.parseInt(comid));
			l=new UserService().findclssnobyid(Integer.parseInt(comid));
			listAppoint=new UserService().find_appoint(l.get(0), l.get(1));
			
			HttpSession session = request.getSession();
			session.setAttribute("computer",computer);
			session.setAttribute("appointList", listAppoint);
			request.getRequestDispatcher("/WEB-INF/jsp/ordercom.jsp").forward(request, response);
		}
		private void ordersuccess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.getRequestDispatcher("/WEB-INF/jsp/order_success.jsp").forward(request, response);
		}
		private void menu_stu(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// TODO Auto-generated method stub
			request.getRequestDispatcher("/WEB-INF/jsp/menu_stu.jsp").forward(request, response);
		}
		private void edit_stu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			User user = new UserService().getUserById(Integer.parseInt(id));
			request.setAttribute("user", user);
			request.setAttribute("method", "edit_stu");
			request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
		}
		private void orderfail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			// TODO Auto-generated method stub
			request.getRequestDispatcher("/WEB-INF/jsp/order_fail.jsp").forward(request, response);
		}
		private void orderview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String no =request.getParameter("no");
			if (StringUtil.isEmpty(no)) {
				return;
			}
			Appoint appoint=new Appoint();
			
			appoint=new UserService().vieworder(no);	
			HttpSession session = request.getSession();
			session.setAttribute("appoint",appoint);
			request.getRequestDispatcher("/WEB-INF/jsp/order_view.jsp").forward(request, response);
		}
		private void edit_password(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String id = request.getParameter("id");
			User user = new UserService().getUserById(Integer.parseInt(id));
			request.setAttribute("user", user);
			request.setAttribute("method", "edit_password");
			request.getRequestDispatcher("/WEB-INF/jsp/edit_password.jsp").forward(request, response);
		}
		private void ordercancel(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// TODO Auto-generated method stub
			String no =request.getParameter("no");
			Appoint a =new UserService().cancel(no);
			request.getRequestDispatcher("/WEB-INF/jsp/menu_stu.jsp").forward(request, response);
		}
		private void start_stu(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// TODO Auto-generated method stub
			String no =request.getParameter("no");
			String username =request.getParameter("username");
			String classno =request.getParameter("classno");
			String comno =request.getParameter("comno");
			Computer com=new UserService().getComputerByNo(classno, comno);
			if(StringUtil.isEmpty(com.getAppointment())){
				Use a =new UserService().startgo(no,username,classno,comno);
				request.getRequestDispatcher("/WEB-INF/jsp/menu_stu.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("/WEB-INF/jsp/menu_stu.jsp").forward(request, response);
			}	
		}
		private void stop_stu(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			// TODO Auto-generated method stub
			String no =request.getParameter("no");
			String classno =request.getParameter("classno");
			String comno =request.getParameter("comno");
			Computer com=new UserService().getComputerByNo(classno, comno);
			
			if(StringUtil.isEmpty(com.getAppointment())){
				request.getRequestDispatcher("/WEB-INF/jsp/menu_stu.jsp").forward(request, response);
			}
			else{
				boolean a =new UserService().stopgo(no,classno,comno);
				request.getRequestDispatcher("/WEB-INF/jsp/menu_stu.jsp").forward(request, response);
			}	
		}
}
