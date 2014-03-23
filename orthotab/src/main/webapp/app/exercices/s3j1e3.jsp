<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="niveau='s3j1e3';optCalcul=true;">
<div id="page">
	<div id="bloc-principal">
<div class="div-haut" ng-controller="ExercicesNavCtrl" ng-init="groupe='s3j1'">
<%@include file="../includes/inc_exercicesnav.htm"%>
<div id="center"><p align="center">Boîtes à compléter</p></div>
</div>
<%@include file="../includes/inc_messages.htm"%>
<div class="div-milieu" ng-controller="Technique06Ctrl">

<div align="center" ng-hide="debut"><button class="boutonGeneral2" ng-click="commencer()">Commencer l'exercice</button></div>

<div ng-show="debut">

	<div id="milieu-left-large">
	
	<div align="center" class="emplacement-cible-groupe">
	<span>Boîte de {{boiteCourant.valmax}} </span><span><button class="emplacement-choix-rond"></button></span>
	<br/>
	<span>Il y a déjà : {{boiteCourant.valacquis}}</span><span><button class="emplacement-choix-rond"></button></span>
	<br/>
	Il en manque : <span class="emplacement-cible-small" align="center">{{boiteCourant.librestant}}</span>
	</div>
		
	</div>
	
	<div id="milieu-right">
	<div align="center" ng-repeat="caseChoix in boiteCourant.listeCaseChoix"><button class="{{caseChoix.cssClass}}" ng-style="{'background-color' : caseChoix.backgrdStyle}" ng-click="enregistreCase(caseChoix)">{{caseChoix.libelle}}</button></div>
	<div align="center" ng-hide="niveauFini" ng-style="{'margin-top' : '20px'}">
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