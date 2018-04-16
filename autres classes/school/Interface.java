package school;

public interface Interface {
//authentification et deconnexion
	public int authentification(int user,int pass);
	public int seConnecter(int user,int pass,int level);
	public void seDeconnecter();
//Gérer les étudiants
	public int inscrireEtudiant(Etudiant e1);
	public int modifierEtudiant(int idEtudiant,Etudiant e1);
	public int supprimerEtudiant(int idEtudiant);
//Gérer les inscriptions
	public int inscrireAgent(Secretaire s1);
	public int inscrireAgent(Directeur d1);
	public int inscrireAgent(Comptable c1);
	public int modifierAgent(int id,String nom,String prenom,String genre,String adresse,String datedenaissance,String lieudenaissance,String telephoneFixe,String telephoneMobile);
	public int supprimerAgent(int idIndividu);
//Gérer les enseignants	
	public int inscrireAgent(Enseignant e1);
	//public int modifierEtudiant(int idEnseignant,Etudiant e1);
	//public int supprimerEtudiant(int idEnseignant);
	public int creerCompetence(int idEnseignant,int idmatiere);
	public int supprimerCompetence(int idmatiere,int idEnseignant);
// Gérer les groupes
	public int creerGroupe(Groupe p1);
	public void consulterGroupe(int idGroupe);
	public void ajouterAuGroupe(int idEtudiant, int idGroupe,int idSession);
	public int supprimergroupe(int idGroupe);
//Gérer le planning
	public void ajouterSeance(Seance s1);
	public int modifierSeance(int idSeance,int cours,int matiere,int salle,int groupe,int horraire);
	public int supprimerSeance(int idSeance);
//Gérer le suivi pédagogique
	public void creernotation(int idGroupe);
	public void consulternotation();
	public void consulternotation(int idEtudiant);
	public int ajouterpresence(int presence,int idEval,int idGroup,int idSession,int idEtudiant);
	public void consulterpresence();
	public void consulterpresence(int idEtudiant);
//Gérer les salles
	public int creersalle(Salle s1);
	public int supprimerSalle(int idSalle);
//Gérer les sessions
	public int creerSession(Session s1);
	public int supprimerSession(int idSession);
//Gérer les matières
	public int ajouterMatiere(Matiere m1);
	public int supprimerMatiere(int idmatiere);
//gerer paiement
	public int effectuerPaiement(Paiement p1);
//Gérer la comptabilité
	public void consulterPaiement();
	public void effectuerAchat();
	
	




}


