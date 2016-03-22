'use strict';
/* Controllers */

var movieReservationControllers = 
  angular.module('movieReservationControllers', []);
movieReservationControllers.controller('MainCtrl', 
  ['$scope', '$location', '$http',
function MainCtrl($scope, $location, $http) {
  $scope.message = "Hello World";
}]);


/*movieReservationControllers.controller('loginController', 
		['$scope', '$location',
		  function loginController($scope, $location) {
		   $scope.submit = function(){
		    $location.path('/customerLogin/' + $scope.cOpenId );
		  };
		}]); 
*/
movieReservationControllers.controller('loginController', 
		  ['$scope', '$routeParams', 'LoginService',

		  function loginController($scope, $routeParams, LoginService) {
			  $scope.login = function(){
				  console.log("Iam here");
			    var openId = $scope.cOpenId;
			  
			    LoginService.getLogin(openId).then(function mySucces(response) {
			    	console.log("service called");
			    }, function myError(response) {
			    	console.log("error thrown called");
			    });
			    /*
			    console.log("method called with openid:" + openId);
			    LoginService.get({id: openId},
			      function success(response) {
			      console.log("Success:" + JSON.stringify(response));
			      //$scope.blogEntry = response;
			    },
			    function error(errorResponse) {
			      console.log("Error:" + JSON.stringify(errorResponse));
			    }
			  );*/
			  };
		}]);