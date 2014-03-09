'use strict';

/* Controllers */

var orthotabExercicesControllers = angular.module(
		'orthotabExercicesControllers', []);

orthotabExercicesControllers.controller('ExercicesNavCtrl', [
		'$window',
		'$scope',
		function($window, $scope) {

			$scope.exercices = function(semaine, jour, exercice) {
				var ex = "";
				if(exercice > 0){
					ex = "e" + exercice;
				}
				$window.location.href = "../exercices/s" + semaine + "j" + jour + ex
						+ ".jsp";
			};

			// home
			$scope.home = function() {
				$window.location.href = "../main/index.jsp";
			};
			
			$scope.menu = function() {
				$window.location.href = "../exercices/" + $scope.groupe + ".jsp";
			};
		} ]);

orthotabExercicesControllers.controller('CouleursCtrl', [ '$rootScope', '$scope',
		'Couleurs', function($rootScope, $scope, Couleurs) {

			$scope.couleurs = Couleurs.query({}, {
				'nbCouleurs' : $scope.nivdifficulte
			});

			$scope.enregistreCouleur = function(couleur, $event, ind) {
				if (couleur.active) {
					couleur.cssClass = "boutonCouleurActif";
					$rootScope.messageNiveau = "";
					$rootScope.couleurCourant = couleur;
				}
			}
		} ]);

orthotabExercicesControllers
.controller(
		'Technique01Ctrl',
		[
				'$rootScope',
				'$scope',
				'Technique01',
				function($rootScope, $scope, Technique01) {

					$rootScope.consigne = "Les opérations et les résultats sont tout  mélangés ! Aide-moi à les remettre " 
						+ "ensemble grâce aux couleurs. Trempe ton doigt dans ton pot de peinture et touche les deux cases qui vont ensemble.";
					
					$scope.cases = Technique01.query({}, {
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