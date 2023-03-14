package ir.mindsheets.ch2_3;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {

    vertx.createHttpServer().requestHandler(req -> req.response().end("OK")).listen(7070, ar -> {
      if (ar.succeeded())
        startPromise.complete();
      else
        startPromise.fail(ar.cause());
    });

  }

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

}
