<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择管理的电脑</title>
<style>
        p{font-size: 20px; font-weight: bold;color:#836C0D}
		body {margin: 0;font-family: 'Lato', sans-serif; font-weight: 400;font-size: 15px;line-height: 25px;color: #333333;overflow-x: hidden;padding: 0;background-image:url(./imgs/bg.jpg);background-size:cover}

		.box{}
	    .menu a:hover {background:#93A29D;color:white}
		.menu{border-bottom: 1px solid white;height: 85px;margin-left: ;margin-right: ;margin-top: 2px;}
		.b{margin-right: 10px; float:right;color:black;margin-bottom: auto;margin-top: 10px;color:white;font-family:幼圆;}
	    .b1{float:right;font-weight: 900;font-size: 150%;}
	    .c1{margin-left: 10px;float:left;height: 80px;margin-top: 15px}
		.d{margin-top: 0px; float:center;height: 300px}
	    .e{float:center;margin-left: 5px;margin-top: 10px}
	    .all{float:right;margin-right: 5px;margin-top: 10px}
		a{color:#4876F1;text-decoration: none;}
	    .f1{float:left;}
	
	</style>
</head>
<body>
   <form action="ManagerServlet_stu" method="post">
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
				 <div class="all">
					<a onclick="return window.confirm('确认要删除所有电脑吗?');" href="ManagerServlet_jadmin?method=deleteAllCom&classno=${requestScope.classno }">删除所有电脑</a>
			    </div>				   
				 <div class="e">
					<a href="ManagerServlet_jadmin?method=classList"><img src="./imgs/zuojiantou.png" width=40px height=40px></a>
			    </div>		
		       
		   <center>
		   <div class="d">
				<center>
				<c:if test="${requestScope.type eq '1'}">
				   <c:forEach items= "${requestScope.comList }" var="computer" varStatus="status">
					   <c:choose>
					       <c:when test="${computer.condition eq 'normal'}">
							     <a href="ManagerServlet_jadmin?method=editCom&comid=${computer.comid}"><img src="./imgs/light.png" ></a>   
							     <c:if test="${status.count%10==0 }"><br><br><br></c:if>   
							     <c:if test="${status.count%5==0 && (status.count/5)%2!=0}"><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></c:if>
					       
					       </c:when>
					       <c:otherwise>
							     <a href="ManagerServlet_jadmin?method=editCom&comid=${computer.comid}"><img src="./imgs/dark.png" ></a>
					             <c:if test="${status.count%10==0 }"><br><br><br></c:if>
					             <c:if test="${status.count%5==0 && (status.count/5)%2!=0}"><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></c:if>
					       </c:otherwise>
					    </c:choose>
				    </c:forEach>
				</c:if>
				<c:if test="${requestScope.type eq '2'}">   
				   <c:forEach items= "${requestScope.comList }" var="computer" varStatus="status">
					   <c:choose>
					       <c:when test="${computer.condition eq 'normal'}">
							     <a href="ManagerServlet_jadmin?method=editCom&comid=${computer.comid}"><img src="./imgs/light.png" ></a>   
							     <c:if test="${status.count%10==0 }"><br><br><br></c:if>   
							     <c:if test="${status.count==3 || status.count==13 || status.count==23 || status.count==7 || status.count==17 || status.count==27}"><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></c:if>
					       
					       </c:when>
					       <c:otherwise>
							     <a href="ManagerServlet_jadmin?method=editCom&comid=${computer.comid}"><img src="./imgs/dark.png" ></a>
					             <c:if test="${status.count%10==0 }"><br><br><br></c:if>
					             <c:if test="${status.count==3 || status.count==13 || status.count==23 || status.count==7 || status.count==17 || status.count==27}"><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></c:if>
					       </c:otherwise>
					    </c:choose>
				    </c:forEach>	
				</c:if>     				    	 
				 </center>

	        </div>
	        </center>
	 </div>
   </form>   

</body>
</html>