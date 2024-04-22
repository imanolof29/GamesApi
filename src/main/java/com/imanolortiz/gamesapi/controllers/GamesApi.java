package com.imanolortiz.gamesapi.controllers;

import com.imanolortiz.gamesapi.commons.dtos.GameDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("")
public interface GamesApi {

    @GetMapping()
    List<GameDto> getAllGames();

    @PostMapping()
    ResponseEntity<GameDto> createGame(@RequestBody() GameDto game);

    @GetMapping("{id}")
    ResponseEntity<GameDto> getGameById(@PathVariable(name = "id") Long id);


}
