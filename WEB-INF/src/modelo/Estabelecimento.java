package modelo;

public class Estabelecimento {
	private int cdEstabelecimento = 0;	
	private String dsEstabelecimento = "";
	private String dsEndereco = "";
	private String dsMunicipio = "";
	private String dsEstado = "";
	private String dsTelefone = "";
	private String idStatus;

	public Estabelecimento(){		
	}
	
	public int getCdEstabelecimento() {
		return cdEstabelecimento;
	}

	public void setCdEstabelecimento(int cdEstabelecimento) {
		this.cdEstabelecimento = cdEstabelecimento;
	}

	public String getDsEndereco() {
		return dsEndereco;
	}

	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}

	public String getDsEstabelecimento() {
		return dsEstabelecimento;
	}

	public void setDsEstabelecimento(String dsEstabelecimento) {
		this.dsEstabelecimento = dsEstabelecimento;
	}

	public String getDsEstado() {
		return dsEstado;
	}

	public void setDsEstado(String dsEstado) {
		this.dsEstado = dsEstado;
	}

	public String getDsMunicipio() {
		return dsMunicipio;
	}

	public void setDsMunicipio(String dsMunicipio) {
		this.dsMunicipio = dsMunicipio;
	}

	public String getDsTelefone() {
		return dsTelefone;
	}

	public void setDsTelefone(String dsTelefone) {
		this.dsTelefone = dsTelefone;
	}

	public String getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}
}
