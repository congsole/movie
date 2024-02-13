package com.congsole.movie.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WatchaDto {
    private String posterUrl;
    private String plot;
}
