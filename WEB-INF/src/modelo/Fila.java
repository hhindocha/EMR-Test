package modelo;

public class Fila {
	private int cdFila;
	private Paciente paciente;
	private Estabelecimento estabelecimento;
	private String dtFila;
	private String idStatus;
	/* Status da fila (cdStatus):
	 * 1 - Fila de atendimento de enfermagem;
	 * 2 - Fila de atendimento m�dico;
	 * 3 - Conclu�do. */
	
	public Fila(){		
	}

	public int getCdFila() {
		return cdFila;
	}

	public void setCdFila(int cdFila) {
		this.cdFila = cdFila;
	}

	/**
	 * <b>Status da fila (cdStatus):</b><br>
	 * 1 - Fila de atendimento de enfermagem;<br>
	 * 2 - Fila de atendimento m�dico;<br>
	 * 3 - Conclu�do.
	 */
	public String getIdStatus() {
		return idStatus;
	}

	/**
	 * <b>Status da fila (IdStatus):</b><br>
	 * 1 - Fila de atendimento de enfermagem;<br>
	 * 2 - Fila de atendimento m�dico;<br>
	 * 3 - Conclu�do.
	 */
	public void setIdStatus(String IdStatus) {
		this.idStatus = IdStatus;
	}

	public String getDtFila() {
		return dtFila;
	}

	public void setDtFila(String dtFila) {
		this.dtFila = dtFila;
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
}
