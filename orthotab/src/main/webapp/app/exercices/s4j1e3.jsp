<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="niveau='s4j1e3';optValeur=true;">
<div id="page">
	<div id="bloc-principal">
<div class="div-haut" ng-controller="ExercicesNavCtrl" ng-init="groupe='s4j1'">
<%@include file="../includes/inc_exercicesnav.htm"%>
<div id="center"><p align="center">Dominos</p></div>
</div>
<%@include file="../includes/inc_messages.htm"%>
<div class="div-milieu" ng-controller="Technique05Ctrl">

<div class="domino-div">
<span class="{{domino.cssClass}}" ng-repeat="domino in dominoCible"><button class="domino-small">{{domino.libg}}</button><button class="domino-small">{{domino.libd}}</button></span>
</div>

<div class="domino-div">
<span class="{{domino.cssClass}}" ng-repeat="domino in dominoChoix" ng-click="enregistreDomino(domino)"><button class="domino-small">{{domino.libg}}</button><button class="domino-small">{{domino.libd}}</button></span>
</div>


</div>

	</div><!-- fin bloc-principal -->
</div><!-- fin page -->

</body>
</html>