/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


'use strict';

angular.module('cabinetApp.rdv', ['ngRoute'])

.controller('rdvCtrl', ['cabinetService', '$route', '$http','$location','$scope',function(cabinetService, $route,$http,$location,$scope) {
        
        console.log('rdvCtrl')

        cabinetService.getAll('rdvs').then(
                function successCallback(response) {
                    console.log(response.data)
                    $scope.rdvs = response.data ;
                }, function errorCallback(response) {
                    //.handle(response.status,'/') ;
         }) ;

        $scope.add = function(){
            $location.path('/rdv/edit')
        }
         
        $scope.edit = function(rdv){
            $location.path('/rdv/edit').search({ param : rdv })
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
/*
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
*/

