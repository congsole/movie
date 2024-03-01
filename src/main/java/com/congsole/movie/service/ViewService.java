package com.congsole.movie.service;

import com.congsole.movie.KMDbDto.Actor;
import com.congsole.movie.KMDbDto.Director;
import com.congsole.movie.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ViewService {

    private final ActorRepository actorRepository;
    private final DirectorRepository directorRepository;
    private final GenreRepository genreRepository;
    private final NationRepository nationRepository;

    public List<Director> findAllDirectorsSortedByDirectorNm() {
        List<com.congsole.movie.domain.Director> directorList = directorRepository.findAll(Sort.by(Sort.Direction.ASC, "directorNm"));
        return directorList.stream().map(com.congsole.movie.domain.Director::to).collect(Collectors.toList());
    }

    public List<Actor> findAllActorsSortedByActorNm() {
        List<com.congsole.movie.domain.Actor> actorList = actorRepository.findAll(Sort.by(Sort.Direction.ASC, "actorNm"));
        return actorList.stream().map(com.congsole.movie.domain.Actor::to).collect(Collectors.toList());
    }

    public List<Director> directorNmAutocomplete(String inputtedNm) {
        return directorRepository.findDistinctByDirectorNmContaining(inputtedNm).stream().map(com.congsole.movie.domain.Director::to).collect(Collectors.toList());
    }

    public List<Actor> actorNmAutocomplete(String inputtedNm) {
        return actorRepository.findDistinctByActorNmContaining(inputtedNm).stream().map(com.congsole.movie.domain.Actor::to).collect(Collectors.toList());
    }

    public List<com.congsole.movie.KMDbDto.Genre> genreAutocomplete(String inputtedGenre) {
        return genreRepository.findByGenreContaining(inputtedGenre).stream().map(Genre::to).collect(Collectors.toList());
    }
    public List<com.congsole.movie.KMDbDto.Nation> nationAutocomplete(String inputtedNation) {
        return nationRepository.findByNationContaining(inputtedNation).stream().map(Nation::to).collect(Collectors.toList());
    }
}
