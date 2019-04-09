package com.jf.sadmin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jf.Computer;
import com.jf.Page;
import com.jf.StringUtil;
import com.jf.User;
import com.jf.UserService;
import com.jf.jadmin.UserService_jadmin;

public class ManagerServlet_sadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ManagerServlet_sadmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		request.setAttribute("method", method);
		if("manager".equals(method)){
			manager(request,response);
		}else if ("delete".equals(method)) {
			delete(request, response);
		}else if ("list_sadmin".equals(method)) {
			list_sadmin(request, response);
		}else if ("edit_stu".equals(method)) {
			edit_stu(request, response);
		}else if ("add_stu".equals(method)) {
			add_stu(request, response);
		}else if ("add_seclet".equals(method)) {
			add_seclet(request, response);
		}else if ("add_allstu".equals(method)) {
			add_allstu(request, response);
		}else if ("find_stu".equals(method)) {
			find_stu(request, response);
		}else if ("findList".equals(method)) {
			findList(request, response);
		}else if ("find_log".equals(method)) {
			find_log(request, response);
		}else if ("findList_log".equals(method)) {
			findList_log(request, response);
		}else if ("output_log".equals(method)) {
			output_log(request, response);
		}else if ("limit".equals(method)) {
			limit(request, response);
		}else if ("find_select".equals(method)) {
			find_select(request, response);
		}else if ("findTime".equals(method)) {
			findTime(request, response);
		}else if ("UseCount".equals(method)) {
			UseCount(request, response);
		}else if ("analyse".equals(method)) {
			analyse(request, response);
		}else if ("analyse_class".equals(method)) {
			analyse_class(request, response);
		}else if ("analyse_class_chart".equals(method)) {
			analyse_class_chart(request, response);
		}else if ("findUseSa".equals(method)) {
			findUseSa(request, response);
		}else if ("findUseListSa".equals(method)) {
			findUseListSa(request, response);
		}
	}



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
				response.sendRedirect("/jfManager/ManagerServlet_sadmin?method=manager");
				return;
			} else {
				request.setAttribute("message", "操作失败");
				request.setAttribute("user", user);
				request.setAttribute("method", method);
				request.getRequestDispatcher("/WEB-INF/jsp_sadmin/add_stu.jsp").forward(request, response);
			}
		}
		
		if (method.equals("add_stu")) {
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
				response.sendRedirect("/jfManager/ManagerServlet_sadmin?method=manager");
				return;
			} else {
				request.setAttribute("message", "操作失败");
				request.setAttribute("user", user);
				request.setAttribute("method",method );
				request.getRequestDispatcher("/WEB-INF/jsp/add_stu.jsp").forward(request, response);
			}
		}
	}
	
	
	private void manager(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String pageNow = request.getParameter("pageNow");
		if (pageNow == null || pageNow.equals("")) {
			pageNow = "1";
		}
		Page page = new UserService().getPage(Integer.parseInt(pageNow));
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/userlist.jsp").forward(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (StringUtil.isEmpty(id)) {
			return;
		}
		new UserService().deleteUserById(Integer.parseInt(id));
		response.sendRedirect("/jfManager/ManagerServlet_sadmin?method=list_sadmin");
	}
	private void list_sadmin(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
				String pageNow = request.getParameter("pageNow");
				if (pageNow == null || pageNow.equals("")) {
					pageNow = "1";
				}
				Page page = new UserService().getPage(Integer.parseInt(pageNow));
				request.setAttribute("page", page);
				request.getRequestDispatcher("/WEB-INF/jsp_sadmin/userlist.jsp").forward(request, response);
	}
	private void edit_stu(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String id = request.getParameter("id");
		User user = new UserService().getUserById(Integer.parseInt(id));
		request.setAttribute("user", user);
		request.setAttribute("method", "edit_stu");
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/add_stu.jsp").forward(request, response);
	}
	private void add_stu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("user", new User());
		request.setAttribute("method", "add_stu");
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/add_stu.jsp").forward(request, response);
	}
	private void add_seclet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("user", new User());
		request.setAttribute("method", "add_stu");
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/add_seclet.jsp").forward(request, response);
	}
	private void find_select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("user", new User());
		request.setAttribute("method", "add_stu");
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/find_select.jsp").forward(request, response);
	}
	private void add_allstu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("user", new User());
		request.setAttribute("method", "add_stu");
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/add_allstu.jsp").forward(request, response);
	}
	private void find_stu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/find_stu.jsp").forward(request, response);
	}
	private void findList(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String pageNow = request.getParameter("pageNow");
		String queryType = request.getParameter("queryType");
		String queryString = null;
		if(queryType.equals("1")) {
			queryString = new String(request.getParameter("queryString1").getBytes("iso8859-1"),"utf-8");
		}else if(queryType.equals("2")) {
			queryString = new String(request.getParameter("queryString2").getBytes("iso8859-1"),"utf-8");
		}else if(queryType.equals("0")) {
			queryString = new String(request.getParameter("queryString0").getBytes("iso8859-1"),"utf-8");
		}

		if (pageNow == null || pageNow.equals("")) {
			pageNow = "1";
		}
		if (queryType == null || queryType.equals("")) {
			queryType = "1";
		}
		Page page = new UserService_sadmin().findPage(Integer.parseInt(pageNow),queryType,queryString);
		request.setAttribute("page", page);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("queryString1", queryString);
		request.setAttribute("queryString2", queryString);
		request.setAttribute("queryString0", queryString);

		request.setAttribute("queryType", queryType);
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/find_list.jsp").forward(request, response);
	}
	private void find_log(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/find_log.jsp").forward(request, response);
	}
	private void findList_log(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String pageNow = request.getParameter("pageNow");
		String queryType = request.getParameter("queryType");
		String queryString =null;
		if(queryType.equals("2")) {
			queryString = new String(request.getParameter("queryString2").getBytes("iso8859-1"),"utf-8");
		}else if(queryType.equals("0")) {
			queryString = new String(request.getParameter("queryString0").getBytes("iso8859-1"),"utf-8");
		}

		if (pageNow == null || pageNow.equals("")) {
			pageNow = "1";
		}
		if (queryType == null || queryType.equals("")) {
			queryType = "1";
		}
		Page page = new UserService_sadmin().findPage_log(Integer.parseInt(pageNow),queryType,queryString);
		request.setAttribute("page", page);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("queryString2", queryString);
		request.setAttribute("queryString0", queryString);

		request.setAttribute("queryType", queryType);
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/find_list_log.jsp").forward(request, response);
	}
	
	private void output_log(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/output_log.jsp").forward(request, response);
	}
	private void limit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/limit.jsp").forward(request, response);
	}
	private void findTime(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String pageNow = request.getParameter("pageNow");
		if (pageNow == null || pageNow.equals("")) {
			pageNow = "1";
		}
		Page page = new UserService_sadmin().getTimePage(Integer.parseInt(pageNow));
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/time_list.jsp").forward(request, response);
	}
	private void UseCount(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		UseCount useCount=new UseCount();
		useCount.setCount1(new UserService_sadmin().getCount(8,10));
		useCount.setCount2(new UserService_sadmin().getCount(10,12));
		useCount.setCount3(new UserService_sadmin().getCount(14,16));
		useCount.setCount4(new UserService_sadmin().getCount(16,18));
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/time_list.jsp").forward(request, response);
	}
	private void analyse(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		UseCount useCount=new UseCount();
		useCount.setCount1(new UserService_sadmin().getCount(8,10));
		useCount.setCount2(new UserService_sadmin().getCount(10,12));
		useCount.setCount3(new UserService_sadmin().getCount(14,16));
		useCount.setCount4(new UserService_sadmin().getCount(16,18));
		request.setAttribute("count1", useCount.getCount1());
		request.setAttribute("count2", useCount.getCount2());
		request.setAttribute("count3", useCount.getCount3());
		request.setAttribute("count4", useCount.getCount4());
		System.out.println(useCount.getCount1());
		System.out.println(useCount.getCount2());
		System.out.println(useCount.getCount3());
		System.out.println(useCount.getCount4());
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/analyse.jsp").forward(request, response);
	}
	private void analyse_class(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/analyse_class.jsp").forward(request, response);
	}
	private void analyse_class_chart(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String queryString = request.getParameter("queryString");
		if (StringUtil.isEmpty(queryString)) {
			return;
		}
		// 第二步：链接数据库，执行删除操作
		List<User> recordList=new UserService_sadmin().getClassTime(queryString);
		// 第三步：删除成功，跳转到列表页面
		request.setAttribute("recordList", recordList);
		request.setAttribute("classn", queryString);
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/analyse_class_chart.jsp").forward(request, response);
	}
	private void findUseSa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/find_use_sa.jsp").forward(request, response);
	}
	private void findUseListSa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageNow = request.getParameter("pageNow");
		String queryType = request.getParameter("queryType");
		String queryString = null;
		String queryString2 = null;
		if(queryType.equals("2")) {
			queryString = new String(request.getParameter("queryString2").getBytes("iso8859-1"),"utf-8");
		}else if(queryType.equals("3")) {
			queryString = new String(request.getParameter("queryString3").getBytes("iso8859-1"),"utf-8");
		}else if(queryType.equals("4")) {
			queryString = new String(request.getParameter("queryString4").getBytes("iso8859-1"),"utf-8");
			queryString2 = new String(request.getParameter("queryString5").getBytes("iso8859-1"),"utf-8");
		}

		// 当用户没有pageNow参数，则设置一个默认值
		if (pageNow == null || pageNow.equals("")) {
			pageNow = "1";
		}
		if (queryType == null || queryType.equals("")) {
			queryType = "1";
		}
		Page page = new UserService_jadmin().findPage(Integer.parseInt(pageNow),queryType,queryString,queryString2);
		// 将集合数据放到Request中，以供list.jsp中使用
		// request.setAttribute("userList", userList);
		request.setAttribute("page", page);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("queryString2", queryString);
		request.setAttribute("queryString3", queryString);
		request.setAttribute("queryString4", queryString);
		request.setAttribute("queryString5", queryString);

		request.setAttribute("queryType", queryType);
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/use_list_sa.jsp").forward(request, response);

	}
	
	
	
	
	
}