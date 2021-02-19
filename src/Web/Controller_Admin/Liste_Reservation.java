package Web.Controller_Admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import Metier.entities.Compte;
import Metier.entities.Reservation;



public class Liste_Reservation extends HttpServlet  {
	
	private ICompte compteDAO;
	private IAdmin AdminDAO;
	private IStatistique statistique;
	
	
	// fonction qui return les 7 suivant jours
	public  String[] nextDate() throws ParseException {
	    String[] dates = new String[7];
	    Date dt = new Date();
	    Calendar cc = Calendar.getInstance();
	    cc.setTime(dt);
	    dt = cc.getTime();
	    SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd");
	    String date_now = Date.format(dt);
	    dates[0] = date_now;
	    for (int i = 1; i < 7; i++) {
	        Calendar c = Calendar.getInstance();
	        c.setTime(dt);
	        c.add(Calendar.DATE, 1);
	        dt = c.getTime();
	        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	        String date = DATE_FORMAT.format(dt);
	        dates[i] = date;
	        dt = new SimpleDateFormat("yyyy-MM-dd").parse(date);
	    }
	    return dates;
	}
	
	
	//fonction qui verifie si une reservation existe ou non
	public Reservation contains(List<Reservation> list, Reservation instance) {
		for(Reservation res : list) {
			if( res.getType_reservation().equals(instance.getType_reservation()) &&
				res.getDate_reservation().equals(instance.getDate_reservation()) &&
				res.getHeure_reservation().equals(instance.getHeure_reservation()) )  
				return res;
			}
		return null;
    }
	
	
	    public static final String VUE = "/Views/Admin/ListeReservation.jsp";
	    public void init() throws ServletException {
			super.init();
			compteDAO = new CompteImp();
			AdminDAO = new AdminImp();
			statistique = new StatistiqueImp();
		}
		public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
			
			String type = request.getParameter("type");
			request.setAttribute("typeReserve", type);
			String[] dates = new String[7];
			Boolean[][] isAvailable = new Boolean[11][7];
			Compte[][] CompteReservations = new Compte[11][7];
			List<Reservation> reservations = new ArrayList<Reservation>();

		    try {
				    dates = nextDate();
			} catch (ParseException e) {
				e.printStackTrace();
			}

			reservations = AdminDAO.trouverParType(type); 
			for(int i=0;i<isAvailable.length;i++) {
				for(int j = 0; j<isAvailable[i].length;j++) {
					Reservation res = new Reservation();
					res.setDate_reservation(dates[j]);
					res.setHeure_reservation(i+9);
					res.setType_reservation(type);
					if(contains(reservations, res)==null) {
						isAvailable[i][j] = false;
						CompteReservations[i][j]=null;
					}
					else {
						isAvailable[i][j] = true;
						CompteReservations[i][j]=AdminDAO.Voir_info_reservation(contains(reservations, res));
					}
					}
				}

			request.setAttribute("IsAvailable", isAvailable);
			request.setAttribute("nextDate", dates);
			request.setAttribute("CompteReservations", CompteReservations);
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
		
		
		
		
		
		
		
	
	
		

}
