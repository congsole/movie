package com.congsole.movie.domain;

import jakarta.persistence.*;
import lombok.Getter;

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

    public static com.congsole.movie.dto.KMDbDto.Genre to(Genre genre) {
        return new com.congsole.movie.dto.KMDbDto.Genre(genre.getId(), genre.getGenre());
    }
}
