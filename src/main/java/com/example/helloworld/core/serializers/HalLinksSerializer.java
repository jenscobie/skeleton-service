package com.example.helloworld.core.serializers;

import com.example.helloworld.core.CuriesLinkRepresentation;
import com.example.helloworld.core.HalLinkRepresentation;
import com.example.helloworld.core.HalLinkRepresentationBase;
import com.example.helloworld.core.HalLinksRepresentation;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class HalLinksSerializer extends JsonSerializer<HalLinksRepresentation> {

    @Override
    public void serialize(HalLinksRepresentation halLinks, JsonGenerator jsonGenerator, SerializerProvider serializers) throws IOException {
        jsonGenerator.writeStartObject();

        serializeCuries(halLinks, jsonGenerator);
        serializeLinks(halLinks, jsonGenerator);

        jsonGenerator.writeEndObject();
    }

    private void serializeLinks(HalLinksRepresentation links, JsonGenerator jsonGenerator) throws IOException {
        Iterable<HalLinkRepresentation> regularLinks = Iterables.filter(Arrays.asList(links.getLinks()), HalLinkRepresentation.class);

        for (HalLinkRepresentation link : regularLinks)
            serializeLink(link, jsonGenerator);
    }

    private void serializeLink(HalLinkRepresentation link, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeFieldName(link.getName());
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("href", link.getUri());
        jsonGenerator.writeEndObject();
    }

    private void serializeCuries(HalLinksRepresentation links, JsonGenerator jsonGenerator) throws IOException {
        Collection<HalLinkRepresentationBase> curies = Collections2.filter(Arrays.asList(links.getLinks()), Predicates.instanceOf(CuriesLinkRepresentation.class));

        if (curies.isEmpty())
            return;

        jsonGenerator.writeFieldName("curies");
        jsonGenerator.writeStartArray();

        for (HalLinkRepresentationBase curie : curies)
            serializeCurie((CuriesLinkRepresentation)curie, jsonGenerator);

        jsonGenerator.writeEndArray();
    }

    private void serializeCurie(CuriesLinkRepresentation link, JsonGenerator jsonGenerator) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", link.getName());
        jsonGenerator.writeStringField("href", link.getUri());
        if (link.getTemplated()) {
            jsonGenerator.writeBooleanField("templated", true);
        }
        jsonGenerator.writeEndObject();
    }
}
