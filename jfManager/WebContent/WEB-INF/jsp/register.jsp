<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<meta http-equiv="Pragma" content="no-cache"> 
<meta http-equiv="Cache-Control" content="no-cache"> 
<meta http-equiv="Expires" content="0"> 
<title>账号注册</title>
	<style>
		@charset "utf-8";
.tip{color:dimgray;margin-top: 15px}
* { font: 13px/1.5 '微软雅黑'; -webkit-box-sizing: border-box; -moz-box-sizing: border-box; -box-sizing: border-box; padding:0; margin:0; list-style:none; box-sizing: border-box; }
body, html { height:100%;}
body { background:#3B5998; background-size: cover; }
a { color:#27A9E3; text-decoration:none; cursor:pointer; }
img{ border:none;}

.login_box{ width:1100px; margin:120px auto 0;}
.login_box .login_l_img{ float:left; width:432px; height:440px; margin-left:50px;}
.login_box .login_l_img img{width:500px; height:440px; }
.login {height:500px; width:400px; padding:20px; background-color: #ffffff;border-radius:6px;box-sizing: border-box; float:right; margin-right:50px; position:relative; margin-top:50px;}
.login_logo{ width:120px; height:120px; border:5px solid #93defe;border-radius:100px; background:#fff; text-align:center; line-height:110px; position:absolute; top:-60px; right:140px;}
.login_name{ width:100%; float:left; text-align:center;}
.login_name p{ width:100%; text-align:center; font-size:18px; color:#444; padding:10px 0 20px;}
.login_logo img{ width:60px; height:60px;display: inline-block; vertical-align: middle;}
input[type=text], input[type=file], input[type=password], input[type=email], select { border: 1px solid #DCDEE0; vertical-align: middle; border-radius: 3px; height: 30px; padding: 0px 16px; font-size: 14px; color: #555555; outline:none; width:100%;margin-bottom: 15px;line-height:50px; color:#888;}
input[type=text]:focus, input[type=file]:focus, input[type=password]:focus, input[type=email]:focus, select:focus { border: 1px solid #27A9E3; }
input[type=submit], input[type=button] { display: inline-block; vertical-align: middle; padding: 12px 24px; margin: 0px; font-size:16px; line-height: 24px; text-align: center; white-space: nowrap; vertical-align: middle; cursor: pointer; color: #ffffff; background-color: #27A9E3; border-radius: 3px; border: none; -webkit-appearance: none; outline:none; width:100%; }
.copyright { font-size:14px; color:#fff; display:block;width:100%; float:left; text-align:center; margin-top:60px;}

#password_text{border: 1px solid #DCDEE0; vertical-align: middle; border-radius: 3px; height: 50px; padding: 0px 16px; font-size: 14px; color: #888; outline:none; width:100%;margin-bottom: 15px;display: block; line-height:50px;}
	</style>
	<script type="text/javascript">
      function validateForm(){
    	  var username = document.getElementById("username").value;
    	  var password = document.getElementById("password").value;
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
          
          <div class="login_name">
               <p>账号注册</p>
          </div>
          <form action="ManagerServlet" method="post" onsubmit="return validateForm();">
          <input type="hidden" name="method" value="${requestScope.method }">
          <input type="hidden" name="usertype" value="学生">
              <center>
					<table align="center">
         <tr>
            <td>用户名：</td>
            <td><input id="username" type="text" name="username"></td>
         </tr>
         <tr>
            <td>密码：</td>
            <td><input id="password" type="text" name="password"></td>
         </tr>
         <tr>
            <td>学号：</td>
            <td><input type="text" name="no"></td>
         </tr>
         <tr>
            <td>姓名：</td>
            <td><input type="text" name="name"></td>
         </tr>
         <tr>
            <td>性别：</td>
            <td>
               <input type="radio" name="sex" value="男" checked="checked"><a>男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
               <input type="radio" name="sex" value="女"><a>女</a>
            </td>
         </tr>
         <tr>
            <td>学院：</td>
            <td><input type="text" name="department"></td>
         </tr>
         <tr>
            <td>邮箱：</td>
            <td><input type="text" name="email"></td>
         </tr>
         <tr>
            <td>联系电话：</td>
            <td><input type="text" name="telephone"></td>
         </tr>
         <tr>
              <td colspan="2" align="center">
                 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input value="注册" style="width:40%;" type="submit">
              </td> 
         </tr>
      </table>
				 </center>	
			  
          </form>
      </div>
     
</body>
</html>