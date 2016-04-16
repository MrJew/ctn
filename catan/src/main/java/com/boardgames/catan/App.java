package com.boardgames.catan;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.net.NetServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.Session;
import io.vertx.ext.web.handler.CookieHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;


public class App extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) {
//        vertx
//            .createHttpServer()
//            .requestHandler(r -> {
//                r.response().sendFile("web/index.html");
//            })
//            .listen(8080, result -> {
//                if (result.succeeded()) {
//                    fut.complete();
//                } else {
//                    fut.fail(result.cause());
//                }
//            });
        
        Router router = Router.router(vertx);

        router.route().handler(CookieHandler.create());
        router.route().handler(SessionHandler.create(LocalSessionStore.create(vertx)));
        router.route().handler(StaticHandler.create().setCachingEnabled(false));

        router.route().handler(routingContext -> {

          Session session = routingContext.session();

          Integer cnt = session.get("hitcount");
          cnt = (cnt == null ? 0 : cnt) + 1;

          session.put("hitcount", cnt);

          routingContext.response().putHeader("content-type", "text/html")
                                   .sendFile("webroot/index.html");
          System.out.println(cnt);
        });

        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
        
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