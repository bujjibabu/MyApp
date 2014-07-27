'use strict';

/**
 * AdminController
 * @constructor
 */
var AdminController = function($scope, $http) {
$scope.login =function(){
    if($scope.email=='admin@gmail.com' && $scope.password=='pwd'){
        $scope.showadminpage=true;
    }else{
       window.alert("Invalid username or password - Try again.")
    }
}

$scope.upload = function (){
    var oMyForm = new FormData();
  oMyForm.append("file", files2.files[0]);
  
  $http.post("admins/upload", {data : oMyForm}, {});
  }
};