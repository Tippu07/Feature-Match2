/**

 File : UserDAO.java
 Package : com.dev.dao
*/

package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static UserDAO userDAO=null;
	private UserDAO(){}
	
	public static UserDAO initialize()
	{
		if(userDAO==null)
		{
			userDAO=new UserDAO();
		}
		return userDAO;
	}
	
	public static boolean loginCheck(String username,String password)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_user where username='"+username+"' and password='"+password+"'";
			System.out.println("********** User Login Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>loginCheck(String username,String password) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean changePassword(String username,String newPassword)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_user set password='"+newPassword+"' where username='"+username+"'";
			System.out.println("********** Change User Password Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Change Password status (T/F) : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>changePassword(String username,String newPassword): "+ e);
		}
		return flag;
	}
	
	
	public static ResultSet getUsers() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in UserDAO==>getUsers() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getUser(int userId) 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_id='"+userId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in UserDAO==>getUser(int userId) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static boolean checkUserExistance(String username)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_user where username='"+username+"'";
			System.out.println("********** Check User Existance Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("User Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>checkUserExistance(String username) : ");
			e.printStackTrace();
		}
		return flag;
	}

	
	public static boolean addUserDetails(String username,String password,String name,String gender,String dob,String mobileNumber,String phoneNumber,String emailId,String address)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "insert into m_user(username,password,name,sex,dob,cell,phone,email,address) values('"+username+"','"+password+"','"+name+"','"+gender+"','"+dob+"','"+mobileNumber+"','"+phoneNumber+"','"+emailId+"','"+address+"')";
			System.out.println("********** Add User Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Add User Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>addUserDetails() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateUserDetails(ArrayList<String> list)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_user set password='"+list.get(2)+"',name='"+list.get(3)+"',sex='"+list.get(4)+"',dob='"+list.get(5)+"',cell='"+list.get(6)+"',phone='"+list.get(7)+"',email='"+list.get(8)+"',address='"+list.get(9)+"' where u_id='"+list.get(0)+"'";
			System.out.println("********** Update User Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update User Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>updateUserDetails(ArrayList<String> list): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateUserProfile(ArrayList<String> list)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_user set password='"+list.get(2)+"',name='"+list.get(3)+"',cell='"+list.get(4)+"',phone='"+list.get(5)+"',email='"+list.get(6)+"',address='"+list.get(7)+"' where u_id='"+list.get(0)+"'";
			System.out.println("********** Update User Profile Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update User Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>updateUserProfile(ArrayList<String> list): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean deleteUserDetails(int userId)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "delete from m_user where u_id='"+userId+"'";
			System.out.println("********** Delete User Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Delete User Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>deleteUserDetails(int userId): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static String getUserName(String username)
	{
		String sql="";
		String name="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select name from m_user where username='"+username+"'";
			System.out.println("********** Get User Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
			System.out.println("User Name["+username+"]: "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getAdminName(String username) : ");
			e.printStackTrace();
		}
		return name;
	}
	
	public static String getUserName(int userId)
	{
		String sql="";
		String name="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select name from m_user where u_id='"+userId+"'";
			System.out.println("********** Get User Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
			System.out.println("User Name["+userId+"]: "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getUserName(int UserId) : ");
			e.printStackTrace();
		}
		return name;
	}
	
	public static String getUserEmail(int userId)
	{
		String sql="";
		String email="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select email from m_user where u_id='"+userId+"'";
			System.out.println("********** Get User Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				email = resultSet.getString(1);
			}
			System.out.println("User Email["+userId+"]: "+email);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getUserEmail(int userId) : ");
			e.printStackTrace();
		}
		return email;
	}
	
	public static String getUserPassword(int userId)
	{
		String sql="";
		String password="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select password from m_user where u_id='"+userId+"'";
			System.out.println("********** Get User Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				password = resultSet.getString(1);
			}
			System.out.println("User Password["+userId+"]: "+password);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getUserPassword(int userId) : ");
			e.printStackTrace();
		}
		return password;
	}
	
	public static int getUserId(String username)
	{
		String sql="";
		int id = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select u_id from m_user where username='"+username+"'";
			System.out.println("********** Get User Id By Username Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				id = resultSet.getInt(1);
			}
			System.out.println("User Id["+username+"]: "+id);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>getUserId(String username) : ");
			e.printStackTrace();
		}
		return id;
	}
	
// All About Images
	
	public static boolean updateImgDistance(int imageId,double distance)
	{
		boolean flag=false;
		String sql= "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_image set f_dist='"+distance+"' where img_id='"+imageId+"'";
			System.out.println("********** Update Image Distance Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Update Image Distance : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO==>updateImgDistance(int imageId,double distance) : ");
			e.printStackTrace();
		}
		return flag;
	}
	

	public static ResultSet getImageByDistAsc() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_image order by f1_dist asc ");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
}
