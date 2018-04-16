package school;

public class Salle {
	private int idSalle;
	private String libelSalle;
	private int capaSalle;
	private String dispoSalle;
	
	public int getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}
	public String getLibelSalle() {
		return libelSalle;
	}
	public void setLibelSalle(String libelSalle) {
		this.libelSalle = libelSalle;
	}
	public int getCapaSalle() {
		return capaSalle;
	}
	public void setCapaSalle(int capaSalle) {
		this.capaSalle = capaSalle;
	}
	public String getDispoSalle() {
		return dispoSalle;
	}
	public void setDispoSalle(String dispoSalle) {
		this.dispoSalle = dispoSalle;
	}
	public Salle(int idSalle, String libelSalle, int capaSalle,
			String dispoSalle) {
		super();
		this.idSalle = idSalle;
		this.libelSalle = libelSalle;
		this.capaSalle = capaSalle;
		this.dispoSalle = dispoSalle;
	}
	
}
