package org.example.bibliotecajuegosspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
class WebController {

    GameRepository gameRepository;
    public WebController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/")
    public String index(Model model)
    {
        return "index";
    }

    @GetMapping("/juegos")
    public String games(@RequestParam(required = false) String platform, Model model)
    {
        // 1. Obtener lista de plataformas para el menú
        model.addAttribute("platforms", gameRepository.findDistinctPlatforms());
        
        // 2. Filtrar juegos o mostrar todos
        if (platform != null && !platform.isEmpty()) {
            model.addAttribute("games", gameRepository.findByPlatform(platform));
            model.addAttribute("selectedPlatform", platform);
        } else {
            model.addAttribute("games", gameRepository.findAll());
            model.addAttribute("selectedPlatform", "all");
        }
        
        return "games";
    }

    @GetMapping("/{nombre}")
    public String saludar(@PathVariable String nombre, Model model)
    {
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellido", "anonimo");
        return "saludo";
    }

    @GetMapping("/juego/{id}")
    public String juego(@PathVariable Integer id, Model model)
    {
        if(gameRepository.findById(id).isPresent()) {
            // Obtener el juego
            Game game = gameRepository.findById(id).get();
            // Obtener todas las plataformas para el menú
            List<String> platforms = gameRepository.findDistinctPlatforms();

            model.addAttribute("game", gameRepository.findById(id).get());
            model.addAttribute("platforms", platforms);
            return "juego";
        } else {
            model.addAttribute("error","No existe el juego "+id);
            return "404";
        }
    }


}
