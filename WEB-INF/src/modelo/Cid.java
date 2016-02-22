package modelo;

public class Cid{	
	private int cdCid = 0;
	private String dsCid = "";
	private String idStatus;
	
	public Cid() {
	}	

	public int getCdCid() {
		return cdCid;
	}

	public void setCdCid(int cdCid) {
		this.cdCid = cdCid;
	}

	public String getDsCid() {
		return dsCid;
	}

	public void setDsCid(String dsCid) {
		this.dsCid = dsCid;
	}
	
	public String getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(String idStatus) {
		this.idStatus = idStatus;
	}
}
