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

      $scope.colors = [
        {name:'white', color:'grey'},
        {name:'blue',color:'blue'},
        {name:'red',color:'red'},
        {name:'yellow', color:'yellow'},
        {name:'green', color: 'green'},
        {name:'brown', color: 'brown'}
      ];

      $scope.gameColors = function(playerCount){
        return $scope.colors.slice(0,playerCount);
      }

  		$scope.gameSessions = [];
  		$http.get("http://localhost:8080/games").success(function(data, status){
  	        $scope.gameSessions = data;
 	    });

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

  		$scope.joinSession = function(gameSessionId, color){
  			ws.send(JSON.stringify({
          "action": "enrol_in_game_session",
          "playerColour": color,
          "gameSessionID": gameSessionId}));
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
    $scope.dialog.gameType = "Sttlrs Ctn";
    $scope.dialog.playerCount=4;

    $scope.submit = function(){
      console.log($scope.dialog.toString());

      $http.post("http://localhost:8080/createSession", $scope.dialog).success(function(data, status){
        console.log("New session created:\n" + data)
        $scope.gameSessions.push(data);
      });
    };


  });
