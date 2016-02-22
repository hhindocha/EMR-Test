var ItensMenu = new Array();
ItensMenu.push('Profissional');
ItensMenu.push('Paciente');
ItensMenu.push('Cid');
ItensMenu.push('Procedimento');
ItensMenu.push('Estabelecimento');
ItensMenu.push('Profissao');
ItensMenu.push('Domicilio');
ItensMenu.push('Fila');
function VoltaItensMenu()
{
	for(i=0;i<ItensMenu.length;i++)
		RetornaObjeto(ItensMenu[i]).src = 'imagens/Icone'+ ItensMenu[i] +'.gif';
}
function IndicaIcone(Icone)
{
	VoltaItensMenu()
	Icone.src = 'imagens/Icone'+ Icone.id +'_o.gif';
	RetornaObjeto('DivCorpoMenuDescricao').innerHTML = Icone.alt;
}