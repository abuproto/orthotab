<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="niveau='s2j5e1';nbocc=11;">
<div id="page">
	<div id="bloc-principal">
<div class="div-haut" ng-controller="ExercicesNavCtrl" ng-init="groupe='s2j5'">
<%@include file="../includes/inc_exercicesnav.htm"%>
<div id="center"><p align="center">Mémory</p></div>
</div>
<%@include file="../includes/inc_messages.htm"%>
<div class="div-milieu" ng-controller="Technique04Ctrl">

<div align="center">
<button class="{{case.cssClass}}" ng-repeat="case in cases | filter:{row:1}" ng-style="{'background-color' : case.backgrdStyle}" ng-click="enregistreCase(case, $event, $index)">
{{case.libelle}}</button>
</div>
<div align="center">
<button class="{{case.cssClass}}" ng-repeat="case in cases | filter:{row:2}" ng-style="{'background-color' : case.backgrdStyle}" ng-click="enregistreCase(case, $event, $index)">
{{case.libelle}}</button>
</div>
<div align="center">
<button class="{{case.cssClass}}" ng-repeat="case in cases | filter:{row:3}" ng-style="{'background-color' : case.backgrdStyle}" ng-click="enregistreCase(case, $event, $index)">
{{case.libelle}}</button>
</div>
<div align="center">
<button class="{{case.cssClass}}" ng-repeat="case in cases | filter:{row:4}" ng-style="{'background-color' : case.backgrdStyle}" ng-click="enregistreCase(case, $event, $index)">
{{case.libelle}}</button>
</div>

</div>
	</div><!-- fin bloc-principal -->
</div><!-- fin page -->

</body>
</html>