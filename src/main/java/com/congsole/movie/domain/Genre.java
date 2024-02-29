package com.congsole.movie.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.checkerframework.common.aliasing.qual.Unique;

@Entity
@Getter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String genre;

    public Genre() {

    }
    private Genre(String genre) {
        this.genre = genre;
    }



    public static Genre of(String genre) {
        return new Genre(genre);
    }

}
