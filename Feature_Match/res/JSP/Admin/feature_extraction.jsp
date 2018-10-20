<%@page import="com.util.Utility"%>
<%@ page import="java.sql.*" %>
<html>
<head>
	<title>Feature Extraction</title>
	<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/button.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/style.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery-1.6.4.min.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function() 
	{

		 $('#disableButton').attr('disabled', true);
		
	});
	</script>
</head>

<%!
	long start = 0,end = 0,processTime=0;
%>

<%
	if(Utility.parse(request.getParameter("no"))==1)
	{
		start = (Long)request.getAttribute("start_time");
		end = System.nanoTime();
		// 1s = 1000000 microseconds
		//long processTime = (end - start);//in nanoseocond
		//processTime = (end - start) / 1000;//in microseconds
		
		processTime = ((end - start) / 1000)/1000;//in Milliseconds
	}
%>

<body onload="startTimer()">
<br>
		
<table align="center">

	<tr>
			<td colspan="3" align="center">
					<a class="gradientbuttons" href="<%=request.getContextPath() %>/ResetFeature" target="afrm">Reset Feature</a>
			</td>
	</tr>
	
	<tr height="30px"></tr>

	<tr>
			<td >
					<a class="gradientbuttons" href="<%=request.getContextPath() %>/ExtractFeature" target="afrm">Extract Feature1</a>
			</td>
			
 			
			<td width="10px"></td>
			
			<td>
					<a class="gradientbuttons" href="<%=request.getContextPath() %>/ExtractFeature1" target="afrm">Extract Feature2</a>
			</td>
<%--			
			<td width="10px"></td>
			
			<td>
					<a class="gradientbuttons" href="<%=request.getContextPath() %>/ExtractFeature3" target="afrm">Extract Feature3</a>
			</td>
--%>			
	</tr>
	
		
<%
		if(Utility.parse(request.getParameter("no"))==1)
		{
%>
			<tr height="50px"></tr>
			
			<tr align="center">
					<td colspan="3" align="center">
							<font color="white" size="4">Feature Extraction Processing Time : </font>
							<font color="black" size="4"><%=processTime%> Milliseconds</font>
					</td>
			</tr>
			
			<div class="success" id="message" style="position: absolute;left:190px;top:150px;width:400px;">	
				<p>Feature Extracted Successfully.....</p>
			</div>
<%
		}
		if(Utility.parse(request.getParameter("no"))==2)
		{
%>
			<div class="error" id="message" style="position: absolute;left:190px;top:150px;width:400px;">	
				<p>Opps,Something Went Wrong!!!!!</p>
			</div>
<%
		}
		if(Utility.parse(request.getParameter("no"))==3)
		{
%>
			<div class="success" id="message" style="position: absolute;left:190px;top:150px;width:400px;">	
				<p>Feature Reseted Successfully.....</p>
			</div>
<%
		}
%>
</table>
</body>
</html>