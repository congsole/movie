package com.congsole.movie.controller;

import com.congsole.movie.dto.RateDto;
import com.congsole.movie.service.NaverSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nv")
@RequiredArgsConstructor
public class NaverSearchController {

    private final NaverSearchService naverSearchService;

    @GetMapping("/rate/{movieName}")
    public ResponseEntity<RateDto> getRateFromNaver(@PathVariable("movieName") String movieName) {
        return ResponseEntity.ok(naverSearchService.getRateFromNaver(movieName));
    }
}
