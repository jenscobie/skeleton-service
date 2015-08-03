package com.example.helloworld.core;

public abstract class HalLinkRepresentationBase {

    private String name;

    private String uri;

    public HalLinkRepresentationBase() {
    }

    public HalLinkRepresentationBase(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }
}
