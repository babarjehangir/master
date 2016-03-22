'use strict';
/* App Module */

var movieReservationApp = angular.module('movieReservationApp', [
  'ngRoute',
  'movieReservationControllers',
  'movieReservationServices'
]);

movieReservationApp.config(['$routeProvider', '$locationProvider',
function($routeProvider, $locationProvider) {
  $routeProvider.
    when('/', {
    templateUrl: 'partials/main.html',
    controller: 'MainCtrl'
  }).when('/login', {
    templateUrl: 'partials/login.html',
    controller: 'loginController'
});


$locationProvider.html5Mode(false).hashPrefix('!');
}]); 

movieReservationApp.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}
]);