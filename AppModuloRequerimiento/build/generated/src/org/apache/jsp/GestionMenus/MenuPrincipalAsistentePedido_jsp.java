package org.apache.jsp.GestionMenus;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MenuPrincipalAsistentePedido_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Pagina Inicio</title>\n");
      out.write("        <script>\n");
      out.write("           function ingresarCotizacion()\n");
      out.write("           {\n");
      out.write("               document.form.action=\"");
      out.print(request.getContextPath());
      out.write("/RequerimientoServlet\";\n");
      out.write("               document.form.method=\"POST\";\n");
      out.write("               document.form.op.value=1;\n");
      out.write("               document.form.submit();\n");
      out.write("           }\n");
      out.write("       </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form name=\"form\">\n");
      out.write("            <input type=\"hidden\" name=\"op\">\n");
      out.write("            <center>\n");
      out.write("                <table cellpadding=\"5\">\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Seleccione Operación</td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <center>\n");
      out.write("                                <button type=\"button\" onclick=\"ingresarCotizacion()\">\n");
      out.write("                                    Cotización\n");
      out.write("                                </button>\n");
      out.write("                            </center>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <center>\n");
      out.write("                                <button type=\"button\">\n");
      out.write("                                    Requerimiento\n");
      out.write("                                </button>\n");
      out.write("                            </center>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            </center>\n");
      out.write("        </form>\n");
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
