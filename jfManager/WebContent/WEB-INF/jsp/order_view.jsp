<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的预约</title>
<style>
		button{background-color:ivory;color:#705108}
		span{font-size: 20px; font-weight: bold;color:black}
        p{font-size: 20px; font-weight: bold;color:#836C0D}
		body {margin: 0;font-family: 'Lato', sans-serif; font-weight: 400;font-size: 15px;line-height: 25px;color: #333333;overflow-x: hidden;padding: 0;background-image:url(./imgs/bg.jpg);background-size:cover}
		.box{}
		.menu a:hover {background:#93A29D;color:white}
		.menu{border-bottom: 1px solid white;height: 85px;margin-top: 2px;width:100%}
		.b{margin-right: 10px; float:right;color:black;margin-bottom: auto;margin-top: 10px;color:white;font-family:幼圆;}
	    .b1{float:right;font-weight: 900;font-size: 150%;}
	    .c1{margin-left: 10px;float:left;height: 80px;margin-top: 15px}
		.d{margin-top: 60px; float:center;height: 300px;}
		a{color:#4876F1}
		input[type=text], input[type=file], input[type=password], input[type=email], select { border: 1px solid #DCDEE0; vertical-align: middle; border-radius: 3px; height: 30px; padding: 0px 16px; font-size: 14px; color: #555555; outline:none; width:100%;margin-bottom: 15px;line-height:50px; color:#888;}
		input[type=text]:focus, input[type=file]:focus, input[type=password]:focus, input[type=email]:focus, select:focus { border: 1px solid #27A9E3; }
		input[type=submit], input[type=button] { display: inline-block; vertical-align: middle; padding: 12px 24px; margin: 0px; font-size:16px; line-height: 24px; text-align: center; white-space: nowrap; vertical-align: middle; cursor: pointer; color: #ffffff; background-color: #27A9E3; border-radius: 3px; border: none; -webkit-appearance: none; outline:none; width:100%; }

</style>

<script type="text/javascript">
   var appointment = '${requestScope.computer.appointment}';
   function initRadioValue(){
	   if(appointment != ''){
		   var appointmentArray = document.getElementsByName('appointment');
		   for(var i=0;i<appointmentArray.length;i++){
			   if(appointmentArray[i].value == appointment){
				   appointmentArray[i].checked = 'checked';
			   }
		   }
	   }
   }
   window.onload = function(){
	   initRadioValue();
   }
</script>
</head>
<body>
   <form action="ManagerServlet_stu" method="post">
	   <input type="hidden" name="method" value="${requestScope.method }">
      <input type="hidden" name="comid" value="${requestScope.computer.comid }">
	  <div class="box">
		<div class="menu">
			 <div class="b">
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;欢迎您：${sessionScope.loginUser.username }
			    <a href="LogoutServlet" style="text-decoration: none">注销</a><br><br>
				 <div class="b1">
					 <a href="ManagerServlet_stu?method=menu_stu" style="text-decoration: none;color: slategray">首页</a>
	                 <a href="ManagerServlet_stu?method=orderclass" style="text-decoration: none;color: slategray">预约</a>
		             <a href="ManagerServlet_stu?method=orderview&no=${sessionScope.loginUser.no}" style="text-decoration: none;color: slategray">我的预约</a>
				 </div>
		     </div>
			 <div class="c1">
				 <img src="./imgs/nchu.png" alt="" height="50px" >
		     </div>
		</div>
		<center>
	         <div class="d">
				 <center><p style="font-size: 30px">预约信息</p></center>
				 <center>
					 <table style="font-size: 20px; ">
						 <tr>
							 <td>编号：</td>
							 <td>${sessionScope.appoint.appointid }</td>
						 </tr>
						 <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr>
						 <tr>
						     <td>预约学号：</td>
							 <td>${sessionScope.appoint.no }</td>
						 </tr>
						 <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr>
						 <tr>
							 <td>机房号：</td>
							 <td>${sessionScope.appoint.classno }</td>
						 </tr>
						 <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr>
						 <tr>
							 <td>设备编号：</td>
							 <td>${sessionScope.appoint.comno }</td>
						 </tr>
						  <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr>
						 <tr>
							 <td>起始时间：</td>
							 <td>${sessionScope.appoint.astime }</td>
						 </tr>
						  <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr>
						 <tr>
							 <td>预约时长：</td>
							 <td>${sessionScope.appoint.time }小时</td>
						 </tr>
						 <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr> <tr>&nbsp;</tr>
					 </table>
					 <a href="ManagerServlet_stu?method=ordercancel&no=${sessionScope.loginUser.no}" style="font-size: 25px">取消预约</a>
					 <a href="ManagerServlet_stu?method=start_stu&no=${sessionScope.loginUser.no}&username=${sessionScope.loginUser.username}&classno=${sessionScope.appoint.classno }&comno=${sessionScope.appoint.comno }" style="font-size: 25px">上机</a>
					 <a href="ManagerServlet_stu?method=stop_stu&no=${sessionScope.loginUser.no}&classno=${sessionScope.appoint.classno }&comno=${sessionScope.appoint.comno }" style="font-size: 25px">下机</a>
				 </center>
	        </div>
	     </center>
	  </div>   
   </form>

</body>
</html>
