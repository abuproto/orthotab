'use strict';

/* Controllers */

var orthotabControllers = angular
		.module('orthotabControllers', [ 'ngCookies' ]);

orthotabControllers.controller('CouleursCtrl', [ '$rootScope', '$scope',
		'Couleurs', function($rootScope, $scope, Couleurs) {

			$scope.couleurs = Couleurs.query({}, {
				'nbCouleurs' : $scope.nivdifficulte
			});

			$scope.enregistreCouleur = function(couleur, $event, ind) {
				if (couleur.active) {
					couleur.cssClass = "boutonCouleurActif";
					$rootScope.messageNiveau01 = "";
					$rootScope.couleurCourant = couleur;
				}
			}

		} ]);

orthotabControllers
		.controller(
				'Niveau01Ctrl',
				[
						'$rootScope',
						'$scope',
						'Niveau01',
						'UserNiveauService',
						'$cookieStore',
						function($rootScope, $scope, Niveau01,
								UserNiveauService, $cookieStore) {

							$scope.cases = Niveau01.query({}, {
								'nbCombi' : $scope.nivdifficulte
							});

							$scope.nbCombiTrouve = 0;
							$rootScope.niveauFini = false;

							$scope.enregistreCase = function(caseCombi, $event,
									ind) {
								if (caseCombi.active) {
									if ($rootScope.couleurCourant == null) {
										$rootScope.messageNiveau01 = "Il faut d'abord selectionner une case de couleur";
									} else if ($rootScope.caseCombiFirst == null) {
										caseCombi.cssClass = "boutonCaseActif";
										caseCombi.backgrdStyle = $rootScope.couleurCourant.code;
										$rootScope.caseCombiFirst = caseCombi;
										$rootScope.messageNiveau01 = "";
									} else {
										var typeCaseFirst = $rootScope.caseCombiFirst.type;
										var typeCaseSecond = caseCombi.type;
										if ($rootScope.caseCombiFirst.valeur == caseCombi.valeur) {
											caseCombi.cssClass = "boutonCaseActif";
											caseCombi.backgrdStyle = $rootScope.couleurCourant.code;
											var couleurCourant = $rootScope.couleurCourant;
											couleurCourant.active = false;
											var caseFisrt = $rootScope.caseCombiFirst;
											caseFisrt.active = false;
											caseCombi.active = false;

											$rootScope.couleurCourant = null;
											$rootScope.caseCombiFirst = null;

											$scope.nbCombiTrouve = $scope.nbCombiTrouve + 1;
											if ($scope.nbCombiTrouve == $scope.nivdifficulte) {
												// mise à jour niveau
												// utilisateur
												var cookieOrthoTab = $cookieStore
														.get('orthotab');
												UserNiveauService
														.majniveau(
																{},
																{
																	'userid' : cookieOrthoTab.id,
																	'niveau' : 1 + $scope.niveauid
																});
												// affichage message
												$rootScope.messageNiveau01 = "Bravo, tu as reussi ce niveau !";
												$rootScope.niveauFini = true;
											}
										}
									}
								}
							}
						} ]);

orthotabControllers
		.controller(
				'AccueilCtrl',
				[
						'$rootScope',
						'$scope',
						'Accueil',
						'$window',
						'$cookieStore',
						function($rootScope, $scope, Accueil, $window, $cookieStore) {
							var cookieOrthoTab = $cookieStore.get('orthotab');

							$scope.etapes = Accueil.query({}, {
								'nivcourant' : cookieOrthoTab.id
							});

							$scope.goToNiveau = function($event, niveau) {
								
								if (niveau == 1) {
									$window.location.href = "niveau1temp.htm";
								} else if (niveau == 2) {
									$window.location.href = "niveau1.htm";
								} else {
									$window
											.alert("Ce niveau sera disponible prochainement.");
								}
							}
						} ]);

