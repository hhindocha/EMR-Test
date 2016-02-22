function CriarObjetoHttpRequest()
{
	try
	{
		return new ActiveXObject("Msxml2.XMLHTTP");
	}
	catch(e){}
	try
	{
		return new ActiveXObject("Microsoft.XMLHTTP")
	}
	catch(e){}
	try
	{
		return new XMLHttpRequest()
	}
	catch(e){}
		alert("Seu Browser não tem suporte a XMLHttpRequest!");
	return null;
}

function AbrirPagina_A(url,div,metodo,variaveis)
{
	g_div_A = div;
	RetornaObjeto(g_div_A).innerHTML = g_CarregandoHorizontalGrande;
	HttpRequest_A.open(metodo,url,true);
	HttpRequest_A.setRequestHeader('Content-Type','application/x-www-form-urlencoded;');
	HttpRequest_A.onreadystatechange=VerificaAlteracaoDeEstado_A;
	HttpRequest_A.send(variaveis);
}
function VerificaAlteracaoDeEstado_A()
{
	if(HttpRequest_A.readyState!=4){return;}
		document.getElementById(g_div_A).innerHTML = HttpRequest_A.responseText;
}
function AbrirPagina_B(url,div,metodo,variaveis)
{
	g_div_B = div;
	RetornaObjeto(g_div_A).innerHTML = g_CarregandoHorizontalGrande;
	HttpRequest_B.open(metodo,url,true);
	HttpRequest_B.setRequestHeader('Content-Type','application/x-www-form-urlencoded;');
	HttpRequest_B.onreadystatechange=VerificaAlteracaoDeEstado_B;
	HttpRequest_B.send(variaveis);
}
function VerificaAlteracaoDeEstado_B()
{
	if(HttpRequest_B.readyState!=4){return;}
		document.getElementById(g_div_B).innerHTML = HttpRequest_B.responseText;
	ChamarPesquisaListagem();
}
function PostarFormulario(url,div,variaveis)
{
	g_divFormulario = div;
	RetornaObjeto(g_divFormulario).innerHTML = g_CarregandoHorizontalGrande;
	RetornaObjeto('DivMensagemCadastro').style.display = 'none';
	RetornaObjeto('DivMensagemCadastro').innerHTML = '';
	HttpRequestFormulario.open('POST',url,true);
	HttpRequestFormulario.setRequestHeader('Content-Type','application/x-www-form-urlencoded;');
	HttpRequestFormulario.onreadystatechange=VerificaAlteracaoDeEstado_Formulario;
	HttpRequestFormulario.send(variaveis);
}
function PostarFormularioExcluir(url,div,variaveis)
{
	g_divFormulario = div;
	RetornaObjeto(g_divFormulario).innerHTML = g_CarregandoHorizontalGrande;
	RetornaObjeto('DivMensagemCadastro').style.display = 'none';
	RetornaObjeto('DivMensagemCadastro').innerHTML = '';
	HttpRequestFormulario.open('POST',url,true);
	HttpRequestFormulario.setRequestHeader('Content-Type','application/x-www-form-urlencoded;');
	HttpRequestFormulario.onreadystatechange=VerificaAlteracaoDeEstado_Formulario;
	HttpRequestFormulario.send(variaveis);
}
function VerificaAlteracaoDeEstado_Formulario()
{
	if(HttpRequestFormulario.readyState!=4){return;}
	CadastrarNovo();
	FormularioMensagemCadastro(HttpRequestFormulario.responseText);
}
function PesquisaListagem(url,div,metodo,variaveis)
{
	g_PesquisaListagem = div;
	HttpRequest_PesquisaListagem.open(metodo,url,true);
	HttpRequest_PesquisaListagem.setRequestHeader('Content-Type','application/x-www-form-urlencoded;');
	HttpRequest_PesquisaListagem.onreadystatechange=VerificaAlteracaoDeEstado_PesquisaListagem;
	HttpRequest_PesquisaListagem.send(variaveis);
}
function VerificaAlteracaoDeEstado_PesquisaListagem()
{
	if(HttpRequest_PesquisaListagem.readyState!=4){return;}
		document.getElementById(gDivPesquisaListagem).innerHTML = HttpRequest_PesquisaListagem.responseText;
}

var g_div_A = '';
var g_div_B = '';
var g_divFormulario = '';
var g_PesquisaListagem = '';
var HttpRequest_A = CriarObjetoHttpRequest();
var HttpRequest_B = CriarObjetoHttpRequest();
var HttpRequestFormulario = CriarObjetoHttpRequest();
var HttpRequest_PesquisaListagem = CriarObjetoHttpRequest();
var g_CarregandoHorizontalGrande = '<div style="width:288px; padding:30px;" align="center"><img src="imagens/AjaxLoading_A.gif" vspace="30" /></div>';