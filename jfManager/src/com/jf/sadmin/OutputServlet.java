package com.jf.sadmin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jf.Page;
import com.jf.User;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * Servlet implementation class OutputServlet
 */
public class OutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OutputServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		request.setAttribute("method", method);
		if("out_log".equals(method)){
			out_log(request,response);
		}
		else if ("out_stu".equals(method)) {
			out_stu(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void out_log(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<Log> log=new UserService_sadmin().out_log();
		out_log(log);
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/output_log.jsp").forward(request, response);
	}


private void out_stu(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		List<User> user=new UserService_sadmin().out_stu();
		out(user);
		request.getRequestDispatcher("/WEB-INF/jsp_sadmin/output_log.jsp").forward(request, response);
	}


private void out(List<User> user) {
	File xlsFile = new File("G:/temp/student.xls");
    // 创建一个工作簿
    WritableWorkbook workbook = null;
	try {
		workbook = Workbook.createWorkbook(xlsFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    // 创建一个工作表
    WritableSheet sheet = workbook.createSheet("sheet1", 0);
    for (int row = 0; row < user.size(); row++)
    {
    	int col=0;
    	if(col<10){
    		// 向工作表中添加数据
            try {
  				sheet.addCell(new Label(0, row, user.get(row).getId().toString()));
  				sheet.addCell(new Label(1, row, user.get(row).getUsername().toString()));
  				sheet.addCell(new Label(2, row, user.get(row).getPassword().toString()));
  				sheet.addCell(new Label(3, row, user.get(row).getNo().toString()));
  				sheet.addCell(new Label(4, row, user.get(row).getName().toString()));
  				sheet.addCell(new Label(5, row, user.get(row).getSex().toString()));
  				sheet.addCell(new Label(6, row, user.get(row).getDepartment().toString()));
  				sheet.addCell(new Label(7, row, user.get(row).getTelephone().toString()));
  				sheet.addCell(new Label(8, row, user.get(row).getEmail().toString()));
  				sheet.addCell(new Label(9, row, user.get(row).getUsertype().toString()));
  				col=10;
  				System.out.println(user.get(0).getId().toString());
  			} catch (WriteException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
    	}
    }
    try {
		workbook.write();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
		workbook.close();
	} catch (WriteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}

private void out_log(List<Log> log) {
	
	File xlsFile = new File("G:/temp/log.xls");
    // 创建一个工作簿
    WritableWorkbook workbook = null;
	try {
		workbook = Workbook.createWorkbook(xlsFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    // 创建一个工作表
    WritableSheet sheet = workbook.createSheet("sheet1", 0);
    for (int row = 0; row < log.size(); row++)
    {
    	int col=0;
    	if(col<10){
    		// 向工作表中添加数据
            try {
  				sheet.addCell(new Label(0, row, log.get(row).getId().toString()));
  				sheet.addCell(new Label(1, row, log.get(row).getNo().toString()));
  				sheet.addCell(new Label(2, row, log.get(row).getUsername().toString()));
  				sheet.addCell(new Label(3, row, log.get(row).getIntime().toString()));
  				sheet.addCell(new Label(4, row, log.get(row).getOuttime().toString()));
  				sheet.addCell(new Label(5, row, log.get(row).getIp().toString()));
  				col=10;
  			} catch (WriteException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
    	}
    }
    try {
		workbook.write();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    try {
		workbook.close();
	} catch (WriteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
