<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>机房管理</title>
	<style>
		@charset "utf-8";
.tip{color:red;margin-top: 15px}
* { font: 13px/1.5 '微软雅黑'; -webkit-box-sizing: border-box; -moz-box-sizing: border-box; -box-sizing: border-box; padding:0; margin:0; list-style:none; box-sizing: border-box; }
body, html { height:100%; overflow:hidden; }
body { background:#3B5998; background-size: cover; }
a { color:#27A9E3; text-decoration:none; cursor:pointer; }
img{ border:none;}

.login_box{ width:1100px; margin:120px auto 0;}
.login_box .login_l_img{ float:left; width:432px; height:440px; margin-left:50px;}
.login_box .login_l_img img{width:500px; height:440px; }
.login {height:400px; width:400px; padding:50px; background-color: #ffffff;border-radius:6px;box-sizing: border-box; float:right; margin-right:50px; position:relative; margin-top:50px;}
.login_logo{ width:120px; height:120px; border:5px solid #93defe;border-radius:100px; background:#fff; text-align:center; line-height:110px; position:absolute; top:-60px; right:140px;}
.login_name{ width:100%; float:left; text-align:center; margin-top:20px;}
.login_name p{ width:100%; text-align:center; font-size:18px; color:#444; padding:10px 0 20px;}
.login_logo img{ width:60px; height:60px;display: inline-block; vertical-align: middle;}
input[type=text], input[type=file], input[type=password], input[type=email], select { border: 1px solid #DCDEE0; vertical-align: middle; border-radius: 3px; height: 50px; padding: 0px 16px; font-size: 14px; color: #555555; outline:none; width:100%;margin-bottom: 15px;line-height:50px; color:#888;}
input[type=text]:focus, input[type=file]:focus, input[type=password]:focus, input[type=email]:focus, select:focus { border: 1px solid #27A9E3; }
input[type=submit], input[type=button] { display: inline-block; vertical-align: middle; padding: 12px 24px; margin: 0px; font-size:16px; line-height: 24px; text-align: center; white-space: nowrap; vertical-align: middle; cursor: pointer; color: #ffffff; background-color: #27A9E3; border-radius: 3px; border: none; -webkit-appearance: none; outline:none; width:100%; }

#password_text{border: 1px solid #DCDEE0; vertical-align: middle; border-radius: 3px; height: 50px; padding: 0px 16px; font-size: 14px; color: #888; outline:none; width:100%;margin-bottom: 15px;display: block; line-height:50px;}
	</style>
	<script type="text/javascript">
      function validateForm(){
    	  var username = document.getElementById("username").value;
    	  var password = document.getElementById("password").value;
    	  var usertype = document.getElementById("usertype").value;
    	  if(username == null || username == ""){
    		  alert("用户名不能为空!!!");
    		  return false;
    	  }
    	  if(password == null || password == ""){
    		  alert("密码不能为空!!!");
    		  return false;
    	  }
      }
   </script>
<link href="login.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="login_box">
      <div class="login_l_img"><img src="./imgs/login_img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="#"><img src="./imgs/login_logo.png" /></a></div>
          <div class="login_name">
               <p>机房管理系统</p>
          </div>
          <form action="LoginServlet" method="post" onsubmit="return validateForm();">
              <input id="usertype" name="username" type="text"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
              <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
              <input name="password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
			  <center>
			      <input type="radio" id="usertype" value ="系统管理员"  style="color: dimgrey" name="usertype" checked="checked">系统管理员&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  <input type="radio" id="usertype" value ="管理员"  style="color: dimgrey" name="usertype">机房管理员&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="radio" id="usertype" value ="学生"  style="color: dimgrey" name="usertype">学生
                  
			  </center><br>
			  
              <input value="登录" style="width:100%;" type="submit"><br>
              <br><center><a href="ManagerServlet?method=register">注册</a></center>
			  <center><div class="tip">${requestScope.message }</div></center>
			  
          </form>
      </div>
     
</body>
</html>
