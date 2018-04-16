package school;

public class Cours {
	private int idCours;
	private int idMatiere;
	private String libelCours;
	private String niveauCours;
	public int getIdCours() {
		return idCours;
	}
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}
	public int getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public String getLibelCours() {
		return libelCours;
	}
	public void setLibelCours(String libelCours) {
		this.libelCours = libelCours;
	}
	public String getNiveauCours() {
		return niveauCours;
	}
	public void setNiveauCours(String niveauCours) {
		this.niveauCours = niveauCours;
	}
	public Cours(int idCours, int idMatiere, String libelCours,
			String niveauCours) {
		super();
		this.idCours = idCours;
		this.idMatiere = idMatiere;
		this.libelCours = libelCours;
		this.niveauCours = niveauCours;
	}
}
