package com.example.helloworld.resources;

import com.example.helloworld.core.HalLinkRespresentation;
import com.example.helloworld.core.RootRepresentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
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

        HalLinkRespresentation selfLink = new HalLinkRespresentation("self", selfUri);
        HalLinkRespresentation helloWorldLink = new HalLinkRespresentation("hello", helloWorldUri);

        return new RootRepresentation(selfLink, helloWorldLink);
    }
}
