package DAO;

import java.util.Collection;
import java.util.List;


import Metier.entities.*;

public interface IClient {
	
	List<Reservation> trouverParType( String type );
	public void addReservation(Reservation R);
	public Reclamation AddReclamation(Reclamation R);
	public Collection<Reservation> ConsulterSesReservation(Integer id_compte);
	public Collection<Reclamation> ConsulterSesReclamation(long id_reclamation);
	public void SupprimerReclamation(long id_reclamation);
	public void ModifierReclamation(long id_reclamation,String terrain ,String reclamation );
	public void AnnulerReservation(long id_reservation);
	public Long nbreReservationDay(long id_compte , String jours,String annee,String mois,String type);
	
}
