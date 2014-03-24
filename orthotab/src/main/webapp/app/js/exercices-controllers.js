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
				if (exercice > 0) {
					ex = "e" + exercice;
				}
				$window.location.href = "../exercices/s" + semaine + "j" + jour
						+ ex + ".jsp";
			};

			// home
			$scope.home = function() {
				$window.location.href = "../main/index.jsp";
			};

			$scope.menu = function() {
				$window.location.href = "../exercices/" + $scope.groupe
						+ ".jsp";
			};
		} ]);

orthotabExercicesControllers.controller('CouleursCtrl', [ '$rootScope',
		'$scope', 'CouleursExercice',
		function($rootScope, $scope, CouleursExercice) {

			$scope.couleurs = CouleursExercice.query({}, {
				'niveau' : $scope.niveau
			});

			$scope.enregistreCouleur = function(couleur, $event, ind) {
				if (couleur.active) {
					couleur.cssClass = "boutonCouleurActif";
					$rootScope.messageNiveau = "";
					if ($rootScope.couleurCourant != null) {
						$rootScope.couleurCourant.cssClass = "boutonCouleur";
						if ($rootScope.caseCombiFirst != null) {
							$rootScope.caseCombiFirst.code = "#B5B276";
							$rootScope.caseCombiFirst = null;
						}
					}
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
							if ($scope.optIntrus) {
								$rootScope.consigne = $rootScope.consigne
										+ " Attention : il y a des intrus qui ne vont avec rien. Tu ne dois pas les colorier.";
							}

							$scope.cases = Technique01.query({}, {
								'niveau' : $scope.niveau
							});
							$scope.nbEchec = 0;
							$scope.nbCombiTrouve = 0;
							$rootScope.niveauFini = false;

							$scope.enregistreCase = function(caseCombi, $event,
									ind) {
								$rootScope.messageNiveau = "";
								if (caseCombi.active) {
									if ($rootScope.couleurCourant == null) {
										$rootScope.messageNiveau = "Il faut d'abord selectionner une case de couleur";
									} else if (caseCombi.type == "INTRUS") {
										$rootScope.messageNiveau = "C'est un intrus, il ne faut pas le colorier";
										$scope.nbEchec++;
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
											if ($scope.nbCombiTrouve == $scope.nbocc) {
												// affichage message
												$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
												$rootScope.niveauFini = true;
											}
										} else {
											$scope.nbEchec++;
											$rootScope.messageNiveau = "Ce n'est pas la bonne case !";
										}
									}
								}
							}
						} ]);

orthotabExercicesControllers
		.controller(
				'Technique02Ctrl',
				[
						'$rootScope',
						'$scope',
						'Technique02',
						'Commun01',
						function($rootScope, $scope, Technique02, Commun01) {

							$rootScope.consigne = "Le singe farceur a tout mélangé. Aide moi à relier l'opération et le résultat qui vont "
									+ "ensemble. Clique sur l'opération et le résultat pour les relier.";
							if ($scope.optIntrus) {
								$rootScope.consigne = $rootScope.consigne
										+ " Attention : il y a des intrus. Tu ne dois pas les relier.";
							}

							$scope.casesg = Technique02.query({}, {
								'niveau' : $scope.niveau,
								'pos' : 'G'
							});

							$scope.casesd = Technique02.query({}, {
								'niveau' : $scope.niveau,
								'pos' : 'D'
							});

							$scope.pathInfos = Commun01.query({}, {
								'nb' : $scope.nbocc
							});

							$scope.nbCombi = $scope.nbocc;
							$scope.nbCombiTrouve = 0;
							$rootScope.niveauFini = false;
							var cptPath = 0;
							$scope.caseGCourant = null;
							$scope.caseDCourant = null;
							$scope.nbEchec = 0;

							$scope.enregistreCaseG = function(caseCombi,
									$event, ind) {
								$rootScope.messageNiveau = "";
								if (caseCombi.active) {
									if (!verifieIntrus(caseCombi)) {
										$scope.caseGCourant = caseCombi;
										caseCombi.backgrdStyle = "yellow";
										verifieEtTrace();
									}
								}
							}

							$scope.enregistreCaseD = function(caseCombi,
									$event, ind) {
								$rootScope.messageNiveau = "";
								if (caseCombi.active) {
									if (!verifieIntrus(caseCombi)) {
										$scope.caseDCourant = caseCombi;
										caseCombi.backgrdStyle = "yellow";
										verifieEtTrace();
									}
								}
							}

							var verifieIntrus = function(caseCombi) {
								if (caseCombi.type == "INTRUS") {
									$rootScope.messageNiveau = "C'est un intrus, il ne faut pas le colorier";
									$scope.nbEchec++;
									caseCombi.backgrdStyle = "red";
									caseCombi.active = false;
									return true;
								} else {
									return false;
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
										$scope.nbEchec++;
									}
								}
							}

						} ]);

