<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp">

<div id="page">
	<div id="bloc-principal">
	
	<div class="div-haut" ng-controller="DidactNavCtrl">
<%@include file="../includes/inc_didactnav.htm"%>

<div id="center"><p align="center">Remplir des emplacements</p></div>
</div>

<div align="center"><p class="messageExercice">{{messageNiveau}}</p>
</div>
<div class="div-milieu" ng-controller="Didact06Ctrl">

	<div id="milieu-left-large">
	
	<div align="center" class="emplacement-cible-groupe">
	<span>Boîte de {{caseCible[0].nbTotal}} </span><span><button class="emplacement-choix-etoile"></button></span>
	<br/>
	<span>Il y a déjà : {{caseCible[0].nbAcquis}}</span><span><button class="emplacement-choix-etoile"></button></span>
	<br/>
	Il en manque : <span class="emplacement-cible" align="center">{{caseCible[0].nbRestant}}</span>
	</div>
		
	</div>
	
	<div id="milieu-right">
	<div align="center" ng-repeat="caseChoix in caseListeChoix" class="{{caseChoix.cssClass}}" ng-click="enregistreCase(caseChoix)"><span>{{caseChoix.valeur}}</span><span><button class="emplacement-choix-etoile"></button></span></div>
	</div>

</div>
	
	</div><!-- fin bloc-principal -->
</div><!-- fin page -->

</body>
</html>