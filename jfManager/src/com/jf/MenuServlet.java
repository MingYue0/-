package com.jf;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuServlet
 */
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object loginUser = request.getSession().getAttribute("loginUser");
		//当用户未登录直接访问menu时，进入登录页面
		User user=(User)loginUser;
		String usertype=user.getUsertype();
		InetAddress address = InetAddress.getLocalHost();
		String addr=address.toString();
		
		if(loginUser==null){
			response.sendRedirect("/jfManager/LoginServlet");
			return;
		}
		if(usertype.equals("管理员")){
		    String no = new String(user.getNo().getBytes("iso8859-1"), "utf-8");
		    String name = new String(user.getUsername().getBytes("iso8859-1"), "utf-8");
		    boolean s=new UserService().write_log(no, name, addr);
			request.getRequestDispatcher("/WEB-INF/jsp/menu_admin.jsp").forward(request, response);
		}
		else if(usertype.equals("学生")){
		    String no = new String(user.getNo().getBytes("iso8859-1"), "utf-8");
		    String name = new String(user.getUsername().getBytes("iso8859-1"), "utf-8");
		    boolean s=new UserService().write_log(no, name, addr);
			request.getRequestDispatcher("/WEB-INF/jsp/menu_stu.jsp").forward(request, response);	
		}
		else if(usertype.equals("系统管理员")){
		    String no = new String(user.getNo().getBytes("iso8859-1"), "utf-8");
		    String name = new String(user.getUsername().getBytes("iso8859-1"), "utf-8");
		    boolean s=new UserService().write_log(no, name, addr);
			request.getRequestDispatcher("/WEB-INF/jsp_sadmin/menu_sadmin.jsp").forward(request, response);	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
