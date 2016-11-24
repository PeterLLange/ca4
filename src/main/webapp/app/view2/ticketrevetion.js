angular.module('myApp.view2', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view2', {
                    templateUrl: 'app/view2/view2.html',
                    controller: 'View2Ctrl'
                });
            }])

        .controller('View2Ctrl', function ($http, $scope) {
            
            var reservation = "localhost.com/api/reservation/";
            var getdataurl = "localhost.com/api/flights/";
            var from = "";
            var to = "";
            var pessengers = [$scope.firstName.length];
            for (i = 0; i < $scope.firstName.length; i++) {
                pessengers[i] = {
                    firstName:$scope.firstName[i],
                    lastName:$scope.firstName[i]
                };
            }
            var data = $.param({
                numberofseats: $scope.numberofseats,
                reserveename: $scope.reserveename,
                reservephone: $scope.reservephone,
                reserveeEmail:$scope.reserveeEmail,
                pessengers:pessengers
            });
            var config = {
                headers : {
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            };
                $http.get(getdataurl+from+"/"+to+"/")
                        .success(function (data) {
                            $scope.data = data;
                        })
                        .error(function (status) {
                            $scope.status = status;
                        });
            
            $scope.reservate = function (flightid) {
                $http.post(reservation + flightid,data,config)
                        .success(function () {
                            $scope.refresh();
                        })
                       .error(function (status) {
                            $scope.status = status;
                        });
            };
            $scope.refresh = function(){
              $http.get('api/admin/users').success(function(data){
                  $scope.data = data;
              });     
            };

        })
        .factory('userService', function ($http) {
            return {
                getCompanies: function () {
                    var req = {
                        method: 'GET',
                        url: 'http://cvrapi.dk/api?vat=3167%208021&country=dk', //? + value + &contr... + dk
                        skipAuthorization: true,
                        
                        data: {}
                    };
                    return $http(req);
                }
            };
        });