package Web.Controller_Admin;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Metier.entities.*;

public class Modifier_MDP extends HttpServlet{

	private IAdmin admin;
	private ICompte compte;
	@Override
	public void init() throws ServletException {
		admin = new AdminImp();
		compte = new CompteImp();
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			Compte C = (Compte) session.getAttribute("Admin");
			if (C != null) {
				String id_compte = request.getParameter("edit_id");
				String MDP = request.getParameter("mdp");
				String MDPhacharge;
				try {
					MDPhacharge = compte.CryptageMDP(compte.getSHA(MDP));
					admin.ModifierMDP(Long.parseLong(id_compte),MDPhacharge);
					response.sendRedirect("Liste_Compte");
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				response.sendRedirect("Login");
			}
		
	}
}
