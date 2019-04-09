<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询维修记录</title>
<style>
		button{background-color:ivory;color:#705108}
		span{font-size: 20px; font-weight: bold;font-family:幼圆;color: black;}
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
		input[type=text], input[type=file], input[type=password], input[type=email], select { border: 1px solid #DCDEE0; vertical-align: middle; border-radius: 3px; height: 20px; padding: 0px 16px; font-size: 14px; color: #555555; outline:none; width:50%;margin-bottom: 15px;line-height:50px; color:#888;}
		input[type=text]:focus, input[type=file]:focus, input[type=password]:focus, input[type=email]:focus, select:focus { border: 1px solid #27A9E3; }
		input[type=submit], input[type=button] { display: inline-block; vertical-align: middle; padding: 12px 24px; margin: 0px; font-size:16px; line-height: 24px; text-align: center; white-space: nowrap; vertical-align: middle; cursor: pointer; color: #ffffff; background-color: #27A9E3; border-radius: 3px; border: none; -webkit-appearance: none; outline:none; width:100%; }
		button{ display: inline-block; vertical-align: middle; padding: 12px 24px; margin: 0px; font-size:16px; line-height: 24px; text-align: center; white-space: nowrap; vertical-align: middle; cursor: pointer; color: #ffffff; background-color: #27A9E3; border-radius: 5px; border: none; -webkit-appearance: none; outline:none; width:70%; margin-left:10px;}

</style>


</head>
<body>
   <form action="ManagerServlet_jadmin" method="get">
	   <input type="hidden" name="method" value="findRepairListJa">
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
					<a href="ManagerServlet_jadmin?method=findSelectJa"><img src="./imgs/zuojiantoub.png" width=40px height=40px></a>
			    </div>		 
		<center>
	    <div class="d">
		<center>
		<table>
			<tr>
				<td colspan="2" style="color: black">
					<center><input type="radio" name="queryType" value="1" checked="checked" onclick="document.getElementById('patent1').style.visibility='hidden';document.getElementById('patent3').style.visibility='hidden';document.getElementById('patent4').style.visibility='hidden';"><span>查询所有维修记录</span></center><br>
					<center><input type="radio" name="queryType" value="2" onclick="document.getElementById('patent1').style.visibility='visible';document.getElementById('patent3').style.visibility='hidden';document.getElementById('patent4').style.visibility='hidden';"><span>查询机房维修记录</span></center>
					<center><input id="patent1" value="输入机房号" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="visibility:hidden; color:#999999" type="text" name="queryString2"/></center>
					<center><input type="radio" name="queryType" value="4" onclick="document.getElementById('patent1').style.visibility='hidden';document.getElementById('patent3').style.visibility='visible';document.getElementById('patent4').style.visibility='visible';"><span>查询电脑维修记录</span></center>
					<center><input id="patent3" value="输入机房号" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="visibility:hidden; color:#999999" type="text" name="queryString4"/></center>
					<center><input id="patent4" value="输入电脑编号" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="visibility:hidden; color:#999999" type="text" name="queryString5"/></center>
					
				</td>
				
			</tr>
			<tr height="5px"></tr>
			<tr>
				<center><td align="center"><button type="submit" >查询</button></td></center>
			</tr>
		</table>
		</center>
	    </div>
	     </center>
	  </div>  
	   
   </form>

</body>
</html>
