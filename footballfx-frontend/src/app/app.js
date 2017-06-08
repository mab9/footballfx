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
    $scope.editingPlayer = {};

    $http.get(backendUrl)
        .then(function (response) {
            $scope.players = response.data;
        });

    $scope.editPlayer = function (player) {
        $scope.isEditMode = true;
        $scope.editingPlayer = angular.copy(player);
    };

    $scope.cancelEdit = function () {
        $scope.isEditMode = false;
        $scope.editingPlayer = {};
    };

    $scope.addPlayer = function () {
        $scope.isEditMode = false;
        $scope.editingPlayer = {}
    };

    $scope.savePlayer = function (player) {
        $http.put(backendUrl, $scope.editPlayer.id, $scope.editPlayer)
            .then(function (response) {
                $scope.players = response.data;
            });
        $scope.editingPlayer = {};
        $scope.isEditMode = false;
    };

    $scope.removePlayer = function (player) {
        $http.delete(backendUrl + player.id)
            .then(function (response) {
                $scope.players.splice($scope.players.indexOf(player), 1);
            });
    };
});
