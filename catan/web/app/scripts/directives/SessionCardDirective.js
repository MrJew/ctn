/**
 * Created by MrJew-User on 20/04/2016.
 */

angular.module('webApp')
  .directive("sessionCard", function(){
    return {
      restrict: "E",
      templateUrl: "app/template/session-card.html",
      controller: "SessionCardCtrl",
      scope:{
        gameName: '@',
        playerCount: '@'
      }
    }
  }).controller("SessionCardCtrl", function($scope) {
    $scope.colors = ['white','red','blue','yellow','green','brown'];
    $scope.gameColors = $scope.colors.slice(0,$scope.playerCount-1);
  });
