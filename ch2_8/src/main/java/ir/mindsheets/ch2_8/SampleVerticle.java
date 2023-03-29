package ir.mindsheets.ch2_8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.*;

// Sample 1
// public class SampleVerticle  {

//     private final static Logger  logger = LoggerFactory.getLogger(SampleVerticle.class);

//        public static void main(String[] args) {

//         Vertx vertx = Vertx.vertx();

//         vertx.getOrCreateContext().runOnContext(v-> logger.info("ABC"));

//         vertx.getOrCreateContext().runOnContext(v-> logger.info("123"));

//     }

// }

public class SampleVerticle {

  private final static Logger logger = LoggerFactory.getLogger(SampleVerticle.class);

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();

    Context context = vertx.getOrCreateContext();
    context.put("key", "value");

    context.exceptionHandler(t -> {
      if ("xxx".equals(t.getMessage())) {
        logger.info("xxx error");
      } else {
        logger.error("unhandel", t);
      }

    });

    context.runOnContext(v -> {
      throw new RuntimeException("xxx");
    });

    context.runOnContext(v -> {
      logger.info("key =" + context.get("key"));
    });

  }

}
