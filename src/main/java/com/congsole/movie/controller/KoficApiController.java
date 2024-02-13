package com.congsole.movie.controller;

import com.congsole.movie.dto.MovieListResult;
import com.congsole.movie.service.KoficApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KoficApiController {
    private final KoficApiService koficApiService;

    @GetMapping("/saveAllMovies")
    public ResponseEntity<MovieListResult> saveAllMovies() {
        return ResponseEntity.ok(koficApiService.getAllMovieListDto(1));
    }
    @GetMapping("/saveNewMovies")
    public void saveNewMovies() {
        koficApiService.saveNewMovies();
    }
}
