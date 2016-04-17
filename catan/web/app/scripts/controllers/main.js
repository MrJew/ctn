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
  		/*$scope.addSession = function(){

  			var data = $.param({
  	                game: "Settlers of Cattan",
  	                players: 4,
  	        });

  			$http.post("http://localhost:8080/createSession", data).success(function(data, status){
  				console.log("New session created:\n" + data)
  			});
  		};*/

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
  .controller('AddModalCtrl', function($scope, $mdDialog){
	  $scope.gameTypes = [
	            			{'name':"Sttlrs Ctn"},
	            			{'name':"Cities and Knights"},
	            			{'name':"Seafares"}
	  ];
  });
