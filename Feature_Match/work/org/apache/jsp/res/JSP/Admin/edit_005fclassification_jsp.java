package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import com.util.Utility;

public final class edit_005fclassification_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	ResultSet rs = null;
	int classificationId=0;
	String classificationName="",remarks="";

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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>Update Classification</title>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/style1.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" /> \r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/form.css\" type=\"text/css\"/>\r\n");
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
      out.write("\r\n");
      out.write("\r\n");

	rs = (ResultSet)request.getAttribute("rs");
    if(rs!=null);
	while(rs.next())
	{
		classificationId = rs.getInt(1);
		classificationName = rs.getString(2);
		remarks = rs.getString(3);
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<div class=\"container\" id=\"label\" style=\"position:absolute;top:10px;left:250px;width: 350px;height:425px;\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"TabMenu\" style=\"position: relative;left:25px;\">\r\n");
      out.write("\t<h2>Upadte Classification Details<h2>\r\n");
      out.write("</div>\t\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("<hr size=\"10\" color=\"#351616\"></hr>\r\n");
      out.write("\r\n");
      out.write("<div class=\"ContentFrame\">\r\n");
      out.write("\t<div class=\"AllTabs\">\r\n");
      out.write("\t\t<div class=\"TabContent\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t <table align=\"center\" id=\"login\">\r\n");
      out.write("\t\t   <form action=\"");
      out.print(request.getContextPath());
      out.write("/ClassificationList\">\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr height=\"20px\"></tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t\t  \t\t\t\t<td id=\"label\">\r\n");
      out.write("\t\t  \t\t\t\t\t\tName : \r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<td width=\"10px\"></td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<td>\r\n");
      out.write("\t\t  \t\t\t\t\t\t<input type=\"text\" class=\"field\" name=\"name\" value=\"");
      out.print(classificationName);
      out.write("\" required=\"required\" autofocus=\"autofocus\" title=\"Enter The Classification Name.\"/>\r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t\t  \t\t\t\t<td id=\"label\">\r\n");
      out.write("\t\t  \t\t\t\t\t\tRemarks : \r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<td width=\"10px\"></td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<td>\r\n");
      out.write("\t\t  \t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"remarks\"  value=\"");
      out.print(remarks);
      out.write("\"/>\r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr height=\"30px\"></tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t\t  \t\t\t\t<td id=\"label\" colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t  \t\t\t\t\t <input class=\"button\" type=\"submit\" name=\"action\" value=\"Update Classification\"/>\r\n");
      out.write("\t\t  \t\t\t\t\t <input type=\"hidden\" name=\"id\" value=\"");
      out.print(classificationId);
      out.write("\">\r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t</form>\t\r\n");
      out.write("\t\t </table>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
	
	int no=Utility.parse(request.getParameter("no"));
	if(no==1)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:60px;left:270px\">\t\r\n");
      out.write("\t\t\t<p>Classification Details Added Successfully...</p>\r\n");
      out.write("\t\t</div>\t\t\t\t\r\n");

	}
	if(no==2)
	{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:60px;left:270px\">\t\r\n");
      out.write("\t\t\t\t<p>Sorry,The Classification Already Exists!!!!!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");

	}
	if(no==3)
	{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:60px;left:270px\">\t\r\n");
      out.write("\t\t\t\t<p>Opp's,Something Went Wrong!!!!!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");

	}

      out.write("\r\n");
      out.write("   \r\n");
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
