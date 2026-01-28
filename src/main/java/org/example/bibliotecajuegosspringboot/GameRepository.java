package org.example.bibliotecajuegosspringboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface GameRepository extends JpaRepository<Game, Integer> {
    
    // Obtener todas las plataformas distintas
    @Query("SELECT DISTINCT g.platform FROM Game g")
    List<String> findDistinctPlatforms();

    // Buscar juegos por plataforma
    List<Game> findByPlatform(String platform);

    @Query("select g from Game g where g.id = ?1")
    public List<Game> findGames(@Param("id") Integer id);


}