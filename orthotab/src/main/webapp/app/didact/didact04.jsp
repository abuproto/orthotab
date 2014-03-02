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
<div id="center">Mémory</div>
</div>
<div class="div-milieu" ng-controller="Didact04Ctrl">

<div align="center">
<button class="{{case.cssClass}}" ng-repeat="case in cases | filter:{row:1}" ng-style="{'border-color' : case.backgrdStyle}" ng-click="enregistreCase(case, $event, $index)">
</div>
<div align="center">
<button class="{{case.cssClass}}" ng-repeat="case in cases | filter:{row:2}" ng-style="{'border-color' : case.backgrdStyle}" ng-click="enregistreCase(case, $event, $index)">
</div>

</div>

<div align="center" class="messageExercice">{{messageNiveau}}</div>
</div>
</body>
</html>