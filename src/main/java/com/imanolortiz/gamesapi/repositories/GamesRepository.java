package com.imanolortiz.gamesapi.repositories;

import com.imanolortiz.gamesapi.commons.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamesRepository extends JpaRepository<Game, Long> {
}
