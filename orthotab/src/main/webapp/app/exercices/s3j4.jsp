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
<div id="center"><p align="center">Semaine 3 - Jour 4</p></div>
</div>

<div class="div-milieu" align="center">
<button class="boutonGeneral2" ng-click="exercices(3,4,1)">Relier les colonnes</button><br/>
</div>

</div>

</body>
</html>