package com.boardgames.catan.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.boardgames.catan.gameSession.GameSession;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.vertx.core.json.JsonObject;

public class GameSessionService {

	private List<GameSession> gameSessions;
	private ObjectMapper objectMapper;
	
	public GameSessionService() {
		gameSessions = new ArrayList<>();
		objectMapper = new ObjectMapper();
	}
		
	public String getJson(String gameID) {
		Optional<GameSession> gameSessionOptional = gameSessions.stream().filter(gameSession -> gameSession.getId().equals(gameID)).findFirst();
		return extractJsonFromObject(gameSessionOptional.get());
	}
	
	public String addGameSession() {
		GameSession gameSession = new GameSession();
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
	
}
