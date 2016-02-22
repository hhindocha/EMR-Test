package modelo;
/**
 *<b>Autor: </b> Rafael Kloss<br>
 *<b>Data: </b> 11/10/2006<br>
 *<b>:Modificado: </b><br> 
 *<b>Descrição: </b>Esta classe é a classe pai de todas as classes de atendimento <br>
 *<b>todos os métodos genéricos e comuns a atendimentos estão aqui.<br>	 	
*/
abstract class Atendimento{	
	private int cdAtendimento;
	private Paciente paciente;	
	private Profissional profissional;	
	private Estabelecimento estabelecimento;	
	private String dtAtendimento = "";
	private String dsAtendimento = "";
	
	public int getCdAtendimento() {
		return cdAtendimento;
	}
	public void setCdAtendimento(int cdAtendimento) {
		this.cdAtendimento = cdAtendimento;
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
	public Profissional getProfissional() {
		return profissional;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
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
}
