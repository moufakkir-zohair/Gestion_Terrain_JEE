package Web;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminImp;
import DAO.CompteImp;
import DAO.IAdmin;
import DAO.IClient;
import DAO.ICompte;
import Metier.entities.Compte;

public class ProfilServlet extends HttpServlet{

	private ICompte compte ;
	private IAdmin admin;
	@Override
	public void init() throws ServletException {
		compte = new CompteImp();
		admin = new AdminImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String path = request.getServletPath();
		 System.out.println(path);
		 if (path.equals("/Profil_Admin")) {
				HttpSession session = request.getSession();
				Compte C = (Compte) session.getAttribute("Admin");
				if (C != null) {
					session.setAttribute("Compte", C);
					request.getRequestDispatcher("Views/Admin/Profil_Admin.jsp").forward(request, response);
				} else {
					response.sendRedirect("Login");
				}
			} else  if (path.equals("/Profil_Client")) {
				HttpSession session = request.getSession();
				Compte C = (Compte) session.getAttribute("Client");
				if (C != null) {
					session.setAttribute("Compte", C);
					request.getRequestDispatcher("Views/Client/Profil_Client.jsp").forward(request, response);
				} else {
					response.sendRedirect("Login");
				}
			}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String tele = request.getParameter("telephone");
		String cin = request.getParameter("cin");
		String mdp = request.getParameter("mdp");
		String mail = request.getParameter("email");
		String edit_id = request.getParameter("edit_id");
		HttpSession session = request.getSession();
		Compte ad = (Compte) session.getAttribute("Admin");
		Compte cl = (Compte) session.getAttribute("Client");

		if (ad != null) {
			 try {
				String MDPhacharge = compte.CryptageMDP(compte.getSHA(mdp));
				compte.Modifier_Compte(nom,prenom,cin,tele,mail,MDPhacharge,Long.parseLong(edit_id));
				 session.removeAttribute("Admin");
				 Compte NouveauCompte = admin.getCompte(Long.parseLong(edit_id));
				 session.setAttribute("Admin", NouveauCompte);
				 response.sendRedirect("Profil_Admin");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			 
		} else if (cl != null) {
			try {
				String MDPhacharge = compte.CryptageMDP(compte.getSHA(mdp));
				compte.Modifier_Compte(nom,prenom,cin,tele,mail,MDPhacharge,Long.parseLong(edit_id));
				session.removeAttribute("Client");
				Compte NouveauCompte = admin.getCompte(Long.parseLong(edit_id));
				session.setAttribute("Client", NouveauCompte);
				response.sendRedirect("Profil_Client");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
		}
		else {
			response.sendRedirect("Login");
		}
}
}
