package ir.mindsheets.ch2_6;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.impl.logging.LoggerFactory;


public class SampleVerticle extends AbstractVerticle {

    private final io.vertx.core.impl.logging.Logger logger = LoggerFactory.getLogger(SampleVerticle.class);

    @Override
    public void start() {

        vertx.setPeriodic(10_000, id -> {
            try {
                logger.info("Zzz...");
                Thread.sleep(8000);
                logger.info("Up!");
            } catch (InterruptedException e) {
                logger.error("Woops", e);
            }
        });

    }

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
            DeploymentOptions deploymentOptions = new DeploymentOptions().setInstances(2).setWorker(true);
            vertx.deployVerticle("ir.mindsheets.ch2_6.SampleVerticle", deploymentOptions);
        

    }

}