orthotabExercicesControllers
		.controller(
				'Technique03Ctrl',
				[
						'$rootScope',
						'$scope',
						'$timeout',
						'Technique03',
						function($rootScope, $scope, $timeout, Technique03) {

							if ($scope.optSaisie) {
								$rootScope.consigne = "Les opérations vont apparaître quelques secondes. Retiens bien le calcul. Tu devras saisir le résultat correct dans la case qui va apparaître après.";
							} else if ($scope.optDouble){
								$rootScope.consigne = "Les opérations vont apparaître quelques secondes. Retiens bien le calcul. Tu devras cliquer sur le résultat correct qui va apparaître après.";
							} else if($scope.optSomme){
								$rootScope.consigne = "Un chiffre va apparaître quelques secondes. Retiens-le bien ! tu devras cliquer sur le chiffre qui complète la dizaine. " +
										"Exemple : si tu vois le chiffre 1, tu devras cliquer sur le 9 parce que 1+9 = 10 ! à toi !";
							}

							$scope.casesflash = Technique03.query({}, {
								'niveau' : $scope.niveau
							});

							$scope.tempsEcoule = false;
							$scope.debut = false;
							$scope.nbEchec = 0;
							$scope.dspsuivant = false;

							var idx = 0;
							var delaims = $scope.delai * 1000;

							var cacheOperation = function() {
								$scope.tempsEcoule = true;
							}

							$scope.debut = false;

							$scope.commencer = function() {
								$scope.caseCourant = $scope.casesflash[idx];
								$scope.nbIt = $scope.casesflash.length;
								$scope.debut = true;
								$timeout(cacheOperation, delaims);
							};
							
							$scope.suivant = function() {
								$scope.caseCourant = $scope.casesflash[idx];
								$scope.message = "";
								$scope.result = "";
								$scope.tempsEcoule = false;
								$timeout(cacheOperation, delaims);
							};

							$scope.submit = function() {							
								if ($scope.result == $scope.caseCourant.valeur) {
									idx++;
									$scope.message = "Bon résultat !";
									if (idx < $scope.nbIt) {
										$scope.dspsuivant = true;
									} else if (idx == $scope.nbIt) {
										$scope.dspsuivant = false;
										$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
										$rootScope.niveauFini = true;
									}
								} else {
									$scope.dspsuivant = false;
									$scope.message = "Résultat incorrect";
									$scope.nbEchec++;
								}
							};

							$scope.valider = function(caseflash) {
								var verif = false;
								if($scope.optDouble){
									verif = (caseflash.valeur == $scope.caseCourant.valeur);
								}else if($scope.optSomme){
									verif = (caseflash.valeur + $scope.caseCourant.valeur == 10);
								}
								
								if (verif) {
									caseflash.cssClass = "boutonCase groupe-case-correct";
									idx++;
									if (idx < $scope.nbIt) {
										$scope.caseCourant = $scope.casesflash[idx];
										$scope.tempsEcoule = false;
										$timeout(cacheOperation, delaims);
									} else if (idx == $scope.nbIt) {
										$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
										$rootScope.niveauFini = true;
									}

								} else {
									caseflash.cssClass = "boutonCase groupe-case-incorrect";
								}
							};

						} ]);

