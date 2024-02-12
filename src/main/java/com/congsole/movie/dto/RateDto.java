package com.congsole.movie.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RateDto {
    private String siteName;
    private double netizen_rate;
    private int netizen_rate10000;
    private int netizen_rate_number;
    private int netizen_rate_number_male;
    private int netizen_rate_number_female;
    private double audience_rate;
    private int audience_rate10000;
    private int audience_rate_number;
    private int audience_rate_number_male;
    private int audience_rate_number_female;


//    private int justWatch;
//    private int kinolights;
//    private int watcha;
//    private int naver_netizen;
//    private int naver_seriesOn;
//    private int google;
//    private int google_tomatometer;
//    private int google_TV;
//    private int imdb;

}
