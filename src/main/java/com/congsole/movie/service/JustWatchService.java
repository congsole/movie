package com.congsole.movie.service;

import com.congsole.movie.dto.JustWatchPopular;
import jakarta.annotation.PostConstruct;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JustWatchService {
    private static final String justWatchUrl = "https://www.justwatch.com/kr";

    @PostConstruct
    public List<JustWatchPopular> getJustWatchPopular() throws IOException {
        List<JustWatchPopular> list = new ArrayList<>();
        Document document = Jsoup.connect(justWatchUrl).get();

        Elements elements = document.select("a.title-list-grid__item--link");
        for (Element element : elements) {
            JustWatchPopular justWatch = JustWatchPopular.builder()
                    .name(element.select("picture img.picture-comp__img").attr("alt"))
                    .url("https://www.justwatch.com" + element.attr("href"))
                    .imgUrl(element.select("picture img.picture-comp__img").attr("src"))
                    .build();
            list.add(justWatch);
        }
        return list;
    }
}
