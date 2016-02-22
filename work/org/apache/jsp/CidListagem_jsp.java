package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CidListagem_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


	response.setHeader("Cache-Control", "no-cache");

      out.write("\r\n");
      out.write("<div id=\"DivFormulario\">\r\n");
      out.write("\t<div id=\"DivBuscar\">\r\n");
      out.write("\t\tBuscar: <input name=\"dsBusca\" type=\"text\" class=\"InputTexto\" id=\"dsBusca\" maxlength=\"30\" onKeyUp=\"ChamarPesquisaListagemPeloCampo(this)\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<a href=\"javascript://\" onclick=\"CadastrarNovo();\"><img src=\"imagens/BotaoCadastrarNovo.gif\" width=\"99\" height=\"14\" vspace=\"5\" border=\"0\" /></a>\r\n");
      out.write("\t<div id=\"DivMensagemCadastro\" style=\"display:none;\" align=\"center\"></div>\r\n");
      out.write("\t<div id=\"DivPesquisaListagem\"></div>\r\n");
      out.write("</div>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
