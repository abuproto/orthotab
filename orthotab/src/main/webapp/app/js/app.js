'use strict';

/* App Module */
var orthotabApp = angular.module('orthotabApp', ['orthotabControllers','orthotabServices']);

//$scope.enregistreCouleur = function (couleur, $event) {
	//console.log(item + ' was clicked at: ' + $event.clientX + ',' +
	//$event.clientY);
	//$scope.codeCouleurCourant = couleur.code;
	//};


	function enregistreCouleur($rootScope, $scope, couleur, $event) {
		console.log("debut");
		$rootScope.codeCouleurCourant = couleur.code;
		}
	
/*
var orthotabApp = angular.module('orthotabApp', [
  'ngRoute',
  'phonecatAnimations',

  'phonecatControllers',
  'phonecatFilters',
  'phonecatServices'
]);

phonecatApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/phones', {
        templateUrl: 'partials/phone-list.html',
        controller: 'PhoneListCtrl'
      }).
      when('/phones/:phoneId', {
        templateUrl: 'partials/phone-detail.html',
        controller: 'PhoneDetailCtrl'
      }).
      otherwise({
        redirectTo: '/phones'
      });
  }]);
*/