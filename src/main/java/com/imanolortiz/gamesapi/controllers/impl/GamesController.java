package com.imanolortiz.gamesapi.controllers.impl;

import com.imanolortiz.gamesapi.commons.dtos.GameDto;
import com.imanolortiz.gamesapi.commons.entities.Game;
import com.imanolortiz.gamesapi.controllers.GamesApi;
import com.imanolortiz.gamesapi.services.GamesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

public class GamesController implements GamesApi {

    @Autowired
    private GamesService service;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<GameDto> getAllGames() {
        return service.getAllGames().stream().map(post -> mapper.map(post, GameDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<GameDto> createGame(GameDto gameDto) {
        Game gameRequest = mapper.map(gameDto, Game.class);
        Game game = service.createGame(gameRequest);
        GameDto gameResponse = mapper.map(game, GameDto.class);
        return new ResponseEntity<>(gameResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GameDto> getGameById(@PathVariable(name = "id") Long id) {
        Game game = service.getGameById(id);
        GameDto gameResponse = mapper.map(game, GameDto.class);
        return ResponseEntity.ok().body(gameResponse);

    }
}
