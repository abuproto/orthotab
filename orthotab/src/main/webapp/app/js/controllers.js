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
						'AccueilEtapes',
						'AccueilInfos',
						'$window',
						'$cookies',
						'$filter',
						function($rootScope, $scope, AccueilEtapes,AccueilInfos, $window, $cookies,$filter) {
							
							var messageAccueilDefaut = "Clique sur le rond vert pour accéder aux exercices du jour";
							$scope.message = messageAccueilDefaut;
							
							var token = "";
							var cookieOrthoTab = $cookies.orthotabv2;
							if(cookieOrthoTab!=null){
								token = getTokenInCookie(cookieOrthoTab);
							}
							
							$scope.etapes = AccueilEtapes.query({}, {
								'token' : token
							});
							
							$scope.infosaccueil = AccueilInfos.query({}, {
								'token' : token
							});

							$scope.home = function() {
								$window.location.href = "../main/index.jsp";
							};
							
							$scope.goToNiveau = function($event, niveau) {
								
								if(niveau==$scope.infosaccueil.nivcourant){
									
									var tmsnext = $scope.infosaccueil.nbMillisNextJour;
																		
									var play = true;
									
									if(tmsnext>0){
										var tmsnow = new Date().getTime();
																				
										if(tmsnext-tmsnow>0){
											$scope.message = "Tu pourras faire le prochain niveau " + $filter('date')(tmsnext,"'à partir de ' HH:mm");
											play = false;
										}else{
											$scope.message = messageAccueilDefaut;
										}
									}
									
									if(play){
										var nosem = 0;
										if(niveau<=5){
											nosem=1;
										}else if(niveau>5 && niveau<=10){
											nosem=2;
										}else if(niveau>10 && niveau<=15){
											nosem=3;
										}else if(niveau>15 && niveau<=20){
											nosem=4;
										}else if(niveau>20){
											nosem=5;
										}
										
										var noj = 0;
										if(niveau<=5){
											noj = niveau;
										}else{
											noj = niveau -(nosem-1)*5;
										}
										
										var page = "s" + nosem + "j" + noj +".jsp";
										$window.location.href = "../exercices/" + page;
									}
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
						'$http',
						'$window',
						'$timeout',
						'localStorageService',
						'UserTokenService',
						'ActivityService',
						'$cookies',
						function($rootScope, $scope, UserAuthService,
								$http, $window, $timeout,
								localStorageService, UserTokenService, ActivityService,$cookies) {
							var cookieOrthoTab = $cookies.orthotabv2;
							
							$scope.infosClient = "H" + $window.innerHeight + " W" + $window.innerWidth;
							$scope.ua = $window.navigator.userAgent;
							
							if (cookieOrthoTab != null && cookieOrthoTab.length>0) {
								// a completer avec verification User
								$rootScope.isLogged = true;
								$scope.utilisateurPrenom = getPrenomInCookie(cookieOrthoTab);
								$scope.utilisateurRole = getRoleInCookie(cookieOrthoTab);
								if($scope.utilisateurRole=='ADMIN'){
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

												var valcookie = userByToken.token + "#" + userByToken.prenom + "#" + userByToken.role;
												document.cookie = "orthotabv2="+valcookie+";path=/orthotab/";
												
												var activity = {'type':'LOGIN','dateActivite':(new Date().getTime()) ,'details': $scope.infosClient + ' / ' + $scope.ua,'token':userByToken.token};
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
								$window.location.href = "../main/accueil.jsp";
								//$window.alert("En travaux !");
							};
							
							// didacticiel
							$scope.didactHome = function() {
								$window.location.href = "../didact/didact0.jsp";
							};

							// admin
							$scope.accesExercices= function() {
								$window.location.href = "../admin/exercices.jsp";
							};
							
							$scope.accesInfosActivity= function() {
								$window.location.href = "../admin/infosactivity.jsp";
							};
							
							$scope.accesInfosUtilisateur= function() {
								$window.location.href = "../admin/infosutilisateur.jsp";
							};
							
							// changerUtilisateur
							$scope.changerUtilisateur = function() {
								
								document.cookie = "orthotabv2=" + ";path=/orthotab/";
								localStorageService.remove('usertoken');
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
														$scope.utilisateurPrenom = userConnecte.prenom;
														if($scope.utilisateur.role=='ADMIN'){
															$rootScope.isAdmin = true;
														}
														
														var valcookie = userConnecte.token + "#" + userConnecte.prenom + "#" + userConnecte.role;
														document.cookie = "orthotabv2="+valcookie+";path=/orthotab/";
														localStorageService.add('usertoken',userConnecte.token);
														
														var activity = {'type':'LOGIN','dateActivite':(new Date().getTime()) ,'details': $scope.infosClient + ' / ' + $scope.ua,'token':userConnecte.token};
														ActivityService.create(activity);
													}
												});
							};
						} ]);

orthotabControllers.controller('InfosUtilisateurCtrl', [ '$window', '$scope',
                                         		'InfosUtilisateurService', function($window, $scope, InfosUtilisateurService) {

                                         			$scope.iu = InfosUtilisateurService.query({}, {
                                         			});

                        							$scope.home = function() {
                        								$window.location.href = "../main/index.jsp";
                        							};
                                         		} ]);

orthotabControllers.controller('InfosActivityCtrl', [ '$window', '$scope',
                                                  		'InfosActivityService', function($window, $scope, InfosActivityService) {

                                                  			$scope.ia = InfosActivityService.query({}, {
                                                  			});
                                                  			
                                                  			$scope.sems = ["", "1", "2", "3", "4", "5"];

                                 							$scope.home = function() {
                                 								$window.location.href = "../main/index.jsp";
                                 							};
                                                  		} ]);
