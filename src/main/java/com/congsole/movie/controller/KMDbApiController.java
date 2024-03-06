package com.congsole.movie.controller;

import com.congsole.movie.dto.KMDbDto.Movie;
import com.congsole.movie.dto.SearchRequestDto;
import com.congsole.movie.service.KMDbApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value="/searchRough", produces="text/plain;charset=UTF-8")
    public ResponseEntity<String> searchRough(HttpServletRequest request) throws JSONException, JsonProcessingException {
        SearchRequestDto dto = new SearchRequestDto(
                request.getParameter("director"),
                request.getParameter("actor"),
                request.getParameter("genre"),
                request.getParameter("nation")
        );

        System.out.println(dto.getActor());

        List<Movie> movieList = kmDbApiService.searchRough(dto);

        System.out.println(movieList);

        ObjectMapper mapper = new ObjectMapper();
        return ResponseEntity.ok(mapper.writeValueAsString(movieList)); //List -> JSONString
    }
}
