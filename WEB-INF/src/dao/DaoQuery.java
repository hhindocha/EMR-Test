package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import util.Data;
import util.Util;

import modelo.Cid;
import modelo.Paciente;
import modelo.Profissao;
import modelo.Estabelecimento;
import modelo.Procedimento;
import modelo.Domicilio;
import modelo.Profissional;
import modelo.Fila;
import modelo.Atendimento;


/**
 *<b>Nome: </b>DaoQuery<br>
 *<b>Autor: </b> Rafael Kloss<br>
 *<b>Data: </b> 13/10/2006<br>
 *<b>Função: </b> Esta classe tem a função de realizar todas as queryes do sistema<br>	 	 	
*/
public class DaoQuery extends SuperDao {
	public ResultSet res = null;
	/**
	 *<b>Autor: </b> Rafael Kloss<br>
	 *<b>Data: </b> 13/10/2006<br>
	 *<b>Parâmetros: </b>String dsCid<br>
	 *<b>Tipo do retorno: </b> ArrayList do tipo Cid<br>
	 *<b>Retorno: </b> ArrayList contendo TODOS os cids encontrados de acordo
	 * com o critério fornecido<br>	 	 	
	*/
	public ArrayList cidByDsCid(String dsCid) throws Exception{
		ArrayList cidByDsCid = new ArrayList();
		StringBuffer query = new StringBuffer();
		query.append("select * from CID ");
		if(!"*".trim().equals(dsCid) && !"|s|".trim().equals(dsCid))
		{
			query.append(" where dsCid ");
			query.append("like '%"+dsCid+"%'");
		}
		if("|s|".trim().equals(dsCid) )
		{
			query.append(" where idStatus = 'A' ");
		}
		query.append(" order by dsCid");
		res = super.executeQuery(query.toString());
		while(res.next()){
			Cid cid = new Cid();			
			cid.setCdCid(res.getInt("cdCid"));
			cid.setDsCid(res.getString("dsCid"));
			cid.setIdStatus(res.getString("idStatus"));
			cidByDsCid.add(cid);
		}
		super.desconecta();
		return cidByDsCid;
	}
	
	public Cid cidById(int cdCid) throws Exception
	{
		res = super.executeQuery("select * from CID where cdCid=" + cdCid);
		Cid cid = new Cid();
		if(res.next())
		{
			cid.setCdCid(res.getInt("cdCid"));
			cid.setDsCid(res.getString("dsCid"));
			cid.setIdStatus(res.getString("idStatus"));
		}
		super.desconecta();
		return cid;
	}
	public ArrayList procedimentoByDsProcedimento(String dsProcedimento) throws Exception{
		ArrayList procedimentoByDsProcedimento = new ArrayList();
		StringBuffer query = new StringBuffer();
		query.append("select * from PROCEDIMENTO ");
		if(!"*".trim().equals(dsProcedimento) && !"|s|".trim().equals(dsProcedimento) )
		{
			query.append(" where dsProcedimento ");
			query.append("like '%"+dsProcedimento+"%'");
		}
		if("|s|".trim().equals(dsProcedimento) )
		{
			query.append(" where idStatus = 'A' ");
		}
		query.append(" order by dsProcedimento");
		res = super.executeQuery(query.toString());
		while(res.next()){
			Procedimento procedimento = new Procedimento();			
			procedimento.setCdProcedimento(res.getInt("cdProcedimento"));
			procedimento.setDsProcedimento(res.getString("dsProcedimento"));
			procedimento.setIdStatus(res.getString("idStatus"));
			procedimentoByDsProcedimento.add(procedimento);
		}
		super.desconecta();
		return procedimentoByDsProcedimento;
	}
	
	public Procedimento procedimentoById(int cdProcedimento) throws Exception
	{
		res = super.executeQuery("select * from PROCEDIMENTO where cdProcedimento=" + cdProcedimento);
		Procedimento procedimento = new Procedimento();
		if(res.next())
		{
			procedimento.setCdProcedimento(res.getInt("cdProcedimento"));
			procedimento.setDsProcedimento(res.getString("dsProcedimento"));
			procedimento.setIdStatus(res.getString("idStatus"));
		}
		super.desconecta();
		return procedimento;
	}

