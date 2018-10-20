/**

 File : AdminDAO.java
 Package : com.dao
*/

package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDAO 
{
	private static Connection connection = null;
	private static Statement statement = null;
	private static Statement stmt = null;
	private static ResultSet resultSet = null;
	private static AdminDAO adminDAO=null;
	private AdminDAO(){}
	
	public static AdminDAO initialize()
	{
		if(adminDAO==null)
		{
			adminDAO=new AdminDAO();
		}
		return adminDAO;
	}
	
	public static boolean loginCheck(String username,String password)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_admin where username='"+username+"' and password='"+password+"'";
			System.out.println("********** Investigator Login Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Admin Login Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>loginCheck(String username,String password) : ");
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
			sql = "update m_admin set password='"+newPassword+"' where username='"+username+"'";
			System.out.println("********** Change Investigator Password Info **********");
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
			System.out.println("Exception in AdminDAO==>changePassword(String username,String newPassword): "+ e);
		}
		return flag;
	}
	
	
	public static String getAdminName(String username)
	{
		String sql="";
		String name="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select name from m_admin where username='"+username+"'";
			System.out.println("********** Get Investigator Name Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
			System.out.println("Admin Name["+username+"]: "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getAdminName(String username) : ");
			e.printStackTrace();
		}
		return name;
	}
	
	public static int getAdminIdByUsername(String username)
	{
		String sql="";
		int id = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select id from m_admin where username='"+username+"'";
			System.out.println("********** Getting The Investigator Id By Username**********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				id = resultSet.getInt(1);
			}
			System.out.println("Admin Id["+username+"] : "+id);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getAdminIdByUsername(String username) : ");
			e.printStackTrace();
		}
		return id;
	}
	
	public static ResultSet getAdminProfile(int adminId) 
	{
		String sql = "";
		
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_admin where id='"+adminId+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Error is in AdminDAO-getAdminProfile(int adminId): ");
			e.printStackTrace();
		}
		return resultSet;
	}

	public static boolean updateAdminProfile(ArrayList<String> list)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_admin set username='"+list.get(1)+"',name='"+list.get(2)+"',cell='"+list.get(3)+"',phone='"+list.get(4)+"',email='"+list.get(5)+"',address='"+list.get(6)+"' where id='"+list.get(0)+"'";
			System.out.println("********** Update Investigator Profile Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update Investigator Profile Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateAdminProfile(ArrayList<String> list): ");
			e.printStackTrace();
		}
		return flag;
	}
	
// All About The User	

	public static ResultSet getUsers() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getUsers() : ");
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
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_user where u_id='"+userId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO-getUser(int userId) : ");
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
			System.out.println("Exception in AdminDAO==>checkUserExistance(String username) : ");
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
			System.out.println("Exception in AdminDAO==>addUserDetails() : ");
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
			System.out.println("Exception in AdminDAO==>updateUserDetails(ArrayList<String> list): ");
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
			System.out.println("Exception in AdminDAO==>deleteUserDetails(int userId): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean changeUserPassword(String username,String newPassword)
	{
		boolean flag=false;
		String sql="";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			statement = connection.createStatement();
			sql = "update m_user set password='"+newPassword+"' where username='"+username+"'";
			System.out.println("********** Change User Password Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i!=0)
			{
				flag=true;
			}
			System.out.println("Change Password status  : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in Authority==>changeUserPassword(String username,String newPassword): "+ e);
		}
		return flag;
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
			System.out.println("Exception in AdminDAO==>getUserName(int UserId) : ");
			e.printStackTrace();
		}
		return name;
	}
	
	public static int getMaxUserId()
	{
		String sql="";
		int id = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select max(u_id) from m_user";
			System.out.println("********** Getting The Max User Id **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				id = resultSet.getInt(1);
			}
			System.out.println("Max User Id : "+id);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getMaxUserId() : ");
			e.printStackTrace();
		}
		return id;
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
			System.out.println("Exception in AdminDAO==>getUserId(String username) : ");
			e.printStackTrace();
		}
		return id;
	}
	
