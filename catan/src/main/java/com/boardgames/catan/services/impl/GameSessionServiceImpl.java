package com.boardgames.catan.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.boardgames.catan.gameSession.GameSession;
import com.boardgames.catan.services.GameSessionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.vertx.core.json.JsonObject;

public class GameSessionServiceImpl implements GameSessionService{

	private List<GameSession> gameSessions;
	private ObjectMapper objectMapper;
	private static GameSessionServiceImpl gameSessionService = null;
	
	private GameSessionServiceImpl() {
		gameSessions = new ArrayList<>();
		objectMapper = new ObjectMapper();
	}
	
	public static GameSessionServiceImpl getInstance() {
	      if(gameSessionService == null) {
	         gameSessionService = new GameSessionServiceImpl();
	      }
	      return gameSessionService;
	}
		
	public String getGameSessionAsJson(String gameID) {
		Optional<GameSession> gameSessionOptional = gameSessions.stream().filter(gameSession -> gameSession.getId().equals(gameID)).findFirst();
		return extractJsonFromObject(gameSessionOptional.get());
	}
	
	public GameSession getGameSession(String gameID){
		return gameSessions.stream().filter(gameSession -> gameSession.getId().equals(gameID)).findFirst().get();
	}
	
	public String addGameSession(GameSession gameSession) {
		gameSessions.add(gameSession);
		return gameSession.getId();
	}
	
	public List<GameSession> getGameSessions(){
		return gameSessions;
	}
	
	public String getGameSessionsAsJson() {
		return extractJsonFromObject(gameSessions);
	}
	
	private String extractJsonFromObject(Object obj){
		String result = "{}";
		try {
			result = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
