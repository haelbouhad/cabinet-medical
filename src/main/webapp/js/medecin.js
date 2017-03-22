/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


'use strict';

angular.module('cabinetApp.medecin', ['ngRoute'])

.controller('medecinCtrl', ['cabinetService', '$http','$location','$scope',function(cabinetService, $http,$location,$scope) {
        
        console.log('medecinCtrl')

        cabinetService.getAll('medecins').then(
                function successCallback(response) {
                    $scope.medecins = response.data ;
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
