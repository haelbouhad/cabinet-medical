/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


'use strict';

angular.module('cabinetApp.creneau', ['ngRoute', 'datetime'])

.controller('creneauCtrl', ['cabinetService', '$route', '$http','$location','$scope',function(cabinetService, $route,$http,$location,$scope) {
        
        console.log('creneauCtrl')

        cabinetService.getAll('creneaux').then(
                function successCallback(response) {
                    console.log(response.data)
                    $scope.creneaux = response.data ;
                }, function errorCallback(response) {
                    //.handle(response.status,'/') ;
         }) ;

        $scope.add = function(){
            $location.path('/creneau/edit')
        }
         
        $scope.edit = function(creneau){
            $location.path('/creneau/edit').search({ param : creneau })
        }
        
        $scope.delete = function(rdv){
            /*var r = confirm("Etes vous sur de bien vouloir supprimer ce RDV ?");
            if (r == true) {
                cabinetService.delete('patients', patient.id).then(
                    function successCallback(response) {
                        $route.reload();
                    }, function errorCallback(response) {
                        //.handle(response.status,'/') ;
                }) ;
            }*/
        }
  
}])

.controller('creneauEditCtrl', ['cabinetService', '$routeParams', '$http','$location','$scope',function(cabinetService, $routeParams, $http,$location,$scope) {
        
        console.log('creneauEditCtrl')  

        $scope.creneau = $routeParams.param;
        
        $scope.creneau.debut = new Date($scope.creneau.debut)
        $scope.creneau.fin = new Date($scope.creneau.fin)
        
        if($scope.creneau != null)
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
            $location.path('/creneau').search({})
        }
        
        $scope.submit = function(){
            
            console.log($scope.creneau.fin)
            cabinetService.maj($scope.operation.id, 'creneaux', $scope.creneau.id, $scope.creneau).then(
                function successCallback(response) {
                    $location.path('/creneau').search({})
                }, function errorCallback(response) {
                    //.handle(response.status,'/') ;
            }) ;
            
        }
  
}])

