package com.boardgames.catan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.boardgames.catan.gameSession.GameSession;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.vertx.core.json.JsonObject;

public class GameSessionService {

	private List<GameSession> gameSessions;
	private ObjectMapper objectMapper;
	private static GameSessionService gameSessionService = null;
	
	private GameSessionService() {
		gameSessions = new ArrayList<>();
		objectMapper = new ObjectMapper();
	}
	
	public static GameSessionService getInstance() {
	      if(gameSessionService == null) {
	         gameSessionService = new GameSessionService();
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
		return extractJsonFromObject(gameSession);
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
	
	public GameSession getGameSessionInstance(String gameID){
		Optional<GameSession> gameSessionOptional = gameSessions.stream().filter(gameSession -> gameSession.getId().equals(gameID)).findFirst();
		GameSession gs = null;
		try {
			gs = gameSessionOptional.get();
		} catch (NoSuchElementException e){
			e.printStackTrace();
		}
		return gs;
	}
	
	public List<GameSession> getGameSessions(){
		return gameSessions;
	}
	
	public String getGameSessionsAsJson() {
		return extractJsonFromObject(gameSessions);
	}
	
}
