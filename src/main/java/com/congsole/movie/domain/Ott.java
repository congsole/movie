package com.congsole.movie.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

@Entity
@Getter
public class Ott {

    @Id
    private String movieCd;
//    @OneToOne private Movie movie;

    @ColumnDefault("0") private char appleTV;
    @ColumnDefault("0") private char coopangPlay;
    @ColumnDefault("0") private char googleTv;
    @ColumnDefault("0") private char disneyPlus;
    @ColumnDefault("0") private char netflix;
    @ColumnDefault("0") private char tving;
    @ColumnDefault("0") private char watcha;
    @ColumnDefault("0") private char wavve;

    @ColumnDefault("0") private char laftel;
    @ColumnDefault("0") private char uPlusMobile;



}
