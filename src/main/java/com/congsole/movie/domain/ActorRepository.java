package com.congsole.movie.domain;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, String> {
    List<Actor> findAll(Sort sort);

    List<Actor> findDistinctByActorNmContaining(String inputtedNm);
}
