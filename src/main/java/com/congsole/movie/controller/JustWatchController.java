package com.congsole.movie.controller;

import com.congsole.movie.dto.JustWatchPopular;
import com.congsole.movie.service.JustWatchService;
import com.congsole.movie.service.SeleniumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class JustWatchController {

    private final JustWatchService justWatchService;
    private final SeleniumService seleniumService;
    @GetMapping("/just-watch")
    public String justWatchCrolling(Model model) throws IOException {
        List<JustWatchPopular> list = justWatchService.getJustWatchPopular();
        model.addAttribute("justWatchPopularList", list);
        return "justwatch";
    }

    @GetMapping("/selenium")
    public String seleminumCrolling(Model model) {
        List<JustWatchPopular> list = seleniumService.justWatchList();
        model.addAttribute("justWatchPopularList", list);
        return "justwatch";
    }
}
