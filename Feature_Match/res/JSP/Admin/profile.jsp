<%@page import="com.util.Utility"%>
<%@ page import="java.sql.*" %>
<html>
<head>
	<title>Profile</title>
	<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/button.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/style.js"></script>
</head>

<%!
	ResultSet rs = null;
	int no = 0,id=0 ;
	String username="",password="",name="",gender="",address="",mobileNumber="",phoneNumber="",emailId="",dob="";
%>

<%
	rs=(ResultSet)request.getAttribute("rs");
	no=Utility.parse(request.getParameter("no"));
	
    if(no==0)
	while(rs.next())
	{
		id = rs.getInt(1);
		username = rs.getString(2);
		password = rs.getString(3);
		name = rs.getString(4);
		gender = rs.getString(5);
		mobileNumber = rs.getString(6);
		phoneNumber = rs.getString(7);
		emailId = rs.getString(8);
		address = rs.getString(9);
	}
%>

<body onload="startTimer()">
<%
	if(no==1)
	{
%>
		<div class="error" id="message">	
			<p>Opp's,Seems Something Went Wrong !!!!!</p>
		</div>
<%
	}
	if(no==0)
	{
		
%>
	    <br>
		
		<table align="center">
			<tr>
					<td>
							<a class="gradientbuttons" href="<%=request.getContextPath() %>/EditProfile?no=1" target="afrm">Edit Profile</a>
					</td>
					
					<td width="10px"></td>
					
					<td>
							<a class="gradientbuttons" href="<%=request.getContextPath() %>/ChangePass?no=1&id=<%=id %>" target="afrm">Change Password</a>
					</td>
			</tr>
			
			
			<tr height="25px"></tr>
			
			
			<tr align="center">
					<td>
							ID 
					</td>
					
					<td width="30px">:</td>
					
					<td>
							<%=id %>
					</td>
			</tr>
			
			<tr height="10px"></tr>
			
			<tr align="center">
					<td >
							Username  
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<%=username %>
					</td>
			</tr>
			
			<tr height="10px"></tr>
			
			<tr align="center">
					<td >
							Name  
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<%=name %>
					</td>
			</tr>
			
			<tr height="10px"></tr>
			
			<tr align="center">
					<td >
							EmailId  
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<%=emailId %>
					</td>
			</tr>
			
			
			<tr height="10px"></tr>
			
			<tr align="center">
					<td >
							Mobile Number  
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<%=mobileNumber %>
					</td>
			</tr>
			
			
			<tr height="10px"></tr>
			
			<tr align="center">
					<td >
							Phone Number  
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<%=phoneNumber %>
					</td>
			</tr>
			
			
			<tr height="10px"></tr>
			
			
			<tr align="center">
					<td >
							Address  
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<%=address %>
					</td>
			</tr>
			
		</table>
		
<%
		if(Utility.parse(request.getParameter("no1"))==1)
		{
%>
			<div class="success" id="message">	
				<p>Your Profile Updated Successfully!!!!!</p>
			</div>
<%
		}
	}
%>
</body>
</html>