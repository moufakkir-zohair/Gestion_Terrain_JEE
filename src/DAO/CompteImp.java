package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connection_BD.SingletonConnection;
import Metier.entities.Compte;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;

public class CompteImp implements ICompte {

	@Override
	public Compte VerifierCompte(String Email, String MDP) {
		Compte C = null;
        Connection  connection=SingletonConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM Compte WHERE email=? and mdp =?");
            ps.setString(1, Email);
            ps.setString(2, MDP);
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
	public Compte SaveCompte(Compte C) {
	    Connection  connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("INSERT INTO COMPTE (NOM,PRENOM,CIN,TELEPHONE,EMAIL,MDP,is_admin) VALUES (?,?,?,?,?,?,?)");
	            ps.setString(1, C.getNom());
	            ps.setString(2, C.getPrenom());
	            ps.setString(3, C.getCin());
	            ps.setString(4, C.getTelephon());
	            ps.setString(5, C.getEmail());
	            ps.setString(6, C.getMdp());
	            ps.setBoolean(7, C.isAdmin());
	            ps.executeUpdate();
	            PreparedStatement ps2=connection.prepareStatement("SELECT MAX(ID_compte) AS MAXID FROM COMPTE");           
	            ResultSet rs = ps2.executeQuery();
	            if(rs.next()) {
	                C.setId(rs.getLong("MAXID"));
	            }
	            ps.close();
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return C;
	}


	@Override
	public boolean VerifierRegister(String Email, String CIN) {
        Connection  connection=SingletonConnection.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM Compte WHERE email=? or cin =?");
            ps.setString(1, Email);
            ps.setString(2, CIN);
            ResultSet rs = ps.executeQuery();
           if(rs.next()) return true; 
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false ;
	}



	@Override
	public void Modifier_Compte(String nom, String prenom, String cin, String tele, String mail, String mdp, Long id) {
		 Connection  connection=SingletonConnection.getConnection();
	        try {
	            PreparedStatement ps=connection.prepareStatement("update COMPTE set NOM=?,PRENOM=?,CIN=?,TELEPHONE=?,EMAIL=?,MDP=? where id_compte = ?");
	            ps.setString(1, nom);
	            ps.setString(2, prenom);
	            ps.setString(3, cin);
	            ps.setString(4, tele);
	            ps.setString(5, mail);
	            ps.setString(6, mdp);
	            ps.setLong(7, id);
	            ps.executeUpdate();
	            ps.close();
	        }catch(SQLException e) {
	            e.printStackTrace();
	        }
	}


	
	
	
	//// la fonction de hacharge 

	
	  public  byte[] getSHA(String input) throws NoSuchAlgorithmException 
	    {  
	         
	        MessageDigest md = MessageDigest.getInstance("SHA-256");  
	  
	        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
	    } 
	    
	    public  String CryptageMDP(byte[] hash) 
	    { 
	       
	        BigInteger number = new BigInteger(1, hash);  
	  	        
	        StringBuilder hexString = new StringBuilder(number.toString(16));  
	  
	        // Pad with leading zeros 
	        while (hexString.length() < 32)  
	        {  
	            hexString.insert(0, '0');  
	        }  
	  
	        return hexString.toString();  
	    } 
	  
	
	
	

	
	
}
