package servlets;

import java.io.IOException;
import java.util.ArrayList;
import util.Data;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Domicilio;
import modelo.Paciente;
import dao.DaoQuery;
import dao.DaoUpdate;

 public class PacienteServlet extends HttpServlet implements Servlet {
	 private static final long serialVersionUID = 1L;
	 public void service(HttpServletRequest req,
			             HttpServletResponse resp
				         ) throws IOException, ServletException	{
		Paciente paciente;
		String dsAcao = req.getParameter("dsAcao");
	if("cadastrar".trim().equals(dsAcao))
	{
		 try
		 {
			DaoUpdate daoUpdate = new DaoUpdate();
			DaoQuery daoQuery = new DaoQuery();
			paciente = new Paciente();
			Domicilio domicilio = daoQuery.domicilioById(Integer.parseInt(req.getParameter("cdDomicilio")));
			paciente.setCdPaciente(Integer.parseInt(req.getParameter("cdPaciente")));
			paciente.setDomicilio(domicilio);
			paciente.setDsTelefoneCel(req.getParameter("dsTelefoneCel"));
			Data data = new Data();
			paciente.setDtNascimento(data.paraBDTrunc(req.getParameter("dtNacimento")));
			paciente.setNmMae(req.getParameter("nmMae"));
			paciente.setNmPaciente(req.getParameter("nmPaciente"));
			paciente.setTpSexo(req.getParameter("tpSexo"));
			paciente.setIdStatus(req.getParameter("idStatus"));
			daoUpdate.pacienteSalva(paciente);
			if(paciente.getCdPaciente()>0)
				this.writeResponse(resp, "atualizado");
			else
				this.writeResponse(resp, "cadastrado");
			paciente = null;
		 }
		 catch (Exception e) 
		 {
			 e.printStackTrace();
		     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
		     paciente = null;
		 }
	}
	if("pesquisar".trim().equals(dsAcao))
	{
		 try{
			 String dsBusca = req.getParameter("dsBusca");
			 StringBuffer tabelaResultado = new StringBuffer();
			 tabelaResultado.append("<table id='TabelaListagem' border='0' cellspacing='0' cellpadding='0'>");
			 ArrayList pacientePesquisa = new ArrayList();
			 DaoQuery daoQuery = new DaoQuery();
			 pacientePesquisa = daoQuery.pacienteByNmPaciente(dsBusca);
			 String classeCss = "";
			 String classeCssExcluido = "";
			 tabelaResultado.append("<tr>");
				tabelaResultado.append("<td width='15' class='LabelListagem'>#</td>");
			 	tabelaResultado.append("<td class='LabelListagem'>Nome</td>");
			 	tabelaResultado.append("<td class='LabelListagem'> </td>");
			 	tabelaResultado.append("<td class='LabelListagem'> </td>");
			tabelaResultado.append("</tr>");
			 for(int i=0; i<pacientePesquisa.size(); i++)
			 {
				 if("linhaEscura".trim().equals(classeCss))
					 classeCss = "LinhaClara";
				 else
					 classeCss = "linhaEscura";
				 paciente = (Paciente) pacientePesquisa.get(i);
				 if("I".equals(paciente.getIdStatus()))
					 classeCssExcluido = "Excluido";
				 else
					 classeCssExcluido = "";
				tabelaResultado.append("<tr>");
					tabelaResultado.append("<td width='15' class='"+classeCss+classeCssExcluido+"'>" + (i+1) + "</td>");
				 	tabelaResultado.append("<td width='100%' class='"+classeCss+classeCssExcluido+"'>" + paciente.getNmPaciente() + "</td>");
				 	tabelaResultado.append("<td class='"+classeCss+"'><a href='javascript://' onclick='Editar("+paciente.getCdPaciente()+")'><img src='imagens/BotaoEditar.gif' border='0'></a></td>");
				 	tabelaResultado.append("<td class='"+classeCss+"'><a href='javascript://' onclick='Excluir("+paciente.getCdPaciente()+")'><img src='imagens/BotaoExcluir.gif' border='0'></a></td>");
				tabelaResultado.append("</tr>");
			 }
			 tabelaResultado.append("</table>");
			 this.writeResponse(resp, tabelaResultado.toString());
			 paciente = null;
		 } catch (Exception e) {
			 e.printStackTrace();
		     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
		}
	}
	if("formulario".trim().equals(dsAcao))
	{
		 try
		 {
			 int idPaciente = Integer.parseInt(req.getParameter("idPaciente"));
			 if(idPaciente>0)
				 paciente = getPacienteByCod(idPaciente);
			 else
			 {
				 paciente = new Paciente();
				 paciente.setDomicilio(new Domicilio());
			 }
			 StringBuffer formulario = new StringBuffer();
			 formulario.append("<form id='cadastro' name='cadastro'>");
			 formulario.append("<div id='DivFormulario'>");
			 formulario.append("<h2>Paciente</h2>");
			 formulario.append("<table width='100%' border='0' cellspacing='1' cellpadding='1'>");
			 formulario.append("<tr>");
			 formulario.append("<td class='LabelFormulario'>*Nome:</td>");
			 formulario.append("<td><input name='nmPaciente' value='"+paciente.getNmPaciente()+"' type='text' class='InputTexto' id='nmPaciente' maxlength='80' /></td>");
			 formulario.append("</tr>");
			 formulario.append("<tr>");
			 formulario.append("<td class='LabelFormulario'>*Domicílio:</td>");
			 formulario.append("<td>");
				 StringBuffer inputSelect = new StringBuffer();
				 Domicilio domicilio;
				 inputSelect.append("<select name='cdDomicilio' class='InputSelect' id='cdDomicilio' style='width:250px'>");
				 ArrayList domicilioPesquisa = new ArrayList();
				 DaoQuery daoQuery = new DaoQuery();
				 domicilioPesquisa = daoQuery.domicilioByDsDomicilio("|s|");
				 inputSelect.append("<option value=''></option>");
				 String selected;
				 for(int i=0; i<domicilioPesquisa.size(); i++)
				 {
					 domicilio = (Domicilio) domicilioPesquisa.get(i);
					 if(domicilio.getCdDomicilio()==paciente.getDomicilio().getCdDomicilio())
						 selected = "selected";
					 else
						 selected = "";
					 inputSelect.append("<option value='" + domicilio.getCdDomicilio() + "' " + selected + ">" + domicilio.getDsLogradouro() + "</option>");
				 }
				 inputSelect.append("</select>");
				 domicilio = null;
				 formulario.append(inputSelect.toString());
			 formulario.append("</td>");
			 formulario.append("</tr>");
			 formulario.append("<tr>");
			 formulario.append("<td class='LabelFormulario'>*Nacimento (dd/mm/aaaa):</td>");
			 formulario.append("<td><input name='dtNacimento' value='"+paciente.getDtNascimento()+"' type='text' class='InputTexto' id='dtNacimento' maxlength='10' /></td>");
			 formulario.append("</tr>");
			 formulario.append("<tr>");
			 formulario.append("<td class='LabelFormulario'>*Telefone:</td>");
			 formulario.append("<td><input name='dsTelefoneCel' value='"+paciente.getDsTelefoneCel()+"' type='text' class='InputTexto' id='dsTelefoneCel' maxlength='20' /></td>");
			 formulario.append("</tr>");
			 formulario.append("<tr>");
			 formulario.append("<td class='LabelFormulario'>*Nome da m&atilde;e:</td>");
			 formulario.append("<td><input name='nmMae' value='"+paciente.getNmMae()+"' type='text' class='InputTexto' id='nmMae' maxlength='80' /></td>");
			 formulario.append("</tr>");
			 formulario.append("<tr>");
			 formulario.append("<td class='LabelFormulario'>*Sexo:</td>");
			 formulario.append("<td>");
			 formulario.append("<select name='tpSexo' id='tpSexo' class='InputSelect'>");
			 	formulario.append("<option value=''></option>");
			 	formulario.append("<option value='M'");
			 	if("M".equals(paciente.getTpSexo()))
			 		formulario.append(" selected ");
			 	formulario.append(">Masculino</option>");
			 	formulario.append("<option value='F'");
			 	if("F".equals(paciente.getTpSexo()))
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
			 	if("A".equals(paciente.getIdStatus()))
			 		formulario.append(" selected ");
			 	formulario.append(">Ativo</option>");
			 	formulario.append("<option value='I'");
			 	if("I".equals(paciente.getIdStatus()))
			 		formulario.append(" selected ");
			 	formulario.append(">Inativo</option>");
			 	formulario.append("<option value='O'");
			 	if("O".equals(paciente.getIdStatus()))
			 		formulario.append(" selected ");
			 	formulario.append(">Óbito</option>");
			 	formulario.append("</select>");
			 formulario.append("</td>");
			 formulario.append("</tr>");
			 formulario.append("<tr>");
			 formulario.append("<td></td>");
			 formulario.append("<td></td>");
			 formulario.append("</tr>");
			 formulario.append("<tr>");
			 formulario.append("<td><input type='hidden' value='" + idPaciente + "' id='cdPaciente' name='cdPaciente' /></td>");
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
			 paciente = new Paciente();
			 paciente.setCdPaciente(Integer.parseInt(req.getParameter("cdPaciente")));
			 daoUpdate.pacienteExcluir(paciente);
			 this.writeResponse(resp, "excluido");
		 }
		 catch (Exception e) 
		 {
			 e.printStackTrace();
		     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
		     paciente = null;
		 }
	}
 }
 public Paciente getPacienteByCod(int cdPaciente) throws Exception
 {
	 DaoQuery daoQuery = new DaoQuery();
	 Paciente paciente = daoQuery.pacienteById(cdPaciente);
	 return paciente;
 }
 public void writeResponse(HttpServletResponse resp, String output) throws IOException{
		resp.setContentType("text/html");
		resp.setHeader("Cache-Control", "no-cache");
			resp.getWriter().write(output);
		}
	 }
 