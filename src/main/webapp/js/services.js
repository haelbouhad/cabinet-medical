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
        maj  : function(op, type, id, object){
            if(op == 'edit'){
                var method = 'PUT'
                var url = apiUrl+'/ws/'+type + '/' + id
            }else{
                var method = 'POST'
                var url = apiUrl+'/ws/'+type
            }
            return $http({
                        method: method, 
                        url: url,
                        data : object
                    }) ; 
        },
        delete : function(type, id){
            return $http({
                        method: 'DELETE', 
                        url: apiUrl+'/ws/'+type+'/' + id
                    }) ; 
        }
    };
})

