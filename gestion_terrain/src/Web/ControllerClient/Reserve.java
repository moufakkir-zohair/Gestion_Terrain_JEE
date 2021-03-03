package Web.ControllerClient;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminImp;
import DAO.ClientImp;
import DAO.CompteImp;
import DAO.IAdmin;
import DAO.IClient;
import DAO.ICompte;
import DAO.IStatistique;
import DAO.StatistiqueImp;
import Metier.entities.Compte;
import Metier.entities.Reservation;



public class Reserve extends HttpServlet  {
	
	private ICompte compteDAO;
	private IClient clientDAO;
	private IStatistique statistique;
	private IAdmin AdminDAO;
	
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
	
	
	    public static final String VUE = "/Views/Client/reservation.jsp";
	    public void init() throws ServletException {
			super.init();
			compteDAO = new CompteImp();
			clientDAO = new ClientImp();
			statistique = new StatistiqueImp();
			AdminDAO = new AdminImp();
		}
	    
	    
		public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
			String type = request.getParameter("type");
			request.setAttribute("typeReserve", type);
			String[] dates = new String[7];
			Boolean[][] isAvailable = new Boolean[11][7];
			Compte[][] CompteReservations = new Compte[11][7];
			Reservation[][] ListeReservations = new Reservation[11][7];
			Long [] nbreReservationDay = new Long[7];
			
			
			
			
			// le remplissage de tableau concerant les reservations de client actuelle par jours.
			HttpSession session = request.getSession();
			Compte C = (Compte) session.getAttribute("Client");
			Date date = new Date();
		    SimpleDateFormat year = new SimpleDateFormat("YYYY"); 
		    SimpleDateFormat day = new SimpleDateFormat("d"); 
		    int dayInt = Integer.parseInt(day.format(date));
		    SimpleDateFormat month = new SimpleDateFormat("MM"); 
		    
		    
		    
		    
		    
		    
		    // 
		    SimpleDateFormat dateoo = new SimpleDateFormat("yyyy-MM-dd");
		    String date_now = dateoo.format(date);
		    
		    SimpleDateFormat h = new SimpleDateFormat("H");
		    String time = h.format(date);
		 
		    request.setAttribute("date_now", date_now);
		    request.setAttribute("time", time);
		    
		    
		    
		    for(int k=0 ; k<7;k++) {
				String dayString = String.valueOf(dayInt+k);
				System.out.println("kkkkkkkkkkkk"+dayString+"nnnnnnnnn  "+month.format(date));
				nbreReservationDay[k] = clientDAO.nbreReservationDay(C.getId(),dayString , year.format(date),month.format(date), type);
				System.out.println("dddddddddddddddddddddddd   " + nbreReservationDay[k]);
			}
			
		    Long nbreReservationMonth = statistique.ReservationParMois(C.getId(), year.format(date),month.format(date));
		   
			List<Reservation> reservations = new ArrayList<Reservation>();
		    try {
				 dates = nextDate();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			reservations = clientDAO.trouverParType(type); 
			for(int i=0;i<isAvailable.length;i++) {
				for(int j = 0; j<isAvailable[i].length;j++) {
					Reservation res = new Reservation();
					res.setDate_reservation(dates[j]);
					res.setHeure_reservation(i+9);
					res.setType_reservation(type);
					if(contains(reservations, res)==null) {
						isAvailable[i][j] = true;
						CompteReservations[i][j] = null;
						ListeReservations[i][j] = null;
					}
					else {
						isAvailable[i][j] = false;
						CompteReservations[i][j]=AdminDAO.Voir_info_reservation(contains(reservations, res));
						ListeReservations[i][j]=contains(reservations, res);
						
					}
					}
				}
			
			
			
			
			request.setAttribute("IsAvailable", isAvailable);
			request.setAttribute("nextDate", dates);
			request.setAttribute("CompteReservations", CompteReservations);
			request.setAttribute("ListeReservations", ListeReservations);
            System.out.println(C.getId()+"nnn"+day.format(date)+year.format(date)+month.format(date)+type);
            System.out.println(nbreReservationDay);
            request.setAttribute("nbreReservationDay", nbreReservationDay);
            request.setAttribute("nbreReservationMonth", nbreReservationMonth);
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
		
		
		
		
		
		
		public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
			
			String path = request.getServletPath();
			
	        if (path.equals("/AnnulerReservation")) {
	        	String id_reservation =  request.getParameter("id_reservation");
	        	int id = Integer.parseInt(id_reservation);
	        	String type_reservation =  request.getParameter("type_reservation");
	        	clientDAO.AnnulerReservation(id);
	        	 response.sendRedirect("reservation?type="+type_reservation);

	        }else {
	        HttpSession session = request.getSession();
			Compte C = (Compte) session.getAttribute("Client");
			String date =  request.getParameter("date");
			String type =  request.getParameter("type");
			String stringTime = request.getParameter("time");
			Integer time =Integer.parseInt(stringTime);
			Reservation reservation = new Reservation(C.getId(),date,time,type);
			clientDAO.addReservation(reservation);
			response.sendRedirect("reservation?type="+type);
	        }
			
			
			
			
		}

}
