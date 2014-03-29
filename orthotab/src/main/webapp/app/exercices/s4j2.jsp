<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>

</head>
<body ng-app="orthotabApp" ng-init="groupe='s4j2';">
<div ng-controller="ExercicesNavCtrl">
<div class="div-haut">
<div id="left">
</div>
<div id="right"><img src="../images/icone_home.jpg" alt="Retour Accueil" ng-click="home()" style="cursor: hand;cursor: pointer;"/></div>
<div id="center"><p align="center">Semaine 4 - Jour 2</p></div>
</div>

<div class="div-milieu" align="center">
<p ng-repeat="infos in infosexercice" class="menu-exercice"><button class="{{infos.cssClass}}" ng-click="exercices(infos.semaine,infos.jour,infos.ex)">{{infos.libelle}}</button>
<span ng-hide="infos.actif"><img class="menu-exercice" ng-src="../images/{{infos.nomImgCac}}"/></span></p>
</div>

</div>

</body>
</html>