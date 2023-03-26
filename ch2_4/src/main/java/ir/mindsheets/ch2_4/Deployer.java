package ir.mindsheets.ch2_4;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.impl.logging.Logger;

public class Deployer extends AbstractVerticle {

    private final Logger logger = LoggerFactory.getLogger(Deployer.class);

    @Override
    public void start() throws Exception {
        long delay = 1000;
        for (int i = 1; i < 50; i++) {
            vertx.setTimer(delay, id -> deploy());
            delay += 1000;
        }

    }

    private void deploy() {
        vertx.deployVerticle(new SampleVerticle(), ar -> {
            if (ar.succeeded()) {
                String id = ar.result();
                logger.info("Successfully deployed {" + id + "}");
                vertx.setTimer(5000, tid -> undeployLater(id));
            } else {

            }
        });
    }

    private void undeployLater(String id) {
        vertx.undeploy(id, ar -> {
            if (ar.succeeded()) {
                logger.info("{" + id + "} was undeployed");
            } else {
                logger.error("{" + id + "} could not be undeployed");
            }
        });
    }


    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new Deployer());
      }
}
