<%@page import="com.util.Utility"%>
<html>
<head>
    
    <title>Search Image</title>
    
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
<div class="container" id="label" style="position:absolute;top:7px;left:150px;width:550px;height:440px;">

<%!
	int no = 0,no1=0;
	String fileName = "";
%>

<%	
	no = Utility.parse(request.getParameter("no"));
	no1 = Utility.parse(request.getParameter("no1"));
	if(no==1)
	{
%>
		<div class="success" id="message">	
			<p>Image Searching Process Done Successfully.....</p>
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
				<p>Opps,Something Went Wrong While Feature1 Comparison!!!!!</p>
			</div>			
<%
	}
	if(no==4)
	{
%>
			<div class="error" id="message">	
				<p>Opps,Something Went Wrong While Feature2 Comparison!!!!!</p>
			</div>			
<%
	}
	if(no==0 & no1==1)
	{
%>
		<div class="success" id="message">	
			<p>Requested Process Done Successfully.....</p>
		</div>				
<%
	}
	if(no==0 & no1==2)
	{
%>
		<div class="error" id="message">	
				<p>Opp's,Something Went Wrong!!!!!</p>
		</div>	
<%
	}
%>
   
<div class="TabMenu" style="position: relative;left:0px;text-align: center;">
	<span>
		<img src="<%=request.getContextPath() %>/res/images/search.png" height="50" width="50" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</span>
<%
		if(no == 22)
		{
%>
	<h2>Medical Image Classification Result<h2>
<%
		}
		else
		{
%>	
	<h2>Classify  Image<h2>
<%
	} 
%>	
</div>	

<hr size="10" color="#351616"></hr>

