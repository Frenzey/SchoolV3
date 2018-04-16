package school;

public class Directeur extends Individus{
	private int idDirecteur;
	
	
	public int getIdDirecteur() {
		return idDirecteur;
	}

	public void setIdDirecteur(int idDirecteur) {
		this.idDirecteur = idDirecteur;
	}

	public Directeur(String nom, String prenom, String genre,
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
