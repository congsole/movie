package com.congsole.movie.controller;

import com.congsole.movie.KMDbDto.Data;
import com.congsole.movie.KMDbDto.Movie;
import com.congsole.movie.KMDbDto.Nation;
import com.congsole.movie.KMDbDto.SearchRequestDto;
import com.congsole.movie.service.KMDbApiService;
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
    public ResponseEntity<String> searchRough(HttpServletRequest request) throws JSONException {
        SearchRequestDto dto = new SearchRequestDto(
                request.getParameter("director"),
                request.getParameter("actor"),
                request.getParameter("genre"),
                request.getParameter("nation")
        );

        System.out.println(dto.getActor());

        List<com.congsole.movie.KMDbDto.Movie> movieList = kmDbApiService.searchRough(dto);
        JSONArray jsonArr = new JSONArray();
        if(movieList != null) {
            for(Movie movie : movieList) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("docId", movie.getDocId());
                jsonArr.put(jsonObj);
                System.out.println(movie.getDocId());
            }
        }

        return ResponseEntity.ok(jsonArr.toString());
    }
}
