package com.congsole.movie.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, String> {
    List<Movie> findMoviesByProdYear(int year);
    List<Movie> findMoviesByTitleContaining(String keyword);
    List<Movie> findMoviesByProdYearBetween(int year1, int year2);

    List<Movie> findMoviesByProdYearBetweenAndRateBetweenAndRateNumberBetweenAndDocIdInOrderByRateDesc(int yearInputLeft, int yearInputRight,
                                                                                                       double rateInputLeft, double rateInputRight,
                                                                                                       int rateNumberInputLeft, int rateNumberInputRight,
                                                                                                       String[] selectedDocIdList);
    List<Movie> findMoviesByProdYearBetweenAndRateBetweenAndRateNumberBetweenOrderByRateDesc(int yearInputLeft, int yearInputRight,
                                                                                                       double rateInputLeft, double rateInputRight,
                                                                                                       int rateNumberInputLeft, int rateNumberInputRight);

}
