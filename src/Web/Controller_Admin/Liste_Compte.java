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

public class Liste_Compte extends HttpServlet{

	private IAdmin admin;
	@Override
	public void init() throws ServletException {
		admin = new AdminImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		if (path.equals("/Liste_Compte")) {
			HttpSession session = request.getSession();
			Compte C = (Compte) session.getAttribute("Admin");
			if (C != null) {
				Collection<Compte> comptes = admin.ListeCompte();
				request.setAttribute("comptes", comptes);
				request.getRequestDispatcher("Views/Admin/ListeCompte.jsp").forward(request, response);
			} else {
				response.sendRedirect("Login");
			}
		}
	}
}
	
	