package com.congsole.movie.dto.KMDbDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rating {
    private String ratingMain;
    private String ratingDate;
    private String ratingGrade;
    private String releaseDate;
    private String runtime;
}
