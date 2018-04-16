package classes;

import java.util.Date;
import java.sql.*;

public class Contrat {
	private int idContrat;
	private String libelContrat;
	private String dateEntrContrat;
	private String dateSortContrat;
	private double salaireContrat;

    public Contrat() {
    }

    public Contrat(String libelContrat, String dateEntrContrat, String dateSortContrat, double salaireContrat) {
   
        this.libelContrat = libelContrat;
        this.dateEntrContrat = dateEntrContrat;
        this.dateSortContrat = dateSortContrat;
        this.salaireContrat = salaireContrat;
    }
        
        
        
	public int getIdContrat() {
		return idContrat;
	}
	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}
	public String getLibelContrat() {
		return libelContrat;
	}
	public void setLibelContrat(String libelContrat) {
		this.libelContrat = libelContrat;
	}
	public String getDateEntrContrat() {
		return dateEntrContrat;
	}
	public void setDateEntrContrat(String dateEntrContrat) {
		this.dateEntrContrat = dateEntrContrat;
	}
	public String getDateSortContrat() {
		return dateSortContrat;
	}
	public void setDateSortContrat(String dateSortContrat) {
		this.dateSortContrat = dateSortContrat;
	}
	public double getSalaireContrat() {
		return salaireContrat;
	}
	public void setSalaireContrat(double salaireContrat) {
		this.salaireContrat = salaireContrat;
	}
	
	
	
	

}
