package com.congsole.movie.controller;

import com.congsole.movie.service.GoogleSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/gg")
public class GoogleSearchController {
    private final GoogleSearchService googleSearchService;
    @GetMapping("/coopang/{movieName}")
    public ResponseEntity<Boolean> searchCoopangPlay(@PathVariable("movieName") String movieName) {
        boolean result = googleSearchService.firstSearchedContentWithCoopangPlay(movieName);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/watcha-rate")
    public ResponseEntity<Integer> addWatchaRates() {
        return ResponseEntity.ok(googleSearchService.addWatchaRates());
    }




}
