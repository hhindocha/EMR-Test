<%
	response.setHeader("Cache-Control", "no-cache");
%>
<div id="DivFormulario">
	<div id="DivBuscar">
		Buscar: <input name="dsBusca" type="text" class="InputTexto" id="dsBusca" maxlength="30" onKeyUp="ChamarPesquisaListagemPeloCampo(this)" />
	</div>
	<a href="javascript://" onclick="CadastrarNovo();"><img src="imagens/BotaoCadastrarNovo.gif" width="99" height="14" vspace="5" border="0" /></a>
	<div id="DivMensagemCadastro" style="display:none;" align="center"></div>
	<div id="DivPesquisaListagem"></div>
</div>
