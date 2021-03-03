<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Gestion terrain</title>
<link href="Static/css/styles.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	background-image: url(Static/images/Terrain3.jpg);
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
	width: 100%;
	height: 100vh; /* responsive height */
}
</style>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-7">
							<div class="card shadow-lg border-0 rounded-lg mt-0">
								<div class="card-header">
									<h3 class="text-center font-weight-light my-4">Créer un
										compte</h3>
								</div>
								<div class="card-body">
									<form action="SaveCompte" method="post">
										<div class="form-row">
											<div class="col-md-6">
												<div class="form-group">
													<label class="small mb-1" for="inputFirstName">Nom</label>
													<input class="form-control py-4" name="nom" type="text"
														placeholder="Saisir votre nom" value="${C.getNom()}" required />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="small mb-1" for="inputLastName">Prénom</label>
													<input class="form-control py-4" name="prenom" type="text"
														placeholder="Saisir votre prénom"  value="${C.getPrenom()}" required="required" />
												</div>
											</div>
										</div>


										<div class="form-row">
											<div class="col-md-6">
												<div class="form-group">
													<label class="small mb-1" for="inputPassword">Téléphone</label>
													<input class="form-control py-4" name="tele" type="text"
														placeholder="Saisir votre télephone"  value="${C.getTelephon()}" required="required" />
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="small mb-1" for="inputConfirmPassword">CIN</label>
													<input class="form-control py-4" name="cin" type="text"
														placeholder="Saisir votre CIN"  value="${C.getCin()}" required="required" />
												</div>
											</div>
										</div>

										<div class="form-group">
											<label class="small mb-1" for="inputEmailAddress">Email</label>
											<input class="form-control py-4" name="email" type="email"
												placeholder="Saisir votre mail"  value="${C.getEmail()}" required="required" />
										</div>

										<div class="form-row">
											<div class="col-md-6">
												<div class="form-group">
													<label class="small mb-1" for="inputConfirmPassword">Mot
														de passe </label> <input class="form-control py-4" name="mdp"
														type="password" placeholder="Saisir votre mot de passe"
														required="required" />
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label class="small mb-1" for="inputConfirmPassword">Confirme
														Mot de passe</label> <input class="form-control py-4" name="cmdp"
														type="password" placeholder="Confirmer votre mot de passe"
														required="required" />
												</div>
											</div>

											<b style="color: red;"> ${error} </b>

										</div>
										<div class="form-group mt-4 mb-0">
											<button type="submit" class="btn btn-primary btn-block">Créer
												un compte</button>
										</div>
									</form>
								</div>
								<div class="card-footer text-center">
									<div class="small">
										<a href="Login">Avoir un compte? Aller à la connexion</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>

	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="Static/js/scripts.js"></script>
</body>
</html>
