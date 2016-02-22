package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("<title>PESP - Prontu&aacute;rio Eletr&ocirc;nico em Sa&uacute;de P&uacute;blica</title>\r\n");
      out.write("<script language=\"javascript\" src=\"js/Auxiliares.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"js/Menu.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"js/AbrirPaginasManutencao.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"js/Ajax.js\"></script>\r\n");
      out.write("<script language=\"javascript\" src=\"js/ControleDeFormularios.js\"></script>\r\n");
      out.write("<link href=\"css/Estilos.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div align=\"center\" id=\"DivCenter\">\r\n");
      out.write("\t<div id=\"DivGeral\"  align=\"center\">\r\n");
      out.write("\t\t<div id=\"DivCabecalho\" align=\"left\">\r\n");
      out.write("\t\t  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t  <td width=\"308\"><img src=\"imagens/PESPLogo.gif\" width=\"308\" height=\"57\" /></td>\r\n");
      out.write("\t\t\t  <td width=\"100%\">&nbsp;</td>\r\n");
      out.write("\t\t\t  <td nowrap=\"nowrap\"><span class=\"LabelForm\">Usu&aacute;rio:</span> Daniel Pereira Camargo<br />\r\n");
      out.write("\t\t\t\t<a href=\"javascript://\" class=\"BotaoLogout\">[Logout]</a></td>\r\n");
      out.write("\t\t\t  <td width=\"4\"><img src=\"imagens/IconeOutros.gif\" width=\"74\" height=\"57\" /></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t  </table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"DivCorpo\" align=\"left\">\r\n");
      out.write("\t\t\t<div id=\"Atendimento\" style=\"display:none;\"></div>\r\n");
      out.write("\t\t\t<div id=\"DivCorpoTopo\"><img src=\"imagens/CorpoTopo.gif\" /></div>\r\n");
      out.write("\t\t\t<div id=\"DivCorpoConteudo\">\r\n");
      out.write("\t\t\t\t<div id=\"DivCorpoIcones\">\r\n");
      out.write("\t\t\t\t\t<div style=\"float:left;\">\r\n");
      out.write("\t\t\t\t\t\t<img class=\"Icone\" src=\"imagens/IconeProfissional.gif\" alt=\"Profissional\" onclick=\"AbrirPaginaManutencao(this);\" onmouseover=\"IndicaIcone(this);\" id=\"Profissional\"/>\r\n");
      out.write("\t\t\t\t\t\t<img class=\"Icone\" src=\"imagens/IconePaciente.gif\" alt=\"Paciente\" onclick=\"AbrirPaginaManutencao(this);\" onmouseover=\"IndicaIcone(this);\" id=\"Paciente\"/>\r\n");
      out.write("\t\t\t\t\t\t<img class=\"Icone\" src=\"imagens/IconeCid.gif\" alt=\"Cid\" onclick=\"AbrirPaginaManutencao(this);\" onmouseover=\"IndicaIcone(this);\" id=\"Cid\"/>\r\n");
      out.write("\t\t\t\t\t\t<img class=\"Icone\" src=\"imagens/IconeProcedimento.gif\" alt=\"Procedimento\" onclick=\"AbrirPaginaManutencao(this);\" onmouseover=\"IndicaIcone(this);\" id=\"Procedimento\"/>\r\n");
      out.write("\t\t\t\t\t\t<img class=\"Icone\" src=\"imagens/IconeEstabelecimento.gif\" alt=\"Estabelecimento\" onclick=\"AbrirPaginaManutencao(this);\" onmouseover=\"IndicaIcone(this);\" id=\"Estabelecimento\"/>\r\n");
      out.write("\t\t\t\t\t\t<img class=\"Icone\" src=\"imagens/IconeProfissao.gif\" alt=\"Profiss&atilde;o\" onclick=\"AbrirPaginaManutencao(this);\" onmouseover=\"IndicaIcone(this);\" id=\"Profissao\"/>\r\n");
      out.write("\t\t\t\t\t\t<img class=\"Icone\" src=\"imagens/IconeDomicilio.gif\" alt=\"Domic&iacute;lio\" onclick=\"AbrirPaginaManutencao(this);\" onmouseover=\"IndicaIcone(this);\" id=\"Domicilio\"/>\r\n");
      out.write("\t\t\t\t\t\t<img class=\"Icone\" src=\"imagens/IconeFila.gif\" alt=\"Fila\" onclick=\"AbrirPaginaManutencao(this);\" onmouseover=\"IndicaIcone(this);\" id=\"Fila\"/>\r\n");
      out.write("\t\t\t\t\t\t<img src=\"imagens/MenuSeparador.gif\" />\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"DivCorpoMenuDescricao\"> </div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<img src=\"imagens/MenuSeparador_1.gif\" />\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"DivCorpoLateralEsquerda\" style=\"display:none\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"DivCorpoLateralDireita\" style=\"display:none\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"DivFilaCabecalho\" style=\"display:none\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"DivFilaConteudo\" style=\"display:none\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
