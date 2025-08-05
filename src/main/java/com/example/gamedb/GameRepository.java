package com.example.gamedb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
    
    List<Game> findByTitle(String title);
    List<Game> findByTitleContainingIgnoreCase(String titlePart);
}
