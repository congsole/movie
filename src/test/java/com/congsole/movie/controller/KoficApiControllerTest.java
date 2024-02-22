package com.congsole.movie.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


class KoficApiControllerTest {

    @Test
    void whenTheNumberOfMoviesIs30364_returnTotalPageNumber304() {
        int totalPage = (int)Math.ceil((double)30364/100.0);
        System.out.println(totalPage);

    }
}