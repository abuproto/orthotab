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

<div id="center">Remplir des emplacements</div>
</div>


<div class="div-milieu" ng-controller="Didact05Ctrl">

<div class="domino-div">
<span class="{{domino.cssClass}}" ng-repeat="domino in dominoCible" droppable="{{domino.droppable}}"><button class="domino">{{domino.valg}}</button><button class="domino">{{domino.vald}}</button></span>
</div>

<div class="domino-div">
<span class="{{domino.cssClass}}" ng-repeat="domino in dominoChoix" id="{{$index}}" draggable="true"><button class="domino">{{domino.valg}}</button><button class="domino">{{domino.vald}}</button></span>
</div>

</div>
	
	</div><!-- fin bloc-principal -->
	<div id="footer" align="center" class="messageExercice">{{messageNiveau}}</div>
</div><!-- fin page -->

</body>
</html>