package com.example.helloworld.core;

public class HalLinks {

    private HalLink[] links;

    public HalLinks(HalLink... links) {
        this.links = links;
    }

    public HalLink[] getLinks() {
        return links;
    }
}
