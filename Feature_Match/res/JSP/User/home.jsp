<html>
<script language="JavaScript">
javascript:window.history.forward(-1);
</script>

<head>
	
	<title>User Home Page</title>
	
	<link href="<%=request.getContextPath() %>/res/CSS/style1.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/style.css" rel="stylesheet" type="text/css" />
	<link href="<%=request.getContextPath() %>/res/CSS/message.css" rel="stylesheet" type="text/css" /> 
	<link rel="stylesheet" href="<%=request.getContextPath() %>/res/CSS/button.css" type="text/css"/>
</head>
<body>
	<img src="<%=request.getContextPath() %>/res/images/header.jpg"></img>
	

<div style="position:absolute;top:190px;left:10px;">	
	<a class="gradientbuttons" href="<%=request.getContextPath() %>/UserProfile"  target="afrm">&nbsp;&nbsp;&nbsp;&nbsp;Show Profile&nbsp;&nbsp;&nbsp;</a><br></br><br>
	<a class="gradientbuttons" href="<%=request.getContextPath() %>/res/JSP/User/serach_img.jsp"  target="afrm">&nbsp;&nbsp;&nbsp;Search Image&nbsp;&nbsp;&nbsp;</a><br></br><br>
	<a class="gradientbuttons" href="<%=request.getContextPath() %>/?no=6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sign Out&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>		
	
	
	<div style="position:absolute;top:135px;left:160px;">
		<iframe frameborder="0" scrolling="auto" name="afrm" height="470" width="850"></iframe>
	</div>
</body>
</html>