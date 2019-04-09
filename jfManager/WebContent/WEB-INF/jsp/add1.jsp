<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
	<c:if test="${requestScope.method eq 'add1' }">添加用户</c:if>
	<c:if test="${requestScope.method eq 'edit1' }">编辑管理员信息</c:if>
</title>
<style>
		button{background-color:ivory;color:#705108}
		span{font-size: 20px; font-weight: bold;color:black}
        p{font-size: 20px; font-weight: bold;color:#836C0D}
		body {margin: 0;font-family: 'Lato', sans-serif; font-weight: 400;font-size: 15px;line-height: 25px;color: #333333;overflow-x: hidden;padding: 0;background-image:url(./imgs/bg.jpg);background-size:cover}
		.box{}
		a:hover {background:#93A29D;color:white}
		.menu{border-bottom: 1px solid white;height: 85px;margin-left: ;margin-right: ;margin-top: 2px;}
		.b{margin-right: 10px; float:right;color:black;margin-bottom: auto;margin-top: 10px;color:white;font-family:幼圆;}
	    .b1{float:right;font-weight: 900;font-size: 150%;}
	    .c1{margin-left: 10px;float:left;height: 80px;margin-top: 15px}
		.d{margin-top: 10px; float:center;height: 350px;}
		.e{float:right;margin-right: 20px;margin-top: 20px}
		a{color:#4876F1}
		input[type=text], input[type=file], input[type=password], input[type=email], select { border: 1px solid #DCDEE0; vertical-align: middle; border-radius: 3px; height: 30px; padding: 0px 16px; font-size: 14px; color: #555555; outline:none; width:100%;margin-bottom: 15px;line-height:50px; color:#888;}
		input[type=text]:focus, input[type=file]:focus, input[type=password]:focus, input[type=email]:focus, select:focus { border: 1px solid #27A9E3; }
		input[type=submit], input[type=button] { display: inline-block; vertical-align: middle; padding: 12px 24px; margin: 0px; font-size:16px; line-height: 24px; text-align: center; white-space: nowrap; vertical-align: middle; cursor: pointer; color: #ffffff; background-color: #27A9E3; border-radius: 3px; border: none; -webkit-appearance: none; outline:none; width:100%; }

</style>

<script type="text/javascript">
   var sex = '${requestScope.user.sex}';
   var usertype = '${requestScope.user.usertype}';
   function initRadioValue(){
	   if(sex != ''){
		   var sexArray = document.getElementsByName('sex');
		   for(var i=0;i<sexArray.length;i++){
			   if(sexArray[i].value == sex){
				   sexArray[i].checked = 'checked';
			   }
		   } 
	   }
	   if(usertype != ''){
		   var usertypeArray = document.getElementsByName('usertype');
		   for(var i=0;i<usertypeArray.length;i++){
			   if(usertypeArray[i].value == usertype){
				   usertypeArray[i].checked = 'checked';
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
    <form action="ManagerServlet" method="post">
	   <input type="hidden" name="method" value="${requestScope.method }">
      <input type="hidden" name="id" value="${requestScope.user.id }">
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
		<center>
	         	 <div class="d">
				 <center><h4 style="color:red">${message }</h4></center>
				 <center>
				 <center><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户信息</p></center>
					<table align="center">
         <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" value="${requestScope.user.username }"></td>
         </tr>
         <tr>
            <td>密码：</td>
            <td><input type="text" name="password" value="${requestScope.user.password }"></td>
         </tr>
         <tr>
            <td>工号：</td>
            <td><input type="text" name="no" value="${requestScope.user.no }"></td>
         </tr>
         <tr>
            <td>姓名：</td>
            <td><input type="text" name="name" value="${requestScope.user.name }"></td>
         </tr>
         <tr>
            <td>性别：</td>
            <td>
               <input type="radio" name="sex" value="男"><a style="color: #0C0202">男</a>
               <input type="radio" name="sex" value="女"><a style="color: #0C0202">女</a>
            </td>
         </tr>
         <tr>
            <td>学院：</td>
            <td><input type="text" name="department" value="${requestScope.user.department }"></td>
         </tr>
         <tr>
            <td>邮箱：</td>
            <td><input type="text" name="email" value="${requestScope.user.email }"></td>
         </tr>
         <tr>
            <td>联系电话：</td>
            <td><input type="text" name="telephone" value="${requestScope.user.telephone }"></td>
         </tr>
         <tr>
            <td>用户类型：</td>
            <td>
               <input type="radio" name="usertype" value="管理员"><a style="color: #0C0202">管理员</a>
               <input type="radio" name="usertype" value="学生"><a style="color: #0C0202">学生</a>
            </td>
         </tr>
         
         <tr>
              <td colspan="2" align="center">
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <button type="submit" >提交</button>
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
