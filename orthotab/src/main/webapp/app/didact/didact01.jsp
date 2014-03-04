<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="nivdifficulte='5'">
<div id="page">
	<div id="bloc-principal">
<div class="div-haut" ng-controller="DidactNavCtrl">
<%@include file="../includes/inc_didactnav.htm"%>
<div id="center"><p align="center">Associer des paires par couleur</p></div>
</div>
<div class="div-milieu">
<div align="center" id="couleurs" ng-controller="CouleursCtrl">
<button class="{{couleur.cssClass}}" ng-repeat="couleur in couleurs" style="background-color:{{couleur.code}};" ng-click="enregistreCouleur(couleur, $event, $index)"/>
</div>
<div align="center" id="cases" ng-controller="Didact01Ctrl">
<p><button class="{{case.cssClass}}" ng-style="{'border-color' : case.backgrdStyle}" ng-repeat="case in cases | filter:{row:1}" ng-click="enregistreCase(case, $event, $index)">
</button></p>
<p><button class="{{case.cssClass}}" ng-style="{'border-color' : case.backgrdStyle}" ng-repeat="case in cases | filter:{row:2}" ng-click="enregistreCase(case, $event, $index)">
</button></p>
</div>	
</div>
	</div><!-- fin bloc-principal -->
	<div id="footer" align="center" class="messageExercice">{{messageNiveau}}</div>
</div><!-- fin page -->

</body>
</html>