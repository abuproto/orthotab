<!doctype html>
<html lang="en" ng-app="orthotabApp">
<head>
  <meta charset="utf-8">
  <title>Orthotab : accueil</title>
<%@include file="../includes/inc_head.htm"%>
</head>
<body>

<div id="accueil">


<div class="div-haut-accueil" ng-controller="NavigationCtrl">
<div id="left">
</div>
<div id="right"><img src="../images/icone_home.jpg" alt="Retour Accueil" ng-click="home()"/></div>
<div id="center"><p align="center">Information Utilisateurs</p></div>
</div>


<%@include file="../includes/inc_waitcharge.htm"%>

<div ng-controller="InfosUtilisateurCtrl">
<div class="div-milieu-accueil" ng-show="!chargementEnCours && dspListe" align="center">

<table class="tabSuivi">
  <tr><th>Prénom / Nom</th><th>Délai entre 2 niveaux<br/>(jour:heure:minute)</th><th>Niveau courant</th><th>Nb total cacahuètes</th></tr>
  <tr ng-repeat="info in iu">
    <td>{{info.libUtilisateur}}</td>
    <td align="center"><a ng-click="majParametre(info.idUser,info.paramInterjour)" class="lienAdmin">{{info.paramInterjour}}</a></td>
    <td align="center">{{info.libNivCourant}}</td>
    <td align="center">{{info.nbTotCac}}</td>
  </tr>
</table>

</div>
</div>

<div ng-controller="ParametreCtrl" ng-hide="dspListe">
<div id="center"><p align="center">Modification Paramètre (Délai entre niveau)</p></div>

<div class="div-milieu-accueil" align="center">

<form ng-submit="submit()">
<table class="tabSuivi">
  <tr><td>heures</td><td><input ng-model="parametre.heure" type="text" placeholder="0"/></td></tr>
  <tr><td>minutes</td><td><input ng-model="parametre.minute" type="text" placeholder="0"/></td></tr>
</table>
<input type="submit" value="Enregistrer" class="boutonGeneral"/>

</form>

</div>
</div>

</div>

</body>
</html>