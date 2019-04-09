package com.jf.jadmin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jf.Computer;
import com.jf.User;
import com.jf.UserService;
import com.jf.sadmin.UserService_sadmin;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class UploadServlet_com extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadServlet_com() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath="G:/jifangstudent/temp";			
		System.out.println(uploadPath);
		File folder = new File(uploadPath);
		if(!folder.exists())
			folder.mkdirs();
		String message=null;
		String content=null; 
		String dtme=null;
		String fileName="";
		if(ServletFileUpload.isMultipartContent(request)){  
			DiskFileItemFactory disk=new DiskFileItemFactory();
			disk.setSizeThreshold(20*1024);                 
			disk.setRepository(disk.getRepository());       
			ServletFileUpload up=new ServletFileUpload(disk);
			int maxsize=2*1024*1024;		
			List list=null;
			try{
				list=up.parseRequest(request);              
			}
			catch(Exception e){
				e.printStackTrace();
			}
			Iterator i=list.iterator();                     
			while(i.hasNext()){
				FileItem fm=(FileItem)i.next();             
				
				if(!fm.isFormField()){
					String filePath = fm.getName();	
					
					int startIndex = filePath.lastIndexOf("\\");
					if(startIndex!=-1){						
						fileName = filePath.substring(startIndex+1);
					}else{
						fileName=filePath;
					}
					if(fm.getSize()>maxsize){
						message="file size can't be more than 2MB";
						break;
					}
					String fileSize=new Long(fm.getSize()).toString();
					if((fileName==null)||(fileName.equals(""))&&(fileSize.equals("0"))){
						message="file can't be null";
						break;
					}
					File saveFile=new File(uploadPath,fileName);
					try{
						fm.write(saveFile);                
						message="file upload success";
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
					
				}
				else{
					String foename=fm.getFieldName();     
					String con=fm.getString("gbk");       
					
					if(foename.equals("upDate")){     
						 content = con;
					}
					else if(foename.equals("upPerson")){  
						 dtme = con;
					}
				}
				
			}
		}
		PrintWriter out=response.getWriter();
		leading_in();
		response.sendRedirect("/jfManager/ManagerServlet_jadmin?method=input_com");
	}

	private void leading_in() {
		List<Computer> u=new ArrayList<Computer>();
		File file = new File("G:/jifangstudent/temp/computer.xls");
        List excelList = readExcel(file);
        for (int i = 1; i < excelList.size(); i++) {
            List list = (List) excelList.get(i);
            int j = 0;
            if(j < list.size()) {
                Computer computer=new Computer();
                computer.setVersion(list.get(0).toString());
                computer.setClassno(list.get(1).toString());
                computer.setCondition(list.get(2).toString());
                computer.setAppointment(list.get(3).toString());
                computer.setSno(list.get(4).toString());
                computer.setConfiguration(list.get(5).toString());
                computer.setSoftware(list.get(6).toString());
                computer.setDirector(list.get(7).toString());
                computer.setComno(list.get(8).toString());
                j=10;
                u.add(computer);
            }
        }
        boolean success=new UserService_jadmin().leading_com(u);
	}
	public List readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                List<List> outerList=new ArrayList<List>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    List innerList=new ArrayList();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        innerList.add(cellinfo);
                    }
                    outerList.add(i, innerList);
                }
                return outerList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
	
}