	public ArrayList profissaoByDsProfissao(String dsProfissao) throws Exception{
		ArrayList profissaoByDsProfissao = new ArrayList();
		StringBuffer query = new StringBuffer();
		query.append("select * from PROFISSAO ");
		if(!"*".trim().equals(dsProfissao) && !"|s|".trim().equals(dsProfissao))
		{
			query.append(" where dsProfissao ");
			query.append("like '%"+dsProfissao+"%'");
		}
		if("|s|".trim().equals(dsProfissao) )
		{
			query.append(" where idStatus = 'A' ");
		}
		query.append(" order by dsProfissao");
		res = super.executeQuery(query.toString());
		while(res.next()){
			Profissao profissao = new Profissao();			
			profissao.setCdProfissao(res.getInt("cdProfissao"));
			profissao.setDsProfissao(res.getString("dsProfissao"));
			profissao.setIdStatus(res.getString("idStatus"));
			profissaoByDsProfissao.add(profissao);
		}
		super.desconecta();
		return profissaoByDsProfissao;
	}
	
	public Profissao profissaoById(int cdProfissao) throws Exception
	{
		res = super.executeQuery("select * from PROFISSAO where cdProfissao=" + cdProfissao);
		Profissao profissao = new Profissao();
		if(res.next())
		{
			profissao.setCdProfissao(res.getInt("cdProfissao"));
			profissao.setDsProfissao(res.getString("dsProfissao"));
			profissao.setDsConselho(res.getString("dsConselho"));
			profissao.setIdStatus(res.getString("idStatus"));
		}
		super.desconecta();
		return profissao;
	}
	
	public ArrayList estabelecimentoByDsEstabelecimento(String dsEstabelecimento) throws Exception{
		ArrayList estabelecimentoByDsEstabelecimento = new ArrayList();
		StringBuffer query = new StringBuffer();
		query.append("select * from ESTABELECIMENTO ");
		if(!"*".trim().equals(dsEstabelecimento) && !"|s|".trim().equals(dsEstabelecimento))
		{
			query.append(" where dsEstabelecimento ");
			query.append("like '%"+dsEstabelecimento+"%'");
		}
		if("|s|".trim().equals(dsEstabelecimento) )
		{
			query.append(" where idStatus = 'A' ");
		}
		query.append(" order by dsEstabelecimento");
		res = super.executeQuery(query.toString());
		while(res.next()){
			Estabelecimento estabelecimento = new Estabelecimento();			
			estabelecimento.setCdEstabelecimento(res.getInt("cdEstabelecimento"));
			estabelecimento.setDsEstabelecimento(res.getString("dsEstabelecimento"));
			estabelecimento.setIdStatus(res.getString("idStatus"));
			estabelecimentoByDsEstabelecimento.add(estabelecimento);
		}
		super.desconecta();
		return estabelecimentoByDsEstabelecimento;
	}
	
	public Estabelecimento estabelecimentoById(int cdEstabelecimento) throws Exception
	{
		res = super.executeQuery("select * from ESTABELECIMENTO where cdEstabelecimento=" + cdEstabelecimento);
		Estabelecimento estabelecimento = new Estabelecimento();
		if(res.next())
		{
			estabelecimento.setCdEstabelecimento(res.getInt("cdEstabelecimento"));
			estabelecimento.setDsEstabelecimento(res.getString("dsEstabelecimento"));
			estabelecimento.setDsEndereco(res.getString("dsEndereco"));
			estabelecimento.setDsMunicipio(res.getString("dsMunicipio"));
			estabelecimento.setDsEstado(res.getString("dsEstado"));
			estabelecimento.setDsTelefone(res.getString("dsTelefone"));
			estabelecimento.setIdStatus(res.getString("idStatus"));

		}
		super.desconecta();
		return estabelecimento;
	}
	
	public ArrayList domicilioByDsDomicilio(String dsLogradouro) throws Exception{
		ArrayList domicilioByDsDomicilio = new ArrayList();
		StringBuffer query = new StringBuffer();
		query.append("select * from DOMICILIO ");
		if(!"*".trim().equals(dsLogradouro) && !"|s|".trim().equals(dsLogradouro))
		{
			query.append(" where dsLogradouro ");
			query.append("like '%"+dsLogradouro+"%'");
		}
		if("|s|".trim().equals(dsLogradouro) )
		{
			query.append(" where idStatus = 'A' ");
		}
		query.append(" order by dsLogradouro");
		res = super.executeQuery(query.toString());
		while(res.next()){
			Domicilio domicilio = new Domicilio();			
			domicilio.setCdDomicilio(res.getInt("cdDomicilio"));
			domicilio.setDsLogradouro(res.getString("dsLogradouro"));
			domicilio.setIdStatus(res.getString("idStatus"));
			domicilioByDsDomicilio.add(domicilio);
		}
		super.desconecta();
		return domicilioByDsDomicilio;
	}
	
