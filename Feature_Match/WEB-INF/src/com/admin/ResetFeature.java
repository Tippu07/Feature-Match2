/**

 File : Reset.java
 Package : com.admin
*/

package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;

@SuppressWarnings("serial")
public class ResetFeature extends HttpServlet
{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		boolean flag = false;
		RequestDispatcher rd = null;
		
		try 
		{
			flag = AdminDAO.resetImgFeatures();
			if(flag)
			{
				rd=request.getRequestDispatcher("/res/JSP/Admin/feature_extraction.jsp?no=3");
				rd.forward(request, response);
			}
			else
			{
				rd=request.getRequestDispatcher("/res/JSP/Admin/feature_extraction.jsp?no=2");
				rd.forward(request, response);
			}
		}
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In Admin==>ResetFeature Servlet : ");
			e.printStackTrace();
			out.println("Opps,Exception In Admin==>ResetFeature Servlet : "+e);
		}
		
	}
}
