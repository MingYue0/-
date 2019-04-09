<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加方式</title>
<style>
        span{font-size: 20px; font-weight: bold;color:black}
        p{font-size: 20px; font-weight: bold;color:#836C0D}
		body {margin: 0;font-family: 'Lato', sans-serif; font-weight: 400;font-size: 15px;line-height: 25px;color: #333333;overflow-x: hidden;padding: 0;background-image:url(./imgs/bg.jpg);background-size:cover}
		.box{}
		.menu a:hover {background:#93A29D;color:white}
		.menu{border-bottom: 1px solid white;height: 85px;margin-left: ;margin-right: ;margin-top: 2px;}
		.b{margin-right: 10px; float:right;color:black;margin-bottom: auto;margin-top: 10px;color:white;font-family:幼圆;}
	    .b1{float:right;font-weight: 900;font-size: 150%;}
	    .c1{margin-left: 10px;float:left;height: 80px;margin-top: 15px}
		.d{margin-top: 60px; float:center;height: 300px}
		a{color:#4876F1}
</style>
</head>
<body>
<form method="post" action="UploadServlet_com" enctype="multipart/form-data">
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
	     <div class="d">
			  <center>
			      <table background="bg.jpg" width="400" height="200">
			      	<tr>
    					<td align="right">选择文件：</td>	
    					<td > <input type="file" name="file1"></td>
    				</tr>
    				<tr>
    					<td align="center"></td>
    					<td > <input type="submit" value="开始上传"></td>
   					</tr>
			      </table>
			  </center>
	     </div>
	 </div>
	</form>
</body>
</html>