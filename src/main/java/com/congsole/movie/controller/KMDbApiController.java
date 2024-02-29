package com.congsole.movie.controller;

import com.congsole.movie.KMDbDto.Data;
import com.congsole.movie.service.KMDbApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kmdb")
public class KMDbApiController {
    private final KMDbApiService kmDbApiService;

    @GetMapping("/saveAllMovies")
    public ResponseEntity<Long> saveAllMovies() {
        double totalPage = Math.ceil(104408.0/500.0);
        for(int i = 0; i <= totalPage; i++) {
            kmDbApiService.saveAllMovies(500*i);
        }
        return ResponseEntity.ok(kmDbApiService.countAllMovies());
    }

    @GetMapping("/saveAllActorsAndDirectors")
    public ResponseEntity<?> saveAllActorsAndDirectors() {
        double totalPage = Math.ceil(104408.0/500.0);
        for(int i = 0; i <= totalPage; i++) {
            kmDbApiService.saveAllActorsAndDirectors(500*i);
        }
        return ResponseEntity.ok("");
    }

    @GetMapping("/saveAllGenreAndNation")
    public ResponseEntity<?> saveAllGenreAndNation() {
        double totalPage = Math.ceil(104408.0/500.0);
        for(int i = 0; i <= totalPage; i++) {
            kmDbApiService.saveAllGenreAndNation(500*i);
        }
        return ResponseEntity.ok("");
    }
}
