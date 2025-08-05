package com.example.gamedb;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Component
public class CSVLoader implements CommandLineRunner {

	private final GameRepository gameRepository;


	public CSVLoader(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		try (Reader reader = new FileReader("/Users/edgar/Desktop/hltb_game.csv");
			        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()) { // skip header

			List<Game> games = new ArrayList<>();
			String[] line;

			while ((line = csvReader.readNext()) != null) {
				Game game = new Game();
				game.setTitle(line[1]);
				game.setPlatform(line[2]);
				game.setMainStory(parseDouble(line[9]));
				game.setMainPlusSides(parseDouble(line[11]));
				game.setCompletionist(parseDouble(line[13]));
				game.setSinglePlayer(parseDouble(line[17]));
				game.setCoop(parseDouble(line[19]));

                games.add(game);

				if (games.size() == 1000) {
					gameRepository.saveAll(games);
					games.clear();
				}
			}

			if (!games.isEmpty()) {
				gameRepository.saveAll(games);
			}

			System.out.println("Games successfully imported.");
		}
	}

	private Double parseDouble(String s) {
		try {
			return Double.parseDouble(s);
		} catch (Exception e) {
			return 0.0;
		}
	}
}
