package school;

public class Groupe {
	private int idGroupe;
	private int idSession;
	private String libelGroupe;
	
	
	public int getIdGroupe() {
		return idGroupe;
	}
	public void setIdGroupe(int idGroupe) {
		this.idGroupe = idGroupe;
	}
	public int getIdSession() {
		return idSession;
	}
	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}
	public String getLibelGroupe() {
		return libelGroupe;
	}
	public void setLibelGroupe(String libelGroupe) {
		this.libelGroupe = libelGroupe;
	}
	public Groupe(int idGroupe, int idSession, String libelGroupe) {
		super();
		this.idGroupe = idGroupe;
		this.idSession = idSession;
		this.libelGroupe = libelGroupe;
	}
	
}
