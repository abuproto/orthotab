'use strict';

/* Controllers */

var orthotabControllers = angular.module('orthotabControllers', ['ngCookies']);

  orthotabControllers.controller('CouleursCtrl', ['$rootScope','$scope', 'Couleurs',
  function($rootScope, $scope, Couleurs) {	  
	
	  //console.log("param : " + $scope.param);
	  /*
	  $scope.init = function(nb)
	  {
	    $scope.nbcouleurs = nb;
	    console.log("dans init : " + nb);
	  };*/
	  //console.log("$rootScope.nbcouleurs : " + $rootScope.nbcouleurs);
	  //console.log("$scope.nbcouleurs : " + $scope.nbcouleurs);
	  
    $scope.couleurs = Couleurs.query({},{'nbCouleurs':$scope.nivdifficulte});
        
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

	  $scope.cases = Niveau01.query({},{'nbCombi':$scope.nivdifficulte});
	  
	  $scope.nbCombiTrouve = 0;
	  $rootScope.niveauFini = false;
                                                    
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
			    		
			    		$scope.nbCombiTrouve = $scope.nbCombiTrouve + 1;
			    		if($scope.nbCombiTrouve == $scope.nivdifficulte){
			    			// mise à jour niveau utilisateur
			    			
			    			// affichage message
			    			$rootScope.messageNiveau01 = "Bravo, tu as réussi ce niveau !";
			    			$rootScope.niveauFini = true;
			    		}
		    		}
		    	}
	    	}
		}                       
  }]);
  
  
  orthotabControllers.controller('AccueilCtrl', ['$rootScope','$scope', 'Accueil','UserService','$window','$cookieStore',
                                                  function($rootScope, $scope, Accueil, UserService, $window, $cookieStore) {
	  //$scope.currentUser = UserService.currentUser();
	  console.log("dans AccueilCtrl");
	  //$scope.etapes = Accueil.query({},{'nivcourant':$scope.currentUser.nivcourant});
	  var cookieOrthoTab = $cookieStore.get('orthotab');
	  if(cookieOrthoTab!=null){
		  console.log("user.id : " + cookieOrthoTab.id);
	  }
		  
	  $scope.etapes = Accueil.query({},{'nivcourant':cookieOrthoTab.id});
	  
	  $scope.goToNiveau = function ($event, niveau) {
		  console.log("dans goToNiveau : " + niveau);
		  
		  if(niveau==1){
			  $window.location.href = "niveau1temp.htm";
		  }else if(niveau==2){
			  $window.location.href = "niveau1.htm";
		  }else{
			  $window.alert("Ce niveau sera disponible prochainement. A bientôt.");
		  }
	  }
	  
	  
  }]);
  
  //orthotabControllers.controller('LoginCtrl', ['$rootScope','$scope', 'User',
  //                                               function($rootScope, $scope, User) {
  orthotabControllers.controller('LoginCtrl', ['$rootScope','$scope', 'UserService', '$cookieStore', '$http', '$window','$timeout',
                                                 function($rootScope, $scope, UserService, $cookieStore, $http, $window, $timeout) {
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
	  $scope.utilisateur = '';
	  
	  //$scope.submit = function
	  //$scope.goToNiveau = function ($event, niveau) {
		//  console.log("dans goToNiveau : " + niveau);  
	  //}
	  
	  $scope.depart = function () {
		  console.log("dans depart");
		  $window.location.href = "accueil.htm";
	  };
	  
	  
	  $scope.submit = function () {
		  
		  //var currentUser = UserService.login($scope.user);
		  //UserService.login($scope.user);
		  
		  //var currentUser = $timeout(UserService.currentUser(),1000);
		  //var currentUser.then(UserService.login($scope.user));
		  //var currentUser = $timeout(function(){return UserService.currentUser();},1000);
		  /*
		  var currentUser = UserService.currentUser();
		  
		  if(angular.isUndefined(currentUser.nom)){
	        	$scope.isLogged = false;
	        	$scope.message = 'Identifiant ou mot de passe incorrect';
	        	console.log("dans if");
	        }else{
	        	$scope.isLogged = true;
	        	$scope.message = '';
	        	$scope.utilisateur = currentUser.prenom;
	        	console.log("dans else");
	        }*/
		  
		    $http
		      .post('/orthotab/api/authenticate', $scope.user)
		      .success(function (data, status, headers, config) {
		        //$window.sessionStorage.token = data.token;
		        $scope.isLogged = true;
		        console.log("dans submit success");
		        console.log("data : ." + data + ".");
		        console.log("data.nom : ." + data.nom + ".");
		        //if(data===null || data.nom==='undefined'){
		        if(angular.isUndefined(data.nom)){
		        	$scope.isLogged = false;
		        	$scope.message = 'Identifiant ou mot de passe incorrect';
		        	console.log("dans if");
		        }else{
		        	$scope.isLogged = true;
		        	$scope.message = '';
		        	$scope.utilisateur = data.prenom;
		        	$cookieStore.put('orthotab',data);
		        	console.log("dans else");
		        }
		        console.log("$scope.isLogged : " + $scope.isLogged);
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
		        $scope.message = 'Identifiant ou mot de passe incorrect';
		        //$scope.welcome = '';
		      });
		  };
	  
	  
 }]);
