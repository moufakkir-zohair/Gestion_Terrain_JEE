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
			<div class="col-md-3">
				<div class="tile p-0">
					<ul class="nav flex-column nav-tabs user-tabs">
						<li class="nav-item"><a class="nav-link active"
							href="#user-timeline" data-toggle="tab" style = "color :var(--blue);">Réclamations</a></li>
						<li class="nav-item"><a class="nav-link"
							href="#user-settings" data-toggle="tab" style = "color :var(--blue);">Céer réclamation</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-9">
				<div class="tab-content">
					<div class="tab-pane active" id="user-timeline">











						<c:forEach items="${ reclamations }" var="R">
							<div class="timeline-post">
								<div class="post-media">
								
								
								
								<c:if test="${R.getType_Reclamation()=='Basket'}">
								<a href="#"><img
										src="https://images-na.ssl-images-amazon.com/images/I/71tdJLduL9L._AC_SX425_.jpg" style=" width: 40px; "></a>
                                </c:if>
                                <c:if test="${R.getType_Reclamation()=='Football'}">
								<a href="#"><img
										src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_FNph6iVYAu2e_H7MptAWc7Dz1SbRiASkmg&usqp=CAU" style=" width: 40px; "></a>
                                </c:if>
                                <c:if test="${R.getType_Reclamation()=='Volé'}">
								<a href="#"><img
										src="https://3.imimg.com/data3/HJ/XD/MY-9842696/pu-volleyball-500x500.jpg" style=" width: 40px; "></a>
                                </c:if>
							
									<div class="content">
										<h5>
											<a> ${R.getType_Reclamation()}</a>
										</h5>
										<p class="text-muted">
											<small>${R.getDate_reclamation()}</small>
										</p>
									</div>
								</div>
								<div class="post-content">
									<p>${R.getDescription()}</p>
								</div>
								<ul class="post-utility">
									<li class="likes">

										<button class="btn btn-primary" data-toggle="modal"
											data-target="#editmodel"
											data-edit_id="${R.getId_reclamation()}"
											data-ter="${R.getType_Reclamation()}"
											data-description="${R.getDescription()}"
											style="padding-left: 4px; padding-right: 4px;">
											<i class="fa fa-pencil-square-o" aria-hidden="true"></i>Modifier
										</button>



									</li>
									<li class="shares">

										<button class="btn btn-danger" data-toggle="modal"
											data-target="#deletemodel"
											data-delete_id="${R.getId_reclamation()}" type="button">
											<i class="fa fa-trash" aria-hidden="true"></i>Supprimer
										</button>
									</li>
								</ul>
							</div>
						</c:forEach>




					</div>
					<div class="tab-pane fade" id="user-settings">
						<div class="tile user-settings">
							<h4 class="line-head">Nouveau Réclamation</h4>
							<form action="Ajouter_Reclamation" method="post">


								<div class="form-group">
									<label>Type de terrain</label> <select class="form-control"
										name="terrain">
										<option>Basket</option>
										<option>Football</option>
										<option>Volé</option>
									</select>
								</div>
								<div class="form-group">
									<label>description</label>
									<textarea class="form-control" name="reclamation" rows="5"
										placeholder="description de réclamation"></textarea>
								</div>

								<div class="row mb-10">
									<div class="col-md-12">
										<button class="btn btn-primary" type="submit">
											<i class="fa fa-fw fa-lg fa-check-circle"></i> Enregistrer
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>







	</main>


	<div class="modal fade" id="deletemodel" tabindex="-1" role="dialog"
		aria-labelledby="delete" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<form action="Supprimer_Reclamation" method="post">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Supprimer
							Réclamation</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<input type="hidden" name="delete_id" id="delete_id">Voulez-vous
						supprimer cette réclamation ?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Non</button>
						<button type="submit" class="btn btn-danger">Oui</button>
					</div>
				</div>
			</form>
		</div>
	</div>




	<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
		tabindex="-1" id="editmodel" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modifier
						Réclamation</h5>
					<button aria-hidden="true" data-dismiss="modal" class="close"
						type="button">×</button>
				</div>

				<div class="modal-body">
					<form role="form" action="Modifier_Reclamation" method="post"
						name="myForm">
						<input type="hidden" id="edit_id" name="edit_id" />

						<div class="form-group">
							<label>Type de terrain</label> <select class="form-control"
								name="terrain" id="ter">
								<option>Basket</option>
								<option>Football</option>
								<option>Volé</option>
							</select>
						</div>
						<div class="form-group">
							<label>description</label>
							<textarea class="form-control" id="description"
								name="reclamation" rows="5"
								placeholder="description de réclamation"></textarea>
						</div>


						<div class="modal-footer">
							<button type="submit" class="btn btn-secondary"
								data-dismiss="modal">Annuler</button>
							<button type="submit" class="btn btn-success ">Enregistrer</button>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
	</div>



	<!-- Essential javascripts for application to work-->
	<script src="Static/js/jquery-3.3.1.min.js"></script>
	<script src="Static/js/popper.min.js"></script>
	<script src="Static/js/bootstrap.min.js"></script>
	<script src="Static/js/main.js"></script>
	<!-- The javascript plugin to display page loading on top-->
	<script src="Static/js/plugins/pace.min.js"></script>
	<!-- Page specific javascripts-->
	<script type="text/javascript" src="Static/js/plugins/chart.js"></script>



	<script type="text/javascript">
		$('#editmodel').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var edit_id = button.data('edit_id')
			var ter = button.data('ter')
			var description = button.data('description')
			var modal = $(this)
			modal.find('.modal-body #edit_id').val(edit_id);
			modal.find('.modal-body #ter').val(ter);
			modal.find('.modal-body #description').val(description);
		})

		$('#deletemodel').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var delete_id = button.data('delete_id')

			var modal = $(this)
			modal.find('.modal-body #delete_id').val(delete_id);

		})
	</script>

<script>
  var a=document.getElementById("").value
  function cond(){

 

     if(a==""){}
     else if(a==""){}
     else {}
}
</script>

</body>
</html>