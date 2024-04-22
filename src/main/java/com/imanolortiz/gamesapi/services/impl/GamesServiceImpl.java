package com.imanolortiz.gamesapi.services.impl;

import com.imanolortiz.gamesapi.commons.entities.Game;
import com.imanolortiz.gamesapi.repositories.GamesRepository;
import com.imanolortiz.gamesapi.services.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Game> result = repository.findById(id);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new ResourceNotFoundException("Game not found with provided id "+ id);
        }
    }
}
