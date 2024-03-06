package com.congsole.movie.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponseDto {
    private String docId;
    private String title;
    private String titleEng;
    private String titleOrg;
    private int prodYear;
    private String nation;
    private String company;
    private String plot;
    private int runtime;
    private String rating;
    private String genre;
    private String type;
    private String repRlsDate;
    private String keywords;
    private String poster;
    private String regDate;
    private String modDate;
    private double rate;
    private int rateNumber;
}
