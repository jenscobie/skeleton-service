package com.example.helloworld.core.serializers;

import com.example.helloworld.core.HalLinkRespresentation;
import com.example.helloworld.core.RootRepresentation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.net.URI;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HalLinksSerializerTest {

    private final String rootResourceJson = "{\"_links\":{\"self\":{\"href\":\"http://localhost:8080/\"}}}";

    @Test
    public void shouldSerialize() throws IOException {
        // Given
        URI uri = UriBuilder.fromPath("http://localhost:8080/").build();
        UriInfo uriInfo = mock(UriInfo.class);
        when(uriInfo.getAbsolutePath()).thenReturn(uri);

        HalLinkRespresentation selfLink = new HalLinkRespresentation("self", uri);
        RootRepresentation rootRepresentation = new RootRepresentation(selfLink);
        ObjectMapper objectMapper = new ObjectMapper();

        // When
        String json = objectMapper.writeValueAsString(rootRepresentation);

        // Then
        assertThat(json, equalTo(rootResourceJson));
    }
}