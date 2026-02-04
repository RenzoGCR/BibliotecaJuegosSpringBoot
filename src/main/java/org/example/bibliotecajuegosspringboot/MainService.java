package org.example.bibliotecajuegosspringboot;
import org.springframework.stereotype.Service;

@Service
public class MainService {

    private final GameRepository gameRepository;

    public MainService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void saveGame(NewGameDTO newGameDTO) {
        Game game = new Game();
        game.setTitle(newGameDTO.getTitle());
        game.setPlatform(newGameDTO.getPlatform());
        game.setYear(newGameDTO.getYear());
        game.setDescription(newGameDTO.getDescription());
        game.setImageUrl(newGameDTO.getImageUrl());

        // Guardamos en la base de datos
        gameRepository.save(game);
    }
    public void updateGame(Integer id, NewGameDTO newGameDTO) {
        // Buscamos el juego existente
        Game game = gameRepository.findById(id).orElseThrow();

        // Actualizamos sus campos
        game.setTitle(newGameDTO.getTitle());
        game.setPlatform(newGameDTO.getPlatform());
        game.setYear(newGameDTO.getYear());
        game.setDescription(newGameDTO.getDescription());
        game.setImageUrl(newGameDTO.getImageUrl());

        // Guardamos los cambios
        gameRepository.save(game);
    }
}
