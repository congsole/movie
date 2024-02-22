package com.congsole.movie.domain;

import com.congsole.movie.KMDbDto.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    private String docId;
    private String title;
    private String titleEng;
    private String titleOrg;
    private int prodYear;
    private String nation;
    private String company;
    @Column(columnDefinition = "text NULL")
    private String plot;
    private int runtime;
    private String rating;
    private String genre;
    private String type;
    private String repRlsDate;
    private String keywords;
    @Column(columnDefinition = "text NULL")
    private String poster;
    private String regDate;
    private String modDate;
    private double rate;
    private int rateNumber;
    public Movie() {

    }

    public static Movie from(
            com.congsole.movie.KMDbDto.Movie movieDto) {
        return Movie.builder()
                .docId(movieDto.getDocId())
                .title(movieDto.getTitle())
                .titleEng(movieDto.getTitleEng())
                .prodYear(movieDto.getProdYear())
                .nation(movieDto.getNation())
                .company(movieDto.getCompany())
                .plot(movieDto.getPlots().getPlot().get(0).getPlotText())
                .runtime(movieDto.getRuntime())
                .rating(movieDto.getRating())
                .genre(movieDto.getGenre())
                .type(movieDto.getType())
                .repRlsDate(movieDto.getRepRlsDate())
                .keywords(movieDto.getKeywords())
                .poster(movieDto.getPosters())
                .build();
    }
    public void addRate(double rate, int rateNumber) {
        this.rate = rate;
        this.rateNumber = rateNumber;
    }
}
