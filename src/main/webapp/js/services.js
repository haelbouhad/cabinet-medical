'use strict';

angular.module('cabinetApp.services', [])

.factory('cabinetService', function(apiUrl, $location,$http) {
  return {
        getAll : function(type){
            return $http({
                        method: 'GET', 
                        url: apiUrl+'/ws/'+type
                    }) ; 
        }
    };
})

