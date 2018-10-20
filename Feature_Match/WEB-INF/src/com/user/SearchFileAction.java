
package com.user;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.AdminDAO;

@SuppressWarnings("serial")
public class SearchFileAction extends HttpServlet
{
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		boolean flag = false;
		String s = "",fileName="",ext="",filepath = "",root = "",imageFileName="";
		
		@SuppressWarnings("rawtypes")
		ArrayList list =  new ArrayList();
		ResultSet rs = null;
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		
		try 
		{
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if(isMultipart)
 			{
 				FileItemFactory factory = new DiskFileItemFactory();
 	            ServletFileUpload upload = new ServletFileUpload(factory);
 	            
 	            try 
 	            {
 	            	@SuppressWarnings("rawtypes")
					List items = upload.parseRequest(request);
  	                @SuppressWarnings("rawtypes")
					Iterator iterator = items.iterator();
  	                while (iterator.hasNext()) 
  	                {
  	                	FileItem item = (FileItem) iterator.next();
  	                	
  	                	
	                    if (item.isFormField()) 
	                    {
	                    	s = item.getString();
	                    	list.add(s);//All Form Field Values
	                    	
	                    }
	                    else 
	                    {
	                    	 fileName = item.getName();
	                    	 if(fileName!="")
		                    		ext=fileName.substring(fileName.lastIndexOf(".")+1,fileName.lastIndexOf(""));
	                    	 
	                    	 root = request.getRealPath("")+"\\Files\\Search\\";
	                    	 File f = new File(root);
	                    	 if(!f.exists())
	                   		 f.mkdir();
	                    	 
			                 filepath = root+fileName;
			  	             File f1=new File(filepath);
			  	             item.write(f1);
			  	             flag = true;
			  	             
			  	             session.setAttribute("img_name",fileName);
			  	             
			  	             System.out.println("File Created Successfully......");
	                    }
	                        
  	                }
  	                
  	                //System.out.println("Form Fields :\n"+list);
  	                
	  	            if(flag)
	  				{
	  	            	request.setAttribute("image_name",fileName);
	  	            	rd=request.getRequestDispatcher("/res/JSP/User/serach_img.jsp?no=11");
						rd.forward(request, response);
	  				}
	  				else
	  				{
	  					System.out.println("Opps,Something Went Wrong While Uploading The Image!!!!");
	  					rd=request.getRequestDispatcher("/res/JSP/User/serach_img.jsp?no=2");
						rd.forward(request, response);
	  				}
				}
 	            catch (Exception e)
 	            {
					System.out.println("Opps,Exception While Creating The File : " );
					e.printStackTrace();
				}
 			}
			
		} 
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In Admin==>SearchFileAction Servlet : ");
			e.printStackTrace();
		}
	}
}
