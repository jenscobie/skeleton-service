package com.example.helloworld.resources;

import com.example.helloworld.core.CuriesLinkRepresentation;
import com.example.helloworld.core.HalLinkRepresentation;
import com.example.helloworld.core.RootRepresentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/")
@Produces("application/hal+json")
public class RootResource {

    public RootResource() {
    }

    @GET
    public RootRepresentation get(@Context UriInfo uriInfo) {
        String selfUri = uriInfo.getBaseUriBuilder()
                .path(RootResource.class)
                .build()
                .toASCIIString();

        String helloWorldUri = uriInfo.getBaseUriBuilder()
                .path(HelloWorldResource.class)
                .build()
                .toASCIIString();

        String curiesUri = "http://www.example.com/docs/{rel}";

        HalLinkRepresentation selfLink = new HalLinkRepresentation("self", selfUri);
        HalLinkRepresentation helloWorldLink = new HalLinkRepresentation("hello", helloWorldUri);
        CuriesLinkRepresentation curiesLink = new CuriesLinkRepresentation("doc", curiesUri, true);

        return new RootRepresentation(selfLink, helloWorldLink, curiesLink);
    }
}
