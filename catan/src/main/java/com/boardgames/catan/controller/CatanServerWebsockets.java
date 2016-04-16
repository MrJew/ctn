package com.boardgames.catan.controller;

import io.vertx.core.Vertx;
import io.vertx.core.net.NetServer;

public class CatanServerWebsockets {

	private Vertx vertx;
	
	public CatanServerWebsockets (Vertx vertx){
		this.vertx = vertx;
	}
	
	public void init(){
		NetServer server = vertx.createNetServer();
	    server.connectHandler(socket -> {
	      socket.handler(buffer -> {
	    	System.out.println(buffer);
	    	String host = String.format("IP-to ti bi trqbvalo da e %s", socket.remoteAddress().host());
	        socket.write(host).close();
	      });
	    });
	    server.listen(8081);
	}
}
