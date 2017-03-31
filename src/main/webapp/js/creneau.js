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
        
        $scope.delete = function(creneau){
            var r = confirm("Etes vous sur de bien vouloir supprimer ce creneau ?");
            if (r == true) {
                cabinetService.delete('creneaux', creneau.id).then(
                    function successCallback(response) {
                        $route.reload();
                    }, function errorCallback(response) {
                        //.handle(response.status,'/') ;
                }) ;
            }
        }
  
}])

.controller('creneauEditCtrl', ['cabinetService', '$routeParams', '$http','$location','$scope',function(cabinetService, $routeParams, $http,$location,$scope) {
        
        console.log('creneauEditCtrl')  

        $scope.creneau = $routeParams.param;
        
        // Le cas de modification
        if($scope.creneau != null){
            $scope.operation = {
                id      :  'edit',
                title : 'Modifier le'
            }
            $scope.creneau.debut = new Date($scope.creneau.debut)
            $scope.creneau.fin = new Date($scope.creneau.fin)
        } 
        // Le cas d'un nouveau créneau
        else{
            $scope.operation =  {
                id      : 'create',
                title : 'Ajouter un'
            }
            
            // Retrieve all medecins
            cabinetService.getAll('medecins').then(
                function successCallback(response) {
                    $scope.medecins = response.data ;
                }, function errorCallback(response) {
                    //.handle(response.status,'/') ;
            }) ;
            
            $scope.creneau = {}
            
            $scope.creneau.debut = new Date
            $scope.creneau.fin = new Date
            
        }
        
        var jsonifyMedecin = function(){
            if($scope.operation.id == 'create')
                $scope.creneau.medecin = JSON.parse($scope.creneau.medecin)
        }

         
        $scope.cancel = function(){
            console.log('cancel')
            $location.path('/creneau').search({})
        }
        
        $scope.submit = function(isValid){
            
            if(isValid){
                
                jsonifyMedecin()
                
                cabinetService.maj($scope.operation.id, 'creneaux', $scope.creneau.id, $scope.creneau).then(
                    function successCallback(response) {
                        $location.path('/creneau').search({})
                    }, function errorCallback(response) {
                        //.handle(response.status,'/') ;
                }) ;
            }
            else
                $scope.msg = "Votre saisie est invalide"
            
        }
  
}])

