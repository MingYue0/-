<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择要管理的机房</title>

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
</style>

</head>
<body>
 	 <form action="ManagerServlet_jadmin" method="post">
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
					<a href="ManagerServlet?method=menu_admin"><img src="./imgs/zuojiantou.png" width=40px height=40px></a>
			    </div>		   
		   <center>
		   <div class="d">
		      <a href="ManagerServlet_jadmin?method=typeSelect&classno=301" ><img src="./imgs/301.jpg" width="350px" height="250px"></a>
		      <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		      <a href="ManagerServlet_jadmin?method=typeChoose&classno=302" ><img src="./imgs/302.jpg" width="350px" height="250px" ></a>
		   </div>
		   <div class="d">
		      <a href="ManagerServlet_jadmin?method=typeSelect&classno=303" ><img src="./imgs/303.jpg" width="350px" height="250px" ></a>
		      <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		      <a href="ManagerServlet_jadmin?method=typeSelect&classno=304" ><img src="./imgs/304.jpg" width="350px" height="250px" ></a>
		   </div>
		   </center>
        </div>
     </form>
</body>
</html>
