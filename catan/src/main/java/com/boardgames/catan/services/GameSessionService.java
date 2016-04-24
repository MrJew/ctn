package com.boardgames.catan.services;

import java.util.List;

import com.boardgames.catan.gameSession.GameSession;

public interface GameSessionService {
	
	
	/**
	 * Retrieve all game sessions
	 * @return
	 */
	List<GameSession> getGameSessions();
	
	/**
	 * Retrieve all game sessions as JSON
	 * @return
	 */
	String getGameSessionsAsJson();
	
	/**
	 * Gets games session by gameID
	 * @param gameID
	 * @return
	 */
	GameSession getGameSession(String gameID);
	
	/**
	 *  Get game session as JSON from gameID
	 * @param gameID
	 * @return
	 */
	String getGameSessionAsJson(String gameID);
	
	/**
	 *  Add a game session and retrieve id;
	 * @param gameSession
	 * @return
	 */
	String addGameSession(GameSession gameSession);
}
