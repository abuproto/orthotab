'use strict';

/* Services */

var orthotabServices = angular.module('orthotabServices', ['ngResource']);

orthotabServices.factory('Couleurs', ['$resource',
  function($resource){
    return $resource('http://localhost\\:8081/orthotab/api/couleurs', {}, {
      query: {method:'GET', isArray:true}
    });
  }]);
