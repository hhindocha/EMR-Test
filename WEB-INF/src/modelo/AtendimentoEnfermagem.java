package modelo;

public class AtendimentoEnfermagem extends Atendimento{
	private String dsQueixa = "";
	
	/**
	 *<b>Autor: </b> Rafael Kloss<br>
	 *<b>Data: </b> 11/10/2006<br>
	 *<b>Método Construtor<br>	 	 	
	*/
	public AtendimentoEnfermagem(){		
	}
	
	public String getDsQueixa() {
		return dsQueixa;
	}

	public void setDsQueixa(String dsQueixa) {
		this.dsQueixa = dsQueixa;
	}

}
