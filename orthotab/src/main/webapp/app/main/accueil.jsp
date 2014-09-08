<!doctype html>
<html lang="en" ng-app="orthotabApp">
<head>
  <meta charset="utf-8">
  <title>Orthotab : accueil</title>
<%@include file="../includes/inc_head.htm"%>
</head>
<body class="degrade">

<div id="accueil" ng-controller="AccueilCtrl">


<div class="div-haut-accueil">
<div id="left">
</div>
<div id="right"><img src="../images/icone_home.jpg" alt="Retour Accueil" ng-click="home()"/></div>
<div id="center"><p align="center">Samba dans la jungle des nombres</p></div>
</div>


<%@include file="../includes/inc_waitcharge.htm"%>

<div class="div-milieu-accueil" ng-show="!chargementEnCours">

<div ng-show="infosaccueil.nivcourant==26" id="milieu-left-accueil">
<p  class="messageExercice" align="center">Bravo, tu as terminé ! <a target="_blank" href="fin.htm">Clique ici</a></p>
</div>

<div ng-hide="infosaccueil.nivcourant==26" id="milieu-left-accueil">
<p  class="messageExercice" align="center">{{message}}</p>

<svg xmlns="http://www.w3.org/2000/svg" version="1.1" width="400" height="400">
<style type="text/css" >
      <![CDATA[

        circle.avant {
           fill:   #B5DED0;
        }
       circle.apres {
           fill:   #F9A41E;
        }
        
 		circle.actif {
           fill:   green;
        }
        path.avant {
        	stroke: #B5DED0;
        	stroke-width: 5;
        }
        path.apres {
        	stroke: #F9A41E;
        	stroke-width: 5;
        }

      ]]>
    </style>

