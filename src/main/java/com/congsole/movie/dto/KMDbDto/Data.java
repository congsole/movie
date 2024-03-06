package com.congsole.movie.dto.KMDbDto;


import com.congsole.movie.deserializer.KMDbDeserializer;
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
