package modelo;

public class Profissional {
	
	private Profissao profissao;
	private int cdProfissional = 0;
	private String dsLogin = "";
	private String dsSenha = "";
	private String nmProfissional = "";
	private String dtNascimento = "";
	private String dsCPF = "";
	private String nmMae = "";
	private String tpSexo = "";
	private String idStatus = "";
	
	public Profissional(){}
	
	public int getCdProfissional() {
		return cdProfissional;
	}
	public void setCdProfissional(int cdProfissional) {
		this.cdProfissional = cdProfissional;
	}
	public String getDsCPF() {
		return dsCPF;
	}
	public void setDsCPF(String dsCPF) {
		this.dsCPF = dsCPF;
	}
	public String getDsLogin() {
		return dsLogin;
	}
	public void setDsLogin(String dsLogin) {
		this.dsLogin = dsLogin;
	}
	public String getDsSenha() {
		return dsSenha;
	}
	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
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
	public String getNmProfissional() {
		return nmProfissional;
	}
	public void setNmProfissional(String nmProfissional) {
		this.nmProfissional = nmProfissional;
	}
	public Profissao getProfissao() {
		return profissao;
	}
	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	public String getTpSexo() {
		return tpSexo;
	}
	public void setTpSexo(String tpSexo) {
		this.tpSexo = tpSexo;
	}

}
