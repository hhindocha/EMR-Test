package servlets;

import java.io.IOException;
import java.util.ArrayList;
import util.Data;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Fila;
import modelo.Estabelecimento;
import modelo.Paciente;
import dao.DaoQuery;
import dao.DaoUpdate;

 public class FilaServlet extends HttpServlet implements Servlet {
	 private static final long serialVersionUID = 1L;
	 public void service(HttpServletRequest req,
			             HttpServletResponse resp
				         ) throws IOException, ServletException	{
		Fila fila;
		Paciente paciente;
		Estabelecimento estabelecimento;
		String dsAcao = req.getParameter("dsAcao");
	if("cadastrar".trim().equals(dsAcao))
	{
		 try
		 {
			DaoUpdate daoUpdate = new DaoUpdate();
			DaoQuery daoQuery = new DaoQuery();
			paciente = daoQuery.pacienteById(Integer.parseInt(req.getParameter("cdPaciente")));
			estabelecimento = daoQuery.estabelecimentoById(Integer.parseInt(req.getParameter("cdEstabelecimento")));
			String idStatus = req.getParameter("idStatus");
			fila = new Fila();
			fila.setEstabelecimento(estabelecimento);
			fila.setPaciente(paciente);
			Data data = new Data();
			fila.setCdFila(Integer.parseInt(req.getParameter("cdFila")));
			fila.setDtFila(data.paraBD((req.getParameter("dtFila"))));
			fila.setIdStatus(idStatus);
			daoUpdate.filaSalva(fila);
			if(fila.getCdFila()>0)
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
			 StringBuffer tabelaResultado = new StringBuffer();
			 ArrayList filaPesquisa = new ArrayList();
			 DaoQuery daoQuery = new DaoQuery();
			 filaPesquisa = daoQuery.pacientesNaFila(Integer.parseInt(req.getParameter("cdEstabelecimento")),req.getParameter("idStatus"));
			 String classeCss = "";
			 if(filaPesquisa.size()>0)
			 {
				tabelaResultado.append("<table id='TabelaListagemFila' border='0' cellspacing='0' cellpadding='0'>");
				 tabelaResultado.append("<tr>");
					tabelaResultado.append("<td width='15' class='LabelListagem'>#</td>");
				 	tabelaResultado.append("<td class='LabelListagem'>Nome</td>");
				 	tabelaResultado.append("<td class='LabelListagem'>Data</td>");
				 	tabelaResultado.append("<td class='LabelListagem'> </td>");
				 	tabelaResultado.append("<td class='LabelListagem'> </td>");
				tabelaResultado.append("</tr>");
			 }
			for(int i=0; i<filaPesquisa.size(); i++)
			 {
				 if("linhaEscura".trim().equals(classeCss))
					 classeCss = "LinhaClara";
				 else
					 classeCss = "linhaEscura";
				fila = (Fila) filaPesquisa.get(i);
				tabelaResultado.append("<tr>");
					tabelaResultado.append("<td width='15' class='"+classeCss+"'>" + (i+1) + "</td>");
				 	tabelaResultado.append("<td width='70%' class='"+classeCss+"'>" + fila.getPaciente().getNmPaciente() + "</td>");
				 	tabelaResultado.append("<td width='30%' class='"+classeCss+"'>" + fila.getDtFila() + "</td>");
				 	tabelaResultado.append("<td class='"+classeCss+"'><a href='javascript://' onclick='Atender("+fila.getCdFila()+")'><img src='imagens/BotaoAtender.gif' border='0'></a></td>");
				 	tabelaResultado.append("<td class='"+classeCss+"'><a href='javascript://' onclick='Editar("+fila.getCdFila()+")'><img src='imagens/BotaoAlterarEstado.gif' border='0'></a></td>");
				tabelaResultado.append("</tr>");
			 }
			if(filaPesquisa.size()>0)
				tabelaResultado.append("</table>");
			else
				tabelaResultado.append("<h2>Não há pacientes na fila.</h2>");
			 this.writeResponse(resp, tabelaResultado.toString());
			 paciente = null;
		 } catch (Exception e) {
			 e.printStackTrace();
		     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
		}
	}
	if("formularioLista".trim().equals(dsAcao))
	{
		 try{
			 StringBuffer tabelaResultado = new StringBuffer();
			 tabelaResultado.append("<hr size='1'><div id='DivFormulario'>");
			 tabelaResultado.append("<div id='DivBuscar'>");
			 tabelaResultado.append("Estado: <select id='idStatusPesquisa' name='idStatus' style='width:280px;' class='InputTexto'>");
			 tabelaResultado.append("<option value='E'>Aguardando atendimento enfermagem</option>");
			 tabelaResultado.append("<option value='M'>Aguardando atendimento médico</option>");
			 tabelaResultado.append("<option value='C'>Concluído</option>");
			 tabelaResultado.append("</select> ");
			 tabelaResultado.append("Estabelecimento: ");
			 StringBuffer inputSelect = new StringBuffer();
			 inputSelect.append("<select name='cdEstabelecimentoPesquisa' class='InputSelect' id='cdEstabelecimentoPesquisa'>");
			 ArrayList estabelecimentosPesquisa = new ArrayList();
			 DaoQuery daoQuery = new DaoQuery();
			 estabelecimentosPesquisa = daoQuery.estabelecimentoByDsEstabelecimento("|s|");
			 for(int i=0; i<estabelecimentosPesquisa.size(); i++)
			 {
				 estabelecimento = (Estabelecimento) estabelecimentosPesquisa.get(i);
				 inputSelect.append("<option value='" + estabelecimento.getCdEstabelecimento() + "'>" + estabelecimento.getDsEstabelecimento() + "</option>");
			 }
			 inputSelect.append("</select>");
			 estabelecimento = null;
			 tabelaResultado.append(inputSelect.toString());
			 tabelaResultado.append("<a href='javascript://' onclick='PesquisarFila();'><img src='imagens/BotaoMostrar.gif' border='0' /></a></div>");
			 tabelaResultado.append("<a href='javascript://' onclick='CadastrarNovo();'><img src='imagens/BotaoCadastrarNovo.gif' width='99' height='14' vspace='5' border='0' /></a>");
			 tabelaResultado.append("<div id='DivMensagemCadastro' style='display:none;' align='center'></div>");
			 tabelaResultado.append("<div id='DivFilaListagem'></div>");
			 tabelaResultado.append("</div>");
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
			 int idFila = Integer.parseInt(req.getParameter("idFila"));
			 String dataAtual;
			 if(idFila>0)
			 {
				 fila = getFilaByCod(idFila);
				 dataAtual = fila.getDtFila();
			 }
			 else
			 {
				 fila = new Fila();
				 fila.setEstabelecimento(new Estabelecimento());
				 fila.setPaciente(new Paciente());
				 Data data = new Data();
				 dataAtual = data.getAgora(false);
				 dataAtual = dataAtual + " " + data.getHoraLocal();				 
			 }
			 StringBuffer formulario = new StringBuffer();
			 formulario.append("<form id='cadastro' name='cadastro'>");
			 formulario.append("<div id='DivFormulario'>");
			 formulario.append("<h2>Paciente na fila</h2>");
			 formulario.append("<table width='100%' border='0' cellspacing='1' cellpadding='1'>");
			 formulario.append("<tr>");
			 formulario.append("<td class='LabelFormulario'>*Estabelecimento:</td>");
			 formulario.append("<td>");
			 StringBuffer inputSelectEstabelecimento = new StringBuffer();
			 inputSelectEstabelecimento.append("<select name='cdEstabelecimento' class='InputSelect' id='cdEstabelecimento'>");
			 ArrayList estabelecimentosPesquisa = new ArrayList();
			 DaoQuery daoQuery = new DaoQuery();
			 estabelecimentosPesquisa = daoQuery.estabelecimentoByDsEstabelecimento("|s|");
			 inputSelectEstabelecimento.append("<option value=''></option>");
			 String select = "";
			 for(int i=0; i<estabelecimentosPesquisa.size(); i++)
			 {
				 estabelecimento = (Estabelecimento) estabelecimentosPesquisa.get(i);
				 if(estabelecimento.getCdEstabelecimento()==fila.getEstabelecimento().getCdEstabelecimento())
					 select = "selected";
				 else
					 select = "";
				 inputSelectEstabelecimento.append("<option value='" + estabelecimento.getCdEstabelecimento() + "' "+select+">" + estabelecimento.getDsEstabelecimento() + "</option>");
			 }
			 inputSelectEstabelecimento.append("</select>");
			 estabelecimento = null;
			 formulario.append(inputSelectEstabelecimento.toString());
			 StringBuffer inputSelectPaciente = new StringBuffer();
			 formulario.append("</td>");
			 formulario.append("</tr>");
			 formulario.append("<tr>");
			 formulario.append("<td class='LabelFormulario'>*Paciente:</td>");
			 formulario.append("<td>");
			 inputSelectPaciente.append("<select name='cdPaciente' class='InputSelect' id='cdPaciente'>");
			 ArrayList pacientePesquisa = new ArrayList();
			 pacientePesquisa = daoQuery.pacienteByNmPaciente("|s|");
			 inputSelectPaciente.append("<option value=''></option>");
			 for(int i=0; i<pacientePesquisa.size(); i++)
			 {
				 paciente = (Paciente) pacientePesquisa.get(i);
				 if(paciente.getCdPaciente()==fila.getPaciente().getCdPaciente())
					 select = "selected";
				 else
					 select = "";
				 inputSelectPaciente.append("<option value='" + paciente.getCdPaciente() + "' "+select+">" + paciente.getNmPaciente() + "</option>");
			 }
			 inputSelectPaciente.append("</select>");
			 paciente = null;
			 formulario.append(inputSelectPaciente.toString());
			 formulario.append("</td>");
			 formulario.append("</tr>");
			 formulario.append("<tr>");
			 formulario.append("<td class='LabelFormulario'>*Estado:</td>");
			 formulario.append("<td>");
			 formulario.append("<select id='idStatus' name='idStatus' style='width:280px;' class='InputTexto'>");
			 formulario.append("<option value=''></option>");
			 formulario.append("<option value='E'");
			 if("E".equals(fila.getIdStatus()))
				 formulario.append(" selected ");
			 formulario.append(">Aguardando atendimento enfermagem</option>");
			 formulario.append("<option value='M'");
			 if("M".equals(fila.getIdStatus()))
				 formulario.append(" selected ");
			 formulario.append(">Aguardando atendimento médico</option>");
			 formulario.append("<option value='C'");
			 if("C".equals(fila.getIdStatus()))
				 formulario.append(" selected ");
			 formulario.append(">Concluído</option>");
			 formulario.append("</select> ");
			 formulario.append("</td>");
			 formulario.append("</tr>");
			 formulario.append("</tr>");
			 formulario.append("<tr>");
			 formulario.append("<td class='LabelFormulario'>Data:</td>");
			 formulario.append("<td>"+dataAtual+"</td>");
			 formulario.append("</tr>");
			 formulario.append("<tr>");
			 formulario.append("<td><input type='hidden' value='" + idFila + "' id='cdFila' name='cdFila' /><input type='hidden' value='" + dataAtual + "' id='dtFila' name='dtFila' /></td></td>");
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
 public Fila getFilaByCod(int cdFila) throws Exception
 {
	 DaoQuery daoQuery = new DaoQuery();
	 Fila fila = daoQuery.filaById(cdFila);
	 return fila;
 }
 public void writeResponse(HttpServletResponse resp, String output) throws IOException{
		resp.setContentType("text/html");
		resp.setHeader("Cache-Control", "no-cache");
			resp.getWriter().write(output);
		}
	 }
 