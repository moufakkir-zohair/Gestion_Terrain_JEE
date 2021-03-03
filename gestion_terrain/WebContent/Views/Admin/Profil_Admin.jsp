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
    <link rel="stylesheet" type="text/css" href="Static/css/profil.css">
    
  </head>
  <body class="app sidebar-mini">
  
  
   <%@include file="aside.jsp" %>


    
    <main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-user"></i> Profil</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb side">
          <li class="breadcrumb-item"><i class="fa fa-bar-chart" aria-hidden="true"></i></li>
          <li class="breadcrumb-item" ><a href="Acceuil_Admin" style = "color: var(--blue);">Statistique</a></li>
          <li class="breadcrumb-item active"><a href="#">Profil</a></li>
        </ul>
      </div>
     
     
     
     
     	<div id="profile" class="tab-pane">
						<section class="panel">
							<div class="bio-graphe-heading">
								<h3>Informations Profil</h3>
							</div>
							<div class="panel-body bio-graph-info">
								<div class="row" style="padding: 15px;">
									<div class="bio-row">
										<p>
											<span>Nom </span>: &nbsp; &nbsp; ${Compte.getNom()}
										</p>
									</div>
									<div class="bio-row">
										<p>
											<span>Prénom </span>: &nbsp; &nbsp;  ${Compte.getPrenom()}
										</p>
									</div>
									<div class="bio-row">
										<p>
											<span>Téléphone </span>: &nbsp; &nbsp; ${Compte.getTelephon()}
										</p>
									</div>
									<div class="bio-row">
										<p>
											<span>Email  </span>:  &nbsp; &nbsp; ${Compte.getEmail()}
										</p>
									</div>
									<div class="bio-row">
										<p>
											<span>CIN </span>: &nbsp; &nbsp; ${Compte.getCin()}
										</p>
									</div>
									
									
									
								</div>
								<div class="form-group mt-4 mb-0">
										<button type="submit" class="btn btn-primary btn-block"  data-toggle="modal"
															data-target="#editmodel" 
															data-nom="${Compte.getNom()}"
															data-prenom="${Compte.getPrenom()}"
															data-telephone="${Compte.getTelephon()}"
															data-email="${Compte.getEmail()}"
															data-cin="${Compte.getCin()}"
															data-edit_id="${Compte.getId()}"
															style="padding-left: 4px; padding-right: 4px;">
															Changer Info
										</button>
								</div>
							</div>
						</section>
						<section>
							<div class="row"></div>
						</section>
					</div>
     
     
     
     
    </main>
    
    
    
    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
				tabindex="-1" id="editmodel" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Changer le
								profil</h5>
							<button aria-hidden="true" data-dismiss="modal" class="close"
								type="button">×</button>
						</div>

						<div class="modal-body">
							<form role="form" action="Modifier_Profil" method="post"
								name="myForm">
								<input type="hidden" id="edit_id" name="edit_id" />
								<div class="modal-body">

									<div class="form-group">
										<label>Nom</label> <input
											class="form-control" id="nom" name="nom" />
									</div>
									<div class="form-group">
										<label>Prenom</label> <input
											class="form-control" id="prenom" name="prenom" />
									</div>
									<div class="form-group">
										<label>Téléphone</label> <input
											class="form-control" id="telephone" name="telephone" />
									</div>
									<div class="form-group">
										<label>Email</label> <input
											class="form-control" id="email" name="email" />
									</div>
									<div class="form-group">
										<label>CIN</label> <input
											class="form-control" id="cin" name="cin" />
									</div>
									<div class="form-group">
										<label>Mot de passe</label> <input
											class="form-control" id="mdp" name="mdp" required="required"/>
									</div>

								</div>
								<div class="modal-footer">
									<button type="submit" class="btn btn-secondary"
										data-dismiss="modal">Annuler</button>
									<button type="submit" class="btn btn-primary">Enregistrer</button>
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
			var nom = button.data('nom')
			var prenom = button.data('prenom')
			var telephone = button.data('telephone')
			var email = button.data('email')
			var cin = button.data('cin')
			var mdp = button.data('mdp')
			
			var modal = $(this)
			modal.find('.modal-body #edit_id').val(edit_id);
			modal.find('.modal-body #nom').val(nom);
			modal.find('.modal-body #prenom').val(prenom);
			modal.find('.modal-body #telephone').val(telephone);
			modal.find('.modal-body #email').val(email);
			modal.find('.modal-body #cin').val(cin);
			
		})
	</script>
  </body>
</html>