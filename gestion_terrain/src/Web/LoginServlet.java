package Web;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Metier.entities.*;

public class LoginServlet extends HttpServlet {
	private ICompte compteDAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		compteDAO = new CompteImp();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		
        if (path.equals("/Login")) {
			request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
		} else if (path.equals("/Deconnecter")) {
			 HttpSession session = request.getSession();
			 session.removeAttribute("Client");
			 session.removeAttribute("Admin");
			 session.invalidate();
			 response.sendRedirect("Login");
		}
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/VerifierCompte") && (request.getMethod().equals("POST"))) {
			String email = request.getParameter("email");
			String mdp = request.getParameter("password");
			try {
				Compte c = compteDAO.VerifierCompte(email, compteDAO.CryptageMDP(compteDAO.getSHA(mdp)));
				HttpSession session = request.getSession();
				if (c == null) {
					System.out.println("ffffffffff");
					request.setAttribute("email", email);
					request.setAttribute("error", "mot de passe ou mail est incorrect");
					request.getRequestDispatcher("Views/Login.jsp").forward(request, response);
				} else if (c.isAdmin()) {
					session.setAttribute("Admin", c);
					response.sendRedirect("Acceuil_Admin");
				} else {
					session.setAttribute("Client", c);
					response.sendRedirect("Acceuil_Client");
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			

		} 
	}
	
	

}