orthotabControllers.controller('AvancementCtrl', [ '$rootScope', '$scope',
		'$cookieStore', function($rootScope, $scope, $cookieStore) {
			if ($rootScope.isLogged) {
				var cookieOrthoTab = $cookieStore.get('orthotab');
				var nivcourant = cookieOrthoTab.nivcourant;
				var longueurbarre = 200;
				var nivtotal = 3;
				
				// message
				var messageavancement = '';
				var nivrestant = nivtotal - nivcourant;
				messageavancement = "Tu as r&eacute;ussi ";
				messageavancement = messageavancement + nivcourant;
				messageavancement = messageavancement + " exercice";
				if(nivcourant > 1){
					messageavancement = messageavancement + "s";
				}
				messageavancement = messageavancement + ". Il en reste ";
				messageavancement = messageavancement + nivrestant;
				messageavancement = messageavancement + ".";
				
				$rootScope.messageavancement = messageavancement;
				// barre progression
				var lfait = (longueurbarre * nivcourant) / nivtotal;
				$rootScope.longueurfait = lfait;
				$rootScope.longueurbarre = longueurbarre;
			}
		} ]);

orthotabControllers
		.controller(
				'LoginCtrl',
				[
						'$rootScope',
						'$scope',
						'UserAuthService',
						'$cookieStore',
						'$http',
						'$window',
						'$timeout',
						'localStorageService',
						'UserTokenService',
						'ActivityService',
						function($rootScope, $scope, UserAuthService,
								$cookieStore, $http, $window, $timeout,
								localStorageService, UserTokenService, ActivityService) {
							var cookieOrthoTab = $cookieStore.get('orthotab');
							
							$scope.infosClient = "H" + $window.innerHeight + " W" + $window.innerWidth;
							$scope.ua = $window.navigator.userAgent;
							
							if (cookieOrthoTab != null) {
								// a completer avec verification User
								$rootScope.isLogged = true;
								$scope.utilisateur = cookieOrthoTab;
								if($scope.utilisateur.role=='ADMIN'){
									$rootScope.isAdmin = true;
								}
							} else {
								var tokenls = localStorageService.get('usertoken');
								if(tokenls!=null){
								UserTokenService
								.findByToken(
										{},
										{
											'token' : tokenls
										},
										function(userByToken) {
											if(angular.isUndefined(userByToken.nom)){
												$rootScope.isLogged = false;
											}else{
												$rootScope.isLogged = true;
												$scope.message = '';
												$scope.utilisateur = userByToken;
												if($scope.utilisateur.role=='ADMIN'){
													$rootScope.isAdmin = true;
												}
												$cookieStore.put(
														'orthotab',
														userByToken);
																								
												var activity = {'type':'LOGIN','dateActivite':(new Date().getTime()) ,'details': $scope.infosClient + ' / ' + $scope.ua,'idUser':$scope.utilisateur.id};
												ActivityService.create(activity);
											}
										});
								}
								
								$rootScope.isLogged = false;
								$scope.utilisateur = '';
							}
							$scope.message = '';

							// depart
							$scope.depart = function() {
								//$window.location.href = "accueil.htm";
								$window.alert("En travaux !");
							};
							
							// didacticiel
							$scope.didactHome = function() {
								$window.location.href = "../didact/didact0.jsp";
							};

							$scope.accesExercices= function() {
								$window.location.href = "../admin/exercices.jsp";
							};
							
							// changerUtilisateur
							$scope.changerUtilisateur = function() {
								var cookieOrthoTab = $cookieStore
										.get('orthotab');
								if (cookieOrthoTab != null) {
									$cookieStore.remove('orthotab');
									localStorageService.remove('usertoken');
								}
								$window.location.href = "../main/index.jsp";
							};

							// submit
							$scope.submit = function() {
								UserAuthService
										.authenticate(
												{},
												{
													'login' : $scope.user.login,
													'passw' : $scope.user.password
												},
												function(userConnecte) {

													if (angular
															.isUndefined(userConnecte.nom)) {
														$rootScope.isLogged = false;
														$scope.message = 'Identifiant ou mot de passe incorrect';
													} else {
														$rootScope.isLogged = true;
														$scope.message = '';
														$scope.utilisateur = userConnecte;
														if($scope.utilisateur.role=='ADMIN'){
															$rootScope.isAdmin = true;
														}
														$cookieStore.put(
																'orthotab',
																userConnecte);
														localStorageService.add('usertoken',userConnecte.token);
														
														var activity = {'type':'LOGIN','dateActivite':(new Date().getTime()) ,'details': $scope.infosClient + ' / ' + $scope.ua,'idUser':$scope.utilisateur.id};
														ActivityService.create(activity);
													}
												});
							};
						} ]);
