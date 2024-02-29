package com.congsole.movie.controller;

import com.congsole.movie.KMDbDto.Actor;
import com.congsole.movie.KMDbDto.Director;
import com.congsole.movie.domain.ActorRepository;
import com.congsole.movie.domain.DirectorRepository;
import com.congsole.movie.service.ViewService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping(value="/nation/autocomplete", produces="text/plain;charset=UTF-8")
    public String nationAutocomplete(HttpServletRequest request) throws JSONException {
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
}
