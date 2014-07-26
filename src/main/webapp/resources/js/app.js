'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
        
    $routeProvider.when('/home', {
        templateUrl: 'views/home',
        controller: HomeController
    });
    
    $routeProvider.when('/admin', {
        templateUrl: 'admins/admin',
        controller: AdminController
    });
    
    $routeProvider.otherwise({redirectTo: '/home'});
}]);