	public Domicilio domicilioById(int cdDomicilio) throws Exception
	{
		res = super.executeQuery("select * from DOMICILIO where cdDomicilio=" + cdDomicilio);
		Domicilio domicilio = new Domicilio();
		if(res.next())
		{
			domicilio.setCdDomicilio(res.getInt("cdDomicilio"));
			Estabelecimento estabelecimento;
			domicilio.setDsLogradouro(res.getString("dsLogradouro"));
			domicilio.setDsBairro(res.getString("dsBairro"));
			domicilio.setDsMunicipio(res.getString("dsMunicipio"));
			domicilio.setDsEstado(res.getString("dsEstado"));
			domicilio.setDsTelefone(res.getString("dsTelefone"));
			domicilio.setIdStatus(res.getString("idStatus"));
			estabelecimento = this.estabelecimentoById(res.getInt("cdEstabelecimento"));
			domicilio.setEstabelecimento(estabelecimento);
		}
		super.desconecta();
		return domicilio;
	}
	public Profissional profissionalById(int cdProfissional) throws Exception
	{
		res = super.executeQuery("select *, DATE_FORMAT(dtNascimento,'%d/%m/%Y') as dtNascimentoFormatada from PROFISSIONAL where cdProfissional=" + cdProfissional);
		Profissional profissional = new Profissional();
		if(res.next())
		{
			Data data = new Data();
			profissional.setCdProfissional(res.getInt("cdProfissional"));
			Profissao profissao;
			profissional.setDsCPF(res.getString("dsCPF"));
			profissional.setDsLogin(res.getString("dsLogin"));
			profissional.setDsSenha(res.getString("dsSenha"));
			profissional.setDtNascimento(res.getString("dtNascimentoFormatada"));
			profissional.setNmMae(res.getString("nmMae"));
			profissional.setNmProfissional(res.getString("nmProfissional"));
			profissional.setTpSexo(res.getString("tpSexo"));
			profissional.setIdStatus(res.getString("idStatus"));
			profissao = this.profissaoById(res.getInt("cdProfissao"));
			profissional.setProfissao(profissao);
		}
		super.desconecta();
		return profissional;
	}
	public ArrayList profissionalByNmProfissional(String nmProfissional) throws Exception{
		ArrayList profissionalByDsProfissional = new ArrayList();
		StringBuffer query = new StringBuffer();
		query.append("select * from PROFISSIONAL ");
		if(!"*".trim().equals(nmProfissional) && !"|s|".trim().equals(nmProfissional))
		{
			query.append(" where nmProfissional ");
			query.append("like '%"+nmProfissional+"%'");
		}
		if("|s|".trim().equals(nmProfissional) )
		{
			query.append(" where idStatus = 'A' ");
		}
		query.append(" order by nmProfissional");
		res = super.executeQuery(query.toString());
		while(res.next()){
			Profissional profissional = new Profissional();			
			profissional.setCdProfissional(res.getInt("cdProfissional"));
			profissional.setNmProfissional(res.getString("nmProfissional"));
			profissional.setIdStatus(res.getString("idStatus"));
			profissionalByDsProfissional.add(profissional);
		}
		super.desconecta();
		return profissionalByDsProfissional;
	}
	public Paciente pacienteById(int cdPaciente) throws Exception
	{
		res = super.executeQuery("select *, DATE_FORMAT(dtNascimento,'%d/%m/%Y') as dtNascimentoFormatada from PACIENTE where cdPaciente=" + cdPaciente);
		Paciente paciente = new Paciente();
		if(res.next())
		{
			paciente.setCdPaciente(res.getInt("cdPaciente"));
			Domicilio domicilio;
			paciente.setDsTelefoneCel(res.getString("dsTelefoneCel"));
			paciente.setDtNascimento(res.getString("dtNascimentoFormatada"));
			paciente.setNmMae(res.getString("nmMae"));
			paciente.setNmPaciente(res.getString("nmPaciente"));
			paciente.setTpSexo(res.getString("tpSexo"));
			paciente.setIdStatus(res.getString("idStatus"));
			domicilio = this.domicilioById(res.getInt("cdDomicilio"));
			paciente.setDomicilio(domicilio);
		}
		super.desconecta();
		return paciente;
	}
	public ArrayList pacienteByNmPaciente(String nmPaciente) throws Exception{
		ArrayList pacienteByDsPaciente = new ArrayList();
		StringBuffer query = new StringBuffer();
		query.append("select * from PACIENTE ");
		if(!"*".trim().equals(nmPaciente) && !"|s|".trim().equals(nmPaciente))
		{
			query.append(" where nmPaciente ");
			query.append("like '%"+nmPaciente+"%'");
		}
		if("|s|".trim().equals(nmPaciente) )
		{
			query.append(" where idStatus = 'A' ");
		}
		query.append(" order by nmPaciente");
		res = super.executeQuery(query.toString());
		while(res.next()){
			Paciente paciente = new Paciente();			
			paciente.setCdPaciente(res.getInt("cdPaciente"));
			paciente.setNmPaciente(res.getString("nmPaciente"));
			paciente.setIdStatus(res.getString("idStatus"));
			pacienteByDsPaciente.add(paciente);
		}
		super.desconecta();
		return pacienteByDsPaciente;
	}
	public ArrayList pacientesNaFila(int cdEstabelecimento, String idStatus) throws Exception{
		ResultSet resultInterno;
		ArrayList pacientesNaFila = new ArrayList();
		StringBuffer query = new StringBuffer();
		query.append("select *, DATE_FORMAT(dtFila,'%d/%m/%Y - %H:%i:%s') as dtFilaFormatada from FILA where cdEstabelecimento ='"+cdEstabelecimento+"' AND idStatus='"+idStatus+"'");
		query.append(" order by cdFila ASC");
		resultInterno = super.executeQuery(query.toString());
		while(resultInterno.next()){
			Fila fila = new Fila();
			fila.setCdFila(resultInterno.getInt("cdFila"));
			fila.setPaciente(pacienteById(resultInterno.getInt("cdPaciente")));
			fila.setEstabelecimento(estabelecimentoById(resultInterno.getInt("cdEstabelecimento")));
			fila.setDtFila(resultInterno.getString("dtFilaFormatada"));
			fila.setIdStatus(resultInterno.getString("idStatus"));
			pacientesNaFila.add(fila);
		}
		super.desconecta();
		return pacientesNaFila;
	}
	public Fila filaById(int cdFila) throws Exception
	{
		ResultSet resultInterno;
		resultInterno = super.executeQuery("select *, DATE_FORMAT(dtFila,'%d/%m/%Y - %H:%i:%s') as dtFilaFormatada from FILA where cdFila = " + cdFila);
		Fila fila = new Fila();
		if(resultInterno.next())
		{
			fila.setCdFila(resultInterno.getInt("cdFila"));
			fila.setIdStatus(resultInterno.getString("idStatus"));
			fila.setDtFila(resultInterno.getString("dtFilaFormatada"));
			Paciente paciente = pacienteById(resultInterno.getInt("cdPaciente"));
			Estabelecimento estabelecimento = estabelecimentoById(resultInterno.getInt("cdEstabelecimento"));
			fila.setEstabelecimento(estabelecimento);
			fila.setPaciente(paciente);
		}
		super.desconecta();
		return fila;
	}
	public ArrayList atendimentoByPaciente(int cdPaciente) throws Exception{
		ResultSet resultInterno;
		ArrayList atendimentos = new ArrayList();
		StringBuffer query = new StringBuffer();
		query.append("select *, DATE_FORMAT(dtAtendimento,'%d/%m/%Y - %H:%i:%s') as dtAtendimentoFormatada from ATENDIMENTO where cdPaciente ='"+cdPaciente+"'");
		query.append(" order by cdAtendimento DESC");
		resultInterno = super.executeQuery(query.toString());
		while(resultInterno.next()){
			Atendimento atendimento = new Atendimento();
			atendimento.setCdAtendimento(resultInterno.getInt("cdAtendimento"));
			atendimento.setEstabelecimento(this.estabelecimentoById(resultInterno.getInt("cdEstabelecimento")));
			atendimento.setPaciente(this.pacienteById(resultInterno.getInt("cdPaciente")));
			atendimento.setProfissional(this.profissionalById(resultInterno.getInt("cdProfissional")));
			atendimento.setProcedimento(this.procedimentoById(resultInterno.getInt("cdProcedimento")));
			atendimento.setCid(this.cidById(resultInterno.getInt("cdCid")));
			atendimento.setDtAtendimento(resultInterno.getString("dtAtendimentoFormatada"));
			atendimento.setDsAtendimento(resultInterno.getString("dsAtendimento"));
			atendimento.setTpConsulta(resultInterno.getString("tpConsulta"));
			atendimento.setDsQueixa(resultInterno.getString("dsQueixa"));
			atendimentos.add(atendimento);
		}
		super.desconecta();
		return atendimentos;
	}
}
