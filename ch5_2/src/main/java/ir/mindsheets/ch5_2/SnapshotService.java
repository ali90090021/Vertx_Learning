package ir.mindsheets.ch5_2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;

public class SnapshotService extends AbstractVerticle {

    private final Logger logger = LoggerFactory.getLogger(SnapshotService.class);

    @Override
    public void start() throws Exception {

        vertx.createHttpServer()
                .requestHandler(req -> {
                    if (badRequest(req)) {
                        req.response().setStatusCode(400).end();
                    }

                    req.bodyHandler(buffer -> {
                        logger.info("Latest temperatures: {}", buffer.toJsonObject().encodePrettily());
                        req.response().end();
                    });

                })
                .listen(config().getInteger("http.port", 4000));

    }

    private boolean badRequest(HttpServerRequest req) {
        return !req.method().equals(HttpMethod.POST) || !"application/json".equals(req.getHeader("Content-Type"));
    }

}
