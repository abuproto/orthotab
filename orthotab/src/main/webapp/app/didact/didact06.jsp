<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
  <link rel="stylesheet" href="../css/app.css">
  
  <script src="../../lib/angular.js"></script>
  <script src="../../lib/angular-cookies.js"></script>
  <script src="../../lib/angular-resource.js"></script>
	<script src="../../lib/angular-sanitize.js"></script>
  <script src="../js/app.js"></script>
  <script src="../js/didact-controllers.js"></script>
  <script src="../js/services.js"></script>
  <script src="../js/directives.js"></script>
  <script src="../js/angular-local-storage.js"></script>
  
</head>
<body ng-app="orthotabApp">
<div class="div-haut">
<div id="left">
<span><img src="../images/icone_menu.png" alt="Menu didacticiel"/></span>
<span><img src="../images/icone_redo.png" alt="Recommencer"/></span>
</div>
<div id="right"><img src="../images/icone_home.jpg" alt="Retour Accueil"/></div>
<div id="center">Remplir des emplacements</div>
</div>
<div class="div-milieu" ng-controller="Didact06Ctrl">

<div id="milieu-left">
<p><button class="btn-case btn-case-etoile"></button></p>
<div droppable drop="handleDrop()">
<button class="btn-case-vide"></button>
<button class="btn-case-vide"></button>
<button class="btn-case-vide"></button>
<button class="btn-case-vide"></button>
</div>
</div>
<div id="milieu-right">
<div draggable id="item1"><button class="btn-case btn-case-etoile"></button><button class="btn-case btn-case-etoile"></button></div>
</div>

</div>

<div align="center" class="messageExercice">{{messageNiveau01}}</div>
</div>
</body>
</html>