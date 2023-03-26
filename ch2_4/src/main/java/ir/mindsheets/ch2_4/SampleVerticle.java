package ir.mindsheets.ch2_4;




import io.vertx.core.AbstractVerticle;
import io.vertx.core.impl.logging.LoggerFactory;

public class SampleVerticle extends AbstractVerticle  {

 private final io.vertx.core.impl.logging.Logger logger = LoggerFactory.getLogger(SampleVerticle.class);
 
 @Override public void start() { logger.info("Start"); }
 
 @Override public void stop() { logger.info("Stop"); }


}
