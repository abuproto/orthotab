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

							var retourneCase = function() {
								$timeout(
										function() {
											$rootScope.caseCombiFirst.cssClass = "btn-case";
											$rootScope.caseCombiFirst.sens = "VERSO";
											$rootScope.caseCombiSecond.cssClass = "btn-case";
											$rootScope.caseCombiSecond.sens = "VERSO";
											$rootScope.caseCombiFirst = null;
											$rootScope.caseCombiSecond = null;
										}, 3000);
							}

							$scope.nbCombiTrouve = 0;
							$rootScope.niveauFini = false;
							var nbCasesRecto = 0;

							$scope.enregistreCase = function(caseCombi, $event,
									ind) {
								if (caseCombi.active) {

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
								"cssClass" : "domino-groupe-plein",
								"droppable" : "false",
								"actif" : false
							}, {
								"valg" : "?",
								"vald" : "?",
								"cssClass" : "domino-groupe-pointille",
								"droppable" : "true",
								"actif" : true
							}, {
								"valg" : "?",
								"vald" : "?",
								"cssClass" : "domino-groupe-pointille",
								"droppable" : "false",
								"actif" : false
							} ];

							$scope.dominoChoix = [ {
								"valg" : "6",
								"vald" : "2",
								"cssClass" : "domino-groupe-plein"
							}, {
								"valg" : "3",
								"vald" : "3",
								"cssClass" : "domino-groupe-plein"
							}, {
								"valg" : "8",
								"vald" : "5",
								"cssClass" : "domino-groupe-plein"
							}, {
								"valg" : "5",
								"vald" : "7",
								"cssClass" : "domino-groupe-plein"
							} ];

							$scope.idxDominoCible = 0;

							$scope.handleDragStart = function(e) {
								// e.dataTransfer.setData('Text', this.id);
								e.dataTransfer.setData('Text', this.id);
							};

							$scope.handleDragEnd = function(e) {
								return false;
							};

							$scope.handleDragEnter = function(e) {
							};

							$scope.handleDragLeave = function(e) {
								e.preventDefault(); // Necessary. Allows us to
													// drop.
								return false;
							};

							$scope.handleDrop = function(e) {
								e.preventDefault();
								e.stopPropagation();
								var data = e.dataTransfer.getData('Text');
								// $scope.sourceCourant = data;
								// console.log("data : " + data);
								// var idx =
								// $scope.sourceCourant.charAt($scope.sourceCourant.length-1);

								var dominoChoix = $scope.dominoChoix[data];
								var dominoCible = $scope.dominoCible[$scope.idxDominoCible];

								if ($scope.dominoCible[$scope.idxDominoCible + 1].actif) {
									var somme = parseInt(dominoChoix.valg)
											+ parseInt(dominoCible.vald);

									if (somme == 10) {
										$scope.idxDominoCible = $scope.idxDominoCible + 1;

										$scope.dominoCible[$scope.idxDominoCible].cssClass = "domino-groupe-plein";
										$scope.dominoCible[$scope.idxDominoCible].valg = dominoChoix.valg;
										$scope.dominoCible[$scope.idxDominoCible].vald = dominoChoix.vald;
										$scope.dominoCible[$scope.idxDominoCible].actif = false;
										dominoChoix.cssClass = "domino-groupe-cache";
										if (($scope.idxDominoCible + 1) < $scope.dominoCible.length) {
											$scope.dominoCible[$scope.idxDominoCible + 1].actif = true;
										}

										if (($scope.idxDominoCible + 1) == $scope.dominoCible.length) {
											$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
											$rootScope.niveauFini = true;
										}
										$scope.$apply();
									}
								}
							};

							$scope.handleDragOver = function(e) {
								e.preventDefault(); // Necessary. Allows us to
													// drop.
								e.dataTransfer.dropEffect = 'move'; // See the
																	// section
																	// on the
								// DataTransfer object.
								return false;
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
								"cssClass" : "btn-case-vide",
								"actif" : true
							}, {
								"cssClass" : "btn-case-vide",
								"actif" : true
							}, {
								"cssClass" : "btn-case-vide",
								"actif" : true
							}, {
								"cssClass" : "btn-case-vide",
								"actif" : true
							} ];
							$scope.nbCaseCible = 4;
							$scope.cssCible = "btn-case btn-case-etoile";

							$scope.caseSource = [ {
								"cssClass" : "btn-case btn-case-etoile",
								"valeur" : 2
							}, {
								"cssClass" : "btn-case btn-case-etoile",
								"valeur" : 1
							}, {
								"cssClass" : "btn-case btn-case-lune",
								"valeur" : 2
							}, {
								"cssClass" : "btn-case btn-case-etoile",
								"valeur" : 3
							} ];

							$scope.handleDragStart = function(e) {
								e.dataTransfer.setData('Text', this.id);
							};

							$scope.handleDragEnd = function(e) {
								return false;
							};

							$scope.handleDragEnter = function(e) {
								// this.style.opacity = '1.0';
							};

							$scope.handleDragLeave = function(e) {
								// this.style.opacity = '1.0';
								e.preventDefault(); // Necessary. Allows us to
													// drop.
								// e.dataTransfer.dropEffect = 'move'; // See
								// the section on the
								// DataTransfer object.
								return false;
							};

							$scope.handleDrop = function(e) {
								e.preventDefault();
								e.stopPropagation();
								var data = e.dataTransfer.getData('Text');
								$scope.sourceCourant = data;

								var idx = $scope.sourceCourant
										.charAt($scope.sourceCourant.length - 1);

								var caseSource = $scope.caseSource[idx];
								if (caseSource.cssClass == $scope.cssCible) {
									var nbValeur = caseSource.valeur;
									if (caseSource.valeur <= $scope.nbCaseCible) {
										for (var i = 0; i < $scope.caseCible.length; i++) {
											if ($scope.caseCible[i].actif
													&& nbValeur > 0) {
												$scope.caseCible[i].cssClass = caseSource.cssClass;
												$scope.caseCible[i].actif = false;
												nbValeur--;
												$scope.nbCaseCible--;
											}
										}
									}
								}

								if ($scope.nbCaseCible == 0) {
									$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
									$rootScope.niveauFini = true;
								}
								$scope.$apply();

							};

							$scope.handleDragOver = function(e) {
								e.preventDefault(); // Necessary. Allows us to
													// drop.
								e.dataTransfer.dropEffect = 'move'; // See the
																	// section
																	// on the
								// DataTransfer object.
								return false;
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
								"backgrdStyle" : "#B5B276"
							}, {
								"valeur" : "+",
								"backgrdStyle" : "#B5B276"
							}, {
								"valeur" : "-",
								"backgrdStyle" : "#B5B276"
							} ];

							$scope.enregistreCase = function(caseCombi, $event,
									ind) {
								caseCombi.backgrdStyle = "yellow";
								if (caseCombi.valeur == $scope.caseCible[0].realValeur) {
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
								"cssClass" : "trou-pointille",
								"backgrdStyle" : "white"
							}, {
								"valeur" : "",
								"realValeur" : "+",
								"actif" : true,
								"cssClass" : "trou-pointille",
								"backgrdStyle" : "white"
							}, {
								"valeur" : "",
								"realValeur" : "blue",
								"actif" : true,
								"cssClass" : "trou-pointille",
								"backgrdStyle" : "white"
							}, {
								"valeur" : "",
								"realValeur" : "=",
								"actif" : true,
								"cssClass" : "trou-pointille",
								"backgrdStyle" : "white"
							}, {
								"valeur" : "",
								"realValeur" : "green",
								"actif" : true,
								"cssClass" : "trou-pointille",
								"backgrdStyle" : "white"
							} ];

							$scope.caseChoix = [ {
								"valeur" : "",
								"backgrdStyle" : "green",
								"realValeur" : "green"
							}, {
								"valeur" : "=",
								"backgrdStyle" : "white",
								"realValeur" : "="
							}, {
								"valeur" : "+",
								"backgrdStyle" : "white",
								"realValeur" : "+"
							}, {
								"valeur" : "",
								"backgrdStyle" : "blue",
								"realValeur" : "blue"
							}, {
								"valeur" : "",
								"backgrdStyle" : "yellow",
								"realValeur" : "yellow"
							} ];

							$scope.nbCaseCible = 5;

							$scope.handleDragStart = function(e) {
								e.dataTransfer.setData('Text', this.id);
							};

							$scope.handleDragEnd = function(e) {
								return false;
							};

							$scope.handleDragEnter = function(e) {
								// this.style.opacity = '1.0';
							};

							$scope.handleDragLeave = function(e) {
								// this.style.opacity = '1.0';
								e.preventDefault(); // Necessary. Allows us to
													// drop.
								// e.dataTransfer.dropEffect = 'move'; // See
								// the section on the
								// DataTransfer object.
								return false;
							};

							$scope.handleDrop = function(e) {
								e.preventDefault();
								e.stopPropagation();
								var data = e.dataTransfer.getData('Text');

								var idxCible = this.id

								var caseChoix = $scope.caseChoix[data];
								var caseCible = $scope.caseCible[idxCible];
								if ($scope.nbCaseCible > 0
										&& caseChoix.realValeur == caseCible.realValeur) {

									caseCible.backgrdStyle = caseChoix.realValeur;
									caseCible.valeur = caseChoix.valeur;
									caseCible.actif = false;
									$scope.nbCaseCible--;
								} else {
									$scope.nbEchec++;
								}

								if ($scope.nbCaseCible == 0) {
									$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
									$rootScope.niveauFini = true;
								}
								$scope.$apply();

							};

							$scope.handleDragOver = function(e) {
								e.preventDefault(); // Necessary. Allows us to
													// drop.
								e.dataTransfer.dropEffect = 'move'; // See the
																	// section
																	// on the
								// DataTransfer object.
								return false;
							};

						} ]);