orthotabExercicesControllers
		.controller(
				'Technique04Ctrl',
				[
						'$rootScope',
						'$scope',
						'Technique04',
						function($rootScope, $scope, Technique04) {

							$rootScope.consigne = "Les opérations et les résultats sont cachés ! retourne les deux par deux pour retrouver l'opération et le résultat qui vont ensemble.";

							$scope.cases = Technique04.query({}, {
								'niveau' : $scope.niveau
							});

							$scope.nbEchec = 0;
							$scope.actif = true;

							$scope.retourner = function() {
								if (nbCasesRecto == 2){
									if ($rootScope.caseCombiFirst != null) {
										$rootScope.caseCombiFirst.backgrdStyle = "#B5B276";
										$rootScope.caseCombiFirst.sens = "VERSO";
										$rootScope.caseCombiFirst.libelle = "?";
										$rootScope.caseCombiFirst = null;
									}
									if ($rootScope.caseCombiSecond != null) {
										$rootScope.caseCombiSecond.backgrdStyle = "#B5B276";
										$rootScope.caseCombiSecond.sens = "VERSO";
										$rootScope.caseCombiSecond.libelle = "?";
										$rootScope.caseCombiSecond = null;
									}
									$scope.actif = true;
									nbCasesRecto = 0;
								}
							}

							$scope.nbCombiTrouve = 0;
							$rootScope.niveauFini = false;
							var nbCasesRecto = 0;

							$scope.valider = function() {
								if (nbCasesRecto == 2
										&& $rootScope.caseCombiFirst != null
										&& $rootScope.caseCombiSecond != null) {
									var caseFisrt = $rootScope.caseCombiFirst;
									var caseSecond = $rootScope.caseCombiSecond;

									if (caseFisrt.valeur == caseSecond.valeur) {
										caseFisrt.active = false;
										caseSecond.active = false;
										caseFisrt.backgrdStyle = "green";
										caseSecond.backgrdStyle = "green";

										$rootScope.caseCombiFirst = null;
										$rootScope.caseCombiSecond = null;

										$scope.nbCombiTrouve = $scope.nbCombiTrouve + 1;
										if ($scope.nbCombiTrouve == $scope.nbocc) {
											$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
											$rootScope.niveauFini = true;
										}
										nbCasesRecto = 0;
									} else {
										caseFisrt.backgrdStyle = "red";
										caseSecond.backgrdStyle = "red";
										$scope.nbEchec++;
									}
								}

							}

							$scope.enregistreCase = function(caseCombi, $event,
									ind) {
								if ($scope.actif && caseCombi.active && nbCasesRecto < 2) {

									if (caseCombi.sens == "VERSO"
											&& nbCasesRecto < 2) {
										caseCombi.sens = "RECTO";
										caseCombi.backgrdStyle = "yellow";
										caseCombi.libelle = caseCombi.realLibelle;
										nbCasesRecto++;
									}

									if ($rootScope.caseCombiFirst == null) {
										$rootScope.caseCombiFirst = caseCombi;
									} else {
										$rootScope.caseCombiSecond = caseCombi;
									}
								}
							}

						} ]);

orthotabExercicesControllers
		.controller(
				'Technique05Ctrl',
				[
						'$rootScope',
						'$scope',
						'Technique05Choix',
						'Technique05Cible',
						function($rootScope, $scope, Technique05Choix,
								Technique05Cible) {

							$rootScope.consigne = "Avant ces dominos faisaient une belle ligne mais le singe a tout mélangé. Tu vois les pointillés? "
									+ "C’est à cet endroit que tu dois placer les dominos pour continuer la série. tu dois trouver la bonne paire pour que le total fasse 10.";

							$scope.dominoCible = Technique05Cible.query({}, {
								'niveau' : $scope.niveau
							});

							$scope.dominoChoix = Technique05Choix.query({}, {
								'niveau' : $scope.niveau
							});

							$scope.nbEchec = 0;
							$scope.idxDominoCible = 1;

							$scope.enregistreDomino = function(domino) {
								if(!$rootScope.niveauFini){
									$rootScope.messageNiveau = "";
									var dominoActif = $scope.dominoCible[$scope.idxDominoCible];
									var dominoCible = $scope.dominoCible[$scope.idxDominoCible - 1];
									var verif = false;
									if($scope.opt10){
										verif = (dominoCible.vald + domino.valg == 10);
									}else if($scope.optValeur){
										verif = (dominoCible.vald == domino.valg);
									}
	
									if (!$rootScope.niveauFini && verif) {
										dominoActif.libg = domino.libg;
										dominoActif.libd = domino.libd;
										dominoActif.valg = domino.valg;
										dominoActif.vald = domino.vald;
	
										dominoActif.cssClass = "domino-groupe domino-groupe-plein";
										dominoActif.actif = false;
										domino.cssClass = "domino-groupe-cache";
	
										if (($scope.idxDominoCible + 1) < $scope.dominoCible.length) {
											$scope.dominoCible[$scope.idxDominoCible + 1].actif = true;
											$scope.dominoCible[$scope.idxDominoCible + 1].cssClass = "domino-groupe domino-groupe-actif";
											$scope.idxDominoCible++;
										} else if (($scope.idxDominoCible + 1) == $scope.dominoCible.length) {
											$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
											$rootScope.niveauFini = true;
										}
									} else {
										$scope.nbEchec++;
										$rootScope.messageNiveau = "Ce n'est pas le bon domino !";
									}
								}
							};
						} ]);

