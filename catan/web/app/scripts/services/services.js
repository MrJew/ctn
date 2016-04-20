angular.module('webApp', [])
  .service('websocketService', ['$scope', '$mdSidenav', '$http', '$websocket', '$mdDialog', function($scope, $mdSidenav, $http, $websocket, $mdDialog) {
 
    this.handleSocket = function(websocket) {
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
  			ws.send(JSON.stringify({
          "action": "enrol_in_game_session",
          "playerColour": "blue",
          "gameSessionID": "1461181799631"}));
  		};
    }
  }]);