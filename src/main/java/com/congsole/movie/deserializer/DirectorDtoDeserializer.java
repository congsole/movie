package com.congsole.movie.deserializer;

import com.congsole.movie.dto.KMDbDto.Director;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class DirectorDtoDeserializer extends JsonDeserializer<Director> {
    @Override
    public Director deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode node = p.getCodec().readTree(p);
        JsonNode directorsNode = node.findValue("directors").findValue("director");
        String directorNm = directorsNode.findValue("directorNm").asText();
        String directorEnNm = directorsNode.findValue("directorEnNm").asText();
        String directorId = directorsNode.findValue("directorId").asText();



        return new Director(directorId, directorNm, directorEnNm);
    }
}
