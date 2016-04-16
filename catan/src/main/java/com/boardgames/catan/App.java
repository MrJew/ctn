package com.boardgames.catan;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.net.NetServer;


public class App extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) {
        vertx
            .createHttpServer()
            .requestHandler(r -> {
                r.response().sendFile("web/index.html");
            })
            .listen(8080, result -> {
                if (result.succeeded()) {
                    fut.complete();
                } else {
                    fut.fail(result.cause());
                }
            });
        
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