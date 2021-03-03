package Metier.entities;

import java.io.Serializable;
import java.util.Date;





public class Reclamation implements Serializable {
	
	//les attributs 
	
	private Long id_reclamation;
	private Compte compte;
	private String Description;
	private String Type_Reclamation;
	private Date date_reclamation;

	// les constructeurs
	
	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Reclamation(Compte compte, String description, String type_Reclamation, Date date_reclamation) {
		this.compte=compte;
		this.Description = description;
		this.Type_Reclamation = type_Reclamation;
		this.date_reclamation = date_reclamation;
	}



	//les setters et les getters 
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getType_Reclamation() {
		return Type_Reclamation;
	}
	public void setType_Reclamation(String type_Reclamation) {
		Type_Reclamation = type_Reclamation;
	}
	public Long getId_reclamation() {
		return id_reclamation;
	}

	
	public Compte getCompte() {
		return compte;
	}



	public void setCompte(Compte compte) {
		this.compte = compte;
	}



	public void setId_reclamation(Long id_reclamation) {
		this.id_reclamation = id_reclamation;
	}



	public Date getDate_reclamation() {
		return date_reclamation;
	}



	public void setDate_reclamation(Date date_reclamation) {
		this.date_reclamation = date_reclamation;
	}
	
	
}
