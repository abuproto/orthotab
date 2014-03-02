<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>

</head>
<body ng-app="orthotabApp" ng-controller="Didact0Ctrl">

<div class="div-haut">
<div id="left">
</div>
<div id="right"><img src="../images/icone_home.jpg" alt="Retour Accueil" ng-click="home()"/></div>
<div id="center">Didacticiel</div>
</div>

<div class="div-milieu" align="center">
<button class="boutonGeneral2" ng-click="didact(01)">1 - Associer des paires par couleur</button><br/>
<button class="boutonGeneral2" ng-click="didact(02)">2 - Relier des colonnes</button><br/>
<button class="boutonGeneral2" ng-click="travaux()">3 - Calcul flash</button><br/>
<button class="boutonGeneral2" ng-click="travaux()">4 - Mémory</button><br/>
<button class="boutonGeneral2" ng-click="travaux()">5 - Dominos</button><br/>
<button class="boutonGeneral2" ng-click="didact(06)">6 - Remplir des emplacements</button><br/>
<button class="boutonGeneral2" ng-click="travaux()">7 - Mémory multipliant</button><br/>
<button class="boutonGeneral2" ng-click="travaux()">8 - Calcul à trou</button><br/>
<button class="boutonGeneral2" ng-click="travaux()">9 - Remettre dans le bon ordre</button>
</div>

</body>
</html>