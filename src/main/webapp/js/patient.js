/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


'use strict';

angular.module('cabinetApp.patient', ['ngRoute'])

.controller('patientCtrl', ['cabinetService', '$route', '$http','$location','$scope',function(cabinetService, $route,$http,$location,$scope) {
        
        console.log('patientCtrl')

        cabinetService.getAll('patients').then(
                function successCallback(response) {
                    $scope.patients = response.data ;
                }, function errorCallback(response) {
                    //.handle(response.status,'/') ;
         }) ;

        $scope.add = function(){
            $location.path('/patient/edit')
        }
         
        $scope.edit = function(patient){
            $location.path('/patient/edit').search({ param : patient })
        }
        
        $scope.delete = function(patient){
            var r = confirm("Etes vous sur de bien vouloir supprimer ce patient ?");
            if (r == true) {
                cabinetService.delete('patients', patient.id).then(
                    function successCallback(response) {
                        $route.reload();
                    }, function errorCallback(response) {
                        //.handle(response.status,'/') ;
                }) ;
            }
        }
  
}])

.controller('patientEditCtrl', ['cabinetService', '$routeParams', '$http','$location','$scope',function(cabinetService, $routeParams, $http,$location,$scope) {
        
        console.log('patientEditCtrl')  

        $scope.patient = $routeParams.param;
        
        if($scope.patient != null)
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
            $location.path('/patient').search({})
        }
        
        $scope.submit = function(){
            
            cabinetService.maj($scope.operation.id, 'patients', $scope.patient.id, $scope.patient).then(
                function successCallback(response) {
                    $location.path('/patient').search({})
                }, function errorCallback(response) {
                    //.handle(response.status,'/') ;
            }) ;
            
        }
  
}])


