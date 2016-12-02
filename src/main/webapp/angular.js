/* global $http */

var app = angular.module('myApp', []);

app.controller("myCtrl", function ($scope, $http) {
    $scope.test = "test";
    $scope.numSeats;
    $scope.date;
    $scope.airport;
    $scope.destination;

    $scope.details = function () {
        console.log($scope.date);
        console.log($scope.numSeats);
        var daty = new Date($scope.date);
        console.log(daty.getDate());
        var stringy = (daty.getDate() == 1 ? daty.getUTCFullYear() + 1 : daty.getFullYear()) + "-" +
                ((daty.getDate() == 1 ? daty.getUTCMonth() + 2 : daty.getUTCMonth() + 1) < 10 ?
                        "0" + (daty.getDate() == 1 ? daty.getUTCMonth() + 2 : daty.getUTCMonth() + 1) :
                        ((daty.getDate() == 1 ? daty.getUTCMonth() + 2 : daty.getUTCMonth() + 1)) == 13 ? 1 :
                        (daty.getDate() == 1 ? daty.getUTCMonth() + 2 : daty.getUTCMonth() + 1))
                + "-" + (daty.getDate() < 10 ? "0" + daty.getDate() : daty.getDate()) + "T" + "00" + ":" + "00" + ":" + "00.000" + "Z";
        console.log("Stringy: " + stringy);
        console.log("Airport: " + $scope.airport);
        var dest = (angular.isUndefined($scope.destination) ? "" :
                ($scope.destination == "" ? "" :
                        "/" + $scope.destination));
        var url = 'http://localhost:8080/Semesterprojekt/api/flightinfo/' + $scope.airport + dest + "/" + stringy + "/" + $scope.numSeats;
        console.log(url);
        $http.get(url).
                success(function (response) {
                    $scope.data = response;
                    console.log("Det gik godt");
                }).error(function (response) {
            alert(response.message);
        });
    };
    $scope.myTable = false;
    $scope.toggle = function () {
        if ($scope.myTable === false && $scope.myForm.$valid)
        {
            $scope.myTable = !$scope.myTable;
        }
    };

});

app.filter('priceFilter', function () {
    return function (f) {

    };
});
