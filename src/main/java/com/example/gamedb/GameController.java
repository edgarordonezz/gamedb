package com.example.gamedb;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/games")
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Search by title
    @GetMapping("/searchExact")
    public List<Game> searchExact(@RequestParam String title) {
        return gameRepository.findByTitle(title);
    }

    // Search partial title, case insensitive
    @GetMapping("/search")
    public List<Game> searchPartial(@RequestParam String title) {
        return gameRepository.findByTitleContainingIgnoreCase(title);
    }
}
