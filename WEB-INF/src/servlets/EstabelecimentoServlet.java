package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Estabelecimento;
import dao.DaoQuery;
import dao.DaoUpdate;

 public class EstabelecimentoServlet extends HttpServlet implements Servlet {
	 private static final long serialVersionUID = 1L;
	 public void service(HttpServletRequest req,
			             HttpServletResponse resp
				         ) throws IOException, ServletException	{
		Estabelecimento estabelecimento;
		String dsAcao = req.getParameter("dsAcao");
		if("cadastrar".trim().equals(dsAcao))
		{
			 try
			 {
				 DaoUpdate daoUpdate = new DaoUpdate();
				 estabelecimento = new Estabelecimento();
				 estabelecimento.setCdEstabelecimento(Integer.parseInt(req.getParameter("cdEstabelecimento")));
				 estabelecimento.setDsEstabelecimento(req.getParameter("dsEstabelecimento"));
				 estabelecimento.setDsEndereco(req.getParameter("dsEndereco"));
				 estabelecimento.setDsMunicipio(req.getParameter("dsMunicipio"));
				 estabelecimento.setDsEstado(req.getParameter("dsEstado"));
				 estabelecimento.setDsTelefone(req.getParameter("dsTelefone"));
				 estabelecimento.setIdStatus(req.getParameter("idStatus"));
				 daoUpdate.estabelecimentoSalva(estabelecimento);
				 if(estabelecimento.getCdEstabelecimento()>0)
					 this.writeResponse(resp, "atualizado");
				 else
					 this.writeResponse(resp, "cadastrado");
				 estabelecimento = null;
			 }
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			     estabelecimento = null;
			 }
		}
		if("pesquisar".trim().equals(dsAcao))
		{
			 try{
				 String dsBusca = req.getParameter("dsBusca");
				 StringBuffer tabelaResultado = new StringBuffer();
				 tabelaResultado.append("<table id='TabelaListagem' border='0' cellspacing='0' cellpadding='0'>");
				 ArrayList estabelecimentosPesquisa = new ArrayList();
				 DaoQuery daoQuery = new DaoQuery();
				 estabelecimentosPesquisa = daoQuery.estabelecimentoByDsEstabelecimento(dsBusca);
				 String classeCss = "";
				 String classeCssExcluido = "";
				 tabelaResultado.append("<tr>");
					tabelaResultado.append("<td width='15' class='LabelListagem'>#</td>");
				 	tabelaResultado.append("<td class='LabelListagem'>Nome</td>");
				 	tabelaResultado.append("<td class='LabelListagem'> </td>");
				 	tabelaResultado.append("<td class='LabelListagem'> </td>");
				tabelaResultado.append("</tr>");
				 for(int i=0; i<estabelecimentosPesquisa.size(); i++)
				 {
					 if("linhaEscura".trim().equals(classeCss))
						 classeCss = "LinhaClara";
					 else
						 classeCss = "linhaEscura";
					 estabelecimento = (Estabelecimento) estabelecimentosPesquisa.get(i);
					 if("I".equals(estabelecimento.getIdStatus()))
						 classeCssExcluido = "Excluido";
					 else
						 classeCssExcluido = "";
					tabelaResultado.append("<tr>");
						tabelaResultado.append("<td width='15' class='"+classeCss+classeCssExcluido+"'>"+ (i+1) + "</td>");
					 	tabelaResultado.append("<td width='100%' class='"+classeCss+classeCssExcluido+"'>" + estabelecimento.getDsEstabelecimento() + "</td>");
					 	tabelaResultado.append("<td class='"+classeCss+"'><a href='javascript://' onclick='Editar("+estabelecimento.getCdEstabelecimento()+")'><img src='imagens/BotaoEditar.gif' border='0'></a></td>");
					 	tabelaResultado.append("<td class='"+classeCss+"'><a href='javascript://' onclick='Excluir("+estabelecimento.getCdEstabelecimento()+")'><img src='imagens/BotaoExcluir.gif' border='0'></a></td>");
					tabelaResultado.append("</tr>");
				 }
				 tabelaResultado.append("</table>");
				 this.writeResponse(resp, tabelaResultado.toString());
				 estabelecimento = null;
			 } catch (Exception e) {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			}
		}
		if("formulario".trim().equals(dsAcao))
		{
			 try
			 {
				 int idEstabelecimento = Integer.parseInt(req.getParameter("idEstabelecimento"));
				 if(idEstabelecimento>0)
					 estabelecimento = getEstabelecimentoByCod(idEstabelecimento);
				 else
					 estabelecimento = new Estabelecimento();
				 StringBuffer formulario = new StringBuffer();
				 formulario.append("<form id='cadastro' name='cadastro'>");
				 formulario.append("<div id='DivFormulario'>");
				 formulario.append("<h2>Estabelecimento</h2>");
				 formulario.append("<table width='100%' border='0' cellspacing='1' cellpadding='1'>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Descri&ccedil;&atilde;o:</td>");
				 formulario.append("<td><input name='dsEstabelecimento' value='" + estabelecimento.getDsEstabelecimento() + "' type='text' class='InputTexto' id='dsEstabelecimento' maxlength='80' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Endereço:</td>");
				 formulario.append("<td><input name='dsEndereco' value='" + estabelecimento.getDsEndereco() + "' type='text' class='InputTexto' id='dsEndereco' maxlength='80' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Municipio:</td>");
				 formulario.append("<td><input name='dsMunicipio' value='" + estabelecimento.getDsMunicipio() + "' type='text' class='InputTexto' id='dsMunicipio' maxlength='80' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*UF:</td>");
				 formulario.append("<td><input name='dsEstado' value='" + estabelecimento.getDsEstado() + "' type='text' class='InputTexto' id='dsEstado' maxlength='2' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Telefone:</td>");
				 formulario.append("<td><input name='dsTelefone' value='" + estabelecimento.getDsTelefone() + "' type='text' class='InputTexto' id='dsTelefone' maxlength='20' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Estado:</td>");
				 formulario.append("<td>");
				 formulario.append("<select id='idStatus' class='InputSelect'>");
				 formulario.append("<option value=''></option>");
				 formulario.append("<option value='A'");
				 if("A".equals(estabelecimento.getIdStatus()))
					 	formulario.append(" selected ");
				 formulario.append(">Ativo</option>");
				 formulario.append("<option value='I'");
				 if("I".equals(estabelecimento.getIdStatus()))
					 formulario.append(" selected ");
				 formulario.append(">Inativo</option>");
				 formulario.append("</select>");
				 formulario.append("</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td></td>");
				 formulario.append("<td></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td><input type='hidden' value='" + idEstabelecimento + "' id='cdEstabelecimento' name='cdEstabelecimento' /></td>");
				 formulario.append("<td id='DivFormularioAlerta'>&nbsp;</td>");
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
				 estabelecimento = new Estabelecimento();
				 estabelecimento.setCdEstabelecimento(Integer.parseInt(req.getParameter("cdEstabelecimento")));
				 estabelecimento.setDsEstabelecimento(req.getParameter("dsEstabelecimento"));
				 daoUpdate.estabelecimentoExcluir(estabelecimento);
				 this.writeResponse(resp, "excluido");
			 }
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			     estabelecimento = null;
			 }
		}
	 }
	 public Estabelecimento getEstabelecimentoByCod(int cdEstabelecimento) throws Exception
	 {
		 DaoQuery daoQuery = new DaoQuery();
		 Estabelecimento estabelecimento = daoQuery.estabelecimentoById(cdEstabelecimento);
		 return estabelecimento;
	 }
	 public void writeResponse(HttpServletResponse resp, String output) throws IOException{
			resp.setContentType("text/html");
			resp.setHeader("Cache-Control", "no-cache");
			resp.getWriter().write(output);
		}
	 }