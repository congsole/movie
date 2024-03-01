package com.congsole.movie.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long>  {
    Genre findByGenre(String genre);

    List<Genre> findByGenreContaining(String inputtedGenre);
}
