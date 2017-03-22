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
         
         
        $scope.edit = function(id){
            console.log(id)
        }
        
        $scope.delete = function(id){
            console.log(id)
        }
  
}]);


