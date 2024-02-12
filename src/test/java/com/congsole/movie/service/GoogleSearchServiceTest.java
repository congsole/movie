package com.congsole.movie.service;

import com.congsole.movie.dto.MovieDto;
import com.congsole.movie.dto.RateDto;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GoogleSearchServiceTest")
@SpringBootTest
class GoogleSearchServiceTest {
    @Autowired
    private GoogleSearchService googleSearchService;
    @Test
    void givenMovieDto_whenRequestWatchRate_thenReturnRateDto() {
        MovieDto movieDto = MovieDto.builder()
                .movieName("찰리와 초콜릿 공장")
                .release(LocalDate.of(2005,9,16))
                .build();

        RateDto rateDto = googleSearchService.getWatchaRate(movieDto.getMovieName(), movieDto.getRelease().getYear());
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(rateDto.getNetizen_rate()).isBetween(1.0, 5.0);
            softly.assertThat(rateDto.getNetizen_rate_number()).isBetween(0, 100000000);
        });
    }
}