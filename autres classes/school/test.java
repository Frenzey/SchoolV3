package school;


import java.sql.SQLException;

import com.mysql.jdbc.Statement;
public class test {
	public static void main(String[] args)  {
		//Etudiant e1=new Etudiant("bwalala", "alegria","m", " 9 rue des oiseaux 77176 SAVIGNY LE TEMPLE", "12/07/1995", "Melun" , "0166666666", "0666666666");
		//inscrireEtudiant(e1);
		//supprimerEtudiant(14);
		//Etudiant e2=new Etudiant("sundara", "adjay","m", " 9 AVENUE HENRI SELLIER 91130 RIS BIZZ", "12/07/1995", "Melun" , "0166666666", "0666666666");
		//modifierEtudiant(15,e2);
	}
	public static int inscrireEtudiant(Etudiant e1) {
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
	public static  int supprimerEtudiant(int idEtudiant) {
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
	public static int modifierEtudiant(int idEtudiant,Etudiant e1) {
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
			sql="UPDATE individus SET individus.nom='"+e1.getNom()+"',individus.prenom='"+e1.getPrenom() +"',individus.genre='"+e1.getGenre()+"',individus.adresse='"+e1.getAdresse()+"',individus.datedenaissance='"+e1.getDatedenaissance()+"',individus.lieudenaissance='"+e1.getLieudenaissance()+"',individus.telephoneFixe='"+e1.getTelephoneFixe()+"',individus.telephoneMobile='"+e1.getTelephoneMobile()+"' WHERE individus.idindividus='"+id+"';";
			JDBC.st =JDBC.connexion.createStatement();
			JDBC.st.executeUpdate(sql);
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("error");
		}
	
		return 0;
	}
}