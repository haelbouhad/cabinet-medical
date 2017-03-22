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
         
         
        $scope.edit = function(medecin){
            $location.path('/medecin/edit').search({ param : medecin })
        }
        
        $scope.delete = function(medecin){
            console.log(medecin.id)
        }
  
  
}])

.controller('medecinEditCtrl', ['cabinetService', '$routeParams', '$http','$location','$scope',function(cabinetService, $routeParams, $http,$location,$scope) {
        
        console.log('medecinditCtrl')  

        
        $scope.medecin= $routeParams.param;
         
        $scope.cancel = function(){
            console.log('cancel')
            $location.path('/medecin').search({})
        }
        
        $scope.submit = function(){
            
            cabinetService.edit('medecins', $scope.medecin.id, $scope.medecin).then(
                function successCallback(response) {
                    $location.path('/medecin').search({})
                }, function errorCallback(response) {
                    //.handle(response.status,'/') ;
            }) ;
            
        }
  
}])
