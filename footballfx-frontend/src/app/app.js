/**
 * Created by rb25 on 30.05.2017.
 */
require('angular');

var app = angular.module('app', []);

app.controller('MainController', function ($scope) {
    $scope.message = 'Angular Works!'
});