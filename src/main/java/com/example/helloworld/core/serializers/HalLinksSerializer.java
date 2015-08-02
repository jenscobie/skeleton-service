package com.example.helloworld.core.serializers;

import com.example.helloworld.core.HalLink;
import com.example.helloworld.core.HalLinks;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class HalLinksSerializer extends JsonSerializer<HalLinks> {

    @Override
    public void serialize(HalLinks halLinks, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeStartObject();

        for (HalLink halLink : halLinks.getLinks())
            serialize(halLink, jsonGenerator);

        jsonGenerator.writeEndObject();
    }

    private void serialize(HalLink halLink, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeFieldName(halLink.getName());
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("href", halLink.getHref());
        jsonGenerator.writeEndObject();
    }
}
