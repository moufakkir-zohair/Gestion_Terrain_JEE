package Web.Controller_Admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Metier.entities.*;

public class Acceuil extends HttpServlet {
	
	private IStatistique statistique;
	
	@Override
	public void init() throws ServletException {
		statistique = new StatistiqueImp();
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			Compte C = (Compte) session.getAttribute("Admin");
			if (C != null) {
			Date date = new Date();
		    SimpleDateFormat year = new SimpleDateFormat("YYYY"); 
		    Long janvier = statistique.NbrReclamtionParMoisTotal(year.format(date), "01");
		    Long fevrier = statistique.NbrReclamtionParMoisTotal(year.format(date), "02");
		    Long mars = statistique.NbrReclamtionParMoisTotal(year.format(date), "03");
		    Long avril = statistique.NbrReclamtionParMoisTotal( year.format(date), "04");
		    Long mai = statistique.NbrReclamtionParMoisTotal(year.format(date), "05");
		    Long juin = statistique.NbrReclamtionParMoisTotal(year.format(date), "06");
		    Long juillet = statistique.NbrReclamtionParMoisTotal(year.format(date), "07");
		    Long aout = statistique.NbrReclamtionParMoisTotal( year.format(date), "08");
		    Long septembre = statistique.NbrReclamtionParMoisTotal(year.format(date), "09");
		    Long octobre = statistique.NbrReclamtionParMoisTotal(year.format(date), "10");
		    Long novembre = statistique.NbrReclamtionParMoisTotal(year.format(date), "11");
		    Long decembre = statistique.NbrReclamtionParMoisTotal(year.format(date), "12");
			
			session.setAttribute("janvier", janvier);  
			session.setAttribute("fevrier", fevrier);
			session.setAttribute("mars", mars);
			session.setAttribute("avril", avril);
			session.setAttribute("mai", mai);
			session.setAttribute("juin", juin);
			session.setAttribute("juillet", juillet);
			session.setAttribute("aout", aout);
			session.setAttribute("septembre", septembre);
			session.setAttribute("octobre", octobre);
			session.setAttribute("novembre", novembre);
			session.setAttribute("decembre", decembre);
			
			
			
			Long janvier1 = statistique.ReservationParMoisTotal(year.format(date), "01");
		    Long fevrier2 = statistique.ReservationParMoisTotal(year.format(date), "02");
		    Long mars3 = statistique.ReservationParMoisTotal( year.format(date), "03");
		    Long avril4 = statistique.ReservationParMoisTotal( year.format(date), "04");
		    Long mai5 = statistique.ReservationParMoisTotal( year.format(date), "05");
		    Long juin6 = statistique.ReservationParMoisTotal(year.format(date), "06");
		    Long juillet7 = statistique.ReservationParMoisTotal(year.format(date), "07");
		    Long aout8 = statistique.ReservationParMoisTotal(year.format(date), "08");
		    Long septembre9 = statistique.ReservationParMoisTotal(year.format(date), "09");
		    Long octobre10 = statistique.ReservationParMoisTotal( year.format(date), "10");
		    Long novembre11 = statistique.ReservationParMoisTotal(year.format(date), "11");
		    Long decembre12 = statistique.ReservationParMoisTotal(year.format(date), "12");
			
			session.setAttribute("janvier1", janvier1);  
			session.setAttribute("fevrier2", fevrier2);
			session.setAttribute("mars3", mars3);
			session.setAttribute("avril4", avril4);
			session.setAttribute("mai5", mai5);
			session.setAttribute("juin6", juin6);
			session.setAttribute("juillet7", juillet7);
			session.setAttribute("aout8", aout8);
			session.setAttribute("septembre9", septembre9);
			session.setAttribute("octobre10", octobre10);
			session.setAttribute("novembre11", novembre11);
			session.setAttribute("decembre12", decembre12);
			
			Long TotalCompte = statistique.NbreClient();
			Long nbreReservation = statistique.NbrReservationTotal();
			Long nbreReclamation = statistique.NbrReclamtionTotal();
			session.setAttribute("nbreReservation", nbreReservation);
			session.setAttribute("nbreReclamation", nbreReclamation);
			session.setAttribute("TotalCompte", TotalCompte);
			session.setAttribute("Admin", C);
			request.getRequestDispatcher("Views/Admin/Acceuil.jsp").forward(request, response);
			}else {
				response.sendRedirect("Login");
			}
		}

}
