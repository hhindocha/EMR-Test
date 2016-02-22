package modelo;

public class Domicilio {	
	private Estabelecimento estabelecimento;
	private int cdDomicilio = 0;
	private String dsLogradouro = "";
	private String dsBairro = "";
	private String dsMunicipio = "";
	private String dsEstado = "";
	private String dsTelefone = "";
	private String idStatus;
	public Domicilio() {
	}

	public int getCdDomicilio() {
		return cdDomicilio;
	}
	public void setCdDomicilio(int cdDomicilio) {
		this.cdDomicilio = cdDomicilio;
	}
	public String getDsBairro() {
		return dsBairro;
	}
	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}
	public String getDsEstado() {
		return dsEstado;
	}
	public void setDsEstado(String dsEstado) {
		this.dsEstado = dsEstado;
	}
	public String getDsLogradouro() {
		return dsLogradouro;
	}
	public void setDsLogradouro(String dsLogradouro) {
		this.dsLogradouro = dsLogradouro;
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
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public String getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}

	
}
