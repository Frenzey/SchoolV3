/*package classes;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public abstract class Admin implements Interface {

	@Override
	public int authentification(int user, int pass) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int level = 0;
		try{
			String sql = "SELECT * FROM auth WHERE user ='"+user+"' and pass='"+pass+"'";
			JDBC.st = JDBC.connexion.createStatement();
			JDBC.rs = JDBC.st.executeQuery(sql);
			if(JDBC.rs.next()){
				level=JDBC.rs.getInt("level");
			}
			else{
				level=0;
			}
		}
		catch(SQLException e){
			//mettre une alerte !!!
			System.out.println("Erreur");
			e.printStackTrace();
		}
		return level;
	}

	@Override
	public int seConnecter(int user, int pass,int level) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int id = 0;
		try{

			String sql = "select * from auth where user ='"+user+"' and pass='"+pass+"'";
			JDBC.st = JDBC.connexion.createStatement();
			JDBC.rs = JDBC.st.executeQuery(sql);
			if(JDBC.rs.next()){
				id=JDBC.rs.getInt("idIndividu");
			}
			else{
				id=0;
				//alerte 
			}
		}
		catch(SQLException e){
			//mettre une alerte !!!
			System.out.println("Erreur");
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public void seDeconnecter() {


	}
	//ok
	public int inscrireEtudiant(Etudiant e1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int id;
		try {
			String sql="INSERT INTO individus(nom,prenom,genre,adresse,datedenaissance,lieudenaissance,telephoneFixe,telephoneMobile) VALUES(?,?,?,?,?,?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setString(1,e1.getNom());
			JDBC.ps.setString(2,e1.getPrenom());
			JDBC.ps.setString(3, e1.getGenre());
			JDBC.ps.setString(4, e1.getAdresse());
			JDBC.ps.setString(5, e1.getDatedenaissance());
			JDBC.ps.setString(6, e1.getLieudenaissance());
			JDBC.ps.setString(7, e1.getTelephoneFixe());
			JDBC.ps.setString(8, e1.getTelephoneMobile());
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				id=JDBC.rs.getInt(1);
				System.out.println(id);
				sql="INSERT INTO etudiants(individus_idindividus) VALUES(?);";
				JDBC.ps =JDBC.connexion.prepareStatement(sql);
				JDBC.ps.setInt(1,id);
				JDBC.ps.executeUpdate();
			}
			return 1;
		} catch (SQLException e) {
			int errCode = e.getErrorCode();
			if(errCode == 1062) {
				System.out.println("user deja existant");
				//inserer code alerte
			}
			else {
				System.out.println("erreur");
			}
			return 0;
		}	
	}
	//ok
	@Override
	public int modifierEtudiant(int idEtudiant,Etudiant e1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int id=0;
		String sql;
		try {
			sql = "SELECT individus_idindividus FROM etudiants WHERE idEtudiant ='"+ idEtudiant +"';";
			JDBC.st = JDBC.connexion.createStatement();
			JDBC.rs=JDBC.st.executeQuery(sql);
			if(JDBC.rs.next()){
				id=JDBC.rs.getInt(1);
				System.out.println(id);
			}
			sql="UPDATE individus SET individus.nom='"+e1.getNom()+ "'individus.prenom='"+e1.getPrenom() +"',individus.genre='"+e1.getGenre()+"',individus.adresse='"+e1.getAdresse()+"',individus.datedenaissance='"+e1.getDatedenaissance()+"',individus.lieudenaissance='"+e1.getLieudenaissance()+"',individus.telephoneFixe='"+e1.getTelephoneFixe()+"',individus.telephoneMobile='"+e1.getTelephoneMobile()+"' WHERE individus.idindividus='"+id+"';";
			JDBC.st =JDBC.connexion.createStatement();
			JDBC.st.executeUpdate(sql);
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("error");
		}

		return 0;
	}
	//ok
	@Override
	public int supprimerEtudiant(int idEtudiant) {
		JDBC.getInstance();
		JDBC.getConnexion();
		String sql;
		int id=0;

		try {
			sql = "SELECT individus_idindividus FROM etudiants WHERE idEtudiant ='"+ idEtudiant +"';";
			JDBC.st = JDBC.connexion.createStatement();
			JDBC.rs=JDBC.st.executeQuery(sql);
			if(JDBC.rs.next()){

				id=JDBC.rs.getInt(1);
				System.out.println(id);
			}
			sql = "DELETE FROM etudiants WHERE idEtudiant ='"+ idEtudiant +"';";
			JDBC.ps = JDBC.connexion.prepareStatement(sql);
			JDBC.ps.executeUpdate();

			sql = "DELETE FROM individus WHERE idindividus ='"+ id +"';";
			JDBC.ps = JDBC.connexion.prepareStatement(sql);
			JDBC.ps.executeUpdate();



			//message alerte ok

			return 1;

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
			//message alerte
		}
	}
	//ok
	@Override
	public int inscrireAgent(Secretaire s1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int id;
		try {
			String sql="INSERT INTO individus(nom,prenom,genre,adresse,datedenaissance,lieudenaissance,telephoneFixe,telephoneMobile) VALUES(?,?,?,?,?,?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setString(1,s1.getNom());
			JDBC.ps.setString(2,s1.getPrenom());
			JDBC.ps.setString(3, s1.getGenre());
			JDBC.ps.setString(4, s1.getAdresse());
			JDBC.ps.setString(5, s1.getDatedenaissance());
			JDBC.ps.setString(6, s1.getLieudenaissance());
			JDBC.ps.setString(7, s1.getTelephoneFixe());
			JDBC.ps.setString(8, s1.getTelephoneMobile());
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				id=JDBC.rs.getInt(1);
				System.out.println(id);
				sql="INSERT INTO secretaire(individus_idindividus) VALUES(?);";
				JDBC.ps =JDBC.connexion.prepareStatement(sql);
				JDBC.ps.setInt(1,id);
				JDBC.ps.executeUpdate();
			}
			return 1;
		} catch (SQLException e) {
			int errCode = e.getErrorCode();
			if(errCode == 1062) {
				System.out.println("user deja existant");
				//inserer code alerte
			}
			else {
				System.out.println("erreur");
			}
			return 0;
		}
	}
	//ok
	@Override
	public int inscrireAgent(Directeur d1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int id;
		try {
			String sql="INSERT INTO individus(nom,prenom,genre,adresse,datedenaissance,lieudenaissance,telephoneFixe,telephoneMobile) VALUES(?,?,?,?,?,?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setString(1,d1.getNom());
			JDBC.ps.setString(2,d1.getPrenom());
			JDBC.ps.setString(3, d1.getGenre());
			JDBC.ps.setString(4, d1.getAdresse());
			JDBC.ps.setString(5, d1.getDatedenaissance());
			JDBC.ps.setString(6, d1.getLieudenaissance());
			JDBC.ps.setString(7, d1.getTelephoneFixe());
			JDBC.ps.setString(8, d1.getTelephoneMobile());
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				id=JDBC.rs.getInt(1);
				System.out.println(id);
				sql="INSERT INTO directeur(individus_idindividus) VALUES(?);";
				JDBC.ps =JDBC.connexion.prepareStatement(sql);
				JDBC.ps.setInt(1,id);
				JDBC.ps.executeUpdate();
			}
			return 1;
		} catch (SQLException e) {
			int errCode = e.getErrorCode();
			if(errCode == 1062) {
				System.out.println("user deja existant");
				//inserer code alerte
			}
			else {
				System.out.println("erreur");
			}
			return 0;
		}
	}
	//ok
	@Override
	public int inscrireAgent(Comptable c1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int id;
		try {
			String sql="INSERT INTO individus(nom,prenom,genre,adresse,datedenaissance,lieudenaissance,telephoneFixe,telephoneMobile) VALUES(?,?,?,?,?,?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setString(1,c1.getNom());
			JDBC.ps.setString(2,c1.getPrenom());
			JDBC.ps.setString(3, c1.getGenre());
			JDBC.ps.setString(4, c1.getAdresse());
			JDBC.ps.setString(5, c1.getDatedenaissance());
			JDBC.ps.setString(6, c1.getLieudenaissance());
			JDBC.ps.setString(7, c1.getTelephoneFixe());
			JDBC.ps.setString(8, c1.getTelephoneMobile());
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				id=JDBC.rs.getInt(1);
				System.out.println(id);
				sql="INSERT INTO comptable(individus_idindividus) VALUES(?);";
				JDBC.ps =JDBC.connexion.prepareStatement(sql);
				JDBC.ps.setInt(1,id);
				JDBC.ps.executeUpdate();
			}
			return 1;
		} catch (SQLException e) {
			int errCode = e.getErrorCode();
			if(errCode == 1062) {
				System.out.println("user deja existant");
				//inserer code alerte
			}
			else {
				System.out.println("erreur");
			}
			return 0;
		}
	}
	//ok
	@Override
	public int inscrireAgent(Enseignant e1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int id;
		try {
			String sql="INSERT INTO individus(nom,prenom,genre,adresse,datedenaissance,lieudenaissance,telephoneFixe,telephoneMobile) VALUES(?,?,?,?,?,?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setString(1,e1.getNom());
			JDBC.ps.setString(2,e1.getPrenom());
			JDBC.ps.setString(3, e1.getGenre());
			JDBC.ps.setString(4, e1.getAdresse());
			JDBC.ps.setString(5, e1.getDatedenaissance());
			JDBC.ps.setString(6, e1.getLieudenaissance());
			JDBC.ps.setString(7, e1.getTelephoneFixe());
			JDBC.ps.setString(8, e1.getTelephoneMobile());
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				id=JDBC.rs.getInt(1);
				System.out.println(id);
				sql="INSERT INTO enseignants(individus_idindividus) VALUES(?);";
				JDBC.ps =JDBC.connexion.prepareStatement(sql);
				JDBC.ps.setInt(1,id);
				JDBC.ps.executeUpdate();
			}
			return 1;
		} catch (SQLException e) {
			int errCode = e.getErrorCode();
			if(errCode == 1062) {
				System.out.println("user deja existant");
				//inserer code alerte
			}
			else {
				System.out.println("erreur");
			}
			return 0;
		}
	}

	@Override
	public int modifierAgent(int idIndividu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int supprimerAgent(int idIndividu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int creerCompetence(int idEnseignant, int idmatiere) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int supprimerCompetence(int idCompetence) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int creerGroupe() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void consulterGroupe(int idGroupe) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ajouterAuGroupe(int idEtudiant, int idGroupe) {
		// TODO Auto-generated method stub

	}

	@Override
	public int supprimergroupe(int idGroupe) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ajouterSeance(Seance s1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int idseance=0;
		try {
			String sql="INSERT INTO seance(idPaiement,idTarifs,datePaiement,montantPaiement,modePaiement) VALUES(?,?,?,?,?);";			
			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setInt(1,s1.getIdSalle());
			JDBC.ps.setInt(2,s1.getIdCours());
			JDBC.ps.setInt(3, s1.getIdHorraire());
			JDBC.ps.setInt(4, s1.getIdSession());
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				idseance=JDBC.rs.getInt(1);
				System.out.println(idseance);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		
	}

	@Override
	public int modifierSeance(int idSeance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int supprimerSeance(int idSeance) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void creernotation(int idGroupe) {
		// TODO Auto-generated method stub

	}

	@Override
	public void consulternotation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consulternotation(int idEtudiant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ajouterpresence(int idGroupe) {
		// TODO Auto-generated method stub

	}

	@Override
	public void consulterpresence() {
		// TODO Auto-generated method stub

	}

	@Override
	public void consulterpresence(int idEtudiant) {
		// TODO Auto-generated method stub

	}
//ok
	@Override
	public int creersalle(Salle s1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int idsalle=0;
		try {
			String sql="INSERT INTO salle(idPaiement,idTarifs,datePaiement,montantPaiement,modePaiement) VALUES(?,?,?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setInt(1,s1.getIdSalle());
			JDBC.ps.setString(2,s1.getLibelSalle());
			JDBC.ps.setInt(3, s1.getCapaSalle());
			JDBC.ps.setString(4, s1.getDispoSalle());
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				idsalle=JDBC.rs.getInt(1);
				System.out.println(idsalle);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return idsalle;
	}

	@Override
	public void supprimerSalle(int idSalle) {
		// TODO Auto-generated method stub

	}
//ok
	@Override
	public int creerSession(Session s1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int idsession=0;
		try {
			String sql="INSERT INTO session(idPaiement,idTarifs,datePaiement,montantPaiement,modePaiement) VALUES(?,?,?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setInt(1,s1.getIdSession());
			JDBC.ps.setInt(2,s1.getAnneeSession());
			JDBC.ps.setString(3, s1.getLibelSession());
			JDBC.ps.setString(4, s1.getDebutSession());
			JDBC.ps.setString(5, s1.getDateFinSession());
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				idsession=JDBC.rs.getInt(1);
				System.out.println(idsession);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return idsession;
	}

	@Override
	public void supprimerSession(int idSession) {
		// TODO Auto-generated method stub

	}
//ok
	@Override
	public int ajouterMatiere(Matiere m1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int idmatiere=0;
		try {
			String sql="INSERT INTO matiere(idMatiere,libelMatiere) VALUES(?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setInt(1,m1.getIdMatiere());
			JDBC.ps.setString(2,m1.getLibelMatiere());
			
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				idmatiere=JDBC.rs.getInt(1);
				System.out.println(idmatiere);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return idmatiere;
	}

	@Override
	public void supprimerMatiere() {
		// TODO Auto-generated method stub

	}
//ok
	@Override
	public int effectuerPaiement(Paiement p1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int idpaiement=0;
		try {
			String sql="INSERT INTO paiement(idPaiement,idTarifs,datePaiement,montantPaiement,modePaiement) VALUES(?,?,?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setInt(1,p1.getIdEtudiant());
			JDBC.ps.setDouble(2,p1.getIdTarif());
			JDBC.ps.setString(3, p1.getDatePaiement());
			JDBC.ps.setDouble(4, p1.getMontantPaiement());
			JDBC.ps.setString(5, p1.getModePaiement());
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				idpaiement=JDBC.rs.getInt(1);
				System.out.println(idpaiement);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return idpaiement;
	}

	@Override
	public void consulterPaiement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void effectuerAchat() {
		// TODO Auto-generated method stub

	}

}
*/