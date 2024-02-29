package com.congsole.movie.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long>  {
    Genre findByGenre(String genre);
}
