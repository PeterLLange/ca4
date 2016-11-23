/* global $http */

var app = angular.module('myApp', []);

app.controller("myCtrl", function ($scope, $http) {
    $scope.test = "test";
    $scope.numSeats;
    $scope.date;
    $scope.airport;


    $scope.details = function () {
        console.log($scope.date);
        console.log($scope.numSeats);
        var daty = new Date($scope.date);
        console.log(daty.getDate());
        var stringy = (daty.getDate() == 1 ? daty.getUTCFullYear() + 1 : daty.getFullYear()) + "-" +
                ((daty.getDate() == 1 ? daty.getUTCMonth() + 2 : daty.getUTCMonth() + 1) < 10 ?
                        "0" + (daty.getDate() == 1 ? daty.getUTCMonth() + 2 : daty.getUTCMonth() + 1) :
                        (daty.getDate() == 1 ? daty.getUTCMonth() + 2 : daty.getUTCMonth() + 1))
                + "-" + (daty.getDate() < 10 ? "0" + daty.getDate() : daty.getDate()) + "T" + "00" + ":" + "00" + ":" + "00.000" + "Z";
        console.log("Stringy: " + stringy);
        console.log("Airport: " + $scope.airport);
        var url = 'http://airline-plaul.rhcloud.com/api/flightinfo/' + $scope.airport + "/" + stringy + "/" + $scope.numSeats;
        console.log(url);
    };

    $http.get('http://airline-plaul.rhcloud.com/api/flightinfo/SXF/2017-01-03T00:00:00.000Z/2').
            success(function (response) {
                $scope.data = response;
                console.log("Det gik godt");
            }).error(function (response) {

        $scope.status = response.statusText;
    });


});

app.filter('dateFilter', function () {
    return function () {

    };
});

