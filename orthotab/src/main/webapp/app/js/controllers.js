'use strict';

/* Controllers */

var orthotabControllers = angular.module('orthotabControllers', []);

  orthotabControllers.controller('CouleursCtrl', ['$rootScope','$scope', 'Couleurs',
  function($rootScope, $scope, Couleurs) {
	//$rootScope.boutonCouleurClass = 'boutonCouleur';
	 // $scope.boutonCouleurClass = 'boutonCouleur';
	  
	  var self = this;
	  self.selectedIndex = -1;
    $scope.couleurs = Couleurs.query();
    //$scope.boutonCouleur-style = "boutonCouleur";
    //$scope.orderProp = 'age';
    
   /* $scope.logPosition = function (item, $event) {
    	console.log(item + ' was clicked at: ' + $event.clientX + ',' +
    	$event.clientY);
    	}*/
    
    $scope.getClass = function(ind){
        if( ind === self.selectedIndex ){
            return "boutonCouleurActif";
        } else{
            return "boutonCouleur";
        }
    }
    
    $scope.enregistreCouleur = function (couleur, $event, ind) {
		console.log("debut");
		self.selectedIndex = ind;
		$rootScope.codeCouleurCourant = couleur.code;
		console.log("codeCouleurCourant : " + $rootScope.codeCouleurCourant);
		}
    
  }]);
  
  orthotabControllers.controller('Niveau01Ctrl', ['$scope', 'Niveau01',
                                                  function($scope, Niveau01) {
                                                    $scope.cases = Niveau01.query();
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
