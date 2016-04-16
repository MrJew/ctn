'use strict';

/**
 * @ngdoc function
 * @name webApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webApp
 */
angular.module('webApp')
  .controller('MainCtrl', function ($scope, $mdSidenav) {
    $scope.toggleSidenav = function(menuId) {
      $mdSidenav(menuId).toggle().then(function(){
        console.log('clicked:'+menuId);
      });
    };

    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
