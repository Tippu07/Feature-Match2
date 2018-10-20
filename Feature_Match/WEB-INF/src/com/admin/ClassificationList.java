
package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDAO;
import com.util.Utility;

@SuppressWarnings("serial")
public class ClassificationList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		ResultSet rs=null; 
		RequestDispatcher rd=null;
		boolean flag = false;
		int classificationId=0;
		
		String username="",classificationName="",remarks="";
		
		try
		{
			String submit=request.getParameter("action");
			
			rs=AdminDAO.getClassifications();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/classification.jsp");
				rd.forward(request, response);
			}
			
			if(submit.equals("Add"))
			{
				rd=request.getRequestDispatcher("/res/JSP/Admin/add_classification.jsp");
				rd.forward(request, response);
			}
			
			if(submit.equals("Add Classification"))
			{
				classificationName = request.getParameter("name");
				remarks = request.getParameter("remarks");
				
				flag = AdminDAO.checkClassificationExistance(classificationName);
				if(!flag)
				{
					flag = AdminDAO.addClassificationDetails(classificationName, remarks);
					if(flag)
					{
						rs=AdminDAO.getClassifications();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/JSP/Admin/classification.jsp?no=1");
						rd.forward(request, response);
					}
					else
					{
						rd=request.getRequestDispatcher("/res/JSP/Admin/add_classification.jsp?no=3");
						rd.forward(request, response);
					}
				}
				else
				{
					rd=request.getRequestDispatcher("//res/JSP/Admin/add_classification.jsp?no=2");
					rd.forward(request, response);
				}
			}
			
			if(submit.equals("Edit"))
			{
				String []chk=request.getParameterValues("chk");
				
				if(chk==null)
				{
					rs=AdminDAO.getClassifications();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/classification.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=AdminDAO.getClassifications();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/classification.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					classificationId = Utility.parse(chk[0]);
					rs=AdminDAO.getClassification(classificationId);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/edit_classification.jsp");
					rd.forward(request,response);
				}
				
			}
			
			if(submit.equals("Update Classification"))
			{
				classificationId = Utility.parse(request.getParameter("id"));
				classificationName = request.getParameter("name");
				remarks = request.getParameter("remarks");
					
				flag = AdminDAO.updatClassificationDetails(classificationId, classificationName, remarks);
				
				if(flag)
				{
					rs=AdminDAO.getClassifications();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/classification.jsp?no=5");
					rd.forward(request,response);
				}
				else
				{
					rs=AdminDAO.getClassification(classificationId);
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/edit_classification.jsp?no=3");
					rd.forward(request,response);
				}
					
			}
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs=AdminDAO.getClassifications();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/classification.jsp?no=2");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						classificationId = Integer.parseInt(chk[i]);
						AdminDAO.deleteClassificationDetails(classificationId);
					}
					rs=AdminDAO.getClassifications();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/classification.jsp?no=3");
					rd.forward(request,response);
				}
			}
			
			//
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin ClassificationList Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin ClassificationList Servlet : "+e);
		}
	}
}
