package com.congsole.movie.controller;

import com.congsole.movie.dto.Ott;
import com.congsole.movie.service.GoogleSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Ott>> searchMovie(@PathVariable("movieName") String movieName) {
        List<Ott> ottList = googleSearchService.servicesAt(movieName);
        return ResponseEntity.ok(ottList);
    }
    @GetMapping("/{movieName}")
    public ResponseEntity<String> message(@PathVariable("movieName") String movieName) {
        return ResponseEntity.ok(movieName);
    }
}
