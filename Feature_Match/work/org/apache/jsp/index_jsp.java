package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.Utility;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Medical Image Classification</title>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/style1.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" /> \r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/login.css\" type=\"text/css\"/>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/style.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery-1.6.4.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function()\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\t$(\".container .TabMenu span:first\").addClass(\"selector\");\r\n");
      out.write("\t\t\t\t$(\".container .TabMenu span\").mouseover(function()\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t$(this).addClass(\"hovering\");\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\".container .TabMenu span\").mouseout(function()\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t$(this).removeClass(\"hovering\");\r\n");
      out.write("\t\t\t\t\t});\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\".container .TabMenu span\").click(function()\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t$(\".selector\").removeClass(\"selector\");\r\n");
      out.write("\t\t\t\t\t\t$(this).addClass(\"selector\");\r\n");
      out.write("\t\t\t\t\t\tvar TabWidth = $(\".TabContent:first\").width();\r\n");
      out.write("\t\t\t\t\t\tif(parseInt($(\".TabContent:first\").css(\"margin-left\")) > 0)\r\n");
      out.write("\t\t\t\t\t\t\tTabWidth += parseInt($(\".TabContent:first\").css(\"margin-left\"));\r\n");
      out.write("\t\t\t\t\t\tif(parseInt($(\".TabContent:first\").css(\"margin-right\")) >0)\r\n");
      out.write("\t\t\t\t\t\t\tTabWidth += parseInt($(\".TabContent:first\").css(\"margin-right\"));\r\n");
      out.write("\t\t\t\t\t\tvar newLeft = -1* $(\"span\").index(this) * TabWidth;\r\n");
      out.write("\t\t\t\t\t\t$(\".AllTabs\").animate({\r\n");
      out.write("\t\t\t\t\t\t\tleft: + newLeft + \"px\"},1000);\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<img src=\"");
      out.print(request.getContextPath() );
      out.write("/res/images/header.jpg\"></img>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\" id=\"label\">\r\n");
	
		int no=Utility.parse(request.getParameter("no"));
		if(no==1)
		{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>Opp's,Invalid userid / password..!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");

		}
		if(no==3)
		{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>Opp's,Something Went Wrong!!!!!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");

		}
		if(no==4)
		{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>You Have Registered Successfully!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");

		}
		if(no==5)
		{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>Opp's,User Already Exists!!!!!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");

		}
		if(no==6)
		{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position: relative;width:230px;\">\t\r\n");
      out.write("\t\t\t\t<p>You Have Logged Out Successfully!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");

		}

      out.write("\r\n");
      out.write("    \r\n");
      out.write("\t<div class=\"TabMenu\">\r\n");
      out.write("\t    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\t\t\t\r\n");
      out.write("\t\t<span>\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/res/images/admin.png\" height=\"50\" width=\"50\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<br>&nbsp;&nbsp;Admin\r\n");
      out.write("\t\t</span>\r\n");
      out.write("\t\t<span>\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/res/images/user.png\" height=\"50\" width=\"50\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<br>&nbsp;&nbsp;Users\r\n");
      out.write("\t\t</span>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<hr size=\"10\" color=\"#351616\"></hr>\r\n");
      out.write("\t<div class=\"ContentFrame\">\r\n");
      out.write("\t\t<div class=\"AllTabs\">\r\n");
      out.write("\t\t\t<div class=\"TabContent\">\r\n");
      out.write("\t\t\t\t<p><h2>Admin Login</h2>\r\n");
      out.write("\t\t\t\t\t<form method=\"post\" id=\"login\" action=\"");
      out.print(request.getContextPath() );
      out.write("/AdminLogin\">\r\n");
      out.write("\t\t\t\t\t\tName&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class=\"field\" name=\"name\" type=\"text\" required=\"required\"/><br>\r\n");
      out.write("\t\t\t\t\t\tPassword<input class=\"field\" name=\"pass\" type=\"password\" required=\"required\"/><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"button\" type=\"submit\"/>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"TabContent\">\r\n");
      out.write("\t\t\t\t<p><h2>User Login</h2>\r\n");
      out.write("\t\t\t\t\t<form method=\"post\" id=\"login\" action=\"");
      out.print(request.getContextPath());
      out.write("/UserLogin\">\r\n");
      out.write("\t\t\t\t\t\tName&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class=\"field\" name=\"name\" type=\"text\" required=\"yes\"/><br>\r\n");
      out.write("\t\t\t\t\t\tPassword<input class=\"field\" name=\"pass\" type=\"password\" required=\"yes\"/><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"button\" type=\"submit\"/>\r\n");
      out.write("\t\t\t\t\t\t<pre>No Account ? <a href=\"");
      out.print(request.getContextPath());
      out.write("?no=2\">Sign up here</a></pre>\t\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");

	if(no==2)
	{
      out.write("\r\n");
      out.write("\t\t<div style=\"position:absolute;top:125px;left:50\" class=\"c\">\t\r\n");
      out.write("\t\t");

			if(Utility.parse(request.getParameter("no1"))==5)
			{
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute\">\t\r\n");
      out.write("\t\t\t\t\t<p>Sorry this user id is already exists.....!</p>\r\n");
      out.write("\t\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t");
}
		
      out.write("\r\n");
      out.write("\t\t\t<table id=\"login\">\r\n");
      out.write("\t\t\t<h1 align=\"center\" id=\"label\">User Registeration</h1>\r\n");
      out.write("\t\t\t<hr size=\"10\" color=\"#351616\"></hr>\r\n");
      out.write("\t\t\t<form  action=\"");
      out.print(request.getContextPath() );
      out.write("/UserList\">\r\n");
      out.write("\t\t\t\t<tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>Username</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"field\" name=\"username\" type=\"text\" required=\"yes\" title=\"Enter Your Username.\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>Password</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"field\" name=\"password\" type=\"text\" required=\"yes\" title=\"Enter Your Password.\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t    <tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>Name</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"field\" name=\"name\" type=\"text\" required=\"yes\" title=\"Enter Your Name\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>Gender</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"sex\" type=\"radio\" checked=\"checked\" value=\"Male\"/> Male\r\n");
      out.write("\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"sex\" type=\"radio\" value=\"Female\"/> Female\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>DOB</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"field\" name=\"dob\" type=\"text\" placeholder=\"DD/MM/YYYY\" required=\"yes\" title=\"Enter Your DOB.\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>Cell</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"field\" name=\"cell\" type=\"text\" required=\"required\" title=\"Please,Enter Valid Mobile Number.\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>Phone</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"field\" name=\"phone\" type=\"text\"   title=\"Please,Enter Valid Phone Number.\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<td>Email</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t<input class=\"field\" name=\"email\" type=\"text\" required=\"yes\" title=\"Enter Your Valid Email.\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr id=\"label\">\r\n");
      out.write("\t\t\t\t\t<td>Address</td>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input class=\"field\" name=\"address\" type=\"text\" title=\"Please,Enter The Address.\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t<input class=\"button\" type=\"submit\" value=\"Register\"/>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"action\" value=\"Add\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t   </div>\t\t\t\r\n");
      out.write("\t");

	}
	else
	{
		

	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
