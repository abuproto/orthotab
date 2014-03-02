<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp">
<div class="div-haut" ng-controller="DidactNavCtrl">
<%@include file="../includes/inc_didactnav.htm"%>

<div id="center">Remplir des emplacements</div>
</div>
<div class="div-milieu" ng-controller="Didact06Ctrl">

<div id="milieu-left">
<p><button class="btn-case btn-case-etoile"></button></p>

<div droppable="true">
<button class="{{caseCible[0].cssClass}}"></button>
<button class="{{caseCible[1].cssClass}}"></button>
<button class="{{caseCible[2].cssClass}}"></button>
<button class="{{caseCible[3].cssClass}}"></button>
</div>
</div>
<div id="milieu-right">
<div draggable="true" id="item0"><button class="{{caseSource[0].cssClass}}"></button><button class="{{caseSource[0].cssClass}}"></button></div>
</div>

</div>

<div align="center" class="messageExercice">{{messageNiveau}}</div>
</div>
</body>
</html>