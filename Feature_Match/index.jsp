<%@page import="com.util.Utility"%>
<html>
<head>
    <title>Medical Image Classification</title>
	<link href="<%=request.getContextPath() %>/res/CSS/style1.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" /> 
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/login.css" type="text/css"/>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/style.js"></script>
	<script src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function()
			{
				$(".container .TabMenu span:first").addClass("selector");
				$(".container .TabMenu span").mouseover(function()
					{
						$(this).addClass("hovering");
					});
				$(".container .TabMenu span").mouseout(function()
					{
						$(this).removeClass("hovering");
					});				
				$(".container .TabMenu span").click(function()
					{
						$(".selector").removeClass("selector");
						$(this).addClass("selector");
						var TabWidth = $(".TabContent:first").width();
						if(parseInt($(".TabContent:first").css("margin-left")) > 0)
							TabWidth += parseInt($(".TabContent:first").css("margin-left"));
						if(parseInt($(".TabContent:first").css("margin-right")) >0)
							TabWidth += parseInt($(".TabContent:first").css("margin-right"));
						var newLeft = -1* $("span").index(this) * TabWidth;
						$(".AllTabs").animate({
							left: + newLeft + "px"},1000);
					});
			});
</script>
</head>

<body onload="startTimer()">
<img src="<%=request.getContextPath() %>/res/images/header.jpg"></img>


<div class="container" id="label">
<%	
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{
%>
			<div class="error" id="message">	
				<p>Opp's,Invalid userid / password..!</p>
			</div>			
<%
		}
		if(no==3)
		{
%>
			<div class="error" id="message">	
				<p>Opp's,Something Went Wrong!!!!!</p>
			</div>			
<%
		}
		if(no==4)
		{
%>
			<div class="success" id="message">	
				<p>You Have Registered Successfully!</p>
			</div>			
<%
		}
		if(no==5)
		{
%>
			<div class="error" id="message">	
				<p>Opp's,User Already Exists!!!!!</p>
			</div>			
<%
		}
		if(no==6)
		{
%>
			<div class="success" id="message" style="position: relative;width:230px;">	
				<p>You Have Logged Out Successfully!</p>
			</div>			
<%
		}
%>
    
	<div class="TabMenu">
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
		<span>
			<img src="<%=request.getContextPath() %>/res/images/admin.png" height="50" width="50" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<br>&nbsp;&nbsp;Admin
		</span>
		<span>
			<img src="<%=request.getContextPath() %>/res/images/user.png" height="50" width="50" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<br>&nbsp;&nbsp;Users
		</span>
		
	</div>	
	<br>
	<hr size="10" color="#351616"></hr>
	<div class="ContentFrame">
		<div class="AllTabs">
			<div class="TabContent">
				<p><h2>Admin Login</h2>
					<form method="post" id="login" action="<%=request.getContextPath() %>/AdminLogin">
						Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="field" name="name" type="text" required="required"/><br>
						Password<input class="field" name="pass" type="password" required="required"/><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="button" type="submit"/>
					</form>
				</p>
			</div>
			<div class="TabContent">
				<p><h2>User Login</h2>
					<form method="post" id="login" action="<%=request.getContextPath()%>/UserLogin">
						Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="field" name="name" type="text" required="yes"/><br>
						Password<input class="field" name="pass" type="password" required="yes"/><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="button" type="submit"/>
						<pre>No Account ? <a href="<%=request.getContextPath()%>?no=2">Sign up here</a></pre>	
					</form>
				</p>
			</div>
		</div>
	</div>
	
</div>
<%
	if(no==2)
	{%>
		<div style="position:absolute;top:125px;left:50" class="c">	
		<%
			if(Utility.parse(request.getParameter("no1"))==5)
			{%>
				<div class="error" id="message" style="position:absolute">	
					<p>Sorry this user id is already exists.....!</p>
				</div>			
			<%}
		%>
			<table id="login">
			<h1 align="center" id="label">User Registeration</h1>
			<hr size="10" color="#351616"></hr>
			<form  action="<%=request.getContextPath() %>/UserList">
				<tr id="label">
					<td>Username</td>
					<td>
						<input class="field" name="username" type="text" required="yes" title="Enter Your Username."/>
					</td>
					
					<td>Password</td>
					<td>
							<input class="field" name="password" type="text" required="yes" title="Enter Your Password."/>
					</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
				</tr>
				
				
			    <tr id="label">
					<td>Name</td>
					<td>
						<input class="field" name="name" type="text" required="yes" title="Enter Your Name"/>
					</td>
					
					<td>Gender</td>
					<td>
							<input name="sex" type="radio" checked="checked" value="Male"/> Male
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input name="sex" type="radio" value="Female"/> Female
					</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
				</tr>



				<tr id="label">
					<td>DOB</td>
					<td>
						<input class="field" name="dob" type="text" placeholder="DD/MM/YYYY" required="yes" title="Enter Your DOB."/>
					</td>
					
					<td>Cell</td>
					<td>
							<input class="field" name="cell" type="text" required="required" title="Please,Enter Valid Mobile Number."/>
					</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
				</tr>
				
				
				<tr id="label">
					<td>Phone</td>
					<td>
						<input class="field" name="phone" type="text"   title="Please,Enter Valid Phone Number."/>
					</td>
					
					<td>Email</td>
					<td>
							<input class="field" name="email" type="text" required="yes" title="Enter Your Valid Email."/>
					</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
				</tr>
				
				<tr id="label">
					<td>Address</td>
					<td>
						<input class="field" name="address" type="text" title="Please,Enter The Address."/>
					</td>
					
				</tr>
				
				<tr>
					<td>&nbsp;</td>
				</tr>
				
				
				<tr>
					<td>&nbsp;</td>
					<td align="center" colspan="3">
						<input class="button" type="submit" value="Register"/>
						<input type="hidden" name="action" value="Add"/>
					</td>
				</tr>
			</form>
			</table>
	   </div>			
	<%
	}
	else
	{
		%><%
	}
%>

</body>
</html>