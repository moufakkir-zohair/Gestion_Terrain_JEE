<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
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
      <div class="app-title">
        <div>
          <h1><i class="fa fa-th-list"></i> Liste Compte</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb side">
           <li class="breadcrumb-item"><i class="fa fa-bar-chart" aria-hidden="true"></i></li>
          <li class="breadcrumb-item" ><a href="Acceuil_Admin" style = "color: var(--blue);">Statistique</a></li>
          <li class="breadcrumb-item active"><a href="#">Liste Comptes</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <div class="table-responsive">
                <table class="table table-hover table-bordered" id="sampleTable">
                 	<thead>
										<tr>
											<th>Nom</th>
											<th>Prénom</th>
											<th>Email</th>
											<th>Téléphone</th>
											<th>CIN</th>
											<th>Action</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${ comptes }" var="C">
											<tr>
												<td>${C.getNom()}</td>
												<td>${C.getPrenom()}</td>
												<td>${C.getEmail()}</td>
												<td>${C.getTelephon()}</td>
												<td>${C.getCin()}</td>
												<td>


													<li class="list-inline-item">
														<button class="btn btn-success" data-toggle="modal"
															data-target="#editmodel" data-edit_id="${C.getId()}"
															
															style="padding-left: 4px; padding-right: 4px;">
															<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
															Modifier
														</button>
												</li>
													<li class="list-inline-item">
														<button class="btn btn-danger" data-toggle="modal"
															data-target="#deletemodel" data-delete_id="${C.getId()}"
															type="button">
															<i class="fa fa-trash" aria-hidden="true"></i> Supprimer
														</button>

												</li>

												</td>
											</tr>
										</c:forEach>
										</tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
    
    
    
    <div class="modal fade" id="deletemodel" tabindex="-1" role="dialog"
				aria-labelledby="delete" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<form action="Supprimer_Compte" method="post">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Supprimer
									Compte</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<input type="hidden" name="delete_id" id="delete_id">Voulez-vous
								supprimer cette compte ?
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
							<h5 class="modal-title" id="exampleModalLabel">Changer le
								mot de passe</h5>
							<button aria-hidden="true" data-dismiss="modal" class="close"
								type="button">×</button>
						</div>

						<div class="modal-body">
							<form role="form" action="Modifier_MDP" method="post"
								name="myForm">
								<input type="hidden" id="edit_id" name="edit_id" />
								<div class="modal-body">

									<div class="form-group">
										<label>Nouveau mot de passe</label> <input
											class="form-control"  name="mdp" required="required" />
									</div>

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

    
    
    
    
    <!-- Essential javascripts for application to work-->
	<!-- Essential javascripts for application to work-->
	<script src="Static/js/jquery-3.3.1.min.js"></script>
	<script src="Static/js/popper.min.js" ></script>
	<script src="Static/js/bootstrap.min.js"></script>
	<script src="Static/js/main.js"></script>
	<!-- The javascript plugin to display page loading on top-->
	<script src="Static/js/plugins/pace.min.js"></script>
	<!-- Page specific javascripts-->
	<script type="text/javascript" src="Static/js/plugins/chart.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/plug-ins/1.10.21/i18n/French.json"></script>
	<script type="text/javascript"
		src="Static/js/plugins/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="Static/js/plugins/dataTables.bootstrap.min.js"></script>

	<script type="text/javascript">
		$('#sampleTable')
				.DataTable(
						{
							"language" : {
								"url" : "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/French.json"
							},
							

						});

        $('#editmodel').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var edit_id = button.data('edit_id')
			var mdp = button.data('mdp')
			var modal = $(this)
			modal.find('.modal-body #edit_id').val(edit_id);
		
		})

		$('#deletemodel').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget)
			var delete_id = button.data('delete_id')
			var modal = $(this)
			modal.find('.modal-body #delete_id').val(delete_id);

		})
	</script>


  </body>
</html>