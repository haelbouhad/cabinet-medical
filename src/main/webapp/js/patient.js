/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


'use strict';

angular.module('cabinetApp.patient', ['ngRoute'])

.controller('patientCtrl', ['cabinetService', '$http','$location','$scope',function(cabinetService, $http,$location,$scope) {
        
        console.log('patientCtrl')

        cabinetService.getAll('patients').then(
                function successCallback(response) {
                    $scope.patients = response.data ;
                }, function errorCallback(response) {
                    //.handle(response.status,'/') ;
         }) ;
         
         
        $scope.edit = function(patient){
            $location.path('/patient/edit').search({ param : patient })
        }
        
        $scope.delete = function(patient){
            console.log(patient.id)
        }
  
}])

.controller('patientEditCtrl', ['cabinetService', '$routeParams', '$http','$location','$scope',function(cabinetService, $routeParams, $http,$location,$scope) {
        
        console.log('patientEditCtrl')  

        $scope.patient = $routeParams.param;
         
        $scope.cancel = function(){
            console.log('cancel')
            $location.path('/patient').search({})
        }
        
        $scope.submit = function(){
            
            cabinetService.edit('patients', $scope.patient.id, $scope.patient).then(
                function successCallback(response) {
                    $location.path('/patient').search({})
                }, function errorCallback(response) {
                    //.handle(response.status,'/') ;
            }) ;
            
        }
  
}])


