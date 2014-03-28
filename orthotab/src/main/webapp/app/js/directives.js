'use strict';

/* Directives */

var orthotabDirectives = angular.module('orthotabDirectives', []);

orthotabDirectives.directive('draggable', function () {
	  return {
	    restrict: 'A',
	    link: function (scope, element, attrs) {
	      element[0].addEventListener('dragstart', scope.handleDragStart, false);
	      element[0].addEventListener('dragend', scope.handleDragEnd, false);
	    }
	  }
	});

orthotabDirectives.directive('droppable', function () {
	  return {
	    restrict: 'A',
	    link: function (scope, element, attrs) {
	      element[0].addEventListener('drop', scope.handleDrop, false);
	      element[0].addEventListener('dragover', scope.handleDragOver, false);
	      element[0].addEventListener('dragenter', scope.handleDragEnter, false);
	      element[0].addEventListener('dragleave', scope.handleDragLeave, false);
	    }
	  }
	});


orthotabDirectives.directive('loading',   ['$http' ,function ($http)
{
    return {
        restrict: 'A',
        link: function (scope, elm, attrs)
        {
            scope.isLoading = function () {
                return $http.pendingRequests.length > 0;
            };

            scope.$watch(scope.isLoading, function (v)
            {
               	scope.chargementEnCours = v;
            });
        }
    };
}]);
