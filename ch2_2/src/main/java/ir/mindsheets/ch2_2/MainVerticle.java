package ir.mindsheets.ch2_2;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;

public class MainVerticle extends AbstractVerticle {



  @Override
  public void start() {

  vertx.setTimer(1000, id -> { while (true); });
  }

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

}
