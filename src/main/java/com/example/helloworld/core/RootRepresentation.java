package com.example.helloworld.core;

import com.example.helloworld.core.serializers.HalLinksSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.ws.rs.core.UriInfo;

public class RootRepresentation {

    private UriInfo href;

    public RootRepresentation(UriInfo href) {
        this.href = href;
    }

    @JsonProperty(value = "_links")
    @JsonSerialize(using = HalLinksSerializer.class)
    public HalLinks getLinks() {
        HalLink self = new HalLink("self", href);
        return new HalLinks(self);
    }
}
