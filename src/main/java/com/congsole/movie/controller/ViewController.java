package com.congsole.movie.controller;


import com.congsole.movie.dto.KMDbDto.*;
import com.congsole.movie.dto.MovieResponseDto;
import com.congsole.movie.service.ViewService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ViewController {

    private final ViewService viewService;

    @GetMapping("/")
    public String side_bar(ModelMap modelMap) {
        List<Director> directorList = viewService.findAllDirectorsSortedByDirectorNm();
        List<Actor> actorList = viewService.findAllActorsSortedByActorNm();
        modelMap.addAttribute("directorList", directorList);
        modelMap.addAttribute("actorList", actorList);
        return "search_bar";
    }

    @ResponseBody
    @GetMapping(value="/director/autocomplete", produces="text/plain;charset=UTF-8")
    public String directorNmAutocomplete(HttpServletRequest request) throws JSONException {
        String inputtedNm = request.getParameter("directorNm");
        List<Director> searchedNmList = viewService.directorNmAutocomplete(inputtedNm);
        JSONArray jsonArr = new JSONArray();
        if(searchedNmList != null) {
            for(Director directorDto : searchedNmList) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("searchedNm", directorDto.getDirectorNm());
                jsonArr.put(jsonObj);
            }
        }
        return jsonArr.toString();
    }
    @ResponseBody
    @GetMapping(value="/actor/autocomplete", produces="text/plain;charset=UTF-8")
    public String actorNmAutocomplete(HttpServletRequest request) throws JSONException {
        String inputtedNm = request.getParameter("actorNm");
        List<Actor> searchedNmList = viewService.actorNmAutocomplete(inputtedNm);
        JSONArray jsonArr = new JSONArray();
        if(searchedNmList != null) {
            for(Actor actorDto : searchedNmList) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("searchedNm", actorDto.getActorNm());
                jsonArr.put(jsonObj);
            }
        }
        return jsonArr.toString();
    }
    @ResponseBody
    @GetMapping(value="/genre/autocomplete", produces="text/plain;charset=UTF-8")
    public String genreAutocomplete(HttpServletRequest request) throws JSONException {
        String inputtedGenre = request.getParameter("genre");
        List<Genre> searchedGenreList = viewService.genreAutocomplete(inputtedGenre);
        JSONArray jsonArr = new JSONArray();
        if(searchedGenreList != null) {
            for(Genre searchedGenre : searchedGenreList) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("searchedGenre", searchedGenre.getGenre());
                jsonArr.put(jsonObj);
            }
        }
        return jsonArr.toString();
    }
    @ResponseBody
    @GetMapping(value="/nation/autocomplete", produces="text/plain;charset=UTF-8")
    public String nationAutocomplete(HttpServletRequest request) throws JSONException {
        String inputtedNation = request.getParameter("nation");
        List<Nation> searchedNationList = viewService.nationAutocomplete(inputtedNation);
        JSONArray jsonArr = new JSONArray();
        if(searchedNationList != null) {
            for(Nation searchedNation : searchedNationList) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("searchedNation", searchedNation.getNation());
                jsonArr.put(jsonObj);
            }
        }
        return jsonArr.toString();
    }
    @ResponseBody
    @GetMapping(value="/search", produces="text/plain;charset=UTF-8")
    public String search(HttpServletRequest request, @RequestParam(value="selectedDocIdList[]", required = false) String[] selectedDocIdList) throws JsonProcessingException {
        int yearInputLeft = Integer.parseInt(request.getParameter("yearInputLeft"));
        int yearInputRight = Integer.parseInt(request.getParameter("yearInputRight"));
        double rateInputLeft = Double.parseDouble(request.getParameter("rateInputLeft"));
        double rateInputRight = Double.parseDouble(request.getParameter("rateInputRight"));
        int rateNumberInputLeft = Integer.parseInt(request.getParameter("rateNumberInputLeft"));
        int rateNumberInputRight = Integer.parseInt(request.getParameter("rateNumberInputRight"));

        List<MovieResponseDto> searchedMovieList = new ArrayList<>();
        if(selectedDocIdList == null || selectedDocIdList.length == 0) {
            searchedMovieList = viewService.getSearchedList(yearInputLeft, yearInputRight, rateInputLeft, rateInputRight, rateNumberInputLeft, rateNumberInputRight);
        } else {
            searchedMovieList = viewService.getSearchedList(yearInputLeft, yearInputRight, rateInputLeft, rateInputRight, rateNumberInputLeft, rateNumberInputRight, selectedDocIdList);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(searchedMovieList); //List -> JSONString

    }
}