//All About Classification(STARTS)
	
	public static ResultSet getClassifications() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_classification");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getClassifications() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getClassification(int classificationId) 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_classification where c_id='"+classificationId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO-getClassification(int classificationId) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static boolean checkClassificationExistance(String classificationName)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_classification where c_name='"+classificationName+"'";
			System.out.println("********** Check Classification Existance Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Classification Existance Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>checkgetClassificationExistance(String classificationName) : ");
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean addClassificationDetails(String classificationName,String remarks)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "insert into m_classification(c_name,c_remark) values('"+classificationName+"','"+remarks+"')";
			System.out.println("********** Add Classification Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Add Classification Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>addClassificationDetails(String classificationName,String remarks) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updatClassificationDetails(int classificationId,String classificationName,String remarks)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_classification set c_name='"+classificationName+"',c_remark='"+remarks+"' where c_id='"+classificationId+"'";
			System.out.println("********** Update Classification Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update Classification Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updatClassificationDetails(): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean deleteClassificationDetails(int classificationId)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "delete from m_classification where c_id='"+classificationId+"'";
			System.out.println("********** Delete Classification Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Delete Classification Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>deleteClassificationDetails(int classificationId): ");
			e.printStackTrace();
		}
		return flag;
	}
//All About Classification(STARTS)	
	
// All About The Upload Image	

	public static ResultSet getImage() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_image");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getImage(int imageId) 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from m_image where img_id='"+imageId+"'");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImage(int imageId) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getTopNimg4Feature1Comparision(int noOfRecords) 
	{
		String sql="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_image order by f1_dist asc limit 0,"+noOfRecords;
			System.out.println("******* Getting The Images For Feature1 Processing *******");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImageTopNimg(int noOfRecords) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getTopNimg4Feature2Comparision(int noOfRecords) 
	{
		String sql="";
		double defaultValue = -1;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_image where f2_dist !='"+defaultValue+"' order by f2_dist asc limit 0,"+noOfRecords;
			System.out.println("******* Getting The Images For Feature2 Processing *******");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getTopNimg4Feature2Comparision(int noOfRecords) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static ResultSet getTopNimg4Feature3Comparision(int noOfRecords) 
	{
		String sql="";
		double defaultValue = -1;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_image where f3_dist !='"+defaultValue+"' order by f3_dist asc limit 0,"+noOfRecords;
			System.out.println("******* Getting The Images For Feature3 Processing *******");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getTopNimg4Feature3Comparision(int noOfRecords) : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public static int getMaxImageId()
	{
		String sql="";
		int id = 0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select max(img_id) from m_image";
			System.out.println("********** Getting The Max Image Id **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				id = resultSet.getInt(1);
			}
			System.out.println("Max ImageId : "+id);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getMaxImageId(): ");
			e.printStackTrace();
		}
		return id;
	}
	
	public static boolean checkImageExistance(String imageFileName)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from m_image where img_name='"+imageFileName+"'";
			System.out.println("********** Check Image Existance Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Image Existance : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>checkImageExistance(String imageFileName) : ");
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean addImageDetails(String imageFileName,String remarks,int classificationId)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "insert into m_image(img_name,remarks,c_id) values('"+imageFileName+"','"+remarks+"','"+classificationId+"')";
			System.out.println("********** Add Image Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Add Image Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>addImageDetails(String imageFileName,String remarks) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateImageDetails(ArrayList<String> list)
	{
		boolean flag=false;
		String sql = "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_image set image_name='"+list.get(1)+"',remarks='"+list.get(2)+"' where img_id='"+list.get(0)+"'";
			System.out.println("********** Update Image Details Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag=true;
			}
			System.out.println("Update Image Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateImageDetails(ArrayList<String> list) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean deleteImageDetails(int imageId)
	{
		boolean flag=false;
		String sql= "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			stmt = connection.createStatement();
			statement = connection.createStatement();
			sql = "delete from m_image where img_id='"+imageId+"'";
			System.out.println("********** Delete Image Details Info **********");
			System.out.println(sql);
			i = stmt.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Delete Image Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>deleteImageDetails(int imageId): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static String getImageName(int imageId)
	{
		String sql="";
		String name="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select img_name from m_image where img_id='"+imageId+"'";
			System.out.println("********** Getting The Image Name By Id **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				name = resultSet.getString(1);
			}
			System.out.println("Image Name["+imageId+"]: "+name);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getImageName(int imageId) : ");
			e.printStackTrace();
		}
		return name;
	}
	
	public static String getImageFeature1(int imageId)
	{
		String sql="";
		String feature="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select feature1 from m_image where img_id='"+imageId+"'";
			System.out.println("********** Getting The Image Freature1 By Id **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				feature = resultSet.getString(1);
			}
			//System.out.println("Freature1["+imageId+"]: "+feature);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getImageFeature1(int imageId) : ");
			e.printStackTrace();
		}
		return feature;
	}
	
	public static String getImageFeature2(int imageId)
	{
		String sql="";
		String feature="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select feature2 from m_image where img_id='"+imageId+"'";
			System.out.println("********** Getting The Image Freature2 By Id **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				feature = resultSet.getString(1);
			}
			//System.out.println("Freature2["+imageId+"]: "+feature);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>getImageFeature2(int imageId) : ");
			e.printStackTrace();
		}
		return feature;
	}
	
//Resetting (STARTS)
	
	public static boolean resetImgFeatures()
	{
		boolean flag=false;
		String sql= "",defaultValue="";
		double value = 0;
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_image set feature1='"+defaultValue+"',feature2='"+defaultValue+"',feature3='"+value+"',f1_dist='"+value+"',f2_dist='"+value+"',f3_dist='"+value+"'";
			System.out.println("********** Updatting F1,F2,F3 Dist To Default Value **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Update F1,F2,F3 Dist Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>resetImgFeatures() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateF1F2F3DistToDefault()
	{
		boolean flag=false;
		String sql= "",defaultValue="";
		double value = 0;
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_image set feature1='"+defaultValue+"',f1_dist='"+value+"',f2_dist='"+value+"',f3_dist='"+value+"'";
			System.out.println("********** Updatting F1,F2,F3 Dist To Default Value **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Update F1,F2,F3 Dist Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateF1F2F3DistToDefault() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean truncateFeature2()
	{
		boolean flag=false;
		String sql= "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "truncate table img_feature2";
			System.out.println("********** Truncating Feature2 Table  **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Truncate Feature2 Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>truncateFeature2() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean truncateFeature3()
	{
		boolean flag=false;
		String sql= "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "truncate table img_feature3";
			System.out.println("********** Truncating Feature3 Table  **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Truncate Feature3 Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>truncateFeature3() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	//Resetting (ENDS)
	
	public static boolean updateImgFeature1(int imageId,String imgFeature1)
	{
		boolean flag=false;
		String sql= "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			stmt = connection.createStatement();
			statement = connection.createStatement();
			sql = "update m_image set feature1='"+imgFeature1+"' where img_id='"+imageId+"'";
			System.out.println("********** Update Image Feature1 Info **********");
			System.out.println(sql);
			i = stmt.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Update Image Feature1 : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateImgFeature1(int imageId,String imgFeature1): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateImgFeature2(int imageId,String imgFeature2)
	{
		boolean flag=false;
		String sql= "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			stmt = connection.createStatement();
			statement = connection.createStatement();
			sql = "update m_image set feature2='"+imgFeature2+"' where img_id='"+imageId+"'";
			System.out.println("********** Update Image Feature2 Info **********");
			System.out.println(sql);
			i = stmt.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Update Image Feature2 : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateImgFeature2(int imageId,String imgFeature2): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean updateImgFeature3(int imageId,double imgFeature3)
	{
		boolean flag=false;
		String sql= "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			stmt = connection.createStatement();
			statement = connection.createStatement();
			sql = "update m_image set feature3='"+imgFeature3+"' where img_id='"+imageId+"'";
			System.out.println("********** Update Image Feature3 Info **********");
			System.out.println(sql);
			i = stmt.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Update Image Feature3 : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateImgFeature3(int imageId,String imgFeature3)): ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateImgDistance(int imageId,double distance)
	{
		boolean flag=false;
		String sql= "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_image set f1_dist='"+distance+"' where img_id='"+imageId+"'";
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
			System.out.println("Exception in AdminDAO==>updateImgDistance(int imageId,double distance) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateF2Distance()
	{
		boolean flag=false;
		String sql= "";
		double defaultValue = -1;
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_image set f2_dist='"+defaultValue+"'";
			System.out.println("********** Update F2 Distance(f2_dist) Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Update F2_Dist Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateF2Distance() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateF3Distance()
	{
		boolean flag=false;
		String sql= "";
		double defaultValue = -1;
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_image set f3_dist='"+defaultValue+"'";
			System.out.println("********** Update F3 Distance(f3_dist) Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Update F3_Dist Status : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateF3Distance() : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateImgDist4Feature1(int imageId,double distance1)
	{
		boolean flag=false;
		String sql= "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_image set f1_dist='"+distance1+"' where img_id='"+imageId+"'";
			System.out.println("********** Update Image Distance For Feature1 Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Update Image Distance1 : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateImgDist4Feature1(int imageId,double distance1) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateImgDist4Feature2(int imageId,double distance2)
	{
		boolean flag=false;
		String sql= "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_image set f2_dist='"+distance2+"' where img_id='"+imageId+"'";
			System.out.println("********** Update Image Distance For Feature2 Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Update Image Distance2 : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateImgDist4Feature2(int imageId,double distance2) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean updateImgDist4Feature3(int imageId,double distance3)
	{
		boolean flag=false;
		String sql= "";
		int i=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "update m_image set f3_dist='"+distance3+"' where img_id='"+imageId+"'";
			System.out.println("********** Update Image Distance For Feature3 Info **********");
			System.out.println(sql);
			i = statement.executeUpdate(sql);
			if(i>0)
			{
				flag = true;
			}
			System.out.println("Update Image Distance3 : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>updateImgDist4Feature3(int imageId,double distance3) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	//All About Image Feature2
	public static boolean checkImgIdExistance(int imageId)
	{
		boolean flag=false;
		String sql = "";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			sql = "select * from img_feature2 where img_id = '"+imageId+"'";
			System.out.println("********** Check Image Id Existance Info **********");
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				flag=true;
			}
			System.out.println("Image Existance : "+flag);
		}
		catch(Exception e)
		{
			System.out.println("Exception in AdminDAO==>checkImageExistance(String imageFileName) : ");
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static ResultSet getImageFeature2() 
	{
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from img_feature2");
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getImageFeature2() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
	
	//All About Image Feature3
		public static boolean checkImgIdExistance4F3(int imageId)
		{
			boolean flag=false;
			String sql = "";
			try
			{
				connection=DAO.getConnection();
				statement = connection.createStatement();
				sql = "select * from img_feature3 where img_id = '"+imageId+"'";
				System.out.println("********** Check Image Id Existance Info **********");
				System.out.println(sql);
				resultSet = statement.executeQuery(sql);
				while(resultSet.next())
				{
					flag=true;
				}
				System.out.println("Image Existance : "+flag);
			}
			catch(Exception e)
			{
				System.out.println("Exception in AdminDAO==>checkImgIdExistance4F3(int imageId) : ");
				e.printStackTrace();
			}
			return flag;
		}
		
		
		
		public static ResultSet getImageFeature3() 
		{
			try
			{
				connection=DAO.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery("select * from img_feature3");
			}
			catch(Exception e)
			{
				System.out.println("Opp's Exception is in AdminDAO==>getImageFeature3() : ");
				e.printStackTrace();
			}
			return resultSet;
		}
	
//All About The Classification(STARTS)
	
	public static int getClassifiedImageId() 
	{
		String sql="";
		int classificationId=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			System.out.println("\n******* Getting The Classification Id For Classified Image *******");
			//sql = "select c_id,avg(f1_dist) as s from m_image group by c_id order by s limit 1";
			sql = "select c_id,avg(f1_dist)+avg(f2_dist) as s from m_image group by c_id order by s limit 1";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			if(resultSet.next())
			{
				classificationId = resultSet.getInt(1);
			}
			System.out.println("Classification Id : " + classificationId);
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getClassifiedImageId() : ");
			e.printStackTrace();
		}
		return classificationId;
	}
    
	public static String getClassificationName(int classificationId) 
	{
		String sql="",classificationName="";
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			System.out.println("\n******* Getting The Classification Name By Id *******");
			sql = "select c_name from m_classification where c_id='"+classificationId+"'";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			if(resultSet.next())
			{
				classificationName = resultSet.getString(1);
			}
			System.out.println("Classification Name["+classificationId+"] : " + classificationName);
			
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getClassificationName(int classificationId) : ");
			e.printStackTrace();
		}
		return classificationName;
	}
	
	public static ResultSet getClassifiedImageResult() 
	{
		String sql="";
		int classificationId=0;
		try
		{
			connection=DAO.getConnection();
			statement = connection.createStatement();
			System.out.println("\n******* Getting The Classified Images Result *******");
			//sql = "select c_id,avg(f1_dist) as s from m_image group by c_id order by s limit 1";
			sql = "select c_id,avg(f1_dist)+avg(f2_dist) as s from m_image group by c_id order by s limit 1";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
			if(resultSet.next())
			{
				classificationId = resultSet.getInt(1);
			}
			System.out.println("Classification Id : " + classificationId);
			
			//sql = "select * from m_image where c_id ='"+classificationId+"' order by f1_dist";
			sql = "select * from m_image where c_id ='1' order by f1_dist+f1_dist";
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println("Opp's Exception is in AdminDAO==>getClassifiedImageResult() : ");
			e.printStackTrace();
		}
		return resultSet;
	}
	
//All About The Classification(ENDS)	
	

}
