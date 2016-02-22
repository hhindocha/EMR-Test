<%
	response.setHeader("Cache-Control", "no-cache");
%>
<form id="cadastro" name="cadastro">
	<div id="DivFormulario">
		<h2>Profissional</h2>
		<table width="100%" border="0" cellspacing="1" cellpadding="1">
		  <tr>
			<td class="LabelFormulario">*Descri&ccedil;&atilde;o:</td>
			<td><input name="dsCid" type="text" class="InputTexto" id="dsProfissao" maxlength="80" /></td>
		  </tr>
		  <tr>
			<td class="LabelFormulario">*Conselho:</td>
			<td><input name="dsCid" type="text" class="InputTexto" id="dsConselho" maxlength="80" /></td>
		  </tr>
		  <tr>
			<td class="LabelFormulario">*Estado:</td>
			<td>
			<select id="idStatus" class="InputSelect">
				<option value=""></option>
				<option value="A">Ativo</option>
				<option value="I">Inativo</option>
			</select>
			</td>
		  </tr>
		  <tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
		  <tr>
            <td>&nbsp;</td>
		    <td id="DivFormularioAlerta">&nbsp;</td>
	      </tr>
		  <tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		  </tr>
		  <tr>
			<td>&nbsp;</td>
			<td><a href="javascript://" onclick="FormularioSalvar()"><img src="imagens/BotaoSalvar.gif" width="54" height="14" hspace="5" border="0" /></a><a href="javascript://" onclick="FormularioLimpar()"><img src="imagens/BotaoLimpar.gif" width="57" height="14" hspace="15" border="0" /></a><a href="javascript://" onclick="FormularioCancelar()"><img src="imagens/BotaoCancelar.gif" width="69" height="14" hspace="5" border="0" /></a></td>
		  </tr>
		</table>
		<p>&nbsp;</p>
	</div>
</form>