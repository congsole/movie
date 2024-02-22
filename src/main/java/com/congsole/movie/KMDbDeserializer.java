package com.congsole.movie;

import com.congsole.movie.KMDbDto.Data;
import com.congsole.movie.KMDbDto.KMDbMovieList;
import com.congsole.movie.KMDbDto.Movie;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class KMDbDeserializer extends JsonDeserializer<Data> {
    @Override
    public Data deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode node = p.getCodec().readTree(p);


        int totalCount = node.findValue("TotalCount").asInt();
        int count = node.findValue("Count").asInt();

        JsonNode movieListNode = node.findValue("Result");
        List<Movie> movieList = Arrays.stream(objectMapper.treeToValue(movieListNode, Movie[].class)).toList();

        return new Data(totalCount, count, movieList);
    }
}
