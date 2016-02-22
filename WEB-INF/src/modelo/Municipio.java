package modelo;

public class Municipio {
	private int cdMunicipio;
	private String dsMunicipio = "";
	private Uf uf;
	
	public Municipio(){		
	}

	public int getCdMunicipio() {
		return cdMunicipio;
	}

	public void setCdMunicipio(int cdMunicipio) {
		this.cdMunicipio = cdMunicipio;
	}

	public String getDsMunicipio() {
		return dsMunicipio;
	}

	public void setDsMunicipio(String dsMunicipio) {
		this.dsMunicipio = dsMunicipio;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

}
