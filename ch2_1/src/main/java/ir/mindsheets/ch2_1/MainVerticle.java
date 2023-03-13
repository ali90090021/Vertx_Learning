package ir.mindsheets.ch2_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {

  private final Logger logger = LoggerFactory.getLogger(MainVerticle.class);

  private long counter = 1;

  @Override
  public void start() {

    vertx.setPeriodic(5000, id -> {
      logger.info("tick");
    });

    vertx.createHttpServer()
      .requestHandler(req -> {
        logger.info("Request #{} from {}", counter++, req.remoteAddress().host());
        req.response().end("Hello!");
      })
      .listen(7070);

    logger.info("Open http://localhost:7070/");
  }

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

}
