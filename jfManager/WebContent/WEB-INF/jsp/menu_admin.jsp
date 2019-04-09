<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页</title>
    <style>
        p{font-size: 20px; font-weight: bold;color:ivory}
		body {margin: 0;font-family: 'Lato', sans-serif; font-weight: 400;font-size: 15px;line-height: 25px;color: #333333;overflow-x: hidden;padding: 0;background-image:url(./imgs/bg.jpg);background-size:cover}
		td{color: #839ccf}
		.box{}
		.menu a:hover {background:#93A29D;color:white}
		.menu{border-bottom: 1px solid white;height: 85px;margin-top: 2px;width:100%}
		.b{margin-right: 10px; float:right;color:black;margin-bottom: auto;margin-top: 10px;color:white;font-family:幼圆;}
	    .b1{float:right;font-weight: 900;font-size: 150%;}
	    .c1{margin-left: 10px;float:left;height: 80px;margin-top: 15px}
	    .c{margin-left: 10px;color: mediumvioletred;margin-bottom: auto}
		.cen{float: left;width: 100%}
		.d{height:420px; width:400px; padding:20px; background-color:#3B5998;border-radius:6px;box-sizing: border-box; float:right;position:relative; margin-top:100px;margin-right: 50px}
		.e{float:center;margin-top: 30px}
		.f{float:left;margin-left: 70px}
		.f1{float:left; margin-top:30px;margin-left: 30px}
		.f2{float:left; margin-top:30px;margin-left: 30px}
		.f img{border-radius: 10px}
		.f span{color:black;font-family:幼圆;font-weight: 900;}
		a{color:#4876F1;text-decoration: none;}
	
	</style>
</head>
<body>
   <form action="MenuServlet" method="post">
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
			 <div class="cen">
				 <div class="f">
						 <div class="f1">
							 <a href="ManagerServlet_jadmin?method=findUseListJa&queryType=1"><img src="./imgs/am1.png" alt="" height="150px" width="150px"></a><br>
						     <span>使用记录</span><br><br>
							 <a href="ManagerServlet_jadmin?method=analyseSelect"><img src="./imgs/am2.png" alt="" height="150px" width="150px"></a><br>
						     <span>机房分析</span><br><br>
							 <a href="ManagerServlet_jadmin?method=deleteClassSelect"><img src="./imgs/am3.png" alt="" height="150px" width="150px"></a><br>
						     <span>删除机房</span>
						 </div>	
						 <div class="f2">
							 <a href="ManagerServlet_jadmin?method=findRepairListJa&queryType=1"><img src="./imgs/am4.png" alt="" height="150px" width="150px"></a><br>
						     <span>维修记录</span><br><br>
							 <a href="ManagerServlet_jadmin?method=typeChoose"><img src="./imgs/am5.png" alt="" height="150px" width="150px"></a><br>
						     <span>机房布局</span><br><br>
							 <a href="LogoutServlet"><img src="./imgs/am6.png" alt="" height="150px" width="150px"></a><br>
						     <span>添加设备</span>
						 </div>		 
					 </div>
				 
				 <div class="d">
				 <center><p>个人信息</p></center>
				 <center>
					 <table>
						 <tr>
							 <td>姓名：</td>
							 <td>${sessionScope.loginUser.name }</td>
						 </tr>
						 <tr>
						     <td>工号：</td>
							 <td>${sessionScope.loginUser.no }</td>
						 </tr>
						 <tr>
							 <td>学院：</td>
							 <td>${sessionScope.loginUser.department }</td>
						 </tr>
						 <tr>
							 <td>性别：</td>
							 <td>${sessionScope.loginUser.sex }</td>
						 </tr>
						 <tr>
							 <td>联系电话：</td>
							 <td>${sessionScope.loginUser.telephone }</td>
						 </tr>
						 <tr>
							 <td>邮箱：</td>
							 <td>${sessionScope.loginUser.email }</td>
						 </tr>
						 <tr>
							 <td>用户类型：</td>
							 <td>${sessionScope.loginUser.usertype }</td>
						 </tr>
					 </table>
					 <div class="e">
					     <a href="ManagerServlet?method=edit_adpassword&id=${sessionScope.loginUser.id}">修改密码</a>
						 &nbsp;&nbsp;<a href="ManagerServlet?method=edit1&id=${sessionScope.loginUser.id}">编辑个人信息</a>
					 </div>
				 </center> 
	        </div>
			 </div>

	     </center>    
	     </div>
   </form>   

</body>
</html>