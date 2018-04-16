package school;

public class Vente {
	private int idVente;
	private int idMateriel;
	private int idPaiement;
	public int getIdVente() {
		return idVente;
	}
	public void setIdVente(int idVente) {
		this.idVente = idVente;
	}
	public int getIdMateriel() {
		return idMateriel;
	}
	public void setIdMateriel(int idMateriel) {
		this.idMateriel = idMateriel;
	}
	public int getIdPaiement() {
		return idPaiement;
	}
	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}
	public Vente(int idVente, int idMateriel, int idPaiement) {
		super();
		this.idVente = idVente;
		this.idMateriel = idMateriel;
		this.idPaiement = idPaiement;
	}
	
}
