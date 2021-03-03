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

</head>
<body class="app sidebar-mini">

   <%@include file="aside.jsp" %>

	<main class="app-content">

		<div class="row user">
			<div class="col-md-12">
				<div class="profile">
				
					<div class="cover-image"></div>
				</div>
			</div>
			
			<div class="col-md-12">
				<div class="tab-content">
					<div class="tab-pane active" id="user-timeline">


						<c:forEach items="${ reclamations }" var="R">
							<div class="timeline-post">
								<div class="post-media">
								
								<c:if test="${R.getType_Reclamation()=='Basket'}">
								<a href="#"><img
										src="https://images-na.ssl-images-amazon.com/images/I/71tdJLduL9L._AC_SX425_.jpg" style=" width: 60px; "></a>
                                </c:if>
                                <c:if test="${R.getType_Reclamation()=='Football'}">
								<a href="#"><img
										src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_FNph6iVYAu2e_H7MptAWc7Dz1SbRiASkmg&usqp=CAU" style=" width: 60px; "></a>
                                </c:if>
                                <c:if test="${R.getType_Reclamation()=='Volé'}">
								<a href="#"><img
										src="https://3.imimg.com/data3/HJ/XD/MY-9842696/pu-volleyball-500x500.jpg" style=" width: 60px; "></a>
                                </c:if>
							
									<div class="content">
										<h5 style="padding-left: 10px;">
										    ${R.getCompte().getNom()} ${R.getCompte().getPrenom()} 
										</h5>
										<h6 style="padding-left: 10px;">${R.getType_Reclamation()}</h6>
										<p class="text-muted" style="padding-left: 10px;">
											<small>${R.getDate_reclamation()}</small>
										</p>
									</div>
								</div>
								<div class="post-content">
									<p>${R.getDescription()}</p>
								</div>
							</div>
						</c:forEach>
						
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
	<!-- Page specific javascripts-->
	<script type="text/javascript" src="Static/js/plugins/chart.js"></script>


</body>
</html>