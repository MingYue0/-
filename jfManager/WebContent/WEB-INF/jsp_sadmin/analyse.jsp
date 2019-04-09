<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.jfree.data.general.DefaultPieDataset" %>
<%@ page import="org.jfree.chart.ChartFactory" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.servlet.*" %>
<%@ page import="org.jfree.chart.StandardChartTheme" %>
<%@ page import="java.awt.Font" %>
<%@page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@ page import="org.jfree.chart.plot.PlotOrientation"%>          
<%@ page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@ page import="org.jfree.chart.ChartColor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用时段分布</title>
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
	   <input type="hidden" name="method" value="findUseListJa">
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
		<center>
<!-- 饼状图 -->
     <%
     Integer count1=(Integer) request.getAttribute("count1");
     Integer count2=(Integer) request.getAttribute("count2");
     Integer count3=(Integer) request.getAttribute("count3");
     Integer count4=(Integer) request.getAttribute("count4");
    DefaultPieDataset dpd = new DefaultPieDataset();
    dpd.setValue("8:00--10:00", count1);
    dpd.setValue("10:00--12:00", count2);
    dpd.setValue("14:00--16:00", count3);
    dpd.setValue("16:00--18:00", count4);
     
    //这一段是防止乱码使用的
    StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  //创建主题样式     
    standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  //设置标题字体
    standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));    //设置图例的字体
    standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));      //设置轴向的字体
    ChartFactory.setChartTheme(standardChartTheme);                    //应用主题样式
     
    JFreeChart chart = ChartFactory.createPieChart("使用时间分布图",dpd, true, false, false);
    String fileName = ServletUtilities.saveChartAsPNG(chart,800,600,session); 
    //ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp）
     
    String url = request.getContextPath() + "/DisplayChart?filename=" + fileName;
    //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
%> <img src="<%= url %>" width="700" height="600"> 		
		
		</center>
	    </div>
	     </center>
	  </div>  
	   
   </form>

</body>
</html>
