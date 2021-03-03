package Web.ControllerClient;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Metier.entities.*;

public class Supprimer_Reclamation extends HttpServlet {

	private ICompte compteDAO;
	private IClient clientDAO;
	private IStatistique statistique;
	private IAdmin admin;

	@Override
	public void init() throws ServletException {
		super.init();
		compteDAO = new CompteImp();
		clientDAO = new ClientImp();
		statistique = new StatistiqueImp();
		admin = new AdminImp();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respons)
			throws ServletException, IOException {

			HttpSession session = request.getSession();
			Compte C = (Compte) session.getAttribute("Client");
			if (C != null) {
				String id_reclamation = request.getParameter("delete_id");
				clientDAO.SupprimerReclamation(Integer.parseInt(id_reclamation));
				respons.sendRedirect("Reclamation_Client");
			}else {
				respons.sendRedirect("Login");
			}
		
		
	}
}
