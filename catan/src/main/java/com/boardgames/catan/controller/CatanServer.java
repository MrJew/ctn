package com.boardgames.catan.controller;

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
		CatanServerController catanServerController = new CatanServerController(vertx);
		catanServerController.init();
		
		CatanServerWebsockets catanServerWebsockets = new CatanServerWebsockets(vertx);
		//catanServerWebsockets.init();
		
		Router router = catanServerController.getRouter();
		
		final EventBus eventBus = vertx.eventBus();
		
		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
		vertx.createHttpServer().websocketHandler(new Handler<ServerWebSocket>(){
			
			
			@Override
			public void handle(final ServerWebSocket ws) {
				
				String id = ws.textHandlerID();
				System.out.println("Registering new ws connection for id: "+id);
				
				ws.closeHandler(new Handler<Void>(){
					@Override
					public void handle(Void event) {
						System.out.println("Closing hanlder");
					}
				});
				
				ws.handler(new Handler<Buffer>(){
					@Override
					public void handle(Buffer event) {
						System.out.println(event.toString());
						eventBus.send(id, "Dice roll 6");
					}
				});
			}
		
		}).listen(8081);
	}
	
	private void test(ServerWebSocket request){
		System.out.println(request.path());
		BufferFactoryImpl buffer = new BufferFactoryImpl();
		request.write(buffer.buffer("TASHAK"));
	}
}
