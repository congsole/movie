package com.congsole.movie.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class JustWatchPopular {
    private String name;
    private String imgUrl;
    private String url;
}
