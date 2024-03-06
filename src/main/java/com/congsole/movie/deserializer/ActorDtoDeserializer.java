package com.congsole.movie.deserializer;

import com.congsole.movie.dto.KMDbDto.Actor;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ActorDtoDeserializer extends JsonDeserializer<Actor> {
    @Override
    public Actor deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode node = p.getCodec().readTree(p);
        JsonNode actorsNode = node.findValue("actors").findValue("actor");
        String actorNm = actorsNode.findValue("actorNm").asText();
        String actorEnNm = actorsNode.findValue("actorEnNm").asText();
        String actorId = actorsNode.findValue("actorId").asText();



        return new Actor(actorId, actorNm, actorEnNm);
    }
}
