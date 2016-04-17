package com.boardgames.catan.gameSession;

import java.util.HashMap;

public class GameSession {

	private String id;
	private HashMap<String, String> players;
	
	public GameSession () {
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
