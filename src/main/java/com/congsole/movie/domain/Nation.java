package com.congsole.movie.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nation;

    public Nation() {

    }
    private Nation(String nation) {
        this.nation = nation;
    }



    public static Nation of(String nation) {
        return new Nation(nation);
    }

    public static com.congsole.movie.dto.KMDbDto.Nation to(Nation nation) {
        return new com.congsole.movie.dto.KMDbDto.Nation(nation.getId(), nation.getNation());
    }
}
