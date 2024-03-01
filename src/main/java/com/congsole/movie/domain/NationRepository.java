package com.congsole.movie.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface NationRepository extends JpaRepository<Nation, Long> {
    Nation findByNation(String nation);

    List<Nation> findByNationContaining(String inputtedNation);
}
