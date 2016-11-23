/* global $http */

var app = angular.module('myApp', []);

app.controller("myCtrl", function($scope, $http){
    $scope.test = "test";
  $http.get('http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00:00:00.000Z/2').
        success(function(response) {
            $scope.data = response;
            console.log("Det gik godt");
        }).error(function(response){
            
            $scope.status = response.statusText;
        });
});

app.filter('dateFilter', function(){
    return function(){
        
    };
});