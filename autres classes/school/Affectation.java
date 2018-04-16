package school;

import java.util.Date;

public class Affectation {
	private int idAffectation;
	private int idContact;
	private String login;
	private String pass;
	private Date DateEntrContrat;
	private Date DateSortContrat;
	private double SalaireContrat;
	public int getIdAffectation() {
		return idAffectation;
	}
	public void setIdAffectation(int idAffectation) {
		this.idAffectation = idAffectation;
	}
	public int getIdContact() {
		return idContact;
	}
	public void setIdContact(int idContact) {
		this.idContact = idContact;
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
	public Date getDateEntrContrat() {
		return DateEntrContrat;
	}
	public void setDateEntrContrat(Date dateEntrContrat) {
		DateEntrContrat = dateEntrContrat;
	}
	public Date getDateSortContrat() {
		return DateSortContrat;
	}
	public void setDateSortContrat(Date dateSortContrat) {
		DateSortContrat = dateSortContrat;
	}
	public double getSalaireContrat() {
		return SalaireContrat;
	}
	public void setSalaireContrat(double salaireContrat) {
		SalaireContrat = salaireContrat;
	}
	public Affectation(int idAffectation, int idContact, String login,
			String pass, Date dateEntrContrat, Date dateSortContrat,
			double salaireContrat) {
		super();
		this.idAffectation = idAffectation;
		this.idContact = idContact;
		this.login = login;
		this.pass = pass;
		DateEntrContrat = dateEntrContrat;
		DateSortContrat = dateSortContrat;
		SalaireContrat = salaireContrat;
	}
}
