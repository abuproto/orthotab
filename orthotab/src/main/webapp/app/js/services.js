'use strict';

/* Services */

//var orthotabServices = angular.module('orthotabServices', [ 'ngResource','ngCookies']);
var orthotabServices = angular.module('orthotabServices', [ 'ngResource']);

orthotabServices.factory('Couleurs', [ '$resource', function($resource) {
	/* return $resource('http://localhost\\:8081/orthotab/api/couleurs', {}, { */
	return $resource('/orthotab/api/couleurs', {}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Niveau01', [ '$resource', function($resource) {
	/* return $resource('http://localhost\\:8081/orthotab/api/niveau01', {}, { */
	return $resource('/orthotab/api/niveau01', {}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Accueil', [ '$resource', function($resource) {
	return $resource('/orthotab/api/accueil', {}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('User', [ '$cookieStore', function($cookieStore) {
	return {
		isLogged : function($cookieStore) {
			var cookieOrthoTab = null;
			// ATTENTION : cookieStore ne fonctionne pas dans un service
			//$cookieStore.put('orthotab','patient1');
			//var cookieOrthoTab = $cookieStore.get('orthotab');
			//$cookies.orthotab = "patient1";
			//var cookieOrthoTab = $cookies.orthotab;
			if(cookieOrthoTab!=null){
				// a completer avec verification User
				return true;
			}else{
				return false;
			}
		}
	};
} ]);