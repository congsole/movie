package com.congsole.movie.service;

import com.congsole.movie.KMDbDto.Actor;
import com.congsole.movie.KMDbDto.Data;

import com.congsole.movie.KMDbDto.Director;
import com.congsole.movie.domain.*;
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
    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final GenreRepository genreRepository;
    private final NationRepository nationRepository;

    public void saveAllMovies(int startCount) {
        Data dto;
        URI uri = getUri(startCount);
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
            System.out.println(e.getMessage());
        }

    }

    public long countAllMovies() {
        return movieRepository.count();
    }

    public void saveAllActorsAndDirectors(int startCount) {
        Data dto;
        URI uri = getUri(startCount);

        // api 호출
        String json = restTemplate.exchange(uri, HttpMethod.GET, null, String.class).getBody();

        try {
            // 결과값을 DTO로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            dto = objectMapper.readValue(json, Data.class);
            // DTO를 Entity로 변환
            for(int i=0; i<500; i++) {
                List<Actor> actorList = dto.getResult().get(i).getActors().getActor();
                for(Actor actorDto: actorList) {
                    actorRepository.save(com.congsole.movie.domain.Actor.from(actorDto));
                }
                List<Director> directorList = dto.getResult().get(i).getDirectors().getDirector();
                for(Director directorDto: directorList) {
                    directorRepository.save(com.congsole.movie.domain.Director.from(directorDto));
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveAllGenreAndNation(int startCount) {
        Data dto;
        URI uri = getUri(startCount);

        // api 호출
        String json = restTemplate.exchange(uri, HttpMethod.GET, null, String.class).getBody();
        try {
            // 결과값을 DTO로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            dto = objectMapper.readValue(json, Data.class);
            // DTO를 Entity로 변환
            for(int i=0; i<500; i++) {
                String genreString = dto.getResult().get(i).getGenre();
                String[] genreArr = genreString.split(",");
                for(String genre: genreArr) {
                    if(genreRepository.findByGenre(genre) == null)
                    genreRepository.save(Genre.of(genre));
                }
                String nationString = dto.getResult().get(i).getNation();
                String[] nationArr = nationString.split(",");
                for(String nation: nationArr) {
                    if(nationRepository.findByNation(nation) == null)
                    nationRepository.save(Nation.of(nation));
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public URI getUri(int startCount) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp");
        URI uri;

        uriBuilder.queryParam("collection", "kmdb_new2");
        uriBuilder.queryParam("ServiceKey", "2EI1I9663MK056Y91EKI");
        uriBuilder.queryParam("listCount", 500);
        uriBuilder.queryParam("startCount", startCount);
        uriBuilder.queryParam("detail", "Y");
        uri = uriBuilder.build().encode().toUri();
        return uri;
    }
}




