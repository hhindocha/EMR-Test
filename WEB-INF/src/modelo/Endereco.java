package modelo;

public class Endereco{
	private int cdEndereco;	
	private String nrEndereco     = "";
	private String dsLogradouro = "";
	private Municipio municipio;
	
	public Endereco(){		
	}

	public int getCdEndereco() {
		return cdEndereco;
	}

	public void setCdEndereco(int cdEndereco) {
		this.cdEndereco = cdEndereco;
	}

	public String getDsLogradouro() {
		return dsLogradouro;
	}

	public void setDsLogradouro(String dsLogradouro) {
		this.dsLogradouro = dsLogradouro;
	}

	public String getNrEndereco() {
		return nrEndereco;
	}

	public void setNrEndereco(String nrEndereco) {
		this.nrEndereco = nrEndereco;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	 
}
