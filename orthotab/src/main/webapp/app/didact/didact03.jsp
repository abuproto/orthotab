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

<div id="center"><p align="center">Calcul Flash</p></div>
</div>
<div align="center"><p class="messageExercice">{{messageNiveau}}</p>
</div>
<div class="div-milieu" ng-controller="Didact03Ctrl">

<div id="milieu-left">
<div align="center" ng-hide="tempsEcoule">
<p class="groupe-case"><button class="btn-case btn-case-etoile"></button></p>
<p class="signe">+</p>
<p class="groupe-case"><button class="btn-case btn-case-etoile">
<button class="btn-case btn-case-etoile"></p>
</div>
</div>
<div id="milieu-right">
<div align="center" ng-show="tempsEcoule">
<p class="{{cssResultat[0].cssClass}}" ng-click="valider(1)"><button class="btn-case btn-case-etoile"></button></p>
<p class="{{cssResultat[1].cssClass}}" ng-click="valider(2)"><button class="btn-case btn-case-etoile"></button><button class="btn-case btn-case-etoile"></button></p>
<p class="{{cssResultat[2].cssClass}}" ng-click="valider(3)"><button class="btn-case btn-case-etoile"></button>
<button class="btn-case btn-case-etoile"></button>
<button class="btn-case btn-case-etoile"></button>
</p>
<br/>
</div>
</div>

</div>

	</div><!-- fin bloc-principal -->
</div><!-- fin page -->
</body>
</html>