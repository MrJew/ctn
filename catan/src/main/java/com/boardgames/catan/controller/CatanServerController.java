package com.boardgames.catan.controller;

import java.io.IOException;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Session;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CookieHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;

import com.boardgames.catan.gameSession.GameSession;
import com.boardgames.catan.services.GameSessionService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CatanServerController {
	
	private Router router;
	private Vertx vertx;
	private GameSessionService gameSessionService;
	private ObjectMapper jsonMapper;
	
	public CatanServerController (Vertx vertx) {
		this.vertx = vertx;
		router = Router.router(vertx);
		gameSessionService = GameSessionService.getInstance();
		jsonMapper = new ObjectMapper();
	}
	
	public void init(){
		setupGameSessionForTesting();
	    router.route().handler(CookieHandler.create());
	    router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));
	    router.route().handler(BodyHandler.create());
	    
	    // GET
	    router.get("/").handler(this::handleLobbyPage);
	    router.get("/games/:gameID").handler(this::getGameSession);
		router.get("/games").handler(this::getGameSessions);
		
	    // POST
	    router.post("/createSession").handler(this::createGameSession);
	    
	    router.getRoutes().forEach(r -> System.out.println(r));
	    router.route().handler(StaticHandler.create("web/").setCachingEnabled(false));
	}
	
	private void setupGameSessionForTesting() {
		GameSession gameSession = new GameSession("test","Catan",4);
		gameSession.setId("1461181799631");
		gameSession.addPlayer("test-session-id-01");
		gameSessionService.addGameSession(gameSession);
	}

	private void handleLobbyPage(RoutingContext routingContext){
	
        Session session = routingContext.session();
        System.out.println(session.id());

        Integer cnt = session.get("hitcount");
        cnt = (cnt == null ? 0 : cnt) + 1;

        session.put("hitcount", cnt);

        routingContext.response().putHeader("content-type", "text/html").sendFile("web/app/index.html");
        System.out.println(cnt);
	    
    }
	
	private void getGameSession(RoutingContext routingContext){
		String gameID = routingContext.request().getParam("gameID");
		String jsonString = gameSessionService.getGameSessionAsJson(gameID);
		System.out.println(jsonString);
		routingContext.response().putHeader("content-type", "application/json").end(jsonString);
	}
	
	private void getGameSessions(RoutingContext routingContext){
		String jsonString = gameSessionService.getGameSessionsAsJson();
		System.out.println(jsonString);
		routingContext.response().putHeader("content-type", "application/json").end(jsonString);
	}
	
	private void createGameSession(RoutingContext routingContext) {
		try {
			GameSession gameSession = jsonMapper.readValue(routingContext.getBodyAsString(), GameSession.class);
			String jsonString = gameSessionService.addGameSession(gameSession);
			System.out.println(jsonString);
			routingContext.response().putHeader("content-type", "application/json").end(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Router getRouter(){
		return router;
	}
	
	
    
	
}
