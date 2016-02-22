package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Data;

import modelo.Atendimento;
import modelo.Cid;
import modelo.Domicilio;
import modelo.Estabelecimento;
import modelo.Paciente;
import modelo.Procedimento;
import modelo.Profissional;
import modelo.Fila;
import dao.DaoQuery;
import dao.DaoUpdate;

 public class AtendimentoServlet extends HttpServlet implements Servlet {
	 private static final long serialVersionUID = 1L;
	 public void service(HttpServletRequest req,
			             HttpServletResponse resp
				         ) throws IOException, ServletException	{
		Atendimento atendimento;
		String dsAcao = req.getParameter("dsAcao");
		if("cadastrar".trim().equals(dsAcao))
		{
			 try
			 {
				 DaoUpdate daoUpdate = new DaoUpdate();
				 DaoQuery daoQuery = new DaoQuery();
				 Data data = new Data();
				 atendimento = new Atendimento();
				 Fila fila = daoQuery.filaById(Integer.parseInt(req.getParameter("cdFila")));
				 fila.setDtFila(data.paraBD(fila.getDtFila()));
				 fila.setIdStatus(req.getParameter("tpNovoEstado"));
				 Profissional profissional = daoQuery.profissionalById(Integer.parseInt(req.getParameter("cdProfissional")));
				 Procedimento procedimento = daoQuery.procedimentoById(Integer.parseInt(req.getParameter("cdProcedimento")));
				 Cid cid = daoQuery.cidById(Integer.parseInt(req.getParameter("cdCid")));
				 atendimento.setCdAtendimento(0);
				 atendimento.setEstabelecimento(fila.getEstabelecimento());
				 atendimento.setPaciente(fila.getPaciente());
				 atendimento.setProfissional(profissional);
				 atendimento.setProcedimento(procedimento);
				 atendimento.setCid(cid);
				 atendimento.setDtAtendimento(data.paraBD((req.getParameter("dtAtendimento"))));
				 atendimento.setDsAtendimento(req.getParameter("dsAtendimento"));
				 atendimento.setTpConsulta(req.getParameter("tpConsulta"));
				 atendimento.setDsQueixa(req.getParameter("dsQueixa"));
				 daoUpdate.atendimentoSalva(atendimento);
				 daoUpdate.filaSalva(fila);
				 if(atendimento.getCdAtendimento()>0)
					 this.writeResponse(resp, "atualizado");
				 else
					 this.writeResponse(resp, "cadastrado");
				 atendimento = null;
			 }
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			     atendimento = null;
			 }
		}
		if("formulario".trim().equals(dsAcao))
		{
			 try
			 {
				 
				 StringBuffer formulario = new StringBuffer();
				 DaoQuery daoQuery = new DaoQuery();
				 Data data = new Data();
				 String dataAtual;
				 int cdFila = Integer.parseInt(req.getParameter("idFila"));
				 Fila fila = daoQuery.filaById(cdFila);
				 dataAtual = data.getAgora(false);
				 dataAtual = dataAtual + " " + data.getHoraLocal();
				 formulario.append("<form id='cadastro' name='cadastro'>");
				 formulario.append("<h2>Atendimento</h2>");
				 formulario.append("<table width='200' border='0' cellspacing='1' cellpadding='1'>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormularioAtendimento' nowrap>Paciente:</td>");
				 formulario.append("<td><b>" + fila.getPaciente().getNmPaciente() + "</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormularioAtendimento' nowrap>Tipo de Consulta:</td>");
				 formulario.append("<td>");
				 if("E".equals(fila.getIdStatus()))
					 formulario.append("<b>Enfermagem</b><input type='hidden' value='M' id='tpNovoEstado' name='tpNovoEstado' /><input type='hidden' value='E' id='tpConsulta' name='tpConsulta' />");
				 if("M".equals(fila.getIdStatus()))
					 formulario.append("<b>Médica</b><input type='hidden' value='C' id='tpNovoEstado' name='tpNovoEstado' /><input type='hidden' value='M' id='tpConsulta' name='tpConsulta' />");
				 formulario.append("</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormularioAtendimento'>Data:</td>");
				 formulario.append("<td>"+dataAtual+"<input type='hidden' value='" + dataAtual + "' id='dtAtendimento' name='dtAtendimento' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormularioAtendimento' nowrap>*Profissional:</td>");
				 formulario.append("<td>");
					 StringBuffer inputSelectProfissional = new StringBuffer();
					 Profissional profissional;
					 inputSelectProfissional.append("<select name='cdProfissional' class='InputSelect' id='cdProfissional'>");
					 ArrayList profissionalPesquisa = new ArrayList();
					 profissionalPesquisa = daoQuery.profissionalByNmProfissional("|s|");
					 inputSelectProfissional.append("<option value=''></option>");
					 for(int i=0; i<profissionalPesquisa.size(); i++)
					 {
						 profissional = (Profissional) profissionalPesquisa.get(i);
						 inputSelectProfissional.append("<option value='" + profissional.getCdProfissional() + "'>" + profissional.getNmProfissional() + "</option>");
					 }
					 inputSelectProfissional.append("</select>");
					 profissional = null;
					 formulario.append(inputSelectProfissional.toString());
				 formulario.append("</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormularioAtendimento' nowrap>*Cid:</td>");
				 formulario.append("<td>");
					 StringBuffer inputSelectCid = new StringBuffer();
					 Cid cid;
					 inputSelectCid.append("<select name='cdCid' class='InputSelect' id='cdCid'>");
					 ArrayList cidPesquisa = new ArrayList();
					 cidPesquisa = daoQuery.cidByDsCid("|s|");
					 inputSelectCid.append("<option value=''></option>");
					 for(int i=0; i<cidPesquisa.size(); i++)
					 {
						 cid = (Cid) cidPesquisa.get(i);
						 inputSelectCid.append("<option value='" + cid.getCdCid() + "'>" + cid.getDsCid() + "</option>");
					 }
					 inputSelectCid.append("</select>");
					 cid = null;
					 formulario.append(inputSelectCid.toString());
				 formulario.append("</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td valign='top' class='LabelFormularioAtendimento' nowrap>*Queixa:</td>");
				 formulario.append("<td><textarea name='dsQueixa' rows='10' class='CaixaTexto' id='dsQueixa'></textarea></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td valign='top' class='LabelFormularioAtendimento' nowrap>*Descri&ccedil;&atilde;o:</td>");
				 formulario.append("<td><textarea name='dsAtendimento' rows='10' class='CaixaTexto' id='dsAtendimento'></textarea></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormularioAtendimento' nowrap>*Procedimento:</td>");
				 formulario.append("<td>");
					 StringBuffer inputSelectProcedimento = new StringBuffer();
					 Procedimento procedimento;
					 inputSelectProcedimento.append("<select name='cdProcedimento' class='InputSelect' id='cdProcedimento'>");
					 ArrayList procedimentoPesquisa = new ArrayList();
					 procedimentoPesquisa = daoQuery.procedimentoByDsProcedimento("|s|");
					 inputSelectProcedimento.append("<option value=''></option>");
					 for(int i=0; i<procedimentoPesquisa.size(); i++)
					 {
						 procedimento = (Procedimento) procedimentoPesquisa.get(i);
						 inputSelectProcedimento.append("<option value='" + procedimento.getCdProcedimento() + "'>" + procedimento.getDsProcedimento() + "</option>");
					 }
					 inputSelectProcedimento.append("</select>");
					 procedimento = null;
					 formulario.append(inputSelectProcedimento.toString());
				 formulario.append("</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td>&nbsp;</td>");
				 formulario.append("<td>&nbsp;</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td><input type='hidden' value='" + cdFila + "' id='cdFila' name='cdFila' /></td>");
				 formulario.append("<td id='DivFormularioAlerta'>&nbsp;</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td>&nbsp;</td>");
				 formulario.append("<td>&nbsp;</td>");
				 formulario.append("</tr>");
				 formulario.append("<tr> ");
				 formulario.append("<td>&nbsp;</td>");
				 formulario.append("<td><a href='javascript://' onClick='FormularioSalvar()'><img src='imagens/BotaoSalvar.gif' width='54' height='14' hspace='5' border='0' /></a><a href='javascript://' onClick='FormularioLimpar()'><img src='imagens/BotaoLimpar.gif' width='57' height='14' hspace='15' border='0' /></a><a href='javascript://' onClick='CancelarAtendimento()'><img src='imagens/BotaoCancelar.gif' width='69' height='14' hspace='5' border='0' /></a></td>");
				 formulario.append("</tr>");
				 formulario.append("</table>");
				 formulario.append("<p>");
				 ArrayList historicoAtendimento = new ArrayList();
				 historicoAtendimento = daoQuery.atendimentoByPaciente(fila.getPaciente().getCdPaciente());
				 if(historicoAtendimento.size()>0)
				 {
					 formulario.append("<h2>Histórico de atendimentos:</h2>");
					 for(int i=0; i<historicoAtendimento.size(); i++)
					 {
						 atendimento = (Atendimento) historicoAtendimento.get(i);
						 formulario.append("<b>Data: " + atendimento.getDtAtendimento() + "</b>");
						 String tipoAtendimento;
						 if("E".equals(atendimento.getTpConsulta()))
							 tipoAtendimento = "Enfermagem";
						 else
							 tipoAtendimento = "Médico";
						 formulario.append("<br><b>Tipo de Atendimento:</b> " + tipoAtendimento);
						 formulario.append("<br><b>Queixa:</b> " + atendimento.getDsQueixa());
						 formulario.append("<br><b>Descrição:</b> " + atendimento.getDsAtendimento());
						 formulario.append("<br><b>Procedimento:</b> " + atendimento.getProcedimento().getDsProcedimento());
						 formulario.append("<br><b>Profissional:</b> " + atendimento.getProfissional().getNmProfissional());
						 formulario.append("<br><b>Cid:</b> " + atendimento.getCid().getDsCid());
						 formulario.append("<hr>");
					 }
				 }
				 formulario.append("<p id='DivMensagemCadastro' style='display:none'>&nbsp;</p>");
				 formulario.append("<p style='display:none' id='DivPesquisaListagem'>&nbsp;</p>");
				 formulario.append("</form>");
				 this.writeResponse(resp, formulario.toString());
			 }
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			}
		}
	 }
	 //public Atendimento getAtendimentoByCod(int cdAtendimento) throws Exception
	//{
		 //DaoQuery daoQuery = new DaoQuery();
		 //Atendimento atendimento = daoQuery.atendimentoById(cdAtendimento);
		 //return atendimento;
	 //}
	 public void writeResponse(HttpServletResponse resp, String output) throws IOException{
			resp.setContentType("text/html");
			resp.setHeader("Cache-Control", "no-cache");
			resp.getWriter().write(output);
		}
	 }