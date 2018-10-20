<%@page import="com.util.Utility"%>
<%@page import="com.dao.AdminDAO"%>
<%@ page import="java.sql.*" %>
<html>

<head>
    <title>User List</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/message.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/contact.css" type="text/css"/>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/button.css" type="text/css"/>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/pagination.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/style.js"></script>
</head>

<%!
	ResultSet rs = null;
%>

<%
	rs = AdminDAO.getUsers();
%>

<body onload="startTimer()">
<br><br>
<form action="<%=request.getContextPath() %>/UserList">

<table id="results" class="tab" align="center" style="">
	<tr align="center">
		<th>Name</th>
		<th>Gender</th>
		<th>Cell</th>
		<th>Phone</th>
		<th>Email</th>
		<th>Address</th>
	</tr>
<%
		while(rs.next())
		{
%>
			<tr align="center">
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getString(5)%></td>
				<td><%=rs.getString(7)%></td>
				<td><%=rs.getString(8)%></td>
				<td><%=rs.getString(9)%></td>
				<td><%=rs.getString(10)%></td>
			</tr>
<%
		}
%>
</table>
</form>
<div id="pageNavPosition" style="cursor:hand"></div>
<script type="text/javascript"><!--
        var pager = new Pager('results', 5); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>
<%
	if(Utility.parse(request.getParameter("no"))==1)
    {%>
    	<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
    		<p>Volunteer Added Successfully.....!</p>
    	</div>			
    <%}
	if(Utility.parse(request.getParameter("no"))==-1)
	{%>
		<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's something went wrong.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==2)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's select atleast one.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==3)
	{%>
		<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Volunteer Deleted Successfully.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==4)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's Select only one volunteer to edit....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==5)
	{%>
		<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Volunteer Updated Successfully....!</p>
		</div>			
	<%}
%>		
</body>
</html>