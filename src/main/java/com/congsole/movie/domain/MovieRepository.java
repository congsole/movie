package com.congsole.movie.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findMoviesByProdYear(int year);
    List<Movie> findMoviesByTitleContaining(String keyword);

}
