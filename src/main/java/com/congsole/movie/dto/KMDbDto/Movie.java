package com.congsole.movie.dto.KMDbDto;

import com.congsole.movie.deserializer.MovieDtoDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonDeserialize(using = MovieDtoDeserializer.class)

public class Movie {
    private String docId;
//    private String movieId;
//    private String movieSeq;
    private String title;
    private String titleEng;
    private String titleOrg;
//    private String titleEtc;
    private int prodYear;
    private Directors directors;
    private Actors actors;
    private String nation;
    private String company;
    private Plots plots;
    private int runtime;
    private String rating;
    private String genre;
//    private String kmdbUrl;
    private String type;
//    private String use;
//    private String episodes;
//    private String ratedYn;
//    private String repRatDate;
    private String repRlsDate;
//    private Ratings ratings;
    private String keywords;
    private String posters;
//    private Staffs staffs;
//    private Vods vods;

//    private String openThtr;
//    private List<Stat> stat;
//    private String screenArea;
//    private String screenCnt;
//    private String salesAcc;
//    private String audiAcc;
//    private String statSouce;
//    private String statDate;
//    private String themeSong;
//    private String soundtrack;
//    private String fLocation;
//    private String Awards1;
//    private String Awards2;
    private String regDate;
    private String modDate;


//    private Codes Codes;
//    private CommCodes CommCodes;
//    private String ALIAS;

}
