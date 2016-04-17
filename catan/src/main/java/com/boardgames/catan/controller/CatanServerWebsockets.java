package com.boardgames.catan.controller;

import java.util.ArrayList;
import java.util.List;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.http.impl.ServerWebSocketImpl;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetSocket;

public class CatanServerWebsockets implements Handler<ServerWebSocket>{

	final EventBus eventBus;
	List<String> session;
	
	public CatanServerWebsockets (Vertx vertx){
		eventBus = vertx.eventBus();
		session = new ArrayList<>();
		
	}
	
	@Override
	public void handle(final ServerWebSocket ws) {
		
		String id = ws.textHandlerID();
		session.add(id);
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
				for(String sessionId : session){
					eventBus.send(sessionId, "Dice roll 6");
				}
			}
		});
	}

	
}
