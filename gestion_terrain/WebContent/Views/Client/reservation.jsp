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
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<script type="text/javascript">
	function get_id(clicked_id) {
		var date = document.getElementsByClassName('modalDate');
		var time = document.getElementsByClassName('modalTime');

		var heure = Math.floor(clicked_id / 10) + 9;
		var rest = clicked_id % 10;

		date[0].innerHTML = "Date: " + document.getElementById(rest).innerHTML;
		time[0].innerHTML = "Heure: " + heure + "h00";
		date[1].value = document.getElementById(rest).innerHTML;
		time[1].value = heure;
	
	}
</script>
</head>
<body class="app sidebar-mini">

<%@include file="aside.jsp" %>
	 
	<main class="app-content">


		<c:choose>
			<c:when test="${typeReserve == 'FOOT'}">

				<div class="app-title">
					<div>
						<h1>
							<i class="fa fa-futbol-o" aria-hidden="true"></i> Réservation
						</h1>
					</div>
					<ul class="app-breadcrumb breadcrumb">
						<li class="breadcrumb-item"><i class="fa fa-futbol-o"
							aria-hidden="true"></i></li>
						<li class="breadcrumb-item active"><a
							href="reservation?type=FOOT" style="color: var(- -blue);">Football</a></li>
					</ul>
				</div>

			</c:when>
			<c:when test="${typeReserve == 'Basket'}">


				<div class="app-title">
					<div>
						<h1>
							<i class="fa fa-futbol-o" aria-hidden="true"></i> Réservation
						</h1>
					</div>
					<ul class="app-breadcrumb breadcrumb">
						<li class="breadcrumb-item"><i class="fa fa-futbol-o"
							aria-hidden="true"></i></li>
						<li class="breadcrumb-item"><a
							href="reservation?type=Basket" style="color: var(- -blue);">Basket</a></li>
					</ul>
				</div>

			</c:when>
			<c:when test="${typeReserve == 'Volley'}">


				<div class="app-title">
					<div>
						<h1>
							<i class="fa fa-futbol-o" aria-hidden="true"></i> Réservation
						</h1>
					</div>
					<ul class="app-breadcrumb breadcrumb">
						<li class="breadcrumb-item"><i class="fa fa-futbol-o"
							aria-hidden="true"></i></li>
						<li class="breadcrumb-item"><a
							href="reservation?type=Volley" style="color: var(- -blue);">Volley</a></li>
					</ul>
				</div>

			</c:when>
		</c:choose>


		<div>
			<div class="container-fluid ">
				<div class="table-responsive">
					<table class="table table-secondary table-bordered border-dark ">
						<thead>
							<tr>
								<th scope="col">TEMPS/DATE</th>
								<c:forEach var="i" begin="0" end="6" step="1">
									<th class="currentDates" id="${i}" scope="col">${ nextDate[i] }</th>
								</c:forEach>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="i" begin="0" end="10" step="1">
								<tr>
									<th id="${i+9}" scope="row">${i+9}</th>
									<c:forEach var="j" begin="0" end="6" step="1">
									
									
									
									
									   <c:choose>
													           
													           <c:when test="${date_now==nextDate[j] && i+9 < time}">
													               <td  style="border-style: solid; border-width: 3px; background-color:#6c757d;">
																     <h6 class="d-inline-flex p-2 justify-content-center align-items-center" style="color: white; text-align: center; ">Le temps s'est écoulé</h6>
                                                                   </td>
													           </c:when>
													           
													           <c:otherwise>
													           
													           
													           
													           
													           	<c:choose>
											<c:when test="${ IsAvailable[i][j]=='true' }">
												<td class="bg-success"
													style="border-style: solid; border-width: 3px;">
													
													
													
													 
													
													
													<c:choose>
													           
																<c:when test="${ nbreReservationMonth < 6 }">
																        
																  <c:choose>
																  
																		<c:when test="${nbreReservationDay[j] == 0}">
																				<button id="${i }${j }" onClick="get_id(this.id)"
																					type="button" class="btn" data-bs-toggle="modal"
																					data-bs-target="#staticBackdrop">
																					<h6 style="color: white;">Clicker pour réserver</h6>
																				</button>
																		</c:when>
																		<c:otherwise>
																			
																				<button
																					type="button" class="btn" data-toggle="modal"
																					data-target="#LimiteReservation">
																					<h6 style="color: white;">Clicker pour réserver</h6>
																				</button>
																		
																		  </c:otherwise>
																  
																  </c:choose>
																
																</c:when>
																<c:otherwise>
																    
																    <button
																			type="button" class="btn" data-toggle="modal"
																			data-target="#LimiteReservationMois">
																			<h6 style="color: white;">Clicker pour réserver</h6>
																    </button>
																		
																</c:otherwise>
																    
																    
											
													</c:choose>
													
												</td>
											</c:when>
											<c:otherwise>
										
								
														<c:choose>
															<c:when
																test="${ListeReservations[i][j].getId_compte()==Client.getId()}">
															    <td class="bg-danger"
                                                                    style="border-style: solid; border-width: 3px;"
                                                                	data-toggle="modal"
																	data-target="#AnnulerReservation"
																	
																	data-id_reservation="${ListeReservations[i][j].getId_reservation()}"
																	data-type_reservation="${ListeReservations[i][j].getType_reservation()}"
