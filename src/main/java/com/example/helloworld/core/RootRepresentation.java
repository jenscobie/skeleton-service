package com.example.helloworld.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

public class RootRepresentation {

    private UriInfo href;

    public RootRepresentation(UriInfo href) {
        this.href = href;
    }

    @JsonProperty
    public List<HalLink> getLinks() {
        List<HalLink> links = new ArrayList<>();
        links.add(new HalLink("self", href));
        return links;
    }
}
