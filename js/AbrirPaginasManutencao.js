var gPaginaAtual = null;
var gIcone = null;
function AbrirPaginaManutencao(Icone)
{
	gPaginaAtual = Icone.id;
	gIcone = Icone.id;
	var UrlFormulario = 'Cadastro.' + gPaginaAtual;
	var UrlListagem   = 'Listagem.jsp';
	AbrirPagina_A(UrlFormulario,'DivCorpoLateralEsquerda','POST','dsAcao=formulario&id'+gIcone+'=0');
	AbrirPagina_B(UrlListagem,'DivCorpoLateralDireita','GET',null);
	FormularioInicio();
}
function CadastrarNovo()
{
	var UrlFormulario = 'Cadastro.' + gPaginaAtual;
	AbrirPagina_A(UrlFormulario,'DivCorpoLateralEsquerda','POST','dsAcao=formulario&id'+gIcone+'=0');
	RetornaObjeto('DivMensagemCadastro').style.display = 'none';
	RetornaObjeto('DivMensagemCadastro').innerHTML = '';
}
function ChamarPesquisaListagem()
{
	try
	{
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
	AbrirPagina_A(UrlFormulario,'DivCorpoLateralEsquerda','POST','dsAcao=formulario&id'+gIcone+'='+id);
	RetornaObjeto('DivMensagemCadastro').style.display = 'none';
	RetornaObjeto('DivMensagemCadastro').innerHTML = '';
}
function Excluir(id)
{
	var url = 'Excluir.' + gPaginaAtual;
	PostarFormularioExcluir(url,'DivCorpoLateralEsquerda','dsAcao=excluir&cd'+gIcone+'='+id);
}