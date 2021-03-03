package Metier.entities;

import java.io.Serializable;

public class Compte implements Serializable{

    private long id;
    private  String nom;
    private  String prenom;
    private  String cin;
    private  String telephon;
    private  String email;
    private  String mdp;
    private boolean isAdmin;
    
    public Compte() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Compte(String nom, String prenom, String cin, String telephon, String email, String mdp, boolean isAdmin) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.telephon = telephon;
        this.email = email;
        this.mdp = mdp;
        this.isAdmin = isAdmin;
    }
    public void setId(long id) {
		this.id = id;
	}

	public long getId() {
        return id;
    }
 
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public String getTelephon() {
        return telephon;
    }
    public void setTelephon(String telephon) {
        this.telephon = telephon;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
   
}
