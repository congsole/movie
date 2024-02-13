package com.congsole.movie.service;

import com.congsole.movie.MovieListDeserializer;
import com.congsole.movie.domain.MovieRepository;
import com.congsole.movie.dto.MovieListResult;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class KoficApiService {

    private final RestTemplate restTemplate;
    private final MovieRepository movieRepository;
    private final MovieListDeserializer movieListDeserializer = new MovieListDeserializer();
    private final String KOFIC_MOVIE_LIST_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json";
    private final int PRESENT_YEAR = 2024;
    public MovieListResult getAllMovieListDto(int i) {
        int totalCount = 0;
        MovieListResult dto;
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(KOFIC_MOVIE_LIST_URL);
        URI uri;

        uriBuilder.queryParam("key", "450348d46e731be0b326340730caa5ba");
        uriBuilder.queryParam("openStartDt", 1000);
        uriBuilder.queryParam("openEndDt", PRESENT_YEAR);
        uriBuilder.queryParam("itemPerPage", 100);
        uriBuilder.queryParam("curPage", i);
        uri = uriBuilder.build().encode().toUri();
        System.out.println(uri);
        // api 호출
        String json = restTemplate.exchange(uri, HttpMethod.GET, null, String.class).getBody();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            dto = objectMapper.readValue(json, MovieListResult.class);
            totalCount = dto.getTotCnt();
            return dto;

        } catch(Exception e) {
            System.out.println("하하하 익셉션 발생");
            System.out.println(e.getMessage());
            return null;
        }

    }

    public void saveNewMovies() {
    }
}
