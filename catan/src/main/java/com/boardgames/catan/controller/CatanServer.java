package com.boardgames.catan.controller;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;

public class CatanServer extends AbstractVerticle {
	
	@Override
    public void start(Future<Void> fut) {
		CatanServerController catanServerController = new CatanServerController(vertx);
		catanServerController.init();
		Router router = catanServerController.getRouter();
		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
		
		CatanServerWebsockets catanServerWebsockets = new CatanServerWebsockets(vertx);
		catanServerWebsockets.init();
		
	}
}
