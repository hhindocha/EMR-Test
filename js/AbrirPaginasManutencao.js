var gPaginaAtual = null;
var gIcone = null;
var gDivPesquisaListagem = null;
function AbrirPaginaManutencao(Icone)
{
	gPaginaAtual = Icone.id;
	gIcone = Icone.id;
	if(gPaginaAtual!='Fila')
	{
		var UrlFormulario = 'Cadastro.' + gPaginaAtual;
		var UrlListagem   = 'Listagem.jsp';
		gDivPesquisaListagem = 'DivPesquisaListagem';
		AbrirPagina_A(UrlFormulario,'DivCorpoLateralEsquerda','POST','dsAcao=formulario&id'+gIcone+'=0');
		AbrirPagina_B(UrlListagem,'DivCorpoLateralDireita','GET',null);
		FormularioInicio();
		MostraFila(false);
	}
	else
	{
		var UrlFormulario = 'Cadastro.' + gPaginaAtual;
		var UrlListagem   = 'Listar.' + gPaginaAtual;
		AbrirPagina_A(UrlFormulario,'DivFilaCabecalho','POST','dsAcao=formulario&idFila=0');
		AbrirPagina_B(UrlListagem,'DivFilaConteudo','POST','dsAcao=formularioLista');
		gDivPesquisaListagem = 'DivFilaListagem';
		FormularioInicio();
		MostraFila(true);
	}
	RetornaObjeto('Atendimento').style.display = 'none';
}
function CadastrarNovo()
{
	if(gPaginaAtual!='Fila')
	{
		var UrlFormulario = 'Cadastro.' + gPaginaAtual;
		AbrirPagina_A(UrlFormulario,'DivCorpoLateralEsquerda','POST','dsAcao=formulario&id'+gIcone+'=0');
		RetornaObjeto('DivMensagemCadastro').style.display = 'none';
		RetornaObjeto('DivMensagemCadastro').innerHTML = '';
	}
	else
	{
		var UrlFormulario = 'Cadastro.' + gPaginaAtual;
		AbrirPagina_A(UrlFormulario,'DivFilaCabecalho','POST','dsAcao=formulario&idFila=0');
		RetornaObjeto('DivMensagemCadastro').style.display = 'none';
		RetornaObjeto('DivMensagemCadastro').innerHTML = '';
	}
}
function ChamarPesquisaListagem()
{
	try
	{
		if(gPaginaAtual!='Fila')
			PesquisaListagem('Listar.'+gPaginaAtual,'DivPesquisaListagem','POST','dsAcao=pesquisar&dsBusca=*');
	}
	catch(e)
	{
		setTimeOut('ChamarPesquisaListagem',500);
	}
}
function ChamarPesquisaListagemPeloCampo(CampoDeTexto)
{
	try
	{
		if(CampoDeTexto.value=='')
			PesquisaListagem('Listar.'+gPaginaAtual,'DivPesquisaListagem','POST','dsAcao=pesquisar&dsBusca=*');
		else
			PesquisaListagem('Listar.'+gPaginaAtual,'DivPesquisaListagem','POST','dsAcao=pesquisar&dsBusca='+CampoDeTexto.value);
	}
	catch(e)
	{
		setTimeOut('ChamarPesquisaListagem',500);
	}
}
function Editar(id)
{
	var UrlFormulario = 'Cadastro.' + gPaginaAtual;
	if(gPaginaAtual!='Fila')
		AbrirPagina_A(UrlFormulario,'DivCorpoLateralEsquerda','POST','dsAcao=formulario&id'+gIcone+'='+id);
	else
		AbrirPagina_A(UrlFormulario,'DivFilaCabecalho','POST','dsAcao=formulario&idFila='+id);
	RetornaObjeto('DivMensagemCadastro').style.display = 'none';
	RetornaObjeto('DivMensagemCadastro').innerHTML = '';
}
function Excluir(id)
{
	var url = 'Excluir.' + gPaginaAtual;
	PostarFormularioExcluir(url,'DivCorpoLateralEsquerda','dsAcao=excluir&cd'+gIcone+'='+id);
}
function MostraFila(mostrar)
{
	if(mostrar)
	{
		RetornaObjeto('DivCorpoLateralEsquerda').style.display = 'none';
		RetornaObjeto('DivCorpoLateralDireita').style.display = 'none';
		RetornaObjeto('DivFilaCabecalho').style.display  = '';
		RetornaObjeto('DivFilaConteudo').style.display = '';
		RetornaObjeto('DivCorpoLateralEsquerda').innerHTML = '';
		RetornaObjeto('DivCorpoLateralDireita').innerHTML = '';

	}
	else
	{
		RetornaObjeto('DivCorpoLateralEsquerda').style.display = '';
		RetornaObjeto('DivCorpoLateralDireita').style.display = '';
		RetornaObjeto('DivFilaCabecalho').style.display  = 'none';
		RetornaObjeto('DivFilaConteudo').style.display = 'none';
		RetornaObjeto('DivCorpoLateralDireita').innerHTML = '';
		RetornaObjeto('DivFilaCabecalho').innerHTML = '';
	}
}
function Atender(cdFila)
{
	gPaginaAtual = 'Atendimento';
	RetornaObjeto('Atendimento').innerHTML = '';
	RetornaObjeto('Atendimento').style.display = '';
	RetornaObjeto('DivFilaCabecalho').innerHTML = '';
	RetornaObjeto('DivFilaConteudo').innerHTML = '';
	RetornaObjeto('DivFilaCabecalho').style.display = 'none';
	RetornaObjeto('DivFilaConteudo').style.display = 'none';
	gDivPesquisaListagem = 'DivPesquisaListagem';
	AbrirPagina_B('Cadastro.Atendimento','Atendimento','POST','dsAcao=formulario&idFila='+cdFila);
	FormularioInicio()
}
function CancelarAtendimento()
{
	RetornaObjeto('Atendimento').innerHTML = '';
	RetornaObjeto('DivFilaCabecalho').innerHTML = '';
	RetornaObjeto('DivFilaConteudo').innerHTML = '';
	RetornaObjeto('Atendimento').style.display = 'none';
	RetornaObjeto('DivFilaCabecalho').style.display = 'none';
	RetornaObjeto('DivFilaConteudo').style.display = 'none';
	AbrirPaginaManutencao(RetornaObjeto('Fila'));
}
function PesquisarFila()
{
	PesquisaListagem('Listar.'+gPaginaAtual,gDivPesquisaListagem,'POST','dsAcao=pesquisar&cdEstabelecimento='+RetornaObjeto('cdEstabelecimentoPesquisa').value+'&idStatus='+RetornaObjeto('idStatusPesquisa').value);
}