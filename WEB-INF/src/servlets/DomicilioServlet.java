package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Domicilio;
import modelo.Estabelecimento;
import dao.DaoQuery;
import dao.DaoUpdate;

 public class DomicilioServlet extends HttpServlet implements Servlet {
	 private static final long serialVersionUID = 1L;
	 public void service(HttpServletRequest req,
			             HttpServletResponse resp
				         ) throws IOException, ServletException	{
		Domicilio domicilio;
		String dsAcao = req.getParameter("dsAcao");
		if("cadastrar".trim().equals(dsAcao))
		{
			 try
			 {
				 DaoUpdate daoUpdate = new DaoUpdate();
				 DaoQuery daoQuery = new DaoQuery();
				 domicilio = new Domicilio();
				 Estabelecimento estabelecimento = daoQuery.estabelecimentoById(Integer.parseInt(req.getParameter("cdEstabelecimento")));
				 domicilio.setCdDomicilio(Integer.parseInt(req.getParameter("cdDomicilio")));
				 domicilio.setEstabelecimento(estabelecimento);
				 domicilio.setDsLogradouro(req.getParameter("dsLogradouro"));
				 domicilio.setDsBairro(req.getParameter("dsBairro"));
				 domicilio.setDsMunicipio(req.getParameter("dsMunicipio"));
				 domicilio.setDsEstado(req.getParameter("dsEstado"));
				 domicilio.setDsTelefone(req.getParameter("dsTelefone"));
				 domicilio.setIdStatus(req.getParameter("idStatus"));
				 daoUpdate.domicilioSalva(domicilio);
				 if(domicilio.getCdDomicilio()>0)
					 this.writeResponse(resp, "atualizado");
				 else
					 this.writeResponse(resp, "cadastrado");
				 domicilio = null;
			 }
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			     domicilio = null;
			 }
		}
		if("pesquisar".trim().equals(dsAcao))
		{
			 try{
				 String dsBusca = req.getParameter("dsBusca");
				 StringBuffer tabelaResultado = new StringBuffer();
				 tabelaResultado.append("<table id='TabelaListagem' border='0' cellspacing='0' cellpadding='0'>");
				 ArrayList domiciliosPesquisa = new ArrayList();
				 DaoQuery daoQuery = new DaoQuery();
				 domiciliosPesquisa = daoQuery.domicilioByDsDomicilio(dsBusca);
				 String classeCss = "";
				 String classeCssExcluido = "";
				 tabelaResultado.append("<tr>");
					tabelaResultado.append("<td width='15' class='LabelListagem'>#</td>");
				 	tabelaResultado.append("<td class='LabelListagem'>Nome</td>");
				 	tabelaResultado.append("<td class='LabelListagem'> </td>");
				 	tabelaResultado.append("<td class='LabelListagem'> </td>");
				tabelaResultado.append("</tr>");
				 for(int i=0; i<domiciliosPesquisa.size(); i++)
				 {
					 if("linhaEscura".trim().equals(classeCss))
						 classeCss = "LinhaClara";
					 else
						 classeCss = "linhaEscura";
					 domicilio = (Domicilio) domiciliosPesquisa.get(i);
					 if("I".equals(domicilio.getIdStatus()))
						 classeCssExcluido = "Excluido";
					 else
						 classeCssExcluido = "";
					tabelaResultado.append("<tr>");
						tabelaResultado.append("<td width='15' class='"+classeCss+classeCssExcluido+"'>" + (i+1) + "</td>");
					 	tabelaResultado.append("<td width='100%' class='"+classeCss+classeCssExcluido+"'>" + domicilio.getDsLogradouro() + "</td>");
					 	tabelaResultado.append("<td class='"+classeCss+"'><a href='javascript://' onclick='Editar("+domicilio.getCdDomicilio()+")'><img src='imagens/BotaoEditar.gif' border='0'></a></td>");
					 	tabelaResultado.append("<td class='"+classeCss+"'><a href='javascript://' onclick='Excluir("+domicilio.getCdDomicilio()+")'><img src='imagens/BotaoExcluir.gif' border='0'></a></td>");
					tabelaResultado.append("</tr>");
				 }
				 tabelaResultado.append("</table>");
				 this.writeResponse(resp, tabelaResultado.toString());
				 domicilio = null;
			 } catch (Exception e) {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			}
		}
		if("formulario".trim().equals(dsAcao))
		{
			 try
			 {
				 int idDomicilio = Integer.parseInt(req.getParameter("idDomicilio"));
				 if(idDomicilio>0)
					 domicilio = getDomicilioByCod(idDomicilio);			 
				 else
				 {
					 domicilio = new Domicilio();
					 domicilio.setEstabelecimento(new Estabelecimento());
				 }
				 StringBuffer formulario = new StringBuffer();
				 formulario.append("<form id='cadastro' name='cadastro'>");
				 formulario.append("<div id='DivFormulario'>");
				 formulario.append("<h2>Domic&iacute;lio</h2>");
				 formulario.append("<table width='100%' border='0' cellspacing='1' cellpadding='1'>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Estab.:</td>");
				 formulario.append("<td>");
				 StringBuffer inputSelect = new StringBuffer();
				 Estabelecimento estabelecimento;
				 inputSelect.append("<select name='cdEstabelecimento' class='InputSelect' id='cdEstabelecimento'>");
				 ArrayList estabelecimentosPesquisa = new ArrayList();
				 DaoQuery daoQuery = new DaoQuery();
				 estabelecimentosPesquisa = daoQuery.estabelecimentoByDsEstabelecimento("|s|");
				 inputSelect.append("<option value=''></option>");
				 String selected;
				 for(int i=0; i<estabelecimentosPesquisa.size(); i++)
				 {
					 estabelecimento = (Estabelecimento) estabelecimentosPesquisa.get(i);
					 if(estabelecimento.getCdEstabelecimento()==domicilio.getEstabelecimento().getCdEstabelecimento())
						 selected = "selected";
					 else
						 selected = "";
					 inputSelect.append("<option value='" + estabelecimento.getCdEstabelecimento() + "' " + selected + ">" + estabelecimento.getDsEstabelecimento() + "</option>");
				 }
				 inputSelect.append("</select>");
				 estabelecimento = null;
				 formulario.append(inputSelect.toString());
				 formulario.append("</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Logradouro:</td>");
				 formulario.append("<td><input name='dsLogradouro' type='text' class='InputTexto' id='dsLogradouro' value='" + domicilio.getDsLogradouro() + "' maxlength='80' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Bairro:</td>");
				 formulario.append("<td><input name='dsBairro' type='text' class='InputTexto' id='dsBairro' value='" + domicilio.getDsBairro() + "' maxlength='60' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Munic&iacute;pio:</td>");
				 formulario.append("<td><input name='dsMunicipio' type='text' class='InputTexto' id='dsMunicipio' value='" + domicilio.getDsMunicipio() + "' maxlength='60' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*UF:</td>");
				 formulario.append("<td><input name='dsEstado' type='text' class='InputTexto' id='dsEstado' maxlength='2' value='" + domicilio.getDsEstado() + "' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Telefone:</td>");
				 formulario.append("<td><input name='dsTelefone' type='text' class='InputTexto' id='dsTelefone' maxlength='20' value='" + domicilio.getDsTelefone() + "' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Estado:</td>");
				 formulario.append("<td>");
				 formulario.append("<select id='idStatus' class='InputSelect'>");
				 formulario.append("<option value=''></option>");
				 formulario.append("<option value='A'");
				 if("A".equals(domicilio.getIdStatus()))
				 	formulario.append(" selected ");
				 formulario.append(">Ativo</option>");
				 formulario.append("<option value='I'");
				 if("I".equals(domicilio.getIdStatus()))
				  formulario.append(" selected ");
				 formulario.append(">Inativo</option>");
				 formulario.append("</select>");
				 formulario.append("</td></tr>");
				 formulario.append("<tr>");
				 formulario.append("<td> </td>");
				 formulario.append("<td> </td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td><input type='hidden' value='" + idDomicilio + "' id='cdDomicilio' name='cdDomicilio' /></td>");
				 formulario.append("<td id='DivFormularioAlerta'></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td>&nbsp;</td>");
				 formulario.append("<td>&nbsp;</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td>&nbsp;</td>");
				 formulario.append("<td><a href='javascript://' onclick='FormularioSalvar()'><img src='imagens/BotaoSalvar.gif' width='54' height='14' hspace='5' border='0' /></a><a href='javascript://' onclick='FormularioLimpar()'><img src='imagens/BotaoLimpar.gif' width='57' height='14' hspace='15' border='0' /></a><a href='javascript://' onclick='FormularioCancelar()'><img src='imagens/BotaoCancelar.gif' width='69' height='14' hspace='5' border='0' /></a></td>");
				 formulario.append("</tr>");
				 formulario.append("</table>");
				 formulario.append("<p>&nbsp;</p>");
				 formulario.append("</div>");
				 formulario.append("</form>");
				 this.writeResponse(resp, formulario.toString());
			 }
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			}
		}
		if("excluir".trim().equals(dsAcao))
		{
			 try
			 {
				 DaoUpdate daoUpdate = new DaoUpdate();
				 domicilio = new Domicilio();
				 domicilio.setCdDomicilio(Integer.parseInt(req.getParameter("cdDomicilio")));
				 daoUpdate.domicilioExcluir(domicilio);
				 this.writeResponse(resp, "excluido");
			 }
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			     domicilio = null;
			 }
		}
	 }
	 public Domicilio getDomicilioByCod(int cdDomicilio) throws Exception
	 {
		 DaoQuery daoQuery = new DaoQuery();
		 Domicilio domicilio = daoQuery.domicilioById(cdDomicilio);
		 return domicilio;
	 }
	 public void writeResponse(HttpServletResponse resp, String output) throws IOException{
			resp.setContentType("text/html");
			resp.setHeader("Cache-Control", "no-cache");
			resp.getWriter().write(output);
		}
	 }