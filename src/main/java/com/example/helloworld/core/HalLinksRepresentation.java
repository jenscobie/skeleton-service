package com.example.helloworld.core;

public class HalLinksRepresentation {

    private HalLinkRespresentation[] links;

    public HalLinksRepresentation(HalLinkRespresentation... links) {
        this.links = links;
    }

    public HalLinkRespresentation[] getLinks() {
        return links;
    }
}
