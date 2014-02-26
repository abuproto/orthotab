'use strict';

/* Controllers */

var orthotabControllers = angular.module('orthotabControllers', []);

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
										//caseCombi.cssClass = "boutonCaseActif";
										caseCombi.backgrdStyle = $rootScope.couleurCourant.code;
										$rootScope.caseCombiFirst = caseCombi;
										$rootScope.messageNiveau01 = "";
									} else {
										var typeCaseFirst = $rootScope.caseCombiFirst.type;
										var typeCaseSecond = caseCombi.type;
										if ($rootScope.caseCombiFirst.valeur == caseCombi.valeur) {
											//caseCombi.cssClass = "boutonCaseActif";
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

orthotabControllers.controller('Didact06Ctrl', function($scope) {
    $scope.handleDrop = function() {
        //alert('Item has been dropped');
    	console.log('Item has been dropped');
    }
});
