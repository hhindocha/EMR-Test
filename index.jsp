<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>PESP - Prontu&aacute;rio Eletr&ocirc;nico em Sa&uacute;de P&uacute;blica</title>
<script language="javascript" src="js/Auxiliares.js"></script>
<script language="javascript" src="js/Menu.js"></script>
<script language="javascript" src="js/AbrirPaginasManutencao.js"></script>
<script language="javascript" src="js/Ajax.js"></script>
<script language="javascript" src="js/ControleDeFormularios.js"></script>
<link href="css/Estilos.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div align="center" id="DivCenter">
	<div id="DivGeral"  align="center">
		<div id="DivCabecalho" align="left">
		  <table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
			  <td width="308"><img src="imagens/PESPLogo.gif" width="308" height="57" /></td>
			  <td width="100%">&nbsp;</td>
			  <td nowrap="nowrap"><span class="LabelForm">Usu&aacute;rio:</span> Daniel Pereira Camargo<br />
				<a href="javascript://" class="BotaoLogout">[Logout]</a></td>
			  <td width="4"><img src="imagens/IconeOutros.gif" width="74" height="57" /></td>
			</tr>
		  </table>
		</div>
		<div id="DivCorpo" align="left">
			<div id="DivCorpoTopo"><img src="imagens/CorpoTopo.gif" /></div>
			<div id="DivCorpoConteudo">
				<div id="DivCorpoIcones">
					<div style="float:left;">
						<img class="Icone" src="imagens/IconeProfissional.gif" alt="Profissional" onclick="AbrirPaginaManutencao(this);" onmouseover="IndicaIcone(this);" id="Profissional"/>
						<img class="Icone" src="imagens/IconePaciente.gif" alt="Paciente" onclick="AbrirPaginaManutencao(this);" onmouseover="IndicaIcone(this);" id="Paciente"/>
						<img class="Icone" src="imagens/IconeCid.gif" alt="Cid" onclick="AbrirPaginaManutencao(this);" onmouseover="IndicaIcone(this);" id="Cid"/>
						<img class="Icone" src="imagens/IconeProcedimento.gif" alt="Procedimento" onclick="AbrirPaginaManutencao(this);" onmouseover="IndicaIcone(this);" id="Procedimento"/>
						<img class="Icone" src="imagens/IconeEstabelecimento.gif" alt="Estabelecimento" onclick="AbrirPaginaManutencao(this);" onmouseover="IndicaIcone(this);" id="Estabelecimento"/>
						<img class="Icone" src="imagens/IconeProfissao.gif" alt="Profiss&atilde;o" onclick="AbrirPaginaManutencao(this);" onmouseover="IndicaIcone(this);" id="Profissao"/>
						<img class="Icone" src="imagens/IconeDomicilio.gif" alt="Domic&iacute;lio" onclick="AbrirPaginaManutencao(this);" onmouseover="IndicaIcone(this);" id="Domicilio"/>
						<img class="Icone" src="imagens/IconeFila.gif" alt="Fila" onclick="AbrirPaginaManutencao(this);" onmouseover="IndicaIcone(this);" id="Fila"/>
						<img class="Icone" src="imagens/MenuSeparador.gif" />
					</div>
					<div id="DivCorpoMenuDescricao"> </div>
				</div>
				<div>
					<img src="imagens/MenuSeparador_1.gif" />
				</div>
				<div id="DivCorpoLateralEsquerda"></div>
				<div id="DivCorpoLateralDireita"></div>
			</div>
		</div>
	</div>
</div>
</body>
</html>