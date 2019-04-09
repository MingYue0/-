package com.jf.sadmin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.jf.StringUtil;
import com.jf.User;
import com.jf.UserService;
import com.jf.jadmin.UserService_jadmin;

/**
 * Servlet implementation class LimitServlet
 */
public class LimitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LimitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comno1 = new String(request.getParameter("comno1").getBytes("iso8859-1"), "utf-8");
		String comno2 = new String(request.getParameter("comno2").getBytes("iso8859-1"), "utf-8");
		String classno= new String(request.getParameter("classno").getBytes("iso8859-1"), "utf-8");
		String lstime1 = new String(request.getParameter("lstime1").getBytes("iso8859-1"), "utf-8");
		String letime1 = new String(request.getParameter("letime1").getBytes("iso8859-1"), "utf-8");
		String lstime2 = new String(request.getParameter("lstime2").getBytes("iso8859-1"), "utf-8");
		String letime2 = new String(request.getParameter("letime2").getBytes("iso8859-1"), "utf-8");
		String reason = new String(request.getParameter("reason").getBytes("iso8859-1"), "utf-8");
		
		System.out.println(comno1);
		System.out.println(comno2);
		System.out.println(classno);
		System.out.println(lstime1);
		System.out.println(letime1);
		System.out.println(lstime2);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		String now=format.format(new Date());
		String lstime=now+"-"+lstime1+" "+lstime2+":00:00";
		String now1=format.format(new Date());
		String letime=now1+"-"+letime1+" "+letime2+":00:00";
		int xianzhishichang =(Integer.parseInt(letime1)-Integer.parseInt(lstime1))*24+Integer.parseInt(letime2)-Integer.parseInt(lstime2);
		System.out.println("******");
		Limit l = new Limit();
		
		l.setComno(comno1);
		l.setClassno(classno);
		l.setLstime(lstime);
		l.setLetime(letime);
		l.setReason(reason);
		
		boolean success = new UserService_sadmin().add_limit(l,comno2,""+xianzhishichang);
		if (success) {
			int a=Integer.parseInt(comno1);
			for(int i=0;i<Integer.parseInt(comno2);i++){
				//找预约表	
				List<String> no=new UserService_jadmin().selsno(classno, ""+a);
				if(no.size()!=0){
					int time=parsetime(classno,""+a,lstime,letime);			//时间比较，若时间冲突返回0，不冲突返回1，不进行发送短信功能
					if(time==0){
						System.out.println(no.get(0));
						List<String> phone=new UserService_jadmin().selphone(no);
						System.out.println(phone.get(0));
						send(phone);
						for(int j=0;j<no.size();j++){
							Appoint appoint=new UserService().cancel(no.get(j));
						}
					}
				}
				a++;
			}
			response.sendRedirect("/jfManager/ManagerServlet?method=menu_sadmin");
			return;
		} 
	}
	
	private int parsetime(String classno,String comno,String lstime,String letime) {
		//日期比较
		List<Appoint> l=new ArrayList<Appoint>();
		l=new UserService().find_appoint(classno,comno);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if(l.size()>0){
		for(int i=0;i<l.size();i++){
			String day=l.get(i).getAstime();
			
			Date date1 = null;
			Date date2 = null;
			Date date3 = null;
			Date date4 = null;
			try {   
				date1 = format.parse(day);  
				date2 = format.parse(lstime);
				date4 = format.parse(letime);
			} catch (Exception ex) {   
				ex.printStackTrace();   
			}        
			//原日期加时长
			Calendar cal = Calendar.getInstance();   
			cal.setTime(date1);
			date3 = cal.getTime();	//原起始时间
			cal.add(Calendar.HOUR, Integer.parseInt(l.get(i).getTime()));// 24小时制   
			date1 = cal.getTime();	//结束时间
			//现日期
			Calendar cal2 = Calendar.getInstance();   
			cal2.setTime(date2);	
			date2 = cal2.getTime();		//现起始时间
			Calendar cal3 = Calendar.getInstance();  
			cal3.setTime(date4); 
			date4 = cal3.getTime();		//结束时间
        	//比较
        	if (date2.getTime() <= date1.getTime()&&date4.getTime() >= date3.getTime()) {
        		System.out.println(date1);
        		System.out.println(date2);
        		System.out.println(date3);
        		System.out.println(date4);
    			return 0;
            } else  {
        		return 1;
            }
		}
		}
		return 1;
	}


	private void send(List<String> list) {
		for(int i=0;i<list.size();i++){
			HttpClient client = new HttpClient();
			PostMethod post = new PostMethod("http://gbk.api.smschinese.cn"); 
			post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
			NameValuePair[] data ={ new NameValuePair("Uid", "jsc321"),
					new NameValuePair("Key", "d41d8cd98f00b204e980"),
					new NameValuePair("smsMob",""+list.get(i)),
					new NameValuePair("smsText","您在机房管理系统预约的电脑由于设备问题处于保修状态，请前往系统重新预约")};
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

}
