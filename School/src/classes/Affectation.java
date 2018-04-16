package classes;
import java.util.Date;

public class Affectation {
	private int idAffectation;
	private int idContrat;
	private String login;
	private String pass;
	private String DateEntrContrat;
	private String DateSortContrat;
	private double SalaireContrat;
        private int validAffect;

    public Affectation() {
    }

    public Affectation(int idContrat, String login, String pass, String DateEntrContrat, String DateSortContrat, double SalaireContrat, int vi) {
        
        this.idContrat = idContrat;
        this.login = login;
        this.pass = pass;
        this.DateEntrContrat = DateEntrContrat;
        this.DateSortContrat = DateSortContrat;
        this.SalaireContrat = SalaireContrat;
        this.validAffect = vi;
    }     
	public int getIdAffectation() {
		return idAffectation;
	}
	public void setIdAffectation(int idAffectation) {
		this.idAffectation = idAffectation;
	}
	public int getIdContact() {
		return idContrat;
	}
	public void setIdContact(int idContact) {
		this.idContrat = idContact;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDateEntrContrat() {
		return DateEntrContrat;
	}
	public void setDateEntrContrat(String dateEntrContrat) {
		DateEntrContrat = dateEntrContrat;
	}
	public String getDateSortContrat() {
		return DateSortContrat;
	}
	public void setDateSortContrat(String dateSortContrat) {
		DateSortContrat = dateSortContrat;
	}
	public double getSalaireContrat() {
		return SalaireContrat;
	}
	public void setSalaireContrat(double salaireContrat) {
		SalaireContrat = salaireContrat;
	}

    public int getValidAffect() {
        return validAffect;
    }

    public void setValidAffect(int validAffect) {
        this.validAffect = validAffect;
    }
        
        

}
