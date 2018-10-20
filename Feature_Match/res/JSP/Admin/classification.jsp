<%@page import="com.util.Utility"%>
<%@page import="com.dao.AdminDAO"%>
<%@ page import="java.sql.*" %>
<html>

<head>
    <title>Classification List</title>
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
	rs = (ResultSet)request.getAttribute("rs");
%>

<body onload="startTimer()">
<br><br>
<form action="<%=request.getContextPath() %>/ClassificationList">

<input type="submit" name="action" value="Add" class="gradientbuttons" style="margin-left: 25px;;">
<input type="submit" name="action" value="Edit" class="gradientbuttons">
<input type="submit" name="action" value="Delete" class="gradientbuttons">

<table id="results" class="tab" align="center" style="width:780px;">
   
	<tr align="center">
		<th>Select</th>
		<th>Classification Name</th>
		<th>Classification Remark</th>
	</tr>
<%
		while(rs.next())
		{
%>
			<tr align="center">
				<td><input name="chk" type="checkbox" value="<%=rs.getInt(1)%>"></input></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
			</tr>
<%
		}
%>
</table>
</form>
<div id="pageNavPosition" style="cursor:hand;position:relative;left:25px;"></div>
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
    		<p>Classification Details Added Successfully.....!</p>
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
			<p>Classification Details Deleted Successfully.....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==4)
	{%>
		<div class="error" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Opp's Select only one record to edit....!</p>
		</div>			
	<%}
	if(Utility.parse(request.getParameter("no"))==5)
	{%>
		<div class="success" id="message" style="position:absolute;top:10px;left:300px">	
			<p>Classification Details Updated Successfully....!</p>
		</div>			
	<%}
%>		
</body>
</html>