package tp.metier;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class Compte implements Serializable{
	private int code;
	private double solde;
	private Date dateCreation;
	
	public Compte(int code, double solde) {
		this.code = code;
		this.solde = solde;
		dateCreation = Date.from(Instant.now());
	}
	
	public int getCode() {
		return code;
	}
	
	public double getSolde() {
		return solde;
	}
	
	public Date getDateCreation() {
		return dateCreation;
	}
	
	public void setSolde(int solde) {
		this.solde = solde;
	}
}
