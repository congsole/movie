package com.congsole.movie.service;

import com.congsole.movie.KMDbDto.Actor;
import com.congsole.movie.KMDbDto.Director;
import com.congsole.movie.domain.ActorRepository;
import com.congsole.movie.domain.DirectorRepository;
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
}
