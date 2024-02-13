package com.congsole.movie.dto;

import com.congsole.movie.MovieListDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(using = MovieListDeserializer.class)
public class MovieListResult {
     public int totCnt;
     public String source;
     public List<KoficMovieDto> movieList;
}
