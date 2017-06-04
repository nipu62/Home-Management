package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");


            if (session.getAttribute("name") != null) {
                response.sendRedirect("home.jsp");
                //out.println("<script>parent.location.href='home.jsp'</script>");
            }
        
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/plugin-css/homepage.css\">\n");
      out.write("        <link href=\"css/plugin-css/topbar.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        \n");
      out.write("        <title>Home Manager - Log In</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrapper\">\n");
      out.write("            <div id=\"title\">\n");
      out.write("                <div id=\"titleimagecontainer\">\n");
      out.write("                    <a href=\"login.jsp\">\n");
      out.write("                        <img id=titleimage src=\"css/images/title.png\" alt=\"Home Manager\">\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div id=\"login\">\n");
      out.write("                <div id=\"triangle\"></div>\n");
      out.write("                <form class=\"loginform\" action=\"LogInCheckJSP\" method=\"POST\">\n");
      out.write("                    <h3 class=\"paraTitle\">Log In</h3>\n");
      out.write("                    <p id=\"loginerror\">");
      out.print( request.getAttribute("error") == null ? "" : request.getAttribute("error"));
      out.write("</p>\n");
      out.write("                    <p class=\"textfield\"><input type=\"text\" class=\"loginfield\" name=\"username\" value=\"\" placeholder=\"Username\"  /><br></p>\n");
      out.write("                    <p class=\"textfield\"><input type=\"password\" class=\"loginfield\" name=\"password\" value=\"\" placeholder=\"Password\" /><br></p>\n");
      out.write("                    <p class=\"submit\"><input type=\"submit\" class=\"loginSubmit\" value=\"Sign In\" /></p>\n");
      out.write("                    <p class=\"submit\"><a href=\"createAccount.jsp\">Create new account</a></p>\n");
      out.write("                </form> \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
