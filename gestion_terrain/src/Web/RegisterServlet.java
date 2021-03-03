package Web;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;
import Metier.entities.*;

public class RegisterServlet extends HttpServlet {
    
	private ICompte compteDAO;
	
	@Override
	public void init() throws ServletException {
		compteDAO = new CompteImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);

		 if (path.equals("/Register")) {
			request.getRequestDispatcher("Views/Register.jsp").forward(request, response);
			
		 } 
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		 if (path.equals("/SaveCompte")) {
				String prenom = request.getParameter("prenom");
				String nom = request.getParameter("nom");
				String tele = request.getParameter("tele");
				String cin = request.getParameter("cin");
				String mdp = request.getParameter("mdp");
				String cmdp = request.getParameter("cmdp");
				String mail = request.getParameter("email");
				if (mdp.equals(cmdp)) {
					if (!compteDAO.VerifierRegister(mail, cin)) {
						System.out.println("nouveau client");
						String MDPhacharge;
						try {
							MDPhacharge = compteDAO.CryptageMDP(compteDAO.getSHA(mdp));
							Compte C = new Compte(nom, prenom, cin, tele, mail, MDPhacharge, false);
							compteDAO.SaveCompte(C);
							response.sendRedirect("Login");
						} catch (NoSuchAlgorithmException e) {
							response.sendRedirect("/Register");
						}
					} else {
						Compte C = new Compte(nom, prenom, cin, tele, mail, mdp, false);
						request.setAttribute("C", C);
						request.setAttribute("error", "client déjà existe");
						request.getRequestDispatcher("Views/Register.jsp").forward(request, response);
						System.out.println("client déjà existe");
					}
				} else {
					System.out.println("confirmer votre mot de passe");
					Compte C = new Compte(nom, prenom, cin, tele, mail, mdp, false);
					request.setAttribute("C", C);
					request.setAttribute("error", "confirmer votre mot de passe");
					request.getRequestDispatcher("Views/Register.jsp").forward(request, response);
				}
			}
	}
}
