package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import Connection_BD.SingletonConnection;
import Metier.entities.*;

public class AdminImp implements IAdmin {
	
	@Override
	public Compte getCompte(Long i) {
		Compte C = null;
	        Connection  connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("SELECT * FROM Compte WHERE id_compte=?");
	            ps.setLong(1, i);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	                C=new Compte();
	                C.setNom(rs.getString("Nom"));
	                C.setPrenom(rs.getString("Prenom"));
	                C.setEmail(rs.getString("Email"));
	                C.setTelephon(rs.getString("Telephone"));
	                C.setCin(rs.getString("CIN"));
	                C.setId(rs.getLong("Id_Compte"));
	                C.setMdp(rs.getString("MDP"));
	                C.setAdmin(rs.getBoolean("IS_ADMIN"));
	            }
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	        return C ;
	}
	
	
	
	@Override
	public void ModifierMDP(Long id_compte , String mdp) {
		   Connection  connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("update compte set mdp=? where id_compte=?");
	            ps.setString(1, mdp);
	            ps.setLong(2, id_compte);
	            ps.executeUpdate();
	            ps.close();
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void SupprimerCompte(Long id_compte) {
		        Connection connection=SingletonConnection.getConnection();
		        try {
		            PreparedStatement ps=connection.prepareStatement("DELETE FROM COMPTE WHERE ID_COMPTE = ?");
		            ps.setLong(1, id_compte);
		            ps.executeUpdate();
		            ps.close();
		        }catch(SQLException e) {
		            e.printStackTrace();
		        }
		      
    }


	@Override
	public void AnnulerReservation(Long id_reservation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Reservation> ListeReservation() {
		  Collection < Reservation > Reservations = new ArrayList<Reservation>();
	        Connection  connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("SELECT * FROM Reservation");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	                Reservation R=new Reservation();
	                R.setId_reservation(rs.getLong("ID_RESERVATION"));
	                R.setType_reservation(rs.getString("Type_RESERVATION"));
	                R.setDate_reservation(rs.getDate("DATE_RESERVATION").toString());
	                Reservations.add(R);
	            }
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	        return Reservations ;
	}

	@Override
	public Collection<Reclamation> ListeReclamation() {
		 Collection < Reclamation > Reclamations = new ArrayList<Reclamation>();
	        Connection  connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("SELECT *  FROM reclamation");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	                Reclamation R=new Reclamation();
	                R.setDescription(rs.getString("DESCRIPTION"));
	                R.setType_Reclamation(rs.getString("TYPE_RECLAMATION"));
	                R.setCompte(getCompte(rs.getLong("ID_COMPTE")));
	                R.setId_reclamation(rs.getLong("ID_RECLAMATION"));
	                R.setDate_reclamation(rs.getDate("DATE_RECLAMATION"));
	                Reclamations.add(R);
	            }
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	        return Reclamations ;
	}



	@Override
	public Collection<Compte> ListeCompte() {
		 Collection < Compte > comptes = new ArrayList<Compte>();
	        Connection  connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("SELECT * FROM compte where is_admin=0");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	                Compte R=new Compte();
	                R.setNom(rs.getString("Nom"));
	                R.setPrenom(rs.getString("Prenom"));
	                R.setEmail(rs.getString("Email"));
	                R.setId(rs.getLong("ID_COMPTE"));
	                R.setCin(rs.getString("CIN"));
	                R.setTelephon(rs.getString("Telephone"));
	                R.setMdp(rs.getString("MDP"));
	                comptes.add(R);
	            }
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	        return comptes ;
	}
	
	@Override
	public List<Reservation> trouverParType(String typeReserve) {
		List<Reservation> reservations = new ArrayList<Reservation>();
		Connection connexion = null;
	    Statement statement = null;
	    ResultSet result = null;
	    Reservation reservation = null;
        try {
        	connexion = SingletonConnection.getConnection();
        	statement = connexion.createStatement();
		    result = statement.executeQuery("select id_compte,date_reservation,heure,type_reservation from reservation where type_reservation ='"+typeReserve+"'" ); 
		    while(result.next()) {
		    	Long id = result.getLong("id_compte");
		    	String date = result.getDate("date_reservation").toString();
		    	Integer time = result.getInt("heure");
		    	String type = result.getString("type_reservation");
		    	reservation = new Reservation(id,date,time,type);
		    	reservations.add(reservation);
        }
        	
        }catch(SQLException e) {
            e.printStackTrace();
        
	}
	 return reservations;

	}
	

	
	@Override
	public Collection<Reservation> ConsulterSesReservation() {
	        Collection < Reservation > Reservations = new ArrayList<Reservation>();
	        Connection  connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("SELECT * FROM Reservation ");
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	                Reservation R=new Reservation();
	                R.setId_reservation(rs.getLong("ID_RESERVATION"));
	                R.setType_reservation(rs.getString("Type_RESERVATION"));
	                R.setId_compte(rs.getLong("ID_COMPTE"));
	                R.setDate_reservation(rs.getDate("DATE_RESERVATION").toString());
	                R.setHeure_reservation(rs.getInt("heure"));
	                Reservations.add(R);
	            }
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	        return Reservations ;
	    }
	
	



	
	
	@Override
	public int get_id_compte(String type,String date,int heur) {
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
        int id_compte = 0;
	    try {
            connexion = SingletonConnection.getConnection();
            String sql = " SELECT ID_COMPTE AS id_compte FROM Reservation WHERE Type_RESERVATION=? and DATE_RESERVATION=? and heure=? ";
	    	preparedStatement = connexion.prepareStatement(sql);
	    	preparedStatement.setString( 1, type );
	    	//preparedStatement.setDate(2,  date);
            ResultSet rs = preparedStatement.executeQuery();
	    	 while(rs.next()) {
	              id_compte =  rs.getInt("id_compte");
	            }
	    	 
        }catch(SQLException e) {
            e.printStackTrace();
        }
	    
	    return id_compte;
	}



	@Override
	public Compte Voir_info_reserv(Reservation R) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Compte Voir_info_reservation(Reservation R) {
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    Compte C = null;
	    try {
            connexion = SingletonConnection.getConnection();
            String sql = " SELECT * FROM Compte WHERE id_compte=? ";
	    	preparedStatement = connexion.prepareStatement(sql);
	    	preparedStatement.setLong( 1, R.getId_compte() );
	    	
            ResultSet rs = preparedStatement.executeQuery();
	    	 while(rs.next()) {
	                C=new Compte();
	                C.setNom(rs.getString("Nom"));
	                C.setPrenom(rs.getString("Prenom"));
	                C.setEmail(rs.getString("Email"));
	                C.setTelephon(rs.getString("Telephone"));
	                C.setCin(rs.getString("CIN"));
	                C.setId(rs.getLong("Id_Compte"));
	                C.setMdp(rs.getString("MDP"));
	                C.setAdmin(rs.getBoolean("IS_ADMIN"));
	            }
	    	 
        }catch(SQLException e) {
            e.printStackTrace();
        }
	    
	    return C;
	}



	

	
}
