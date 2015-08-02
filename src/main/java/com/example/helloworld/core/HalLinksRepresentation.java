package com.example.helloworld.core;

public class HalLinksRepresentation {

    private HalLinkRepresentation[] links;

    public HalLinksRepresentation(HalLinkRepresentation... links) {
        this.links = links;
    }

    public HalLinkRepresentation[] getLinks() {
        return links;
    }
}
