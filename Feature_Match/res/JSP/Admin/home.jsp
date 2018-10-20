<html>
<%
	String admin=request.getAttribute("admin").toString();
%>
<script language="JavaScript">
javascript:window.history.forward(-1);
</script>

<head>
	
	<title>Admin Home Page</title>
	
	<link href="<%=request.getContextPath() %>/res/CSS/style1.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" /> 
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/button.css" type="text/css"/>
</head>
<body>
	<img src="<%=request.getContextPath() %>/res/images/header.jpg"></img>
	

<div style="position:absolute;top:190px;left:10px;">	
	<a class="gradientbuttons" href="<%=request.getContextPath() %>/Profile"  target="afrm">&nbsp;&nbsp;&nbsp;&nbsp;Show Profile&nbsp;&nbsp;&nbsp;</a><br></br><br>
	<a class="gradientbuttons" href="<%=request.getContextPath() %>/res/JSP/Admin/users.jsp"  target="afrm">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;User List&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><br></br><br>
	<a class="gradientbuttons" href="<%=request.getContextPath() %>/ClassificationList?action=get"  target="afrm">&nbsp;&nbsp;&nbsp;Classification&nbsp;&nbsp;&nbsp;&nbsp;</a><br></br><br>
	<a class="gradientbuttons" href="<%=request.getContextPath() %>/res/JSP/Admin/upload.jsp" target="afrm">&nbsp;&nbsp;&nbsp;&nbsp;Upload File&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><br></br><br>
	<a class="gradientbuttons" href="<%=request.getContextPath() %>/res/JSP/Admin/view_file.jsp" target="afrm">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;View File&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><br></br><br>
	<a class="gradientbuttons" href="<%=request.getContextPath() %>/res/JSP/Admin/feature_extraction.jsp" target="afrm">Feature Extraction</a><br></br><br>
	<a class="gradientbuttons" href="<%=request.getContextPath() %>/?no=6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sign Out&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>		
	
	
	<div style="position:absolute;top:150px;left:160px;">
		<iframe frameborder="0" scrolling="auto" name="afrm" height="470" width="850"></iframe>
	</div>
</body>
</html>