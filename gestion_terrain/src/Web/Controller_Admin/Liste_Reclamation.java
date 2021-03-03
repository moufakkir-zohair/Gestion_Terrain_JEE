package Web.Controller_Admin;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminImp;
import DAO.ClientImp;
import DAO.IAdmin;
import DAO.IClient;
import Metier.entities.Compte;
import Metier.entities.Reclamation;

public class Liste_Reclamation extends HttpServlet{
	private IClient clientDAO;
	private IAdmin admin;
	
	@Override
	public void init() throws ServletException {
		clientDAO = new ClientImp();
		admin = new AdminImp();
	}
 @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			Compte C = (Compte) session.getAttribute("Admin");
			if (C != null) {
				Collection<Reclamation> reclamations = admin.ListeReclamation();
				request.setAttribute("reclamations", reclamations);
				request.getRequestDispatcher("Views/Admin/ListeReclamation.jsp").forward(request, response);
			} else {
				response.sendRedirect("Login");
			}
		}
	
}
