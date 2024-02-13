package com.congsole.movie.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieNm;
    private LocalDate openDt;
    private String typeNm;
    private String nationAlt;
    private String genreAlt;
}
