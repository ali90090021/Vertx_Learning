package ir.mindsheets.ch2_5;




import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.impl.logging.LoggerFactory;
import io.vertx.core.json.JsonObject;

public class SampleVerticle extends AbstractVerticle  {

 private final io.vertx.core.impl.logging.Logger logger = LoggerFactory.getLogger(SampleVerticle.class);
 
 @Override public void start() {
    
    logger.info("n = {"+config().getInteger("n", -1)+"}" );


}
 
    public static void main(String[] args) {

     Vertx vertx=Vertx.vertx();
     
     for (int i = 0; i < 4; i++) {
        JsonObject jsonObject=new JsonObject().put("n", i);
        DeploymentOptions deploymentOptions=new DeploymentOptions().setConfig(jsonObject).setInstances(i);
        vertx.deployVerticle("ir.mindsheets.ch2_5.SampleVerticle", deploymentOptions);
     }

    }


}
