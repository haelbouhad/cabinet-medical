/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


'use strict';

angular.module('cabinetApp.rdv', ['ngRoute', 'ui.rCalendar', 'datetime'])

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
            $location.path('/rdv/add')
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

.controller('rdvAddCtrl', ['cabinetService', '$routeParams', '$http','$location','$scope',function(cabinetService, $routeParams, $http,$location,$scope) {
        
        console.log('rdvAddCtrl')  

        var init = function () {
            
            $scope.rdv = $routeParams.param;
            //$scope.rdv.patient = JSON.stringify($scope.rdv.patient) 
            
            $scope.operation =  {
                    id      : 'create',
                    title : 'Ajouter un'
            }
            $scope.rdv = {}
       
        }

        
        
        // Retrieve all patients
        cabinetService.getAll('patients').then(
            function successCallback(response) {
                $scope.patients = response.data ;  
                init();
            }, function errorCallback(response) {
                //.handle(response.status,'/') ;
        }) ;

        var prepareData = function(){
            // jsonifiy chosen patient
            $scope.rdv.patient = JSON.parse($scope.rdv.patient)
            // get the current creneau
            $scope.rdv.creneau = $scope.chosenEvent.creneau
        }
         
        $scope.cancel = function(){
            console.log('cancel')
            $location.path('/rdv').search({})
        }
        
        $scope.submit = function(isValid){
            
            if(isValid){
                                
                prepareData()
                
                console.log($scope.rdv)
                
                cabinetService.maj($scope.operation.id, 'rdvs', $scope.rdv.id, $scope.rdv).then(
                    function successCallback(response) {
                        $location.path('/rdv').search({})
                    }, function errorCallback(response) {
                        //.handle(response.status,'/') ;
                }) ;
                
            }
            else
                $scope.msg = "Votre saisie est invalide"
            
        }
        
        /*-----------------------------------------*/

        $scope.loadCreneaux = function () {

            cabinetService.getAll('creneaux').then(
                function successCallback(response) {
                    $scope.creneaux= response.data ;  
                    $scope.eventSource = getEvents();
                }, function errorCallback(response) {
                    //.handle(response.status,'/') ;
            }) ;

        };

        function getEvents() {

            var events = [];

            for(var index in $scope.creneaux) {

                events.push({
                        creneau  : $scope.creneaux[index],
                        title: 'Médecin : '
                                + $scope.creneaux[index].medecin.nom + ' ' + $scope.creneaux[index].medecin.prenom  ,
                        startTime: new Date($scope.creneaux[index].debut) ,
                        endTime: new Date($scope.creneaux[index].fin) ,
                        allDay: false
                });

            }

            return events;
        }

        $scope.onEventSelected = function (event) {
            $scope.chosenEvent = event
        };

        $scope.onTimeSelected = function (selectedTime) {
            $scope.chosenEvent = null 
        };

}])

