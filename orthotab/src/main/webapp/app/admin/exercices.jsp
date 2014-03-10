<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>

</head>
<body ng-app="orthotabApp" ng-controller="ExercicesNavCtrl">

<div class="div-haut">
<div id="left">
</div>
<div id="right"><img src="../images/icone_home.jpg" alt="Retour Accueil" ng-click="home()" style="cursor: hand;cursor: pointer;"/></div>
<div id="center"><p align="center">Tous les exercices</p></div>
</div>

<div class="div-milieu" align="center">

<div id="milieu-left">
<button class="boutonGeneral" ng-click="exercices(1,1,0)">semaine 1 jour 1</button><br/>
<button class="boutonGeneral" ng-click="exercices(2,1,0)">semaine 2 jour 1</button><br/>
</div>
<div id="milieu-right">

</div>

<div id="center" align="center">

</div>

</div>

</body>
</html>