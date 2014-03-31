<!doctype html>
<html lang="en" ng-app="orthotabApp">
<head>
  <meta charset="utf-8">
  <title>Orthotab : accueil</title>
<%@include file="../includes/inc_head.htm"%>
</head>
<body>

<div id="accueil" ng-controller="InfosActivityCtrl">


<div class="div-haut-accueil">
<div id="left">
</div>
<div id="right"><img src="../images/icone_home.jpg" alt="Retour Accueil" ng-click="home()"/></div>
<div id="center"><p align="center">Suivi Activité</p></div>
</div>


<%@include file="../includes/inc_waitcharge.htm"%>

<div class="div-milieu-accueil" ng-show="!chargementEnCours" align="center">
<p><span>filter par prénom : <input ng-model="search.libUtilisateur"></span>&nbsp;
<span>filter par semaine : <select ng-model="search.noSemaine" ng-options="sem for sem in sems"></select></span>&nbsp;
<span>filter par exercice : <input ng-model="search.exercice"></span>
</p>
<table class="tabSuivi">
  <tr><th>Prénom ou Nom</th><th>Semaine</th><th>Exercice</th><th>Durée (h:mm:ss)</th><th>Nb échecs</th><th>Date</th></tr>
  <tr ng-repeat="info in ia | filter:search:strict">
    <td>{{info.libUtilisateur}}</td>
    <td align="center">{{info.noSemaine}}</td>
    <td align="center">{{info.exercice}}</td>
    <td align="center">{{info.duree}}</td>
    <td align="center">{{info.nbEchec}}</td>
    <td align="center">{{info.dateIa}}</td>
  </tr>
</table>

</div>

</div>

</body>
</html>