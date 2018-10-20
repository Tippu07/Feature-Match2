
package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;

@SuppressWarnings("serial")
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
		String id="",username="",password="",name="",gender="",dob="",address="",mobileNumber="",phoneNumber="",emailId="";
		int userId = 0;
		
		try
		{
			int no=Integer.parseInt(request.getParameter("no"));
			username =  (String) session.getAttribute("username");
			userId = UserDAO.getUserId(username);
			rs = UserDAO.getUser(userId);
			if(no==1)
			{
				if(rs.next())
				{
					rs.previous();
					request.setAttribute("rs",rs);
					rd=request.getRequestDispatcher("/res/JSP/User/editprof.jsp?no=0");
					rd.forward(request, response);
				}
				else
				{
					rd=request.getRequestDispatcher("/res/JSP/User/editprof.jsp?no=1");
					rd.forward(request, response);
				}
				
			}
			
			if(no==2)
			{
				id = request.getParameter("id");
				username = request.getParameter("username");
				password = request.getParameter("password");
				name = request.getParameter("name");
				emailId = request.getParameter("email");
				mobileNumber = request.getParameter("mob");
				phoneNumber = request.getParameter("phone");
				address = request.getParameter("address");
				
				list = new ArrayList<>();
				list.add(id);
				list.add(username);
				list.add(password);
				list.add(name);
				list.add(mobileNumber);
				list.add(phoneNumber);
				list.add(emailId);
				list.add(address);
				
				flag = UserDAO.updateUserProfile(list);
				if(flag)
				{
					rs = UserDAO.getUser(userId);
					request.setAttribute("rs",rs);
					rd=request.getRequestDispatcher("/res/JSP/User/profile.jsp?no=0&no1=1");
					rd.forward(request, response);
				}
				else
				{
					response.sendRedirect(request.getContextPath()+"/res/JSP/User/editprof.jsp?no=1");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User==>EditProfile Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in User==>EditProfile Servlet : "+e);
		}
	}
}
