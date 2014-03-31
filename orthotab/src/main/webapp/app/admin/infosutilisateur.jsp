<!doctype html>
<html lang="en" ng-app="orthotabApp">
<head>
  <meta charset="utf-8">
  <title>Orthotab : accueil</title>
<%@include file="../includes/inc_head.htm"%>
</head>
<body>

<div id="accueil" ng-controller="InfosUtilisateurCtrl">


<div class="div-haut-accueil">
<div id="left">
</div>
<div id="right"><img src="../images/icone_home.jpg" alt="Retour Accueil" ng-click="home()"/></div>
<div id="center"><p align="center">Information Utilisateurs</p></div>
</div>


<%@include file="../includes/inc_waitcharge.htm"%>

<div class="div-milieu-accueil" ng-show="!chargementEnCours" align="center">

<table class="tabSuivi">
  <tr><th>Prénom / Nom</th><th>Délai entre 2 jours</th><th>Niveau courant</th><th>Nb total cacahuètes</th></tr>
  <tr ng-repeat="info in iu">
    <td>{{info.libUtilisateur}}</td>
    <td align="center">{{info.paramInterjour}}</td>
    <td align="center">{{info.libNivCourant}}</td>
    <td align="center">{{info.nbTotCac}}</td>
  </tr>
</table>

</div>

</div>

</body>
</html>