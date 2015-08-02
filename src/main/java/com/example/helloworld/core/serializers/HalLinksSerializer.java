package com.example.helloworld.core.serializers;

import com.example.helloworld.core.HalLinkRespresentation;
import com.example.helloworld.core.HalLinksRepresentation;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class HalLinksSerializer extends JsonSerializer<HalLinksRepresentation> {

    @Override
    public void serialize(HalLinksRepresentation halLinks, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeStartObject();

        for (HalLinkRespresentation halLink : halLinks.getLinks())
            serialize(halLink, jsonGenerator);

        jsonGenerator.writeEndObject();
    }

    private void serialize(HalLinkRespresentation halLink, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeFieldName(halLink.getName());
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("href", halLink.getUri());
        jsonGenerator.writeEndObject();
    }
}
