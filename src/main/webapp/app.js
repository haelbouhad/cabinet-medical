/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module("cabinetApp", [
    'ngRoute',
    'cabinetApp.rdv', 
    'cabinetApp.creneau', 
    'cabinetApp.medecin',
    'cabinetApp.patient',
    'cabinetApp.services'
]);

app.constant('apiUrl', window.location.origin + '/cabinet') ;

app.controller("cabinetApp", function (apiUrl, $scope, $http, $location) {
    console.log('cabinetApp') ;
}) ;

app.config(['$locationProvider', '$routeProvider','$httpProvider', function($locationProvider, $routeProvider,$httpProvider) {
  
  $locationProvider.hashPrefix('!');

  // Routing 
  $routeProvider.when('/rdv', {
    templateUrl: 'sections/rdv/list.html',
    controller: 'rdvCtrl'
  });

  $routeProvider.when('/rdv/add', {
    templateUrl: 'sections/rdv/add.html',
    controller: 'rdvAddCtrl'
  });
  
  $routeProvider.when('/creneau', {
    templateUrl: 'sections/creneau/list.html',
    controller: 'creneauCtrl'
  });
  
  $routeProvider.when('/creneau/edit', {
    templateUrl: 'sections/creneau/edit.html',
    controller: 'creneauEditCtrl'
  });

  $routeProvider.when('/medecin', {
    templateUrl: 'sections/medecin/list.html',
    controller: 'medecinCtrl'
  });
  
  $routeProvider.when('/medecin/edit', {
    templateUrl: 'sections/medecin/edit.html',
    controller: 'medecinEditCtrl'
  });

  $routeProvider.when('/patient', {
    templateUrl: 'sections/patient/list.html',
    controller: 'patientCtrl'
  });
  
  $routeProvider.when('/patient/edit', {
    templateUrl: 'sections/patient/edit.html',
    controller: 'patientEditCtrl'
  });

  $httpProvider.defaults.headers.common['Accept'] = 'application/json, text/javascript;charset=UTF-8';

}]) ;