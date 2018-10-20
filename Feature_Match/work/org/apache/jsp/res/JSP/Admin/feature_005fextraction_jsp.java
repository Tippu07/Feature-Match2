package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.Utility;
import java.sql.*;

public final class feature_005fextraction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	long start = 0,end = 0,processTime=0;

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
      out.write("\t<title>Feature Extraction</title>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/res/CSS/button.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/style.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery-1.6.4.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function() \r\n");
      out.write("\t{\r\n");
      out.write("\r\n");
      out.write("\t\t $('#disableButton').attr('disabled', true);\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no"))==1)
	{
		start = (Long)request.getAttribute("start_time");
		end = System.nanoTime();
		// 1s = 1000000 microseconds
		//long processTime = (end - start);//in nanoseocond
		//processTime = (end - start) / 1000;//in microseconds
		
		processTime = ((end - start) / 1000)/1000;//in Milliseconds
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("<br>\r\n");
      out.write("\t\t\r\n");
      out.write("<table align=\"center\">\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<a class=\"gradientbuttons\" href=\"");
      out.print(request.getContextPath() );
      out.write("/ResetFeature\" target=\"afrm\">Reset Feature</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t<tr height=\"30px\"></tr>\r\n");
      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t\t<td >\r\n");
      out.write("\t\t\t\t\t<a class=\"gradientbuttons\" href=\"");
      out.print(request.getContextPath() );
      out.write("/ExtractFeature\" target=\"afrm\">Extract Feature1</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write(" \t\t\t\r\n");
      out.write("\t\t\t<td width=\"10px\"></td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<a class=\"gradientbuttons\" href=\"");
      out.print(request.getContextPath() );
      out.write("/ExtractFeature1\" target=\"afrm\">Extract Feature2</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");

		if(Utility.parse(request.getParameter("no"))==1)
		{

      out.write("\r\n");
      out.write("\t\t\t<tr height=\"50px\"></tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<font color=\"white\" size=\"4\">Feature Extraction Processing Time : </font>\r\n");
      out.write("\t\t\t\t\t\t\t<font color=\"black\" size=\"4\">");
      out.print(processTime);
      out.write(" Milliseconds</font>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position: absolute;left:190px;top:150px;width:400px;\">\t\r\n");
      out.write("\t\t\t\t<p>Feature Extracted Successfully.....</p>\r\n");
      out.write("\t\t\t</div>\r\n");

		}
		if(Utility.parse(request.getParameter("no"))==2)
		{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position: absolute;left:190px;top:150px;width:400px;\">\t\r\n");
      out.write("\t\t\t\t<p>Opps,Something Went Wrong!!!!!</p>\r\n");
      out.write("\t\t\t</div>\r\n");

		}
		if(Utility.parse(request.getParameter("no"))==3)
		{

      out.write("\r\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position: absolute;left:190px;top:150px;width:400px;\">\t\r\n");
      out.write("\t\t\t\t<p>Feature Reseted Successfully.....</p>\r\n");
      out.write("\t\t\t</div>\r\n");

		}

      out.write("\r\n");
      out.write("</table>\r\n");
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
