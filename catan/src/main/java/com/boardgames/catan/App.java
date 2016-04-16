package com.boardgames.catan;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;


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
    }

}