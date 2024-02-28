package com.congsole.movie.deserializer;

import com.congsole.movie.KMDbDto.*;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MovieDtoDeserializer extends JsonDeserializer<Movie> {
    @Override
    public Movie deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode node = p.getCodec().readTree(p);
        String docid = node.findValue("DOCID").asText();
        String title = node.findValue("title").asText();
        String titleEng = node.findValue("titleEng").asText();
        String titleOrg = node.findValue("titleOrg").asText();
        int prodYear = node.findValue("prodYear").asInt();
        String nation = node.findValue("nation").asText();
        String company = node.findValue("company").asText();

        JsonNode plotsNode = node.findValue("plots").findValue("plot");
        String plotLang = plotsNode.findValue("plotLang").asText();
        String plotText = plotsNode.findValue("plotText").asText();
        Plot plot = new Plot(plotLang, plotText);
        Plots plots = new Plots(List.of(plot));

        JsonNode actorListNode = node.findValue("actors").findValue("actor");
        List<Actor> actorList = Arrays.stream(objectMapper.treeToValue(actorListNode, Actor[].class)).toList();
        Actors actors = new Actors(actorList);

        JsonNode directorListNode = node.findValue("directors").findValue("director");
        List<Director> directorList = Arrays.stream(objectMapper.treeToValue(directorListNode, Director[].class)).toList();
        Directors directors = new Directors(directorList);

        int runtime = node.findValue("runtime").asInt();
        String rating = node.findValue("rating").asText();
        String genre = node.findValue("genre").asText();
        String type = node.findValue("type").asText();
        String repRlsDate = node.findValue("repRlsDate").asText();
        String keywords = node.findValue("keywords").asText();
        String posters = node.findValue("posters").asText();
        String regDate = node.findValue("regDate").asText();
        String modDate = node.findValue("modDate").asText();



        return new Movie(docid, title, titleEng, titleOrg, prodYear, directors, actors, nation, company, plots, runtime, rating, genre, type,
                repRlsDate, keywords, posters, regDate, modDate);
    }
}
