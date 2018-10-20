<%@page import="com.util.Utility"%>
<%@page import="com.dao.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.AdminDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Fast CBIR</title>
   <link rel="shortcut icon" href="http://visuallightbox.com/favicon.ico">
   
   <link href="<%=request.getContextPath()%>/res/CSS/style.css" rel="stylesheet" type="text/css">
   
   <script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/pagination1.js"></script>
   

<!-- Start VisualLightBox.com HEAD section -->
    
    <link href="<%=request.getContextPath()%>/res/CSS/vlightbox1.css" rel="stylesheet" type="text/css">
    
	<link href="<%=request.getContextPath()%>/res/CSS/visuallightbox.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/jquery.min.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/ga.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/visuallightbox.js"></script>
	

 <!-- End VisualLightBox.com HEAD section -->
 
 <link rel="stylesheet" href="<%=request.getContextPath()%>/res/CSS/default.css">
 
 <script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/a.js"></script>
 
 <script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/highlight.js"></script>
 
 <script type="text/javascript" src="<%=request.getContextPath() %>/res/JS/conversion.js"></script>
 
 <script src="<%=request.getContextPath() %>/res/JS/thumbscript1.js" type="text/javascript"></script>
 <script src="<%=request.getContextPath() %>/res/JS/vlbdata1.js" type="text/javascript"></script>

<style type="text/css">

body
{

	position:relative;
	margin: 0;
	background: url("res/images/page.jpg") repeat scroll 0 0 #A1DEE7; 
/*	background: url("../../images/page.jpg") repeat scroll 0 0 #A1DEE7; */
	font-family: "KreonRegular",sans-serif;
	font-size: 16px;
	color: #1F4E72;
	text-shadow: 1px 2px 0 rgba(0, 107, 138, 0.1);
	text-align:center;
	
}

</style>

</head>
<body>
<%!
	ArrayList<String> list = null;
	ResultSet rs = null;
	String imageFileName = "",threshhold4Feature3="";
	int noOfRecords = 0; 
	
%>

<%
	
	//threshhold4Feature3 = Utility.getPro("Feature3_Threshold");
	//noOfRecords = Utility.parse(threshhold4Feature3);
	
	list = new ArrayList<String>();
	
    //rs = UserDAO.getImageByDistAsc();
    
    //rs = AdminDAO.getTopNimg4Feature3Comparision(noOfRecords);
    
    //rs = AdminDAO.getTopNimg4Feature2Comparision(noOfRecords);
    
    //
   	 rs = AdminDAO.getClassifiedImageResult();
    //
    
    while(rs.next())
    {
    	list.add(rs.getString(2));
    }
	
%>

<div id="content">	
<header id="header">
	
<table id="results" style="width: 100%; margin: 0 auto;" cellpadding="0px" cellspacing="0px">

<tbody>
<tr>
	<td>
	<!-- Start VisualLightBox.com BODY section id=1 -->
	<div id="vlightbox1">
			
	<%
		int rows = 1;
		int br = 4;//4 Clumn Per Row
		for (int i = 0; i < list.size(); i++) 
		{
		    imageFileName = list.get(i);
		    
	%>
			<a class="vlightbox1" href="<%=request.getContextPath() %>/Files/UploadedImg/<%=imageFileName%>">
				<img src="<%=request.getContextPath() %>/Files/UploadedImg/<%=imageFileName%>" alt="Image Lightbox" width="150" height="150">Image Lightbox
			</a>
	<%	    
		    
		    if (i % br == (br - 1))
		    {
		    	rows++;
	%>
				<br>
	<%		    
			}
	
		}
		//System.out.println("Rows : " + rows);
	%>
		</td>
			
	</tr>
	
</tbody>
</table>		
<br>

<%-- 
<div id="pageNavPosition" style="cursor:hand"></div>
<script type="text/javascript">
		var pager = new Pager('<%=rows%>',1); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
</script>
--%>	
<div class="separator"></div>
</header>

</div>

</body>
</html>