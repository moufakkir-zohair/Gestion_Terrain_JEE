package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection_BD.SingletonConnection;

public class StatistiqueImp implements IStatistique {

	@Override
	public Long NbrReservation(Long id_compte) {
	    Long nbrR = (long) 0;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS STATRES FROM reservation WHERE id_compte = ?");
			ps.setLong(1, id_compte);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				nbrR = rs.getLong("STATRES");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return nbrR ;
	}

	@Override
	public Long NbrReclamtion(Long id_compte) {
		Long nbrR = (long) 0;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS STATREC FROM reclamation WHERE id_compte = ?");
			ps.setLong(1, id_compte);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				nbrR = rs.getLong("STATREC");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return nbrR ;
	}

	@Override
	public Long ReservationParMois(Long id_compte, String annee, String mois) {
		 Long nbrR = (long) 0;
			Connection connection = SingletonConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS STATRES FROM reservation WHERE id_compte = ? and date_reservation like ? ");
				ps.setLong(1, id_compte);
				ps.setString(2, "%"+annee+"-"+mois+"%");
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					nbrR = rs.getLong("STATRES");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return nbrR ;
	}

	@Override
	public Long NbrReclamtionParMois(Long id_compte, String annee, String mois) {
		Long nbrR = (long) 0;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS STATREC FROM reclamation WHERE id_compte = ? and date_reclamation like ? ");
			ps.setLong(1, id_compte);
			ps.setString(2, "%"+annee+"-"+mois+"%");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				nbrR = rs.getLong("STATREC");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return nbrR ;
	}

	@Override
	public Long NbrReservationTotal() {
		 Long nbrR = (long) 0;
			Connection connection = SingletonConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS STATRES FROM reservation");
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					nbrR = rs.getLong("STATRES");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return nbrR ;
	}

	@Override
	public Long NbrReclamtionTotal() {
		Long nbrR = (long) 0;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS STATREC FROM reclamation");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				nbrR = rs.getLong("STATREC");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return nbrR ;
	}

	@Override
	public Long ReservationParMoisTotal(String annee, String mois) {
		 Long nbrR = (long) 0;
			Connection connection = SingletonConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS STATRES FROM reservation WHERE  date_reservation like ? ");
				ps.setString(1, "%"+annee+"-"+mois+"%");
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					nbrR = rs.getLong("STATRES");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return nbrR ;
	}

	@Override
	public Long NbrReclamtionParMoisTotal(String annee, String mois) {
		 Long nbrR = (long) 0;
			Connection connection = SingletonConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS STATRES FROM reclamation WHERE  date_reclamation like ? ");
				ps.setString(1, "%"+annee+"-"+mois+"%");
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					nbrR = rs.getLong("STATRES");
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return nbrR ;
	}

	@Override
	public Long NbreClient() {
		 Long nbrR = (long) 0;
			Connection connection = SingletonConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS STATRES FROM compte WHERE is_admin =0 ");
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

