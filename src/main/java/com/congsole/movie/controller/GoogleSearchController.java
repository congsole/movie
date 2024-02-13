package com.congsole.movie.controller;

import com.congsole.movie.dto.MovieDto;
import com.congsole.movie.dto.OttDto;
import com.congsole.movie.dto.RateDto;
import com.congsole.movie.dto.WatchaDto;
import com.congsole.movie.service.GoogleSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GoogleSearchController {
    private final GoogleSearchService googleSearchService;
    @GetMapping("/coopang/{movieName}")
    public ResponseEntity<Boolean> searchCoopangPlay(@PathVariable("movieName") String movieName) {
        boolean result = googleSearchService.firstSearchedContentWithCoopangPlay(movieName);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/service/{movieName}")
    public ResponseEntity<List<OttDto>> searchMovie(@PathVariable("movieName") String movieName) {
        List<OttDto> ottDtoList = googleSearchService.servicesAt(movieName);
        return ResponseEntity.ok(ottDtoList);
    }
    @GetMapping("/{movieName}")
    public ResponseEntity<String> message(@PathVariable("movieName") String movieName) {
        return ResponseEntity.ok(movieName);
    }

    @GetMapping("/watcha")
    public ResponseEntity<RateDto> getRateFromWatchaPedia(@RequestParam String movieName, @RequestParam int releaseYear) {
        RateDto rateDto = googleSearchService.getWatchaRate(movieName,releaseYear);
        return ResponseEntity.ok(rateDto);
    }

    @GetMapping("/poster_plot")
    public ResponseEntity<WatchaDto> getPosterAndPlotFromWatchaPedia(@RequestParam String movieName, @RequestParam int releaseYear) {
        return ResponseEntity.ok(googleSearchService.getWatchaDto(movieName, releaseYear));
    }


}
