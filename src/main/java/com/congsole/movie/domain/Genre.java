package com.congsole.movie.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Genre {
    @Id
    private Long id;
    private String genre;
}
