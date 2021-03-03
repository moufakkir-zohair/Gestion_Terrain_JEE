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
      <div class="app-title">
        <div>
          <h1><i class="fa fa-bar-chart"></i> Statistique</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
           <li class="breadcrumb-item"><i class="fa fa-bar-chart" aria-hidden="true"></i></li>
          <li class="breadcrumb-item" ><a href="Acceuil_Admin" style = "color: var(--blue);">Statistique</a></li>
        </ul>
      </div>
      <div class="row">
        <div class="col-md-4 ">
          <div class="widget-small primary coloured-icon"><i class=" icon fa  fa-pencil-square-o" aria-hidden="true"></i>
            <div class="info">
              <h4>Total Réclamations</h4>
              <p><b>${nbreReclamation}</b></p>
            </div>
          </div>
        </div>
        <div class="col-md-4 ">
          <div class="widget-small info coloured-icon"><i class="icon fa fa-futbol-o" aria-hidden="true"></i>
            <div class="info">
              <h4>Total Réservations</h4>
              <p><b>${nbreReservation}</b></p>
            </div>
          </div>
        </div>
        
         <div class="col-md-4 ">
          <div class="widget-small info coloured-icon" ><i class="icon fa fa-users" aria-hidden="true" style="background-color:#222d32;"></i>
            <div class="info">
              <h4>Total Comptes</h4>
              <p><b>${TotalCompte}</b></p>
            </div>
          </div>
        </div>

      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <h3 class="tile-title">Statistiques mensuelles Total</h3>
            <div class="embed-responsive">
              <div id="columnchart_material" style="width: 800px; height: 500px;"></div>
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
     <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);

 

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Mois', 'Nombre Réclamations','Nombre Réservations'],
          ['Jan',  ${janvier} ,  ${janvier1}],
          ['Feb', ${fevrier}, ${fevrier2}],
          ['Mar',  ${mars},  ${mars3}],
          ['Avr', ${avril}, ${avril4}],
          ['Mai', ${mai}, ${mai5}],
          ['Juin', ${juin}, ${juin6}],
          ['Juil', ${juillet}, ${juillet7}],
          ['Aout', ${aout}, ${aout8}],
          ['Sept', ${septembre}, ${septembre9}],
          ['Oct',  ${octobre},  ${octobre10}],
          ['Nov', ${novembre}, ${novembre11}],
          ['Dec',  ${decembre},  ${decembre12}]
        ]);

 

        var options = {
          chart: {
            title: 'Réclamations-Réservations',
            subtitle: "Réclamation et Réservation par Mois: 2021" ,
          }
        };

 

        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));
        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
    </script>
    
    

  </body>
</html>