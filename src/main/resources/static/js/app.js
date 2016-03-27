'use strict';
/* App Module */

var movieReservationApp = angular.module('movieReservationApp', [
  'ngRoute',
  'movieReservationControllers',
  'movieReservationServices'
]);

movieReservationApp.config(['$routeProvider', '$locationProvider','$httpProvider',
function($routeProvider, $locationProvider, $httpProvider) {
  $routeProvider.
    when('/', {
    templateUrl: 'partials/main.html',
    controller: 'MainCtrl'
  }).when('/login', {
    templateUrl: 'partials/login.html',
    controller: 'loginController'
}).when('/home', {
    templateUrl: 'partials/home.html'
});

 $httpProvider.defaults.useXDomain = true;
 $httpProvider.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
$locationProvider.html5Mode(false).hashPrefix('!');
}]); 
