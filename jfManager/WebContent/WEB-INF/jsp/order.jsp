<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>座位选择</title>
<style>
         p{font-size: 20px; font-weight: bold;color:#836C0D}
		body {margin: 0;font-family: 'Lato', sans-serif; font-weight: 400;font-size: 15px;line-height: 25px;color: #333333;overflow-x: hidden;padding: 0;background-image:url(./imgs/bg.jpg);background-size:cover}

		.box{}
	    .menu a:hover {background:#93A29D;color:white}
		.menu{border-bottom: 1px solid white;height: 85px;margin-top: 2px;width:100%}
		.b{margin-right: 10px; float:right;color:black;margin-bottom: auto;margin-top: 10px;color:white;font-family:幼圆;}
	    .b1{float:right;font-weight: 900;font-size: 150%;}
	    .c1{margin-left: 10px;float:left;height: 80px;margin-top: 15px}
		.d{margin-top: 30px; float:center;height: 300px}
	    .e{float:right;margin-right: 20px;margin-top: 75px}
		a{color:#4876F1}
	
	</style>
</head>
<body>
   <form action="ManagerServlet_stu" method="post">
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
				<center><p>请选择你的座位</p></center>
				<center>
				   <!--<c:forEach items= "${sessionScope.comList }" var="computer" varStatus="status">
					   <c:choose>
					       <c:when test="${computer.condition eq 'normal'}">
							     <a href="ManagerServlet_stu?method=ordercom&comid=${computer.comid}"><img src="./imgs/light.png" ></a>		   
							     <c:if test="${status.count%10==0 }"><br><br><br></c:if>
							     <c:if test="${status.count%5==0 && (status.count/5)%2!=0}"><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></c:if>
					       </c:when>
					       <c:otherwise>
					             <a><img src="./imgs/dark.png" ></a>
					             <c:if test="${status.count%10==0 }"><br><br><br></c:if>
					             <c:if test="${status.count%5==0 && (status.count/5)%2!=0}"><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></c:if>
					       </c:otherwise>
					    </c:choose>
				    </c:forEach>-->
				<c:if test="${requestScope.type eq '1'}">
				   <c:forEach items= "${sessionScope.comList }" var="computer" varStatus="status">
					   <c:choose>
					       <c:when test="${computer.condition eq 'normal'}">
							     <a href="ManagerServlet_stu?method=ordercom&comid=${computer.comid}"><img src="./imgs/light.png" ></a>   
							     <c:if test="${status.count%10==0 }"><br><br><br></c:if>   
							     <c:if test="${status.count%5==0 && (status.count/5)%2!=0}"><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></c:if>
					       
					       </c:when>
					       <c:otherwise>
							     <a href=""><img src="./imgs/dark.png" ></a>
					             <c:if test="${status.count%10==0 }"><br><br><br></c:if>
					             <c:if test="${status.count%5==0 && (status.count/5)%2!=0}"><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></c:if>
					       </c:otherwise>
					    </c:choose>
				    </c:forEach>
				</c:if>
				<c:if test="${requestScope.type eq '2'}">   
				   <c:forEach items= "${sessionScope.comList }" var="computer" varStatus="status">
					   <c:choose>
					       <c:when test="${computer.condition eq 'normal'}">
							     <a href="ManagerServlet_stu?method=ordercom&comid=${computer.comid}"><img src="./imgs/light.png" ></a>   
							     <c:if test="${status.count%10==0 }"><br><br><br></c:if>   
							     <c:if test="${status.count==3 || status.count==13 || status.count==23 || status.count==7 || status.count==17 || status.count==27}"><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></c:if>
					       
					       </c:when>
					       <c:otherwise>
							     <a href=""><img src="./imgs/dark.png" ></a>
					             <c:if test="${status.count%10==0 }"><br><br><br></c:if>
					             <c:if test="${status.count==3 || status.count==13 || status.count==23 || status.count==7 || status.count==17 || status.count==27}"><a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></c:if>
					       </c:otherwise>
					    </c:choose>
				    </c:forEach>	
				</c:if>     						    	 
				 </center>
				 <div class="e">
					<a href="ManagerServlet_stu?method=orderclass&id=${user.id}"><img src="./imgs/fanhui.png" width=50px height=50px></a>
			    </div>
	        </div>
	        </center>
	 </div>
   </form>   

</body>
</html>