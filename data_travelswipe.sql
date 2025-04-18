-- Création d'un utilisateur simple
INSERT INTO users (name, email, motdepass)
VALUES ('Latif Benbaha', 'latif@test.com', '123456');

-- Ajout d'activités
INSERT INTO activites (id, name, description, image_url) VALUES
                                                 (1, 'Plage', 'Profiter du soleil et de la mer',''),
                                                 (2, 'Randonnée', 'Marcher dans la nature',''),
                                                 (3, 'Ski', 'Descente sur les pistes enneigées','');

-- Ajout de destinations
INSERT INTO destinations (id, name, description, image_url) VALUES
                                                              (1, 'Nice', 'Ville de la Côte d’Azur idéale pour la plage', 'https://example.com/nice.jpg'),
                                                              (2, 'Chamonix', 'Station de ski dans les Alpes', 'https://example.com/chamonix.jpg'),
                                                              (3, 'Verdon', 'Canyon magnifique pour la randonnée', 'https://example.com/verdon.jpg');

-- Liaisons entre activités et destinations
INSERT INTO activite_destination (activite_id, destination_id) VALUES
                                                                   (1, 1),  -- Plage -> Nice
                                                                   (2, 3),  -- Randonnée -> Verdon
                                                                   (3, 2);  -- Ski -> Chamonix
