package school;

public class Seance {
	private int idSeance;
	private int idCours;
	private int idMatiere;
	private int idSalle;
	private int idGroupe;
	private int idHorraire;
	private int idSession;
	public int getIdSeance() {
		return idSeance;
	}
	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}
	public int getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}
	public int getIdCours() {
		return idCours;
	}
	public void setIdCours(int idCours) {
		this.idCours = idCours;
	}
	public int getIdHorraire() {
		return idHorraire;
	}
	public void setIdHorraire(int idHorraire) {
		this.idHorraire = idHorraire;
	}
	public int getIdSession() {
		return idSession;
	}
	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}
	public int getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public int getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}
	public Seance(int idSeance, int idCours, int idMatiere, int idSalle,
			int idGroupe, int idHorraire, int idSession) {
		super();
		this.idSeance = idSeance;
		this.idCours = idCours;
		this.idMatiere = idMatiere;
		this.idSalle = idSalle;
		this.idGroupe = idGroupe;
		this.idHorraire = idHorraire;
		this.idSession = idSession;
	}

	
	
}
