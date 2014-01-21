'use strict';

/* Controllers */

var orthotabControllers = angular.module('orthotabControllers', ['ngCookies']);

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
  
  
  orthotabControllers.controller('AccueilCtrl', ['$rootScope','$scope', 'Accueil',
                                                  function($rootScope, $scope, Accueil) {
	  console.log("dans AccueilCtrl");
	  $scope.etapes = Accueil.query();
	  
	  $scope.goToNiveau = function ($event, niveau) {
		  console.log("dans goToNiveau : " + niveau);  
	  }
	  
	  
  }]);
  
  //orthotabControllers.controller('LoginCtrl', ['$rootScope','$scope', 'User',
  //                                               function($rootScope, $scope, User) {
  orthotabControllers.controller('LoginCtrl', ['$rootScope','$scope', 'User', '$cookieStore', '$http',
                                                 function($rootScope, $scope, User, $cookieStore, $http) {
	  console.log("dans LoginCtrl");
	  //$scope.etapes = Accueil.query();
	  //$cookieStore.put('orthotab','patient1');
		var cookieOrthoTab = $cookieStore.get('orthotab');
		if(cookieOrthoTab!=null){
			// a completer avec verification User
			$scope.isLogged = true;
		}else{
			$scope.isLogged = false;
		}
	  console.log("$scope.isLogged : " + $scope.isLogged);
	  //$scope.isLogged = User.isLogged();
	  $scope.message = '';
	  
	  //$scope.submit = function
	  //$scope.goToNiveau = function ($event, niveau) {
		//  console.log("dans goToNiveau : " + niveau);  
	  //}
	  
	  $scope.submit = function () {
		    $http
		      .post('/orthotab/api/authenticate', $scope.user)
		      .success(function (data, status, headers, config) {
		        //$window.sessionStorage.token = data.token;
		        $scope.isLogged = true;
		        console.log("dans submit success");
		        //console.log("data : " + data);
		        console.log("data.nom : " + data.nom);
		        
		        //var userConnecte = JSON.parse(data);
		        //console.log("userConnecte : " + userConnecte);
		        //var encodedProfile = data.token.split('.')[1];
		        //var profile = JSON.parse(url_base64_decode(encodedProfile));
		        //$scope.welcome = 'Welcome ' + profile.first_name + ' ' + profile.last_name;
		      })
		      .error(function (data, status, headers, config) {
		        // Erase the token if the user fails to log in
		        //delete $window.sessionStorage.token;
		        $scope.isLogged = false;

		        // Handle login errors here
		        $scope.message = 'Error: Invalid user or password';
		        //$scope.welcome = '';
		      });
		  };
	  
	  
 }]);
