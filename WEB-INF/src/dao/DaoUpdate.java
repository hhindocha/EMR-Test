package dao;

import modelo.Cid;
import modelo.Profissao;
import modelo.Estabelecimento;
import modelo.Domicilio;
import modelo.Procedimento;
import modelo.Profissional;
import modelo.Paciente;

import util.Data;

/**
 * <b>Nome: </b>DaoUpdate<br>
 * <b>Autor: </b> Rafael Kloss<br>
 * <b>Data: </b> 13/10/2006<br>
 * <b>Função: </b> Esta classe tem a função de realizar todos os<br>
 * inserts, update e delete do sistema<br>
 */
public class DaoUpdate extends SuperDao {		

	public int cidSalva(Cid cid) throws Exception {
		StringBuffer query = new StringBuffer();
		if(cid.getCdCid()>0)
		{
			query.append("update CID set");		
			query.append(" dsCid = '"+cid.getDsCid()+"',");
			query.append(" idStatus = '"+cid.getIdStatus()+"'");
			query.append(" where cdCid = "+cid.getCdCid());
		}
		else
		{
			query.append("insert into CID");
			query.append(" (cdCid, dsCid, idStatus)");
			query.append("  values");
			query.append(" (null,'" + cid.getDsCid()+ "','" + cid.getIdStatus() + "')");			
		}
		return super.executeUpdate(query.toString());
	}
	public int cidExcluir(Cid cid) throws Exception {
		StringBuffer query = new StringBuffer();
		query.append("update CID set idStatus = 'I'");
		//query.append("delete from CID");
		query.append(" where cdCid = "+cid.getCdCid());
		return super.executeUpdate(query.toString());
	}
	public int procedimentoSalva(Procedimento procedimento) throws Exception {
		StringBuffer query = new StringBuffer();
		if(procedimento.getCdProcedimento()>0)
		{
			query.append("update PROCEDIMENTO set");		
			query.append(" dsProcedimento = '"+procedimento.getDsProcedimento()+"',");
			query.append(" idStatus = '"+procedimento.getIdStatus()+"'");
			query.append(" where cdProcedimento = "+procedimento.getCdProcedimento());
		}
		else
		{
			query.append("insert into PROCEDIMENTO");
			query.append(" (cdProcedimento, dsProcedimento,idStatus)");
			query.append("  values");
			query.append(" (null,'" + procedimento.getDsProcedimento()+ "','" + procedimento.getIdStatus()+ "')");			
		}
		return super.executeUpdate(query.toString());
	}
	public int procedimentoExcluir(Procedimento procedimento) throws Exception {
		StringBuffer query = new StringBuffer();
		//query.append("delete from PROCEDIMENTO");
		query.append("update PROCEDIMENTO set idStatus = 'I'");
		query.append(" where cdProcedimento = "+procedimento.getCdProcedimento());
		return super.executeUpdate(query.toString());
	}
	
