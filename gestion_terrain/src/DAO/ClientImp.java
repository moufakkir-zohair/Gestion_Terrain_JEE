package DAO;

import java.sql.*;
import java.util.*;


import Connection_BD.SingletonConnection;
import Metier.entities.*;

public class ClientImp  implements IClient{
	private AdminImp admin = new AdminImp();
	@Override
	public void addReservation(Reservation R) {
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    try {
            connexion = SingletonConnection.getConnection();
            String sql = " insert into reservation(id_compte,date_reservation,heure,type_reservation) values(?,?,?,?) ";
	    	preparedStatement = connexion.prepareStatement(sql);
	    	preparedStatement.setLong( 1, R.getId_compte() );
	    	preparedStatement.setString( 2, R.getDate_reservation() );
	    	preparedStatement.setInt( 3, R.getHeure_reservation() );
	    	preparedStatement.setString( 4, R.getType_reservation());
	    	preparedStatement.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();
        }
	}
	

	@Override
	public Reclamation AddReclamation(Reclamation R) {
	      Connection connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("INSERT INTO reclamation (id_compte,description,type_reclamation,date_reclamation) VALUES (?,?,?,?)");
	            ps.setLong(1, R.getCompte().getId());
	            ps.setString(2, R.getDescription());
	            ps.setString(3, R.getType_Reclamation());
	            ps.setDate(4, new java.sql.Date(R.getDate_reclamation().getTime()));
	            ps.executeUpdate();
	            PreparedStatement ps2=connection.prepareStatement("SELECT MAX(id_reclamation) AS MAXID FROM reclamation");            
	            ResultSet rs = ps2.executeQuery();
	            if(rs.next()) {
	                R.setId_reclamation(rs.getLong("MAXID"));
	            }
	            ps.close();
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	        return R;
	}
		 
		
	

	@Override
	public Collection<Reservation> ConsulterSesReservation(Integer id_compte) {
	        Collection < Reservation > Reservations = new ArrayList<Reservation>();
	        Connection  connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("SELECT * FROM reservation WHERE id_compte=?");
	            ps.setInt(1, id_compte);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	                Reservation R=new Reservation();
	                R.setId_reservation(rs.getLong("id_reservation"));
	                R.setType_reservation(rs.getString("type_reservation"));
	                R.setDate_reservation(rs.getDate("date_reservation").toString());
	                R.setHeure_reservation(rs.getInt("heure"));
	                Reservations.add(R);
	            }
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	        return Reservations ;
	    }


	@Override
	public Collection<Reclamation> ConsulterSesReclamation(long id_compte) {
		 Collection < Reclamation > Reclamations = new ArrayList<Reclamation>();
	        Connection  connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("SELECT * FROM reclamation WHERE id_compte=? order by id_reclamation DESC");
	            ps.setLong(1, id_compte);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	                Reclamation R=new Reclamation();
	                R.setDescription(rs.getString("description"));
	                R.setType_Reclamation(rs.getString("type_reclamation"));
	                R.setCompte(admin.getCompte(rs.getLong("id_compte")));
	                R.setId_reclamation(rs.getLong("id_reclamation"));
	                R.setDate_reclamation(rs.getDate("date_reclamation"));
	                Reclamations.add(R);
	            }
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	        return Reclamations ;
	}


	@Override
	public void SupprimerReclamation(long id_reclamation) {
		  Connection connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("DELETE FROM reclamation WHERE id_reclamation = ?");
	            ps.setLong(1, id_reclamation);
	            ps.executeUpdate();
	            ps.close();
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	      
		
	}


	@Override
	public void ModifierReclamation(long id_reclamation, String terrain, String reclamation) {
		 Connection  connection=SingletonConnection.getConnection();
	        try {
	        	
	            PreparedStatement ps=connection.prepareStatement("update reclamation set type_reclamation = ? , description = ? where id_reclamation = ?");
	            ps.setString(1, terrain);
	            ps.setString(2, reclamation);
	            ps.setLong(3, id_reclamation);
	            ps.executeUpdate();
	            ps.close();
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	        
	        
		
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
		    result = statement.executeQuery("select * from reservation where type_reservation ='"+typeReserve+"'" ); 
		    while(result.next()) {
		    	Long id = result.getLong("id_compte");
		    	String date = result.getDate("date_reservation").toString();
		    	Integer time = result.getInt("heure");
		    	String type = result.getString("type_reservation");
		    	Long id_reservation = result.getLong("id_reservation");
		    	reservation = new Reservation(id,date,time,type);
		    	reservation.setId_reservation(id_reservation);
		    	reservations.add(reservation);
        }
        	
        }catch(SQLException e) {
            e.printStackTrace();
        
	}
	 return reservations;

	}


	@Override
	public void AnnulerReservation(long id_reservation) {
	
		 Connection connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("DELETE FROM reservation WHERE id_reservation = ?");
	            ps.setLong(1, id_reservation);
	            ps.executeUpdate();
	            ps.close();
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	}


	@Override
	public Long nbreReservationDay(long id_compte, String jour, String annee, String mois , String type) {
		
		 Long nbrR = (long) 0;
			Connection connection = SingletonConnection.getConnection();
			
			try {
				PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS STATRES FROM reservation WHERE id_compte = ? and  date_reservation like ? and type_reservation= ? ");
				ps.setLong(1, id_compte);
				if(Integer.parseInt(jour)<10) {
					ps.setString(2, "%"+annee+"-"+mois+"-"+0+jour+"%");
				}else {
					ps.setString(2, "%"+annee+"-"+mois+"-"+jour+"%");
				}
				ps.setString(3, type);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					nbrR = rs.getLong("STATRES");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return nbrR ;
	}


	

}
