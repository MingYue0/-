<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="org.jfree.data.general.DefaultPieDataset" %>
<%@ page import="com.jf.Computer" %>
<%@ page import="java.util.List" %>
<%@ page import="org.jfree.chart.ChartFactory" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.servlet.*" %>
<%@ page import="org.jfree.chart.StandardChartTheme" %>
<%@ page import="java.awt.Font" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities"%>
<%@ page import="org.jfree.chart.plot.PlotOrientation"%>          
<%@ page import="org.jfree.data.category.DefaultCategoryDataset"%>
<%@ page import="org.jfree.chart.ChartColor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>班级上机分布</title>
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
		.d{margin-top: 80px; float:center;height: 250px}
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
	    <div class="d">
		<center>
<%
      List<Computer> recordList=(List<Computer>) request.getAttribute("recordList");
      String classn=(String) request.getAttribute("classn");
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
      for(int i = 0 ; i < recordList.size() ; i++) {
    	     dataset.addValue(recordList.get(i).getRepairtime(), classn, recordList.get(i).getComno());
    	}

     // 创建主题样式
     StandardChartTheme standardChartTheme1 = new StandardChartTheme("CN");
     // 设置标题字体
     standardChartTheme1.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
     // 设置图例的字体
     standardChartTheme1.setRegularFont(new Font("宋书", Font.PLAIN, 15));
     // 设置轴向的字体
     standardChartTheme1.setLargeFont(new Font("宋书", Font.PLAIN, 15));
     // 应用主题样式
     ChartFactory.setChartTheme(standardChartTheme1);
     
     JFreeChart chart1 = ChartFactory.createBarChart3D(classn+"机房电脑维修情况统计", 
                       "电脑编号",
                       "维修总时长/小时",
                       dataset,
                       PlotOrientation.VERTICAL,
                       false,
                       false,
                       false);
     String filename = ServletUtilities.saveChartAsPNG(chart1, 1200, 300, null, session);
     String graphURL = request.getContextPath() + "/DisplayChart?filename=" + filename;
     
     System.out.println(graphURL + "\n"+ filename);
 %>
 <img src="<%= graphURL %>"width=1200 height=300 border=0 usemap="#<%= filename %>">
		
		</center><br><br>
		<span style="color:white">${requestScope.tip }</span>
	    </div>
	     </center>
	  </div>  
	   
   </form>

</body>
</html>
