package com.congsole.movie.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NationRepository extends JpaRepository<Nation, Long> {
    Nation findByNation(String nation);
}
