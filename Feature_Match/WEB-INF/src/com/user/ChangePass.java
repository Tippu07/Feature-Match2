
package com.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;

@SuppressWarnings("serial")
public class ChangePass extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException 
	{
		PrintWriter out=response.getWriter();
		RequestDispatcher rd = null;
		ResultSet rs = null;
		boolean flag = false;
		HttpSession session = request.getSession();
		String username = "",currentPwd="",newPwd="",confirmPwd="";
		int userId = 0;
		try
		{
			int no=Integer.parseInt(request.getParameter("no"));
			username =  (String) session.getAttribute("username");
			userId = UserDAO.getUserId(username);
			
			if(no==1)
			{
				rd = request.getRequestDispatcher("/res/JSP/User/changepass.jsp?no=0");
				rd.forward(request, response);
			}
			if(no==2)
			{
				username = request.getParameter("username");
				currentPwd = request.getParameter("cur_pwd");
				newPwd = request.getParameter("new_pwd");
				confirmPwd = request.getParameter("cnf_pwd");
				
				flag= UserDAO.loginCheck(username,currentPwd);
				
				if(flag)
				{
					if(newPwd.equals(confirmPwd))
					{
						flag=UserDAO.changePassword(username,newPwd);
						if(flag)
						{
							rs = UserDAO.getUser(userId);
							request.setAttribute("rs",rs);
							rd=request.getRequestDispatcher("/res/JSP/User/profile.jsp?no=0&no1=1");
							rd.forward(request, response);
						}
						else
						{
							rd=request.getRequestDispatcher("/res/JSP/User/changepass.jsp?no=3");
							rd.forward(request, response);
						}
					}
					else
					{
						rd=request.getRequestDispatcher("/res/JSP/User/changepass.jsp?no=2");
						rd.forward(request, response);
					}
				}
				else
				{
					rd=request.getRequestDispatcher("/res/JSP/User/changepass.jsp?no=1");
					rd.forward(request, response);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in User ChangePass Servlet : "+e);
			e.printStackTrace();
			out.println("Opps's Error is in Admin User Servlet : "+e);
		}
	}
}
