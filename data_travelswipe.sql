-- Création d'un utilisateur simple
INSERT INTO users (name, email, motdepass)
VALUES ('Latif Benbaha', 'latif@test.com', '123456');

-- Ajout d'activités
INSERT INTO activites (id, name, description, image_url) VALUES
                                                 (1, 'Plage', 'Profiter du soleil et de la mer','http://localhost:8080/images/plage-nice.jpg'),
                                                 (2, 'Randonnée', 'Marcher dans la nature','http://localhost:8080/images/Randonnée-verdon.jpg'),
                                                 (3, 'Ski', 'Descente sur les pistes enneigées','http://localhost:8080/images/ski-Chamonix.jpg');

-- Ajout de destinations
INSERT INTO destinations (id, name, description, image_url) VALUES
                                                              (1, 'Nice', 'Ville de la Côte d’Azur idéale pour la plage', 'http://localhost:8080/images/nice.jpeg'),
                                                              (2, 'Chamonix', 'Station de ski dans les Alpes', 'http://localhost:8080/images/Chamonix.jpg'),
                                                              (3, 'Verdon', 'Canyon magnifique pour la randonnée', 'http://localhost:8080/images/Verdon.jpg');

-- Liaisons entre activités et destinations
INSERT INTO activite_destination (activite_id, destination_id) VALUES
                                                                   (1, 1),  -- Plage -> Nice
                                                                   (2, 3),  -- Randonnée -> Verdon
                                                                   (3, 2);  -- Ski -> Chamonix
