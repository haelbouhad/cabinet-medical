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
         
        $scope.add = function(){
            $location.path('/medecin/edit')
        }
        
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
        
        if($scope.medecin != null)
            $scope.operation = {
                id      :  'edit',
                title : 'Modifier le'
            }
        else
            $scope.operation =  {
                id      : 'create',
                title : 'Ajouter un'
            }
        
         
        $scope.cancel = function(){
            console.log('cancel')
            $location.path('/medecin').search({})
        }
        
        $scope.submit = function(){
            
            cabinetService.maj($scope.operation.id, 'medecins', $scope.medecin.id, $scope.medecin).then(
                function successCallback(response) {
                    $location.path('/medecin').search({})
                }, function errorCallback(response) {
                    //.handle(response.status,'/') ;
            }) ;
            
        }
  
}])
