package com.github.pkomuda;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@Slf4j
@Path("/kafka")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class KafkaController {

    @Inject
    @Channel("test-topic")
    Emitter<String> stringEmitter;

    @POST
    public void produceEvent(String value) {
        stringEmitter.send(value);
    }

    @Incoming("test-topic")
    public void consumeEvent(String value) {
        log.info(value);
    }
}
