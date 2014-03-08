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

<div id="center"><p align="center">M�mory multipliant</p></div>
</div>


<div class="div-milieu" ng-controller="Didact07Ctrl">

	<div id="milieu-left">
	<p align="right" ng-repeat="case in caseChoixG"><button class="case-nombre" ng-style="{'background-color' : case.backgrdStyle}" ng-click="enregistreCaseG(case, $event, $index)">{{case.valeur}}</button></p>
	</div>
	
	<div id="milieu-right">
	<p align="right" ng-repeat="case in caseChoixD"><button class="case-nombre" ng-style="{'background-color' : case.backgrdStyle}" ng-click="enregistreCaseD(case, $event, $index)">{{case.valeur}}</button></p>
	</div>
	<div id="center" align="center">
	<p align="center"><button class="case-nombre">{{caseCible[0].valeur}}</button></p>
	<div class="signe" style="margin-top:100px;">X</div>
	</div>
</div>
	
	</div><!-- fin bloc-principal -->
	<div id="footer" align="center" class="messageExercice">{{messageNiveau}}</div>
</div><!-- fin page -->

</body>
</html>