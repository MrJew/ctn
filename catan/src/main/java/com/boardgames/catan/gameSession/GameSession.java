package com.boardgames.catan.gameSession;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//@JsonSerialize(using = GameSessionSerializer.class)
public class GameSession {

	private String id;
	private String name;
	private String gameType;
	private Integer playerCount;
	private Map<String, String> players;
	
	public GameSession(){
		id = String.valueOf(System.currentTimeMillis());
	}
	
	public GameSession (String name, String gameType, Integer playerCount) {
		this();
		this.name = name;
		this.gameType = gameType;
		this.playerCount = playerCount;
		players = new HashMap<>(playerCount);
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
	
	public String addPlayer(String sessionID){
		return players.get(sessionID);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public Integer getPlayerCount() {
		return playerCount;
	}

	public void setPlayerCount(Integer playerCount) {
		this.playerCount = playerCount;
	}

	public Map<String, String> getPlayers() {
		return players;
	}

	public void setPlayers(HashMap<String, String> players) {
		this.players = players;
	}
	
}
