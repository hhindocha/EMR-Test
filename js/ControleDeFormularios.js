var gFormCampos = null;
var gFormCamposRequeridos = null;
var gFormCamposRequeridosNome = null;
var gPaginaPostar = null;
function FormularioInicio()
{
	switch (gPaginaAtual)
	{
		case 'Cid':
			gFormCampos = new Array('cdCid','dsCid','idStatus');
			gFormCamposRequeridos = new Array('dsCid','idStatus');
			gFormCamposRequeridosNome = new Array('Descrição','Estado');
			gPaginaPostar = 'Cadastro.Cid';
			break;
		case 'Procedimento':
			gFormCampos = new Array('cdProcedimento','dsProcedimento','idStatus');
			gFormCamposRequeridos = new Array('dsProcedimento','idStatus');
			gFormCamposRequeridosNome = new Array('Descrição','Estado');
			gPaginaPostar = 'Cadastro.Procedimento';
			break;
		case 'Profissao':
			gFormCampos = new Array('cdProfissao','dsProfissao','dsConselho','idStatus');
			gFormCamposRequeridos = new Array('dsProfissao','dsConselho','idStatus');
			gFormCamposRequeridosNome = new Array('Descrição','Conselho','Estado');
			gPaginaPostar = 'Cadastro.Profissao';
			break;
		case 'Estabelecimento':
			gFormCampos = new Array('cdEstabelecimento','dsEstabelecimento','dsEndereco','dsMunicipio','dsEstado','dsTelefone','idStatus');
			gFormCamposRequeridos = new Array('dsEstabelecimento','dsEndereco','dsMunicipio','dsEstado','dsTelefone','idStatus');
			gFormCamposRequeridosNome = new Array('Descrição','Endereço','Município','UF','Telefone','Estado');
			gPaginaPostar = 'Cadastro.Estabelecimento';
			break;
		case 'Domicilio':
			gFormCampos = new Array('cdDomicilio','cdEstabelecimento','dsLogradouro','dsBairro','dsMunicipio','dsEstado','dsTelefone','idStatus');
			gFormCamposRequeridos = new Array('cdEstabelecimento','dsLogradouro','dsBairro','dsMunicipio','dsEstado','dsTelefone','idStatus');
			gFormCamposRequeridosNome = new Array('Estabelecimento','Logradouro','Bairro','Município','UF','Telefone','Estado');
			gPaginaPostar = 'Cadastro.Domicilio';
			break;
		case 'Profissional':
			gFormCampos = new Array('cdProfissional','nmProfissional','cdProfissao','dsLogin','dsSenha','dtNacimento','dsCPF','nmMae','tpSexo','idStatus');
			gFormCamposRequeridos = new Array('nmProfissional','cdProfissao','dsLogin','dsSenha','dtNacimento','dsCPF','nmMae','tpSexo','idStatus');
			gFormCamposRequeridosNome = new Array('Nome','Profissão','Login','Senha','Nascimento','CPF','Nome da mãe','Sexo','Estado');
			gPaginaPostar = 'Cadastro.Profissional';
			break;
		case 'Paciente':
			gFormCampos = new Array('cdPaciente','nmPaciente','cdDomicilio','dtNacimento','dsTelefoneCel','nmMae','tpSexo','idStatus');
			gFormCamposRequeridos = new Array('nmPaciente','cdDomicilio','dtNacimento','dsTelefoneCel','nmMae','tpSexo','idStatus');
			gFormCamposRequeridosNome = new Array('Nome','Domicílio','Nascimento','Telefone','Nome da mãe','Sexo','Estado');
			gPaginaPostar = 'Cadastro.Paciente';
			break;
		default:
			alert("Essa opção do menu ainda não foi implementada!")
	}

}
function FormularioLimpar()
{
	RetornaObjeto('DivFormularioAlerta').innerHTML = '';
	document.cadastro.reset();
}
function FormularioSalvar()
{
	var tudoOk = true;
	RetornaObjeto('DivFormularioAlerta').innerHTML = '';
	for(i=0;i<gFormCamposRequeridos.length;i++)
	{
		if(eval("document.cadastro." + gFormCamposRequeridos[i]).value=='' || eval("document.cadastro." + gFormCamposRequeridos[i]).value==0)
		{
			FormularioAlerta(gFormCamposRequeridosNome[i])
			eval("document.cadastro." + gFormCamposRequeridos[i]).focus();
			tudoOk = false;
			break;
		}
	}
	if(tudoOk == true )
	{
		var variaveis = 'dsAcao=cadastrar';
		for(i=0;i<gFormCampos.length;i++)
			variaveis += '&'+ gFormCampos[i] + '=' + escape(eval("document.cadastro." + gFormCampos[i]).value);
		PostarFormulario(gPaginaPostar,'DivCorpoLateralEsquerda',variaveis);
	}
}
function FormularioCancelar()
{
	CadastrarNovo();
}
function FormularioAlerta(NomeDoCampo)
{
	RetornaObjeto('DivFormularioAlerta').innerHTML ='<div id="DivMensagemAlerta" align="center">O campo <b>' + NomeDoCampo + '</b> não pode ficar vazio!</div>'
}
function FormularioMensagemCadastro(Retorno)
{
	var Mensagem = '';
	switch (Retorno)
	{
		case 'cadastrado':
			Mensagem = 'Cadastrado com sucesso!';
			break;
		case 'atualizado':
			Mensagem = 'Atualizado com sucesso!';
			break;
		case 'excluido':
			Mensagem = 'Exclu&iacute;do com sucesso!';
			break;
		default:
			Mensagem = Retorno;
	}
	if(Mensagem!='')
	{
		RetornaObjeto('DivMensagemCadastro').style.display = '';
		RetornaObjeto('DivMensagemCadastro').innerHTML = Mensagem;
		ChamarPesquisaListagem();
	}
}