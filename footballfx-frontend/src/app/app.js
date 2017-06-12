/**
 * Created by rb25 on 30.05.2017.
 */
require('angular');


var app = angular.module('app', []);

app.controller('MainController', function ($scope, $http) {

    var backendUrl = "http://localhost:8080/football/";

    $scope.title = 'Football Fx Pro Version!';
    $scope.players = [];
    $scope.associations = [];
    $scope.countries = [];
    $scope.isEditMode = false;
    $scope.editingPlayer = {};
    $scope.isCreateMode = false;
    $scope.createPlayer = {};

    $scope.getPlayers = function () {
        $http.get(backendUrl)
            .then(function (response) {
                $scope.players = response.data;
            });
    };

    $scope.getAssociations = function () {
        $http.get(backendUrl + 'association')
            .then(function (response) {
                $scope.associations = response.data;
            });
    };

    $scope.getCountries = function () {
        $http.get(backendUrl + 'country')
            .then(function (response) {
                $scope.countries = response.data;
            });
    };

    $scope.editPlayer = function (player) {
        console.info(player);
        $scope.isEditMode = true;
        $scope.editingPlayer = angular.copy(player);
    };

    $scope.cancelEdit = function () {
        $scope.isEditMode = false;
        $scope.editingPlayer = {};
        $scope.isCreateMode = false;
        $scope.createPlayer = {};
    };

    $scope.addPlayer = function () {
        $scope.isCreateMode = true;
    };

    $scope.savePlayer = function () {
        $http.post(backendUrl, $scope.createPlayer)
            .then(function () {
                $scope.getPlayers();
            });
        $scope.createPlayer = {};
        $scope.isCreateMode = false;
    };

    $scope.updatePlayer = function () {
        $http.put(backendUrl + $scope.editingPlayer.id, $scope.editingPlayer)
            .then(function () {
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
    $scope.getAssociations();
    $scope.getCountries();
});


app.directive("editPlayer", function () {
    return {
        restrict: 'E',
        templateUrl: "app/modules/directive/editplayer.html"
    }
});

app.directive("createPlayer", function () {
    return {
        restrict: 'E',
        templateUrl: "app/modules/directive/createplayer.html"
    }
});

app.directive("player", function () {
    return {
        restrict: 'E',
        templateUrl: "app/modules/directive/player.html"
    }
});

app.directive("header", function () {
    return {
        restrict: 'E',
        templateUrl: "app/modules/directive/header.html"
    }
});


