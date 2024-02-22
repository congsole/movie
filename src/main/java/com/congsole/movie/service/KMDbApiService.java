package com.congsole.movie.service;

import com.congsole.movie.KMDbDto.Data;

import com.congsole.movie.domain.Movie;
import com.congsole.movie.domain.MovieRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KMDbApiService {

    private final RestTemplate restTemplate;
    private final MovieRepository movieRepository;

    public void saveAllMovies(int startCount) {
        Data dto;
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp");
        URI uri;

        uriBuilder.queryParam("collection", "kmdb_new2");
        uriBuilder.queryParam("ServiceKey", "2EI1I9663MK056Y91EKI");
        uriBuilder.queryParam("listCount", 500);
        uriBuilder.queryParam("startCount", startCount);
        uriBuilder.queryParam("detail", "Y");
        uri = uriBuilder.build().encode().toUri();

        // api 호출
        String json = restTemplate.exchange(uri, HttpMethod.GET, null, String.class).getBody();

        try {
            // 결과값을 DTO로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            dto = objectMapper.readValue(json, Data.class);
            // DTO를 Entity로 변환
            List<Movie> movieList = dto.getResult().stream().map(Movie::from).collect(Collectors.toList());
            // DB에 저장
            for(Movie movie: movieList) {
                movieRepository.save(movie);
            }
        } catch(Exception e) {
            System.out.println("하하하 익셉션 발생");
            System.out.println(e.getMessage());
        }

    }

    public long countAllMovies() {
        return movieRepository.count();
    }

}




