package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cid;
import dao.DaoQuery;
import dao.DaoUpdate;

public class CidServlet extends HttpServlet implements Servlet {
	 private static final long serialVersionUID = 1L;
	 public void service(HttpServletRequest req,
			             HttpServletResponse resp
				         ) throws IOException, ServletException	{
		Cid cid;
		String dsAcao = req.getParameter("dsAcao");
		if("cadastrar".trim().equals(dsAcao))
		{
			 try
			 {
				 DaoUpdate daoUpdate = new DaoUpdate();
				 cid = new Cid();
				 cid.setCdCid(Integer.parseInt(req.getParameter("cdCid")));
				 cid.setDsCid(req.getParameter("dsCid"));
				 cid.setIdStatus(req.getParameter("idStatus"));
				 daoUpdate.cidSalva(cid);
				 if(cid.getCdCid()>0)
					 this.writeResponse(resp, "atualizado");
				 else
					 this.writeResponse(resp, "cadastrado");
				 cid = null;
			 }
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			     cid = null;
			 }
		}
		if("pesquisar".trim().equals(dsAcao))
		{
			 try{
				 String dsBusca = req.getParameter("dsBusca");
				 StringBuffer tabelaResultado = new StringBuffer();
				 tabelaResultado.append("<table id='TabelaListagem' border='0' cellspacing='0' cellpadding='0'>");
				 ArrayList cidsPesquisa = new ArrayList();
				 DaoQuery daoQuery = new DaoQuery();
				 cidsPesquisa = daoQuery.cidByDsCid(dsBusca);
				 String classeCss = "";
				 String classeCssExcluido = "";
				 tabelaResultado.append("<tr>");
					tabelaResultado.append("<td width='15' class='LabelListagem'>#</td>");
				 	tabelaResultado.append("<td class='LabelListagem'>Nome</td>");
				 	tabelaResultado.append("<td class='LabelListagem'> </td>");
				 	tabelaResultado.append("<td class='LabelListagem'> </td>");
				tabelaResultado.append("</tr>");
				 for(int i=0; i<cidsPesquisa.size(); i++)
				 {
					 if("linhaEscura".trim().equals(classeCss))
						 classeCss = "LinhaClara";
					 else
						 classeCss = "linhaEscura";
					 cid = (Cid) cidsPesquisa.get(i);
					 if("I".equals(cid.getIdStatus()))
						 classeCssExcluido = "Excluido";
					 else
						 classeCssExcluido = "";
					tabelaResultado.append("<tr>");
						tabelaResultado.append("<td width='15' class='"+classeCss+classeCssExcluido+"'>" + (i+1) + "</td>");
					 	tabelaResultado.append("<td width='100%' class='"+classeCss+classeCssExcluido+"'>" + cid.getDsCid() + "</td>");
					 	tabelaResultado.append("<td class='"+classeCss+"'><a href='javascript://' onclick='Editar("+cid.getCdCid()+")'><img src='imagens/BotaoEditar.gif' border='0'></a></td>");
					 	tabelaResultado.append("<td class='"+classeCss+"'><a href='javascript://' onclick='Excluir("+cid.getCdCid()+")'><img src='imagens/BotaoExcluir.gif' border='0'></a></td>");
					tabelaResultado.append("</tr>");
				 }
				 tabelaResultado.append("</table>");
				 this.writeResponse(resp, tabelaResultado.toString());
				 cid = null;
			 } catch (Exception e) {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			}
		}
		if("formulario".trim().equals(dsAcao))
		{
			 try
			 {
				 int idCid = Integer.parseInt(req.getParameter("idCid"));
				 if(idCid>0)
					 cid = getCidByCod(idCid);			 
				 else
					 cid = new Cid();
				 StringBuffer formulario = new StringBuffer();
				 formulario.append("<form id='cadastro' name='cadastro'>");
				 formulario.append("<div id='DivFormulario'>");
				 formulario.append("<h2>Cid</h2>");
				 formulario.append("<table width='100%' border='0' cellspacing='1' cellpadding='1'>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Descri&ccedil;&atilde;o:</td>");
				 formulario.append("<td><input name='dsCid' value='" + cid.getDsCid() + "' type='text' class='InputTexto' id='dsCid' maxlength='120' /></td>");
				 formulario.append("</tr>");
				 formulario.append("<tr>");
				 formulario.append("<td class='LabelFormulario'>*Estado:</td>");
				 formulario.append("<td>");
				 formulario.append("<select id='idStatus' class='InputSelect'>");
				 formulario.append("<option value=''></option>");
				 formulario.append("<option value='A'");
				 if("A".equals(cid.getIdStatus()))
					 	formulario.append(" selected ");
				 formulario.append(">Ativo</option>");
				 formulario.append("<option value='I'");
				 if("I".equals(cid.getIdStatus()))
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
				 formulario.append("<td><input type='hidden' value='" + idCid + "' id='cdCid' name='cdCid' /></td>");
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
				 cid = new Cid();
				 cid.setCdCid(Integer.parseInt(req.getParameter("cdCid")));
				 cid.setDsCid(req.getParameter("dsCid"));
				 cid.setIdStatus(req.getParameter("idStatus"));
				 daoUpdate.cidExcluir(cid);
				 this.writeResponse(resp, "excluido");
			 }
			 catch (Exception e) 
			 {
				 e.printStackTrace();
			     resp.sendRedirect(req.getContextPath() + "/pError.jsp?mensagemExcecao=" + e.getMessage());
			     cid = null;
			 }
		}
	 }
	 public Cid getCidByCod(int cdCid) throws Exception
	 {
		 DaoQuery daoQuery = new DaoQuery();
		 Cid cid = daoQuery.cidById(cdCid);
		 return cid;
	 }
	 public void writeResponse(HttpServletResponse resp, String output) throws IOException{
			resp.setContentType("text/html");
			resp.setHeader("Cache-Control", "no-cache");
			resp.getWriter().write(output);
		}
	 }