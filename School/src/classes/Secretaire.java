package classes;

public class Secretaire extends Individus {
	private int idSecretaire;
	
	
	public int getIdSecretaire() {
		return idSecretaire;
	}

	public void setIdSecretaire(int idSecretaire) {
		this.idSecretaire = idSecretaire;
	}

	public Secretaire(String nom, String prenom, String genre,
			String date, String lieudenaissance, String telephoneFixe,
			String telephoneMobile) {
		super();
		super.setNom(nom);
		super.setPrenom(prenom);
		super.setGenre(genre);
		super.setDatedenaissance(date);
		super.setLieudenaissance(lieudenaissance);
		super.setTelephoneFixe(telephoneFixe);
		super.setTelephoneMobile(telephoneMobile);
	}

}