<circle ng-click="goToNiveau($event,1)" cx="{{etapes[0].cx}}" cy="{{etapes[0].cy}}" r="20" class="{{etapes[0].circleCssClass}}"/>
<path d="{{etapes[0].d}}" class="{{etapes[0].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,2)" cx="{{etapes[1].cx}}" cy="{{etapes[1].cy}}" r="20" class="{{etapes[1].circleCssClass}}"/>
<path d="{{etapes[1].d}}" class="{{etapes[1].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,3)" cx="{{etapes[2].cx}}" cy="{{etapes[2].cy}}" r="20" class="{{etapes[2].circleCssClass}}"/>
<path d="{{etapes[2].d}}" class="{{etapes[2].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,4)" cx="{{etapes[3].cx}}" cy="{{etapes[3].cy}}" r="20" class="{{etapes[3].circleCssClass}}"/>
<path d="{{etapes[3].d}}" class="{{etapes[3].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,5)" cx="{{etapes[4].cx}}" cy="{{etapes[4].cy}}" r="20" class="{{etapes[4].circleCssClass}}"/>
<path d="{{etapes[4].d}}" class="{{etapes[4].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,6)" cx="{{etapes[5].cx}}" cy="{{etapes[5].cy}}" r="20" class="{{etapes[5].circleCssClass}}"/>
<path d="{{etapes[5].d}}" class="{{etapes[5].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,7)" cx="{{etapes[6].cx}}" cy="{{etapes[6].cy}}" r="20" class="{{etapes[6].circleCssClass}}"/>
<path d="{{etapes[6].d}}" class="{{etapes[6].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,8)" cx="{{etapes[7].cx}}" cy="{{etapes[7].cy}}" r="20" class="{{etapes[7].circleCssClass}}"/>
<path d="{{etapes[7].d}}" class="{{etapes[7].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,9)" cx="{{etapes[8].cx}}" cy="{{etapes[8].cy}}" r="20" class="{{etapes[8].circleCssClass}}"/>
<path d="{{etapes[8].d}}" class="{{etapes[8].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,10)" cx="{{etapes[9].cx}}" cy="{{etapes[9].cy}}" r="20" class="{{etapes[9].circleCssClass}}"/>
<path d="{{etapes[9].d}}" class="{{etapes[9].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,11)" cx="{{etapes[10].cx}}" cy="{{etapes[10].cy}}" r="20" class="{{etapes[10].circleCssClass}}"/>
<path d="{{etapes[10].d}}" class="{{etapes[10].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,12)" cx="{{etapes[11].cx}}" cy="{{etapes[11].cy}}" r="20" class="{{etapes[11].circleCssClass}}"/>
<path d="{{etapes[11].d}}" class="{{etapes[11].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,13)" cx="{{etapes[12].cx}}" cy="{{etapes[12].cy}}" r="20" class="{{etapes[12].circleCssClass}}"/>
<path d="{{etapes[12].d}}" class="{{etapes[12].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,14)" cx="{{etapes[13].cx}}" cy="{{etapes[13].cy}}" r="20" class="{{etapes[13].circleCssClass}}"/>
<path d="{{etapes[13].d}}" class="{{etapes[13].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,15)" cx="{{etapes[14].cx}}" cy="{{etapes[14].cy}}" r="20" class="{{etapes[14].circleCssClass}}"/>
<path d="{{etapes[14].d}}" class="{{etapes[14].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,16)" cx="{{etapes[15].cx}}" cy="{{etapes[15].cy}}" r="20" class="{{etapes[15].circleCssClass}}"/>
<path d="{{etapes[15].d}}" class="{{etapes[15].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,17)" cx="{{etapes[16].cx}}" cy="{{etapes[16].cy}}" r="20" class="{{etapes[16].circleCssClass}}"/>
<path d="{{etapes[16].d}}" class="{{etapes[16].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,18)" cx="{{etapes[17].cx}}" cy="{{etapes[17].cy}}" r="20" class="{{etapes[17].circleCssClass}}"/>
<path d="{{etapes[17].d}}" class="{{etapes[17].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,19)" cx="{{etapes[18].cx}}" cy="{{etapes[18].cy}}" r="20" class="{{etapes[18].circleCssClass}}"/>
<path d="{{etapes[18].d}}" class="{{etapes[18].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,20)" cx="{{etapes[19].cx}}" cy="{{etapes[19].cy}}" r="20" class="{{etapes[19].circleCssClass}}"/>
<path d="{{etapes[19].d}}" class="{{etapes[19].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,21)" cx="{{etapes[20].cx}}" cy="{{etapes[20].cy}}" r="20" class="{{etapes[20].circleCssClass}}"/>
<path d="{{etapes[20].d}}" class="{{etapes[20].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,22)" cx="{{etapes[21].cx}}" cy="{{etapes[21].cy}}" r="20" class="{{etapes[21].circleCssClass}}"/>
<path d="{{etapes[21].d}}" class="{{etapes[21].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,23)" cx="{{etapes[22].cx}}" cy="{{etapes[22].cy}}" r="20" class="{{etapes[22].circleCssClass}}"/>
<path d="{{etapes[22].d}}" class="{{etapes[22].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,24)" cx="{{etapes[23].cx}}" cy="{{etapes[23].cy}}" r="20" class="{{etapes[23].circleCssClass}}"/>
<path d="{{etapes[23].d}}" class="{{etapes[23].pathCssClass}}"/>
<circle ng-click="goToNiveau($event,25)" cx="{{etapes[24].cx}}" cy="{{etapes[24].cy}}" r="20" class="{{etapes[24].circleCssClass}}"/>
</svg>

</div>
<div id="milieu-right-accueil">
<div class="div-zone-accueil" ng-show="infosaccueil.nbcac>0">
<p class="messageExercice">Tu as déjà {{infosaccueil.nbcac}} cacahuètes</p>
</div>
<div class="div-zone-accueil" ng-show="infosaccueil.nbcac>0">
<p align="center" ng-repeat="objet in infosaccueil.listeNomObjet"><img ng-src="../images/{{objet}}_reduit.jpg"></p>
</div>
</div>

</div>

</div>

</body>
</html>