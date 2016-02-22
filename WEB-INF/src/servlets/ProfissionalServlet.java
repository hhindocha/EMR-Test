package servlets;

import java.io.IOException;
import java.util.ArrayList;
import util.Data;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Profissao;
import modelo.Profissional;
import dao.DaoQuery;
import dao.DaoUpdate;

 public class ProfissionalServlet extends HttpServlet implements Servlet {
	 private static final long serialVersionUID = 1L;
	 public void service(HttpServletRequest req,
			             HttpServletResponse resp
				         ) throws IOException, ServletException	{
		Profissional profissional;
		String dsAcao = req.getParameter("dsAcao");
		if("cadastrar".trim().equals(dsAcao))
		{
			 try
			 {
				DaoUpdate daoUpdate = new DaoUpdate();
				DaoQuery daoQuery = new DaoQuery();
				profissional = new Profissional();
				Profissao profissao = daoQuery.profissaoById(Integer.parseInt(req.getParameter("cdProfissao")));
				profissional.setCdProfissional(Integer.parseInt(req.getParameter("cdProfissional")));
				profissional.setProfissao(profissao);
				profissional.setDsCPF(req.getParameter("dsCPF"));
				profissional.setDsLogin(req.getParameter("dsLogin"));
				profissional.setDsSenha(req.getParameter("dsSenha"));
				Data data = new Data();
				profissional.setDtNascimento(data.paraBDTrunc(req.getParameter("dtNacimento")));
				profissional.setNmMae(req.getParameter("nmMae"));
				profissional.setNmProfissional(req.getParameter("nmProfissional"));
				profissional.setTpSexo(req.getParameter("tpSexo"));
				profissional.setIdStatus(req.getParameter("idStatus"));
				daoUpdate.profissionalSalva(profissional);
				if(profissional.getCdProfissional()>0)
					this.writeResponse(resp, "atualizado");
				else
					this.writeResponse(resp, "cadastrado");
				profissional = null;
			 }
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			     profissional = null;
			 }
		}
		if("pesquisar".trim().equals(dsAcao))
		{
			 try{
				 String dsBusca = req.getParameter("dsBusca");
				 StringBuffer tabelaResultado = new StringBuffer();
				 tabelaResultado.append("<table id='TabelaListagem' border='0' cellspacing='0' cellpadding='0'>");
				 ArrayList profissionalPesquisa = new ArrayList();
				 DaoQuery daoQuery = new DaoQuery();
				 profissionalPesquisa = daoQuery.profissionalByNmProfissional(dsBusca);
				 String classeCss = "";
				 String classeCssExcluido = "";
				 tabelaResultado.append("<tr>");
					tabelaResultado.append("<td width='15' class='LabelListagem'>#</td>");
				 	tabelaResultado.append("<td class='LabelListagem'>Nome</td>");
				 	tabelaResultado.append("<td class='LabelListagem'> </td>");
				 	tabelaResultado.append("<td class='LabelListagem'> </td>");
				tabelaResultado.append("</tr>");
				 for(int i=0; i<profissionalPesquisa.size(); i++)
				 {
					 if("linhaEscura".trim().equals(classeCss))
						 classeCss = "LinhaClara";
					 else
						 classeCss = "linhaEscura";
					 profissional = (Profissional) profissionalPesquisa.get(i);
					 if("I".equals(profissional.getIdStatus()))
						 classeCssExcluido = "Excluido";
					 else
						 classeCssExcluido = "";
					tabelaResultado.append("<tr>");
						tabelaResultado.append("<td width='15' class='"+classeCss+classeCssExcluido+"'>" + (i+1) + "</td>");
					 	tabelaResultado.append("<td width='100%' class='"+classeCss+classeCssExcluido+"'>" + profissional.getNmProfissional() + "</td>");
					 	tabelaResultado.append("<td class='"+classeCss+"'><a href='javascript://' onclick='Editar("+profissional.getCdProfissional()+")'><img src='imagens/BotaoEditar.gif' border='0'></a></td>");
					 	tabelaResultado.append("<td class='"+classeCss+"'><a href='javascript://' onclick='Excluir("+profissional.getCdProfissional()+")'><img src='imagens/BotaoExcluir.gif' border='0'></a></td>");
					tabelaResultado.append("</tr>");
				 }
				 tabelaResultado.append("</table>");
				 this.writeResponse(resp, tabelaResultado.toString());
				 profissional = null;
			 } catch (Exception e) {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			}
		}
		if("formulario".trim().equals(dsAcao))
		{
			 try
			 {
				 int idProfissional = Integer.parseInt(req.getParameter("idProfissional"));
				 if(idProfissional>0)
					 profissional = getProfissionalByCod(idProfissional);
				 else
				 {
					 profissional = new Profissional();
					 profissional.setProfissao(new Profissao());
				 }
				 StringBuffer formulario = new StringBuffer();
				 formulario.append("<form id='cadastro' name='cadastro'>");
				 formulario.append("<div id='DivFormulario'>");
				 formulario.append("<h2>Profissional</h2>");
				 formulario.append("<table width='100%' border='0' cellspacing='1' cellpadding='1'>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Nome:</td>");
				 formulario.append("<td><input name='nmProfissional' value='"+profissional.getNmProfissional()+"' type='text' class='InputTexto' id='nmProfissional' maxlength='80' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Profiss&atilde;o:</td>");
				 formulario.append("<td>");
					 StringBuffer inputSelect = new StringBuffer();
					 Profissao profissao;
					 inputSelect.append("<select name='cdProfissao' class='InputSelect' id='cdProfissao'>");
					 ArrayList profissaoPesquisa = new ArrayList();
					 DaoQuery daoQuery = new DaoQuery();
					 profissaoPesquisa = daoQuery.profissaoByDsProfissao("|s|");
					 inputSelect.append("<option value=''></option>");
					 String selected;
					 for(int i=0; i<profissaoPesquisa.size(); i++)
					 {
						 profissao = (Profissao) profissaoPesquisa.get(i);
						 if(profissao.getCdProfissao()==profissional.getProfissao().getCdProfissao())
							 selected = "selected";
						 else
							 selected = "";
						 inputSelect.append("<option value='" + profissao.getCdProfissao() + "' " + selected + ">" + profissao.getDsProfissao() + "</option>");
					 }
					 inputSelect.append("</select>");
					 profissao = null;
					 formulario.append(inputSelect.toString());
				 formulario.append("</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Login:</td>");
				 formulario.append("<td><input name='dsLogin' value='"+profissional.getDsLogin()+"' type='text' class='InputTexto' id='dsLogin' maxlength='20' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Senha:</td>");
				 formulario.append("<td><input name='dsSenha' value='"+profissional.getDsSenha()+"' type='password' class='InputTexto' id='dsSenha' maxlength='10' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Nacimento (dd/mm/aaaa):</td>");
				 formulario.append("<td><input name='dtNacimento' value='"+profissional.getDtNascimento()+"' type='text' class='InputTexto' id='dtNacimento' maxlength='10' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*CPF:</td>");
				 formulario.append("<td><input name='dsCPF' value='"+profissional.getDsCPF()+"' type='text' class='InputTexto' id='dsCPF' maxlength='11' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Nome da m&atilde;e:</td>");
				 formulario.append("<td><input name='nmMae' value='"+profissional.getNmMae()+"' type='text' class='InputTexto' id='nmMae' maxlength='80' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Sexo:</td>");
				 formulario.append("<td>");
				 formulario.append("<select name='tpSexo' id='tpSexo' class='InputSelect'>");
				 	formulario.append("<option value=''></option>");
				 	formulario.append("<option value='M'");
				 	if("M".equals(profissional.getTpSexo()))
				 		formulario.append(" selected ");
				 	formulario.append(">Masculino</option>");
				 	formulario.append("<option value='F'");
				 	if("F".equals(profissional.getTpSexo()))
				 		formulario.append(" selected ");
				 	formulario.append(">Feminino</option>");
				 	formulario.append("</select>");
				 formulario.append("</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Estado:</td>");
				 formulario.append("<td>");
				 formulario.append("<select name='idStatus' id='idStatus' class='InputSelect'>");
				 	formulario.append("<option value=''></option>");
				 	formulario.append("<option value='A'");
				 	if("A".equals(profissional.getIdStatus()))
				 		formulario.append(" selected ");
				 	formulario.append(">Ativo</option>");
				 	formulario.append("<option value='I'");
				 	if("I".equals(profissional.getIdStatus()))
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
				 formulario.append("<td><input type='hidden' value='" + idProfissional + "' id='cdProfissional' name='cdProfissional' /></td>");
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
				 profissional = new Profissional();
				 profissional.setCdProfissional(Integer.parseInt(req.getParameter("cdProfissional")));
				 daoUpdate.profissionalExcluir(profissional);
				 this.writeResponse(resp, "excluido");
			 }
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			     profissional = null;
			 }
		}
	 }
	 public Profissional getProfissionalByCod(int cdProfissional) throws Exception
	 {
		 DaoQuery daoQuery = new DaoQuery();
		 Profissional profissional = daoQuery.profissionalById(cdProfissional);
		 return profissional;
	 }
	 public void writeResponse(HttpServletResponse resp, String output) throws IOException{
			resp.setContentType("text/html");
			resp.setHeader("Cache-Control", "no-cache");
			resp.getWriter().write(output);
		}
	 }