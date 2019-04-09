<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>预约设备</title>
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
		.d{margin-top: 20px; float:right;height: 300px;margin-right:100px}
		.e{float:center;margin-left: 5px;margin-top: 10px}
		.f{float:left;margin-left: 100px}
		a{color:#4876F1}
</style>

<script language="javascript" type="text/javascript">
	function show(){
		var now=new Date();
	   var astime = form1.astime.value;
	   var time = form1.time.value;
	   var day1=form1.day.value;
	   var day=now.getDate();
	   var hour=now.getHours();
	   if(astime==""||time==""){
		   alert("请输入起始时间和预约时长");
	   }
	   else if((parseInt(time))>=4){
		   alert("最多预约三小时");
	   }
	   else if((parseInt(astime))<8||(parseInt(astime)+parseInt(time))>20){
		   alert("预约时段超过机房开门时间");
	   }
	   else if(parseInt(day)>parseInt(day1)){
		   alert("请输入正确的日期");
	   }
	   else if(parseInt(hour)>parseInt(astime)&&parseInt(day)==parseInt(day1)){
		   alert("请输入正确的时间");
	   }
	   else if(parseInt(day)+2<=parseInt(day1)){
		   alert("最多可预约两天内的时段");
	   }
	   else{
		   alert("时间为"+astime+",时长为"+time);
		   document.getElementById("form1").submit(); 
	   }
   }
</script>
</head>
<body>
   <form action="OrderServlet" method="post" name="form1" id="form1">
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
				 <div class="e">
				 	<a href="ManagerServlet_stu?method=order&classno=${computer.classno }"><img src="./imgs/zuojiantou.png" width=40px;height=40px></a>
				 </div>		
		<center>
			<div class="f">
				 <center><p>设备信息</p></center>
				 <center>
				    <table>
				    	<input type="hidden" name="comid"  value="${sessionScope.computer.comid }">
					    <tr><td>设备编号：</td><td><input type="text" name="comno" value="${sessionScope.computer.comno }"readonly="true"></td></tr>
					    <tr><td>设备型号：</td><td><input type="text" name="version" value="${sessionScope.computer.version }"readonly="true"></td></tr>
					    <tr><td>所在机房号：</td><td><input type="text" name="classno" value="${sessionScope.computer.classno }"readonly="true"></td></tr>
					    <tr><td>设备状况：</td><td><input type="text" name="condition" value="${sessionScope.computer.condition }"readonly="true"></td></tr>
					    <tr><td>预约情况：</td><td><input type="text" name="appointment" value="${sessionScope.computer.appointment }"readonly="true"></td></tr>
					    <tr><td>待预约学号：</td><td><input type="text" name="sno" value="${loginUser.no }"readonly="true"></td></tr>
                        <tr><td>请输入预约的起始日期：</td><td><input type="text" name="day"></td></tr>
                        <tr><td>请输入预约的起始时间：</td><td><input type="text" name="astime"></td></tr>
                        <tr><td>请输入预约的时长：</td><td><input type="text" name="time"></td></tr>
                    </table>
                    <br>
                    <button type="button" onclick="show();">预约</button>    
				 </center>
	        </div>
			<div class="d">
				 <center>
				    <table>
				    <tr><td colspan="2"><center><span style="color:black">已被预约时段</span></center></td></tr>
				    	<c:forEach items= "${sessionScope.appointList }" var="appoint" varStatus="status">
					    <tr style="color:black"><td>起始时间：</td><td>${appoint.astime }</td></tr>
					    <tr style="color:black"><td>时长：</td><td>${appoint.time }</td></tr><br>
	                	</c:forEach>
	                </table>
                    <br>  
				 </center>
	        </div>	        
	     </center>
	  </div>   
   </form>

</body>
</html>