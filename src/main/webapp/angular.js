/* global $http */

var app = angular.module('myApp', []);

app.controller("myCtrl", function($scope, $http){
    $scope.test = "test";
  $http.get('http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00:00:00.000Z/2').
        then(function(response) {
            $scope.data = response.data;
        });
});

app.filter('dateFilter', function(){
    return function(){
        
    };
});