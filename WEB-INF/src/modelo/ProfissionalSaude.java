package modelo;

public class ProfissionalSaude extends Profissional{
	
	private int cdConselho;
	private ConselhoDeClasse conselhoDeClasse;	
	private String dsProfissao;
	private String dsEspecializacao;
	
	public ProfissionalSaude(){		
	}
	
	public int getCdConselho() {
		return cdConselho;		
	}
	public void setCdConselho(int cdConselho) {
		this.cdConselho = cdConselho;
	}
	public String getDsEspecializacao() {
		return dsEspecializacao;
	}
	public void setDsEspecializacao(String dsEspecializacao) {
		this.dsEspecializacao = dsEspecializacao;
	}
	public String getDsProfissao() {
		return dsProfissao;
	}
	public void setDsProfissao(String dsProfissao) {
		this.dsProfissao = dsProfissao;
	}
	public ConselhoDeClasse getConselhoDeClasse() {
		return conselhoDeClasse;
	}
	public void setConselhoDeClasse(ConselhoDeClasse conselhoDeClasse) {
		this.conselhoDeClasse = conselhoDeClasse;
	}
	
}
