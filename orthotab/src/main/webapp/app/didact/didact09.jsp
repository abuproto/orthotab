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

<div id="center"><p align="center">Remettre dans le bon ordre</p></div>
</div>

<div align="center"><p class="messageExercice">{{messageNiveau}}</p>
</div>
<div class="div-milieu" ng-controller="Didact09Ctrl">

<p align="center">
<button ng-repeat="case in caseCible" ng-click="enregistreCaseH(case)" class="{{case.cssClass}}" ng-style="{'background-color' : case.backgrdStyle}">&nbsp;{{case.valeur}}&nbsp;</button>
</p>

<p align="center">
<button ng-repeat="case in caseChoix" ng-click="enregistreCaseB(case)" class="{{case.cssClass}}" ng-style="{'background-color' : case.backgrdStyle}">&nbsp;{{case.valeur}}&nbsp;</button>
</p>

</div>
	
	</div><!-- fin bloc-principal -->
</div><!-- fin page -->

</body>
</html>