package modelo;

abstract class Pessoa {
	private String nmPessoa = "";
	private String nmMae = "";
	private String dtNascimento = "";
	private String tpSexo = "";
	private String telefoneRes = "";
	private String telefoneCel = "";	
	private double nrCpf;	
	private int cdPessoa;
		
	public int getCdPessoa() {
		return cdPessoa;
	}
	public void setCdPessoa(int cdPessoa) {
		this.cdPessoa = cdPessoa;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getNmMae() {
		return nmMae;
	}
	public void setNmMae(String nmMae) {
		this.nmMae = nmMae;
	}
	public String getNmPessoa() {
		return nmPessoa;
	}
	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}
	public double getNrCpf() {
		return nrCpf;
	}
	public void setNrCpf(double nrCpf) {
		this.nrCpf = nrCpf;
	}
	public String getTelefoneCel() {
		return telefoneCel;
	}
	public void setTelefoneCel(String telefoneCel) {
		this.telefoneCel = telefoneCel;
	}
	public String getTelefoneRes() {
		return telefoneRes;
	}
	public void setTelefoneRes(String telefoneRes) {
		this.telefoneRes = telefoneRes;
	}
	public String getTpSexo() {
		return tpSexo;
	}
	public void setTpSexo(String tpSexo) {
		this.tpSexo = tpSexo;
	}	
}
