package com.example.helloworld.resources;

import com.example.helloworld.core.HalLinkRepresentation;
import com.example.helloworld.core.SayingRepresentation;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces("application/hal+json")
public class HelloWorldResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public SayingRepresentation sayHello(@QueryParam("name") Optional<String> name, @Context UriInfo uriInfo) {
        URI selfUri = uriInfo.getBaseUriBuilder()
                .path(HelloWorldResource.class)
                .build();

        HalLinkRepresentation selfLink = new HalLinkRepresentation("self", selfUri);

        final String value = String.format(template, name.or(defaultName));
        return new SayingRepresentation(counter.incrementAndGet(), value, selfLink);
    }
}
