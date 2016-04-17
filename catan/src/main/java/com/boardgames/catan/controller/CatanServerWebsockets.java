package com.boardgames.catan.controller;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.impl.ServerWebSocketImpl;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetSocket;

public class CatanServerWebsockets {

	private Vertx vertx;
	
	public CatanServerWebsockets (Vertx vertx){
		this.vertx = vertx;
	}
	
	public void init(){
	}
	
}
