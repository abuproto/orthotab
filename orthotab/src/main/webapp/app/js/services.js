'use strict';

/* Services */

// var orthotabServices = angular.module('orthotabServices', [
// 'ngResource','ngCookies']);
var orthotabServices = angular.module('orthotabServices', [ 'ngResource']);

orthotabServices.factory('Couleurs', [ '$resource', function($resource) {
	/* return $resource('http://localhost\\:8081/orthotab/api/couleurs', {}, { */
	return $resource('/orthotab/api/couleurs/:nbCouleurs', {nbCouleurs:'@nbCouleurs'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Niveau01', [ '$resource', function($resource) {
	/* return $resource('http://localhost\\:8081/orthotab/api/niveau01', {}, { */
	return $resource('/orthotab/api/niveau01/:nbCombi', {nbCombi:'@nbCombi'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Accueil', [ '$resource', function($resource) {
	return $resource('/orthotab/api/accueil/:nivcourant', {nivcourant:'@nivcourant'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);



orthotabServices.factory('UserNiveauService', [ '$resource', function($resource) {
	return $resource('/orthotab/api/majniveau/:userid/:niveau', {userid:'@userid', niveau:'@niveau'}, {
		majniveau : {
			method : 'POST'
		}
	});
} ]);


orthotabServices.factory('UserService', [ '$http', function($http, $user) {
	
	var currentUser = null;
	
	return {
	    login: function($user) {
	    	//var promise = $http
	        //.post('/orthotab/api/authenticate', $user) //headers: { 'Content-Type': false }
	    	//({method: 'POST', url: '/orthotab/api/authenticate', headers: { 'Accept': 'application/json','Content-Type': 'application/json' 
	        //}})
	    	//data : angular.toJson($user)
	    	$http
	    	({method: 'POST', url: '/orthotab/api/authenticate', data : angular.toJson($user) })
	        .success(function (data, status, headers, config) {
	          console.log("dans success");
	          console.log("data : ." + data + ".");
	          console.log("data.nom : ." + data.nom + ".");
	          currentUser = data;
	          //return currentUser;
	        })
	        .error(function (data, status, headers, config) {
	        	console.log("dans error");
	        	currentUser = null;
	        	//return currentUser;
	        });
	    	//return promise;
	    	},
	    currentUser: function() { return currentUser; }
	  };
	  
	  
	    var promise = $http.get('/api/users/' + $cookies.id).
	    success(function (data) {
	        var userInfo = data.user[0];
	        return userInfo;
	    });
	    return promise;
	  
} ]);