'use strict';
/* Controllers */

var movieReservationControllers = 
  angular.module('movieReservationControllers', []);
movieReservationControllers.controller('MainCtrl', 
  ['$scope', '$location', '$http',
function MainCtrl($scope, $location, $http) {
  $scope.message = "Hello World";
}]);


movieReservationControllers.controller('loginController', 
		  ['$scope', '$routeParams', 'LoginService', '$location', '$window',

		  function loginController($scope, $routeParams, LoginService, $location, $window) {
			  $scope.login = function(){
				  console.log("Iam here");
			    var openId = $scope.cOpenId;
			  
			    LoginService.getLogin(openId).then(function mySucces(response) {
			    	console.log("service called " + response.data.redirectURL);
			    	$window.location.href = response.data.redirectURL ;
			    }, function myError(response) {
			    	console.log("error thrown called");
			    });
			  };
		}]);