package com.jf.jadmin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.jf.Appoint;
import com.jf.Computer;
import com.jf.Page;
import com.jf.StringUtil;
import com.jf.User;
import com.jf.UserService;
import com.jf.sadmin.UserService_sadmin;

/**
 * Servlet implementation class ManagerServlet_jadmin
 */
public class ManagerServlet_jadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet_jadmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method=request.getParameter("method");
		request.setAttribute("method", method);
		//order
		if("findUseJa".equals(method)){
			findUseJa(request,response);
		}else if("findRepairJa".equals(method)){
			findRepairJa(request,response);
		}else if("findUseListJa".equals(method)){
			findUseListJa(request,response);
		}else if("findRepairListJa".equals(method)){
			findRepairListJa(request,response);
		}else if("classList".equals(method)){
			classList(request,response);
		}else if("comManagePlan".equals(method)){
			comManagePlan(request,response);
		}else if("comList".equals(method)){
			comList(request,response);
		}else if("editCom".equals(method)){
			editCom(request,response);
		}else if("editComNow".equals(method)){
			editComNow(request,response);
		}else if("repairNow".equals(method)){
			repairNow(request,response);
		}else if("normalNow".equals(method)){
			normalNow(request,response);
		}else if("deleteComNow".equals(method)){
			deleteComNow(request,response);
		}else if("addSelectJa".equals(method)){
			addSelectJa(request,response);
		}else if("findSelectJa".equals(method)){
			findSelectJa(request,response);
		}else if("deleteAllCom".equals(method)){
			deleteAllCom(request,response);
		}else if("deleteClassSelect".equals(method)){
			deleteClassSelect(request,response);
		}else if("deleteClass".equals(method)){
			deleteClass(request,response);
		}else if("typeChoose".equals(method)){
			typeChoose(request,response);
		}else if("typeSelect".equals(method)){
			typeSelect(request,response);
		}else if("type".equals(method)){
			type(request,response);
		}else if("analyseSelect".equals(method)){
			analyseSelect(request,response);
		}else if("analyseSelectChart".equals(method)){
			analyseSelectChart(request,response);
		}else if("input_com".equals(method)){
			input_com(request,response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		System.out.println(method);
		boolean success = false;
		String tip=null;
		if (method.equals("editComNow")) {
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
				response.sendRedirect("/jfManager/ManagerServlet_jadmin?method=editCom&comid="+comid);
				return;
			} else {
				request.setAttribute("message", "操作失败！");
				request.setAttribute("computer", computer);
				request.setAttribute("method", method);
				request.getRequestDispatcher("/WEB-INF/jsp/add2.jsp").forward(request, response);
			}

		}
	}
	
	private void addSelectJa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/add_select_ja.jsp").forward(request, response);
	}
	private void findSelectJa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/find_select_ja.jsp").forward(request, response);
	}
	private void findUseJa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/find_use_ja.jsp").forward(request, response);
	}
	private void findRepairJa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/find_repair_ja.jsp").forward(request, response);
	}
	private void findUseListJa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
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
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/use_list_ja.jsp").forward(request, response);

	}
	
	private void findRepairListJa(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
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
		Page page = new UserService_jadmin().findRepairPage(Integer.parseInt(pageNow),queryType,queryString,queryString2);
		// 将集合数据放到Request中，以供list.jsp中使用
		// request.setAttribute("userList", userList);
		request.setAttribute("page", page);
		request.setAttribute("pageNow", pageNow);
		request.setAttribute("queryString2", queryString);
		request.setAttribute("queryString3", queryString);
		request.setAttribute("queryString4", queryString);
		request.setAttribute("queryString5", queryString);

		request.setAttribute("queryType", queryType);
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/repair_list_ja.jsp").forward(request, response);	

	}

	
	private void classList(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/class_manage_select.jsp").forward(request, response);
	}
	private void comManagePlan(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/commanage_plan_select.jsp").forward(request, response);
	}
	private void comList(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String classno =request.getParameter("classno");
		if (StringUtil.isEmpty(classno)) {
			return;
		}
		List<Computer> comList=new ArrayList<Computer>();
		
		comList=new UserService_jadmin().selByClassno(Integer.parseInt(classno));	
		String type=new UserService_jadmin().getTypeByNo(classno);	
		request.setAttribute("comList",comList);
		request.setAttribute("classno",classno);
		request.setAttribute("type",type);
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/com_manage_select.jsp").forward(request, response);
	}
	private void editCom(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String comid =request.getParameter("comid");
		Computer computer=new UserService_jadmin().getComputerById(Integer.parseInt(comid));
		request.setAttribute("computer", computer);
		request.setAttribute("method", "editCom");
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/edit_com.jsp").forward(request, response);
	}
	private void editComNow(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String comid =request.getParameter("comid");
		Computer computer=new UserService_jadmin().getComputerById(Integer.parseInt(comid));
		request.setAttribute("computer", computer);
		request.setAttribute("method", "editComNow");
		request.getRequestDispatcher("/WEB-INF/jsp/add2.jsp").forward(request, response);
	}
	
	private void repairNow(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String comid =request.getParameter("comid");
		String condition=new UserService_jadmin().chargeCondition(Integer.parseInt(comid));
		Computer computer=new UserService().repair(Integer.parseInt(comid));
		
		request.setAttribute("computer", computer);
		computer=new UserService_jadmin().getComputerById(Integer.parseInt(comid));
		System.out.println(condition);
		if(condition.equals("normal")) {
			Boolean success= new UserService_jadmin().repairTime(computer);
			
			//找预约表
			List<String> no=new UserService_jadmin().selsno(computer.getClassno(), computer.getComno());
			if(no.size()!=0){
				List<String> phone=new UserService_jadmin().selphone(no);
				System.out.println(phone.get(0));
				//send(phone);
				for(int i=0;i<no.size();i++){
					Appoint appoint=new UserService().cancel(no.get(i));
				}
			}
		}
		
		request.setAttribute("computer", computer);
		request.setAttribute("method", "editCom");
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/edit_com.jsp").forward(request, response);
	}
	
	private void normalNow(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String comid =request.getParameter("comid");
		String condition=new UserService_jadmin().chargeCondition(Integer.parseInt(comid));
		Computer computer=new UserService().normal(Integer.parseInt(comid));
		request.setAttribute("computer", computer);
		computer=new UserService_jadmin().getComputerById(Integer.parseInt(comid));
		System.out.println(condition);
		if(condition.equals("damage")) {
			Boolean success= new UserService_jadmin().normalTime(computer);
		}
		
		request.setAttribute("computer", computer);
		request.setAttribute("method", "editCom");
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/edit_com.jsp").forward(request, response);
	}
	//从电脑排布界面进入后选择删除，删除后回到电脑排布界面
	private void deleteComNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 第一步：获取需要删除的用户ID
		String comid = request.getParameter("comid");
		String classno = request.getParameter("classno");
		if (StringUtil.isEmpty(comid)||StringUtil.isEmpty(classno)) {
			return;
		}
		// 第二步：链接数据库，执行删除操作
		new UserService_jadmin().deleteComputerById(Integer.parseInt(comid));
		// 第三步：删除成功，跳转到列表页面
		response.sendRedirect("/jfManager/ManagerServlet_jadmin?method=comList&classno="+classno);
	}
	
	private void deleteClassSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/delete_class_select.jsp").forward(request, response);
	}
	private void deleteAllCom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 第一步：获取需要删除的用户ID
		String classno = request.getParameter("classno");
		if (StringUtil.isEmpty(classno)) {
			return;
		}
		// 第二步：链接数据库，执行删除操作
		new UserService_jadmin().deleteAllComputer(classno);
		// 第三步：删除成功，跳转到列表页面
		response.sendRedirect("/jfManager/ManagerServlet_jadmin?method=comList&classno="+classno);
	}
	private void deleteClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 第一步：获取需要删除的用户ID
		String queryString = new String(request.getParameter("queryString").getBytes("iso8859-1"),"utf-8");
		// 第二步：链接数据库，执行删除操作
		System.out.println(queryString);
		new UserService_jadmin().deleteAllComputer(queryString);
		// 第三步：删除成功，跳转到列表页面
		response.sendRedirect("/jfManager/ManagerServlet?method=menu_admin");
	}
	private void typeSelect(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String classno =request.getParameter("classno");
		if (StringUtil.isEmpty(classno)) {
			return;
		}
		request.setAttribute("classno",classno);
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/type_select.jsp").forward(request, response);
	}
	private void typeChoose(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/type_select_class.jsp").forward(request, response);
	}
	private void type(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String classno =request.getParameter("classno");
		String type =request.getParameter("type");
		if (StringUtil.isEmpty(classno)) {
			return;
		}
		new UserService_jadmin().alterType(type,classno);
		request.getRequestDispatcher("/WEB-INF/jsp/menu_admin.jsp").forward(request, response);
	}

	private void analyseSelect(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/analyse_select.jsp").forward(request, response);
	}
	private void analyseSelectChart(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String queryString = request.getParameter("queryString");
		if (StringUtil.isEmpty(queryString)) {
			return;
		}
		// 第二步：链接数据库，执行删除操作
		List<Computer> recordList=new UserService_jadmin().getRepairTime(queryString);
		// 第三步：删除成功，跳转到列表页面
		int maxnum=0,maxgap=0,gap=0;
		String comno1=null;
		String comno2=null;
		for(int i=0;i<recordList.size();i++) {
			gap=recordList.get(i).getRepairnum()-maxnum;
			if(recordList.get(i).getRepairnum()>maxnum) {
				maxnum=recordList.get(i).getRepairnum();
				comno1=recordList.get(i).getComno();
			}
			if(gap>maxgap||gap<-1*maxgap) {
				if(gap>0)
					maxgap=gap;
				else
					maxgap=-1*gap;
				comno2=recordList.get(i).getComno();
			}
		}
		System.out.println(maxgap);
		System.out.println(comno1);
		System.out.println(comno2);
		String tip="Tips:该机房暂无异常电脑";
		if(comno1.equals(comno2) && maxgap>=3) {
			tip="Tips:该机房编号为"+comno1+"的电脑维修次数异常，可能有机器老化或恶意损坏的情况，请及时查看并更换!!!";
		}
		request.setAttribute("tip", tip);
		request.setAttribute("recordList", recordList);
		request.setAttribute("classn", queryString);
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/analyse_select_chart.jsp").forward(request, response);
	}
	
	
	private void send(List<String> list) {
		for(int i=0;i<list.size();i++){
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod("http://gbk.api.smschinese.cn"); 
			post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
			NameValuePair[] data ={ new NameValuePair("Uid", "jsc321"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob",""+list.get(i)),new NameValuePair("smsText","您在机房管理系统预约的电脑由于设备问题正处于保修状态，请前往系统重新预约")};
			post.setRequestBody(data);

			try {
				client.executeMethod(post);
			} catch (HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Header[] headers = post.getResponseHeaders();
			int statusCode = post.getStatusCode();
			System.out.println("statusCode:"+statusCode);
			for(Header h : headers)
			{
			System.out.println(h.toString());
			}
			String result;
			try {
				result = new String(post.getResponseBodyAsString().getBytes("gbk"));
				System.out.println(result); //打印返回消息状态
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			post.releaseConnection();
		}
		
	}
	private void input_com(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp_jadmin/input_com.jsp").forward(request, response);
	}


}
