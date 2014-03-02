<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="nivdifficulte='5'">
<div class="div-haut" ng-controller="DidactNavCtrl">
<%@include file="../includes/inc_didactnav.htm"%>
<div id="center">Associer des paires par couleur</div>
</div>
<div class="div-milieu">
<div align="center" id="couleurs" ng-controller="CouleursCtrl">
<button class="{{couleur.cssClass}}" ng-repeat="couleur in couleurs" style="background-color:{{couleur.code}};" ng-click="enregistreCouleur(couleur, $event, $index)"/>
</div>
<div align="center" id="cases" ng-controller="Didact01Ctrl">
<button class="{{case.cssClass}}" ng-style="{'border-color' : case.backgrdStyle}" ng-repeat="case in cases" ng-click="enregistreCase(case, $event, $index)">
</button>
</div>
<div align="center" class="messageExercice">{{messageNiveau01}}</div>
</div>
</body>
</html>