package com.congsole.movie.service;

import com.congsole.movie.domain.Movie;
import com.congsole.movie.domain.MovieRepository;
import com.congsole.movie.dto.watchaPediaDto.RateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("GoogleSearchServiceTest")
@SpringBootTest
class GoogleSearchServiceTest {
    @Autowired
    private GoogleSearchService googleSearchService;
    @Autowired
    private MovieRepository movieRepository;

    @Test
    void test() {
        // given
        Movie movie = Movie.builder().title("털").prodYear(2004).build();

        // when
        RateDto rateDto = googleSearchService.searchWatchaRates(movie.getTitle(), movie.getRepRlsDate().substring(0, 4));
        movie.addRate(rateDto.getRate(), rateDto.getRateNumber());
//        Movie saved = movieRepository.save(movie);

        // then
        assertThat(movie.getRate()).isEqualTo(3.0);
        assertThat(movie.getRateNumber()).isEqualTo(3774);
    }

}