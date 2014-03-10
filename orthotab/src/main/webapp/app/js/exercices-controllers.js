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
		'CouleursExercice', function($rootScope, $scope, CouleursExercice) {

			$scope.couleurs = CouleursExercice.query({}, {
				'niveau' : $scope.niveau
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
						'niveau' : $scope.niveau
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
		'Technique02Ctrl',
		[
				'$rootScope',
				'$scope',
				'Technique02',
				function($rootScope, $scope, Technique02) {

					$rootScope.consigne = "Le singe farceur a tout mélangé. Aide moi à relier l'opération et le résultat qui vont " +
					"ensemble. Clique sur l'opération et le résultat pour les relier.";
					
					$scope.casesg = Technique02.query({}, {
						'niveau' : $scope.niveau,
						'pos' : 'G'
					});

					$scope.casesd = Technique02.query({}, {
						'niveau' : $scope.niveau,
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
					}, {
						"loc" : "M0,0 L0,0",
						"cssClass" : "masque"
					} ];

					$scope.nbCombi = 5;
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
								if ($scope.nbCombiTrouve == $scope.nbCombi) {
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
		'Technique03Ctrl',
		[
				'$rootScope',
				'$scope',
				'$timeout',
				'Technique03',
				function($rootScope, $scope, $timeout, Technique03) {

					$rootScope.consigne = "Les opérations vont apparaître quelques secondes. Retiens bien le calcul. Tu devras cliquer sur le résultat correct qui va apparaître après.";
					
					$scope.casesflash = Technique03.query({}, {
						'niveau' : $scope.niveau
					});
					
					$scope.tempsEcoule = false;
					$scope.debut = false;
					
					var idx=0;
					var nbIt = $scope.casesflash.length;
					

					var cacheOperation = function() {
						$scope.tempsEcoule = true;
					}
					
					
					$scope.debut = false;

					$scope.commencer = function(){
						$scope.caseCourant = $scope.casesflash[idx];
						$scope.debut=true;
						$timeout(cacheOperation, 5000);
					};
					
					$scope.valider = function(caseflash) {
						if (caseflash.valeur == $scope.caseCourant.valeur) {
							caseflash.cssClass = "boutonCase groupe-case-correct";
							idx++;
							if(idx<nbIt){
								$scope.caseCourant = $scope.casesflash[idx];
								$scope.tempsEcoule = false;
								$timeout(cacheOperation, 5000);
							}else if(idx==nbIt){
								$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
								$rootScope.niveauFini = true;
							}
							
						}else{
							caseflash.cssClass = "boutonCase groupe-case-incorrect";
						}
					};

				} ]);
