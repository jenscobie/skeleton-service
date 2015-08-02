package com.example.helloworld.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.core.UriInfo;

public class HalLink {

    private String name;

    private UriInfo href;

    public HalLink(String name, UriInfo href) {
        this.name = name;
        this.href = href;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getHref() {
        return href.getAbsolutePath().toString();
    }
}
