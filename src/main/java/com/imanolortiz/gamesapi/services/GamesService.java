package com.imanolortiz.gamesapi.services;

import com.imanolortiz.gamesapi.commons.dtos.GameDto;
import com.imanolortiz.gamesapi.commons.entities.Game;

import java.util.List;

public interface GamesService {

    List<Game> getAllGames();

    Game createGame(Game game);

    Game getGameById(Long id);

}
