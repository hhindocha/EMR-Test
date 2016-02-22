package modelo;

public class Profissao {
	private int cdProfissao = 0;
	private String dsProfissao = "";
	private String dsConselho = "";;
	private String idStatus;

	public Profissao(){		
	}

	public int getCdProfissao() {
		return cdProfissao;
	}

	public void setCdProfissao(int cdProfissao) {
		this.cdProfissao = cdProfissao;
	}

	public String getDsProfissao() {
		return dsProfissao;
	}

	public void setDsProfissao(String dsProfissao) {
		this.dsProfissao = dsProfissao;
	}

	public String getDsConselho() {
		return dsConselho;
	}

	public void setDsConselho(String dsConselho) {
		this.dsConselho = dsConselho;
	}
	
	public String getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}
}
