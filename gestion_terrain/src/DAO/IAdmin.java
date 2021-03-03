package DAO;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import Metier.entities.Compte;
import Metier.entities.Reclamation;
import Metier.entities.Reservation;

public interface IAdmin {
	public Compte getCompte(Long id_compte);
	public void ModifierMDP(Long id_compte , String mdp);
	public void SupprimerCompte(Long id_compte);
	public void AnnulerReservation(Long id_reservation);
	public Collection<Reservation> ListeReservation();
	public Collection<Reclamation> ListeReclamation();
	public Collection<Compte> ListeCompte();
	public List<Reservation> trouverParType(String typeReserve);
	public Collection<Reservation> ConsulterSesReservation();
	int get_id_compte(String type, String date, int heur);
	Compte Voir_info_reservation(Reservation R);
}
