'use strict';

/**
 * @ngdoc function
 * @name webApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the webApp
 */
angular.module('webApp')
  	.controller('MainCtrl', function ($scope, $mdSidenav, $http, $websocket, $mdDialog) {

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
  		ws.onMessage(function(message) {
  	        console.log("DATA" + message.data);
  	     });

  		ws.onError(function(message){
  			console.log("Error:" + message);
  		});

  		ws.onClose(function(message){
  			console.log("Close:" + message);
  		});

  		ws.onOpen(function(message){
  			console.log("Open:" + message);
  		});

  		$scope.rollDice = function(){
  			ws.send(JSON.stringify({ action: 'roll_dice' }));
  		};

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
    $scope.dialog.selectedGameType = "Sttlrs Ctn";
    $scope.dialog.selectedPlayerCount=4;

    $scope.submit = function(){
      console.log($scope.dialog.toString());

      var data = $httpParamSerializer($scope.dialog);

      $http({
        method: 'POST',
        url: "http://localhost:8080/createSession",
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        data: data
      }).success(function(data, status){
        console.log("New session created:\n" + data)
      });
    }
  });
