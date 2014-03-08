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

<div id="center"><p align="center">Calcul à trou</p></div>
</div>


<div class="div-milieu" ng-controller="Didact08Ctrl">
<p align="center">

<button class="rond trou-plein" ng-style="{'background-color' : 'blue'}">&nbsp;</button>
<button class="carre trou-plein" ng-style="{'background-color' : 'white'}">{{caseCible[0].valeur}}</button>
<button class="rond trou-plein" ng-style="{'background-color' : 'yellow'}">&nbsp;</button>
<button class="carre trou-plein" ng-style="{'background-color' : '#B5B276'}">=</button>
<button class="rond trou-plein" ng-style="{'background-color' : 'green'}">&nbsp;</button>
</p>

<p align="center">
<button ng-repeat="case in caseChoix" class="{{case.cssClass}}" ng-style="{'background-color' : case.backgrdStyle}" ng-click="enregistreCase(case, $event, $index)">{{case.valeur}}</button>
</p>

</div>
	
	</div><!-- fin bloc-principal -->
	<div id="footer" align="center" class="messageExercice">{{messageNiveau}}</div>
</div><!-- fin page -->

</body>
</html>