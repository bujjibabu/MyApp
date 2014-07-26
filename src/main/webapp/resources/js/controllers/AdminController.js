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

  
//  $http({
//    url: 'admins/upload',
//    data: oMyForm,
//    contentType: false,
//    type: 'POST',
//    success: function(data){
//        console.log('data  ---- :', data);
//    }
//  });
    
    
    
//    $scope.title;
//    $scope.description;
//    $scope.tags;
//    $scope.thumbnail;
//    $scope.largeImage;
    
//    $http({
//    method: 'POST',
//    url: 'admins/upload',
//    headers: {
//      'Content-Type': 'multipart/form-data'
//    },
//    data: {
//        thumbnail: $scope.thumbnail, title : $scope.title 
//    }
//    ,transformRequest: function(data) {
//            console.log(data);
//            var fd = new FormData();
//            angular.forEach(data, function(value, key) {
//            fd.append(key, value);
//            });
//                return fd;
//}
//  });

}

};