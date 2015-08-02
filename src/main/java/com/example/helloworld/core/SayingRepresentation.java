package com.example.helloworld.core;

import com.example.helloworld.core.serializers.HalLinksSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Length;

@JsonPropertyOrder({ "_links" })
public class SayingRepresentation {
    private long id;

    @Length(max = 3)
    private String content;

    private HalLinkRepresentation[] halLinks;

    public SayingRepresentation() {
    }

    public SayingRepresentation(long id, String content, HalLinkRepresentation... halLinks) {
        this.id = id;
        this.content = content;
        this.halLinks = halLinks;
    }

    @JsonProperty(value = "_links")
    @JsonSerialize(using = HalLinksSerializer.class)
    public HalLinksRepresentation getLinks() {
        return new HalLinksRepresentation(halLinks);
    }

    @JsonProperty(value = "id", index = 2)
    public long getId() {
        return id;
    }

    @JsonProperty(value = "content", index = 3)
    public String getContent() {
        return content;
    }
}