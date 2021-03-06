'use strict';

/* Services */

var orthotabServices = angular.module('orthotabServices', [ 'ngResource' ]);

orthotabServices.factory('Couleurs', [ '$resource', function($resource) {
	return $resource('/orthotab/api/couleurs/:nbCouleurs', {
		nbCouleurs : '@nbCouleurs'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('CouleursExercice', [ '$resource',
		function($resource) {
			return $resource('/orthotab/api/couleursExercice/:niveau', {
				niveau : '@niveau'
			}, {
				query : {
					method : 'GET',
					isArray : true
				}
			});
		} ]);

orthotabServices.factory('Commun01', [ '$resource', function($resource) {
	return $resource('/orthotab/api/pathinfos/:nb', {
		nb : '@nb'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique01', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique01/:niveau', {
		niveau : '@niveau'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique02', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique02/:niveau/:pos', {
		niveau : '@niveau',
		pos : '@pos'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique03', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique03/:niveau', {
		niveau : '@niveau'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique04', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique04/:niveau', {
		niveau : '@niveau'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique05Choix', [ '$resource',
		function($resource) {
			return $resource('/orthotab/api/technique05choix/:niveau', {
				niveau : '@niveau'
			}, {
				query : {
					method : 'GET',
					isArray : true
				}
			});
		} ]);

orthotabServices.factory('Technique05Cible', [ '$resource',
		function($resource) {
			return $resource('/orthotab/api/technique05cible/:niveau', {
				niveau : '@niveau'
			}, {
				query : {
					method : 'GET',
					isArray : true
				}
			});
		} ]);

orthotabServices.factory('Technique06', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique06/:niveau', {
		niveau : '@niveau'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique07', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique07/:niveau', {
		niveau : '@niveau'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique08', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique08/:niveau', {
		niveau : '@niveau'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Technique09', [ '$resource', function($resource) {
	return $resource('/orthotab/api/technique09/:niveau', {
		niveau : '@niveau'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Didact01', [ '$resource', function($resource) {
	return $resource('/orthotab/api/didact01/:nbCombi', {
		nbCombi : '@nbCombi'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Didact02', [ '$resource', function($resource) {
	return $resource('/orthotab/api/didact02/:nbCombi/:pos', {
		nbCombi : '@nbCombi',
		pos : '@pos'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('Didact04', [ '$resource', function($resource) {
	return $resource('/orthotab/api/didact04/:nbCombi', {
		nbCombi : '@nbCombi'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('AccueilEtapes', [ '$resource', function($resource) {
	return $resource('/orthotab/api/accueiletapes/:token', {
		token : '@token'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('AccueilInfos', [ '$resource', function($resource) {
	return $resource('/orthotab/api/accueilinfos/:token', {
		token : '@token'
	}, {
		query : {
			method : 'GET',
			isArray : false
		}
	});
} ]);

orthotabServices.factory('InfosExercice', [ '$resource', function($resource) {
	return $resource('/orthotab/api/infosexercice/:token/:groupe', {
		token : '@token',
		groupe : '@groupe'
	}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

orthotabServices.factory('UserNiveauService', [ '$resource',
		function($resource) {
			return $resource('/orthotab/api/majniveau/:userid/:niveau', {
				userid : '@userid',
				niveau : '@niveau'
			}, {
				majniveau : {
					method : 'POST'
				}
			});
		} ]);

orthotabServices.factory('UserTokenService', [ '$resource',
		function($resource) {
			return $resource('/orthotab/api/findByToken/:token', {
				token : '@token'
			}, {
				findByToken : {
					method : 'POST'
				}
			});
		} ]);

orthotabServices.factory('UserAuthService', [ '$resource', function($resource) {
	return $resource('/orthotab/api/authenticate2/:login/:passw', {
		login : '@login',
		passw : '@passw'
	}, {
		authenticate : {
			method : 'POST'
		}
	});
} ]);

orthotabServices.factory('ActivityService', [ '$resource', function($resource) {
	return $resource('/orthotab/api/activity', {}, {
		query : {
			method : 'GET',
			isArray : true
		},
		create : {
			method : 'POST'
		}
	})
} ]);

orthotabServices.factory('InfosActivityService', [ '$resource',
		function($resource) {
			return $resource('/orthotab/api/infosactivity', {}, {
				query : {
					method : 'GET',
					isArray : true
				},
				create : {
					method : 'POST'
				}
			})
		} ]);

orthotabServices.factory('InfosUtilisateurService', [ '$resource',
		function($resource) {
			return $resource('/orthotab/api/infosutilisateur', {}, {
				query : {
					method : 'GET',
					isArray : true
				},
				create : {
					method : 'POST'
				}
			})
		} ]);


orthotabServices.factory('ParametreService', function($rootScope) {

	var parametreMgr = {
		idUser : null,
		addIdUser : function(id) {
			this.idUser = id;
			$rootScope.$broadcast("idUserAdded");
			console.log("addIdUser : " + this.idUser);
		}
	};
	return parametreMgr;
});


orthotabServices.factory('ParametreMajService', [ '$resource',
		function($resource) {
			return $resource('/orthotab/api/majparametre', {}, {
				update : {
					method : 'POST'
				}
			});
		} ]);