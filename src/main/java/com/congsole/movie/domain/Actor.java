package com.congsole.movie.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Actor {
    @Id
    private String actorId;
    private String actorNm;
    private String actorEnNm;

    public Actor() {

    }

    public Actor(String actorId, String actorNm, String actorEnNm) {
        this.actorId = actorId;
        this.actorNm = actorNm;
        this.actorEnNm = actorEnNm;
    }

    public static Actor from(com.congsole.movie.KMDbDto.Actor actorDto) {
        return new Actor(actorDto.getActorId(), actorDto.getActorNm(), actorDto.getActorEnNm());
    }

    public static com.congsole.movie.KMDbDto.Actor to(Actor actor) {
        return new com.congsole.movie.KMDbDto.Actor(actor.getActorId(), actor.getActorNm(), actor.getActorEnNm());
    }
}
