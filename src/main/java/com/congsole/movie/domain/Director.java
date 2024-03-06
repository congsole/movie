package com.congsole.movie.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Director {
    @Id
    private String directorId;
    private String directorNm;
    private String directorEnNm;

    public Director() {

    }

    public Director(String actorId, String actorNm, String actorEnNm) {
        this.directorId = actorId;
        this.directorNm = actorNm;
        this.directorEnNm = actorEnNm;
    }

    public static Director from(com.congsole.movie.dto.KMDbDto.Director directorDto) {
        return new Director(directorDto.getDirectorId(), directorDto.getDirectorNm(), directorDto.getDirectorEnNm());
    }
    public static com.congsole.movie.dto.KMDbDto.Director to(Director director) {
        return new com.congsole.movie.dto.KMDbDto.Director(director.getDirectorId(), director.getDirectorNm(), director.getDirectorEnNm());
    }
}
