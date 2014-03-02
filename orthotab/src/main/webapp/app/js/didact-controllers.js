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

orthotabDidactControllers.controller('Didact0Ctrl', [ '$window', '$scope',
		function($window, $scope) {

			// home
			$scope.home = function() {
				$window.location.href = "../main/index.jsp";
			};
			
			$scope.didact = function(nbDidact) {
				$window.location.href = "../didact/didact0" + nbDidact +".jsp";
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
										$rootScope.messageNiveau01 = "Il faut d'abord selectionner une case de couleur";
									} else if ($rootScope.caseCombiFirst == null) {
										// caseCombi.cssClass =
										// "boutonCaseActif";
										caseCombi.backgrdStyle = $rootScope.couleurCourant.code;
										$rootScope.caseCombiFirst = caseCombi;
										$rootScope.messageNiveau01 = "";
									} else {
										var typeCaseFirst = $rootScope.caseCombiFirst.type;
										var typeCaseSecond = caseCombi.type;
										if ($rootScope.caseCombiFirst.valeur == caseCombi.valeur) {
											// caseCombi.cssClass =
											// "boutonCaseActif";
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
												// affichage message
												$rootScope.messageNiveau01 = "Bravo, tu as reussi ce niveau !";
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
							$scope.caseGcourant = null;

							$scope.enregistreCaseG = function(caseCombi,
									$event, ind) {
								if (caseCombi.active) {
									$scope.caseGcourant = caseCombi;
									caseCombi.backgrdStyle = "yellow";
								}
							}

							$scope.enregistreCaseD = function(caseCombi,
									$event, ind) {
								if (caseCombi.active) {
									if ($scope.caseGcourant == null) {
										$rootScope.messageNiveau = "Il faut d'abord selectionner une case dans la colonne de gauche";
									} else {
										if ($scope.caseGcourant.valeur == caseCombi.valeur) {
											var caseGCourant = $scope.caseGcourant;
											$scope.pathInfos[cptPath].loc = "M"
													+ caseGCourant.loc.x + ","
													+ caseGCourant.loc.y + " L"
													+ caseCombi.loc.x + ","
													+ caseCombi.loc.y;
											$scope.pathInfos[cptPath].cssClass = "correct";
											cptPath++;

											caseGCourant.active = false;
											caseCombi.active = false;
											$scope.caseGcourant = null;

											$scope.nbCombiTrouve = $scope.nbCombiTrouve + 1;
											if ($scope.nbCombiTrouve == $scope.nivdifficulte) {
												// affichage message
												$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
												$rootScope.niveauFini = true;
											}
										} else {
											// a completer par du style
											//caseCombi.backgrdStyle = "red";
											$scope.caseGcourant.backgrdStyle = "#B5B276";
											$scope.caseGcourant = null;
										}
									}
								}
							}

						} ]);

orthotabDidactControllers.controller('Didact06Ctrl', function($scope) {

	$scope.caseCible = [ {
		"cssClass" : "btn-case-vide"
	}, {
		"cssClass" : "btn-case-vide"
	}, {
		"cssClass" : "btn-case-vide"
	}, {
		"cssClass" : "btn-case-vide"
	} ];
	$scope.nbCaseCible = 4;
	$scope.cssCible = "btn-case btn-case-etoile";

	$scope.caseSource = [ {
		"cssClass" : "btn-case btn-case-etoile",
		"valeur" : 2
	} ];

	$scope.handleDragStart = function(e) {
		// this.style.opacity = '0.4';
		// e.dataTransfer.setData('text/plain', this.innerHTML);
		e.dataTransfer.setData('Text', this.id);
	};

	$scope.handleDragEnd = function(e) {
		// this.style.opacity = '1.0';
	};

	$scope.handleDragEnter = function(e) {
		// this.style.opacity = '1.0';
	};

	$scope.handleDragLeave = function(e) {
		// this.style.opacity = '1.0';
	};

	$scope.handleDrop = function(e) {
		e.preventDefault();
		e.stopPropagation();
		var data = e.dataTransfer.getData('Text');
		$scope.sourceCourant = data;

		/*
		 * $scope.$apply(function() { $scope.items.push(dataText); });
		 */

		console.log('Item has been dropped : ' + $scope.sourceCourant);
	};

	$scope.handleDragOver = function(e) {
		e.preventDefault(); // Necessary. Allows us to drop.
		e.dataTransfer.dropEffect = 'move'; // See the section on the
		// DataTransfer object.
		return false;
	};

});
