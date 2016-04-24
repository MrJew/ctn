package com.boardgames.catan.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.boardgames.catan.gameSession.GameSession;
import com.boardgames.catan.services.impl.GameSessionServiceImpl;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.http.impl.ServerWebSocketImpl;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetSocket;


public class CatanServerWebsockets implements Handler<ServerWebSocket>{

	final EventBus eventBus;
	List<String> session;
	GameSessionServiceImpl gameSessionService;
	
	public CatanServerWebsockets (Vertx vertx){
		eventBus = vertx.eventBus();
		session = new ArrayList<>();
		gameSessionService = GameSessionServiceImpl.getInstance();
	}
	
	@Override
	public void handle(final ServerWebSocket ws) {
		
		String id = ws.textHandlerID();
		session.add(id);
		System.out.println("Registering new ws connection for id: "+id);
		
		ws.closeHandler(new Handler<Void>(){
			@Override
			public void handle(Void event) {
				System.out.println("Closing hanlder");
			}
		});
		
		ws.handler(new Handler<Buffer>(){
			@Override
			public void handle(Buffer event) {
				JSONObject eventJson = new JSONObject(event.toString());
				System.out.println(id);
				String eventAction = eventJson.getString("action");
				System.out.println(eventAction);
				
				switch (eventAction) {
		            case "enrol_in_game_session":
		            	String playerColour = eventJson.getString("playerColour");
		            	String gameSessionID = eventJson.getString("gameSessionID");
		            	GameSession gs = gameSessionService.getGameSession(gameSessionID);
		            	gs.addPlayerSession(id, playerColour);
		            	System.out.println(String.format("Added player with id %s and colour %s to game %s", 
		            			id, playerColour, gameSessionID));
		            	eventBus.send(id, "You have been enrolled in game session #" + gameSessionID);
		                break;
		            case "roll_dice":
		            	for(String sessionId : session){
							eventBus.send(sessionId, "Dice roll 6");
						}
		            	break;
	                default:
	                	break;
				}
			}
		});
	}

	
}
