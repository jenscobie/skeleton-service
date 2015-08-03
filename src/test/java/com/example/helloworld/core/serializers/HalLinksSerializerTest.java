package com.example.helloworld.core.serializers;

import com.example.helloworld.core.CuriesLinkRepresentation;
import com.example.helloworld.core.HalLinkRepresentation;
import com.example.helloworld.core.RootRepresentation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class HalLinksSerializerTest {

    private final String rootResourceJson = "{\"_links\":{\"self\":{\"href\":\"http://localhost:8080/\"}}}";

    private final String rootResourceWithCuriesJson = "{\"_links\":{\"curies\":[{\"name\":\"doc\",\"href\":\"http://localhost:8080/{rel}\",\"templated\":true}]}}";

    @Test
    public void shouldSerializeRegularHalLink() throws IOException {
        // Given
        String uri = "http://localhost:8080/";
        HalLinkRepresentation selfLink = new HalLinkRepresentation("self", uri);
        RootRepresentation rootRepresentation = new RootRepresentation(selfLink);
        ObjectMapper objectMapper = new ObjectMapper();

        // When
        String json = objectMapper.writeValueAsString(rootRepresentation);

        // Then
        assertThat(json, equalTo(rootResourceJson));
    }

    @Test
    public void shouldSerializeCurieHalLink() throws IOException {
        // Given
        String uri = "http://localhost:8080/{rel}";
        CuriesLinkRepresentation selfLink = new CuriesLinkRepresentation("doc", uri, true);
        RootRepresentation rootRepresentation = new RootRepresentation(selfLink);
        ObjectMapper objectMapper = new ObjectMapper();

        // When
        String json = objectMapper.writeValueAsString(rootRepresentation);

        // Then
        assertThat(json, equalTo(rootResourceWithCuriesJson));
    }
}