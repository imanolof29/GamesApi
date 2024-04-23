package com.imanolortiz.gamesapi.services.impl;

import com.imanolortiz.gamesapi.commons.entities.Game;
import com.imanolortiz.gamesapi.repositories.GamesRepository;
import com.imanolortiz.gamesapi.services.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesServiceImpl implements GamesService {

    @Autowired
    GamesRepository repository;

    @Override
    public List<Game> getAllGames() {
        return repository.findAll();
    }

    @Override
    public Game createGame(Game game) {
        return repository.save(game);
    }

    @Override
    public Game getGameById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Game not found"));
    }

    @Override
    public void deleteGame(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateGame(Long id, Game game) {
        Game existingGame = getGameById(id);
        existingGame.setName(game.getName());
        existingGame.setPrice(game.getPrice());
        repository.save(existingGame);
    }
}
