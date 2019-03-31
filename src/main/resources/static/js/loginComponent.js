const LOGGED_STATUS = "logged";
const baseUrl = window.basepath;
var app = angular.module("appComponent", []);
app.controller('appController', function($scope, $http) {


  $scope.initApp = function() {
    $scope.customerEmail="";
    $scope.customerpassword="";
    $scope.submitBtnDisabled = "disabled";
    $scope.errorMsg = false;
    $scope.passwordErr=false;

  };

  $scope.validatePass = function() {
    console.log($scope.customerpassword);
    if($scope.customerpassword.length>=6){
      $scope.passwordErr=false;
      console.log($scope.customerpassword.length);
      console.log($scope.customerpassword.length);
    }
    else {
      $scope.passwordErr=true;
      console.log($scope.customerpassword.length);
    }

  };


});
