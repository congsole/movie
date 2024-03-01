package com.congsole.movie.KMDbDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchRequestDto {
    private String director;
    private String actor;
    private String genre;
    private String nation;
//    private String releaseDts;
//    private String releaseDte;
//    private double rateStart;
//    private double rateEnd;


}
