<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
<style>
		p{font-size: 20px; font-weight: bold;color:ivory}
		body {margin: 0;font-family: 'Lato', sans-serif; font-weight: 400;font-size: 15px;line-height: 25px;color: #333333;overflow-x: hidden;padding: 0;background-image:url(./imgs/bg5.png)}
		td{color: #839ccf}
		.box{}
		.menu{border-radius:10px;background-color:aliceblue;height: 50px;margin-left: ;margin-right: ;margin-top:2px}
		.b{margin-right: 10px; float:right;color:#3D444C;margin-bottom: auto;margin-top: 10px}
	    .c{margin-left: 10px;color: mediumvioletred;margin-bottom: auto}
		.cen{}
		.d{height:420px; width:400px; padding:20px; background-color:#3B5998;;border-radius:6px;box-sizing: border-box;position:relative; margin-top:50px;}
		.e{float:center;margin-top: 80px}
		.f1{float:left; margin-top:50px;margin-left: 100px}
		.f2{float:left; margin-top:50px;margin-left: 10px}
		a{color:#4876F1}
</style>

</head>
<body>
   <form action="ManagerServlet_stu" method="post">
	  <input type="hidden" name="method" value="${requestScope.method }">
      <input type="hidden" name="id" value="${requestScope.user.id }">
      <input type="hidden" name="username" value="${requestScope.user.username }">
      <input type="hidden" name="no" value="${requestScope.user.no }">
      <input type="hidden" name="name" value="${requestScope.user.name }">
      <input type="hidden" name="sex" value="${requestScope.user.sex }">
      <input type="hidden" name="department" value="${requestScope.user.department }">
      <input type="hidden" name="email" value="${requestScope.user.email }">
      <input type="hidden" name="telephone" value="${requestScope.user.telephone }">
      <input type="hidden" name="usertype" value="${requestScope.user.usertype }">
	  <div class="box">
		 <div class="menu">
			 <div class="b">
			     欢迎您：${sessionScope.loginUser.username }
			     <a href="LogoutServlet">注销</a>
		     </div>
		     <div class="c">
				 <img src="./imgs/nchu.png" alt="" width="230px">
		     </div>
		 </div>
		 <center>
		 <div class="d">
			<center><h4 style="color:red">${message }</h4></center>
		    <center>
               <center><p>修改密码</p></center><br>
               <span style="color:white">请输入新密码：<input type="text" name="password" value="${requestScope.user.password }"></span><br><br>
               <td colspan="2" align="center">
                   <button type="submit" >提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                   <button type="reset">重置</button>
               </td>
			</center>
			<div class="e">
				<a href="ManagerServlet_stu?method=menu_stu"><img src="./imgs/fanhui.png" width=50px;height=50px></a>
			</div>	
	     </div>
	     </center>
	 </div>
      
      
   </form>

</body>
</html>