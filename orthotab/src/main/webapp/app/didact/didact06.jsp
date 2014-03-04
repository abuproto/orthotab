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

<div id="center"><p align="center">Remplir des emplacements</p></div>
</div>


<div class="div-milieu" ng-controller="Didact06Ctrl">

	<div id="milieu-left-large">
	<p align="center"><button class="btn-case btn-case-etoile" ng-style="{'border-color' : 'red'}"></button></p>
	
	<div droppable="true" align="center" class="groupe-case">
	<button class="{{caseCible[0].cssClass}}">&nbsp;</button>
	<button class="{{caseCible[1].cssClass}}">&nbsp;</button>
	<button class="{{caseCible[2].cssClass}}">&nbsp;</button>
	<button class="{{caseCible[3].cssClass}}">&nbsp;</button>
	</div>
	</div>
	
	<div id="milieu-right-large">
	<div align="center" draggable="true" id="item0" class="groupe-case"><button class="{{caseSource[0].cssClass}}"></button><button class="{{caseSource[0].cssClass}}"></button></div>
	<div align="center" draggable="true" id="item1" class="groupe-case"><button class="{{caseSource[1].cssClass}}"></button></div>
	<div align="center" draggable="true" id="item2" class="groupe-case"><button class="{{caseSource[2].cssClass}}"></button><button class="{{caseSource[2].cssClass}}"></button></div>
	<div align="center" draggable="true" id="item3" class="groupe-case"><button class="{{caseSource[3].cssClass}}"></button><button class="{{caseSource[3].cssClass}}"></button><button class="{{caseSource[3].cssClass}}"></button></div>
	</div>

</div>
	
	</div><!-- fin bloc-principal -->
	<div id="footer" align="center" class="messageExercice">{{messageNiveau}}</div>
</div><!-- fin page -->

</body>
</html>