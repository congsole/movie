package com.congsole.movie.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KoficMovieDto {
    private String movieCd;
    private String movieNm;
    private String movieNmEn;
    private String prdtYear;
    private String openDt;
    private String typeNm;
    private String prdtStatNm;
    private String nationAlt;
    private String genreAlt;
    private String repNationNm;
    private String repGenreNm;
    private List<DirectorDto> directors;
    private List<CompanyDto> companys;
}
