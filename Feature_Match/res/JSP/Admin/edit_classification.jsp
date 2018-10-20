<%@page import="java.sql.ResultSet"%>
<%@page import="com.util.Utility"%>
<html>
<head>
	<title>Update Classification</title>
	<link href="<%=request.getContextPath() %>/res/CSS/style1.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" /> 
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/form.css" type="text/css"/>
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

<%!
	ResultSet rs = null;
	int classificationId=0;
	String classificationName="",remarks="";
%>

<%
	rs = (ResultSet)request.getAttribute("rs");
    if(rs!=null);
	while(rs.next())
	{
		classificationId = rs.getInt(1);
		classificationName = rs.getString(2);
		remarks = rs.getString(3);
	}
%>

<body onload="startTimer()">
<div class="container" id="label" style="position:absolute;top:10px;left:250px;width: 350px;height:425px;">

<div class="TabMenu" style="position: relative;left:25px;">
	<h2>Upadte Classification Details<h2>
</div>	
<br>

<hr size="10" color="#351616"></hr>

<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent">
		
		 <table align="center" id="login">
		   <form action="<%=request.getContextPath()%>/ClassificationList">
		  		
		  		<tr height="20px"></tr>
		  		
		  		<tr>
		  				<td id="label">
		  						Name : 
		  				</td>
		  				
		  				<td width="10px"></td>
		  				
		  				<td>
		  						<input type="text" class="field" name="name" value="<%=classificationName%>" required="required" autofocus="autofocus" title="Enter The Classification Name."/>
		  				</td>
		  		</tr>
		  		
		  		<tr>
		  				<td id="label">
		  						Remarks : 
		  				</td>
		  				
		  				<td width="10px"></td>
		  				
		  				<td>
		  						<input class="field" type="text" name="remarks"  value="<%=remarks%>"/>
		  				</td>
		  		</tr>
		  		
		  		<tr height="30px"></tr>
		  		
		  		<tr>
		  				<td id="label" colspan="3" align="center">
		  					 <input class="button" type="submit" name="action" value="Update Classification"/>
		  					 <input type="hidden" name="id" value="<%=classificationId%>">
		  				</td>
		  				
		  		</tr>
		  	</form>	
		 </table>
		  
		</div>
		
		
	</div>
</div>
	
</div>

<%	
	int no=Utility.parse(request.getParameter("no"));
	if(no==1)
	{
%>
		<div class="success" id="message" style="position:absolute;top:60px;left:270px">	
			<p>Classification Details Added Successfully...</p>
		</div>				
<%
	}
	if(no==2)
	{
%>
			<div class="error" id="message" style="position:absolute;top:60px;left:270px">	
				<p>Sorry,The Classification Already Exists!!!!!</p>
			</div>			
<%
	}
	if(no==3)
	{
%>
			<div class="error" id="message" style="position:absolute;top:60px;left:270px">	
				<p>Opp's,Something Went Wrong!!!!!</p>
			</div>			
<%
	}
%>
   

</body>
</html>