orthotabExercicesControllers
		.controller(
				'Technique06Ctrl',
				[
						'$rootScope',
						'$scope',
						'Technique06',
						function($rootScope, $scope, Technique06) {
							if ($scope.optRapide) {
								$rootScope.consigne = "Voilà des boîtes à oeufs que je dois compléter. Sur le couvercle il est écrit combien on peut mettre d’oeufs au maximum. "
										+ "Et dans la boîte, il y a déjà quelques oeufs mais elle n’est pas complète ! Aide moi à compléter chaque boîte avec le bon tas d’oeufs, "
										+ "et tu dois aussi choisir le calcul qui te permet de calculer le plus vite";
							} else if ($scope.optCalcul) {
								$rootScope.consigne = "Voilà des boîtes d’oeufs que je dois compléter. Il y en a des petites et des grandes. "
										+ "Sur le couvercle il y a marqué combien on peut mettre d’oeufs au maximum. Et dans la boîte il y a déjà quelques oeufs mais elle n’est pas complète !"
										+ " Aide moi à compléter chaque boîte avec le bon tas d’oeufs";
							}

							$scope.boites = Technique06.query({}, {
								'niveau' : $scope.niveau
							});

							$scope.nbEchec = 0;
							var idx = 0;

							$scope.debut = false;
							$scope.dspsuivant = false;

							$scope.commencer = function() {
								$scope.boiteCourant = $scope.boites[idx];
								$scope.nbIt = $scope.boites.length;
								$scope.debut = true;
							};

							$rootScope.niveauFini = false;

							$scope.suivant = function() {
								idx++;
								$scope.boiteCourant = $scope.boites[idx];
								$scope.message = "";
							}

							$scope.enregistreCase = function(caseCombi) {
								if ($scope.optRapide) {
									if (caseCombi.type == "RES") {
										caseCombi.backgrdStyle = "green";
										$scope.boiteCourant.librestant = caseCombi.valeur;
										$scope.message = "Bon résultat !";
										$scope.dspsuivant = true;
										if (idx + 1 == $scope.nbIt) {
											$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
											$rootScope.niveauFini = true;
											$scope.dspsuivant = false;
										}
									} else {
										caseCombi.backgrdStyle = "red";
										$scope.nbEchec++;
										$scope.dspsuivant = false;
										$scope.message = "Résultat incorrect";
									}
								} else if ($scope.optCalcul && caseCombi.active) {
									if($scope.boiteCourant.valrestant==caseCombi.valeur){
										caseCombi.backgrdStyle = "green";
										caseCombi.active = false;
										$scope.boiteCourant.librestant = $scope.boiteCourant.valmax - $scope.boiteCourant.valacquis;
										$scope.message = "Bon résultat !";
										$scope.dspsuivant = true;
										if (idx + 1 == $scope.nbIt) {
											$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
											$rootScope.niveauFini = true;
											$scope.dspsuivant = false;
										}
									}else if($scope.boiteCourant.valrestant>caseCombi.valeur){
										caseCombi.backgrdStyle = "green";
										caseCombi.active = false;
										$scope.dspsuivant = false;
										$scope.boiteCourant.valrestant = $scope.boiteCourant.valrestant - caseCombi.valeur;
									}else{
										caseCombi.backgrdStyle = "red";
										$scope.nbEchec++;
										$scope.dspsuivant = false;
										$scope.message = "Résultat incorrect";
									}
								}
							}
						} ]);

