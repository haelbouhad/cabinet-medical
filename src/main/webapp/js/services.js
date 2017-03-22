'use strict';

angular.module('cabinetApp.services', [])

.factory('cabinetService', function(apiUrl, $location,$http) {
  return {
        getAll : function(type){
            return $http({
                        method: 'GET', 
                        url: apiUrl+'/ws/'+type
                    }) ; 
        },
        edit  : function(type, id, object){
            console.log(apiUrl+'/ws/'+type + '/' + id)
            return $http({
                        method: 'PUT', 
                        url: apiUrl+'/ws/'+type + '/' + id,
                        data : object
                    }) ; 
        }
    };
})

