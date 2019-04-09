<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑电脑信息</title>
<style>
        p{font-size: 20px; font-weight: bold;color:#836C0D}
		body {margin: 0;font-family: 'Lato', sans-serif; font-weight: 400;font-size: 15px;line-height: 25px;color: #333333;overflow-x: hidden;padding: 0;background-image:url(./imgs/bg.jpg);background-size:cover}

		.box{}
	    .menu a:hover {background:#93A29D;color:white}
		.menu{border-bottom: 1px solid white;height: 85px;margin-left: ;margin-right: ;margin-top: 2px;}
		.b{margin-right: 10px; float:right;color:black;margin-bottom: auto;margin-top: 10px;color:white;font-family:幼圆;}
	    .b1{float:right;font-weight: 900;font-size: 150%;}
	    .c1{margin-left: 10px;float:left;height: 80px;margin-top: 15px}
		.d{margin-top: 0px; float:center;height: 300px}
	    .e{float:center;margin-left: 10px;margin-top: 10px}
		a{color:#4876F1;text-decoration: none;}
	
	</style>
</head>
<body>
   <form action="ManagerServlet" method="post"></form>
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
			     <div class="e">
						 <a href="ManagerServlet_jadmin?method=comList&classno=${requestScope.computer.classno}"><img src="./imgs/zuojiantou.png" width=40px;height=40px></a>
			     </div>		     
	     <div class="d">
			     <center>
							
						<div style="color: #242262;width: 220px;height: 350px;border-radius: 10px;background: #FFFFFF;float: center;margin-top: 0px">
                        <br>
                        <center>
                        <table>
                            <tr><td>型号:</td><td>${requestScope.computer.version }</td></tr>
                            <tr><td>教室编号:</td><td>${requestScope.computer.classno }</td></tr>
                            <tr><td>电脑编号:</td><td>${requestScope.computer.comno }</td></tr>
                            <tr><td>状态:</td><td>${requestScope.computer.condition }</td></tr>
                            <tr><td>预约:</td><td>${requestScope.computer.appointment }</td></tr>
                            <tr><td>预约学号:</td><td>${requestScope.computer.sno }</td></tr>
                            <tr><td>系统配置:</td><td>${requestScope.computer.configuration }</td></tr>
                            <tr><td>预装软件:</td><td>${requestScope.computer.software }</td></tr>
                            <tr><td>负责人:</td><td>${requestScope.computer.director }</td></tr>
                        </table>
                            <a href="ManagerServlet_jadmin?method=editComNow&comid=${requestScope.computer.comid}">编辑</a>
                            <a href="ManagerServlet_jadmin?method=repairNow&comid=${requestScope.computer.comid}">报修</a>
                            <a href="ManagerServlet_jadmin?method=normalNow&comid=${requestScope.computer.comid}">报修完成</a>
                            <a onclick="return window.confirm('确认要删除当前记录吗?');" href="ManagerServlet_jadmin?method=deleteComNow&comid=${requestScope.computer.comid }&classno=${requestScope.computer.classno }">删除</a> 
                     </center>
						</div>
					
			     </center>

	         </div>
	 </div>
	  
   </form>   

</body>
</html>
