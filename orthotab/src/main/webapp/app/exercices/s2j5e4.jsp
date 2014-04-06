<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="niveau='s2j5e4';optValeur=true;">
<div id="page">
	<div id="bloc-principal">
<div class="div-haut" ng-controller="ExercicesNavCtrl" ng-init="groupe='s2j5'">
<%@include file="../includes/inc_exercicesnav.htm"%>
<div id="center"><p align="center">Calcul à trou</p></div>
</div>
<%@include file="../includes/inc_messages.htm"%>
<div class="div-milieu" ng-controller="Technique08Ctrl">

<div align="center" ng-hide="debut"><button class="boutonGeneral2" ng-click="commencer()">Commencer l'exercice</button></div>

<div ng-show="debut">
<p align="center">{{noIt}} sur {{nbIt}}</p>
<div align="center">
<button class="{{case.cssClass}}" ng-repeat="case in calculATrouCourant.listeCaseCible" ng-style="{'background-color' : case.backgrdStyle}">
{{case.libelle}}</button>
</div>
<div align="center" ng-style="{'margin-top' : '20px'}">
<button class="{{case.cssClass}}" ng-repeat="case in calculATrouCourant.listeCaseChoix" ng-style="{'background-color' : case.backgrdStyle}" ng-click="enregistreCase(case, $event, $index)">
{{case.libelle}}</button>
</div>
<div align="center" ng-hide="niveauFini" ng-style="{'margin-top' : '30px'}">
<br/><span>{{message}}</span>
<p ng-show="dspsuivant"><button class="boutonGeneral2" ng-click="suivant()">Suivant</button></p>
</div>
</div>

</div>
	</div><!-- fin bloc-principal -->
</div><!-- fin page -->

</body>
</html>