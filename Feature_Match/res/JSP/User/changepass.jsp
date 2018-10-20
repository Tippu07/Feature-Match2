<%@page import="com.util.Utility"%>
<html>
<head>
	<title>Chenge Password</title>
	<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/button.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/form.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/style.js"></script>

</head>

<%!
	int no = 0;
	String username = "";
%>

<%
	no = Utility.parse(request.getParameter("no"));
    username = (String)session.getAttribute("username");
%>

<body onload="startTimer()">

<form action="<%=request.getContextPath() %>/ChangeUserPassword">
		<input type="hidden" name="no" value="2"></input>
		<table align="center" id="login">
			<tr>
					<td>
							<a class="gradientbuttons" href="<%=request.getContextPath() %>/EditUserProfile?no=1" target="afrm">Edit Profile</a>
					</td>
					
					<td width="10px"></td>
					
					<td>
							<input type="submit" value="Save Updates" class="gradientbuttons" id="a1"/>
					</td>
			</tr>
			
			
			<tr height="25px"></tr>
			
			<tr align="center">
					<td >
							Username  
					</td>
					
					<td width="30px">:</td>
					
					<td>
							<input class="field" type="text" name="username" value="<%=username %>" readonly="readonly"/>
					</td>
			</tr>
			
			<tr height="5px"></tr>
			
			<tr align="center">
					<td >
							Current Password
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<input class="field" type="text" name="cur_pwd" required="required" title="Please,Enter The Current Password."/>
					</td>
			</tr>
			
			<tr height="5px"></tr>
			
			<tr align="center">
					<td >
							New Password 
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<input class="field" type="text" name="new_pwd" required="required" title="Please,Enter The New Password."/>
					</td>
			</tr>
			
			<tr height="5px"></tr>
			
			<tr align="center">
					<td >
							Confirm Password 
					</td>
					
					<td width="30px">:</td>
					
					<td id="al">
							<input class="field" type="text" name="cnf_pwd" required="required" title="Please,Enter The Confirm Password."/>
					</td>
			</tr>
<%
	if(no==1)
	{
%>
		<div class="error" id="message">	
			<p>Opp's,Your Current Password is Wrong!!!!!</p>
		</div>
<%
}
	if(no==2)
	{
%>
		<div class="error" id="message">	
			<p>Opp's,New Password and Confirm Password is not Same!!!!!</p>
		</div>
<%
}
	if(no==3)
	{
%>
		<div class="error" id="message">	
			<p>Opp's,Something Went Wrong !!!!!</p>
		</div>
	<%
	}
%>	
	
</body>
</html>