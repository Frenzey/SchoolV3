package classes;
public class Etudiant extends Individus {
	private int idEtudiant;

    public Etudiant() {
        
    }
	

	public int getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	
	public Etudiant(String nom, String prenom, String genre,String adresse,
			String date, String lieudenaissance, String telephoneFixe,
			String telephoneMobile) {
		super();
		super.setNom(nom);
		super.setPrenom(prenom);
		super.setGenre(genre);
		super.setAdresse(adresse);
		super.setDatedenaissance(date);
		super.setLieudenaissance(lieudenaissance);
		super.setTelephoneFixe(telephoneFixe);
		super.setTelephoneMobile(telephoneMobile);
	}

        
        
        
    @Override
    public String toString() {
        return "Etudiant{" + "idEtudiant=" + idEtudiant + '}';
    }

   
      
	
}
