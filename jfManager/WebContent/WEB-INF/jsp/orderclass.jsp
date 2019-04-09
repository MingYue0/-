<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>机房选择</title>

<style>
		button{background-color:ivory;color:#705108}
		span{font-size: 20px; font-weight: bold;color:black}
        p{font-size: 20px; font-weight: bold;color:#836C0D}
		body {margin: 0;font-family: 'Lato', sans-serif; font-weight: 400;font-size: 15px;line-height: 25px;color: #333333;overflow-x: hidden;padding: 0;background-image:url(./imgs/bg.jpg);background-size:cover}
		.box{}
		.menu a:hover {background:#93A29D;color:white}
		.menu{border-bottom: 1px solid white;height: 85px;margin-top: 2px;width:100%}
		.b{margin-right: 10px; float:right;color:black;margin-bottom: auto;margin-top: 10px;color:white;font-family:幼圆;}
	    .b1{float:right;font-weight: 900;font-size: 150%;}
	    .c1{margin-left: 10px;float:left;height: 80px;margin-top: 15px}
		.d{margin-top: 60px; float:center;height: 250px}
		a{color:#4876F1}
		img{border-radius: 10px}
</style>

</head>
<body>
 	 <form action="ManagerServlet_stu" method="post">
	   <input type="hidden" name="method" value="${requestScope.method }">
       <input type="hidden" name="id" value="${requestScope.user.id }">
	   <div class="box">
		  <div class="menu">
			 <div class="b">
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;欢迎您：${sessionScope.loginUser.username }
			    <a href="LogoutServlet" style="text-decoration: none">注销</a><br><br>
				 <div class="b1">
			        <a href="ManagerServlet_stu?method=menu_stu"  style="text-decoration: none;color: slategray">首页</a>
	                <a href="ManagerServlet_stu?method=orderclass"  style="text-decoration: none;color: slategray">预约</a>
		            <a href="ManagerServlet_stu?method=orderview&no=${sessionScope.loginUser.no}"  style="text-decoration: none;color: slategray">我的预约</a>
		         </div>
		     </div>
			 <div class="c1">
				 <img src="./imgs/nchu.png" alt="" height="50px" >
		     </div>
		   </div>
		   <center>
		   <div class="d">
		      <a href="ManagerServlet_stu?method=order&classno=301" ><img src="./imgs/301.jpg" width="350px" height="250px"></a>
		      <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		      <a href="ManagerServlet_stu?method=order&classno=302" ><img src="./imgs/302.jpg" width="350px" height="250px" ></a>
		   </div>
		   <div class="d">
		      <a href="ManagerServlet_stu?method=order&classno=303" ><img src="./imgs/303.jpg" width="350px" height="250px" ></a>
		      <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		      <a href="ManagerServlet_stu?method=order&classno=304" ><img src="./imgs/304.jpg" width="350px" height="250px" ></a>
		   </div>
		   </center>
        </div>
     </form>
</body>
</html>
