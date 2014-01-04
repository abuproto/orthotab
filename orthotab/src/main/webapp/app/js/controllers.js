'use strict';

/* Controllers */

var orthotabControllers = angular.module('orthotabControllers', []);

  orthotabControllers.controller('CouleursCtrl', ['$rootScope','$scope', 'Couleurs',
  function($rootScope, $scope, Couleurs) {	  
	
    $scope.couleurs = Couleurs.query();
        
    $scope.enregistreCouleur = function (couleur, $event, ind) {
    	if(couleur.active){
    		couleur.cssClass = "boutonCouleurActif";
			$rootScope.messageNiveau01 = "";
			$rootScope.couleurCourant = couleur;
    	}
	}
    
  }]);
  
  orthotabControllers.controller('Niveau01Ctrl', ['$rootScope','$scope', 'Niveau01',
  function($rootScope, $scope, Niveau01) {

	  $scope.cases = Niveau01.query();
                                                    
	    $scope.enregistreCase = function (caseCombi, $event, ind) {
	    	if(caseCombi.active){
		    	if($rootScope.couleurCourant==null){
		    		$rootScope.messageNiveau01 = "Il faut d'abord selectionner une case de couleur";
		    	}else if($rootScope.caseCombiFirst==null){
		    		caseCombi.cssClass = "boutonCaseActif";
		    		caseCombi.backgrdStyle = $rootScope.couleurCourant.code;
		    		$rootScope.caseCombiFirst = caseCombi;
		    		$rootScope.messageNiveau01 = "";
		    	}else{
		    		var typeCaseFirst = $rootScope.caseCombiFirst.type;
		    		var typeCaseSecond = caseCombi.type;
		    		if($rootScope.caseCombiFirst.valeur == caseCombi.valeur){
			    		caseCombi.cssClass = "boutonCaseActif";
			    		caseCombi.backgrdStyle = $rootScope.couleurCourant.code;
			    		var couleurCourant = $rootScope.couleurCourant;
			    		couleurCourant.active = false;
			    		var caseFisrt = $rootScope.caseCombiFirst;
			    		caseFisrt.active = false;
			    		caseCombi.active = false;
			    		
			    		$rootScope.couleurCourant = null;
			    		$rootScope.caseCombiFirst = null;
		    		}
		    	}
	    	}
		}                       
  }]);
