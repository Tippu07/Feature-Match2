package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dao.AdminDAO;
import java.sql.ResultSet;
import com.util.Utility;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
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
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<div class=\"container\" id=\"label\" style=\"position:absolute;top:1px;left:250px;width: 350px;height:450px;\">\r\n");
      out.write("\r\n");
	
	int no=Utility.parse(request.getParameter("no"));
	if(no==1)
	{

      out.write("\r\n");
      out.write("\t\t<div class=\"success\" id=\"message\">\t\r\n");
      out.write("\t\t\t<p>Image Uploaded Successfully.....</p>\r\n");
      out.write("\t\t</div>\t\t\t\t\r\n");

	}
	if(no==2)
	{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>Opp's,Something Went Wrong!!!!!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");

	}
	if(no==3)
	{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\">\t\r\n");
      out.write("\t\t\t\t<p>Opp's,Something Went Wrong!!!!!</p>\r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");

	}

      out.write("\r\n");
      out.write("   \r\n");
      out.write("<div class=\"TabMenu\" style=\"position: relative;left:75px;\">\r\n");
      out.write("    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\t\t\t\r\n");
      out.write("\t<span>\r\n");
      out.write("\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/res/images/upload.png\" height=\"50\" width=\"50\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<br>&nbsp;&nbsp;Single\r\n");
      out.write("\t</span>\r\n");
      out.write(" \t\r\n");
      out.write("\t<span>\r\n");
      out.write("\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/res/images/uploas_multiple.png\" height=\"50\" width=\"50\" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t<br>&nbsp;&nbsp;Multiple\r\n");
      out.write("\t</span>\r\n");
      out.write("\t\r\n");
      out.write("\t<h2>Upload Files Details<h2>\r\n");
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
      out.write("/UploadFileAction\" enctype=\"multipart/form-data\" method=\"post\">\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t  \t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t  \t\t\t\t\t<p><h2>Single File Upload</h2>\r\n");
      out.write("\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t\t  \t\t\t\t<td id=\"label\">\r\n");
      out.write("\t\t  \t\t\t\t\t\tBrowse File : \r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<td width=\"10px\"></td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<td>\r\n");
      out.write("\t\t  \t\t\t\t\t\t<input class=\"field\" name=\"myfile\" type=\"file\" required=\"yes\"/>\r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t\t  \t\t\t\t<td id=\"label\">\r\n");
      out.write("\t\t  \t\t\t\t\t\tClassification : \r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<td width=\"10px\"></td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<td>\r\n");
      out.write("\t\t  \t\t\t\t\t\t<select name=\"classification\" style=\"width: 190px;border:5px solid #351616;font-size:12px;line-height:1.5em;padding:4px; \">\r\n");
      out.write("\t\t  \t\t\t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t\t\t");

		  							ResultSet rs = AdminDAO.getClassifications();
		  							while(rs.next())
		  							{
		  						
      out.write("\r\n");
      out.write("\t\t  \t\t\t\t\t\t\t\t<option value=\"");
      out.print(rs.getInt(1));
      out.write('"');
      out.write('>');
      out.print(rs.getString(2));
      out.write("</option>\r\n");
      out.write("\t\t  \t\t\t\t\t\t");

		  							}
		  						
      out.write("\r\n");
      out.write("\t\t  \t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t\t\t</select>\r\n");
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
      out.write("\t\t  \t\t\t\t\t\t<input class=\"field\" name=\"remarks\" type=\"text\" />\r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr height=\"10px\"></tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t\t  \t\t\t\t<td id=\"label\" colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t  \t\t\t\t\t <input class=\"button\" type=\"submit\" value=\"Upload File\"/>\r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t</form>\t\r\n");
      out.write("\t\t </table>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<div class=\"TabContent\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t <table align=\"center\" id=\"login\">\r\n");
      out.write("\t\t   <form method=\"post\" action=\"");
      out.print(request.getContextPath() );
      out.write("/AdminLogin\">\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t  \t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t  \t\t\t\t\t<p><h2>Multiple File Upload</h2>\r\n");
      out.write("\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t\t  \t\t\t\t<td id=\"label\">\r\n");
      out.write("\t\t  \t\t\t\t\t\tBrowse File : \r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<td width=\"10px\"></td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t\t<td>\r\n");
      out.write("\t\t  \t\t\t\t\t\t<input class=\"field\" name=\"myfile\" type=\"file\" required=\"yes\"/>\r\n");
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
      out.write("\t\t  \t\t\t\t\t\t<input class=\"field\" name=\"remarks\" type=\"text\" />\r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr height=\"10px\"></tr>\r\n");
      out.write("\t\t  \t\t\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t\t  \t\t\t\t<td id=\"label\" colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t  \t\t\t\t\t <input class=\"button\" type=\"submit\" value=\"Upload File\"/>\r\n");
      out.write("\t\t  \t\t\t\t</td>\r\n");
      out.write("\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t</tr>\r\n");
      out.write("\t\t  \t</form>\t\r\n");
      out.write("\t\t </table>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
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
