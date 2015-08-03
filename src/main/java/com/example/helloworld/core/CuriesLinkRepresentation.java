package com.example.helloworld.core;

public class CuriesLinkRepresentation extends HalLinkRepresentationBase {

    private String name;

    private String uri;

    private Boolean templated;

    public CuriesLinkRepresentation(String name, String uri, Boolean templated) {
        this.name = name;
        this.uri = uri;
        this.templated = templated;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }

    public Boolean getTemplated() {
        return templated;
    }
}
