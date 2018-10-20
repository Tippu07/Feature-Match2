
package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDAO;

public class EditProfile extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		ArrayList<String> list = null;
		RequestDispatcher rd = null;
		ResultSet rs = null;
		boolean flag = false;
		HttpSession session = request.getSession();
		String id="",username="",password="",name="",gender="",address="",mobileNumber="",phoneNumber="",emailId="",dob="";
		int adminId = 0;
		
		try
		{
			int no=Integer.parseInt(request.getParameter("no"));
			username =  (String) session.getAttribute("username");
			adminId = AdminDAO.getAdminIdByUsername(username);
			rs = AdminDAO.getAdminProfile(adminId);
			if(no==1)
			{
				if(rs.next())
				{
					rs.previous();
					request.setAttribute("rs",rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/editprof.jsp?no=0");
					rd.forward(request, response);
				}
				else
				{
					rd=request.getRequestDispatcher("/res/JSP/Admin/editprof.jsp?no=1");
					rd.forward(request, response);
				}
				
			}
			
			if(no==2)
			{
				id = request.getParameter("id");
				username = request.getParameter("username");
				name = request.getParameter("name");
				emailId = request.getParameter("email");
				mobileNumber = request.getParameter("mob");
				phoneNumber = request.getParameter("phone");
				address = request.getParameter("address");
				
				list = new ArrayList<>();
				list.add(id);
				list.add(username);
				list.add(name);
				list.add(mobileNumber);
				list.add(phoneNumber);
				list.add(emailId);
				list.add(address);
				
				flag = AdminDAO.updateAdminProfile(list);
				if(flag)
				{
					rs = AdminDAO.getAdminProfile(adminId);
					request.setAttribute("rs",rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/profile.jsp?no=0&no1=1");
					rd.forward(request, response);
				}
				else
				{
					response.sendRedirect(request.getContextPath()+"/res/JSP/Admin/editprof.jsp?no=1");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin EditProfile Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin EditProfile Servlet : "+e);
		}
	}
}
