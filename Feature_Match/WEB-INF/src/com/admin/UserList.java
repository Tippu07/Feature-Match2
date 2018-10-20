
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
public class UserList extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		PrintWriter out = response.getWriter();
		ResultSet rs=null; 
		RequestDispatcher rd=null;
		boolean flag = false;
		int userId=0;
		
		String username="",password="",name="",gender="",address="",mobileNumber="",phoneNumber="",emailId="",dob="",UserAge="";
		
		try
		{
			String submit=request.getParameter("action");
			
			rs=AdminDAO.getUsers();
			
			if(submit.equals("get"))
			{
				request.setAttribute("rs", rs);
				rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp");
				rd.forward(request, response);
			}
			
			
			if(submit.equals("Add"))
			{
				username = request.getParameter("username");
				password = request.getParameter("password");
				name = request.getParameter("name");
				gender = request.getParameter("sex");
				dob = request.getParameter("dob");
				mobileNumber = request.getParameter("cell");
				phoneNumber = request.getParameter("phone");
				emailId = request.getParameter("email");
				address = request.getParameter("address");
				
				flag = AdminDAO.checkUserExistance(username);
				if(!flag)
				{
					flag = AdminDAO.addUserDetails(username,password,name,gender,dob,mobileNumber, phoneNumber, emailId,address);
					if(flag)
					{
						rd=request.getRequestDispatcher("/index.jsp?no=4");
						rd.forward(request, response);
					}
					else
					{
						rd=request.getRequestDispatcher("/index.jsp?no=3");
						rd.forward(request, response);
					}
				}
				else
				{
					rd=request.getRequestDispatcher("/index.jsp?no=5");
					rd.forward(request, response);
				}
			}
			
/*			if(submit.equals("Add"))
			{
				if(Utility.parse1(request.getParameter("add1")).equals("YES"))
				{
					username = request.getParameter("username");
					password = request.getParameter("password");
					name = request.getParameter("name");
					gender = request.getParameter("sex");
					age= Integer.parseInt(request.getParameter("age"));
					mobileNumber = request.getParameter("mob");
					phoneNumber = request.getParameter("phone");
					emailId = request.getParameter("email");
					address = request.getParameter("address");
					
					
					flag = AdminDAO.checkUserExistance(username);
					
					if(!flag)
					{
						if( session.getAttribute( "waitPage" ) == null ) 
					     {  
					    	   session.setAttribute( "waitPage", Boolean.TRUE );  
					    	   out.println( "<html><head>" );  
					    	   out.println( "<title>Please Wait...</title>" );  
					    	   out.println("<link href='res/CSS/form.css' rel='stylesheet' type='text/css' />");
					       	   out.println( "<meta http-equiv=\"Refresh\" content=\"0\">" );  
					    	   out.println( "</head><body bgcolor=''>" );
					    	   out.println("<section id='content' style='position: absolute;top:35;left:125px;width: 650px;'>");
					    	   out.println("<h1>Add User Details</h1>");
					    	   out.println("<center>");
					    	   out.println("<font color='green' size='5'>");
					    	   out.println( "Wait Please...,Key Generation In Process... " );
					    	   out.println( "<br><br>" );
					    	   out.print( "<img src='res/Images/spinner.gif'></img><br><br>");
					    	   out.println("<font color='red' size='5'>");
					    	   out.println( "Please Do not press Back or Refresh button.......<br>  " );
					    	   out.println("</font><br>");
					    	   out.println("<font color='green' size='5'>");
					    	   out.println( "Sending mail.......  " );
					    	   out.println("</font><br>");
					    	   out.println( "Please wait....</h1><br>");  
					    	   out.println("</center>");
					    	   out.println("<div class='button'>");
					    	   out.println("</section>");
					    	   out.close();  
					     }
						 else
						 {
							session.removeAttribute( "waitPage" ); 
							
							flag = AdminDAO.addUserDetails(username,password,name,gender,deptId,designationId,dob, age, mobileNumber, phoneNumber, emailId,address);
								
							if(flag)
							{
								
									rs=AdminDAO.getUsers();
									request.setAttribute("rs", rs);
									rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp?no=1");
									rd.forward(request, response);
								
								
								rd=request.getRequestDispatcher("/DistributeKey");
								rd.forward(request, response);
								
							}
							else
							{
								rd=request.getRequestDispatcher("/res/JSP/Admin/add_user.jsp?no=2");
								rd.forward(request, response);
							}
							 
						 }
						
						
					}
					else
					{
						rd=request.getRequestDispatcher("/res/JSP/Admin/add_user.jsp?no=3");
						rd.forward(request, response);
					}
					
				}
				else
				{
					rd=request.getRequestDispatcher("/res/JSP/Admin/add_user.jsp");
					rd.forward(request, response);
				}
			}
*/			
			
			if(submit.equals("Edit"))
			{
				String []chk=request.getParameterValues("chk");
				if(Utility.parse1(request.getParameter("edit1")).equals("YES"))
				{
					String id =request.getParameter("id");
					username = request.getParameter("username");
					password = request.getParameter("password");
					name = request.getParameter("name");
					gender = request.getParameter("sex");
					dob = request.getParameter("dob");
					mobileNumber = request.getParameter("mob");
					phoneNumber = request.getParameter("phone");
					emailId = request.getParameter("email");
					address = request.getParameter("address");
					
					ArrayList<String> list = new ArrayList<String>();
					list.add(id);
					list.add(username);
					list.add(password);
					list.add(name);
					list.add(gender);
					list.add(dob);
					list.add(mobileNumber);
					list.add(phoneNumber);
					list.add(emailId);
					list.add(address);
					
					flag = AdminDAO.updateUserDetails(list);
					
					if(flag)
					{
						rs=AdminDAO.getUsers();
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp?no=5");
						rd.forward(request,response);
					}
					else
					{
						rs=AdminDAO.getUser(Integer.parseInt(id));
						request.setAttribute("rs", rs);
						rd=request.getRequestDispatcher("/res/JSP/Admin/edit_user.jsp?no=2");
						rd.forward(request,response);
					}
					
				}
				else if(chk==null)
				{
					rs=AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp?no=2");
					rd.forward(request,response);
				}
				else if(chk.length!=1)
				{
					rs=AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp?no=4");
					rd.forward(request,response);
				}
				else if(chk.length==1)
				{
					rs=AdminDAO.getUser(Integer.parseInt(chk[0]));
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/edit_user.jsp");
					rd.forward(request,response);
				}
			}
			if(submit.equals("Delete"))
			{
				String []chk=request.getParameterValues("chk");
				if(chk==null)
				{
					rs=AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp?no=2");
					rd.forward(request,response);
				}
				else
				{
					for(int i=0;i<chk.length;i++)
					{
						userId = Integer.parseInt(chk[i]);
						AdminDAO.deleteUserDetails(userId);
					}
					rs=AdminDAO.getUsers();
					request.setAttribute("rs", rs);
					rd=request.getRequestDispatcher("/res/JSP/Admin/users.jsp?no=3");
					rd.forward(request,response);
				}
			}
			
			//
		}
		catch(Exception e)
		{
			System.out.println("Opps's Error is in Admin UserList Servlet : ");
			e.printStackTrace();
			out.println("Opps's Error is in Admin UserList Servlet : "+e);
		}
	}
}
