
package com.admin;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;


public class Login extends HttpServlet 
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		boolean flag = false;
		String username = "",password="";
		try
		{
		    username=request.getParameter("name");
		    password=request.getParameter("pass");
			
			flag = AdminDAO.loginCheck(username, password);
			if(flag)
			{
				session.setAttribute("username",username);
				request.setAttribute("admin", username);
				rd=request.getRequestDispatcher("/res/JSP/Admin/home.jsp");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"?no=1");
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in AdminLogin Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in AdminLogin Servlet : "+e);
		}
	}
}
