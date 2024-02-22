package com.congsole.movie;

import com.congsole.movie.KMDbDto.Movie;
import com.congsole.movie.KMDbDto.Plot;
import com.congsole.movie.KMDbDto.Plots;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
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
        int runtime = node.findValue("runtime").asInt();
        String rating = node.findValue("rating").asText();
        String genre = node.findValue("genre").asText();
        String type = node.findValue("type").asText();
        String repRlsDate = node.findValue("repRlsDate").asText();
        String keywords = node.findValue("keywords").asText();
        String posters = node.findValue("posters").asText();
        String regDate = node.findValue("regDate").asText();
        String modDate = node.findValue("modDate").asText();



        return new Movie(docid, title, titleEng, titleOrg, prodYear, nation, company, plots, runtime, rating, genre, type,
                repRlsDate, keywords, posters, regDate, modDate);
    }
}
