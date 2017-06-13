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
    $scope.isCreateMode = false;
    $scope.player = {};

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
        $scope.isEditMode = true;
        $scope.player = angular.copy(player);
    };

    $scope.cancelEdit = function () {
        $scope.isEditMode = false;
        $scope.isCreateMode = false;
        $scope.player = {};
    };

    $scope.addPlayer = function () {
        $scope.isCreateMode = true;
        $scope.player = {};
    };

    $scope.savePlayer = function () {
        $http.post(backendUrl, $scope.player)
            .then(function () {
                $scope.getPlayers();
            });
        $scope.isEditMode = false;
        $scope.isCreateMode = false;
        $scope.player = {};
    };

    $scope.updatePlayer = function () {
        $http.put(backendUrl + $scope.player.id, $scope.player)
            .then(function () {
                $scope.getPlayers();
            });
        $scope.isEditMode = false;
        $scope.isCreateMode = false;
        $scope.player = {};
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


app.directive("formPlayer", function () {
    return {
        restrict: 'E',
        templateUrl: "app/modules/directive/formplayer.html"
    }
});

app.directive("tablePlayer", function () {
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


