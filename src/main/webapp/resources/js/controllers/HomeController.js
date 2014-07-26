/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

'use strict';

/**
 * HomeController
 * @constructor
 */
var HomeController = function($scope, $http) {  
    $scope.fetchArtData = function() {
        $http.get('views/data.json').success(function(data){
            console.log('DATA : ', data);
            $scope.data = data;
            $scope.fnLoadGrid();
        });
    };
   $scope.fnLoadGrid = function(){
        $("#elastic_grid_demo").elastic_grid({
            'filterEffect': 'popup', // moveup, scaleup, fallperspective, fly, flip, helix , popup
            'hoverDirection': true,
            'hoverDelay': 0,
            'hoverInverse': false,
            'expandingSpeed': 500,
            'expandingHeight': 500,
            'items' :$scope.data
        });
    };
    $scope.fetchArtData();
};
