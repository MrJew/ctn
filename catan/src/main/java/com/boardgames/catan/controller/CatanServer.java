package com.boardgames.catan.controller;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.buffer.impl.BufferFactoryImpl;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.ext.web.Router;

public class CatanServer extends AbstractVerticle {
	
	@Override
    public void start(Future<Void> fut) {
		CatanServerController catanServerController = new CatanServerController(vertx);
		catanServerController.init();
		
		CatanServerWebsockets catanServerWebsockets = new CatanServerWebsockets(vertx);
		//catanServerWebsockets.init();
		
		Router router = catanServerController.getRouter();
		
		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
		vertx.createHttpServer().websocketHandler(this::test).listen(8081);
		
	}
	
	private void test(ServerWebSocket request){
		System.out.println(request.path());
		BufferFactoryImpl buffer = new BufferFactoryImpl();
		request.write(buffer.buffer("TASHAK"));
	}
}
