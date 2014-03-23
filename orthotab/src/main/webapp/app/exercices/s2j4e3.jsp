<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="niveau='s2j4e3';">
<div id="page">
	<div id="bloc-principal">
<div class="div-haut" ng-controller="ExercicesNavCtrl" ng-init="groupe='s2j4'">
<%@include file="../includes/inc_exercicesnav.htm"%>
<div id="center"><p align="center">Mémory multipliant</p></div>
</div>
<%@include file="../includes/inc_messages.htm"%>
<div class="div-milieu" ng-controller="Technique07Ctrl">

<div align="center" ng-hide="debut"><button class="boutonGeneral2" ng-click="commencer()">Commencer l'exercice</button></div>

<div ng-show="debut">

	<div id="milieu-left">
	<p align="right" ng-repeat="case in memorymCourant.listeCaseG"><button class="case-nombre" ng-style="{'background-color' : case.backgrdStyle}" ng-click="enregistreCaseG(case, $event, $index)">{{case.valeur}}</button></p>
	</div>
	
	<div id="milieu-right">
	<p align="right" ng-repeat="case in memorymCourant.listeCaseD"><button class="case-nombre" ng-style="{'background-color' : case.backgrdStyle}" ng-click="enregistreCaseD(case, $event, $index)">{{case.valeur}}</button></p>
	</div>
	<div id="center" align="center">
	<p align="center"><button class="case-nombre">{{memorymCourant.valeur}}</button></p>
	<div class="signe" style="margin-top:50px;">X</div>
	<br/><span>{{message}}</span>
	<p ng-show="dspsuivant"><button class="boutonGeneral2" ng-click="suivant()">Suivant</button></p>
	</div>
</div>

</div>

	</div><!-- fin bloc-principal -->
</div><!-- fin page -->

</body>
</html>