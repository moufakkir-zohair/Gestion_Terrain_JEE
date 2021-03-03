package Web.Controller_Admin;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminImp;
import DAO.IAdmin;
import Metier.entities.Compte;

public class Supprimer_Compte extends HttpServlet{

	private IAdmin admin;
	@Override
	public void init() throws ServletException {
		admin = new AdminImp();
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			Compte C = (Compte) session.getAttribute("Admin");
			if (C != null) {
				String id_compte = request.getParameter("delete_id");
				admin.SupprimerCompte(Long.parseLong(id_compte));
				response.sendRedirect("Liste_Compte");
			}else {
				response.sendRedirect("Login");
			}
	}		
}
