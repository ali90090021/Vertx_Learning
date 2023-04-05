package ir.mindsheets.ch5_1;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;
import io.vertx.core.*;

public class Main extends AbstractVerticle {

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();
    
    vertx.deployVerticle("ir.mindsheets.ch5_1.HeatSensor",
        new DeploymentOptions().setConfig(new JsonObject().put("http.port", 3000)));
    vertx.deployVerticle("ir.mindsheets.ch5_1.HeatSensor",
        new DeploymentOptions().setConfig(new JsonObject().put("http.port", 3001)));
    vertx.deployVerticle("ir.mindsheets.ch5_1.HeatSensor",
        new DeploymentOptions().setConfig(new JsonObject().put("http.port", 3002)));
    vertx.deployVerticle("ir.mindsheets.ch5_1.SnapshotService");
    vertx.deployVerticle("ir.mindsheets.ch5_1.CollectorService");

  }

}
