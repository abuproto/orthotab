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
					if($rootScope.couleurCourant !=null){
						$rootScope.couleurCourant.cssClass = "boutonCouleur";
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

					$rootScope.consigne = "Les op�rations et les r�sultats sont tout  m�lang�s ! Aide-moi � les remettre " 
						+ "ensemble gr�ce aux couleurs. Trempe ton doigt dans ton pot de peinture et touche les deux cases qui vont ensemble.";
					if($scope.optIntrus){
						$rootScope.consigne = $rootScope.consigne + " Attention : il y a des intrus qui ne vont avec rien. Tu ne dois pas les colorier.";
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
							}else if(caseCombi.type=="INTRUS"){
								$rootScope.messageNiveau = "C'est un intrus, il ne faut pas le colorier";
								$scope.nbEchec ++;
							}else if ($rootScope.caseCombiFirst == null) {
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
				'Commun01',
				function($rootScope, $scope, Technique02, Commun01) {

					$rootScope.consigne = "Le singe farceur a tout m�lang�. Aide moi � relier l'op�ration et le r�sultat qui vont " +
					"ensemble. Clique sur l'op�ration et le r�sultat pour les relier.";
					if($scope.optIntrus){
						$rootScope.consigne = $rootScope.consigne + " Attention : il y a des intrus. Tu ne dois pas les relier.";
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
						if (caseCombi.active) {
							if(!verifieIntrus(caseCombi)){
								$scope.caseGCourant = caseCombi;
								caseCombi.backgrdStyle = "yellow";
								verifieEtTrace();
							}
						}
					}

					$scope.enregistreCaseD = function(caseCombi,
							$event, ind) {
						if (caseCombi.active) {
							if(!verifieIntrus(caseCombi)){
								$scope.caseDCourant = caseCombi;
								caseCombi.backgrdStyle = "yellow";
								verifieEtTrace();
							}
						}
					}

					var verifieIntrus = function(caseCombi){
						if(caseCombi.type=="INTRUS"){
							$rootScope.messageNiveau = "C'est un intrus, il ne faut pas le colorier";
							$scope.nbEchec ++;
							caseCombi.backgrdStyle = "red";
							caseCombi.active = false;
							return true;
						}else{
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
								$scope.nbEchec ++;
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

					if($scope.optSaisie){
						$rootScope.consigne = "Les op�rations vont appara�tre quelques secondes. Retiens bien le calcul. Tu devras saisir le r�sultat correct dans la case qui va appara�tre apr�s.";
					}else{
						$rootScope.consigne = "Les op�rations vont appara�tre quelques secondes. Retiens bien le calcul. Tu devras cliquer sur le r�sultat correct qui va appara�tre apr�s.";
					}
					
					$scope.casesflash = Technique03.query({}, {
						'niveau' : $scope.niveau
					});
					
					$scope.tempsEcoule = false;
					$scope.debut = false;
					$scope.nbEchec = 0;
					
					var idx=0;

					var cacheOperation = function() {
						$scope.tempsEcoule = true;
					}
					
					
					$scope.debut = false;

					$scope.commencer = function(){
						$scope.caseCourant = $scope.casesflash[idx];
						$scope.nbIt = $scope.casesflash.length;
						$scope.debut=true;
						$timeout(cacheOperation, 5000);
					};
					
					$scope.effaceMessage=function(){
						$scope.message = "";
						$scope.result="";
					}
					
					
					$scope.submit = function() {
						if($scope.result==$scope.caseCourant.valeur){
							idx++;
							if(idx<$scope.nbIt){
								$scope.caseCourant = $scope.casesflash[idx];
								$scope.tempsEcoule = false;
								$timeout(cacheOperation, 5000);
							}else if(idx==$scope.nbIt){
								$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
								$rootScope.niveauFini = true;
							}
						}else{
							$scope.message = "R�sultat incorrect";
							$scope.nbEchec++;
						}
					};
					
					$scope.valider = function(caseflash) {
						if (caseflash.valeur == $scope.caseCourant.valeur) {
							caseflash.cssClass = "boutonCase groupe-case-correct";
							idx++;
							if(idx<$scope.nbIt){
								$scope.caseCourant = $scope.casesflash[idx];
								$scope.tempsEcoule = false;
								$timeout(cacheOperation, 5000);
							}else if(idx==$scope.nbIt){
								$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
								$rootScope.niveauFini = true;
							}
							
						}else{
							caseflash.cssClass = "boutonCase groupe-case-incorrect";
						}
					};

				} ]);

orthotabDidactControllers
.controller(
		'Technique04Ctrl',
		[
				'$rootScope',
				'$scope',
				'Technique04',
				'$timeout',
				function($rootScope, $scope, Technique04, $timeout) {

					$rootScope.consigne = "Les op�rations et les r�sultats sont cach�s ! retourne les deux par deux pour retrouver l'op�ration et le r�sultat qui vont ensemble.";
					
					
					$scope.cases = Technique04.query({}, {
						'niveau' : $scope.niveau
					});
					
					$scope.nbEchec = 0;
					$scope.actif = true;

					var retourneCase = function() {
						$timeout(
								function() {
									//$rootScope.caseCombiFirst.cssClass = "btn-case";
									$rootScope.caseCombiFirst.backgrdStyle = "#B5B276";
									$rootScope.caseCombiFirst.sens = "VERSO";
									$rootScope.caseCombiFirst.libelle = "";
									//$rootScope.caseCombiSecond.cssClass = "btn-case";
									$rootScope.caseCombiSecond.backgrdStyle = "#B5B276";
									$rootScope.caseCombiSecond.sens = "VERSO";
									$rootScope.caseCombiSecond.libelle = "";
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
								//caseCombi.cssClass = caseCombi.realCssClass;
								caseCombi.backgrdStyle = "yellow";
								caseCombi.libelle = caseCombi.realLibelle;
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
									caseFisrt.backgrdStyle = "green";
									caseCombi.backgrdStyle = "green";

									$rootScope.caseCombiFirst = null;
									$rootScope.caseCombiSecond = null;

									$scope.nbCombiTrouve = $scope.nbCombiTrouve + 1;
									if ($scope.nbCombiTrouve == $scope.nbocc) {
										// affichage message
										$rootScope.messageNiveau = "Bravo, tu as reussi ce niveau !";
										$rootScope.niveauFini = true;
									}
									nbCasesRecto = 0;
								} else {
									$scope.nbEchec ++;
									$scope.actif = false;
									retourneCase();
									nbCasesRecto = 0;
								}
							}
						}
					}

				} ]);
