<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="niveau='s4j4e3';">
<div id="page">
	<div id="bloc-principal">
<div class="div-haut" ng-controller="ExercicesNavCtrl" ng-init="groupe='s4j4'">
<%@include file="../includes/inc_exercicesnav.htm"%>
<div id="center"><p align="center">Remettre dans le bon ordre</p></div>
</div>
<%@include file="../includes/inc_messages.htm"%>
<div class="div-milieu" ng-controller="Technique09Ctrl">

<div align="center" ng-hide="debut"><button class="boutonGeneral2" ng-click="commencer()">Commencer l'exercice</button></div>

<div ng-show="debut">
<p align="center">{{noIt}} sur {{nbIt}}</p>
<p align="center">
<button ng-repeat="case in rmCourant.listeCaseCible" ng-click="enregistreCaseH(case,$index)" class="{{case.cssClass}}" ng-style="{'background-color' : case.backgrdStyle}">{{case.libelle}}</button>
</p>
<hr/>
<p align="center">
<button ng-repeat="case in rmCourant.listeCaseChoix" ng-click="enregistreCaseB(case)" class="{{case.cssClass}}" ng-style="{'background-color' : case.backgrdStyle}">{{case.libelle}}</button>
</p>

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