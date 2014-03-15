<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="niveau='s4j3e1'">
<div id="page">
	<div id="bloc-principal">
<div class="div-haut" ng-controller="ExercicesNavCtrl" ng-init="groupe='s4j3'">
<%@include file="../includes/inc_exercicesnav.htm"%>
<div id="center"><p align="center">Associer des paires par couleur</p></div>
</div>
<%@include file="../includes/inc_messages.htm"%>
<div class="div-milieu">
<div align="center" id="couleurs" ng-controller="CouleursCtrl">
<button class="{{couleur.cssClass}}" ng-repeat="couleur in couleurs" style="background-color:{{couleur.code}};" ng-click="enregistreCouleur(couleur, $event, $index)"/>
</div>
<div align="center" id="cases" ng-controller="Technique01Ctrl">
<p><button class="{{case.cssClass}}" ng-style="{'background-color' : case.backgrdStyle}" ng-repeat="case in cases | filter:{row:1}" ng-click="enregistreCase(case, $event, $index)">
{{case.libelle}}</button></p>
<p><button class="{{case.cssClass}}" ng-style="{'background-color' : case.backgrdStyle}" ng-repeat="case in cases | filter:{row:2}" ng-click="enregistreCase(case, $event, $index)">
{{case.libelle}}</button></p>
<p><button class="{{case.cssClass}}" ng-style="{'background-color' : case.backgrdStyle}" ng-repeat="case in cases | filter:{row:3}" ng-click="enregistreCase(case, $event, $index)">
{{case.libelle}}</button></p>
</div>	
</div>
	</div><!-- fin bloc-principal -->
</div><!-- fin page -->

</body>
</html>