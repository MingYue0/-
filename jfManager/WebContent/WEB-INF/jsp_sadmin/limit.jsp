<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
	设置机房不可用学时
</title>
<style>
		span{font-size: 20px; font-weight: bold;font-family:幼圆;color: black;}
		button{ display: inline-block; vertical-align: middle; padding: 12px 24px; margin: 0px; font-size:16px; line-height: 24px; text-align: center; white-space: nowrap; vertical-align: middle; cursor: pointer; color: #ffffff; background-color: #27A9E3; border-radius: 5px; border: none; -webkit-appearance: none; outline:none; width:30%; margin-left:10px;}
        p{font-size: 20px; font-weight: bold;color:#836C0D}
		body {margin: 0;font-family: 'Lato', sans-serif; font-weight: 400;font-size: 15px;line-height: 25px;color: #333333;overflow-x: hidden;padding: 0;background-image:url(./imgs/bg.jpg);background-size:cover}
		.box{}
		.menu a:hover {background:#93A29D;color:white}
		.menu{border-bottom: 1px solid white;height: 85px;margin-left: ;margin-right: ;margin-top: 2px;}
		.b{margin-right: 10px; float:right;color:black;margin-bottom: auto;margin-top: 10px;color:white;font-family:幼圆;}
	    .b1{float:right;font-weight: 900;font-size: 150%;}
	    .c1{margin-left: 10px;float:left;height: 80px;margin-top: 15px}
		.d{margin-top: 100px; float:center;height: 300px;}
		.e{float:right;margin-right: 20px;margin-top: 20px}
		a{color:#4876F1}
		input[type=text], input[type=file], input[type=password], input[type=email], select { border: 1px solid #DCDEE0; vertical-align: middle; border-radius: 3px; height: 30px; padding: 0px 16px; font-size: 14px; color: #555555; outline:none; width:50%;margin-bottom: 15px;line-height:50px; color:#888;}
		input[type=text]:focus, input[type=file]:focus, input[type=password]:focus, input[type=email]:focus, select:focus { border: 1px solid #27A9E3; }
		input[type=submit], input[type=button] { display: inline-block; vertical-align: middle; padding: 12px 24px; margin: 0px; font-size:16px; line-height: 24px; text-align: center; white-space: nowrap; vertical-align: middle; cursor: pointer; color: #ffffff; background-color: #27A9E3; border-radius: 3px; border: none; -webkit-appearance: none; outline:none; width:100%; }

</style>
</head>
<body>
   <form action="LimitServlet" method="post">
	  <div class="box">
		 <div class="menu">
			 <div class="b">
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;欢迎您：${sessionScope.loginUser.username }
			    <a href="LogoutServlet" style="text-decoration: none">注销</a><br><br>
				 <div class="b1">
					 <a href="ManagerServlet?method=menu_sadmin" style="text-decoration: none;color: white">首页</a>
	                 <a href="ManagerServlet_sadmin?method=manager" style="text-decoration: none;color: white">用户管理</a>
		             <a href="ManagerServlet_sadmin?method=add_seclet" style="text-decoration: none;color: white">添加用户</a>
		             <a href="ManagerServlet_sadmin?method=find_select" style="text-decoration: none;color: white">查看</a>
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
	    <table align="center">
         <tr>
            <td><span>电脑编号：</span></td>
            <td width="200px"><input type="text" name="comno1" style="height: 30px; width:20%"><span>&nbsp;---&nbsp;</span><input type="text" name="comno2"style="height: 30px; width:20%"></td>
         </tr>
         <tr>
            <td><span>机房编号：</span></td>
            <td><input type="text" name="classno" style="height: 30px;width:85%"></td>
         </tr>
         <tr>
            <td><span>开始时间：</span></td>
            <td width="200px"><input type="text" name="lstime1" style="height: 30px; width:20%" value="日" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="visibility:hidden; color:#999999"><span>&nbsp;&nbsp;&nbsp;</span><input type="text" name="lstime2" style="height: 30px; width:20%" value="时" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="visibility:hidden; color:#999999"></td>
         </tr>
         
         <tr>
            <td><span>结束时间：</span></td>
            <td width="200px"><input type="text" name="letime1" style="height: 30px; width:20%" value="日" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="visibility:hidden; color:#999999"><span>&nbsp;&nbsp;&nbsp;</span><input type="text" name="letime2" style="height: 30px; width:20%" value="时" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="visibility:hidden; color:#999999"></td>
         </tr>
         <tr>
            <td><span>禁用原因：</span></td>
            <td><input type="text" name="reason" style="height: 30px;width:85%"></td>
         </tr>
                 
         <tr>
              <td colspan="2" align="center">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <button type="submit" >提交</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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