<%
	if( no == 0)
	{
%>

<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent" style="position: relative;width: 550px;">
		 <table align="center" id="login">
		   <form action="<%=request.getContextPath()%>/SearchFileAction" enctype="multipart/form-data" method="post">
		  		<tr>
	  				<td colspan="3" align="center">
	  					<p><h2>Search Image Files</h2>
	  				</td>
		  		</tr>
		  		
		  		<tr>
		  				<td id="label">
		  						Browse Image File : 
		  				</td>
		  				
		  				<td width="10px"></td>
		  				
		  				<td>
		  						<input class="field" name="myfile" type="file" required="yes"/>
		  				</td>
		  		</tr>
		  		
		  		<tr height="35px"></tr>
		  		
		  		<tr>
		  				<td id="label" colspan="3" align="center">
		  					 <input class="button" type="submit" value="Search Image"/>
		  				</td>
		  				
		  		</tr>
		  	</form>	
		 </table>
		  
		</div>
		
	</div>
</div>

		
<%
	}// Ends  if(no == 0)
	else if(no == 11)
	{
		fileName = (String)request.getAttribute("image_name");
		
%>

	<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent" style="position: relative;width: 550px;">
		  <table align="center" id="login">
		    <form action="<%=request.getContextPath()%>/SearchImage" method="post">
		 	
		 	<tr align="center">
		 			<td align="center">
		 					<img src="<%=request.getContextPath() %>/Files/Search/<%=fileName %>" height="200" width="200" />
		 			</td>
		 	</tr>
		 	
		 	<tr height="10px"></tr>
		 	
		 	<tr align="center">
		 		 <td align="center">
		 		 		<input  class="button" type="submit" value="Search Image"/>
		 		 </td>
		 	</tr>
		 	
		 	</form>
		 	</table>
		</div>
		
	</div>
</div>

<%		
		
	}
	else if(no == 22)
	{
		int totalNoOfImgInDb = (Integer)request.getAttribute("tatal_img");
		int noOfclassifiedImg = (Integer)request.getAttribute("no_classified_img");
		
		long f1ProcessingTime=0,f2ProcessingTime=0,f3ProcessingTime=0;
		String classsificationName="";
		f1ProcessingTime = (Long)request.getAttribute("f1_time");
		//f2ProcessingTime = (Long)request.getAttribute("f2_time");
		//f3ProcessingTime = (Long)request.getAttribute("f3_time");
		
		classsificationName = (String)request.getAttribute("classsification_name");
		
		
%>
	<div class="ContentFrame">
	<div class="AllTabs">
		<div class="TabContent" style="position: relative;width: 550px;">
		  <table align="center" id="login">
		    <form action="<%=request.getContextPath()%>/res/JSP/User/view_file.jsp" method="post">
		 	
		 	<tr align="center">
		 			<td align="center" colspan="3">
		 					<font color="#003366" size="6">Image Classification Information </font>
		 			</td>
		 	</tr>
		 	
		 	<tr height="10px"></tr>
		 	
		 	<tr align="center">
		 			<td align="center">
		 					<font color="white" size="4">Total Number Of Images To Proccess</font>
							
		 			</td>
		 			
		 			<td width="20px" align="center">:</td>
		 			
		 			<td align="center">
							<font color="black" size="4"><%=totalNoOfImgInDb%></font>
		 			</td>
		 	</tr>
		
			<tr height="10px"></tr>
			
<%-- 		 	
		 	<tr align="center">
		 	
		 			<td align="center">
		 					<font color="white" size="4">Time Taken For Feature1 Comparision</font>
		 			</td>
		 			
		 			<td width="20px" align="center">:</td>
		 			
		 			<td align="center">
							<font color="black" size="4"><%=f1ProcessingTime%> ms</font>
		 			</td>
		 	</tr>
		 	
		 	<tr align="center">
		 	
		 			<td align="center">
		 					<font color="white" size="4">Toatal No. Of Images Considerd For Feature2 Comparision</font>
		 			</td>
		 			
		 			<td width="20px" align="center">:</td>
		 			
		 			<td align="center">
							<font color="black" size="4"><%=Utility.getPro("Feature1_Threshold") %></font>
		 			</td>
		 	
		 	</tr>
--%>		 	
		 	<tr align="center">
		 	
		 	
		 			<td align="center">
		 					<font color="white" size="4">Time Taken For  Classification</font>
		 			</td>
		 			
		 			<td width="20px" align="center">:</td>
		 			
		 			<td align="center">
						<font color="black" size="4"><%=f1ProcessingTime%> ms</font>
		 			</td>
		 	
		 	</tr>
		 	
		 	<tr height="10px"></tr>
<%-- 		 	
		 	<tr align="center">
		 	
		 			<td align="center">
		 					<font color="white" size="4">Toatal No. Of Images Considerd For Feature3 Comparision</font>
		 			</td>
		 			
		 			<td width="20px" align="center">:</td>
		 			
		 			<td align="center">
						<font color="black" size="4"><%=Utility.getPro("Feature2_Threshold") %></font>
		 			</td>
		 	
		 	</tr>
		 	
		 	<tr align="center">
		 	
		 			<td align="center">
		 					<font color="white" size="4">Time Taken For Feature3 Comparision</font>
		 			</td>
		 			
		 			<td width="20px" align="center">:</td>
		 			
		 			<td align="center">
						<font color="black" size="4"><%=f3ProcessingTime%> ms</font>
		 			</td>
		 			
		 	</tr>
		 	
		 	<tr align="center">
		 	
		 			<td align="center">
		 					<font color="white" size="4">Toatal No. Of Images Retrieved</font>
		 			</td>
		 			
		 			<td width="20px" align="center">:</td>
		 			
		 			<td align="center">
						<font color="black" size="4"><%=Utility.getPro("Feature3_Threshold") %></font>
		 			</td>
		 	</tr>
--%>		 	

            <tr align="center">
		 	
		 	
		 			<td align="center">
		 					<font color="white" size="4">Classification Name</font>
		 			</td>
		 			
		 			<td width="20px" align="center">:</td>
		 			
		 			<td align="center">
						<font color="black" size="4"><%=classsificationName%></font>
		 			</td>
		 	
		 	</tr>

		 	<tr height="10px"></tr>
		 	
		 	 <tr align="center">
		 	
		 	
		 			<td align="center">
		 					<font color="white" size="4">No. Of Images Belongs To Classification<br>[<%=classsificationName%>]</font>
		 			</td>
		 			
		 			<td width="20px" align="center">:</td>
		 			
		 			<td align="center">
						<font color="black" size="4"><%=noOfclassifiedImg%></font>
		 			</td>
		 	
		 	</tr>

		 	
		 	
		 	</form>
		 	</table>
		</div>
		
	</div>
</div>

<div class="success" id="message" style="position: absolute;top:90px;left:100px;">	
			<p>Image Classification Process Done Successfully.....</p>
</div>			

<%		
		
	}
	if(no==222)
	{
%>
		<div class="success" id="message" style="position: absolute;top:300px;left:100px;">	
			<p>Image Searching Process Done Successfully.....</p>
		</div>				
<%
	}
%>

</div>	

</body>
</html>