package modelo;

public class Procedimento {
	private int cdProcedimento = 0;
	private String dsProcedimento = "";
	private String idStatus;
	public Procedimento() {
	}

	public int getCdProcedimento() {
		return cdProcedimento;
	}

	public void setCdProcedimento(int cdProcedimento) {
		this.cdProcedimento = cdProcedimento;
	}

	public String getDsProcedimento() {
		return dsProcedimento;
	}

	public void setDsProcedimento(String dsProcedimento) {
		this.dsProcedimento = dsProcedimento;
	}

	public String getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}
}
