package Web.ControllerClient;

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
			Compte C = (Compte) session.getAttribute("Client");
			if (C != null) {
			Date date = new Date();
		    SimpleDateFormat year = new SimpleDateFormat("YYYY"); 
		    Long janvier = statistique.NbrReclamtionParMois(C.getId(), year.format(date), "01");
		    Long février = statistique.NbrReclamtionParMois(C.getId(), year.format(date), "02");
		    Long mars = statistique.NbrReclamtionParMois(C.getId(), year.format(date), "03");
		    Long avril = statistique.NbrReclamtionParMois(C.getId(), year.format(date), "04");
		    Long mai = statistique.NbrReclamtionParMois(C.getId(), year.format(date), "05");
		    Long juin = statistique.NbrReclamtionParMois(C.getId(), year.format(date), "06");
		    Long juillet = statistique.NbrReclamtionParMois(C.getId(), year.format(date), "07");
		    Long août = statistique.NbrReclamtionParMois(C.getId(), year.format(date), "08");
		    Long septembre = statistique.NbrReclamtionParMois(C.getId(), year.format(date), "09");
		    Long octobre = statistique.NbrReclamtionParMois(C.getId(), year.format(date), "10");
		    Long novembre = statistique.NbrReclamtionParMois(C.getId(), year.format(date), "11");
		    Long décembre = statistique.NbrReclamtionParMois(C.getId(), year.format(date), "12");
			
			session.setAttribute("janvier", janvier);  
			session.setAttribute("février", février);
			session.setAttribute("mars", mars);
			session.setAttribute("avril", avril);
			session.setAttribute("mai", mai);
			session.setAttribute("juin", juin);
			session.setAttribute("juillet", juillet);
			session.setAttribute("août", août);
			session.setAttribute("septembre", septembre);
			session.setAttribute("octobre", octobre);
			session.setAttribute("novembre", novembre);
			session.setAttribute("décembre", décembre);
			
			
			
			Long janvier1 = statistique.ReservationParMois(C.getId(), year.format(date), "01");
		    Long février2 = statistique.ReservationParMois(C.getId(), year.format(date), "02");
		    Long mars3 = statistique.ReservationParMois(C.getId(), year.format(date), "03");
		    Long avril4 = statistique.ReservationParMois(C.getId(), year.format(date), "04");
		    Long mai5 = statistique.ReservationParMois(C.getId(), year.format(date), "05");
		    Long juin6 = statistique.ReservationParMois(C.getId(), year.format(date), "06");
		    Long juillet7 = statistique.ReservationParMois(C.getId(), year.format(date), "07");
		    Long août8 = statistique.ReservationParMois(C.getId(), year.format(date), "08");
		    Long septembre9 = statistique.ReservationParMois(C.getId(), year.format(date), "09");
		    Long octobre10 = statistique.ReservationParMois(C.getId(), year.format(date), "10");
		    Long novembre11 = statistique.ReservationParMois(C.getId(), year.format(date), "11");
		    Long décembre12 = statistique.ReservationParMois(C.getId(), year.format(date), "12");
			
			session.setAttribute("janvier1", janvier1);  
			session.setAttribute("février2", février2);
			session.setAttribute("mars3", mars3);
			session.setAttribute("avril4", avril4);
			session.setAttribute("mai5", mai5);
			session.setAttribute("juin6", juin6);
			session.setAttribute("juillet7", juillet7);
			session.setAttribute("août8", août8);
			session.setAttribute("septembre9", septembre9);
			session.setAttribute("octobre10", octobre10);
			session.setAttribute("novembre11", novembre11);
			session.setAttribute("décembre12", décembre12);
			
			
			Long nbreReservation = statistique.NbrReservation(C.getId());
			Long nbreReclamation = statistique.NbrReclamtion(C.getId());
			session.setAttribute("nbreReservation", nbreReservation);
			session.setAttribute("nbreReclamation", nbreReclamation);
			session.setAttribute("year", year);
			session.setAttribute("Client", C);
			request.getRequestDispatcher("Views/Client/Acceuil.jsp").forward(request, response);
			}
		}
}
