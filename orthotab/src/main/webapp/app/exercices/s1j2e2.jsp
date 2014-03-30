<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>
  
</head>
<body ng-app="orthotabApp" ng-init="niveau='s1j2e2';nbocc=3;optIntrus=false;nbIntrus=0;">
<div id="page">
	<div id="bloc-principal">
<div class="div-haut" ng-controller="ExercicesNavCtrl" ng-init="groupe='s1j2'">
<%@include file="../includes/inc_exercicesnav.htm"%>
<div id="center"><p align="center">Relier des colonnes</p></div>
</div>
<%@include file="../includes/inc_messages.htm"%>

<%@include file="../includes/inc_waitcharge.htm"%>

<div class="div-milieu" ng-controller="Technique02Ctrl">


<div id="milieu-left">
<div align="right" id="casesg" ng-repeat="case in casesg">
<button class="{{case.cssClass}}" ng-style="{'background-color' : case.backgrdStyle}" ng-click="enregistreCaseG(case, $event, $index)">
{{case.libelle}}</button>
</div>

</div>
<div id="milieu-right">
<div align="left" id="casesd" ng-repeat="case in casesd">
<button class="{{case.cssClass}}" ng-style="{'background-color' : case.backgrdStyle}" ng-click="enregistreCaseD(case, $event, $index)">
{{case.libelle}}</button>
</div>
</div>


<div id="center-relier-colonnes" align="center">
<svg xmlns="http://www.w3.org/2000/svg" version="1.1" width="200" height="400">
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
<%
for(int i=0;i<3;i++){
%>
<circle cx="{{casesg[<%=i%>].loc.x}}" cy="{{casesg[<%=i%>].loc.y}}" r="5" class="avant"/>
<path d="{{pathInfos[<%=i%>].loc}}" class="{{pathInfos[<%=i%>].cssClass}}"/>
<circle cx="{{casesd[<%=i%>].loc.x}}" cy="{{casesd[<%=i%>].loc.y}}" r="5" class="avant"/>
<% } %>

</svg>
</div>
	
</div>
	</div><!-- fin bloc-principal -->
</div><!-- fin page -->

</body>
</html>