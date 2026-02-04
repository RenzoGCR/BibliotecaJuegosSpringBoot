CREATE TABLE IF NOT EXISTS games (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     title VARCHAR(255) NOT NULL,
    platform VARCHAR(100),
    year INT,
    description TEXT,
    image_url VARCHAR(500)
    );

INSERT INTO games (title, platform, year, description, image_url) VALUES
                                                                      ('The Legend of Zelda: Breath of the Wild', 'Nintendo Switch', 2017, 'Una aventura épica en un mundo abierto masivo donde Link debe derrotar a Ganon.', 'https://picsum.photos/seed/1/300/200'),
                                                                      ('Elden Ring', 'PC / PS5 / Xbox Series X', 2022, 'Un RPG de acción de mundo abierto desarrollado por FromSoftware en colaboración con George R.R. Martin.', 'https://picsum.photos/seed/2/300/200'),
                                                                      ('The Last of Us Part I', 'PS5', 2022, 'Una fiel recreación de la inolvidable historia de supervivencia de Joel y Ellie.', 'https://picsum.photos/seed/3/300/200'),
                                                                      ('God of War Ragnarök', 'PS4 / PS5', 2022, 'Kratos y Atreus deben viajar a cada uno de los nueve reinos en busca de respuestas mientras se preparan para la batalla profetizada.', 'https://picsum.photos/seed/4/300/200'),
                                                                      ('Red Dead Redemption 2', 'PC / PS4 / Xbox One', 2018, 'La épica historia del forajido Arthur Morgan y la banda de Van der Linde.', 'https://picsum.photos/seed/5/300/200'),
                                                                      ('Super Mario Odyssey', 'Nintendo Switch', 2017, 'Mario se embarca en una aventura trotamundos en 3D para salvar a la princesa Peach de Bowser.', 'https://picsum.photos/seed/6/300/200'),
                                                                      ('Cyberpunk 2077', 'PC / PS5 / Xbox Series X', 2020, 'Un RPG de acción y aventura de mundo abierto ambientado en Night City.', 'https://picsum.photos/seed/7/300/200'),
                                                                      ('Minecraft', 'Multiplataforma', 2011, 'Un juego de construcción tipo "sandbox" donde los jugadores pueden crear sus propios mundos.', 'https://picsum.photos/seed/8/300/200'),
                                                                      ('Hollow Knight', 'PC / Switch / PS4', 2017, 'Un desafiante metroidvania de acción en 2D ambientado en un reino subterráneo en ruinas.', 'https://picsum.photos/seed/9/300/200'),
                                                                      ('Final Fantasy VII Rebirth', 'PS5', 2024, 'La segunda parte del proyecto de remake de Final Fantasy VII que sigue a Cloud y sus amigos fuera de Midgar.', 'https://picsum.photos/seed/10/300/200');