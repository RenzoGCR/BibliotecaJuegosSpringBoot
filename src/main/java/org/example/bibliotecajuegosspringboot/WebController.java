package org.example.bibliotecajuegosspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
class WebController {

    GameRepository gameRepository;
    private final MainService mainService;

    public WebController(GameRepository gameRepository, MainService mainService) {
        this.gameRepository = gameRepository;
        this.mainService = mainService;
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



    //Buscar juego por id
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

    //Mostrar el formulario
    @GetMapping("/juego/nuevo")
    public String mostrarFormulario(Model model) {
        // Pasamos un objeto vacío para el formulario
        model.addAttribute("newGame", new NewGameDTO());
        // Reutilizamos la lista de plataformas por si quieres poner un <select>
        model.addAttribute("platforms", gameRepository.findDistinctPlatforms());
        return "nuevo-juego"; // Nombre del nuevo HTML
    }

    //Procesar el formulario (Guardar)
    @PostMapping("/juego/nuevo")
    public String guardarJuego(@ModelAttribute NewGameDTO newGameDTO) {
        mainService.saveGame(newGameDTO);
        return "redirect:/juegos"; // Redirigimos a la lista tras guardar
    }

    //Mostrar el formulario de edición
    @GetMapping("/juego/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        if(gameRepository.findById(id).isPresent()) {
            Game game = gameRepository.findById(id).get();

            // Convertimos la Entidad Game a DTO para rellenar el formulario
            NewGameDTO dto = new NewGameDTO();
            dto.setTitle(game.getTitle());
            dto.setPlatform(game.getPlatform());
            dto.setYear(game.getYear());
            dto.setDescription(game.getDescription());
            dto.setImageUrl(game.getImageUrl());

            model.addAttribute("newGame", dto);
            model.addAttribute("platforms", gameRepository.findDistinctPlatforms());

            // Pasamos el ID para saber que estamos editando
            model.addAttribute("gameId", id);

            return "nuevo-juego";
        } else {
            return "redirect:/juegos";
        }
    }

    //Procesar la edicion
    @PostMapping("/juego/editar/{id}")
    public String actualizarJuego(@PathVariable Integer id, @ModelAttribute NewGameDTO newGameDTO) {
        mainService.updateGame(id, newGameDTO);
        return "redirect:/juego/" + id; // Volvemos al detalle del juego editado
    }
}
