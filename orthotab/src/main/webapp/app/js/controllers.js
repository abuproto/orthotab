'use strict';

/* Controllers */

var orthotabControllers = angular.module('orthotabControllers', []);

  orthotabControllers.controller('CouleursCtrl', ['$rootScope','$scope', 'Couleurs',
  function($rootScope, $scope, Couleurs) {	  
	var self = this;
	self.selectedIndex = -1;
	
    $scope.couleurs = Couleurs.query();
    
    $scope.getClass = function(ind){
        if( ind === self.selectedIndex ){
            return "boutonCouleurActif";
        } else{
            return "boutonCouleur";
        }
    }
    
    $scope.enregistreCouleur = function (couleur, $event, ind) {
		self.selectedIndex = ind;
		$rootScope.codeCouleurCourant = couleur.code;
		$rootScope.messageNiveau01 = "";
		console.log("codeCouleurCourant : " + $rootScope.codeCouleurCourant);
		}
    
  }]);
  
  orthotabControllers.controller('Niveau01Ctrl', ['$rootScope','$scope', 'Niveau01',
  function($rootScope, $scope, Niveau01) {
		var self = this;
		self.selectedIndex = -1;
	  $scope.cases = Niveau01.query();
                                                    
                                                    
	    $scope.getClass = function(ind){
	        if( ind === self.selectedIndex){
	            return "boutonCaseActif";
	        } else{
	            return "boutonCase";
	        }
	    }
	    
	    $scope.getBackgrdStyle = function(ind){
	        if( ind === self.selectedIndex && $rootScope.codeCouleurCourant!=null){
	            return $rootScope.codeCouleurCourant;
	        } else{
	        	return "#B5B276";
	        }
	    }
	    $scope.enregistreCase = function (caseCombi, $event, ind) {
			//console.log("debut");
	    	console.log("codeCouleurCourant : " + $rootScope.codeCouleurCourant);
	    	if($rootScope.codeCouleurCourant==null){
	    		$rootScope.messageNiveau01 = "Il faut d'abord selectionner une case de couleur";
	    	}else if($rootScope.caseCombiCourant==null){
	    		self.selectedIndex = ind;
	    		$rootScope.caseCombiCourant = caseCombi;
	    		$rootScope.messageNiveau01 = "";
	    	}else{
	    		var typeCaseFirst = $rootScope.caseCombiCourant.type;
	    		console.log("typeCaseFirst : " + typeCaseFirst);
	    		var typeCaseSecond = caseCombi.type;
	    		console.log("typeCaseSecond : " + typeCaseSecond);
	    		if($rootScope.caseCombiCourant.valeur == caseCombi.valeur){
	    			console.log("correspondance Ok");
	    			$rootScope.correspondanceOK = true;
	    			//self.class="boutonCaseActif";
	    		}
	    	}
			
			//$rootScope.codeCouleurCourant = couleur.code;
			//console.log("codeCouleurCourant : " + $rootScope.codeCouleurCourant);
			}                       
  }]);

/*phonecatControllers.controller('PhoneDetailCtrl', ['$scope', '$routeParams', 'Phone',
  function($scope, $routeParams, Phone) {
    $scope.phone = Phone.get({phoneId: $routeParams.phoneId}, function(phone) {
      $scope.mainImageUrl = phone.images[0];
    });

    $scope.setImage = function(imageUrl) {
      $scope.mainImageUrl = imageUrl;
    }
  }]);*/
