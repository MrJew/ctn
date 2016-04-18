package com.boardgames.catan;

import java.util.ArrayList;
import java.util.List;

import com.boardgames.catan.controller.CatanServerController;
import com.boardgames.catan.controller.CatanServerWebsockets;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.buffer.impl.BufferFactoryImpl;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.ext.web.Router;

public class CatanServer extends AbstractVerticle {
	
	@Override
    public void start(Future<Void> fut) {
		// Initialise main Http server
		CatanServerController catanServerController = new CatanServerController(vertx);
		catanServerController.init();
		Router router = catanServerController.getRouter();
		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
		
		// Initialise WebSocket Http server
		CatanServerWebsockets catanServerWebsockets = new CatanServerWebsockets(vertx);
		vertx.createHttpServer().websocketHandler(catanServerWebsockets).listen(8081);
		
	}
}
