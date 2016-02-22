package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Cid;
import servlets.CidServlet;

public final class CidFormulario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");

String strCD_Cid = request.getParameter("CD_Cid");
int CD_Cid;
Cid cid;
if(strCD_Cid == null)
{
	cid = new Cid();
	cid.setCdCid(0);
	cid.setDsCid("");
	cid.setIdStatusCid("");
}
else
{
	CD_Cid  = Integer.parseInt(strCD_Cid);
	//cid =
	cid.setCdCid(0);
	cid.setDsCid("");
	cid.setIdStatusCid("");
}

      out.write("\r\n");
      out.write("<form id=\"cadastro\" name=\"cadastro\">\r\n");
      out.write("\t<div id=\"DivFormulario\">\r\n");
      out.write("\t\t<h2>Cid</h2>\r\n");
      out.write("\t\t<table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"1\">\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t\t<td class=\"LabelFormulario\">*Descri&ccedil;&atilde;o:</td>\r\n");
      out.write("\t\t\t<td><input name=\"dsCid\" type=\"text\" class=\"InputTexto\" id=\"dsCid\" maxlength=\"120\" /></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t\t<td class=\"LabelFormulario\">*Estado:</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<select id=\"idStatus\" class=\"InputSelect\">\r\n");
      out.write("\t\t\t\t<option value=\"\"></option>\r\n");
      out.write("\t\t\t\t<option value=\"A\">Ativo</option>\r\n");
      out.write("\t\t\t\t<option value=\"I\">Inativo</option>\r\n");
      out.write("\t\t\t</select>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t\t<td></td>\r\n");
      out.write("\t\t\t<td></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("            <td>&nbsp;</td>\r\n");
      out.write("\t\t    <td id=\"DivFormularioAlerta\">&nbsp;</td>\r\n");
      out.write("\t      </tr>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t<td><a href=\"javascript://\" onclick=\"FormularioSalvar()\"><img src=\"imagens/BotaoSalvar.gif\" width=\"54\" height=\"14\" hspace=\"5\" border=\"0\" /></a><a href=\"javascript://\" onclick=\"FormularioLimpar()\"><img src=\"imagens/BotaoLimpar.gif\" width=\"57\" height=\"14\" hspace=\"15\" border=\"0\" /></a><a href=\"javascript://\" onclick=\"FormularioCancelar()\"><img src=\"imagens/BotaoCancelar.gif\" width=\"69\" height=\"14\" hspace=\"5\" border=\"0\" /></a></td>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<p>&nbsp;</p>\r\n");
      out.write("\t</div>\r\n");
      out.write("</form>\r\n");
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
