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

    $scope.getPlayers = function () {
        $http.get(backendUrl)
            .then(function (response) {
                $scope.players = response.data;
            });
    };

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

    $scope.updatePlayer = function () {
        $http.put(backendUrl + $scope.editingPlayer.id, $scope.editingPlayer)
            .then(function (response) {
                $scope.getPlayers();
            });
        $scope.editingPlayer = {};
        $scope.isEditMode = false;
    };

    $scope.deletePlayer = function (player) {
        $http.delete(backendUrl + player.id)
            .then(function () {
                $scope.removePlayer(player)
            });
    };

    $scope.removePlayer = function (player) {
        $scope.players.splice($scope.players.indexOf(player), 1);
    };


    $scope.getPlayers();
});
