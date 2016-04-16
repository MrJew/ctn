package com.boardgames.catan.controller;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetSocket;

public class CatanServerWebsockets {

	private Vertx vertx;
	
	public CatanServerWebsockets (Vertx vertx){
		this.vertx = vertx;
	}
	
	public void init(){
		NetServer server = vertx.createNetServer();
	    server.connectHandler(socket -> {
	      socket.write("Dobre do6yl.");
	      EventBus eb = vertx.eventBus();
	      eb.consumer("roll_dice", message -> {
	    	  System.out.println("Polu4ih tova: " + message.body());
	    	  socket.write(message.body().toString());
	      });
	      socket.handler(buffer -> {
		    	System.out.println(buffer);
		        eb.publish("roll_dice", buffer);
		      });
	    });
	    server.listen(8081);
	}
	
	private void socketHandler(Handler<NetSocket> socket){
		
	}
}
