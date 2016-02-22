package modelo;

public class Atendimento{	
	private int cdAtendimento;
	private Paciente paciente;	
	private Profissional profissional;	
	private Estabelecimento estabelecimento;	
	private String dtAtendimento = "";
	private String dsAtendimento = "";
	private Procedimento procedimento;
	private String tpConsulta;
	private String dsQueixa;
	private Cid cid;
	public int getCdAtendimento() {
		return cdAtendimento;
	}
	public void setCdAtendimento(int cdAtendimento) {
		this.cdAtendimento = cdAtendimento;
	}
	public Cid getCid() {
		return cid;
	}
	public void setCid(Cid cid) {
		this.cid = cid;
	}
	public String getDsAtendimento() {
		return dsAtendimento;
	}
	public void setDsAtendimento(String dsAtendimento) {
		this.dsAtendimento = dsAtendimento;
	}
	public String getDtAtendimento() {
		return dtAtendimento;
	}
	public void setDtAtendimento(String dtAtendimento) {
		this.dtAtendimento = dtAtendimento;
	}
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Procedimento getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}
	public Profissional getProfissional() {
		return profissional;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	public String getTpConsulta() {
		return tpConsulta;
	}
	public void setTpConsulta(String tpConsulta) {
		this.tpConsulta = tpConsulta;
	}
	public String getDsQueixa() {
		return dsQueixa;
	}
	public void setDsQueixa(String dsQueixa) {
		this.dsQueixa = dsQueixa;
	}
}
