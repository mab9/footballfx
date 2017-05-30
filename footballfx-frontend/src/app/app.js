/**
 * Created by rb25 on 30.05.2017.
 */
require('angular');


var app = angular.module('app', []);

app.controller('MainController', function ($scope, $http) {

    $scope.players = [];
    $scope.title = 'Football Fx Pro Version!';

    $http.get('http://localhost:8080/football/')
        .then(function (response) {
            $scope.players = response.data;
        });


    $scope.editPlayer = function () {
        return null;
    };

    $scope.savePlayer = function () {
        return null;
    };

    $scope.removePlayer = function (player) {
        $http.post('http://localhost:8080/football/', player.id)
            .then(function (response) {
                $scope.players = response.data;
            });
    };
});
