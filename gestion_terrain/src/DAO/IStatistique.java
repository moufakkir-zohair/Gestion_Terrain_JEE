package DAO;

public interface IStatistique {
	
	//pour le client
	public Long NbrReservation(Long id_compte);
	public Long NbrReclamtion(Long id_compte);
	public Long ReservationParMois(Long id_compte,String annee,String mois);
	public Long NbrReclamtionParMois(Long id_compte,String annee,String mois);
	
	
	
	//pour l'admin
	public Long NbrReservationTotal();
	public Long NbrReclamtionTotal();
	public Long ReservationParMoisTotal(String annee,String mois);
	public Long NbrReclamtionParMoisTotal(String annee,String mois);
	public Long NbreClient();
}
