package com.congsole.movie.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class Movie {
    private String movieName;
    private String posterUrl;
    private String plot;

    private LocalDateTime release;
    private String director;
    private List<String> cast;

    private List<Ott> ottList;
    private List<Rate> rateList;
}
