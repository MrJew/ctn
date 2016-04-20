'use strict';

/**
 * @ngdoc function
 * @name webApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webApp
 */
angular.module('webApp')
  	.controller('MainCtrl', function ($scope, $mdSidenav, $http, $websocket, $mdDialog, websocketService) {

  		$scope.toggleSidenav = function(menuId) {
  			$mdSidenav(menuId).toggle().then(function(){
  				console.log('clicked:'+menuId);
  			});
  		};

  		$scope.showAddDialog = function(modalId){
  			$mdDialog.show({
  				scope: $scope,
  				templateUrl: 'app/template/add-modal.html',
  				controller: 'AddModalCtrl'
  			});
  		};

  		var ws = $websocket('ws://localhost:8081');
  		ws.binaryType = "arraybuffer";
  		websocketService.handleSocket(ws);

  		this.awesomeThings = [
	      'HTML5 Boilerplate',
	      'AngularJS',
	      'Karma'
	    ];
  })
  .controller('AddModalCtrl', function($scope, $httpParamSerializer, $http){
	  $scope.gameTypes = [
	            			"Sttlrs Ctn",
	            			"Cities and Knights",
	            			"Seafares"
	  ];
    $scope.playerCount = [2,3,4,5,6];

    $scope.dialog={};
    $scope.dialog.name="";
    $scope.dialog.gameType = "Sttlrs Ctn";
    $scope.dialog.playerCount=4;

    $scope.submit = function(){
      console.log($scope.dialog.toString());


      $http.post("http://localhost:8080/createSession", $scope.dialog).success(function(data, status){
        console.log("New session created:\n" + data.toString)
      });
    };


  });
