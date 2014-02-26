<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
  <link rel="stylesheet" href="../css/app.css">
  
  <script src="../../lib/angular.js"></script>
  <script src="../../lib/angular-cookies.js"></script>
  <script src="../../lib/angular-resource.js"></script>
	<script src="../../lib/angular-sanitize.js"></script>
  <script src="../js/app.js"></script>
  <script src="../js/didact-controllers.js"></script>
  <script src="../js/services.js"></script>
  <script src="../js/angular-local-storage.js"></script>
  
</head>
<body ng-app="orthotabApp" ng-init="nivdifficulte='5'">
<div class="div-haut">
<div id="left">
<span><img src="../images/icone_menu.png" alt="Menu didacticiel"/></span>
<span><img src="../images/icone_redo.png" alt="Recommencer"/></span>
</div>
<div id="right"><img src="../images/icone_home.jpg" alt="Retour Accueil"/></div>
<div id="center">Associer des paires par couleur</div>
</div>
<div class="div-milieu">
<div align="center" id="couleurs" ng-controller="CouleursCtrl">
<button class="{{couleur.cssClass}}" ng-repeat="couleur in couleurs" style="background-color:{{couleur.code}};" ng-click="enregistreCouleur(couleur, $event, $index)"/>
</div>
<div align="center" id="cases" ng-controller="Didact01Ctrl">
<button class="{{case.cssClass}}" ng-style="{'border-color' : case.backgrdStyle}" ng-repeat="case in cases" ng-click="enregistreCase(case, $event, $index)">
</button>
</div>
<div align="center" class="messageExercice">{{messageNiveau01}}</div>
</div>
</body>
</html>