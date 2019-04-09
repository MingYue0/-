package com.jf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 内部转发至jsp页面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		//解决中文乱码
		username = new String(username.getBytes("iso8859-1"),"utf-8");
		String password = request.getParameter("password");
		//解决中文乱码
		password = new String(password.getBytes("iso8859-1"),"utf-8");
		String usertype = request.getParameter("usertype");
		//解决中文乱码
		usertype = new String(usertype.getBytes("iso8859-1"),"utf-8");
		User user = new UserService().findUserByUsernameAndPassword(username, password,usertype);
		if(user == null) {
			request.setAttribute("message", "用户名或密码不正确，请重新输入！！！");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser",user);
			response.sendRedirect("/jfManager/MenuServlet");
		}
	}
}
