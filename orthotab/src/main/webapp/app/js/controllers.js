'use strict';

/* Controllers */

var orthotabControllers = angular.module('orthotabControllers', []);

  orthotabControllers.controller('CouleursCtrl', ['$scope', 'Couleurs',
  function($scope, Couleurs) {
    $scope.couleurs = Couleurs.query();
    //$scope.orderProp = 'age';
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
