package com.jf;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String comid=request.getParameter("comid");
		comid =new String(comid.getBytes("iso8859-1"),"utf-8");
		String comno=request.getParameter("comno");
		comno =new String(comno.getBytes("iso8859-1"),"utf-8");
		String version=request.getParameter("version");
		version =new String(version.getBytes("iso8859-1"),"utf-8");
		String classno=request.getParameter("classno");
		classno =new String(classno.getBytes("iso8859-1"),"utf-8"); 
		String condition=request.getParameter("condition");
		condition =new String(condition.getBytes("iso8859-1"),"utf-8"); 
		String appointment=request.getParameter("appointment");
		appointment =new String(appointment.getBytes("iso8859-1"),"utf-8"); 
		String sno=request.getParameter("sno");
		sno =new String(sno.getBytes("iso8859-1"),"utf-8"); 
		
		String astime=request.getParameter("astime");
		astime =new String(astime.getBytes("iso8859-1"),"utf-8");
		String time=request.getParameter("time");
		time =new String(time.getBytes("iso8859-1"),"utf-8");
		String dayo=request.getParameter("day");
		dayo =new String(dayo.getBytes("iso8859-1"),"utf-8");
		
		int rows=new UserService().judge(sno);
		if(rows==0)
		{	
			//日期比较
			List<Appoint> l=new ArrayList<Appoint>();
			l=new UserService().find_appoint(classno,comno);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM");
			String now=format1.format(new Date());
			String now1=now+"-"+dayo+" "+astime+":00:00";
			if(l.size()>0){
			for(int i=0;i<l.size();i++){
				String day=l.get(i).getAstime();
				
				Date date1 = null;
				Date date2 = null;
				Date date3 = null;
				Date date4 = null;
				try {   
					date1 = format.parse(day);  
					date2 = format.parse(now1);
				} catch (Exception ex) {   
					ex.printStackTrace();   
				}        
				//原日期加时长
				Calendar cal = Calendar.getInstance();   
				cal.setTime(date1);
				date3 = cal.getTime();	//原起始时间
				cal.add(Calendar.HOUR, Integer.parseInt(l.get(i).getTime()));// 24小时制   
				date1 = cal.getTime();	//结束时间
				//现日期加时长
				Calendar cal2 = Calendar.getInstance();   
				cal2.setTime(date2);	
				date4 = cal2.getTime();		//现起始时间
				cal2.add(Calendar.HOUR, Integer.parseInt(time));// 24小时制   
				date2 = cal2.getTime();		//结束时间
	        	//比较
	        	if (date4.getTime() >= date1.getTime()||date2.getTime() <= date3.getTime()) {
	                Appoint appoint =new UserService().setappoint(sno,classno,comno,now1,time);
	    			response.sendRedirect("/jfManager/ManagerServlet_stu?method=ordersuccess");
	    			return;
	            } else  {
	                response.sendRedirect("/jfManager/ManagerServlet_stu?method=orderfail");
	            } 
			}	
			}
			else{
				Appoint appoint =new UserService().setappoint(sno,classno,comno,now1,time);
    			response.sendRedirect("/jfManager/ManagerServlet_stu?method=ordersuccess");
			}
		}
		else if(rows==1){
			response.sendRedirect("/jfManager/ManagerServlet_stu?method=orderfail");
		}

		
	}

}
