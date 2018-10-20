package org.apache.jsp.res.JSP.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import com.dao.AdminDAO;
import java.util.ArrayList;

public final class view_005ffile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	ArrayList<String> list = null;
	ResultSet rs = null;
	String imageFileName = "";

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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\r\n");
      out.write("<title>Fast CBIR</title>\r\n");
      out.write("   <link rel=\"shortcut icon\" href=\"http://visuallightbox.com/favicon.ico\">\r\n");
      out.write("   \r\n");
      out.write("   <link href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("<!-- Start VisualLightBox.com HEAD section -->\r\n");
      out.write("    \r\n");
      out.write("    <link href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/vlightbox1.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    \r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/visuallightbox.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/jquery.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/ga.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/visuallightbox.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write(" <!-- End VisualLightBox.com HEAD section -->\r\n");
      out.write(" \r\n");
      out.write(" <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/res/CSS/default.css\">\r\n");
      out.write(" \r\n");
      out.write(" <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/a.js\"></script>\r\n");
      out.write(" \r\n");
      out.write(" <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/highlight.js\"></script>\r\n");
      out.write(" \r\n");
      out.write(" <script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/conversion.js\"></script>\r\n");
      out.write(" \r\n");
      out.write(" <script src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/thumbscript1.js\" type=\"text/javascript\"></script>\r\n");
      out.write(" <script src=\"");
      out.print(request.getContextPath() );
      out.write("/res/JS/vlbdata1.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("body\r\n");
      out.write("{\r\n");
      out.write("\r\n");
      out.write("\tposition:relative;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tbackground: url(\"../../images/page.jpg\") repeat scroll 0 0 #A1DEE7;\r\n");
      out.write("\tfont-family: \"KreonRegular\",sans-serif;\r\n");
      out.write("\tfont-size: 16px;\r\n");
      out.write("\tcolor: #1F4E72;\r\n");
      out.write("\ttext-shadow: 1px 2px 0 rgba(0, 107, 138, 0.1);\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");

	list = new ArrayList<String>();
    rs = AdminDAO.getImage();
    while(rs.next())
    {
    	list.add(rs.getString(2));
    }
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"content\">\t\r\n");
      out.write("<header id=\"header\">\r\n");
      out.write("\t\r\n");
      out.write("<table style=\"width: 100%; margin: 0 auto;\" cellpadding=\"0px\" cellspacing=\"0px\">\r\n");
      out.write("\r\n");
      out.write("<tbody>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t<!-- Start VisualLightBox.com BODY section id=1 -->\r\n");
      out.write("\t<div id=\"vlightbox1\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t");

		int br = 4;//4 Clumn Per Row
		for (int i = 0; i < list.size(); i++) 
		{
		    imageFileName = list.get(i);
		    
	
      out.write("\r\n");
      out.write("\t\t\t<a class=\"vlightbox1\" href=\"");
      out.print(request.getContextPath() );
      out.write("/Files/UploadedImg/");
      out.print(imageFileName);
      out.write("\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/Files/UploadedImg/");
      out.print(imageFileName);
      out.write("\" alt=\"Image Lightbox\" width=\"150\" height=\"150\">Image Lightbox\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t");
	    
		    
		    if (i % br == (br - 1))
		    {
	
      out.write("\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t");
		    
			}
		}
	
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("</tbody>\r\n");
      out.write("</table>\t\t\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<div class=\"separator\"></div>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
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
