package modelo;

public class FilaAtendimento {
	private int cdFilaAtendimento;
	private Paciente paciente;
	private Estabelecimento estabelecimento;
	private String dtFila;
	private int cdStatus;
	/* Status da fila (cdStatus):
	 * 1 - Fila de atendimento de enfermagem;
	 * 2 - Fila de atendimento médico;
	 * 3 - Concluído. */
	
	public FilaAtendimento(){		
	}

	public int getCdFilaAtendimento() {
		return cdFilaAtendimento;
	}

	public void setCdFilaAtendimento(int cdFilaAtendimento) {
		this.cdFilaAtendimento = cdFilaAtendimento;
	}

	/**
	 * <b>Status da fila (cdStatus):</b><br>
	 * 1 - Fila de atendimento de enfermagem;<br>
	 * 2 - Fila de atendimento médico;<br>
	 * 3 - Concluído.
	 */
	public int getCdStatus() {
		return cdStatus;
	}

	/**
	 * <b>Status da fila (cdStatus):</b><br>
	 * 1 - Fila de atendimento de enfermagem;<br>
	 * 2 - Fila de atendimento médico;<br>
	 * 3 - Concluído.
	 */
	public void setCdStatus(int cdStatus) {
		this.cdStatus = cdStatus;
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
