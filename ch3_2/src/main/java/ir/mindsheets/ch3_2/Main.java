package ir.mindsheets.ch3_2;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.*;

public class Main extends AbstractVerticle {

  public static void main(String[] args) {

    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle("ir.mindsheets.ch3_2.HeatSensor", new DeploymentOptions().setInstances(4));
    vertx.deployVerticle("ir.mindsheets.ch3_2.Listener");
    vertx.deployVerticle("ir.mindsheets.ch3_2.Sensordata");
    vertx.deployVerticle("ir.mindsheets.ch3_2.HttpServer");

  }

}
