<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  <meta charset="utf-8" />
    <title>Gestion-Terrain</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="Static/css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
 
  </head>
  <body class="app sidebar-mini">
  
  <%@include file="aside.jsp" %>
    
    <main class="app-content">
    
    
     <c:choose>
        <c:when test="${typeReserve == 'FOOT'}">
        
       <div class="app-title">
        <div>
          <h1><i class="fa fa-futbol-o" aria-hidden="true"></i> Réservations</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-futbol-o" aria-hidden="true"></i></li>
          <li class="breadcrumb-item active" ><a href="ListeReservation?type=FOOT" style = "color: var(--blue);">Football</a></li>
        </ul>
     </div>
        
        </c:when>
        <c:when test="${typeReserve == 'Basket'}">
        
        
       <div class="app-title">
        <div>
          <h1><i class="fa fa-futbol-o" aria-hidden="true"></i> Réservations</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-futbol-o" aria-hidden="true"></i></li>
          <li class="breadcrumb-item" ><a href="ListeReservation?type=Basket" style = "color: var(--blue);">Basket</a></li>
        </ul>
     </div>
        
        </c:when>
        <c:when test="${typeReserve == 'Volley'}">
        
        
       <div class="app-title">
        <div>
          <h1><i class="fa fa-futbol-o" aria-hidden="true"></i> Réservations</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
          <li class="breadcrumb-item"><i class="fa fa-futbol-o" aria-hidden="true"></i></li>
          <li class="breadcrumb-item" ><a href="ListeReservation?type=Volley" style = "color: var(--blue);">Volley</a></li>
        </ul>
     </div>
        
        </c:when>
    </c:choose>
    
    
     
    
    
    
    
    <div >
	<div class="container-fluid ">
	<div class="table-responsive">
        <table class="table table-secondary table-bordered border-dark ">
            <thead>
              <tr>
                <th scope="col">TEMPS/DATE</th>
                <c:forEach var="i" begin="0" end="6" step="1">
					<th class = "currentDates" id= "${i}" scope="col">${ nextDate[i] }</th>
				</c:forEach>
              </tr>
            </thead>
            
            <tbody>
            <c:forEach var="i" begin="0" end="10" step="1">
					<tr>
						<th id= "${i+9}" scope="row">${i+9}</th>
						<c:forEach var="j" begin="0" end="6" step="1">	  					
							<c:choose>
						    	<c:when test="${ IsAvailable[i][j] }">
									<td class="bg-success"  
									                data-toggle="modal"
													data-target="#modelInfo"
													data-nom="${CompteReservations[i][j].getNom()}"
													data-prenom="${CompteReservations[i][j].getPrenom()}"
													data-cin="${CompteReservations[i][j].getCin()}"
													data-telephone="${CompteReservations[i][j].getTelephon()}">		
  										<h6 style="color: white; height: 100%;width: 100% ;text-align: center; display: block; margin: auto;" >${CompteReservations[i][j].getNom()} ${CompteReservations[i][j].getPrenom()}</h6>
						    	</c:when>
						   		 <c:otherwise>
						    	
						    	<td class="bg-success" style="border-style: solid;border-width: 3px;">
										
								 </td>
						    	
						    	</c:otherwise>
							</c:choose>
						</c:forEach>

					</tr>
			</c:forEach>
            </tbody>
          </table>
      </div>
    <div class="modal fade" id="modelInfo" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Information sur la réservation</h5>
	        <button aria-hidden="true" data-dismiss="modal" class="close"
						type="button">×</button>
	      </div>
	      <div class="modal-body">
	        
	        <h5 id="NomComplete" ></h5> 
	        <h5 id="CIN" ></h5> 
	        <h5 id="Telephone" ></h5> 
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Ok</button>
	      </div>
	    </div>
	  </div>
	</div> 

	</div>
	</div>
    </main>
    <!-- Essential javascripts for application to work-->
      <script src="Static/js/jquery-3.3.1.min.js"></script>
    <script src="Static/js/popper.min.js"></script>
    <script src="Static/js/bootstrap.min.js"></script>
    <script src="Static/js/main.js"></script>
    <!-- The javascript plugin to display page loading on top-->
    <script src="Static/js/plugins/pace.min.js"></script>
    <script src="Static/css/bootstrap.min.js"></script>
    
    
       <script type="text/javascript">
	

		$('#modelInfo').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var nom = button.data('nom')
			var prenom = button.data('prenom')
			var cin = button.data('cin')
			var telephone = button.data('telephone')
		    var modal = $(this)
		    $('#NomComplete').text('Nom complet : '+nom+' '+prenom);
			$('#CIN').text('CIN : '+cin);
			$('#Telephone').text('Téléphone : '+telephone);			
		})

	
	</script>
  </body>
</html>