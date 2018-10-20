/**

 File : Test.java
 Package : com.admin
*/

package com.admin;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.AdminDAO;

/*
 * Reading 'text' data type from ResultSet
 * Qn : how to read unicode text from java resultset?
 * Ans : rs.getString() returns a Java String which is Unicode by definition.
 */

public class Test 
{
	public static void main(String[] args) 
	{
		try 
		{
			ResultSet rs = AdminDAO.getImageFeature2();
			while(rs.next())
			{
				System.out.println(rs.getString(3));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
