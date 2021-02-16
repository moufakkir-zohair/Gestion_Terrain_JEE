package Metier.entities;

import java.util.Date;

public class Reservation {

	//les attributs
	private Long id_reservation;
	private Long id_compte;
	private String date_reservation;
	private Integer heure_reservation;
	private String Type_reservation;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation( Long id_compte, String date_reservation,Integer heure_reservation, String type_reservation) {
		super();
		this.id_compte = id_compte;
		this.date_reservation = date_reservation;
		this.heure_reservation = heure_reservation;
		this.Type_reservation = type_reservation;
	}
	//les setters et les getters
	
	public Long getId_compte() {
		return id_compte;
	}
	public void setId_compte(Long id_compte) {
		this.id_compte = id_compte;
	}
	public String getDate_reservation() {
		return date_reservation;
	}
	public void setDate_reservation(String date_reservation) {
		this.date_reservation = date_reservation;
	}
	public Integer getHeure_reservation() {
		return heure_reservation;
	}
	public void setHeure_reservation(Integer heure_reservation) {
		this.heure_reservation = heure_reservation;
	}
	
	public String getType_reservation() {
		return Type_reservation;
	}
	public void setType_reservation(String type_reservation) {
		Type_reservation = type_reservation;
	}
	public Long getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(Long id_reservation) {
		this.id_reservation = id_reservation;
	}
	
	
	
	
}
