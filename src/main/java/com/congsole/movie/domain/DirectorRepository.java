package com.congsole.movie.domain;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, String> {

    List<Director> findAll(Sort sort);

    List<Director> findDistinctByDirectorNmContaining(String inputtedNm);

    @Query(value=
            "SELECT distinct d.director_nm " +
                "FROM director d " +
                "WHERE d.director_nm like '%"+ ":inputtedNm"+"%'",
            nativeQuery=true)
    List<String> selectDistinctDirectorNmLike(String inputtedNm);

}