	public int profissaoSalva(Profissao profissao) throws Exception {
		StringBuffer query = new StringBuffer();
		if(profissao.getCdProfissao()>0)
		{
			query.append("update PROFISSAO set");		
			query.append(" dsProfissao = '"+profissao.getDsProfissao()+"',");
			query.append(" dsConselho = '"+profissao.getDsConselho()+"',");
			query.append(" idStatus = '"+profissao.getIdStatus()+"'");
			query.append(" where cdProfissao = "+profissao.getCdProfissao());
		}
		else
		{
			query.append("insert into PROFISSAO");
			query.append(" (cdProfissao, dsProfissao,dsConselho,idStatus)");
			query.append("  values");
			query.append(" (null,'" + profissao.getDsProfissao()+ "','" + profissao.getDsConselho()+ "','" + profissao.getIdStatus()+ "')");			
		}
		return super.executeUpdate(query.toString());
	}
	public int profissaoExcluir(Profissao profissao) throws Exception {
		StringBuffer query = new StringBuffer();
		//query.append("delete from PROFISSAO");
		query.append("update PROFISSAO set idStatus = 'I'");
		query.append(" where cdProfissao = "+profissao.getCdProfissao());
		return super.executeUpdate(query.toString());
	}
	public int estabelecimentoSalva(Estabelecimento estabelecimento) throws Exception {
		StringBuffer query = new StringBuffer();
		if(estabelecimento.getCdEstabelecimento()>0)
		{
			query.append("update ESTABELECIMENTO set");		
			query.append(" dsEstabelecimento = '"+estabelecimento.getDsEstabelecimento()+"',");
			query.append(" dsEndereco = '"+estabelecimento.getDsEndereco()+"',");
			query.append(" dsMunicipio = '"+estabelecimento.getDsMunicipio()+"',");
			query.append(" dsEstado = '"+estabelecimento.getDsEstado()+"',");
			query.append(" dsTelefone = '"+estabelecimento.getDsTelefone()+"',");
			query.append(" idStatus = '"+estabelecimento.getIdStatus()+"'");
			query.append(" where cdEstabelecimento = "+estabelecimento.getCdEstabelecimento());
		}
		else
		{
			query.append("insert into ESTABELECIMENTO");
			query.append(" (cdEstabelecimento,dsEstabelecimento,dsEndereco,dsMunicipio,dsEstado,dsTelefone,idStatus)");
			query.append("  values");
			query.append(" (null,'" + estabelecimento.getDsEstabelecimento()+ "','" + estabelecimento.getDsEndereco()+ "','" + estabelecimento.getDsMunicipio()+ "','" + estabelecimento.getDsEstado()+ "','" + estabelecimento.getDsTelefone()+ "','" + estabelecimento.getIdStatus()+ "')");			
		}
		return super.executeUpdate(query.toString());
	}
	public int estabelecimentoExcluir(Estabelecimento estabelecimento) throws Exception {
		StringBuffer query = new StringBuffer();
		//query.append("delete from ESTABELECIMENTO");
		query.append("update ESTABELECIMENTO set idStatus = 'I'");
		query.append(" where cdEstabelecimento = "+estabelecimento.getCdEstabelecimento());
		return super.executeUpdate(query.toString());
	}
	public int domicilioSalva(Domicilio domicilio) throws Exception {
		StringBuffer query = new StringBuffer();
		if(domicilio.getCdDomicilio()>0)
		{
			query.append("update DOMICILIO set");		
			query.append(" cdEstabelecimento = "+domicilio.getEstabelecimento().getCdEstabelecimento()+",");
			query.append(" dsLogradouro = '"+domicilio.getDsLogradouro()+"',");
			query.append(" dsBairro = '"+domicilio.getDsBairro()+"',");
			query.append(" dsMunicipio = '"+domicilio.getDsMunicipio()+"',");
			query.append(" dsEstado = '"+domicilio.getDsEstado()+"',");
			query.append(" dsTelefone = '"+domicilio.getDsTelefone()+"',");
			query.append(" idStatus = '"+domicilio.getIdStatus()+"'");
			query.append(" where cdDomicilio = "+domicilio.getCdDomicilio());
		}
		else
		{
			query.append("insert into DOMICILIO");
			query.append(" (cdDomicilio, cdEstabelecimento, dsLogradouro, dsBairro, dsMunicipio, dsEstado, dsTelefone, idStatus)");
			query.append("  values");
			query.append(" (null," + domicilio.getEstabelecimento().getCdEstabelecimento()+ ",'" + domicilio.getDsLogradouro() + "','"+domicilio.getDsBairro()+"','"+domicilio.getDsMunicipio()+"','"+domicilio.getDsEstado()+"','"+domicilio.getDsTelefone()+"','"+domicilio.getIdStatus()+"')");			
		}
		return super.executeUpdate(query.toString());
	}
	public int domicilioExcluir(Domicilio domicilio) throws Exception {
		StringBuffer query = new StringBuffer();
		query.append("update DOMICILIO set idStatus = 'I'");
		//query.append("delete from DOMICILIO");
		query.append(" where cdDomicilio = "+domicilio.getCdDomicilio());
		return super.executeUpdate(query.toString());
	}
	public int profissionalSalva(Profissional profissional) throws Exception {
		StringBuffer query = new StringBuffer();
		if(profissional.getCdProfissional()>0)
		{
			query.append("update PROFISSIONAL set");
			query.append(" cdProfissao = "+profissional.getProfissao().getCdProfissao()+",");
			query.append(" dsLogin = '"+profissional.getDsLogin()+"',");
			query.append(" dsSenha = '"+profissional.getDsSenha()+"',");
			query.append(" dtNascimento = '"+profissional.getDtNascimento()+"',");
			query.append(" nmProfissional = '"+profissional.getNmProfissional()+"',");
			query.append(" dsCPF = '"+profissional.getDsCPF()+"',");
			query.append(" nmMae = '"+profissional.getNmMae()+"',");
			query.append(" tpSexo = '"+profissional.getTpSexo()+"',");
			query.append(" idStatus = '"+profissional.getIdStatus()+"'");
			query.append(" where cdProfissional = "+profissional.getCdProfissional());
		}
		else
		{
			query.append("insert into PROFISSIONAL");
			query.append(" (cdProfissional, cdProfissao, dsLogin, dsSenha, dtNascimento, nmProfissional, dsCPF, nmMae, tpSexo, idStatus)");
			query.append("  values");
			query.append(" (null," + profissional.getProfissao().getCdProfissao()+ ",'" + profissional.getDsLogin() + "','"+profissional.getDsSenha()+"','"+profissional.getDtNascimento()+"','"+profissional.getNmProfissional()+"','"+profissional.getDsCPF()+"','"+profissional.getNmMae()+"','"+profissional.getTpSexo()+"','"+profissional.getIdStatus()+"')");
		}
		return super.executeUpdate(query.toString());
	}
	public int profissionalExcluir(Profissional profissional) throws Exception {
		StringBuffer query = new StringBuffer();
		query.append("update PROFISSIONAL set idStatus = 'I'");
		query.append(" where cdProfissional = "+profissional.getCdProfissional());
		return super.executeUpdate(query.toString());
	}
	public int pacienteSalva(Paciente paciente) throws Exception {
		StringBuffer query = new StringBuffer();
		if(paciente.getCdPaciente()>0)
		{
			query.append("update PACIENTE set");
			query.append(" cdDomicilio = "+paciente.getDomicilio().getCdDomicilio()+",");
			query.append(" dtNascimento = '"+paciente.getDtNascimento()+"',");
			query.append(" nmPaciente = '"+paciente.getNmPaciente()+"',");
			query.append(" dsTelefoneCel = '"+paciente.getDsTelefoneCel()+"',");
			query.append(" nmMae = '"+paciente.getNmMae()+"',");
			query.append(" tpSexo = '"+paciente.getTpSexo()+"',");
			query.append(" idStatus = '"+paciente.getIdStatus()+"'");
			query.append(" where cdPaciente = "+paciente.getCdPaciente());
		}
		else
		{
			query.append("insert into PACIENTE");
			query.append(" (cdPaciente, cdDomicilio, dtNascimento, nmPaciente, dsTelefoneCel, nmMae, tpSexo, idStatus)");
			query.append("  values");
			query.append(" (null," + paciente.getDomicilio().getCdDomicilio()+ ",'"+paciente.getDtNascimento()+"','"+paciente.getNmPaciente()+"','"+paciente.getDsTelefoneCel()+"','"+paciente.getNmMae()+"','"+paciente.getTpSexo()+"','"+paciente.getIdStatus()+"')");
		}
		return super.executeUpdate(query.toString());
	}
	public int pacienteExcluir(Paciente paciente) throws Exception {
		StringBuffer query = new StringBuffer();
		query.append("update PACIENTE set idStatus = 'I'");
		query.append(" where cdPaciente = "+paciente.getCdPaciente());
		return super.executeUpdate(query.toString());
	}
}
