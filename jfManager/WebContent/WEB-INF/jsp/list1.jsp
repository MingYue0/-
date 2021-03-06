<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理</title>
<style>
        p{font-size: 20px; font-weight: bold;color:#836C0D}
		body {margin: 0;font-family: 'Lato', sans-serif; font-weight: 400;font-size: 15px;line-height: 25px;color: #333333;overflow-x: hidden;padding: 0;background-image:url(./imgs/bg.jpg);background-size:cover}

		.box{}
	    .menu a:hover {background:#93A29D;color:white}
		.menu{border-bottom: 1px solid white;height: 85px;margin-left: ;margin-right: ;margin-top: 2px;}
		.b{margin-right: 10px; float:right;color:black;margin-bottom: auto;margin-top: 10px;color:white;font-family:幼圆;}
	    .b1{float:right;font-weight: 900;font-size: 150%;}
	    .c1{margin-left: 10px;float:left;height: 80px;margin-top: 15px}
		.d{margin-top: 30px; float:center;height: 300px}
	    .e{float:center;margin-left: 10px;margin-top: 10px}
		a{color:#4876F1;text-decoration: none}
	
	</style>
</head>
<body>
   <form action="ManagerServlet" method="post">
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
					<a href="ManagerServlet?method=list&id=${user.id}"><img src="./imgs/zuojiantou.png" width=40px height=40px></a>
			    </div>		 
		 <center>    
	     <div class="d">
				<center>
			    	<c:forEach items= "${requestScope.page.recordList }" var="user" varStatus="status">
                   	 <div style="color: #242262;width: 220px;height: 350px;border-radius: 10px;background: #FFFFFF;float: left;margin-left:30px;margin-top: 0px">                  
                        <br>
						 <center>
						 <table>
							<tr><td>序号：</td><td>${status.count }</td></tr>
                        	<tr><td>用户名：</td><td>${user.username }</td></tr>
                      	 	<tr><td>密码：</td><td>${user.password }</td></tr>
                      	 	<tr><td>学号：</td><td>${user.no }</td></tr>
                       		<tr><td>姓名：</td><td>${user.name }</td></tr>
                       		<tr><td>性别：</td><td>${user.sex }</td></tr>
                       	 	<tr><td>学院：</td><td>${user.department }</td></tr>
                       	 	<tr><td>电话：</td><td>${user.telephone }</td></tr>
                       		<tr><td>邮箱：</td><td>${user.email }</td></tr>
                       		<tr><td>用户类型：</td><td>${user.usertype }</td></tr>
						 </table>
						</center>    
                        <center><a onclick="return window.confirm('确认要删除当前记录吗?');" href="ManagerServlet?method=delete1&id=${user.id }">删除</a></center> 
                        </td>    
                        </tr>
					</div>
                   </c:forEach>            
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                <div> <c:if test="${requestScope.page.pageNow>1 }">
		                <a href="ManagerServlet?method=list1&pageNow=${requestScope.page.pageNow -1}">[上一页]</a>
	                </c:if>
	                <c:forEach begin="${requestScope.page.beginIndex }" end="${requestScope.page.endIndex }" varStatus="status">
	                <c:choose>
		            <c:when test="${requestScope.page.pageNow eq status.index}">
			            <a>${status.index }</a>
		            </c:when>
		            <c:otherwise>
		                <a href="ManagerServlet?method=list1&pageNow=${status.index }">[${status.index }]</a>
		            </c:otherwise>
	                </c:choose>
	                </c:forEach>
	                <c:if test="${requestScope.page.pageNow< requestScope.page.pageCount}">
		                <a href="ManagerServlet?method=list1&pageNow=${requestScope.page.pageNow +1}">[下一页]</a>
	                </c:if>
			   
			    </div> 

			    </center>
	      </div>
	      </center>
	 </div> 
</form>	 
</body>
</html>