>
																 
															       <h6 class="d-inline-flex p-2 justify-content-center align-items-center" style="color: white; text-align: center; ">${CompteReservations[i][j].getNom()} ${CompteReservations[i][j].getPrenom()}</h6>
                                                               </td>
                                                             
															</c:when>
															
															<c:otherwise>
                                                               <td class="bg-danger" style="border-style: solid; border-width: 3px;">
																<h6 class="d-inline-flex p-2 justify-content-center align-items-center" style="color: white; text-align: center; ">Heure déjà réserver</h6>
                                                               </td>
															</c:otherwise>
														</c:choose>
											</c:otherwise>
										</c:choose>
													           
													           
													           
													           </c:otherwise>
													           
													           
													           
					                  </c:choose>
													
									
									
									
									
									
									</c:forEach>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="modal fade" id="staticBackdrop"
					data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
					aria-labelledby="staticBackdropLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="staticBackdropLabel">Confirmation
									de réservation</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<form action="reservation" method="post">
								<div class="modal-body">
									<h5 id="confirmation" class="modalDate"></h5>
									<h5 id="confirmation" class="modalTime"></h5>
									<h5 id="confirmation" class="modalType">Terrain de:
										${typeReserve }</h5>
									<input class="modalType" type="hidden" name="type"
										value="${typeReserve }" /> <input class="modalDate"
										type="hidden" name="date" /> <input class="modalTime"
										type="hidden" name="time" />
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Annuler</button>
									<button type="submit" class="btn btn-primary">
										Réserver</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				
				
				
				
 <div class="modal fade" id="AnnulerReservation" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Annuler la réservation</h5>
	        <button aria-hidden="true" data-dismiss="modal" class="close"
						type="button">×</button>
	      </div>
	      <form action="AnnulerReservation" method="POST">
	            <div class="modal-body">
						<input type="hidden" name="id_reservation" id="id_reservation"> 
						<input type="hidden" name="type_reservation" id="type_reservation"> 
						          Voulez-vous annuler la réservation ?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Non</button>
			<button type="submit" class="btn btn-danger">Oui</button>
		     </div>
		  </form>
	    </div>
	  </div>
	</div> 
				
				
				
	<div class="modal fade" id="LimiteReservation" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Limite de réservation par jour</h5>
	        <button aria-hidden="true" data-dismiss="modal" class="close"
						type="button">×</button>
	      </div>
	      <form action="AnnulerReservation" method="POST">
	            <div class="modal-body"> 
						vous dépassez vos limites de réservation par jour
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">OK</button>
		     </div>
		  </form>
	    </div>
	  </div>
	</div> 
			
				
				
	<div class="modal fade" id="LimiteReservationMois" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Limite de réservation par Mois</h5>
	        <button aria-hidden="true" data-dismiss="modal" class="close"
						type="button">×</button>
	      </div>
	      <form action="AnnulerReservation" method="POST">
	            <div class="modal-body"> 
						vous dépassez vos limites de réservation par mois
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">OK</button>
		     </div>
		  </form>
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
		

		$('#AnnulerReservation').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var id_reservation = button.data('id_reservation')
			var type_reservation = button.data('type_reservation')
			var modal = $(this)
			modal.find('.modal-body #id_reservation').val(id_reservation);
			modal.find('.modal-body #type_reservation').val(type_reservation);

		})
		
		
		
		
	</script>
</body>
</html>



















	<%-- 	<td class="bg-danger"
													style="border-style: solid; border-width: 3px;">
													<div
														class="d-inline-flex p-2 justify-content-center align-items-center">
														<c:choose>
															<c:when
																test="${ListeReservations[i][j].getId_compte()==Client.getId()}">
                                                                <button 
                                                                    class="btn"
                                                                	data-toggle="modal"
																	data-target="#AnnulerReservation"
																	
																	data-id_reservation="${ListeReservations[i][j].getId_reservation()}"
																	data-type_reservation="${ListeReservations[i][j].getType_reservation()}"

                                                                >
																<h6 style="color: white;">${CompteReservations[i][j].getNom()} ${CompteReservations[i][j].getPrenom()}</h6>
                                                                </button>
															</c:when>
															<c:otherwise>

																<h6 style="color: white;">Deja reserver</h6>

															</c:otherwise>
														</c:choose>

													</div>
												</td> --%>
												