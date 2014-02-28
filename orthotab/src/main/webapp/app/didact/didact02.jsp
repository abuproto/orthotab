<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
  <%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="nivdifficulte='4'">
<div class="div-haut">
<div id="left">
<span><img src="../images/icone_menu.png" alt="Menu didacticiel"/></span>
<span><img src="../images/icone_redo.png" alt="Recommencer"/></span>
</div>
<div id="right"><img src="../images/icone_home.jpg" alt="Retour Accueil"/></div>
<div id="center">Relier des colonnes</div>
</div>
<div class="div-milieu" ng-controller="Didact02Ctrl">

<div id="milieu-left">
<div align="right" id="casesg" ng-repeat="case in casesg">
<button class="{{case.cssClass}}" ng-style="{'border-color' : case.backgrdStyle}" ng-click="enregistreCaseG(case, $event, $index)">
</button>
</div>

</div>
<div id="milieu-right">
<div align="left" id="casesd" ng-repeat="case in casesd">
<button class="{{case.cssClass}}" ng-style="{'border-color' : case.backgrdStyle}" ng-click="enregistreCaseD(case, $event, $index)">
</button>
</div>
</div>


<div id="center">
<svg xmlns="http://www.w3.org/2000/svg" version="1.1" >
<style type="text/css" >
      <![CDATA[

        circle.avant {
           fill:   blue;
        }
       circle.apres {
           fill:   grey;
        }
        
 		circle.actif {
           fill:   red;
        }
        path.avant {
        	stroke: blue;
        	stroke-width: 5;
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

<circle cx="20" cy="20" r="5" class="avant"/>
<path d="{{pathInfos[0].loc}}" class="{{pathInfos[0].cssClass}}"/>
<circle cx="180" cy="20" r="5" class="avant"/>

<circle cx="20" cy="120" r="5" class="avant"/>
<path d="{{pathInfos[1].loc}}" class="{{pathInfos[1].cssClass}}"/>
<circle cx="180" cy="120" r="5" class="avant"/>

<circle cx="20" cy="220" r="5" class="avant"/>
<path d="{{pathInfos[2].loc}}" class="{{pathInfos[2].cssClass}}"/>
<circle cx="180" cy="220" r="5" class="avant"/>

<circle cx="20" cy="320" r="5" class="avant"/>
<path d="{{pathInfos[3].loc}}" class="{{pathInfos[3].cssClass}}"/>
<circle cx="180" cy="320" r="5" class="avant"/>
</svg>
</div>

</div>

<div align="center" class="messageExercice">{{messageNiveau01}}message</div>
</div>
</body>
</html>