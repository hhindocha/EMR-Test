package modelo;

public class Paciente {
	
	private Domicilio domicilio;
	private int cdPaciente = 0;
	private String nmPaciente = "";
	private String dtNascimento = "";
	private String dsTelefoneCel = "";
	private String nmMae = "";
	private String tpSexo = "";
	private String idStatus = "";
	
	public Paciente(){}
	
	public int getCdPaciente() {
		return cdPaciente;
	}
	public void setCdPaciente(int cdPaciente) {
		this.cdPaciente = cdPaciente;
	}
	public String getDsTelefoneCel() {
		return dsTelefoneCel;
	}
	public void setDsTelefoneCel(String dsTelefoneCel) {
		this.dsTelefoneCel = dsTelefoneCel;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}
	public String getNmMae() {
		return nmMae;
	}
	public void setNmMae(String nmMae) {
		this.nmMae = nmMae;
	}
	public String getNmPaciente() {
		return nmPaciente;
	}
	public void setNmPaciente(String nmPaciente) {
		this.nmPaciente = nmPaciente;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	public String getTpSexo() {
		return tpSexo;
	}
	public void setTpSexo(String tpSexo) {
		this.tpSexo = tpSexo;
	}

}
