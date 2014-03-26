<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>

</head>
<body ng-app="orthotabApp">
<div ng-controller="LoginCtrl">

<div class="div-haut-accueil">
<div id="left">
</div>
<div id="right"></div>
<div id="center"><p align="center">Bienvenue dans le monde de Samba dans la jungle des nombres</p></div>
</div>

<div class="div-milieu" align="center">

<div id="milieu-left-accueil">
<p><img alt="jungle" src="../images/page_accueil_appli-300x225.jpg"></p>

</div>

<div id="milieu-right-accueil">
  <div ng-hide="isLogged" class="div-login">
  <form ng-submit="submit()">
    <input ng-model="user.login" type="text" name="user" placeholder="identifiant" /><br/>
    <input ng-model="user.password" type="password" name="pass" placeholder="mot de passe" /><br/>
    <input type="submit" value="Connexion" class="boutonGeneral"/>
  </form>
  <span>{{message}}</span>
  <span class="infosClient">{{infosClient}}</span>
  </div>
<div ng-show="isLogged" class="div-login">
<span>Bonjour {{utilisateurPrenom}}!</span><br/><br/>
<button class="boutonGeneral" ng-click="changerUtilisateur()">Changer d'utilisateur</button>
</div>

<div ng-show="isLogged" align="center" class="div-login">
<button class="boutonGeneral" ng-click="depart()">Accès aux exercices</button>
<br/><br/>
<button class="boutonGeneral" ng-click="didactHome()">Didacticiel</button>
</div>

<div ng-show="isLogged && isAdmin" class="div-login">

<!--<div align="center" ng-show="{{utilisateur.role=='ADMIN'}}">-->
<div align="center">
<p align="center">Réservé aux administrateurs :</p>
<p><button class="boutonGeneral" ng-click="accesExercices()">Accès à tous les exercices</button></p>
</div>
</div>

</div>

</div>
</body>
</html>