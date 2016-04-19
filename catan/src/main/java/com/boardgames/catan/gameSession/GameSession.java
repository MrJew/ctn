package com.boardgames.catan.gameSession;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class GameSession {

	private String id;
	
	@JsonUnwrapped
	@JsonSerialize(as=GameConfiguration.class)
	private GameConfiguration configuration;
	
	private HashMap<String, String> players;
	
	public GameSession (GameConfiguration configuration) {
		id = String.valueOf(System.currentTimeMillis());
		players = new HashMap<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void addPlayerSession(String playerSession, String colour){
		players.put(playerSession, colour);
	}
	
	public String getPlayerColour(String sessionID){
		return players.get(sessionID);
	}
	
	
	
}
