package com.congsole.movie.KMDbDto;

import com.congsole.movie.KMDbDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class KMDbMovieList {
    private String Query;
    private String KMAQuery;
    private int TotalCount;
    private List<Data> Data;
}
