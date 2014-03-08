'use strict';

/* Controllers */

var orthotabDidactControllers = angular.module('orthotabDidactControllers', []);

orthotabDidactControllers.controller('CouleursCtrl', [ '$rootScope', '$scope',
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

orthotabDidactControllers.controller('DidactNavCtrl', [ '$window', '$scope',
		function($window, $scope) {

			// home
			$scope.home = function() {
				$window.location.href = "../main/index.jsp";
			};

			// recommencer
			$scope.recommencer = function() {
				$window.location.reload();
			};

			$scope.travaux = function() {
				$window.alert("En travaux !");
			};

			// didacticiel
			$scope.didactHome = function() {
				$window.location.href = "../didact/didact0.jsp";
			};

		} ]);

orthotabDidactControllers.controller('Didact0Ctrl',
		[
				'$window',
				'$scope',
				function($window, $scope) {

					// home
					$scope.home = function() {
						$window.location.href = "../main/index.jsp";
					};

					$scope.didact = function(nbDidact) {
						$window.location.href = "../didact/didact0" + nbDidact
								+ ".jsp";
					};

					$scope.travaux = function() {
						$window.alert("En travaux !");
					};

				} ]);

orthotabDidactControllers
		.controller(
				'Didact01Ctrl',
				[
						'$rootScope',
						'$scope',
						'Didact01',
						function($rootScope, $scope, Didact01) {

							$scope.cases = Didact01.query({}, {
								'nbCombi' : $scope.nivdifficulte
							});

							$scope.nbCombiTrouve = 0;
							$rootScope.niveauFini = false;

							$scope.enregistreCase = function(caseCombi, $event,
									ind) {
								if (caseCombi.active) {
									if ($rootScope.couleurCourant == null) {
										$rootScope.messageNiveau = "Il faut d'abord selectionner une case de couleur";
									} else if ($rootScope.caseCombiFirst == null) {
										caseCombi.backgrdStyle = $rootScope.couleurCourant.code;
										$rootScope.caseCombiFirst = caseCombi;
										$rootScope.messageNiveau = "";
									} else {
										var typeCaseFirst = $rootScope.caseCombiFirst.type;
										var typeCaseSecond = caseCombi.type;
										if ($rootScope.caseCombiFirst.valeur == caseCombi.valeur) {
											caseCombi.backgrdStyle = $rootScope.couleurCourant.code;
											var couleurCourant = $rootScope.couleurCourant;
											couleurCourant.active = false;
											couleurCourant.code = "#ffffff";
											var caseFisrt = $rootScope.caseCombiFirst;
											caseFisrt.active = false;
											caseCombi.active = false;

											$rootScope.couleurCourant = null;
											$rootScope.caseCombiFirst = null;

											$scope.nbCombiTrouve = $scope.nbCombiTrouve + 1;
											if ($scope.nbCombiTrouve == $scope.nivdifficulte) {
												// affichage message
												$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
												$rootScope.niveauFini = true;
											}
										}
									}
								}
							}

						} ]);

orthotabDidactControllers
		.controller(
				'Didact02Ctrl',
				[
						'$rootScope',
						'$scope',
						'Didact02',
						function($rootScope, $scope, Didact02) {

							$scope.casesg = Didact02.query({}, {
								'nbCombi' : $scope.nivdifficulte,
								'pos' : 'G'
							});

							$scope.casesd = Didact02.query({}, {
								'nbCombi' : $scope.nivdifficulte,
								'pos' : 'D'
							});

							$scope.pathInfos = [ {
								"loc" : "M0,0 L0,0",
								"cssClass" : "masque"
							}, {
								"loc" : "M0,0 L0,0",
								"cssClass" : "masque"
							}, {
								"loc" : "M0,0 L0,0",
								"cssClass" : "masque"
							}, {
								"loc" : "M0,0 L0,0",
								"cssClass" : "masque"
							} ];

							$scope.nbCombiTrouve = 0;
							$rootScope.niveauFini = false;
							var cptPath = 0;
							$scope.caseGCourant = null;
							$scope.caseDCourant = null;

							$scope.enregistreCaseG = function(caseCombi,
									$event, ind) {
								if (caseCombi.active) {
									$scope.caseGCourant = caseCombi;
									caseCombi.backgrdStyle = "yellow";
									verifieEtTrace();
								}
							}

							$scope.enregistreCaseD = function(caseCombi,
									$event, ind) {
								if (caseCombi.active) {
									$scope.caseDCourant = caseCombi;
									caseCombi.backgrdStyle = "yellow";
									verifieEtTrace();
								}
							}

							var verifieEtTrace = function() {
								if ($scope.caseGCourant != null
										&& $scope.caseDCourant != null) {
									var caseGCourant = $scope.caseGCourant;
									var caseDCourant = $scope.caseDCourant;

									if (caseGCourant.valeur == caseDCourant.valeur) {
										$scope.pathInfos[cptPath].loc = "M"
												+ caseGCourant.loc.x + ","
												+ caseGCourant.loc.y + " L"
												+ caseDCourant.loc.x + ","
												+ caseDCourant.loc.y;
										$scope.pathInfos[cptPath].cssClass = "correct";
										cptPath++;
										caseGCourant.backgrdStyle = "green";
										caseDCourant.backgrdStyle = "green";
										caseGCourant.active = false;
										caseDCourant.active = false;
										$scope.caseGCourant = null;
										$scope.caseDCourant = null;

										$scope.nbCombiTrouve = $scope.nbCombiTrouve + 1;
										if ($scope.nbCombiTrouve == $scope.nivdifficulte) {
											// affichage message
											$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
											$rootScope.niveauFini = true;
										}
									} else {
										// a completer par du style
										// caseCombi.backgrdStyle = "red";
										$scope.caseGCourant.backgrdStyle = "#B5B276";
										$scope.caseGCourant = null;
										$scope.caseDCourant.backgrdStyle = "#B5B276";
										$scope.caseDCourant = null;
									}
								}
							}

						} ]);

orthotabDidactControllers
		.controller(
				'Didact03Ctrl',
				[
						'$rootScope',
						'$scope',
						'$timeout',
						function($rootScope, $scope, $timeout) {

							$scope.tempsEcoule = false;
							$scope.nbFormes = 3;
							$scope.cssResultat = [ {
								"cssClass" : "groupe-case"
							}, {
								"cssClass" : "groupe-case"
							}, {
								"cssClass" : "groupe-case"
							} ];

							var cacheOperation = function() {
								$scope.tempsEcoule = true;
							}
							$timeout(cacheOperation, 5000);

							$scope.valider = function(nb) {
								if (nb == $scope.nbFormes) {
									$scope.cssResultat[nb - 1].cssClass = "groupe-case groupe-case-correct";
									$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
									$rootScope.niveauFini = true;
								}else{
									$scope.cssResultat[nb - 1].cssClass = "groupe-case groupe-case-incorrect";
								}
							};

						} ]);

orthotabDidactControllers
		.controller(
				'Didact04Ctrl',
				[
						'$rootScope',
						'$scope',
						'Didact04',
						'$timeout',
						function($rootScope, $scope, Didact04, $timeout) {

							$scope.cases = Didact04.query({}, {
								'nbCombi' : $scope.nivdifficulte
							});
							
							$scope.actif = true;

							var retourneCase = function() {
								$timeout(
										function() {
											$rootScope.caseCombiFirst.cssClass = "btn-case";
											$rootScope.caseCombiFirst.sens = "VERSO";
											$rootScope.caseCombiSecond.cssClass = "btn-case";
											$rootScope.caseCombiSecond.sens = "VERSO";
											$rootScope.caseCombiFirst = null;
											$rootScope.caseCombiSecond = null;
											$scope.actif = true;
										}, 2000);
							}

							$scope.nbCombiTrouve = 0;
							$rootScope.niveauFini = false;
							var nbCasesRecto = 0;

							$scope.enregistreCase = function(caseCombi, $event,
									ind) {
								if ($scope.actif && caseCombi.active) {

									if (caseCombi.sens == "VERSO"
											&& nbCasesRecto < 2) {
										caseCombi.sens = "RECTO";
										caseCombi.cssClass = caseCombi.realCssClass;
										nbCasesRecto++;
									}

									if ($rootScope.caseCombiFirst == null) {
										$rootScope.caseCombiFirst = caseCombi;
									} else {
										var caseFisrt = $rootScope.caseCombiFirst;
										$rootScope.caseCombiSecond = caseCombi;
										if ($rootScope.caseCombiFirst.valeur == caseCombi.valeur) {
											caseFisrt.active = false;
											caseCombi.active = false;

											$rootScope.caseCombiFirst = null;
											$rootScope.caseCombiSecond = null;

											$scope.nbCombiTrouve = $scope.nbCombiTrouve + 1;
											if ($scope.nbCombiTrouve == $scope.nivdifficulte) {
												// affichage message
												$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
												$rootScope.niveauFini = true;
											}
											nbCasesRecto = 0;
										} else {
											$scope.actif = false;
											retourneCase();
											nbCasesRecto = 0;
										}
									}
								}
							}

						} ]);

orthotabDidactControllers
		.controller(
				'Didact05Ctrl',
				[
						'$rootScope',
						'$scope',
						function($rootScope, $scope) {

							$scope.dominoCible = [ {
								"valg" : "3",
								"vald" : "4",
								"cssClass" : "domino-groupe domino-groupe-plein",
								"cssClassg" : "domino btn-case-fleche",
								"cssClassd" : "domino btn-case-etoile",
								"actif" : false
							}, {
								"valg" : "?",
								"vald" : "?",
								"cssClass" : "domino-groupe domino-groupe-pointille",
								"cssClassg" : "domino",
								"cssClassd" : "domino",
								"actif" : true
							}, {
								"valg" : "?",
								"vald" : "?",
								"cssClass" : "domino-groupe domino-groupe-pointille",
								"cssClassg" : "domino",
								"cssClassd" : "domino",
								"actif" : false
							} ];

							$scope.dominoChoix = [ {
								"valg" : "6",
								"vald" : "2",
								"cssClassg" : "domino btn-case-lune",
								"cssClassd" : "domino btn-case-etoile",
								"cssClass" : "domino-groupe domino-groupe-plein"
							}, {
								"valg" : "3",
								"vald" : "3",
								"cssClassg" : "domino btn-case-croix",
								"cssClassd" : "domino btn-case-rond",
								"cssClass" : "domino-groupe domino-groupe-plein"
							}, {
								"valg" : "8",
								"vald" : "5",
								"cssClassg" : "domino btn-case-etoile",
								"cssClassd" : "domino btn-case-croix",
								"cssClass" : "domino-groupe domino-groupe-plein"
							}, {
								"valg" : "5",
								"vald" : "7",
								"cssClassg" : "domino btn-case-rond",
								"cssClassd" : "domino btn-case-etoile",
								"cssClass" : "domino-groupe domino-groupe-plein"
							} ];

							$scope.idxDominoCible = 1;
							$scope.dominoCible[$scope.idxDominoCible].cssClass = "domino-groupe domino-groupe-actif";

							$scope.enregistreDomino = function(domino) {
								var dominoActif = $scope.dominoCible[$scope.idxDominoCible];
								var dominoCible = $scope.dominoCible[$scope.idxDominoCible-1];
								if(!$rootScope.niveauFini && dominoCible.cssClassd==domino.cssClassg){
									dominoActif.cssClassg = domino.cssClassg;
									dominoActif.cssClassd = domino.cssClassd;
									
									dominoActif.cssClass = "domino-groupe domino-groupe-plein";
									dominoActif.actif = false;
									domino.cssClass = "domino-groupe-cache";
									
									if (($scope.idxDominoCible + 1) < $scope.dominoCible.length) {
										$scope.dominoCible[$scope.idxDominoCible + 1].actif = true;
										$scope.dominoCible[$scope.idxDominoCible + 1].cssClass = "domino-groupe domino-groupe-actif";
										$scope.idxDominoCible++;
									}else if (($scope.idxDominoCible + 1) == $scope.dominoCible.length) {
										$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
										$rootScope.niveauFini = true;
									}
								}
							};
						} ]);

orthotabDidactControllers
		.controller(
				'Didact06Ctrl',
				[
						'$rootScope',
						'$scope',
						function($rootScope, $scope) {

							$scope.caseCible = [ {
								"nbTotal" : "20",
								"nbAcquis" : "17",
								"nbRestant" : "?"
							}];

							$scope.caseListeChoix = [ {
								"valeur" : 1,"cssClass":"emplacement-choix-groupe"
							}, {
								"valeur" : 3,"cssClass":"emplacement-choix-groupe"
							}, {
								"valeur" : 2,"cssClass":"emplacement-choix-groupe"
							} ];

							$scope.enregistreCase = function(caseChoix) {
								
								if(!$rootScope.niveauFini){
								
									var nbRestant = parseInt($scope.caseCible[0].nbTotal) - parseInt($scope.caseCible[0].nbAcquis);
								
									if(caseChoix.valeur==nbRestant){
										caseChoix.cssClass="emplacement-choix-groupe emplacement-choix-groupe-ok";
										$scope.caseCible[0].nbRestant=caseChoix.valeur;
										$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
										$rootScope.niveauFini = true;
									}else{
										caseChoix.cssClass="emplacement-choix-groupe emplacement-choix-groupe-ko";
									}
								}
								
							};
						} ]);

orthotabDidactControllers
		.controller(
				'Didact07Ctrl',
				[
						'$rootScope',
						'$scope',
						function($rootScope, $scope) {
							$scope.caseCible = [ {
								"valeur" : "25"
							} ];

							$scope.caseChoixG = [ {
								"valeur" : 5,
								"backgrdStyle" : "#B5B276","row":1
							}, {
								"valeur" : 3,
								"backgrdStyle" : "#B5B276","row":1
							}, {
								"valeur" : 4,
								"backgrdStyle" : "#B5B276","row":2
							}, {
								"valeur" : 8,
								"backgrdStyle" : "#B5B276","row":2
							} ];
							$scope.caseChoixD = [ {
								"valeur" : 9,
								"backgrdStyle" : "#B5B276","row":1
							}, {
								"valeur" : 5,
								"backgrdStyle" : "#B5B276","row":1
							}, {
								"valeur" : 2,
								"backgrdStyle" : "#B5B276","row":2
							}, {
								"valeur" : 4,
								"backgrdStyle" : "#B5B276","row":2
							} ];

							$scope.enregistreCaseG = function(caseCombi,
									$event, ind) {

								$scope.caseGcourant = caseCombi;
								caseCombi.backgrdStyle = "yellow";
								verifieCalcul();
							}

							$scope.enregistreCaseD = function(caseCombi,
									$event, ind) {

								$scope.caseDcourant = caseCombi;
								caseCombi.backgrdStyle = "yellow";
								verifieCalcul();
							}
							var verifieCalcul = function() {
								if ($scope.caseGcourant != null
										&& $scope.caseDcourant != null) {
									var produit = parseInt($scope.caseGcourant.valeur)
											* parseInt($scope.caseDcourant.valeur);
									if (produit == parseInt($scope.caseCible[0].valeur)) {
										$scope.caseGcourant.backgrdStyle = "green";
										$scope.caseDcourant.backgrdStyle = "green";
										$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
										$rootScope.niveauFini = true;
									} else {
										$scope.nbEchec++;
										$scope.caseGcourant.backgrdStyle = "#B5B276";
										$scope.caseGcourant = null;
										$scope.caseDcourant.backgrdStyle = "#B5B276";
										$scope.caseDcourant = null;
									}
								}
							}
						} ]);

orthotabDidactControllers
		.controller(
				'Didact08Ctrl',
				[
						'$rootScope',
						'$scope',
						function($rootScope, $scope) {
							$scope.caseCible = [ {
								"valeur" : "?",
								"realValeur" : "+"
							} ];

							$scope.caseChoix = [ {
								"valeur" : "x",
								"cssClass" : "carre trou-plein",
								"backgrdStyle" : "#B5B276"
							}, {
								"valeur" : "+",
								"cssClass" : "carre trou-plein",
								"backgrdStyle" : "#B5B276"
							}, {
								"valeur" : "-",
								"cssClass" : "carre trou-plein",
								"backgrdStyle" : "#B5B276"
							} ];

							$scope.enregistreCase = function(caseCombi, $event,
									ind) {
								caseCombi.backgrdStyle = "yellow";
								if (caseCombi.valeur == $scope.caseCible[0].realValeur) {
									caseCombi.backgrdStyle = "green";
									$scope.caseCible[0].valeur = $scope.caseCible[0].realValeur;
									$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
									$rootScope.niveauFini = true;
								} else {
									caseCombi.backgrdStyle = "red";
									$scope.nbEchec++;
								}
							}
						} ]);

orthotabDidactControllers
		.controller(
				'Didact09Ctrl',
				[
						'$rootScope',
						'$scope',
						function($rootScope, $scope) {
							$scope.caseCible = [ {
								"valeur" : "",
								"realValeur" : "yellow",
								"actif" : true,
								"cssClass" : "rond trou-pointille",
								"backgrdStyle" : "white"
							}, {
								"valeur" : "",
								"realValeur" : "+",
								"actif" : true,
								"cssClass" : "carre trou-pointille",
								"backgrdStyle" : "white"
							}, {
								"valeur" : "",
								"realValeur" : "blue",
								"actif" : true,
								"cssClass" : "rond trou-pointille",
								"backgrdStyle" : "white"
							}, {
								"valeur" : "",
								"realValeur" : "=",
								"actif" : true,
								"cssClass" : "carre trou-pointille",
								"backgrdStyle" : "white"
							}, {
								"valeur" : "",
								"realValeur" : "green",
								"actif" : true,
								"cssClass" : "rond trou-pointille",
								"backgrdStyle" : "white"
							} ];

							$scope.caseChoix = [ {
								"valeur" : "",
								"backgrdStyle" : "green",
								"cssClass" : "rond trou-plein",
								"realValeur" : "green"
							}, {
								"valeur" : "=",
								"backgrdStyle" : "white",
								"cssClass" : "carre trou-plein",
								"realValeur" : "="
							}, {
								"valeur" : "+",
								"backgrdStyle" : "white",
								"cssClass" : "carre trou-plein",
								"realValeur" : "+"
							}, {
								"valeur" : "",
								"backgrdStyle" : "blue",
								"cssClass" : "rond trou-plein",
								"realValeur" : "blue"
							}, {
								"valeur" : "",
								"backgrdStyle" : "yellow",
								"cssClass" : "rond trou-plein",
								"realValeur" : "yellow"
							} ];

							$scope.nbCaseCible = 5;

							
							$scope.enregistreCaseH = function(caseCombi) {

								$scope.caseHcourant = caseCombi;
								verifieCase();
							}

							$scope.enregistreCaseB = function(caseCombi) {

								$scope.caseBcourant = caseCombi;
								verifieCase();
							}
							
							var verifieCase = function() {
								if ($scope.caseHcourant != null
										&& $scope.caseBcourant != null) {
									if ($scope.nbCaseCible > 0
											&& $scope.caseHcourant.realValeur == $scope.caseBcourant.realValeur) {

										$scope.caseHcourant.backgrdStyle = $scope.caseBcourant.realValeur;
										$scope.caseHcourant.cssClass = $scope.caseBcourant.cssClass;
										$scope.caseHcourant.valeur = $scope.caseBcourant.valeur;
										$scope.caseHcourant.actif = false;
										$scope.nbCaseCible--;
									} else {
										$scope.nbEchec++;
									}

									if ($scope.nbCaseCible == 0) {
										$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
										$rootScope.niveauFini = true;
									}
								}
							}
						} ]);
