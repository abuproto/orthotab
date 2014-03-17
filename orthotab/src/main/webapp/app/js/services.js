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

orthotabServices.factory('CouleursExercice', [ '$resource', function($resource) {
	return $resource('/orthotab/api/couleursExercice/:niveau', {niveau:'@niveau'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Commun01', [ '$resource', function($resource) {
	return $resource('/orthotab/api/pathinfos/:nb', {nb:'@nb'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique01', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique01/:niveau', {niveau:'@niveau'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique02', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique02/:niveau/:pos', {niveau:'@niveau',pos:'@pos'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique03', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique03/:niveau', {niveau:'@niveau'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique04', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique04/:niveau', {niveau:'@niveau'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique05Choix', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique05choix/:niveau', {niveau:'@niveau'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique05Cible', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique05cible/:niveau', {niveau:'@niveau'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);


orthotabServices.factory('Technique08Choix', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique08choix/:niveau', {niveau:'@niveau'}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique08Cible', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique08cible/:niveau', {niveau:'@niveau'}, {
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


orthotabServices.factory('ActivityService', [ '$resource', function($resource) {
	return $resource('/orthotab/api/activity', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
	})
} ]);
