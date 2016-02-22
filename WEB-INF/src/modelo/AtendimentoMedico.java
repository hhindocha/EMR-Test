package modelo;

public class AtendimentoMedico extends Atendimento {
	private Cid cid;
	private Procedimento procedimento;
	
	public AtendimentoMedico() {
	}

	public Cid getCid() {
		return cid;
	}

	public void setCid(Cid cid) {
		this.cid = cid;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}
	
}
