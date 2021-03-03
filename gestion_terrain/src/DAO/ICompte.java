package DAO;

import java.security.NoSuchAlgorithmException;

import Metier.entities.Compte;

public interface ICompte {
	public Compte VerifierCompte(String Email, String MDP);
	public Compte SaveCompte(Compte C);
	public boolean VerifierRegister(String Email, String CIN);
	public void Modifier_Compte(String nom,String prenom,String cin,String tele,String mail,String mdp,Long id);
	public  byte[] getSHA(String input) throws NoSuchAlgorithmException  ;
	public  String CryptageMDP(byte[] hash) ;
}
