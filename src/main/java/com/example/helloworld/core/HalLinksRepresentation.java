package com.example.helloworld.core;

public class HalLinksRepresentation {

    private HalLinkRepresentationBase[] links;

    public HalLinksRepresentation(HalLinkRepresentationBase... links) {
        this.links = links;
    }

    public HalLinkRepresentationBase[] getLinks() {
        return links;
    }
}