orthotabExercicesControllers
.controller(
		'Technique07Ctrl',
		[
				'$rootScope',
				'$scope',
				'Technique07',
				function($rootScope, $scope, Technique07) {
					
					$rootScope.consigne = "La carte noire est le résultat d’une opération. Il faut que tu retrouves les bons chiffres de cette opération. " +
							"Pour cela choisis la bonne carte bleu et multiplie la avec la bonne carte rouge.";

					$scope.memorym = Technique07.query({}, {
						'niveau' : $scope.niveau
					});
	
					$scope.nbEchec = 0;
					var idx = 0;
	
					$scope.debut = false;
					$scope.dspsuivant = false;
	
					$scope.commencer = function() {
						$scope.memorymCourant = $scope.memorym[idx];
						$scope.nbIt = $scope.memorym.length;
						$scope.debut = true;
					};
	
					$rootScope.niveauFini = false;
	
					$scope.suivant = function() {
						idx++;
						$scope.memorymCourant = $scope.memorym[idx];
						$scope.message = "";
						$scope.dspsuivant = false;
						$scope.caseGcourant = null;
						$scope.caseDcourant = null;
					}
					
					$scope.enregistreCaseG = function(caseCombi,
							$event, ind) {
						if($scope.caseGcourant==null){
							$scope.caseGcourant = caseCombi;
							caseCombi.backgrdStyle = "yellow";
							verifieCalcul();
						}
					}

					$scope.enregistreCaseD = function(caseCombi,
							$event, ind) {
						if($scope.caseDcourant==null){
							$scope.caseDcourant = caseCombi;
							caseCombi.backgrdStyle = "yellow";
							verifieCalcul();
						}
					}
					var verifieCalcul = function() {
						$scope.message = "";
						if ($scope.caseGcourant != null
								&& $scope.caseDcourant != null) {
							var produit = parseInt($scope.caseGcourant.valeur)
									* parseInt($scope.caseDcourant.valeur);
							if (produit == parseInt($scope.memorymCourant.valeur)) {
								$scope.caseGcourant.backgrdStyle = "green";
								$scope.caseDcourant.backgrdStyle = "green";
								$scope.message = "Bon résultat !";
								$scope.dspsuivant = true;
								if (idx + 1 == $scope.nbIt) {
									$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
									$rootScope.niveauFini = true;
									$scope.dspsuivant = false;
								}
							} else {
								$scope.nbEchec++;
								$scope.caseGcourant.backgrdStyle = "red";
								$scope.caseGcourant = null;
								$scope.caseDcourant.backgrdStyle = "blue";
								$scope.caseDcourant = null;
								$scope.dspsuivant = false;
								$scope.message = "Résultat incorrect";
							}
						}
					}
				} ]);


