package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import Connection_BD.SingletonConnection;
import Metier.entities.Compte;
import Metier.entities.Reclamation;

public class TestDAO {

	public static void main(String[] args) {
	    System.out.println("hhhhh");
		ClientImp Cl = new ClientImp();
		CompteImp compte = new CompteImp();
		
		Connection  connection=SingletonConnection.getConnection();
		if(connection==null) {
			System.out.println("echouc");
		}
		else {
			System.out.println("reussi");
		}
		
		Compte C = compte.VerifierCompte( "email.com", "123");
		
		System.out.println(C.getNom());
		
//		Compte C = new Compte("Zohair", "Moufakkir" ,"CD638723", "092728228" , "email.com" , "123" , false);
//		Cl.NewCompte(C);
		
		
//      Teste de d'inserer la reclamation
//      Reclamation r = Cl.AddReclamation(new Reclamation((long) 2, "String description", "type_Reclamation",new Date(2000, 10, 20)));
		
//	
//		Collection<Reclamation> rec = new ArrayList();
//		rec = Cl.ConsulterSesReclamation(5);
//		for(Reclamation R : rec ) {
//			System.out.println(R.getDescription());
//		}
//		
		
//      Test de recherche de Compte
//		AdminImp A = new AdminImp();
//	    Compte C = A.getCompte((long) 2);
//	    System.out.println(C.getNom());
		
		
		
	}

}
