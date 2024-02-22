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
@JsonDeserialize(using = KMDbDeserializer.class)
public class Data {
//    private String CollName;
    private int TotalCount;
    private int Count;
    private List<Movie> Result;

}
