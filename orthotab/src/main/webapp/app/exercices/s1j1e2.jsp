<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="niveau='s1j1e2'">
<div id="page">
	<div id="bloc-principal">
<div class="div-haut" ng-controller="ExercicesNavCtrl" ng-init="groupe='s1j1'">
<%@include file="../includes/inc_exercicesnav.htm"%>
<div id="center"><p align="center">Relier des colonnes</p></div>
</div>
<div><p class="consigne">{{consigne}}</p></div>
<div class="div-milieu" ng-controller="Technique02Ctrl">


<div id="milieu-left">
<div align="right" id="casesg" ng-repeat="case in casesg">
<button class="{{case.cssClass}}" ng-style="{'border-color' : case.backgrdStyle}" ng-click="enregistreCaseG(case, $event, $index)">
{{case.libelle}}</button>
</div>

</div>
<div id="milieu-right">
<div align="left" id="casesd" ng-repeat="case in casesd">
<button class="{{case.cssClass}}" ng-style="{'border-color' : case.backgrdStyle}" ng-click="enregistreCaseD(case, $event, $index)">
{{case.libelle}}</button>
</div>
</div>


<div id="center-relier-colonnes" align="center">
<svg xmlns="http://www.w3.org/2000/svg" version="1.1" width="200" height="200">
<style type="text/css" >
      <![CDATA[

        circle.avant {
           fill:   green;
        }

        path.correct {
        	stroke: green;
        	stroke-width: 5;
        }
        
        path.masque {
        	stroke: white;
        	stroke-width: 0;
        }

      ]]>
    </style>

<circle cx="{{casesg[0].loc.x}}" cy="{{casesg[0].loc.y}}" r="5" class="avant"/>
<path d="{{pathInfos[0].loc}}" class="{{pathInfos[0].cssClass}}"/>
<circle cx="{{casesd[0].loc.x}}" cy="{{casesd[0].loc.y}}" r="5" class="avant"/>

<circle cx="{{casesg[1].loc.x}}" cy="{{casesg[1].loc.y}}" r="5" class="avant"/>
<path d="{{pathInfos[1].loc}}" class="{{pathInfos[1].cssClass}}"/>
<circle cx="{{casesd[1].loc.x}}" cy="{{casesd[1].loc.y}}" r="5" class="avant"/>

<circle cx="{{casesg[2].loc.x}}" cy="{{casesg[2].loc.y}}" r="5" class="avant"/>
<path d="{{pathInfos[2].loc}}" class="{{pathInfos[2].cssClass}}"/>
<circle cx="{{casesd[2].loc.x}}" cy="{{casesd[2].loc.y}}" r="5" class="avant"/>

<circle cx="{{casesg[3].loc.x}}" cy="{{casesg[3].loc.y}}" r="5" class="avant"/>
<path d="{{pathInfos[3].loc}}" class="{{pathInfos[3].cssClass}}"/>
<circle cx="{{casesd[3].loc.x}}" cy="{{casesd[3].loc.y}}" r="5" class="avant"/>

<circle cx="{{casesg[4].loc.x}}" cy="{{casesg[4].loc.y}}" r="5" class="avant"/>
<path d="{{pathInfos[4].loc}}" class="{{pathInfos[4].cssClass}}"/>
<circle cx="{{casesd[4].loc.x}}" cy="{{casesd[4].loc.y}}" r="5" class="avant"/>
</svg>
</div>
	
</div>
	</div><!-- fin bloc-principal -->
	<div id="footer" align="center" class="messageExercice">
	<p class="messageExercice">{{messageNiveau}}</p>
	</div>
</div><!-- fin page -->

</body>
</html>