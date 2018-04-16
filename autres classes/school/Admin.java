package school;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public abstract class Admin implements Interface {

	//OK
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
	//OK
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
		//effacer l'idetudiant public
		//et revenir a la page d'authentification
		//a ajouter dans le controlleur

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
	//ok maj
	@Override
	public int modifierAgent(int id,String nom,String prenom,String genre,String adresse,String datedenaissance,String lieudenaissance,String telephoneFixe,String telephoneMobile) {
		JDBC.getInstance();
		JDBC.getConnexion();
		String sql;
		try {
			sql="UPDATE individus SET individus.nom='"+nom+ "'individus.prenom='"+prenom+"',individus.genre='"+genre+"',individus.adresse='"+adresse+"',individus.datedenaissance='"+datedenaissance+"',individus.lieudenaissance='"+lieudenaissance+"',individus.telephoneFixe='"+telephoneFixe+"',individus.telephoneMobile='"+telephoneMobile+"' WHERE individus.idindividus='"+id+"';";
			JDBC.st =JDBC.connexion.createStatement();
			JDBC.st.executeUpdate(sql);
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("error");
		}

		return 0;
	}
	//not ok depend de l'agent ou faire du polymorphisme 
	@Override
	public int supprimerAgent(int id) {
		JDBC.getInstance();
		JDBC.getConnexion();
		String sql;
		int idind=0;
		try {
			sql = "SELECT individus_idindividus FROM secretaire WHERE idSecretaire ='"+ id +"';";
			JDBC.st = JDBC.connexion.createStatement();
			JDBC.rs=JDBC.st.executeQuery(sql);
			if(JDBC.rs.next()){
				id=JDBC.rs.getInt(1);
				System.out.println(idind);
			}
			sql = "DELETE FROM etudiants WHERE idEtudiant ='"+ id +"';";
			JDBC.ps = JDBC.connexion.prepareStatement(sql);
			JDBC.ps.executeUpdate();

			sql = "DELETE FROM individus WHERE idindividus ='"+ idind +"';";
			JDBC.ps = JDBC.connexion.prepareStatement(sql);
			//message ok
			return 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error");
			return 0;
		}
	}
	//ok
	@Override
	public int creerCompetence(int idEnseignant, int idmatiere) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int idcompetance=0;
		try {
			String sql="INSERT INTO competences(matieres_idMatiere,enseignants_idEnseignant) VALUES(?,?);";			
			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setInt(1,idEnseignant);
			JDBC.ps.setInt(2,idmatiere);
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				idcompetance=JDBC.rs.getInt(1);
				System.out.println(idcompetance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idcompetance;
	}
	//ok
	@Override
	public int supprimerCompetence(int idmatiere, int idenseignant) {
		JDBC.getInstance();
		JDBC.getConnexion();
		String sql;
		try {
			sql = "DELETE FROM competences WHERE matieres_idMatiere ='"+ idmatiere +"'AND enseignants_idEnseignant='"+idenseignant +"';";
			JDBC.ps = JDBC.connexion.prepareStatement(sql);
			JDBC.ps.executeUpdate();
			//message alerte ok
			return 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
			//message alerte non ok
		}
	}
	//ok
	@Override
	public int creerGroupe(Groupe p1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int idgroupe=0;
		try {
			String sql="INSERT INTO groupes(libelGroupe,sessions_idsessions) VALUES(?,?);";			
			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setString(1,p1.getLibelGroupe());
			JDBC.ps.setInt(2,p1.getIdSession());

			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				idgroupe=JDBC.rs.getInt(1);
				System.out.println(idgroupe);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return idgroupe;

	}
	//ok
	@Override
	public void consulterGroupe(int idGroupe) {
		JDBC.getInstance();
		JDBC.getConnexion();
		try{
			String sql = "SELECT * FROM groupes_has_etudiants WHERE groupes_idGroupe ='"+idGroupe+"';";
			JDBC.st = JDBC.connexion.createStatement();
			JDBC.rs = JDBC.st.executeQuery(sql);
			if(JDBC.rs.next()){
				//get value
			}
		}
		catch(SQLException e){
			//mettre une alerte !!!
			System.out.println("Erreur");
			e.printStackTrace();
		}
	}
	//ok
	@Override
	public void ajouterAuGroupe(int idEtudiant, int idGroupe,int idSession) {
		JDBC.getInstance();
		JDBC.getConnexion();
		
		try {
			String sql="INSERT INTO groupes_has_etudiants(groupes_idGroupe,groupes_sessions_idsessions,etudiants_idEtudiant) VALUES(?,?,?);";			
			JDBC.ps =JDBC.connexion.prepareStatement(sql);
			JDBC.ps.setInt(1,idGroupe);
			JDBC.ps.setInt(2,idSession);
			JDBC.ps.setInt(3,idEtudiant);
			JDBC.ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//ok
	@Override
	public int supprimergroupe(int idGroupe) {
		JDBC.getInstance();
		JDBC.getConnexion();
		String sql;
		try {
			sql = "DELETE FROM groupes WHERE idGroupe ='"+ idGroupe+"';";
			JDBC.ps = JDBC.connexion.prepareStatement(sql);
			JDBC.ps.executeUpdate();
			//message alerte ok
			return 1;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return 0;
			//message alerte non ok
		}
	}
	//OK 
	@Override
	public void ajouterSeance(Seance s1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int idseance=0;
		try {
			String sql="INSERT INTO seance(Cours_idCours,Cours_matieres_idMatiere,salles_idsalles,groupes_idGroupe,horaires_idHoraires) VALUES(?,?,?,?,?);";			
			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setInt(1,s1.getIdCours());
			JDBC.ps.setInt(2,s1.getIdMatiere());
			JDBC.ps.setInt(3,s1.getIdSalle());
			JDBC.ps.setInt(4,s1.getIdGroupe());
			JDBC.ps.setInt(5,s1.getIdHorraire());
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
	//ok
	@Override
	public int modifierSeance(int idSeance,int cours,int matiere,int salle,int groupe,int horraire) {
		JDBC.getInstance();
		JDBC.getConnexion();
		String sql;
		try {
			sql="UPDATE seances SET Cours_idCours='"+cours+ "'Cours_matieres_idMatiere='"+matiere+"',salles_idsalles='"+salle+"',groupes_idGroupe='"+groupe+"',horaires_idHoraires='"+horraire+"'WHERE idseances='"+idSeance+"';";
			JDBC.st =JDBC.connexion.createStatement();
			JDBC.st.executeUpdate(sql);
			return 1;
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("error");
			return 0;
		}
	}
	//ok
	@Override
	public int supprimerSeance(int idSeance) {
		JDBC.getInstance();
		JDBC.getConnexion();
		String sql;
		try {

			sql = "DELETE FROM seances WHERE idseances ='"+ idSeance +"';";
			JDBC.ps = JDBC.connexion.prepareStatement(sql);
			JDBC.ps.executeUpdate();
			//message alerte ok
			return 1;

		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("error");
			return 0;
		}

	}
	//bonus
	@Override
	public void creernotation(int idGroupe) {
	
	}
	//ok
	@Override
	public void consulternotation() {
		JDBC.getInstance();
		JDBC.getConnexion();
		try{
			String sql = "SELECT * FROM evalution WHERE idEvalution=exam.evalution_idEvalution;";
			JDBC.st = JDBC.connexion.createStatement();
			JDBC.rs = JDBC.st.executeQuery(sql);
			if(JDBC.rs.next()){
				//get value
			}
		}
		catch(SQLException e){
			//mettre une alerte !!!
			System.out.println("Erreur");
			e.printStackTrace();
		}
	
	}
	//ok
	@Override
	public void consulternotation(int idEtudiant) {
		JDBC.getInstance();
		JDBC.getConnexion();
		try{
			String sql = "SELECT * FROM evalution WHERE evalution_groupes_has_etudiants_etudiants_idEtudiant='"+idEtudiant+"' AND idEvalution=exam.evalution_idEvalution;";
			JDBC.st = JDBC.connexion.createStatement();
			JDBC.rs = JDBC.st.executeQuery(sql);
			if(JDBC.rs.next()){
				//get value
			}
		}
		catch(SQLException e){
			//mettre une alerte !!!
			System.out.println("Erreur");
			e.printStackTrace();
		}
	}
	//ok
	@Override
	public int ajouterpresence(int presence,int idEval,int idGroup,int idSession,int idEtudiant) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int id=0;
		try {
			String sql="INSERT INTO matiere(presence,evalution_idEvalution,evalution_groupes_has_etudiants_groupes_idGroupe,evalution_groupes_has_etudiants_groupes_sessions_idsessions,evalution_groupes_has_etudiants_etudiants_idEtudiant,) VALUES(?,?);";
			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setInt(1,presence);
			JDBC.ps.setInt(2,idEval);
			JDBC.ps.setInt(3,idGroup);
			JDBC.ps.setInt(4,idSession);
			JDBC.ps.setInt(5,idSession);
			JDBC.ps.setInt(6,idEtudiant);
			JDBC.ps.executeUpdate();
			JDBC.rs=JDBC.ps.getGeneratedKeys();
			if(JDBC.rs.next()){
				id=JDBC.rs.getInt(1);
				System.out.println(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return id;
	}
	//ok
	@Override
	public void consulterpresence() {
		JDBC.getInstance();
		JDBC.getConnexion();
		try{
			String sql = "SELECT * FROM assidute WHERE idEvalution=assiduite.evalution_idEvalution;";
			JDBC.st = JDBC.connexion.createStatement();
			JDBC.rs = JDBC.st.executeQuery(sql);
			if(JDBC.rs.next()){
				//get value
			}
		}
		catch(SQLException e){
			//mettre une alerte !!!
			System.out.println("Erreur");
			e.printStackTrace();
		}
	
	
	}
	//ok
	@Override
	public void consulterpresence(int idEtudiant) {
		JDBC.getInstance();
		JDBC.getConnexion();
		try{
			String sql = "SELECT * FROM assidute WHERE evalution_groupes_has_etudiants_etudiants_idEtudiant='"+idEtudiant+"';";
			JDBC.st = JDBC.connexion.createStatement();
			JDBC.rs = JDBC.st.executeQuery(sql);
			if(JDBC.rs.next()){
				//get value
			}
		}
		catch(SQLException e){
			//mettre une alerte !!!
			System.out.println("Erreur");
			e.printStackTrace();
		}
	
	}
	//ok
	@Override
	public int creersalle(Salle s1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int idsalle=0;
		try {
			String sql="INSERT INTO salle(libelsalles,capasalles,disposalles) VALUES(?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setString(1,s1.getLibelSalle());
			JDBC.ps.setInt(2, s1.getCapaSalle());
			JDBC.ps.setString(3,s1.getDispoSalle());
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
	//ok
	@Override
	public int supprimerSalle(int idSalle) {
		JDBC.getInstance();
		JDBC.getConnexion();
		String sql;
		
		try {
			sql = "DELETE FROM salles WHERE idsalles ='"+ idSalle +"';";
			JDBC.ps = JDBC.connexion.prepareStatement(sql);
			JDBC.ps.executeUpdate();
			//message alerte ok
			return 1;

		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("error");
			return 0;
		}

	}
	//ok
	@Override
	public int creerSession(Session s1) {
		JDBC.getInstance();
		JDBC.getConnexion();
		int idsession=0;
		try {
			String sql="INSERT INTO session(annéeSession,libelSession,datedebutSession,datefinSession) VALUES(?,?,?,?);";

			JDBC.ps =JDBC.connexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			JDBC.ps.setInt(1,s1.getAnneeSession());
			JDBC.ps.setString(2,s1.getLibelSession());
			JDBC.ps.setString(3,s1.getDebutSession());
			JDBC.ps.setString(4,s1.getDateFinSession());
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

	//ok
	@Override
	public int supprimerSession(int idSession) {
		JDBC.getInstance();
		JDBC.getConnexion();
		String sql;
		try {
			sql = "DELETE FROM sessions WHERE idsessions ='"+ idSession +"';";
			JDBC.ps = JDBC.connexion.prepareStatement(sql);
			JDBC.ps.executeUpdate();
			//message alerte ok
			return 1;

		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("error");
			return 0;
		}

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
	//ok
	@Override
	public int supprimerMatiere(int idmatiere) {
		JDBC.getInstance();
		JDBC.getConnexion();
		String sql;
		
		try {
			sql = "DELETE FROM matieres WHERE idMatiere ='"+ idmatiere +"';";
			JDBC.ps = JDBC.connexion.prepareStatement(sql);
			JDBC.ps.executeUpdate();
			//message alerte ok
			return 1;

		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("error");
			return 0;
		}

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
    //ok
	@Override
	public void consulterPaiement() {
		JDBC.getInstance();
		JDBC.getConnexion();
		try{
			String sql = "SELECT * FROM paiement ";
			JDBC.st = JDBC.connexion.createStatement();
			JDBC.rs = JDBC.st.executeQuery(sql);
			if(JDBC.rs.next()){
				//get value
			}
		}
		catch(SQLException e){
			//mettre une alerte !!!
			System.out.println("Erreur");
			e.printStackTrace();
		}
	}

	//bonus
	@Override
	public void effectuerAchat() {
		// TODO Auto-generated method stub

	}

}
