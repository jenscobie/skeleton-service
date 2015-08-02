package com.example.helloworld.core;

import com.example.helloworld.core.serializers.HalLinksSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class RootRepresentation {

    private HalLink[] halLinks;

    public RootRepresentation(HalLink... halLinks) {
        this.halLinks = halLinks;
    }

    @JsonProperty(value = "_links")
    @JsonSerialize(using = HalLinksSerializer.class)
    public HalLinks getLinks() {
        return new HalLinks(halLinks);
    }
}