orthotabExercicesControllers
		.controller(
				'Technique08Ctrl',
				[
						'$rootScope',
						'$scope',
						'Technique08',
						function($rootScope, $scope, Technique08) {

							if($scope.optValeur){
								$rootScope.consigne = "Ces opérations ont quelque chose qui ne va pas… il en manque un bout ! "
									+ "lequel de ces bouts peut aller selon toi? clique sur le chiffre qui complète l’opération";
							}else if($scope.optRapide){
								$rootScope.consigne = "";
							}
							
							$scope.calculATrou = Technique08.query({}, {
								'niveau' : $scope.niveau
							});

							$scope.nbEchec = 0;
							var idx = 0;

							$scope.debut = false;

							$scope.commencer = function() {
								$scope.calculATrouCourant = $scope.calculATrou[idx];
								$scope.nbIt = $scope.calculATrou.length;
								$scope.debut = true;
							};

							$rootScope.niveauFini = false;
							$scope.dspsuivant = false;

							$scope.suivant = function() {
								idx++;
								$scope.calculATrouCourant = $scope.calculATrou[idx];
								$scope.dspsuivant = false;
								$scope.message = "";
							}

							$scope.enregistreCase = function(caseCombi, $event,
									ind) {
								var idtrou = $scope.calculATrouCourant.idtrou;
								var verif = false;
								if($scope.optValeur){
									verif = (caseCombi.valeur == $scope.calculATrouCourant.listeCaseCible[idtrou].valeur);
								}else if($scope.optRapide){
									verif = (caseCombi.type == "RES");
								}
								
								if (verif) {
									caseCombi.backgrdStyle = "green";
									if($scope.optValeur){
										$scope.calculATrouCourant.listeCaseCible[idtrou].libelle = $scope.calculATrouCourant.listeCaseCible[idtrou].valeur;
										$scope.calculATrouCourant.listeCaseCible[idtrou].backgrdStyle = "green";
									}
									$scope.dspsuivant = true;
									$scope.message = "Bon choix !";
									if (idx + 1 == $scope.nbIt) {
										$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
										$rootScope.niveauFini = true;
										$scope.dspsuivant = false;
									}
								} else {
									caseCombi.backgrdStyle = "red";
									$scope.nbEchec++;
									$scope.dspsuivant = false;
									$scope.message = "Choix incorrect";
								}
							}
						} ]);

orthotabExercicesControllers
.controller(
		'Technique09Ctrl',
		[
				'$rootScope',
				'$scope',
				'Technique09',
				function($rootScope, $scope, Technique09) {
					
					$scope.rm = Technique09.query({}, {
						'niveau' : $scope.niveau
					});

					$scope.nbEchec = 0;
					var idx = 0;
					$scope.nbCaseCible = 0;
					
					$scope.debut = false;

					$scope.commencer = function() {
						$scope.rmCourant = $scope.rm[idx];
						$scope.nbIt = $scope.rm.length;
						$scope.debut = true;
						$scope.nbCaseCible=$scope.rmCourant.listeCaseCible.length;
					};

					$rootScope.niveauFini = false;
					$scope.dspsuivant = false;

					$scope.suivant = function() {
						idx++;
						$scope.rmCourant = $scope.rm[idx];
						$scope.dspsuivant = false;
						$scope.message = "";
						$scope.nbCaseCible=$scope.rmCourant.listeCaseCible.length;
					}
										
					$scope.enregistreCaseH = function(caseCombi, index) {
						if(caseCombi.active){
							$scope.message = "";
							$scope.caseHcourantidx = index;
							$scope.caseHcourant = caseCombi;
							$scope.caseHcourant.backgrdStyle = "yellow";
							verifieCase();
						}
					}

					$scope.enregistreCaseB = function(caseCombi) {
						if(caseCombi.active){
							$scope.message = "";
							$scope.caseBcourant = caseCombi;
							$scope.caseBcourant.backgrdStyle = "yellow";
							verifieCase();
						}
					}
					
					var verifieCase = function() {
						if ($scope.caseHcourant != null
								&& $scope.caseBcourant != null) {
							if ($scope.nbCaseCible > 0
									&& $scope.caseBcourant.exppos.indexOf($scope.caseHcourantidx)>=0) {
								$scope.caseHcourant.libelle = $scope.caseBcourant.libelle;
								$scope.caseBcourant.backgrdStyle = "green";
								$scope.caseHcourant.backgrdStyle = "green";
								$scope.caseHcourant.active = false;
								$scope.caseBcourant.active = false;
								$scope.nbCaseCible--;
								
								$scope.message = "Bon choix !";

								
							} else {
								$scope.nbEchec++;
								$scope.dspsuivant = false;
								$scope.message = "Choix incorrect";
								$scope.caseBcourant.backgrdStyle = "#B5B276";
								$scope.caseHcourant.backgrdStyle = "white";
							}

							if ($scope.nbCaseCible == 0) {								
								if (idx + 1 == $scope.nbIt) {
									$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
									$rootScope.niveauFini = true;
									$scope.dspsuivant = false;
								}else{
									$scope.dspsuivant = true;
								}
							}
							$scope.caseHcourant = null;
							$scope.caseBcourant = null;
						}
					}
				} ]);