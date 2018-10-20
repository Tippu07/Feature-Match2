<%@page import="com.util.Utility"%>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Update Profile</title>
	<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/button.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/form.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/style.js"></script>
</head>

<%!
	ResultSet rs = null;
	int no = 0,id=0 ;
	String username="",password="",name="",gender="",address="",mobileNumber="",phoneNumber="",emailId="",dob="";
%>

<%
	rs = (ResultSet)request.getAttribute("rs");
	no = Utility.parse(request.getParameter("no"));
	
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
			<p>Opp's,Something Went Wrong!!!!!</p>
		</div>
<%
	}
	if(no==0)
	{
%>
		
		<form action="<%=request.getContextPath() %>/EditProfile">
		<input type="hidden" name="no" value="2"></input>
		<table align="center" id="login">
			<tr>
					<td>
							<input type="submit" value="Save Updates" class="gradientbuttons" id="a1"/>
					</td>
					
					<td width="10px"></td>
					
					<td>
							<a class="gradientbuttons" href="<%=request.getContextPath() %>/ChangePass?no=1&id=<%=id %>" target="afrm">Change Password</a>
					</td>
			</tr>
			
			
			<tr height="3px"></tr>
			
			
			<tr align="center">
					<td>
							ID 
					</td>
					
					<td width="30px">:</td>
					
					<td>
							<input class="field" type="text" name="id" value="<%=id %>" readonly="readonly"/>
					</td>
			</tr>
			
			<tr height="3px"></tr>
			
			<tr align="center">
					<td >
							Username  
					</td>
					
					<td width="30px">:</td>
					
					<td>
							<input class="field" type="text" name="username" value="<%=username %>" required="required"/>
					</td>
			</tr>
			
			<tr height="3px"></tr>
			
			<tr align="center">
					<td >
							Name  
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<input class="field" type="text" name="name" value="<%=name %>" required="required"/>
					</td>
			</tr>
			
			<tr height="3px"></tr>
			
			<tr align="center">
					<td >
							EmailId  
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<input class="field" type="text" name="email" value="<%=emailId%>" required="required"/>
					</td>
			</tr>
			
			
			<tr height="3px"></tr>
			
			<tr align="center">
					<td >
							Mobile Number  
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<input class="field" type="text" name="mob" value="<%=mobileNumber %>" required="required"/>
					</td>
			</tr>
			
			
			<tr height="3px"></tr>
			
			
			<tr align="center">
					<td >
							Phone Number  
					</td>
					
					<td width="30px">:</td>
					
					<td >
							<input class="field" type="text" name="phone" value="<%=phoneNumber %>" required="required"/>
					</td>
			</tr>
			
			
			<tr height="3px"></tr>
			
			
			<tr align="center">
					<td >
							Address  
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<input class="field" type="text" name="address" value="<%=address %>" required="required"/>
					</td>
			</tr>
			
		</table>
			</form>
<%
	}
%>
</body>
</html>