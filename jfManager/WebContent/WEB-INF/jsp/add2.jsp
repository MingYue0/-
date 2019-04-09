<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
	<c:if test="${requestScope.method eq 'add2' }">添加设备</c:if>
	<c:if test="${requestScope.method eq 'edit2' || requestScope.method eq 'editComNow'}">编辑设备信息</c:if>
</title>
<style>
		button{background-color:ivory;color:#705108}
		span{font-size: 20px; font-weight: bold;color:black}
        p{font-size: 20px; font-weight: bold;color:#836C0D}
		body {margin: 0;font-family: 'Lato', sans-serif; font-weight: 400;font-size: 15px;line-height: 25px;color: #333333;overflow-x: hidden;padding: 0;background-image:url(./imgs/bg.jpg);background-size:cover}
		.box{}
		.menu a:hover {background:#93A29D;color:white}
		.menu{border-bottom: 1px solid white;height: 85px;margin-left: ;margin-right: ;margin-top: 2px;}
		.b{margin-right: 10px; float:right;color:black;margin-bottom: auto;margin-top: 10px;color:white;font-family:幼圆;}
	    .b1{float:right;font-weight: 900;font-size: 150%;}
	    .c1{margin-left: 10px;float:left;height: 80px;margin-top: 15px}
		.d{margin-top: 30px; float:center;height: 250px}
		.e{float:center;margin-left: 5px;margin-top: 10px}
		a{color:#4876F1}
		input[type=text], input[type=file], input[type=password], input[type=email], select { border: 1px solid #DCDEE0; vertical-align: middle; border-radius: 3px; height: 30px; padding: 0px 16px; font-size: 14px; color: #555555; outline:none; width:100%;margin-bottom: 15px;line-height:50px; color:#888;}
		input[type=text]:focus, input[type=file]:focus, input[type=password]:focus, input[type=email]:focus, select:focus { border: 1px solid #27A9E3; }
		input[type=submit], input[type=button] { display: inline-block; vertical-align: middle; padding: 12px 24px; margin: 0px; font-size:16px; line-height: 24px; text-align: center; white-space: nowrap; vertical-align: middle; cursor: pointer; color: #ffffff; background-color: #27A9E3; border-radius: 3px; border: none; -webkit-appearance: none; outline:none; width:100%; }
		button{ display: inline-block; vertical-align: middle; padding: 12px 24px; margin: 0px; font-size:16px; line-height: 24px; text-align: center; white-space: nowrap; vertical-align: middle; cursor: pointer; color: #ffffff; background-color: #27A9E3; border-radius: 5px; border: none; -webkit-appearance: none; outline:none; width:30%;}

</style>

<script type="text/javascript">
   var appointment = '${requestScope.computer.appointment}';
   var condition = '${requestScope.computer.condition}';
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
   function initRadioValue2(){
	   if(condition != ''){
		   var conditionArray = document.getElementsByName('condition');
		   for(var i=0;i<conditionArray.length;i++){
			   if(conditionArray[i].value == condition){
				   conditionArray[i].checked = 'checked';
			   }
		   }
	   }
   }
   window.onload = function(){
	   initRadioValue();
	   initRadioValue2();
   }
</script>
</head>
<body>
<c:if test="${requestScope.method eq 'edit2' || requestScope.method eq 'add2'}">
   <form action="ManagerServlet" method="post">
</c:if>
<c:if test="${requestScope.method eq 'editComNow'}">
   <form action="ManagerServlet_jadmin" method="post">
</c:if>
	   <input type="hidden" name="method" value="${requestScope.method }">
      <input type="hidden" name="comid" value="${requestScope.computer.comid }">
	  <div class="box">
		 <div class="menu">
			 <div class="b">
				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			          欢迎您：${sessionScope.loginUser.username }
				 <a href="LogoutServlet" style="text-decoration: none">注销</a><br><br>
				 <div class="b1">
					 <a href="ManagerServlet?method=menu_admin" style="text-decoration: none;color: slategray">首页</a>
	                 <a href="ManagerServlet_jadmin?method=comManagePlan" style="text-decoration: none;color: slategray">设备管理</a>
		             <a href="ManagerServlet_jadmin?method=addSelectJa" style="text-decoration: none;color: slategray">添加设备</a>
		             <a href="ManagerServlet_jadmin?method=findSelectJa" style="text-decoration: none;color: slategray">查看</a>
				 </div>
		     </div>
			 <div class="c1">
				 <img src="./imgs/nchu.png" alt="" height="50px" >
		     </div>
		 </div>
		 <c:if test="${requestScope.method eq 'add2' }">
				 <div class="e">
					<a href="ManagerServlet_jadmin?method=addSelectJa"><img src="./imgs/zuojiantou.png" width=40px height=40px></a>
			    </div>
		</c:if>	    		 
		<center>
			 <div class="d">
				 <center><h4 style="color:red">${message }</h4></center>
				 <center><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;设备信息</p></center>
				 <center>
		            <table align="center">
                       <tr>
                           <td>型号：</td>
                           <td><input type="text" name="version" value="${requestScope.computer.version }"></td>
                       </tr>
                       <tr>
                           <td>机房号：</td>
                           <td><input type="text" name="classno" value="${requestScope.computer.classno }"></td>
                       </tr>
                       <tr>
                           <td>电脑编号：</td>
                           <td><input type="text" name="comno" value="${requestScope.computer.comno }"></td>
                       </tr>
                       <tr>
                           <td>系统配置：</td>
                           <td><input type="text" name="configuration" value="${requestScope.computer.configuration }"></td>
                       </tr>
                       <tr>
                           <td>预装软件：</td>
                           <td><input type="text" name="software" value="${requestScope.computer.software }"></td>
                       </tr>
                       <tr>
                           <td>负责人：</td>
                           <td><input type="text" name="director" value="${requestScope.computer.director }"></td>
                       </tr>
                       <tr>&nbsp;</tr>
		               <tr>
                           <td colspan="2" align="center"><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                <button type="submit" >提交</button><span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                <button type="reset">重置</button>
                           </td>   
                       </tr>
                     </table>
				 </center>
	         </div>
	     </center>
	  </div>   
   </form>

</body>
</html>
