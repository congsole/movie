package com.congsole.movie;

import com.congsole.movie.dto.KoficMovieDto;
import com.congsole.movie.dto.MovieListResult;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MovieListDeserializer extends JsonDeserializer<MovieListResult> {

    @Override
    public MovieListResult deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode node = p.getCodec().readTree(p);
        JsonNode movieListNode = node.findValue("movieList");
        int totCnt = node.get("movieListResult").get("totCnt").asInt();
        String source = node.get("movieListResult").get("source").asText();
        List<KoficMovieDto> movieList = Arrays.stream(objectMapper.treeToValue(movieListNode, KoficMovieDto[].class)).toList();

        return new MovieListResult(totCnt, source, movieList);
    }
}
