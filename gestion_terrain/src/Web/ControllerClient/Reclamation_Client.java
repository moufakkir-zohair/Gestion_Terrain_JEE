package Web.ControllerClient;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Metier.entities.*;

public class Reclamation_Client extends HttpServlet{
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
			Compte C = (Compte) session.getAttribute("Client");
			if (C != null) {
				Collection<Reclamation> reclamations = clientDAO.ConsulterSesReclamation(C.getId());
				request.setAttribute("reclamations", reclamations);
				request.getRequestDispatcher("Views/Client/Reclamation.jsp").forward(request, response);
			} else {
				response.sendRedirect("Login");
			}
		}

	
}
