package com.example.helloworld.resources;

import com.example.helloworld.core.HalLink;
import com.example.helloworld.core.RootRepresentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class RootResource {

    public RootResource() {
    }

    @GET
    public RootRepresentation get(@Context UriInfo uriInfo) {
        URI selfUri = uriInfo.getBaseUriBuilder()
                .path(RootResource.class)
                .build();

        URI helloWorldUri = uriInfo.getBaseUriBuilder()
                .path(HelloWorldResource.class)
                .build();

        HalLink selfLink = new HalLink("self", selfUri);
        HalLink helloWorldLink = new HalLink("hello", helloWorldUri);

        return new RootRepresentation(selfLink, helloWorldLink);
    }
}
