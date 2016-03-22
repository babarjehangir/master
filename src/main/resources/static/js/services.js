'use strict';
/* Services */

var movieReservationServices = 
 angular.module('movieReservationServices', ['ngResource']);
 
movieReservationServices.factory('LoginService', ['$resource',
function($resource) {
	return $resource("http://localhost:8080/login/openid/:id", {}, {
	  get: {method: 'GET', cache: false, isArray: false}
	  });

}]);

movieReservationServices.factory('LoginService', function($http) {
	    return {
	      getLogin: function(id) {
	         return $http.get('http://localhost:8080/login/openid/' + id);
	      }
	    }
	  });
