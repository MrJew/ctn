package com.boardgames.catan.gameSession;

public class GameSession {

	private String id;
	
	public GameSession () {
		id = String.valueOf(System.currentTimeMillis());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
