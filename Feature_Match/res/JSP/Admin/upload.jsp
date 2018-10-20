<%@page import="com.dao.AdminDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.util.Utility"%>
<html>
<head>
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
<body onload="startTimer()">
<div class="container" id="label" style="position:absolute;top:1px;left:250px;width: 350px;height:450px;">

<%	
	int no=Utility.parse(request.getParameter("no"));
	if(no==1)
	{
%>
		<div class="success" id="message">	
			<p>Image Uploaded Successfully.....</p>
		</div>				
<%
	}
	if(no==2)
	{
%>
			<div class="error" id="message">	
				<p>Opp's,Something Went Wrong!!!!!</p>
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
%>
   
<div class="TabMenu" style="position: relative;left:75px;">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;			
	<span>
		<img src="<%=request.getContextPath() %>/res/images/upload.png" height="50" width="50" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<br>&nbsp;&nbsp;Single
	</span>
 	
	<span>
		<img src="<%=request.getContextPath() %>/res/images/uploas_multiple.png" height="50" width="50" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<br>&nbsp;&nbsp;Multiple
	</span>
	
	<h2>Upload Files Details<h2>
</div>	
<br>

<hr size="10" color="#351616"></hr>

<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent">
		
		 <table align="center" id="login">
		   <form action="<%=request.getContextPath()%>/UploadFileAction" enctype="multipart/form-data" method="post">
		  		<tr>
	  				<td colspan="3" align="center">
	  					<p><h2>Single File Upload</h2>
	  				</td>
		  		</tr>
		  		
		  		<tr>
		  				<td id="label">
		  						Browse File : 
		  				</td>
		  				
		  				<td width="10px"></td>
		  				
		  				<td>
		  						<input class="field" name="myfile" type="file" required="yes"/>
		  				</td>
		  		</tr>
		  		
		  		<tr>
		  				<td id="label">
		  						Classification : 
		  				</td>
		  				
		  				<td width="10px"></td>
		  				
		  				<td>
		  						<select name="classification" style="width: 190px;border:5px solid #351616;font-size:12px;line-height:1.5em;padding:4px; ">
		  						
		  						<%
		  							ResultSet rs = AdminDAO.getClassifications();
		  							while(rs.next())
		  							{
		  						%>
		  								<option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>
		  						<%
		  							}
		  						%>
		  									
		  						</select>
		  				</td>
		  		</tr>
		  		
		  		<tr>
		  				<td id="label">
		  						Remarks : 
		  				</td>
		  				
		  				<td width="10px"></td>
		  				
		  				<td>
		  						<input class="field" name="remarks" type="text" />
		  				</td>
		  		</tr>
		  		
		  		<tr height="10px"></tr>
		  		
		  		<tr>
		  				<td id="label" colspan="3" align="center">
		  					 <input class="button" type="submit" value="Upload File"/>
		  				</td>
		  				
		  		</tr>
		  	</form>	
		 </table>
		  
		</div>
		
		<%-- Multiple File Upload --%>
		<div class="TabContent">
		
		 <table align="center" id="login">
		   <form method="post" action="<%=request.getContextPath() %>/AdminLogin">
		  		<tr>
	  				<td colspan="3" align="center">
	  					<p><h2>Multiple File Upload</h2>
	  				</td>
		  		</tr>
		  		
		  		<tr>
		  				<td id="label">
		  						Browse File : 
		  				</td>
		  				
		  				<td width="10px"></td>
		  				
		  				<td>
		  						<input class="field" name="myfile" type="file" required="yes"/>
		  				</td>
		  		</tr>
		  		
		  		<tr>
		  				<td id="label">
		  						Remarks : 
		  				</td>
		  				
		  				<td width="10px"></td>
		  				
		  				<td>
		  						<input class="field" name="remarks" type="text" />
		  				</td>
		  		</tr>
		  		
		  		<tr height="10px"></tr>
		  		
		  		<tr>
		  				<td id="label" colspan="3" align="center">
		  					 <input class="button" type="submit" value="Upload File"/>
		  				</td>
		  				
		  		</tr>
		  	</form>	
		 </table>
		  
		</div>
		
	</div>
</div>
	
</div>

</body>
</html>