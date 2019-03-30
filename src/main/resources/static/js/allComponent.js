const LOGGED_STATUS = "logged";
const baseUrl = window.basepath;
var app = angular.module("appComponent", []);

app.controller('appController', function($scope, $http) {
  $scope.isUserLogged = sessionStorage.getItem('enterPotUser');
  $scope.showLogin = true;
  $scope.showProfile = false;
  $scope.filterText = '';
  if($scope.isUserLogged){
    if($scope.isUserLogged.toString() !== ""){
      $http.get(baseUrl+'customer/'+$scope.isUserLogged)
        .then(function(response) {
          if(response.data){
            window.user = response.data;
            $scope.showLogin = false;
            $scope.showProfile = true;
          }
          else {
            $scope.showLogin = true;
            $scope.showProfile = false;
          }
        }, function(response) {
          $scope.showLogin = true;
          $scope.showProfile = false;
          console.log("couldnt get user");
        });
    }
    else {
      $scope.showLogin = true;
      $scope.showProfile =false;
    }
  }
  $scope.initApp = function() {
    $scope.showLogin = true;
    $scope.showProfile = false;
    $http.get(baseUrl+'item/all/')
      .then(function(response) {
        if(response.data.length>0){
          $scope.items=response.data;
          console.log(response.data);
          $scope.nodata = false;
        }
        else {
          $scope.nodata = true;
        }
      }, function(response) {
        console.log("No items");
      });
  };
  $scope.changeFilter=function (filter) {
    $scope.filterText = filter;
  }
});
