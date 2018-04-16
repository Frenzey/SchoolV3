package school;

public class materiels {
	private int idMateriel;
	private String libelMateriel;
	private double prixMateriel;
	
	public int getIdMateriel() {
		return idMateriel;
	}
	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
	}
	public String getLibelMateriel() {
		return libelMateriel;
	}
	public void setLibelMateriel(String libelMateriel) {
		this.libelMateriel = libelMateriel;
	}
	public double getPrixMateriel() {
		return prixMateriel;
	}
	public void setPrixMateriel(double prixMateriel) {
		this.prixMateriel = prixMateriel;
	}
	public materiels(int idMateriel, String libelMateriel, double prixMateriel) {
		super();
		this.idMateriel = idMateriel;
		this.libelMateriel = libelMateriel;
		this.prixMateriel = prixMateriel;
	}
	
}
