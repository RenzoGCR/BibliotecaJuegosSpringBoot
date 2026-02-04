package org.example.bibliotecajuegosspringboot;
import lombok.Data;

@Data
public class NewGameDTO {
    private String title;
    private String platform;
    private Integer year;
    private String description;
    private String imageUrl;
}