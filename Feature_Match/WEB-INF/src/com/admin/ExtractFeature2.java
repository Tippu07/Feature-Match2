/**
 
 File : UploadFile.java
 Package : com.dev.admin
*/

package com.admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;
import com.util.LocalColorHistogram;

@SuppressWarnings("serial")
public class ExtractFeature2 extends HttpServlet
{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		ResultSet rs = null;
		RequestDispatcher rd = null;
		String root = "",filePath="",fileName="",imgFeature3;
		int imageId = 0,counter=0,totalImage=0;
		BufferedImage img = null;
		Vector<Double> featureVector = null;
		StringBuffer sb = null;
		boolean flag = false;
		
		//long startTime = System.currentTimeMillis();
		long start = System.nanoTime();
		
		if( session.getAttribute( "waitPage" ) == null ) 
	     {  
			   PrintWriter out = response.getWriter();
	    	   session.setAttribute( "waitPage", Boolean.TRUE );  
	    	   out.println( "<html><head>" );  
	    	   out.println( "<title>Please Wait...</title>" );  
	    	   out.println("<link href='res/CSS/message.css' rel='stylesheet' type='text/css' />");
	    	   out.println("<link href='res/CSS/button.css' rel='stylesheet' type='text/css' />");
	       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
	    	   out.println( "</head><body bgcolor=''>" );
	    	   out.println("<section id='content' style='position: absolute;top:15px;left:100px;width: 650px;'>");
	    	   out.println("<center>");
	    	   out.println("<a class='gradientbuttons' href='<%=request.getContextPath() %>/ResetFeature' target='afrm'>Reset Feature</a><br><br><br>");
	    	   out.println("<a class='gradientbuttons' href='<%=request.getContextPath() %>/ExtractFeature' target='afrm'>Extract Feature</a>&nbsp;&nbsp;");
	    	   //out.println("<a class='gradientbuttons' href='<%=request.getContextPath() %>/ExtractFeature' target='afrm'>Extract Feature2</a>&nbsp;&nbsp;");
	    	   //out.println("<a class='gradientbuttons' href='<%=request.getContextPath() %>/ExtractFeature' target='afrm'>Extract Feature3</a>");
	    	   out.println("<br><br><br>");
	    	   out.println("<font color='white' size='5'>");
	    	   out.println( "Wait Please...<br>" );
	    	   out.println( "Features Are Getting Extracted..... <br>" );
	    	   out.print( "<img src='res/images/spinner.gif'></img><br><br>");
	    	   //out.println( "Feature Extracted For "+counter+"/"+totalImage+" Image(s)"+"<br><br>" );
	    	   out.println("<font color='red' size='5'>");
	    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
	    	   out.println("</font><br>");
	    	   out.println("<font color='green' size='5'>");
	    	   out.println( "Features Are Getting Extracted..... " );
	    	   out.println("</font><br>");
	    	   out.println( "Please wait....</h1><br>");  
	    	   out.println("</center>");
	    	   out.println("</section>");
	    	   out.close();  
	     }
		 else
		 {
			session.removeAttribute( "waitPage" );
			
			try
			{
				
				root = request.getRealPath("")+"\\Files\\UploadedImg\\";
				
				rs = AdminDAO.getImage();
				
				while(rs.next())
				{
					sb = new StringBuffer();
					
					counter++;
					imageId = rs.getInt(1);
					fileName = rs.getString(2);
					filePath = root+fileName;
					
					img = LocalColorHistogram.readImage(filePath);
					featureVector = LocalColorHistogram.getFeatureVector(img);
				    //System.out.println("Feature Vector :\n"+featureVector);
				    
				    for(int i=0;i<featureVector.size();i++)
				    {
				    	sb.append(featureVector.get(i)+"-");
				    }
				    
				    //Deleting The Last '-' from sb
				    if(sb.length() > 0)
				    {
				    	sb.deleteCharAt(sb.lastIndexOf("-"));
				    }
				    
				    imgFeature3 = sb.toString();
				    //System.out.println("Feature2 Value :\n"+imgFeature2);
				 
				    //Updating The Features In Database
				    flag = AdminDAO.updateImgFeature2(imageId,imgFeature3);
					flag = true;
				}
				
				if(flag)
				{
					request.setAttribute("start_time",start);
					rd=request.getRequestDispatcher("/res/JSP/Admin/feature_extraction.jsp?no=1");
					rd.forward(request, response);
				}
				else
				{
					rd=request.getRequestDispatcher("/res/JSP/Admin/feature_extraction.jsp?no=2");
					rd.forward(request, response);
				}
				
/*				
				//Delaying The Process Manually(Starts)
				try
			    {
			        Thread.currentThread().sleep(10000);
			    }
			    catch (InterruptedException e)
			    {
			        Thread.currentThread().interrupt();
			    }
				
				//Delaying The Process Manually(Starts)
*/				
			}
			catch (Exception e)
			{
				System.out.println("Opps,Exception In ExtractFeature2 Servlet : " );
				e.printStackTrace();
				rd=request.getRequestDispatcher("/res/JSP/Admin/feature_extraction.jsp?no=2");
				rd.forward(request, response);
			}
			
			
		}
	}
}
