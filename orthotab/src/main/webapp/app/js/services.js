'use strict';

/* Services */

var orthotabServices = angular.module('orthotabServices', [ 'ngResource']);

orthotabServices.factory('Couleurs', [ '$resource', function($resource) {
	return $resource('/orthotab/api/couleurs/:nbCouleurs', {nbCouleurs:'@nbCouleurs'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique01', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique01/:nbCombi', {nbCombi:'@nbCombi'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);


orthotabServices.factory('Didact01', [ '$resource', function($resource) {
	return $resource('/orthotab/api/didact01/:nbCombi', {nbCombi:'@nbCombi'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Didact02', [ '$resource', function($resource) {
	return $resource('/orthotab/api/didact02/:nbCombi/:pos', {nbCombi:'@nbCombi',pos:'@pos'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Didact04', [ '$resource', function($resource) {
	return $resource('/orthotab/api/didact04/:nbCombi', {nbCombi:'@nbCombi'}, {
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

orthotabServices.factory('UserTokenService', [ '$resource', function($resource) {
	return $resource('/orthotab/api/findByToken/:token', {token:'@token'}, {
		findByToken : {
			method : 'POST'
		}
	});
} ]);


orthotabServices.factory('UserAuthService', [ '$resource', function($resource) {
	return $resource('/orthotab/api/authenticate2/:login/:passw', {login:'@login', passw:'@passw'}, {
		authenticate : {
			method : 'POST'
		}
	});
} ]);

orthotabServices.factory('UserConnecteService', function($rootScope) {
	var service = {};
	service.userConnecte = null;
	
	service.updateUserConnecte  = function(user){
		this.userConnecte = user;
		$rootScope.$broadcast("userUpdated");
		console.log("this.userConnecte : " + this.userConnecte.prenom);
	}
	return service;
	
	return {
	      getUserConnecte: function() { return this.userConnecte; }
	    };
});



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