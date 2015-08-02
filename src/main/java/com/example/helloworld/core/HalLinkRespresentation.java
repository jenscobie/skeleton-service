package com.example.helloworld.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

public class HalLinkRespresentation {

    private String name;

    private URI uri;

    public HalLinkRespresentation(String name, URI uri) {
        this.name = name;
        this.uri = uri;
    }

    @JsonProperty(value = "name")
    public String getName() {
        return name;
    }

    @JsonProperty(value = "href")
    public String getUri() {
        return uri.toString();
    }
}