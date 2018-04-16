package school;

public class Matiere {
	private  int idMatiere;
	private String libelMatiere;
	public int getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public String getLibelMatiere() {
		return libelMatiere;
	}
	public void setLibelMatiere(String libelMatiere) {
		this.libelMatiere = libelMatiere;
	}
	public Matiere(int idMatiere, String libelMatiere) {
		super();
		this.idMatiere = idMatiere;
		this.libelMatiere = libelMatiere;
	}
	
}
