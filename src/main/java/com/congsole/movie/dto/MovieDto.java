package com.congsole.movie.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class MovieDto {
    private String movieName;
    private String posterUrl;
    private String plot;

    private LocalDate release;
    private String director;
    private List<String> cast;

    private List<OttDto> ottDtoList;
    private List<RateDto> rateDtoList;
}
