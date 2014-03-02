<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Orthotab</title>
<%@include file="../includes/inc_head.htm"%>

</head>
<body ng-app="orthotabApp">
<div ng-controller="LoginCtrl">
<table>
<tr height="50%">
<td colspan="2" width="70%">
<img alt="orthotab" src="../images/orthotab.png" width="200px" height="100px"/>
</td>
<td width="30%" valign="top"><img alt="perroquet" src="../images/perroquet.jpg" width="200" height="200"></td>
</tr>
<tr height="50%">
<td>
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
<span>Bonjour {{utilisateur}}!</span><br/><br/>
<button class="boutonGeneral" ng-click="changerUtilisateur()">Changer d'utilisateur</button>
</div>
</td>
<td>
<div ng-show="isLogged" align="center">
<img alt="orthotab" src="../images/depart.png" width="200" height="100" ng-click="depart()"/>
<br/>
<button class="boutonGeneral" ng-click="didactHome()">Didacticiel</button>
</div>
</td>
<td>
<div ng-if="isLogged">
<div ng-controller="AvancementCtrl" class="div-login">
<p ng-bind-html="messageavancement"></p>

<svg xmlns="http://www.w3.org/2000/svg" version="1.1" >
<style type="text/css" >
      <![CDATA[
      
        line.fait {
        	stroke: green;
        	stroke-width: 20;
        }
        line.restant {
        	stroke: grey;
        	stroke-width: 20;
        }

      ]]>
    </style>
<line x1="0" y1="0" x2="{{longueurfait}}" y2="0" class="fait"/>
<line x1="{{longueurfait}}" y1="0" x2="{{longueurbarre}}" y2="0" class="restant"/>

</svg>
</div>
</div>
</td>
</tr>
</table>
</div>
</body>
</html>