package com.boardgames.catan.controller;

import com.boardgames.catan.services.GameSessionService;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Session;
import io.vertx.ext.web.handler.CookieHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;

public class CatanServerController {
	
	private Router router;
	private Vertx vertx;
	private GameSessionService gameSessionService;
	
	public CatanServerController (Vertx vertx) {
		this.vertx = vertx;
		router = Router.router(vertx);
		gameSessionService = new GameSessionService();
	}
	
	public void init(){
	    router.route().handler(CookieHandler.create());
	    router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));
	    
	    router.get("/").handler(this::handleLobbyPage);
	    router.get("/games/:gameID").handler(this::getGameSession);
	    router.route().handler(StaticHandler.create("web/").setCachingEnabled(false));
	    
	    
	    
	}
	
	private void handleLobbyPage(RoutingContext routingContext){
	
        Session session = routingContext.session();

        Integer cnt = session.get("hitcount");
        cnt = (cnt == null ? 0 : cnt) + 1;

        session.put("hitcount", cnt);

        routingContext.response().putHeader("content-type", "text/html").sendFile("web/app/index.html");
        System.out.println(cnt);
	    
    }
	
	private void getGameSession(RoutingContext routingContext){
		
		
		String gameID = routingContext.request().getParam("gameID");
		System.out.println(gameID);
		String jsonString = gameSessionService.getJson(gameID);
		
		routingContext.response().putHeader("content-type", "application/json").end(jsonString);
	}
	
	public void createGameSession() {
		gameSessionService.newGameSession();
	}
	
	public Router getRouter(){
		return router;
	}
	
	
    
	
}
