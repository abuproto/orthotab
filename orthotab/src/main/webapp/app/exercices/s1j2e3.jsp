<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="niveau='s1j2e3';optSomme=true;delai=3;">
<div id="page">
	<div id="bloc-principal">
<div class="div-haut" ng-controller="ExercicesNavCtrl" ng-init="groupe='s1j2'">
<%@include file="../includes/inc_exercicesnav.htm"%>
<div id="center"><p align="center">Calcul flash</p></div>
</div>
<%@include file="../includes/inc_messages.htm"%>
<div class="div-milieu" ng-controller="Technique03Ctrl">

<div align="center" ng-hide="debut"><button class="boutonGeneral2" ng-click="commencer()">Commencer l'exercice</button></div>

<div ng-show="debut">
<div id="milieu-left">
<div align="center" ng-hide="tempsEcoule">
<p><button class="boutonCase">{{caseCourant.libelle}}</button></p>
</div>
</div>
<div id="milieu-right">
<div align="center" ng-show="tempsEcoule">
<p ng-repeat="case in caseCourant.listeCaseflash"><button ng-click="valider(case)" class="{{case.cssClass}}">{{case.libelle}}</button></p>
	<span>{{message}}</span>
	<p ng-show="dspsuivant"><button class="boutonGeneral2" ng-click="suivant()">Suivant</button></p>
</div>
</div>

</div>

</div>
	</div><!-- fin bloc-principal -->
</div><!-- fin page -->

</body>
</html>