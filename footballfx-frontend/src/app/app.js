/**
 * Created by rb25 on 30.05.2017.
 */
require('angular');


var app = angular.module('app', []);

app.controller('MainController', function ($scope, $http) {

    var backendUrl = "http://localhost:8080/football/";
    $scope.players = [];
    $scope.title = 'Football Fx Pro Version!';
    $scope.isEditMode = false;
    $scope.playerEditing = {};

    $http.get(backendUrl)
        .then(function (response) {
            $scope.players = response.data;
        });

    $scope.editPlayer = function (player) {
        $scope.isEditMode = true;
        $scope.playerEditing = angular.copy(player);
    };

    $scope.cancelEdit = function () {
        $scope.isEditMode = false;
        $scope.playerEditing = {};
    };

    $scope.savePlayer = function () {
        $http.put('http://localhost:8080/football/', $scope.playerEditing.id, $scope.playerEditing)
            .then(function (response) {
                $scope.players = response.data;
            });
        $scope.playerEditing = {};
        $scope.isEditMode = false;
    };

    $scope.removePlayer = function (player) {
        $http.delete('http://localhost:8080/football/', player.id)
            .then(function (response) {
                $scope.players = response.data;
            });
    };
});
