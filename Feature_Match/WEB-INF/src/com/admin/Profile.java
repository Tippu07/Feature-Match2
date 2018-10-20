
package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;

public class Profile extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		RequestDispatcher rd = null;
		ResultSet rs = null;
		boolean flag = false;
		HttpSession session = request.getSession();
		String username = "";
		int adminId = 0;
		
		try
		{
			username =  (String) session.getAttribute("username");
			adminId = AdminDAO.getAdminIdByUsername(username);
			rs = AdminDAO.getAdminProfile(adminId);
			if(rs.next())
			{
				rs.previous();
				request.setAttribute("rs",rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/profile.jsp?no=0");
				rd.forward(request, response);
			}
			else
			{
				rd=request.getRequestDispatcher("/res/JSP/Admin/profile.jsp?no=1");
				rd.forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in AdminProfile Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in AdminProfile Servlet : "+e);
		}
	}
}
